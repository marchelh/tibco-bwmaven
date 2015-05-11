/**
 * (C) Copyright 2011-2015 FastConnect SAS
 * (http://www.fastconnect.fr/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.fastconnect.tibco.businessworks.fcunit.processes;

import java.io.Serializable;
import java.util.HashSet;

public class TestProcessFactory implements AbstractProcessFactory, Serializable {

	private static final long serialVersionUID = 4809068280351869676L;

	public AbstractProcess createProcess(String path) {
		return new TestProcess(path);
	}

	public AbstractProcess[] createProcessArray(int length,	HashSet<String> paths) {
		return new TestProcess[length-1];
	}

}