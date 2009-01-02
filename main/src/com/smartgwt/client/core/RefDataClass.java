/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * smartclient.com/license.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;


public class RefDataClass extends DataClass {

    public RefDataClass() {
        setAttribute(SC.REF, (Object) this);
    }

    public RefDataClass(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static RefDataClass getRef(String jsObj) {
        return null;
    }

    public static RefDataClass getRef(JavaScriptObject jsObj) {
        /*if(!GWT.isScript()) {
            if(jsObj instanceof String) {
                return null;
            }
        }*/
        if (jsObj == null) {
            return null;
        } else {
            Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
            if (ref != null && !(ref instanceof RefDataClass)) {
                //SC.debugger();
                return null;
            } else {
                return (RefDataClass) ref;
            }
        }
    }


}
