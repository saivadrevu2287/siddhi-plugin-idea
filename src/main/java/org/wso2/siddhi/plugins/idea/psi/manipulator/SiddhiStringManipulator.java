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

package org.wso2.siddhi.plugins.idea.psi.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.wso2.siddhi.plugins.idea.psi.QuotedLiteralString;
import org.wso2.siddhi.plugins.idea.psi.impl.SiddhiPsiImplUtil;
import org.jetbrains.annotations.NotNull;

public class SiddhiStringManipulator extends AbstractElementManipulator<QuotedLiteralString> {

    @Override
    public QuotedLiteralString handleContentChange(@NotNull QuotedLiteralString literal,
                                                   @NotNull TextRange range, String newContent)
            throws IncorrectOperationException {
        String newText = range.replace(literal.getText(), newContent);
        return SiddhiPsiImplUtil.updateText(literal, newText);
    }

    @NotNull
    @Override
    public TextRange getRangeInElement(@NotNull QuotedLiteralString element) {
        if (element.getTextLength() == 0) {
            return TextRange.EMPTY_RANGE;
        }
        String s = element.getText();
        char quote = s.charAt(0);
        int startOffset = isQuote(quote) ? 1 : 0;
        int endOffset = s.length();
        if (s.length() > 1) {
            char lastChar = s.charAt(s.length() - 1);
            if (isQuote(quote) && lastChar == quote) {
                endOffset = s.length() - 1;
            }
            if (!isQuote(quote) && isQuote(lastChar)) {
                endOffset = s.length() - 1;
            }
        }
        return TextRange.create(startOffset, endOffset);
    }

    private static boolean isQuote(char ch) {
        return ch == '"' || ch == '\'' || ch == '`';
    }
}