/*
 * $Id: VelocityPageFilter.java 835251 2009-11-12 06:11:13Z musachy $
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
package org.apache.struts2.sitemesh;

import com.opensymphony.sitemesh.webapp.SiteMeshWebAppContext;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import com.opensymphony.sitemesh.DecoratorSelector;
import com.opensymphony.module.sitemesh.Factory;
import com.opensymphony.module.sitemesh.Config;
import com.opensymphony.xwork2.inject.Inject;

import javax.servlet.*;

import org.apache.struts2.views.velocity.VelocityManager;

/**
 * Core Filter for integrating SiteMesh into a Java web application.
 */
public class VelocityPageFilter extends SiteMeshFilter {

    @Inject(required=false)
    public static void setVelocityManager(VelocityManager mgr) {
        OldDecorator2NewStrutsVelocityDecorator.setVelocityManager(mgr);
    }

    private FilterConfig filterConfig;

     public void init(FilterConfig filterConfig) {
         this.filterConfig = filterConfig;
        super.init(filterConfig);
     }

    protected DecoratorSelector initDecoratorSelector(SiteMeshWebAppContext webAppContext) {
        // TODO: Remove heavy coupling on horrible SM2 Factory
        Factory factory = Factory.getInstance(new Config(filterConfig));
        factory.refresh();
        return new FreemarkerMapper2DecoratorSelector(factory.getDecoratorMapper());
    }

}

