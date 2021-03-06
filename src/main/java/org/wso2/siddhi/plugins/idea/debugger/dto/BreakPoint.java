/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.siddhi.plugins.idea.debugger.dto;

/**
 * DTO class for breakpoint.
 */
public class BreakPoint {

    private int queryIndex;
    private String queryTerminal;
    private String fileName;
    private int lineNumber;

    public Integer getQueryIndex() {
        return queryIndex;
    }

    public void setQueryIndex(int queryIndex) {
        this.queryIndex = queryIndex;
    }

    public String getQueryTerminal() {
        return queryTerminal;
    }

    public void setQueryTerminal(String queryTerminal) {
        this.queryTerminal = queryTerminal;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public BreakPoint(String fileName, int queryIndex, String queryTerminal) {
        this.fileName = fileName;
        this.queryIndex = queryIndex;
        this.queryTerminal = queryTerminal;
    }
}
