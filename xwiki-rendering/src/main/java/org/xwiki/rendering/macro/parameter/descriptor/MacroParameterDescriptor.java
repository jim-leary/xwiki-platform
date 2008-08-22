/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.macro.parameter.descriptor;

import org.xwiki.rendering.macro.parameter.instance.MacroParameter;

/**
 * Describe a Macro parameter (parameter name, description, default value, whather it's a mandator parameter or not,
 * whether there's validation done on user's provided values for this parameter). 
 * 
 * @param <T> the type of the value after conversion.
 * @version $Id$
 */
public interface MacroParameterDescriptor<T>
{
    /**
     * @return the name of the parameter.
     */
    String getName();

    /**
     * @return the description of the parameter.
     */
    String getDescription();

    /**
     * @return the default value.
     */
    T getDefaultValue();

    /**
     * @return indicate the parameter has to be specified.
     */
    boolean isRequired();

    /**
     * @return indicate if the macro parameter object has to throw exception when value is invalid.
     */
    boolean isValueHasToBeValid();

    /**
     * Create a new instance of the corresponding parameter object.
     * 
     * @param value the value to convert.
     * @return the parameter.
     */
    MacroParameter<T> newInstance(String value);

    /**
     * Create a new instance of the corresponding parameter object.
     *
     * @param value the value.
     * @return the parameter.
     */
    MacroParameter<T> newInstance(T value);
}
