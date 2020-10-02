/*
 * Copyright 2000-2020 Vaadin Ltd.
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
package com.vaadin.flow.server.frontend.scanner;

import java.io.Serializable;
import java.util.Objects;

/**
 * A container for Theme information when scanning the class path. It overrides
 * equals and hashCode in order to use HashSet to eliminate duplicates.
 *
 * @since 2.0
 */
final class ThemeData implements Serializable {
    String themeBaseClass;
    String variant = "";
    String themeName;
    boolean notheme;

    ThemeData(String themeBaseClass, String variant, String themeName) {
        this.themeBaseClass = themeBaseClass;
        this.variant = variant;
        this.themeName = themeName;
    }

    ThemeData() {
    }

    String getThemeBaseClass() {
        return themeBaseClass;
    }

    String getVariant() {
        return variant;
    }

    public String getThemeName() {
        return themeName;
    }

    boolean isNotheme() {
        return notheme;
    }

    static ThemeData createNoTheme() {
        ThemeData data = new ThemeData();
        data.notheme = true;
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ThemeData)) {
            return false;
        }
        ThemeData that = (ThemeData) other;
        return notheme == that.notheme && Objects.equals(themeBaseClass, that.themeBaseClass);
    }

    @Override
    public int hashCode() {
        // We might need to add variant when we wanted to fail in the
        // case of same theme class with different variant, which was
        // right in v13
        return Objects.hash(themeBaseClass, notheme);
    }

    @Override
    public String toString() {
        return " notheme: " + notheme + "\n themeBaseClass:" + themeBaseClass + "\n variant: "
                + variant;
    }
}
