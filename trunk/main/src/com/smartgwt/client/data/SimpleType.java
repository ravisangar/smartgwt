/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.data;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An atomic type such as a string or number, that is generally stored, displayed and manipulated as a single value. <P>
 * SimpleTypes can be created at any time, and subsequently referred to as a  {@link
 * com.smartgwt.client.data.DataSourceField#getType field type} in {@link com.smartgwt.client.data.DataSource DataSources}
 * and {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}.  This allows you to define {@link
 * com.smartgwt.client.data.SimpleType#getValidators validation}, {@link
 * com.smartgwt.client.data.SimpleType#normalDisplayFormatter formatting} and {@link
 * com.smartgwt.client.data.SimpleType#getEditorType editing} behaviors for a type to be reused across all {@link
 * com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}. <P> Note that the term "simpleType" is used in the
 * same sense as in <a href='XML Schema' onclick="window.open('XML Schema');return
 * false;">http://www.w3.org/TR/xmlschema-0/</a>, and {@link com.smartgwt.client.data.XMLTools#loadXMLSchema
 * XMLTools.loadXMLSchema} will create new SimpleType definitions. <P> An <a
 * href="http://www.smartclient.com/smartgwt/showcase/#form_validation_custom_types" target="examples">example</a> is here.
 */
public class SimpleType extends BaseClass {

    public static SimpleType getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (SimpleType) obj;
        } else {
            return new SimpleType(jsObj);
        }
    }

    public SimpleType(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @param inheritsFrom inheritsFrom Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_custom_types" target="examples">Custom Types Example</a>
     */
    public void setInheritsFrom(String inheritsFrom)  throws IllegalStateException {
        setAttribute("inheritsFrom", inheritsFrom, false);
    }

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_validation_custom_types" target="examples">Custom Types Example</a>
     */
    public String getInheritsFrom()  {
        return getAttributeAsString("inheritsFrom");
    }

    /**
     * Name of the type, used to refer to the type from {@link com.smartgwt.client.data.DataSourceField#getName field.name}.
     *
     * @param name name Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Name of the type, used to refer to the type from {@link com.smartgwt.client.data.DataSourceField#getName field.name}.
     *
     *
     * @return String
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
            
    /**
     * Retrieve a simpleType definition by type name
     * @param typeName the <code>name</code> of the simpleType to return
     *
     * @return ssimple type object
     */
    public static native SimpleType getType(String typeName) /*-{
        var ret = $wnd.isc.SimpleType.getType(typeName);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.data.SimpleType::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
        
    // ***********************************************************        



    /**
     * Create a new simple type.
     *
     * @param name the name of the simple type
     * @param inheritsFrom the type it inherits from
     */
    public SimpleType(String name, FieldType inheritsFrom) {
        scClassName = "SimpleType";
        setName(name);
        setInheritsFrom(inheritsFrom);
    }

    /**
     * Create a new simple type.
     *
     * @param name the name of the simple type
     * @param inheritsFrom the type it inherits from
     */
    public SimpleType(String name, SimpleType inheritsFrom) {
        scClassName = "SimpleType";
        setName(name);
        //ensure the type being inherited from is registered
        inheritsFrom.getOrCreateJsObj();
        setAttribute("inheritsFrom", inheritsFrom.getName(), true);
    }

    /**
     * Explicitly register this SimpleType with the system so that it can be used / referenced by remote DataSources.
     */
    public void register() {
        getOrCreateJsObj();
    }

    /**
     * Validators to apply to value of this type.
     *
     * @param validators validators Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValidators(Validator... validators) throws IllegalStateException {
        setAttribute("validators", validators, false);
    }

    /**
     * List of legal values for this type, like {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap}.
     *
     * @param valueMap valueMap Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMap(String... valueMap) throws IllegalStateException {
        setAttribute("valueMap", valueMap, false);
    }

    /**
     * List of legal values for this type, like {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap}.
     *
     * @param valueMap valueMap Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMap(Map valueMap) throws IllegalStateException {
        setAttribute("valueMap", valueMap, false);
    }

    /**
     * Classname of the FormItem that should be the default for editing values of this type (eg "SelectItem"). <P> You
     * can create a simple custom FormItem by adding default {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons
     * icons} that launch custom value picking dialogs (an example is in the <i>QuickStart Guide</i>, Chapter 9,
     * <i>Extending Smart GWT</i>).  By setting simpleType.editorType to the name of your custom FormItem, forms will
     * automatically use the custom FormItem, as will grids performing {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
     * canEdit}.
     *
     * @param editorType editorType Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEditorType(FormItem editorType) throws IllegalStateException {
        setAttribute("editorType", editorType, false);
    }

    /**
     * Set of search operators valid for this type.   <P> If not specified, the {@link
     * com.smartgwt.client.data.SimpleType#getInheritsFrom inheritsFrom} type's operators will be used, finally
     * defaulting to the default operators for the basic types (eg integer).
     *
     * @param operators validOperators Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValidOperators(OperatorId... operators) throws IllegalStateException {
        setAttribute("validOperators", operators, false);
    }

    /**
     * Name of another SimpleType from which this type should inherit. <P> Validators, if any, will be combined.  All other
     * SimpleType properties default to the inherited type's value.
     *
     * @param inheritsFrom inheritsFrom Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInheritsFrom(FieldType inheritsFrom)  throws IllegalStateException {
        setAttribute("inheritsFrom", inheritsFrom.getValue(), false);
    }

    /**
     * Normal formatter for values of this type used in a {@link com.smartgwt.client.widgets.form.fields.StaticTextItem} or {@link com.smartgwt.client.widgets.viewer.DetailViewer}.
     * <p>
     * A formatter can make itself configurable on a per-component or per-field basis by checking properties on the component or field. For example, a formatter for account IDs may want
     * to omit a prefix in views where it is redundant, and could check a flag detailViewer.omitAccountIdPrefix for this purpose.
     *
     * @param formatter the formatter
     */
    public native void setNormalDisplayFormatter(SimpleTypeFormatter formatter)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.normalDisplayFormatter = $debox($entry(function(value, field, component, record) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var componentJ = (component == null || component === undefined) ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = (record == null || record === undefined) ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.data.SimpleTypeFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/core/DataClass;Lcom/smartgwt/client/widgets/DataBoundComponent;Lcom/smartgwt/client/data/Record;)(valueJ, fieldJ, componentJ, recordJ);
        }));
    }-*/;

    /**
     * Formatter for values of this type when compact display is required, for example, in a {@link com.smartgwt.client.widgets.grid.ListGrid} or
     * {@link com.smartgwt.client.widgets.tree.TreeGrid}.
     * <p>
     * A formatter can make itself configurable on a per-component or per-field basis by checking properties on the component or field.
     * For example, a formatter for account IDs may want to omit a prefix in views where it is redundant, and could check a flag listGridField.omitAccountIdPrefix for this purpose.
     *
     * @param formatter the formatter
     */
    public native void setShortDisplayFormatter(SimpleTypeFormatter formatter)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.shortDisplayFormatter = $debox($entry(function(value, field, component, record) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var fieldJ = @com.smartgwt.client.data.SimpleType::toDataClass(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            var componentJ = (component == null || component === undefined) ? null : @com.smartgwt.client.widgets.Canvas::getOrCreateDBC(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
            var recordJ = (record == null || record === undefined) ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return formatter.@com.smartgwt.client.data.SimpleTypeFormatter::format(Ljava/lang/Object;Lcom/smartgwt/client/core/DataClass;Lcom/smartgwt/client/widgets/DataBoundComponent;Lcom/smartgwt/client/data/Record;)(valueJ, fieldJ, componentJ, recordJ);
        }));
    }-*/;

    private static DataClass toDataClass(JavaScriptObject jsObj) {
        Object ref = JSOHelper.getAttributeAsObject((JavaScriptObject) jsObj, SC.REF);
        return ref == null ? new DataClass(jsObj) : (RefDataClass) ref;
    }

}


