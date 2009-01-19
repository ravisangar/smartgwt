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
 
package com.smartgwt.client.widgets;



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
    * The ViewLoader component can be used to load new SmartClient-based user interfaces into a running application. <P> <b>NOTE:</b> before using a ViewLoader, be sure that you have read about and understood the SmartClient Architecture.  The most responsive and scalable application architecture preloads views rather than using ViewLoaders. <P> A ViewLoader is a Canvas, and can be provided anywhere a Canvas can be provided: as a Tab pane, and Layout member, etc.  When a ViewLoader draws, it shows a {@link com.smartgwt.client.widgets.ViewLoader#getLoadingMessage loadingMessage}, then performs an RPC to the {@link com.smartgwt.client.widgets.ViewLoader#getViewURL viewURL} to load components. <P> The response from the viewURL should be SmartClient components defined in JavaScript, with no surrounding &lt;SCRIPT&gt; tags or other HTML framing.  The returned script can be dynamically generated, for example, it may be the result of a JSP containing an XML view description enclosed in &lt;isomorphicXML&gt; tags. <P> In the returned script, the special variable "viewLoader" is available to refer to the ViewLoader instance that is loading components.  The intended usage is that the returned script creates a view consisting of SmartClient components, then calls <code>viewLoader.setView(myView)</code> to place the loaded view into the ViewLoader. If the view does not call setView() explicitly, the viewLoader will find the last top-level UI component (Canvas subclass) created by the view and set that as the current view. Top-level in this case means that the UI component is not contained in another UI component as a member or child. <p> The ViewLoader relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See ${isc.DocUtils.linkForRef('group:platformDependencies')} for more information.

    */
public class ViewLoader extends Label {

    public static ViewLoader getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ViewLoader) obj;
        } else {
            return new ViewLoader(jsObj);
        }
    }


    public ViewLoader(){
        
    }

    public ViewLoader(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ViewLoader.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Message to show while the view is loading
    *
    * @param loadingMessage loadingMessage Default value is "Loading View..."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        setAttribute("loadingMessage", loadingMessage, false);
    }
    /**
     * Message to show while the view is loading
     *
     *
     * @return String
     *
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    /**
    * URL to load components from.
    * Change the URL this component loads a view from.  Triggers a fetch from the new URL. <P> Can also be called with no arguments to reload the view from the existing ${isc.DocUtils.linkForRef('contentsURL')}.
    *
    * @param viewURL URL to retrieve view from. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setViewURL(String viewURL)  throws IllegalStateException {
        setAttribute("viewURL", viewURL, false);
    }
    /**
     * URL to load components from.
     *
     *
     * @return String
     *
     */
    public String getViewURL()  {
        return getAttributeAsString("viewURL");
    }

    /**
    * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
    *
    * @param httpMethod httpMethod Default value is "GET"
    */
    public void setHttpMethod(String httpMethod) {
        setAttribute("httpMethod", httpMethod, true);
    }
    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     *
     * @return String
     *
     */
    public String getHttpMethod()  {
        return getAttributeAsString("httpMethod");
    }

    /**
    * By default a ViewLoader will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the response can be cached.
    *
    * @param allowCaching allowCaching Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAllowCaching(Boolean allowCaching)  throws IllegalStateException {
        setAttribute("allowCaching", allowCaching, false);
    }
    /**
     * By default a ViewLoader will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the response can be cached.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAllowCaching()  {
        return getAttributeAsBoolean("allowCaching");
    }

    // ********************* Methods ***********************



        /**
         * Retrieve the current view.  May be null if the view has not yet been loaded, or has been explicitly set to null.
         *
         * @return the current view
         */
        public native Canvas getView() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getView();
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * StringMethod fired when the view has been loaded.  Has no default implementation.  May be observed or overridden to fire custom logic when loading completes.
         * @param view the view that was loaded
         */
        public native void viewLoaded(Canvas view) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.viewLoaded(view.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        }-*/;

    // ********************* Static Methods ***********************

}



