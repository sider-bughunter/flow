/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.flow.demo.model.SourceCodeExample;
import com.vaadin.flow.demo.model.SourceCodeExample.SourceType;
import com.vaadin.flow.demo.views.DemoView;

/**
 * Utility class for obtaining {@link SourceCodeExample}s for classes.
 * 
 * @author Vaadin Ltd
 */
public class SourceContentResolver {

    // @formatter::off
    private static final ConcurrentHashMap<Class<? extends DemoView>, List<SourceCodeExample>>
        CACHED_SOURCE_EXAMPLES = new ConcurrentHashMap<>();
    // @formatter::on

    private static final Pattern SOURCE_CODE_EXAMPLE_BEGIN_PATTERN = Pattern
            .compile("\\s*// begin-source-example");
    private static final Pattern SOURCE_CODE_EXAMPLE_END_PATTERN = Pattern
            .compile("\\s*// end-source-example");
    private static final Pattern SOURCE_CODE_EXAMPLE_HEADING_PATTERN = Pattern
            .compile("\\s*// source-example-heading: (.*)");
    private static final Pattern SOURCE_CODE_EXAMPLE_TYPE_PATTERN = Pattern
            .compile("\\s*// source-example-type: ([A-Z]+)");

    private SourceContentResolver() {
    }

    /**
     * Get all {@link SourceCodeExample}s from a given class.
     * 
     * @param demoViewClass
     *            the class to retrieve source code examples for
     * @return an unmodifiable list of source code examples
     */
    public static List<SourceCodeExample> getSourceCodeExamplesForClass(
            Class<? extends DemoView> demoViewClass) {
        return CACHED_SOURCE_EXAMPLES.computeIfAbsent(demoViewClass,
                SourceContentResolver::parseSourceCodeExamplesForClass);
    }

    private static List<SourceCodeExample> parseSourceCodeExamplesForClass(
            Class<? extends DemoView> demoViewClass) {

        Path sourceFilePath = Paths.get(
                new File(demoViewClass.getProtectionDomain().getCodeSource()
                        .getLocation().getPath()).getPath(),
                demoViewClass.getPackage().getName().replaceAll("\\.", "/"),
                demoViewClass.getSimpleName() + ".java");

        try {
            return Collections.unmodifiableList(parseSourceCodeExamples(
                    Files.readAllLines(sourceFilePath)));
        } catch (IOException ioe) {
            throw new RuntimeException(String.format(
                    "IO exception when trying to read sources for class '%s' from path '%s'.",
                    demoViewClass.getName(), sourceFilePath), ioe);
        } catch (SecurityException se) {
            throw new RuntimeException(String.format(
                    "Security exception when reading source file for class '%s' from path '%s', check read permissions",
                    demoViewClass.getName(), sourceFilePath), se);
        }
    }

    private static List<SourceCodeExample> parseSourceCodeExamples(
            List<String> sourceLines) {
        List<SourceCodeExample> examples = new ArrayList<>();
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < sourceLines.size(); i++) {
            if (SOURCE_CODE_EXAMPLE_BEGIN_PATTERN.matcher(sourceLines.get(i))
                    .matches()) {
                startIndex = i;
            } else if (SOURCE_CODE_EXAMPLE_END_PATTERN
                    .matcher(sourceLines.get(i)).matches()) {
                endIndex = i;
            }
            if (startIndex != -1 && endIndex != -1
                    && startIndex + 1 < endIndex) {
                examples.add(parseSourceCodeExample(
                        sourceLines.subList(startIndex + 1, endIndex)));
                startIndex = -1;
                endIndex = -1;
            }
        }
        return examples;
    }

    private static SourceCodeExample parseSourceCodeExample(
            List<String> sourceLines) {
        String heading = parseValueFromPattern(sourceLines,
                SOURCE_CODE_EXAMPLE_HEADING_PATTERN, Function.identity(),
                () -> null);
        SourceType sourceType = parseValueFromPattern(sourceLines,
                SOURCE_CODE_EXAMPLE_TYPE_PATTERN, SourceType::valueOf,
                () -> SourceType.UNDEFINED);

        SourceCodeExample example = new SourceCodeExample();
        example.setHeading(heading);
        example.setSourceType(sourceType);
        example.setSourceCode(
                String.join("\n", trimWhitespaceAtStart(sourceLines)));
        return example;
    }

    private static <T> T parseValueFromPattern(List<String> sourceLines, Pattern pattern,
            Function<String, T> valueProvider, Supplier<T> nullValueProvider) {
        for (int i = 0; i < sourceLines.size(); i++) {
            Matcher matcher = pattern.matcher(sourceLines.get(i));
            if (matcher.matches()) {
                sourceLines.remove(i);
                return valueProvider.apply(matcher.group(1));
            }
        }
        return nullValueProvider.get();
    }

    private static List<String> trimWhitespaceAtStart(
            List<String> sourceLines) {
        int minIndent = Integer.MAX_VALUE;
        for (String line : sourceLines) {
            if (line == null || line.isEmpty()) {
                continue;
            }
            int indent = getWhitespaceCountAtStart(line);
            if (indent < minIndent) {
                minIndent = indent;
            }
        }
        List<String> trimmed = new ArrayList<>();
        for (String line : sourceLines) {
            if (line == null || line.isEmpty()) {
                trimmed.add("");
            } else {
                trimmed.add(line.substring(minIndent));
            }
        }
        return trimmed;
    }
    
    private static int getWhitespaceCountAtStart(String line) {
        int indent = 0;
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isWhitespace(line.charAt(i))) {
                return indent;
            }
            indent++;
        }
        return indent;
    }
}
