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
package com.vaadin.flow.server.frontend.installer;

import java.io.File;

/**
 * Handle extracting file archives.
 * <p>
 * Derived from eirslett/frontend-maven-plugin
 * <p>
 * For internal use only. May be renamed or removed in a future release.
 *
 * @since
 */
interface ArchiveExtractor {

    /**
     * Extract archive contents to given destination.
     *
     * @param archive
     *         archive file to extract
     * @param destinationDirectory
     *         destination directory to extract files to
     * @throws ArchiveExtractionException
     *         exception thrown for failure during extraction
     */
    void extract(File archive, File destinationDirectory)
            throws ArchiveExtractionException;
}


