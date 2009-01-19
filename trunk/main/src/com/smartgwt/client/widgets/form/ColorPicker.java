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
 
package com.smartgwt.client.widgets.form;



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
    * The ColorPicker widget allows the user to select a color from anywhere in the  color spectrum. It also supports selecting the alpha (opacity) value of the  color.  The picker supports a simple mode - which allows for one-click selection from a standard palette of colors - and a complex mode which allow the user to define any conceivable color. It is possible for the user to switch from simple mode to complex by interacting with the widget.  In general, the widget provides very similar functionality to the color picker dialogs found in graphics packages and other desktop software.

    */
public class ColorPicker extends Window {

    public static ColorPicker getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ColorPicker) obj;
        } else {
            return new ColorPicker(jsObj);
        }
    }


    public ColorPicker(){
        
    }

    public ColorPicker(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ColorPicker.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * The default color. This is the color that is selected when the picker first loads
    *
    * @param defaultColor defaultColor Default value is #808080
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDefaultColor(String defaultColor)  throws IllegalStateException {
        setAttribute("defaultColor", defaultColor, false);
    }
    /**
     * The default color. This is the color that is selected when the picker first loads
     *
     *
     * @return String
     *
     */
    public String getDefaultColor()  {
        return getAttributeAsString("defaultColor");
    }

    /**
    * Width and height of the basic color boxes (they are always square, and they are all the same size).
    *
    * @param colorButtonSize colorButtonSize Default value is 20
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setColorButtonSize(int colorButtonSize)  throws IllegalStateException {
        setAttribute("colorButtonSize", colorButtonSize, false);
    }
    /**
     * Width and height of the basic color boxes (they are always square, and they are all the same size).
     *
     *
     * @return int
     *
     */
    public int getColorButtonSize()  {
        return getAttributeAsInt("colorButtonSize");
    }

    /**
    * Base CSS style applied to the basic color boxes
    *
    * @param colorButtonBaseStyle colorButtonBaseStyle Default value is "ColorChooserCell"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setColorButtonBaseStyle(String colorButtonBaseStyle)  throws IllegalStateException {
        setAttribute("colorButtonBaseStyle", colorButtonBaseStyle, false);
    }
    /**
     * Base CSS style applied to the basic color boxes
     *
     *
     * @return String
     *
     */
    public String getColorButtonBaseStyle()  {
        return getAttributeAsString("colorButtonBaseStyle");
    }

    /**
    * Displayed width of the color swatch image. The default width is approximately that used by the Windows&#174; XP color picking window
    *
    * @param swatchWidth swatchWidth Default value is 170
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSwatchWidth(int swatchWidth)  throws IllegalStateException {
        setAttribute("swatchWidth", swatchWidth, false);
    }
    /**
     * Displayed width of the color swatch image. The default width is approximately that used by the Windows&#174; XP color picking window
     *
     *
     * @return int
     *
     */
    public int getSwatchWidth()  {
        return getAttributeAsInt("swatchWidth");
    }

    /**
    * Displayed height of the color swatch image. The default height is approximately that used by the Windows&#174; XP color picking window
    *
    * @param swatchHeight swatchHeight Default value is 170
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSwatchHeight(int swatchHeight)  throws IllegalStateException {
        setAttribute("swatchHeight", swatchHeight, false);
    }
    /**
     * Displayed height of the color swatch image. The default height is approximately that used by the Windows&#174; XP color picking window
     *
     *
     * @return int
     *
     */
    public int getSwatchHeight()  {
        return getAttributeAsInt("swatchHeight");
    }

    /**
    * Width of the Luminosity bar
    *
    * @param lumWidth lumWidth Default value is 15
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLumWidth(int lumWidth)  throws IllegalStateException {
        setAttribute("lumWidth", lumWidth, false);
    }
    /**
     * Width of the Luminosity bar
     *
     *
     * @return int
     *
     */
    public int getLumWidth()  {
        return getAttributeAsInt("lumWidth");
    }

    /**
    * Determines whether to show the opacity slider. This allows the user to select colors with an alpha element (ie, semi-transparent colors). If this attribute is set to false, no opacity slider is shown, and all colors are completely opaque.
    * Set the {@link com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} flag.
    *
    * @param supportsTransparency Set to true to enable transparency/opacity. Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSupportsTransparency(Boolean supportsTransparency)  throws IllegalStateException {
        setAttribute("supportsTransparency", supportsTransparency, false);
    }
    /**
     * Determines whether to show the opacity slider. This allows the user to select colors with an alpha element (ie, semi-transparent colors). If this attribute is set to false, no opacity slider is shown, and all colors are completely opaque.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSupportsTransparency()  {
        return getAttributeAsBoolean("supportsTransparency");
    }

    /**
    * The text to show underneath the selected color box, so that it can  be seen through semi-transparent colors. If you do not want such text, set  this value to blank. This value is irrelevant if  {@link com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
    *
    * @param opacityText opacityText Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOpacityText(Boolean opacityText)  throws IllegalStateException {
        setAttribute("opacityText", opacityText, false);
    }
    /**
     * The text to show underneath the selected color box, so that it can  be seen through semi-transparent colors. If you do not want such text, set  this value to blank. This value is irrelevant if  {@link com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getOpacityText()  {
        return getAttributeAsBoolean("opacityText");
    }

    /**
    * The location of the color swatch image file
    *
    * @param swatchImageURL swatchImageURL Default value is "[SKIN]ColorPicker/spectrum.png"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSwatchImageURL(String swatchImageURL)  throws IllegalStateException {
        setAttribute("swatchImageURL", swatchImageURL, false);
    }
    /**
     * The location of the color swatch image file
     *
     *
     * @return String
     *
     */
    public String getSwatchImageURL()  {
        return getAttributeAsString("swatchImageURL");
    }

    /**
    * The location of the crosshair image file
    *
    * @param crosshairImageURL crosshairImageURL Default value is "[SKIN]ColorPicker/crosshair.png"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCrosshairImageURL(String crosshairImageURL)  throws IllegalStateException {
        setAttribute("crosshairImageURL", crosshairImageURL, false);
    }
    /**
     * The location of the crosshair image file
     *
     *
     * @return String
     *
     */
    public String getCrosshairImageURL()  {
        return getAttributeAsString("crosshairImageURL");
    }

    /**
    * The label shown above the basic color blocks.
    *
    * @param basicColorLabel basicColorLabel Default value is "Basic Colors:"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBasicColorLabel(String basicColorLabel)  throws IllegalStateException {
        setAttribute("basicColorLabel", basicColorLabel, false);
    }
    /**
     * The label shown above the basic color blocks.
     *
     *
     * @return String
     *
     */
    public String getBasicColorLabel()  {
        return getAttributeAsString("basicColorLabel");
    }

    /**
    * The label shown next to the selected color box.
    *
    * @param selectedColorLabel selectedColorLabel Default value is "Selected Color"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSelectedColorLabel(String selectedColorLabel)  throws IllegalStateException {
        setAttribute("selectedColorLabel", selectedColorLabel, false);
    }
    /**
     * The label shown next to the selected color box.
     *
     *
     * @return String
     *
     */
    public String getSelectedColorLabel()  {
        return getAttributeAsString("selectedColorLabel");
    }

    /**
    * The label shown next to the opacity slider. Ignored if  {@link com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
    *
    * @param opacitySliderLabel opacitySliderLabel Default value is "Opacity"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOpacitySliderLabel(String opacitySliderLabel)  throws IllegalStateException {
        setAttribute("opacitySliderLabel", opacitySliderLabel, false);
    }
    /**
     * The label shown next to the opacity slider. Ignored if  {@link com.smartgwt.client.widgets.form.ColorPicker#getSupportsTransparency supportsTransparency} is false.
     *
     *
     * @return String
     *
     */
    public String getOpacitySliderLabel()  {
        return getAttributeAsString("opacitySliderLabel");
    }

    /**
    * The initial opacity value for the component, as a percentage value between 0 and 100
    *
    * @param defaultOpacity defaultOpacity Default value is 100
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDefaultOpacity(int defaultOpacity)  throws IllegalStateException {
        setAttribute("defaultOpacity", defaultOpacity, false);
    }
    /**
     * The initial opacity value for the component, as a percentage value between 0 and 100
     *
     *
     * @return int
     *
     */
    public int getDefaultOpacity()  {
        return getAttributeAsInt("defaultOpacity");
    }

    /**
    * If true, causes the ColorPicker to appear near where the mouse was last clicked. If false, the ColorPicker is centered on first show; depending on the value of  {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoCenterOnShow autoCenterOnShow}, it either reappears wherever it was last shown after hide/show(),  or centered regardless of where it was last shown.
    *
    * @param autoPosition autoPosition Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoPosition(Boolean autoPosition)  throws IllegalStateException {
        setAttribute("autoPosition", autoPosition, false);
    }
    /**
     * If true, causes the ColorPicker to appear near where the mouse was last clicked. If false, the ColorPicker is centered on first show; depending on the value of  {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoCenterOnShow autoCenterOnShow}, it either reappears wherever it was last shown after hide/show(),  or centered regardless of where it was last shown.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoPosition()  {
        return getAttributeAsBoolean("autoPosition");
    }

    /**
    * If {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoPosition autoPosition} is false, this property controls whether to automatically center the colorPicker every time it is reshown with the show() method.
    *
    * @param autoCenterOnShow autoCenterOnShow Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoCenterOnShow(Boolean autoCenterOnShow)  throws IllegalStateException {
        setAttribute("autoCenterOnShow", autoCenterOnShow, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.form.ColorPicker#getAutoPosition autoPosition} is false, this property controls whether to automatically center the colorPicker every time it is reshown with the show() method.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoCenterOnShow()  {
        return getAttributeAsBoolean("autoCenterOnShow");
    }

    /**
    * The ColorPicker can operate in either a "simple" mode (where it displays just the 40 basic colors and allows the user to click one), or a "complex" mode (where the user can specify a color from anywhere in the spectrum, with an optional alpha  element). The defaultPickMode attribute specifies which of these two modes is  in force when the picker first loads.
    *
    * @param defaultPickMode defaultPickMode Default value is "simple"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDefaultPickMode(String defaultPickMode)  throws IllegalStateException {
        setAttribute("defaultPickMode", defaultPickMode, false);
    }
    /**
     * The ColorPicker can operate in either a "simple" mode (where it displays just the 40 basic colors and allows the user to click one), or a "complex" mode (where the user can specify a color from anywhere in the spectrum, with an optional alpha  element). The defaultPickMode attribute specifies which of these two modes is  in force when the picker first loads.
     *
     *
     * @return String
     *
     */
    public String getDefaultPickMode()  {
        return getAttributeAsString("defaultPickMode");
    }

    /**
    * Should the "complex" mode be allowed for this ColorPicker? If false, no "More" button is shown on the simple picker
    *
    * @param allowComplexMode allowComplexMode Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAllowComplexMode(Boolean allowComplexMode)  throws IllegalStateException {
        setAttribute("allowComplexMode", allowComplexMode, false);
    }
    /**
     * Should the "complex" mode be allowed for this ColorPicker? If false, no "More" button is shown on the simple picker
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAllowComplexMode()  {
        return getAttributeAsBoolean("allowComplexMode");
    }

    // ********************* Methods ***********************


        /**
         * Returns the Red element of the currently-selected color, as an integer from 0-255
         */
        public native void getRed() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getRed();
        }-*/;

        /**
         * Returns the Green element of the currently-selected color, as an integer from 0-255
         */
        public native void getGreen() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getGreen();
        }-*/;

        /**
         * Returns the Blue element of the currently-selected color, as an integer from 0-255
         */
        public native void getBlue() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getBlue();
        }-*/;

        /**
         * Returns the Hue of the currently-selected color, as an integer from 0-239
         */
        public native void getHue() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getHue();
        }-*/;

        /**
         * Returns the Saturation of the currently-selected color, as an integer from 0-240
         */
        public native void getSaturation() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getSaturation();
        }-*/;

        /**
         * Returns the Luminosity (brightness) of the currently-selected color, as an  integer from 0-240
         */
        public native void getLuminosity() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getLuminosity();
        }-*/;

        /**
         * Returns the currently-selected color, in HTML color representation form, as a string. HTML color representation is a hash sign, followed by the red, green and blue elements of the color in 2-digit hex form - for example "#F17F1D"
         */
        public native void getHtmlColor() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getHtmlColor();
        }-*/;


        /**
         * Sets the Red element of the selected color
         * @param newValue An integer between 0 and 255
         */
        public native void setRed(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setRed(newValue);
        }-*/;

        /**
         * Sets the Green element of the selected color
         * @param newValue An integer between 0 and 255
         */
        public native void setGreen(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setGreen(newValue);
        }-*/;

        /**
         * Sets the Blue element of the selected color
         * @param newValue An integer between 0 and 255
         */
        public native void setBlue(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setBlue(newValue);
        }-*/;

        /**
         * Sets the Hue of the selected color
         * @param newValue An integer between 0 and 239
         */
        public native void setHue(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHue(newValue);
        }-*/;

        /**
         * Sets the Saturation of the selected color
         * @param newValue An integer between 0 and 240
         */
        public native void setSaturation(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setSaturation(newValue);
        }-*/;

        /**
         * Sets the Luminosity (brightness) of the selected color
         * @param newValue An integer between 0 and 240
         */
        public native void setLuminosity(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setLuminosity(newValue);
        }-*/;

        /**
         * Changes the selected color to the one represented by the supplied HTML color  string. Note that ths method only accepts the parameter if it represents a  valid color (otherwise it is simply ignored).
         * @param newValue A string in HTML color representation format (#RRGGBB)
         */
        public native void setHtmlColor(String newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHtmlColor(newValue);
        }-*/;

        /**
         * Sets the Opacity of the selected color. Ignored if opacity is switched off.
         * @param newValue An integer between 0 and 100
         */
        public native void setOpacity(int newValue) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setOpacity(newValue);
        }-*/;

        /**
         * Override this method to be kept informed when the ColorPicker changes in real-time  (for example, if you need to update your own GUI accordingly). Then use the  getXxxx() methods (for example, {@link com.smartgwt.client.widgets.form.ColorPicker#getBlue} or  {@link com.smartgwt.client.widgets.form.ColorPicker#getLuminosity})to obtain current state as required.
         */
        public native void colorChanged() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.colorChanged();
        }-*/;

        /**
         * Override this method to be notified when the user selects a color either by clicking a basic color box in simple mode, or by clicking  the OK button in complex mode. It is not intended that client code  call this method.
         * @param color The color selected, in HTML format
     * @param opacity The opacity selected, from 0-100.
         */
        public native void colorSelected(String color, int opacity) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.colorSelected(color, opacity);
        }-*/;

    // ********************* Static Methods ***********************


}




