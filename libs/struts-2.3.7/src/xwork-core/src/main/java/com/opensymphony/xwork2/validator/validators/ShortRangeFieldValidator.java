/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2.validator.validators;

/**
 * <!-- START SNIPPET: javadoc -->
 * Field Validator that checks if the short specified is within a certain range.
 * <!-- END SNIPPET: javadoc -->
 * 
 * 
 * <!-- START SNIPPET: parameters -->
 * <ul>
 *      <li>fieldName - The field name this validator is validating. Required if using Plain-Validator Syntax otherwise not required</li>
 *      <li>min - the minimum value (if none is specified, it will not be checked) </li>
 *      <li>max - the maximum value (if none is specified, it will not be checked) </li>
 * </ul>
 *
 * The min / max value can be specified as an expression, but then you must also enable parsing it by specifying <strong>parse</strong> param
 * as in the example below.
 * WARNING! Do not use ${min} and ${max} as an expression as this will turn into infinitive loop!
 *
 * <!-- END SNIPPET: parameters -->
 *
 * <pre>
 * <!-- START SNIPPET: examples -->
 *  &lt;validators>
 *      &lt;!-- Plain Validator Syntax --&gt;
 *      &lt;validator type="short">
 *          &lt;param name="fieldName"&gt;age&lt;/param&gt;
 *          &lt;param name="min"&gt;20&lt;/param&gt;
 *          &lt;param name="max"&gt;50&lt;/param&gt;
 *          &lt;message&gt;Age needs to be between ${min} and ${max}&lt;/message&gt;
 *      &lt;/validator&gt;
 *
 *      &lt;!-- Field Validator Syntax --&gt;
 *      &lt;field name="age"&gt;
 *          &lt;field-validator type="short"&gt;
 *              &lt;param name="min"&gt;20&lt;/param&gt;
 *              &lt;param name="max"&gt;50&lt;/param&gt;
 *              &lt;message&gt;Age needs to be between ${min} and ${max}&lt;/message&gt;
 *          &lt;/field-validator&gt;
 *      &lt;/field&gt;
 *
 *      &lt;!-- Field Validator Syntax with expression --&gt;
 *      &lt;field name="age"&gt;
 *          &lt;field-validator type="short"&gt;
 *              &lt;param name="parse"&gt;true&lt;/param&gt;
 *              &lt;param name="${minValue}"&gt;20&lt;/param&gt; &lt;!-- will be evaluated as: Short getMinValue() --&gt;
 *              &lt;param name="${maxValue}"&gt;50&lt;/param&gt; &lt;!-- will be evaluated as: Short getMaxValue() --&gt;
 *              &lt;message&gt;Age needs to be between ${min} and ${max}&lt;/message&gt;
 *          &lt;/field-validator&gt;
 *      &lt;/field&gt;
 *  &lt;/validators&gt;
 * <!-- END SNIPPET: examples -->
 * </pre>
 * 
 * 
 * 
 * @version $Date: 2012-10-17 21:09:07 +0200 (Wed, 17 Oct 2012) $
 */
public class ShortRangeFieldValidator extends AbstractRangeValidator<Short> {

    String max = null;
    String min = null;

    public void setMax(String max) {
        this.max = max;
    }

    public String getMax() {
        return safeConditionalParse(max);
    }

    @Override
    public Short getMaxComparatorValue() {
        return parseShort(getMax());
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMin() {
        return safeConditionalParse(min);
    }

    @Override
    public Short getMinComparatorValue() {
        return parseShort(getMin());
    }

    private Short parseShort(String value) {
        if (value != null) {
            return Short.parseShort(value);
        } else {
            return null;
        }
    }

}
