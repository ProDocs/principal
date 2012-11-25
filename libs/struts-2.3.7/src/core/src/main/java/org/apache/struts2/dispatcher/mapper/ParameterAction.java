/*
 * $Id: ParameterAction.java 651946 2008-04-27 13:41:38Z apetrelli $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.struts2.dispatcher.mapper;

/**
 * Defines a parameter action prefix.  This is executed when the configured prefix key is matched in a parameter
 * name, allowing the implementation to manipulate the action mapping accordingly.  For example, if the "action:foo"
 * parameter name was found, and a ParameterAction implementation was registered to handle the "action" prefix, the
 * execute method would be called, allowing the implementation to set the "method" value on the ActionMapping.
 * 
 * @since 2.1.0
 */
public interface ParameterAction {
    void execute(String key, ActionMapping mapping);
}
