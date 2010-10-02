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
 
package com.smartgwt.client.widgets.tree.events;

import com.smartgwt.client.event.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDataArrivedHandlers extends HasHandlers {
    /**
     * Notification method fired whenever this TreeGrid recieves new data nodes from the &#010 dataSource. Only applies to databound TreeGrids where {@link com.smartgwt.client.widgets.tree.TreeGrid#getData data} is a &#010 {@link com.smartgwt.client..ResultTree} - either explicitly created and applied via {@link com.smartgwt.client.widgets.tree.TreeGrid#setData} or&#010 automatically generated via a {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} call.&#010
     *
     * @param handler the dataArrived handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    HandlerRegistration addDataArrivedHandler(DataArrivedHandler handler);
}