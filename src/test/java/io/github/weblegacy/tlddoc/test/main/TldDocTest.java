/*
 * <license>
 * Copyright (c) 2003-2004, Sun Microsystems, Inc.
 * Copyright (c) 2022-2024, Web-Legacy
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Sun Microsystems, Inc. nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * </license>
 */

package io.github.weblegacy.tlddoc.test.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.weblegacy.tlddoc.main.TldDoc;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for the class {@link TldDoc}.
 *
 * @author Stefan Graff
 */
class TldDocTest {

    /**
     * Test TldDoc generation for JSP-Version 1.1, 1.2 and 2.0.
     *
     * @param jspVersion JSP-Version to test
     */
    @DisplayName("Test TldDoc generation for ...")
    @ParameterizedTest(name = "JSP-Version {0}.")
    @ValueSource(strings = {"1.1", "1.2", "2.0"})
    void TldDocJsp(String jspVersion) {
        final String pathVersion = jspVersion.replace(".", "");
        TldDoc.main(new String[]{"-d", "target/o" + pathVersion, "target/test-classes/jsp" + pathVersion + ".tld"});

        Path index = Paths.get("target", "o" + pathVersion, "index.html").toAbsolutePath();
        assertTrue(Files.isReadable(index), () -> "TldDoc for JSP-Version " + jspVersion + " not generated: " + index);
    }
}