/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form.fields;



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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Item for manipulating Dates. <p> Can be rendered as a text field, or as 3 selects for day, month, year.  Includes optional pop-up picker.

    */
public class DateItem extends FormItem {

    public static DateItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (DateItem) obj;
        } else {
            return new DateItem(jsObj);
        }
    }


    public DateItem(){
        setType("date");
    }

    public DateItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Should we show the date in a text field, or as 3 select boxes?
    *
    * @param useTextField useTextField Default value is false
    */
    public void setUseTextField(Boolean useTextField) {
        setAttribute("useTextField", useTextField);
    }
    /**
     * Should we show the date in a text field, or as 3 select boxes?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseTextField()  {
        return getAttributeAsBoolean("useTextField");
    }
             
    /**
    * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property governs the alignment of text within the text field.
    *
    * @param textAlign textAlign Default value is Canvas.RIGHT
    */
    public void setTextAlign(Alignment textAlign) {
        setAttribute("textAlign", textAlign.getValue());
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property governs the alignment of text within the text field.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getTextAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("textAlign"));
    }

    /**
    * Can this field be set to a non-date value [other than null]? <P> When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue} will return false without setting the item value and log a warning if passed something other than a valid date value. If a user enters a text value which cannot be parsed into a valid date, the item will automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage invalidDateStringMessage} (though at this point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue} will return the string entered by the user). <P> When set to false, a user may enter value that is not a valid date (for example, "Not applicable") and the value will not immediately be flagged as an error.  However note that for the value to actually pass validation you would need to declare the field as not of "date" type, for example: <pre>     {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true }, </pre> The type "dateOrOther" could be declared as a {@link com.smartgwt.client.data.SimpleType}, with validators that will accept either a valid date or certain special Strings (like "Not Available"). <P> Only applies to dateItems where {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true. Non-Date values are never supported in items where useTextField is false.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param enforceDate enforceDate Default value is false
    */
    public void setEnforceDate(Boolean enforceDate) {
        setAttribute("enforceDate", enforceDate);
    }
    /**
     * Can this field be set to a non-date value [other than null]? <P> When set to true, {@link com.smartgwt.client.widgets.form.fields.FormItem#setValue} will return false without setting the item value and log a warning if passed something other than a valid date value. If a user enters a text value which cannot be parsed into a valid date, the item will automatically redraw and display the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInvalidDateStringMessage invalidDateStringMessage} (though at this point calling {@link com.smartgwt.client.widgets.form.fields.FormItem#getValue} will return the string entered by the user). <P> When set to false, a user may enter value that is not a valid date (for example, "Not applicable") and the value will not immediately be flagged as an error.  However note that for the value to actually pass validation you would need to declare the field as not of "date" type, for example: <pre>     {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true }, </pre> The type "dateOrOther" could be declared as a {@link com.smartgwt.client.data.SimpleType}, with validators that will accept either a valid date or certain special Strings (like "Not Available"). <P> Only applies to dateItems where {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is true. Non-Date values are never supported in items where useTextField is false.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEnforceDate()  {
        return getAttributeAsBoolean("enforceDate");
    }

    /**
    * Validation error message to display if the user enters an invalid date
    *
    * @param invalidDateStringMessage invalidDateStringMessage Default value is "Invalid date"
    */
    public void setInvalidDateStringMessage(String invalidDateStringMessage) {
        setAttribute("invalidDateStringMessage", invalidDateStringMessage);
    }
    /**
     * Validation error message to display if the user enters an invalid date
     *
     *
     * @return String
     *
     */
    public String getInvalidDateStringMessage()  {
        return getAttributeAsString("invalidDateStringMessage");
    }

    /**
    * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization of your application.
    *
    * @param pickerIconPrompt pickerIconPrompt Default value is "Show Date Chooser"
    */
    public void setPickerIconPrompt(String pickerIconPrompt) {
        setAttribute("pickerIconPrompt", pickerIconPrompt);
    }
    /**
     * Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May be overridden for localization of your application.
     *
     *
     * @return String
     *
     */
    public String getPickerIconPrompt()  {
        return getAttributeAsString("pickerIconPrompt");
    }

    /**
    * Minimum date the selectors will allow the user to pick.
    *
    * @param startDate startDate Default value is 1/1/1995
    */
    public void setStartDate(java.util.Date startDate) {
        setAttribute("startDate", startDate);
    }
    /**
     * Minimum date the selectors will allow the user to pick.
     *
     *
     * @return java.util.Date
     *
     */
    public java.util.Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }

    /**
    * Maximum date the selectors will allow the user to pick.
    *
    * @param endDate endDate Default value is 12/31/2015
    */
    public void setEndDate(java.util.Date endDate) {
        setAttribute("endDate", endDate);
    }
    /**
     * Maximum date the selectors will allow the user to pick.
     *
     *
     * @return java.util.Date
     *
     */
    public java.util.Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

    /**
    * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with only 2 digits and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted according to default browser behaviour, which will consider it to be 19xx.
    *
    * @param centuryThreshold centuryThreshold Default value is 25
    */
    public void setCenturyThreshold(int centuryThreshold) {
        setAttribute("centuryThreshold", centuryThreshold);
    }
    /**
     * Only used if we're showing the date in a text field. When parsing a date, if the year is specified with only 2 digits and is less than the centuryThreshold, then the year will be assumed to be 20xx; otherwise it will be interpreted according to default browser behaviour, which will consider it to be 19xx.
     *
     *
     * @return int
     *
     */
    public int getCenturyThreshold()  {
        return getAttributeAsInt("centuryThreshold");
    }
             
    /**
    * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to  customize the format in which dates are displayed.<br> Should be set to a standard ${isc.DocUtils.linkForRef('type:DateDisplayFormat')} or a function which will return a formatted date string. Default setting is <code>"toShortDate"</code> which ensures that if the standard shortDate format is modified via {@link com.smartgwt.client..Date#setShortDisplayFormat} this format will be picked up. <P> <B>NOTE: you may need to update the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} to ensure the DateItem is able to parse user-entered date strings back into Dates</B>
    *
    * @param displayFormat displayFormat Default value is "toShortDate"
    */
    public void setDisplayFormat(DateDisplayFormat displayFormat) {
        setAttribute("displayFormat", displayFormat.getValue());
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to  customize the format in which dates are displayed.<br> Should be set to a standard ${isc.DocUtils.linkForRef('type:DateDisplayFormat')} or a function which will return a formatted date string. Default setting is <code>"toShortDate"</code> which ensures that if the standard shortDate format is modified via {@link com.smartgwt.client..Date#setShortDisplayFormat} this format will be picked up. <P> <B>NOTE: you may need to update the {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} to ensure the DateItem is able to parse user-entered date strings back into Dates</B>
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDisplayFormat()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("displayFormat"));
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to specify the input format for date strings.  If unset, the input format will be determined based on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} if possible (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat}), otherwise picked up from the Date class (see {@link com.smartgwt.client..Date#setInputFormat}). <P> Should be set to a standard ${isc.DocUtils.linkForRef('type:DateInputFormat')} or a function which will take a date string as a parameter and return a Javascript Date object.
    *
    * @param inputFormat inputFormat Default value is null
    */
    public void setInputFormat(String inputFormat) {
        setAttribute("inputFormat", inputFormat);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this property can be used to specify the input format for date strings.  If unset, the input format will be determined based on the specified {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} if possible (see {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat}), otherwise picked up from the Date class (see {@link com.smartgwt.client..Date#setInputFormat}). <P> Should be set to a standard ${isc.DocUtils.linkForRef('type:DateInputFormat')} or a function which will take a date string as a parameter and return a Javascript Date object.
     *
     *
     * @return If {@link com.smartgwt.client.widgets.form.fields.DateItem#getUseTextField useTextField} is <code>true</code> this method returns a standard ${isc.DocUtils.linkForRef('type:DateInputFormat')}, or parsing function, determining how values entered by the user are to be converted to Javascript Date objects. <P> If an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getInputFormat inputFormat} has been specified it will be returned. <P> Otherwise, if an explicit {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat} has been specified as one of <code>toUSShortDate</code>, <code>toEuropeanShortDate</code> or <code>toJapanShortDate</code> this method will return the appropriate DateInputFormat to parse strings entered in the specified displayFormat. <P> If no inputFormat can be derived, the method will return null, meaning the standard input format for Date objects (specified via {@link com.smartgwt.client..Date#setInputFormat}) will be used.
     *
     */
    public String getInputFormat()  {
        return getAttributeAsString("inputFormat");
    }

    /**
    * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this property allows customization of the  order of the day, month and year selector fields. If unset these fields will match the specified inputFormat for this item.
    *
    * @param selectorFormat selectorFormat Default value is null
    */
    public void setSelectorFormat(String selectorFormat) {
        setAttribute("selectorFormat", selectorFormat);
    }
    /**
     * If showing date selectors rather than the date text field (so when  <code>this.useTextField</code> is false), this property allows customization of the  order of the day, month and year selector fields. If unset these fields will match the specified inputFormat for this item.
     *
     *
     * @return String
     *
     */
    public String getSelectorFormat()  {
        return getAttributeAsString("selectorFormat");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************

}




