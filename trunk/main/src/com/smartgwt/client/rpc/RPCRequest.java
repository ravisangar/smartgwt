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
 
package com.smartgwt.client.rpc;



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
    * Encapsulates a client/server RPC request.  You'll need to provide an instance of this class (or a constructor for it) to the {@link com.smartgwt.client.rpc.RPCManager#sendRequest} method.  If you use the  {@link com.smartgwt.client.rpc.RPCManager#send} method, an instance of RPCRequest will be created for you.

    */
public class RPCRequest extends DataClass {

    public static RPCRequest getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RPCRequest(jsObj);
    }


    public RPCRequest(){
        
    }

    public RPCRequest(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Overrides RPCManager.actionURL for this request only.  If you're using queuing, note that queues as per-URL - in other words all RPCRequests in a queue must go to a single URL.  If you attempt to send a request with an actionURL that is different from those already in the queue, it will be sent to the server separately, ahead of the queue,  and a warning will be logged to the Developer Console.
    *
    * @param actionURL actionURL Default value is RPCManager.actionURL
    */
    public void setActionURL(String actionURL) {
        setAttribute("actionURL", actionURL);
    }
    /**
     * Overrides RPCManager.actionURL for this request only.  If you're using queuing, note that queues as per-URL - in other words all RPCRequests in a queue must go to a single URL.  If you attempt to send a request with an actionURL that is different from those already in the queue, it will be sent to the server separately, ahead of the queue,  and a warning will be logged to the Developer Console.
     *
     *
     * @return String
     *
     */
    public String getActionURL()  {
        return getAttributeAsString("actionURL");
    }
             
    /**
    * Controls the prompt style for this request only.  Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptStyle}.
    *
    * @param promptStyle promptStyle Default value is RPCManager.promptStyle
    */
    public void setPromptStyle(PromptStyle promptStyle) {
        setAttribute("promptStyle", promptStyle.getValue());
    }
    /**
     * Controls the prompt style for this request only.  Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptStyle}.
     *
     *
     * @return PromptStyle
     *
     */
    public PromptStyle getPromptStyle()  {
        return (PromptStyle) EnumUtil.getEnum(PromptStyle.values(), getAttribute("promptStyle"));
    }

    /**
    * Controls the cursor shown when {@link com.smartgwt.client.rpc.RPCManager#promptStyle} is set to <code>"cursor"</code> for this request only. Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptCursor}. <p> In Safari, IE 5.5 and Firefox 1.0 the default value is "wait", on all other platforms it is "progress".  The reason for this split is that the above-mentioned browsers do not support CSS2.1 - which is required for the "progress" cursor type.
    *
    * @param promptCursor promptCursor Default value is browser-dependent
    */
    public void setPromptCursor(String promptCursor) {
        setAttribute("promptCursor", promptCursor);
    }
    /**
     * Controls the cursor shown when {@link com.smartgwt.client.rpc.RPCManager#promptStyle} is set to <code>"cursor"</code> for this request only. Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptCursor}. <p> In Safari, IE 5.5 and Firefox 1.0 the default value is "wait", on all other platforms it is "progress".  The reason for this split is that the above-mentioned browsers do not support CSS2.1 - which is required for the "progress" cursor type.
     *
     *
     * @return String
     *
     */
    public String getPromptCursor()  {
        return getAttributeAsString("promptCursor");
    }

    /**
    * Overrides RPCManager.defaultPrompt for this request only.  If you're using queuing, note that the prompt string from the first request in the queue is the one that is shown to the user.
    *
    * @param prompt prompt Default value is RPCManager.defaultPrompt
    */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }
    /**
     * Overrides RPCManager.defaultPrompt for this request only.  If you're using queuing, note that the prompt string from the first request in the queue is the one that is shown to the user.
     *
     *
     * @return String
     *
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }

    /**
    * Overrides RPCManager.showPrompt for this request only.  If you're using queuing, note that if any of the requests in the queue specify showPrompt:true, then a prompt will be shown for the entire queue with the prompt text of the first request in the queue to specify a custom prompt if promptStyle is set to "dialog".  If promptStyle is set to "cursor" for the request that specified showPrompt: true, then the entire queue uses the "cursor" style for the prompt.
    *
    * @param showPrompt showPrompt Default value is RPCManager.showPrompt
    */
    public void setShowPrompt(Boolean showPrompt) {
        setAttribute("showPrompt", showPrompt);
    }
    /**
     * Overrides RPCManager.showPrompt for this request only.  If you're using queuing, note that if any of the requests in the queue specify showPrompt:true, then a prompt will be shown for the entire queue with the prompt text of the first request in the queue to specify a custom prompt if promptStyle is set to "dialog".  If promptStyle is set to "cursor" for the request that specified showPrompt: true, then the entire queue uses the "cursor" style for the prompt.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowPrompt()  {
        return getAttributeAsBoolean("showPrompt");
    }

    /**
    * With willHandleError:false, rpcResponses that indicate an error go through centralized handling in the RPCManager and rpcRequest.callback is never invoked. <P> Setting willHandleError:true means that your rpcRequest.callback will receive rpcResponses that have an error status and must handle them. <P> See also the error handling section in the {@link com.smartgwt.client.rpc.RPCManager} docs.
    *
    * @param willHandleError willHandleError Default value is false
    */
    public void setWillHandleError(Boolean willHandleError) {
        setAttribute("willHandleError", willHandleError);
    }
    /**
     * With willHandleError:false, rpcResponses that indicate an error go through centralized handling in the RPCManager and rpcRequest.callback is never invoked. <P> Setting willHandleError:true means that your rpcRequest.callback will receive rpcResponses that have an error status and must handle them. <P> See also the error handling section in the {@link com.smartgwt.client.rpc.RPCManager} docs.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWillHandleError()  {
        return getAttributeAsBoolean("willHandleError");
    }

    /**
    * Overrides RPCManager.defaultTimeout for this request only.  If you're using queuing, note that the timeout setting derived from the last request in the queue is used for the entire queue.  If you want to override the timeout for the queue, make sure to set your override at least on the last request in the queue.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param timeout timeout Default value is RPCManager.defaultTimeout
    */
    public void setTimeout(int timeout) {
        setAttribute("timeout", timeout);
    }
    /**
     * Overrides RPCManager.defaultTimeout for this request only.  If you're using queuing, note that the timeout setting derived from the last request in the queue is used for the entire queue.  If you want to override the timeout for the queue, make sure to set your override at least on the last request in the queue.
     *
     *
     * @return int
     *
     */
    public int getTimeout()  {
        return getAttributeAsInt("timeout");
    }

    /**
    * This works similarly to {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} except the resulting String is automatically evaluated as JavaScript.  The result of the evaluation is then passed to any specified {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link com.smartgwt.client.rpc.RPCResponse#getData data}. <p> This feature can be used to dynamically load new application modules into a running application.  An RPCRequest with <code>evalResult</code> enabled can be used to fetch a static .js file or JavaScript dynamically generated by the server.  The returned JavaScript can contain anything that a JavaScript file loaded at init time can contain, including new views and new SmartClient class definitions. <p> <i>Example usage with {@link com.smartgwt.client.rpc.RPCManager#sendRequest}:</i> <pre> isc.RPCManager.sendRequest({     evalResult:true,     actionURL:"js/loadLabel.js",     evalVars:{var1:"A Value"} }); </pre> This call would execute the code from <code>loadLabel.js</code>, and make the variable <code>var1</code> available to that code. Therefore if the .js file contained this code: <pre> isc.Label.create({     contents:var1 }) </pre> A label would be created with contents set to the value of <code>var1</code> - the string <code>"A Value"</code>.  <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See ${isc.DocUtils.linkForRef('group:platformDependencies')} for more information.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param evalResult evalResult Default value is false
    */
    public void setEvalResult(Boolean evalResult) {
        setAttribute("evalResult", evalResult);
    }
    /**
     * This works similarly to {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} except the resulting String is automatically evaluated as JavaScript.  The result of the evaluation is then passed to any specified {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link com.smartgwt.client.rpc.RPCResponse#getData data}. <p> This feature can be used to dynamically load new application modules into a running application.  An RPCRequest with <code>evalResult</code> enabled can be used to fetch a static .js file or JavaScript dynamically generated by the server.  The returned JavaScript can contain anything that a JavaScript file loaded at init time can contain, including new views and new SmartClient class definitions. <p> <i>Example usage with {@link com.smartgwt.client.rpc.RPCManager#sendRequest}:</i> <pre> isc.RPCManager.sendRequest({     evalResult:true,     actionURL:"js/loadLabel.js",     evalVars:{var1:"A Value"} }); </pre> This call would execute the code from <code>loadLabel.js</code>, and make the variable <code>var1</code> available to that code. Therefore if the .js file contained this code: <pre> isc.Label.create({     contents:var1 }) </pre> A label would be created with contents set to the value of <code>var1</code> - the string <code>"A Value"</code>.  <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See ${isc.DocUtils.linkForRef('group:platformDependencies')} for more information.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEvalResult()  {
        return getAttributeAsBoolean("evalResult");
    }

    /**
    * For use only with the <code>scriptInclude</code> transport, this attribute specifies the name of the parameter from which the server expects to read the name of the JavaScript callback function. <P> SmartClient will use the callback mechanism provided by the server, then call {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} normally. <p> This attribute is ignored by all other transports.
    *
    * @param callbackParam callbackParam Default value is "callback"
    */
    public void setCallbackParam(String callbackParam) {
        setAttribute("callbackParam", callbackParam);
    }
    /**
     * For use only with the <code>scriptInclude</code> transport, this attribute specifies the name of the parameter from which the server expects to read the name of the JavaScript callback function. <P> SmartClient will use the callback mechanism provided by the server, then call {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} normally. <p> This attribute is ignored by all other transports.
     *
     *
     * @return String
     *
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
    }

    /**
    * Setting this flag makes the body of the HTTP response available as a String in the {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link com.smartgwt.client.rpc.RPCResponse#getData data}.  This is typically only useful if you are sending a request that will <b>not</b> be received by the SmartClient Java Server, however in that case, set {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp}:true instead, which implies <code>serverOutputAsString:true</code>. <P> <code>serverOutputAsString:true</code> allows you to, for example, load the contents of static files off your webserver into a string for processing on the client with no server support.  The {@link com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} must be in the same domain as the current page for this to work. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See non-Java backends  or for advanced usage such as content that requires processing before it can be used in SmartClient components (such as client-side web scraping).  Note that SmartClient provides higher-level APIs for loading common types of data, see eg {@link com.smartgwt.client.widgets.HTMLFlow} for HTML content, {@link com.smartgwt.client.widgets.ViewLoader} for loading SmartClient components, {@link com.smartgwt.client.util.XMLTools#loadXML} for loading XML, {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} for loading <a href='http://www.json.org/' onclick="window.open('http://www.json.org/');return false;">JSON</a>, and {@link com.smartgwt.client.data.DataSource} for loading structured data in various formats.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param serverOutputAsString serverOutputAsString Default value is false
    */
    public void setServerOutputAsString(Boolean serverOutputAsString) {
        setAttribute("serverOutputAsString", serverOutputAsString);
    }
    /**
     * Setting this flag makes the body of the HTTP response available as a String in the {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link com.smartgwt.client.rpc.RPCResponse#getData data}.  This is typically only useful if you are sending a request that will <b>not</b> be received by the SmartClient Java Server, however in that case, set {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp}:true instead, which implies <code>serverOutputAsString:true</code>. <P> <code>serverOutputAsString:true</code> allows you to, for example, load the contents of static files off your webserver into a string for processing on the client with no server support.  The {@link com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} must be in the same domain as the current page for this to work. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See non-Java backends  or for advanced usage such as content that requires processing before it can be used in SmartClient components (such as client-side web scraping).  Note that SmartClient provides higher-level APIs for loading common types of data, see eg {@link com.smartgwt.client.widgets.HTMLFlow} for HTML content, {@link com.smartgwt.client.widgets.ViewLoader} for loading SmartClient components, {@link com.smartgwt.client.util.XMLTools#loadXML} for loading XML, {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} for loading <a href='http://www.json.org/' onclick="window.open('http://www.json.org/');return false;">JSON</a>, and {@link com.smartgwt.client.data.DataSource} for loading structured data in various formats.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getServerOutputAsString()  {
        return getAttributeAsBoolean("serverOutputAsString");
    }
             
    /**
    * Selects the transport used for this RPCRequest.  If unset, the value of {@link com.smartgwt.client.rpc.RPCManager#defaultTransport} will be used. <p> If you're using queueing, note that all requests in the queue must use the same transport. If you attempt to send a request via a different transport than those that are currently on the queue, it will be sent to the server separately, ahead of the queue, and a warning will be logged to the Developer Console. <p> If you specify an unknown transport, an error will be logged to the DeveloperConsole and {@link com.smartgwt.client.rpc.RPCManager#defaultTransport} will be used instead. <p> If you specify the <code>xmlHttpRequest</code> transport and it is not available, a warning will be logged to the Developer Console and the RPCManager will attempt to use the <code>hiddenFrame</code> transport instead for this request.  Note that some features like {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} requre the <code>xmlHttpRequest</code> transport and will not work if the <code>xmlHttpRequest</code> transport is unavailable (this can happen if the end user is using Internet Explorer and has disabled ActiveX).  You can check whether or not the <code>xmlHttpRequest</code> transport is currently available by calling {@link com.smartgwt.client.rpc.RPCManager#xmlHttpRequestAvailable}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param transport transport Default value is RPCManager.defaultTransport
    */
    public void setTransport(RPCTransport transport) {
        setAttribute("transport", transport.getValue());
    }
    /**
     * Selects the transport used for this RPCRequest.  If unset, the value of {@link com.smartgwt.client.rpc.RPCManager#defaultTransport} will be used. <p> If you're using queueing, note that all requests in the queue must use the same transport. If you attempt to send a request via a different transport than those that are currently on the queue, it will be sent to the server separately, ahead of the queue, and a warning will be logged to the Developer Console. <p> If you specify an unknown transport, an error will be logged to the DeveloperConsole and {@link com.smartgwt.client.rpc.RPCManager#defaultTransport} will be used instead. <p> If you specify the <code>xmlHttpRequest</code> transport and it is not available, a warning will be logged to the Developer Console and the RPCManager will attempt to use the <code>hiddenFrame</code> transport instead for this request.  Note that some features like {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} requre the <code>xmlHttpRequest</code> transport and will not work if the <code>xmlHttpRequest</code> transport is unavailable (this can happen if the end user is using Internet Explorer and has disabled ActiveX).  You can check whether or not the <code>xmlHttpRequest</code> transport is currently available by calling {@link com.smartgwt.client.rpc.RPCManager#xmlHttpRequestAvailable}.
     *
     *
     * @return RPCTransport
     *
     */
    public RPCTransport getTransport()  {
        return (RPCTransport) EnumUtil.getEnum(RPCTransport.values(), getAttribute("transport"));
    }

    /**
    * Selects the HTTP method that will be used for the request.  Typical values are "POST" and "GET". <P> The more obscure "PUT", "DELETE" and "HEAD" methods are also valid, however, none of these are supported by the Safari browser previous to version 3.0.
    *
    * @param httpMethod httpMethod Default value is "POST"
    */
    public void setHttpMethod(String httpMethod) {
        setAttribute("httpMethod", httpMethod);
    }
    /**
     * Selects the HTTP method that will be used for the request.  Typical values are "POST" and "GET". <P> The more obscure "PUT", "DELETE" and "HEAD" methods are also valid, however, none of these are supported by the Safari browser previous to version 3.0.
     *
     *
     * @return String
     *
     */
    public String getHttpMethod()  {
        return getAttributeAsString("httpMethod");
    }

    /**
    * Valid with the xmlHttpRequest transport only and only when {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} is set to "POST".
    *
    * @param contentType contentType Default value is "application/x-www-form-urlencoded"
    */
    public void setContentType(String contentType) {
        setAttribute("contentType", contentType);
    }
    /**
     * Valid with the xmlHttpRequest transport only and only when {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} is set to "POST".
     *
     *
     * @return String
     *
     */
    public String getContentType()  {
        return getAttributeAsString("contentType");
    }

    /**
    * For use during Relogin, this property marks this request an attempt to login, therefore a response containing the <code>loginRequiredMarker</code> is a normal condition and should result in the status code {@link com.smartgwt.client.rpc.RPCResponse#STATUS_LOGIN_INCORRECT} rather than a call to {@link com.smartgwt.client.rpc.RPCManager#loginRequired}. <P> It is not required to set <code>containsCredentials</code>, however, it does typically simplify relogin logic by separating the handling of RPCs that are login attempts from RPCs that are not.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param containsCredentials containsCredentials Default value is false
    */
    public void setContainsCredentials(Boolean containsCredentials) {
        setAttribute("containsCredentials", containsCredentials);
    }
    /**
     * For use during Relogin, this property marks this request an attempt to login, therefore a response containing the <code>loginRequiredMarker</code> is a normal condition and should result in the status code {@link com.smartgwt.client.rpc.RPCResponse#STATUS_LOGIN_INCORRECT} rather than a call to {@link com.smartgwt.client.rpc.RPCManager#loginRequired}. <P> It is not required to set <code>containsCredentials</code>, however, it does typically simplify relogin logic by separating the handling of RPCs that are login attempts from RPCs that are not.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getContainsCredentials()  {
        return getAttributeAsBoolean("containsCredentials");
    }

    /**
    * When set to true, no reply is expected from the server.  However, if a reply is received, it will be processed.<p> Note: setting this to true, forces {@link com.smartgwt.client.rpc.RPCRequest#getSendNoQueue sendNoQueue} to <code>true</code> for this request.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param ignoreTimeout ignoreTimeout Default value is false
    */
    public void setIgnoreTimeout(Boolean ignoreTimeout) {
        setAttribute("ignoreTimeout", ignoreTimeout);
    }
    /**
     * When set to true, no reply is expected from the server.  However, if a reply is received, it will be processed.<p> Note: setting this to true, forces {@link com.smartgwt.client.rpc.RPCRequest#getSendNoQueue sendNoQueue} to <code>true</code> for this request.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getIgnoreTimeout()  {
        return getAttributeAsBoolean("ignoreTimeout");
    }

    /**
    * When set to true, this request is sent to the server immediately, bypassing any current queue.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param sendNoQueue sendNoQueue Default value is false
    */
    public void setSendNoQueue(Boolean sendNoQueue) {
        setAttribute("sendNoQueue", sendNoQueue);
    }
    /**
     * When set to true, this request is sent to the server immediately, bypassing any current queue.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSendNoQueue()  {
        return getAttributeAsBoolean("sendNoQueue");
    }

    /**
    * When set to true, assume the request is not going to the SmartClient server, and hence send a simple HTTP request that does not use SmartClient-specific request encoding. <P> Values specified in {@link com.smartgwt.client.rpc.RPCRequest#getParams params} are sent to to the server as HTTP request parameters.  If {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} is "GET", parameters appear in the request URL, otherwise if httpMethod is "POST", parameters are encoded in the request body (exactly like an HTML form does).  These parameters are then accessible via typical server-side APIs for retrieving HTTP parameters, eg, servletRequest.getParameter(paramName) in Java Servlets.   <P> Note that if {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} method is POST and {@link com.smartgwt.client.rpc.RPCRequest#getData data} is supplied, {@link com.smartgwt.client.rpc.RPCRequest#getData data} is assumed to be a string to post as the HTTP request body, and {@link com.smartgwt.client.rpc.RPCRequest#getParams params} are sent as URL parameters instead.  This usage is for sending custom request bodies such as the XML payloads used for SOAP.  In this case, {@link com.smartgwt.client.rpc.RPCRequest#getContentType contentType} is typically also set to indicate the content type of the request body. <p> Setting <code>useSimpleHttp</code> to true also automatically sets {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} to true as well.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param useSimpleHttp useSimpleHttp Default value is false
    */
    public void setUseSimpleHttp(Boolean useSimpleHttp) {
        setAttribute("useSimpleHttp", useSimpleHttp);
    }
    /**
     * When set to true, assume the request is not going to the SmartClient server, and hence send a simple HTTP request that does not use SmartClient-specific request encoding. <P> Values specified in {@link com.smartgwt.client.rpc.RPCRequest#getParams params} are sent to to the server as HTTP request parameters.  If {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} is "GET", parameters appear in the request URL, otherwise if httpMethod is "POST", parameters are encoded in the request body (exactly like an HTML form does).  These parameters are then accessible via typical server-side APIs for retrieving HTTP parameters, eg, servletRequest.getParameter(paramName) in Java Servlets.   <P> Note that if {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} method is POST and {@link com.smartgwt.client.rpc.RPCRequest#getData data} is supplied, {@link com.smartgwt.client.rpc.RPCRequest#getData data} is assumed to be a string to post as the HTTP request body, and {@link com.smartgwt.client.rpc.RPCRequest#getParams params} are sent as URL parameters instead.  This usage is for sending custom request bodies such as the XML payloads used for SOAP.  In this case, {@link com.smartgwt.client.rpc.RPCRequest#getContentType contentType} is typically also set to indicate the content type of the request body. <p> Setting <code>useSimpleHttp</code> to true also automatically sets {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} to true as well.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseSimpleHttp()  {
        return getAttributeAsBoolean("useSimpleHttp");
    }

    /**
    * For xmlHttp transport + httpMethod: "GET"  only, set to true to force IE to send a conditional GET request even if the browser thinks it has a current cached response.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param bypassCache bypassCache Default value is false
    */
    public void setBypassCache(Boolean bypassCache) {
        setAttribute("bypassCache", bypassCache);
    }
    /**
     * For xmlHttp transport + httpMethod: "GET"  only, set to true to force IE to send a conditional GET request even if the browser thinks it has a current cached response.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getBypassCache()  {
        return getAttributeAsBoolean("bypassCache");
    }

    /**
    * If enabled, the server omits any key/value pairs in map that have null values from the response.  This can reduce the size of the response when many fields have null values. <p> To enable this globally for all responses you can set RPCManager.omitNullMapValuesInResponse in server.properties.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param omitNullMapValuesInResponse omitNullMapValuesInResponse Default value is false
    */
    public void setOmitNullMapValuesInResponse(Boolean omitNullMapValuesInResponse) {
        setAttribute("omitNullMapValuesInResponse", omitNullMapValuesInResponse);
    }
    /**
     * If enabled, the server omits any key/value pairs in map that have null values from the response.  This can reduce the size of the response when many fields have null values. <p> To enable this globally for all responses you can set RPCManager.omitNullMapValuesInResponse in server.properties.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getOmitNullMapValuesInResponse()  {
        return getAttributeAsBoolean("omitNullMapValuesInResponse");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

        /**
         * RPCRequest shouldn't be created directly. Instead, pass ${isc.DocUtils.linkForRef('type:Properties')} to  {@link com.smartgwt.client.rpc.RPCManager#sendRequest} and {@link com.smartgwt.client.rpc.RPCManager#send}.
         */
        public static native void create() /*-{
            $wnd.isc.RPCRequest.create();
        }-*/;






    /**
     * This attribute specifies the payload of the RPCRequest.  When using the SmartClient server, any JavaScript simple
     * type or arbitrarily nested set of Objects and Arrays can be sent to server and automatically translated to Java
     * Objects.  Here are the  mapping of JavaScript types to their corresponding server object types:<br><br> <table
     * class='normal' border='1'>   <tr><td><b>JS Type</b></td>     <td><b>Java Type</b></td> <td><b>C# Type</b></td>
     * <td><b>Perl Type</b></td></tr>   <tr><td>Object: {}</td>         <td>Map</td>              <td>IDictionary</td>
     *    <td>Associative Array: {}</td></tr>   <tr><td>Array: []</td>          <td>List</td>             <td>IList</td>
     *      <td>Array: []</td></tr>   <tr><td>String</td>             <td>String</td>           <td>string</td>
     * <td>string</td></tr>   <tr><td>Number</td>             <td>Long|Double</td>      <td>long|double</td>
     * <td>string</td></tr>   <tr><td>Boolean</td>            <td>Boolean</td>          <td>bool</td>
     * <td>string</td></tr>   <tr><td>Date</td>               <td>java.util.Date</td>   <td>DateTime</td>
     * <td>string</td></tr>  </table> <br><br> Note that the order of keys/values in the Maps created on the server is
     * not guaranteed because JavaScript Object literals do not guarantee order. <p> Server->client conversion follows
     * the this table as well, with some extras.  See the toJS() method on JSTranslater in the server documentation for
     * a description of additional behaviors. <P> When <b>not</b> communicating with the SmartClient server,
     * <code>rpcRequest.data</code> becomes simple HTTP parameters or an HTTP request body - see {@link
     * com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} for details.
     *
     * @param data data Default value is null
     */
    public void setData(JavaScriptObject data) {
        setAttribute("data", data);
    }

    public JavaScriptObject getData() {
        return getAttributeAsJavaScriptObject("data");
    }

    /**
     * Values to be sent as simple HTTP params, as a JavaScript Object where each property/value pair will become an
     * HTTP parameter name and value.  These parameters are then accessible on the server, for example, using
     * servletRequest.getParameter(paramName) in Java Servlets.   <P> This API is primarily used in combination with
     * {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp}. <P> When contacting the SmartClient
     * server, setting <code>params</code> is an opportunity to send additional data aside from the main {@link
     * com.smartgwt.client.rpc.RPCRequest#getData data} payload; this is useful for  adding data to DataSource requests
     * which will be kept separate from the automatically sent DataSource data. <P> Note that in contrast to {@link
     * com.smartgwt.client.rpc.RPCRequest#getData data} object, the data in <code>rpcRequest.params</code> is not
     * serialized/deserialized by the SmartClient server, and all values arrive on the server as String type (like HTTP
     * parameters always do). <p> The params value can also be a componentID or component instance that provides a
     * method getValues() that returns an Object literal.  SmartClient components {@link
     * com.smartgwt.client.widgets.form.DynamicForm}, {@link com.smartgwt.client.widgets.form.ValuesManager} are two
     * such classes.  Lastly, you may specify the ID of a native form element (retreivable via getElementById()) and the
     * params will be populated from there.  If there is an error resolving your params directive, it will be logged to
     * the Developer Console. <p> Note: The params are submitted once per http transaction.  If you are using  {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue} to bundle multiple RPCRequests or DSRequests into a single HTTP
     * turnaround, the params from the various RPCRequests will be merged, with the later-queued transactions winning on
     * parameter name collisions.  A warning will be logged in the Developer Console if multiple RPCRequests specified
     * params.
     *
     * @param params params Default value is null
     */
    public void setParams(Map params) {
        setAttribute("params", params);
    }

    /**
     * HTTP headers to send, as a mapping Header name -> Header value, eg
     * { "Content-Type" : "text/xml" }
     * <p>
     * Valid with the xmlHttpRequest transport only.
     *
     * @param httpHeaders the http headers
     */
    public void setHttpHeaders(Map httpHeaders) {
        setAttribute("httpHeaders", httpHeaders);
    }

}



