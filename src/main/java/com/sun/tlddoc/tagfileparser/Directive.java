/*
 * <license>
 * Copyright (c) 2003-2004, Sun Microsystems, Inc.
 * Copyright (c) 2022-2022, Web-Legacy
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

package com.sun.tlddoc.tagfileparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encapsulates a directive in a tag file.
 *
 * @author  mroth
 */
public class Directive {

    /**
     * The name of this directive.
     */
    private String directiveName;

    /**
     * The attributes for this directive.
     */
    final private ArrayList<Attribute> attributes = new ArrayList<>();

    /**
     * Creates a new instance of Directive
     */
    public Directive() {
    }

    /**
     * Getter for property directiveName.
     * @return Value of property directiveName.
     */
    public String getDirectiveName() {
        return directiveName;
    }

    /**
     * Setter for property directiveName.
     * @param directiveName New value of property directiveName.
     */
    public void setDirectiveName(String directiveName) {
        this.directiveName = directiveName;
    }

    /**
     * Adds an attribute to the list of attributes for this directive.
     *
     * @param attribute to add to the list of attributes for this directive
     */
    public void addAttribute( Attribute attribute ) {
        this.attributes.add( attribute );
    }

    /**
     * Returns the unmodifiable list of attributes in this directive.
     *
     * @return the list of attributes in this directive
     */
    
    public List<Attribute> getAttributes() {
        return Collections.unmodifiableList( attributes );
    }

    /**
     * Returns a string representation of this directive
     *
     * @return a string representation of this directive
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append( "[Directive;name=" );
        result.append( directiveName );
        result.append( ", attributes=" );
        result.append( attributes );
        result.append( ']' );
        return result.toString();
    }
}