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

package org.wso2.siddhi.plugins.idea.sdk;

import com.intellij.openapi.roots.libraries.DummyLibraryProperties;
import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.wso2.siddhi.plugins.idea.SiddhiIcons;

import java.util.List;
import javax.swing.Icon;

/**
 * Provide a custom icon and description for specific libraries in Project Structure dialog.
 */
public class SiddhiSdkLibraryPresentationProvider extends LibraryPresentationProvider<DummyLibraryProperties> {

    private static final LibraryKind KIND = LibraryKind.create("Siddhi-SDK");

    public SiddhiSdkLibraryPresentationProvider() {
        super(KIND);
    }

    @Override
    @Nullable
    public Icon getIcon() {
        return SiddhiIcons.ICON;
    }

    @Override
    @Nullable
    public DummyLibraryProperties detect(@NotNull List<VirtualFile> classesRoots) {
        return null;
    }
}
