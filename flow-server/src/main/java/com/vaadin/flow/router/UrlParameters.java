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
package com.vaadin.flow.router;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Container which stores the url parameters extracted from a navigation url
 * received from the client.
 */
public class UrlParameters {

    private Map<String, Serializable> params;

    /**
     * Creates a url parameters container using the given map as argument.
     * 
     * @param params
     *            parameters mapping.
     */
    public UrlParameters(Map<String, Serializable> params) {
        this.params = params != null ? params : Collections.emptyMap();
    }

    public String get(String parameterName) {
        return params.get(parameterName).toString();
    }

    public Integer getInt(String parameterName) {
        return new Integer(get(parameterName));
    }

    public Long getLong(String parameterName) {
        return new Long(get(parameterName));
    }

    public Boolean getBool(String parameterName) {
        return new Boolean(get(parameterName));
    }

    public List<String> getList(String parameterName) {
        return (List<String>) params.get(parameterName);
    }

    public Object getObject(String parameterName) {
        return params.get(parameterName);
    }

}
