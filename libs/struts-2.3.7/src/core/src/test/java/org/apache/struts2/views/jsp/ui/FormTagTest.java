/*
 * $Id: FormTagTest.java 1326928 2012-04-17 05:03:45Z lukaszlenart $
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

package org.apache.struts2.views.jsp.ui;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ObjectFactory;
import com.opensymphony.xwork2.config.RuntimeConfiguration;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.config.impl.DefaultConfiguration;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Scope.Strategy;
import com.opensymphony.xwork2.validator.ValidationInterceptor;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.TestAction;
import org.apache.struts2.TestConfigurationProvider;
import org.apache.struts2.components.Form;
import org.apache.struts2.views.jsp.AbstractUITagTest;
import org.apache.struts2.views.jsp.ActionTag;
import org.easymock.EasyMock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * FormTagTest
 */
public class FormTagTest extends AbstractUITagTest {

    public void testFormWithActionAttributeContainingBothActionAndMethod() throws Exception {
        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAcceptcharset("UTF-8");
        tag.setAction("testAction");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-9.txt"));
    }

    public void testFormWithoutContext() throws Exception {
        request.setupGetContext("somecontext");

        FormTag tag = new FormTag();
        tag.setTheme("xhtml");
        tag.setPageContext(pageContext);
        tag.setAction("testAction");
        tag.setIncludeContext(false);
        tag.doStartTag();
        tag.doEndTag();


        verify(FormTag.class.getResource("Formtag-14.txt"));
    }

    public void testFormWithContext() throws Exception {
        request.setupGetContext("/somecontext");

        FormTag tag = new FormTag();
        tag.setTheme("xhtml");
        tag.setPageContext(pageContext);
        tag.setAction("testAction");
        tag.doStartTag();
        tag.doEndTag();


        verify(FormTag.class.getResource("Formtag-13.txt"));
    }
    
    public void testFormWithActionAttributeContainingBothActionAndDMIMethod() throws Exception {
        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAcceptcharset("UTF-8");
        tag.setAction("testAction!testMethod");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-23.txt"));
    }    

    public void testFormWithFocusElement() throws Exception {
        FormTag tag = new FormTag();
        tag.setTheme("xhtml");
        tag.setPageContext(pageContext);
        tag.setAction("testAction");
        tag.setFocusElement("felement");
        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-12.txt"));
    }

    public void testFormWithActionAttributeContainingBothActionAndMethodAndNamespace() throws Exception {
        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setNamespace("/testNamespace");
        tag.setMethod("post");
        tag.setAcceptcharset("UTF-8");
        tag.setAction("testNamespaceAction");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-10.txt"));
    }


    public void testForm() throws Exception {

        request.setupGetServletPath("/testAction");

        TestAction testAction = (TestAction) action;
        testAction.setFoo("bar");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAcceptcharset("UTF-8");
        tag.setAction("myAction");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.setId("myid");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-1.txt"));
    }

     public void testFormNoNameOrId() throws Exception {

        request.setupGetServletPath("/testAction");

        TestAction testAction = (TestAction) action;
        testAction.setFoo("bar");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setMethod("post");
        tag.setAcceptcharset("UTF-8");
        tag.setAction("myAction");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-25.txt"));
    }

    /**
     * This test with form tag validation enabled. Js validation script will appear
     * cause action submited by the form is intercepted by validation interceptor which
     * "include" all methods.
     */
    public void testFormWithCustomOnsubmitEnabledWithValidateEnabled1() throws Exception {

        final Container cont = container;
        // used to determined if the form action needs js validation
        configurationManager.setConfiguration(new com.opensymphony.xwork2.config.impl.DefaultConfiguration() {
            private DefaultConfiguration self = this;
            public Container getContainer() {
                return new Container() {
                    public <T> T inject(Class<T> implementation) {return null;}
                    public void removeScopeStrategy() {}
                    public void setScopeStrategy(Strategy scopeStrategy) {}
                    public <T> T getInstance(Class<T> type, String name) {return null;}
                    public <T> T getInstance(Class<T> type) {return cont.getInstance(type);}
                    public Set<String> getInstanceNames(Class<?> type) {return null;}

                    public void inject(Object o) {
                        cont.inject(o);
                        if (o instanceof Form) {
                            ((Form)o).setConfiguration(self);
                        }
                    }
                };
            }
            public RuntimeConfiguration getRuntimeConfiguration() {
                return new RuntimeConfiguration() {
                    public ActionConfig getActionConfig(String namespace, String name) {
                        ActionConfig actionConfig = new ActionConfig("", name, "") {
                            public List getInterceptors() {
                                List interceptors = new ArrayList();

                                ValidationInterceptor validationInterceptor = new ValidationInterceptor();
                                validationInterceptor.setIncludeMethods("*");

                                InterceptorMapping interceptorMapping = new InterceptorMapping("validation", validationInterceptor);
                                interceptors.add(interceptorMapping);

                                return interceptors;
                            }
                            public String getClassName() {
                                return ActionSupport.class.getName();
                            }
                        };
                        return actionConfig;
                    }

                    public Map getActionConfigs() {
                        return null;
                    }
                };
            }
        });

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAction("myAction");
        tag.setAcceptcharset("UTF-8");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.setValidate("true");
        tag.setNamespace("");

        UpDownSelectTag t = new UpDownSelectTag();
        t.setPageContext(pageContext);
        t.setName("myUpDownSelectTag");
        t.setList("{}");

        tag.doStartTag();
        t.doStartTag();
        t.doEndTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-2.txt"));
    }


    /**
     * This test with form tag validation enabled. Js validation script will not appear
     * cause action submited by the form is intercepted by validation interceptor which
     * "excludes" all methods.
     */
    public void testFormWithCustomOnsubmitEnabledWithValidateEnabled2() throws Exception {

        com.opensymphony.xwork2.config.Configuration originalConfiguration = configurationManager.getConfiguration();
        ObjectFactory originalObjectFactory = ObjectFactory.getObjectFactory();

        final Container cont = container;
        try {
            // used to determined if the form action needs js validation
            configurationManager.setConfiguration(new DefaultConfiguration() {
                private DefaultConfiguration self = this;
                public Container getContainer() {
                    return new Container() {
                        public <T> T inject(Class<T> implementation) {return null;}
                        public void removeScopeStrategy() {}
                        public void setScopeStrategy(Strategy scopeStrategy) {}
                        public <T> T getInstance(Class<T> type, String name) {return null;}
                        public <T> T getInstance(Class<T> type) {return cont.getInstance(type);}
                        public Set<String> getInstanceNames(Class<?> type) {return null;}

                        public void inject(Object o) {
                            cont.inject(o);
                            if (o instanceof Form) {
                                ((Form)o).setConfiguration(self);
                            }
                        }
                    };
                }
                public RuntimeConfiguration getRuntimeConfiguration() {
                    return new RuntimeConfiguration() {
                        public ActionConfig getActionConfig(String namespace, String name) {
                            ActionConfig actionConfig = new ActionConfig("", name, "") {
                                public List getInterceptors() {
                                    List interceptors = new ArrayList();

                                    ValidationInterceptor validationInterceptor = new ValidationInterceptor();
                                    validationInterceptor.setExcludeMethods("*");

                                    InterceptorMapping interceptorMapping = new InterceptorMapping("validation", validationInterceptor);
                                    interceptors.add(interceptorMapping);

                                    return interceptors;
                                }
                                public String getClassName() {
                                    return ActionSupport.class.getName();
                                }
                            };
                            return actionConfig;
                        }

                        public Map getActionConfigs() {
                            return null;
                        }
                    };
                }
            });

            FormTag tag = new FormTag();
            tag.setPageContext(pageContext);
            tag.setName("myForm");
            tag.setMethod("post");
            tag.setAction("myAction");
            tag.setAcceptcharset("UTF-8");
            tag.setEnctype("myEncType");
            tag.setTitle("mytitle");
            tag.setOnsubmit("submitMe()");
            tag.setValidate("true");
            tag.setNamespace("");

            UpDownSelectTag t = new UpDownSelectTag();
            t.setPageContext(pageContext);
            t.setName("myUpDownSelectTag");
            t.setList("{}");

            tag.doStartTag();
            t.doStartTag();
            t.doEndTag();
            tag.doEndTag();

            verify(FormTag.class.getResource("Formtag-11.txt"));
        }
        finally {
            configurationManager.setConfiguration(originalConfiguration);
        }
    }

    /**
     * Tests the numbers are formatted correctly to not break the javascript
     */
    public void testFormWithCustomOnsubmitEnabledWithValidateEnabled3() throws Exception {

        final Container cont = container;
        // used to determined if the form action needs js validation
        configurationManager.setConfiguration(new com.opensymphony.xwork2.config.impl.DefaultConfiguration() {
            private DefaultConfiguration self = this;
            public Container getContainer() {
                return new Container() {
                    public <T> T inject(Class<T> implementation) {return null;}
                    public void removeScopeStrategy() {}
                    public void setScopeStrategy(Strategy scopeStrategy) {}
                    public <T> T getInstance(Class<T> type, String name) {return null;}
                    public <T> T getInstance(Class<T> type) {return cont.getInstance(type);}
                    public Set<String> getInstanceNames(Class<?> type) {return null;}

                    public void inject(Object o) {
                        cont.inject(o);
                        if (o instanceof Form) {
                            ((Form)o).setConfiguration(self);
                        }
                    }
                };
            }
            public RuntimeConfiguration getRuntimeConfiguration() {
                return new RuntimeConfiguration() {
                    public ActionConfig getActionConfig(String namespace, String name) {
                        ActionConfig actionConfig = new ActionConfig("", name, IntValidationAction.class.getName()) {
                            public List getInterceptors() {
                                List interceptors = new ArrayList();

                                ValidationInterceptor validationInterceptor = new ValidationInterceptor();
                                validationInterceptor.setIncludeMethods("*");

                                InterceptorMapping interceptorMapping = new InterceptorMapping("validation", validationInterceptor);
                                interceptors.add(interceptorMapping);

                                return interceptors;
                            }
                            public String getClassName() {
                                return IntValidationAction.class.getName();
                            }
                        };
                        return actionConfig;
                    }

                    public Map getActionConfigs() {
                        return null;
                    }
                };
            }
        });

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAction("myAction");
        tag.setAcceptcharset("UTF-8");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.setValidate("true");
        tag.setNamespace("");

        UpDownSelectTag t = new UpDownSelectTag();
        t.setPageContext(pageContext);
        t.setName("myUpDownSelectTag");
        t.setList("{}");

        tag.doStartTag();
        tag.getComponent().getParameters().put("actionClass", IntValidationAction.class);
        t.doStartTag();
        t.doEndTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-22.txt"));
    }

/**
     * Tests the numbers are formatted correctly to not break the javascript, using doubles
     */
    public void testFormWithCustomOnsubmitEnabledWithValidateEnabled4() throws Exception {

        final Container cont = container;
        // used to determined if the form action needs js validation
        configurationManager.setConfiguration(new com.opensymphony.xwork2.config.impl.DefaultConfiguration() {
            private DefaultConfiguration self = this;
            public Container getContainer() {
                return new Container() {
                    public <T> T inject(Class<T> implementation) {return null;}
                    public void removeScopeStrategy() {}
                    public void setScopeStrategy(Strategy scopeStrategy) {}
                    public <T> T getInstance(Class<T> type, String name) {return null;}
                    public <T> T getInstance(Class<T> type) {return cont.getInstance(type);}
                    public Set<String> getInstanceNames(Class<?> type) {return null;}

                    public void inject(Object o) {
                        cont.inject(o);
                        if (o instanceof Form) {
                            ((Form)o).setConfiguration(self);
                        }
                    }
                };
            }
            public RuntimeConfiguration getRuntimeConfiguration() {
                return new RuntimeConfiguration() {
                    public ActionConfig getActionConfig(String namespace, String name) {
                        ActionConfig actionConfig = new ActionConfig("", name, DoubleValidationAction.class.getName()) {
                            public List getInterceptors() {
                                List interceptors = new ArrayList();

                                ValidationInterceptor validationInterceptor = new ValidationInterceptor();
                                validationInterceptor.setIncludeMethods("*");

                                InterceptorMapping interceptorMapping = new InterceptorMapping("validation", validationInterceptor);
                                interceptors.add(interceptorMapping);

                                return interceptors;
                            }
                            public String getClassName() {
                                return DoubleValidationAction.class.getName();
                            }
                        };
                        return actionConfig;
                    }

                    public Map getActionConfigs() {
                        return null;
                    }
                };
            }
        });

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAction("myAction");
        tag.setAcceptcharset("UTF-8");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.setValidate("true");
        tag.setNamespace("");

        UpDownSelectTag t = new UpDownSelectTag();
        t.setPageContext(pageContext);
        t.setName("myUpDownSelectTag");
        t.setList("{}");

        tag.doStartTag();
        tag.getComponent().getParameters().put("actionClass", DoubleValidationAction.class);
        t.doStartTag();
        t.doEndTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-24.txt"));
    }


    /**
     * This test with form tag validation disabled.
     */
    public void testFormWithCustomOnsubmitEnabledWithValidateDisabled() throws Exception {
        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAction("myAction");
        tag.setEnctype("myEncType");
        tag.setTitle("mytitle");
        tag.setOnsubmit("submitMe()");
        tag.setValidate("false");

        UpDownSelectTag t = new UpDownSelectTag();
        t.setPageContext(pageContext);
        t.setName("myUpDownSelectTag");
        t.setList("{}");

        tag.doStartTag();
        t.doStartTag();
        t.doEndTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-6.txt"));
    }


    /**
     * Testing that this: <p>
     * &lt;a:form name=&quot;'myForm'&quot; namespace=&quot;'/testNamespace'&quot; action=&quot;'testNamespaceAction'&quot; method=&quot;'post'&quot;&gt;
     * <p/>
     * doesn't create an action of &quot;/testNamespace/testNamespaceAction.action&quot; when the &quot;struts.action.extension&quot;
     * config property is set to &quot;jspa&quot;.
     */
    public void testFormTagWithDifferentActionExtension() throws Exception {
        initDispatcher(new HashMap<String,String>(){{ 
            put(StrutsConstants.STRUTS_ACTION_EXTENSION, "jspa");
            put("configProviders", TestConfigurationProvider.class.getName());
        }});
        request.setupGetServletPath("/testNamespace/testNamespaceAction");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setNamespace("/testNamespace");
        tag.setAction("testNamespaceAction");
        tag.setMethod("post");
        tag.setName("myForm");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-5.txt"));
    }

    /**
     * Testing that this: <p>
     * &lt;a:form name=&quot;'myForm'&quot; action=&quot;'/testNamespace/testNamespaceAction.jspa'&quot; method=&quot;'post'&quot;&gt;
     * <p/>
     * doesn't create an action of &quot;/testNamespace/testNamespaceAction.action&quot;
     */
    public void testFormTagWithDifferentActionExtensionHardcoded() throws Exception {
        request.setupGetServletPath("/testNamespace/testNamespaceAction");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setAction("/testNamespace/testNamespaceAction.jspa");
        tag.setMethod("post");
        tag.setName("myForm");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-5.txt"));
    }

    public void testFormWithNamespaceDefaulting() throws Exception {
        request.setupGetServletPath("/testNamespace/testNamespaceAction");

        TestAction testAction = (TestAction) action;
        testAction.setFoo("bar");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setName("myForm");
        tag.setMethod("post");
        tag.setAction("testNamespaceAction");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-3.txt"));
    }

    public void testFormTagForStackOverflowException1() throws Exception {
        request.setRequestURI("/requestUri");

        FormTag form1 = new FormTag();
        form1.setPageContext(pageContext);
        form1.doStartTag();

        assertEquals(form1.getComponent().getComponentStack().size(), 1);

        ActionTag tag = new ActionTag();
        tag.setPageContext(pageContext);
        tag.setName("testAction");
        tag.doStartTag();

        assertEquals(tag.getComponent().getComponentStack().size(), 2);

        tag.doEndTag();

        assertEquals(form1.getComponent().getComponentStack().size(), 1);

        form1.doEndTag();

        assertNull(form1.getComponent()); // component is removed after end tag
    }

    public void testFormTagForStackOverflowException2() throws Exception {
        request.setRequestURI("/requestUri");

        FormTag form1 = new FormTag();
        form1.setPageContext(pageContext);
        form1.doStartTag();

        assertEquals(form1.getComponent().getComponentStack().size(), 1);

        FormTag form2 = new FormTag();
        form2.setPageContext(pageContext);
        form2.doStartTag();

        assertEquals(form2.getComponent().getComponentStack().size(), 2);

        ActionTag tag = new ActionTag();
        tag.setPageContext(pageContext);
        tag.setName("testAction");
        tag.doStartTag();

        assertEquals(tag.getComponent().getComponentStack().size(), 3);

        tag.doEndTag();

        assertEquals(form2.getComponent().getComponentStack().size(), 2);

        form2.doEndTag();

        assertEquals(form1.getComponent().getComponentStack().size(), 1);

        form1.doEndTag();

        assertNull(form1.getComponent()); // component is removed after end tag
    }


    public void testFormTagForStackOverflowException3() throws Exception {
        request.setRequestURI("/requestUri");

        FormTag form1 = new FormTag();
        form1.setPageContext(pageContext);
        form1.doStartTag();

        assertEquals(form1.getComponent().getComponentStack().size(), 1);

        FormTag form2 = new FormTag();
        form2.setPageContext(pageContext);
        form2.doStartTag();

        assertEquals(form2.getComponent().getComponentStack().size(), 2);

        FormTag form3 = new FormTag();
        form3.setPageContext(pageContext);
        form3.doStartTag();

        assertEquals(form3.getComponent().getComponentStack().size(), 3);

        ActionTag tag = new ActionTag();
        tag.setPageContext(pageContext);
        tag.setName("testAction");
        tag.doStartTag();

        assertEquals(tag.getComponent().getComponentStack().size(), 4);

        tag.doEndTag();

        assertEquals(form3.getComponent().getComponentStack().size(), 3);

        form3.doEndTag();

        assertEquals(form2.getComponent().getComponentStack().size(), 2);

        form2.doEndTag();

        assertEquals(form1.getComponent().getComponentStack().size(), 1);

        form1.doEndTag();

        assertNull(form1.getComponent()); // component is removed after end tag
    }


    public void testFormComponentIsRemoved() throws Exception {
        request.setRequestURI("/requestUri");

        FormTag form = new FormTag();
        form.setPageContext(pageContext);
        form.doStartTag();

        assertEquals(form.getComponent().getComponentStack().size(), 1);

        form.doEndTag();

        assertNull(form.getComponent());
    }


    public void testFormWithNoAction() throws Exception {
        request.setupGetServletPath("/");
        request.setupGetContextPath("/");
        request.setRequestURI("/foo.jsp");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-4.txt"));
    }

    public void testFormWithStaticAction() throws Exception {
        request.setupGetServletPath("/");
        request.setupGetContextPath("/");
        request.setRequestURI("/foo.jsp");

        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setAction("test.html");
        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-7.txt"));
    }

    public void testFormWithActionAndExtension() throws Exception {
        request.setupGetServletPath("/BLA");
        
        FormTag tag = new FormTag();
        tag.setPageContext(pageContext);
        tag.setAction("/testNamespace/testNamespaceAction.jspa");
        tag.setMethod("post");
        tag.setName("myForm");

        tag.doStartTag();
        tag.doEndTag();

        verify(FormTag.class.getResource("Formtag-8.txt"));

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        initDispatcher(new HashMap<String,String>(){{ 
            put("configProviders", TestConfigurationProvider.class.getName());
        }});
        ActionContext.getContext().setValueStack(stack);

        ActionConfig config = new ActionConfig.Builder("", "name", "").build();
        ActionInvocation invocation = EasyMock.createNiceMock(ActionInvocation.class);
        ActionProxy proxy = EasyMock.createNiceMock(ActionProxy.class);

        EasyMock.expect(invocation.getProxy()).andReturn(proxy).anyTimes();
        EasyMock.expect(invocation.getAction()).andReturn(null).anyTimes();
        EasyMock.expect(invocation.invoke()).andReturn(Action.SUCCESS).anyTimes();
        EasyMock.expect(proxy.getMethod()).andReturn("execute").anyTimes();
        EasyMock.expect(proxy.getConfig()).andReturn(config).anyTimes();


        EasyMock.replay(invocation);
        EasyMock.replay(proxy);

        ActionContext.getContext().setActionInvocation(invocation);
    }
}
