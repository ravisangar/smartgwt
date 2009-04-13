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
 
package com.smartgwt.client.widgets.tree;



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
    * The SmartClient system supports hierarchical data (also referred to as tree data due to its "branching" organization) with: <ul>   <li> the {@link com.smartgwt.client.widgets.tree.Tree} class, which manipulates hierarchical data sets   <li> the TreeGrid widget class, which extends the ListGrid class to visually        present tree data in an expandable/collapsible format. </ul> For information on DataBinding Trees, see ${isc.DocUtils.linkForRef('group:treeDataBinding')}. <p> A TreeGrid works just like a {@link com.smartgwt.client.widgets.grid.ListGrid}, except one column (specified by {@link com.smartgwt.client.widgets.tree.TreeGridField#getTreeField treeField} shows a heirarchical {@link com.smartgwt.client.widgets.tree.Tree}.  A TreeGrid is not limited to displaying just the {@link com.smartgwt.client.widgets.tree.Tree} column - you can define additional columns (via {@link com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}) which will render just like the columns of a {@link com.smartgwt.client.widgets.grid.ListGrid}, and support all of the functionality of ListGrid columns, such as {@link com.smartgwt.client.widgets.grid.ListGridField#formatCellValue}. <p> Except where explicitly overridden, {@link com.smartgwt.client.widgets.grid.ListGrid} methods, callbacks, and properties apply to TreeGrids as well.  The {@link com.smartgwt.client.widgets.grid.ListGrid} defines some methods as taking/returning ${isc.DocUtils.linkForRef('object:ListGridField')} and ${isc.DocUtils.linkForRef('object:ListGridRecord')}.  When using those methods in a TreeGrid, those types will be ${isc.DocUtils.linkForRef('object:TreeGridField')} and ${isc.DocUtils.linkForRef('object:TreeNode')}, respectively.

    */









public class TreeGrid extends ListGrid  implements DataBoundComponent, com.smartgwt.client.widgets.tree.events.HasDataArrivedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderOpenedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderClosedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderClickHandlers, com.smartgwt.client.widgets.tree.events.HasLeafClickHandlers, com.smartgwt.client.widgets.tree.events.HasNodeClickHandlers, com.smartgwt.client.widgets.tree.events.HasFolderContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasLeafContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasNodeContextClickHandlers {

    public static TreeGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TreeGrid) obj;
        } else {
            return new TreeGrid(jsObj);
        }
    }


    public TreeGrid(){
        
    }

    public TreeGrid(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.TreeGrid.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * If true, when folders are opened / closed children will be animated into view.
    *
    * @param animateFolders animateFolders Default value is true
    */
    public void setAnimateFolders(Boolean animateFolders) {
        setAttribute("animateFolders", animateFolders, true);
    }
    /**
     * If true, when folders are opened / closed children will be animated into view.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAnimateFolders()  {
        return getAttributeAsBoolean("animateFolders");
    }

    /**
    * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed animateFolderSpeed} is not set, this property designates the duration of the animation in ms.
    *
    * @param animateFolderTime animateFolderTime Default value is 100
    */
    public void setAnimateFolderTime(int animateFolderTime) {
        setAttribute("animateFolderTime", animateFolderTime, true);
    }
    /**
     * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed animateFolderSpeed} is not set, this property designates the duration of the animation in ms.
     *
     *
     * @return int
     *
     */
    public int getAnimateFolderTime()  {
        return getAttributeAsInt("animateFolderTime");
    }

    /**
    * When animating folder opening / closing, this property designates the speed of the animation in pixels shown (or hidden) per second. Takes presidence over the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime animateFolderTime} property, which allows the developer to specify a duration for the animation rather than a speed.
    *
    * @param animateFolderSpeed animateFolderSpeed Default value is 1000
    */
    public void setAnimateFolderSpeed(int animateFolderSpeed) {
        setAttribute("animateFolderSpeed", animateFolderSpeed, true);
    }
    /**
     * When animating folder opening / closing, this property designates the speed of the animation in pixels shown (or hidden) per second. Takes presidence over the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime animateFolderTime} property, which allows the developer to specify a duration for the animation rather than a speed.
     *
     *
     * @return int
     *
     */
    public int getAnimateFolderSpeed()  {
        return getAttributeAsInt("animateFolderSpeed");
    }
             
    /**
    * When animating folder opening / closing, this property can be set to apply an animated acceleration effect.designates the speed of the animation in pixels shown (or hidden) per second.
    *
    * @param animateFolderEffect animateFolderEffect Default value is null
    */
    public void setAnimateFolderEffect(AnimationAcceleration animateFolderEffect) {
        setAttribute("animateFolderEffect", animateFolderEffect.getValue(), true);
    }
    /**
     * When animating folder opening / closing, this property can be set to apply an animated acceleration effect.designates the speed of the animation in pixels shown (or hidden) per second.
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateFolderEffect()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateFolderEffect"));
    }
            
    /**
    * A {@link com.smartgwt.client.widgets.tree.Tree} object containing of nested ${isc.DocUtils.linkForRef('object:TreeNode')}s to  display as rows in this TreeGrid.   The <code>data</code> property will typically not be explicitly specified for  databound TreeGrids, where the data is returned from the server via databound component methods such as <code>fetchData()</code>
    * Set the {@link com.smartgwt.client.widgets.tree.Tree} object this TreeGrid will view and manipulate.
    *
    * @param data Tree to show. Default value is null
    */
    public void setData(Tree data) {
        setAttribute("data", data.getOrCreateJsObj(), true);
    }
    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object containing of nested ${isc.DocUtils.linkForRef('object:TreeNode')}s to  display as rows in this TreeGrid.   The <code>data</code> property will typically not be explicitly specified for  databound TreeGrids, where the data is returned from the server via databound component methods such as <code>fetchData()</code>
     *
     *
     * @return Tree
     *
     */
    public Tree getData()  {
            return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }

    /**
    * For databound treeGrid instances, should the entire tree of data be loaded on initial  fetch, or should folders load their children as they are opened. <P> If unset the default {@link com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand} setting will be used. <P> Note that when using <code>loadDataOnDemand</code>, every node returned by the server is assumed be a folder which may load further children.  See {@link com.smartgwt.client..ResultTree#getDefaultIsFolder defaultIsFolder} for how to control this behavior.
    *
    * @param loadDataOnDemand loadDataOnDemand Default value is null
    */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand) {
        setAttribute("loadDataOnDemand", loadDataOnDemand, true);
    }
    /**
     * For databound treeGrid instances, should the entire tree of data be loaded on initial  fetch, or should folders load their children as they are opened. <P> If unset the default {@link com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand} setting will be used. <P> Note that when using <code>loadDataOnDemand</code>, every node returned by the server is assumed be a folder which may load further children.  See {@link com.smartgwt.client..ResultTree#getDefaultIsFolder defaultIsFolder} for how to control this behavior.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }

    /**
    * Visible title for the tree column (field).
    *
    * @param treeFieldTitle treeFieldTitle Default value is "Name"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTreeFieldTitle(String treeFieldTitle)  throws IllegalStateException {
        setAttribute("treeFieldTitle", treeFieldTitle, false);
    }
    /**
     * Visible title for the tree column (field).
     *
     *
     * @return String
     *
     */
    public String getTreeFieldTitle()  {
        return getAttributeAsString("treeFieldTitle");
    }

    /**
    * Specifies whether the root node should be displayed in the treeGrid. <P> This property is only available for "children" modelType trees, hence is not allowed for trees that load data from the server dynamically via {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData}.   <P> To get the equivalent of a visible "root" node in a tree that loads data dynamically, add a singular, top-level parent to the data.  However, note that this top-level parent will technically be the only child of root, and the implicit root object will be returned by {@link com.smartgwt.client.widgets.tree.Tree#getRoot}.
    *
    * @param showRoot showRoot Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowRoot(Boolean showRoot)  throws IllegalStateException {
        setAttribute("showRoot", showRoot, false);
    }
    /**
     * Specifies whether the root node should be displayed in the treeGrid. <P> This property is only available for "children" modelType trees, hence is not allowed for trees that load data from the server dynamically via {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData}.   <P> To get the equivalent of a visible "root" node in a tree that loads data dynamically, add a singular, top-level parent to the data.  However, note that this top-level parent will technically be the only child of root, and the implicit root object will be returned by {@link com.smartgwt.client.widgets.tree.Tree#getRoot}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRoot()  {
        return getAttributeAsBoolean("showRoot");
    }

    /**
    * Specifies whether folders and leaves should be segregated in the treeGrid display.          With separateFolders:true and sortDirection:"descending", folders are displayed          before their sibling leaves; with sortDirection:"ascending", leaves are displayed          before their sibling folders.
    *
    * @param separateFolders separateFolders Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSeparateFolders(Boolean separateFolders)  throws IllegalStateException {
        setAttribute("separateFolders", separateFolders, false);
    }
    /**
     * Specifies whether folders and leaves should be segregated in the treeGrid display.          With separateFolders:true and sortDirection:"descending", folders are displayed          before their sibling leaves; with sortDirection:"ascending", leaves are displayed          before their sibling folders.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSeparateFolders()  {
        return getAttributeAsBoolean("separateFolders");
    }
             
    /**
    * Specifies the type of nodes displayed in the treeGrid.
    *
    * @param displayNodeType displayNodeType Default value is Tree.FOLDERS_AND_LEAVES
    */
    public void setDisplayNodeType(DisplayNodeType displayNodeType) {
        setAttribute("displayNodeType", displayNodeType.getValue(), true);
    }
    /**
     * Specifies the type of nodes displayed in the treeGrid.
     *
     *
     * @return DisplayNodeType
     *
     */
    public DisplayNodeType getDisplayNodeType()  {
        return (DisplayNodeType) EnumUtil.getEnum(DisplayNodeType.values(), getAttribute("displayNodeType"));
    }

    /**
    * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
    *
    * @param canDragRecordsOut canDragRecordsOut Default value is false
    */
    public void setCanDragRecordsOut(Boolean canDragRecordsOut) {
        setAttribute("canDragRecordsOut", canDragRecordsOut, true);
    }
    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragRecordsOut()  {
        return getAttributeAsBoolean("canDragRecordsOut");
    }

    /**
    * Indicates whether records can be dropped into this listGrid.
    *
    * @param canAcceptDroppedRecords canAcceptDroppedRecords Default value is false
    */
    public void setCanAcceptDroppedRecords(Boolean canAcceptDroppedRecords) {
        setAttribute("canAcceptDroppedRecords", canAcceptDroppedRecords, true);
    }
    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDroppedRecords()  {
        return getAttributeAsBoolean("canAcceptDroppedRecords");
    }

    /**
    * Indicates whether records can be reordered by dragging within this listGrid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canReorderRecords canReorderRecords Default value is false
    */
    public void setCanReorderRecords(Boolean canReorderRecords) {
        setAttribute("canReorderRecords", canReorderRecords, true);
    }
    /**
     * Indicates whether records can be reordered by dragging within this listGrid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReorderRecords()  {
        return getAttributeAsBoolean("canReorderRecords");
    }

    /**
    * Whether drops are allowed on leaf nodes. <P> Dropping is ordinarily not allowed on leaf nodes unless {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is set.   <P> The default action for a drop on a leaf node is to place the node in that leaf's parent folder.  This can be customized by overriding {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDropOnLeaves canDropOnLeaves Default value is false
    */
    public void setCanDropOnLeaves(Boolean canDropOnLeaves) {
        setAttribute("canDropOnLeaves", canDropOnLeaves, true);
    }
    /**
     * Whether drops are allowed on leaf nodes. <P> Dropping is ordinarily not allowed on leaf nodes unless {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is set.   <P> The default action for a drop on a leaf node is to place the node in that leaf's parent folder.  This can be customized by overriding {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDropOnLeaves()  {
        return getAttributeAsBoolean("canDropOnLeaves");
    }

    /**
    * If set this property allows the user to reparent nodes by dragging them from their current folder to a new folder.<br> <b>Backcompat:</b> For backwards compatibility with versions prior to SmartClient 1.5, if this property is unset, but <code>this.canAcceptDroppedRecords</code> is true, we allow nodes to be dragged to different folders.
    *
    * @param canReparentNodes canReparentNodes Default value is null
    */
    public void setCanReparentNodes(Boolean canReparentNodes) {
        setAttribute("canReparentNodes", canReparentNodes, true);
    }
    /**
     * If set this property allows the user to reparent nodes by dragging them from their current folder to a new folder.<br> <b>Backcompat:</b> For backwards compatibility with versions prior to SmartClient 1.5, if this property is unset, but <code>this.canAcceptDroppedRecords</code> is true, we allow nodes to be dragged to different folders.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReparentNodes()  {
        return getAttributeAsBoolean("canReparentNodes");
    }
             
    /**
    * Specifies what to do with data dragged from this TreeGrid (into another component, or another node in this TreeGrid.  The default action is to move the data.  A setting of "none" is not recommended for trees because Trees maintain the node open state on the nodes themselves, and hence having multiple Tree objects share a reference to a node can have unintended consequences (such as opening a folder in one tree also triggering an open in another tree that shares the same node). <br><br> For DataBound trees ({@link com.smartgwt.client..ResultTree}), the expectation is that {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop} will be overridden to perform whatever action took place as the result of the drag and drop interaction.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragDataAction dragDataAction Default value is ListGrid.MOVE
    */
    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }
    /**
     * Specifies what to do with data dragged from this TreeGrid (into another component, or another node in this TreeGrid.  The default action is to move the data.  A setting of "none" is not recommended for trees because Trees maintain the node open state on the nodes themselves, and hence having multiple Tree objects share a reference to a node can have unintended consequences (such as opening a folder in one tree also triggering an open in another tree that shares the same node). <br><br> For DataBound trees ({@link com.smartgwt.client..ResultTree}), the expectation is that {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop} will be overridden to perform whatever action took place as the result of the drag and drop interaction.
     *
     *
     * @return DragDataAction
     *
     */
    public DragDataAction getDragDataAction()  {
        return (DragDataAction) EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    /**
    * Message displayed when user attempts to drag a node into a parent that already contains a child of the same name.
    *
    * @param parentAlreadyContainsChildMessage parentAlreadyContainsChildMessage Default value is "This item already contains a child item with that name."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setParentAlreadyContainsChildMessage(String parentAlreadyContainsChildMessage)  throws IllegalStateException {
        setAttribute("parentAlreadyContainsChildMessage", parentAlreadyContainsChildMessage, false);
    }
    /**
     * Message displayed when user attempts to drag a node into a parent that already contains a child of the same name.
     *
     *
     * @return String
     *
     */
    public String getParentAlreadyContainsChildMessage()  {
        return getAttributeAsString("parentAlreadyContainsChildMessage");
    }

    /**
    * Message displayed when user attempts to drop a dragged node onto itself.
    *
    * @param cantDragIntoSelfMessage cantDragIntoSelfMessage Default value is "You can't drag an item into itself."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCantDragIntoSelfMessage(String cantDragIntoSelfMessage)  throws IllegalStateException {
        setAttribute("cantDragIntoSelfMessage", cantDragIntoSelfMessage, false);
    }
    /**
     * Message displayed when user attempts to drop a dragged node onto itself.
     *
     *
     * @return String
     *
     */
    public String getCantDragIntoSelfMessage()  {
        return getAttributeAsString("cantDragIntoSelfMessage");
    }

    /**
    * Message displayed when user attempts to drop a node into a child of itself.
    *
    * @param cantDragIntoChildMessage cantDragIntoChildMessage Default value is "You can't drag an item into one of it's children."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCantDragIntoChildMessage(String cantDragIntoChildMessage)  throws IllegalStateException {
        setAttribute("cantDragIntoChildMessage", cantDragIntoChildMessage, false);
    }
    /**
     * Message displayed when user attempts to drop a node into a child of itself.
     *
     *
     * @return String
     *
     */
    public String getCantDragIntoChildMessage()  {
        return getAttributeAsString("cantDragIntoChildMessage");
    }

    /**
    * The amount of indentation (in pixels) to add to a node's icon/title for each level          down in this tree's hierarchy.
    *
    * @param indentSize indentSize Default value is 20
    */
    public void setIndentSize(int indentSize) {
        setAttribute("indentSize", indentSize, true);
    }
    /**
     * The amount of indentation (in pixels) to add to a node's icon/title for each level          down in this tree's hierarchy.
     *
     *
     * @return int
     *
     */
    public int getIndentSize()  {
        return getAttributeAsInt("indentSize");
    }

    /**
    * The standard size (same height and width, in pixels) of node icons in this          treeGrid.
    *
    * @param iconSize iconSize Default value is 16
    */
    public void setIconSize(int iconSize) {
        setAttribute("iconSize", iconSize, true);
    }
    /**
     * The standard size (same height and width, in pixels) of node icons in this          treeGrid.
     *
     *
     * @return int
     *
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
    * Width and height in pixels of the opener icons, that is, the icons which show the open or closed state of the node, typically a [+] or [-] symbol. <P> If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, the opener icon includes the connector line, and defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight}. <P> Otherwise, <code>openerIconSize</code> defaults to {@link com.smartgwt.client.widgets.tree.TreeGrid#getIconSize iconSize}.
    *
    * @param openerIconSize openerIconSize Default value is null
    */
    public void setOpenerIconSize(Integer openerIconSize) {
        setAttribute("openerIconSize", openerIconSize, true);
    }
    /**
     * Width and height in pixels of the opener icons, that is, the icons which show the open or closed state of the node, typically a [+] or [-] symbol. <P> If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, the opener icon includes the connector line, and defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight}. <P> Otherwise, <code>openerIconSize</code> defaults to {@link com.smartgwt.client.widgets.tree.TreeGrid#getIconSize iconSize}.
     *
     *
     * @return Integer
     *
     */
    public Integer getOpenerIconSize()  {
        return getAttributeAsInt("openerIconSize");
    }

    /**
    * The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will have {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} or  {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} appended to indicate state changes if appropriate -  see documentation on  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}.
    *
    * @param folderIcon folderIcon Default value is "[SKIN]folder.gif"
    */
    public void setFolderIcon(String folderIcon) {
        setAttribute("folderIcon", folderIcon, true);
    }
    /**
     * The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will have {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} or  {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} appended to indicate state changes if appropriate -  see documentation on  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}.
     *
     *
     * @return String
     *
     */
    public String getFolderIcon()  {
        return getAttributeAsString("folderIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user drop-hovers over some folder.
    *
    * @param dropIconSuffix dropIconSuffix Default value is "drop"
    */
    public void setDropIconSuffix(String dropIconSuffix) {
        setAttribute("dropIconSuffix", dropIconSuffix, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user drop-hovers over some folder.
     *
     *
     * @return String
     *
     */
    public String getDropIconSuffix()  {
        return getAttributeAsString("dropIconSuffix");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is true, this suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for open folders in this grid.
    *
    * @param openIconSuffix openIconSuffix Default value is "open"
    */
    public void setOpenIconSuffix(String openIconSuffix) {
        setAttribute("openIconSuffix", openIconSuffix, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is true, this suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for open folders in this grid.
     *
     *
     * @return String
     *
     */
    public String getOpenIconSuffix()  {
        return getAttributeAsString("openIconSuffix");
    }

    /**
    * This suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for closed folders. If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is set to <code>false</code> this suffix will also be appended to open folders' icons.
    *
    * @param closedIconSuffix closedIconSuffix Default value is "closed"
    */
    public void setClosedIconSuffix(String closedIconSuffix) {
        setAttribute("closedIconSuffix", closedIconSuffix, true);
    }
    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for closed folders. If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is set to <code>false</code> this suffix will also be appended to open folders' icons.
     *
     *
     * @return String
     *
     */
    public String getClosedIconSuffix()  {
        return getAttributeAsString("closedIconSuffix");
    }

    /**
    * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} directly on the node.
    * Set the icon for a particular treenode to a specified URL
    *
    * @param nodeIcon tree node. Default value is "[SKIN]file.gif"
    */
    public void setNodeIcon(String nodeIcon) {
        setAttribute("nodeIcon", nodeIcon, true);
    }
    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} directly on the node.
     *
     *
     * @return String
     *
     */
    public String getNodeIcon()  {
        return getAttributeAsString("nodeIcon");
    }

    /**
    * If true, show a different icon for <code>open</code> folders than closed folders. This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} onto the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be  replaced by <code>"[SKIN]/folder_open.gif"</code>.<br> <b>Note</b> If this property is set to <code>false</code> the same icon is shown for open folders as for closed folders, unless a custom folder icon was specified. This will be determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} plus the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix}.
    *
    * @param showOpenIcons showOpenIcons Default value is true
    */
    public void setShowOpenIcons(Boolean showOpenIcons) {
        setAttribute("showOpenIcons", showOpenIcons, true);
    }
    /**
     * If true, show a different icon for <code>open</code> folders than closed folders. This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} onto the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be  replaced by <code>"[SKIN]/folder_open.gif"</code>.<br> <b>Note</b> If this property is set to <code>false</code> the same icon is shown for open folders as for closed folders, unless a custom folder icon was specified. This will be determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} plus the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowOpenIcons()  {
        return getAttributeAsBoolean("showOpenIcons");
    }

    /**
    * If true, when the user drags a droppable target over a folder in this TreeGrid, show  a different icon folder icon. This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} onto the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for example <code>"[SKIN]/folder.gif"</code> may be replaced by <code>"[SKIN]/folder_drop.gif"</code>).
    *
    * @param showDropIcons showDropIcons Default value is true
    */
    public void setShowDropIcons(Boolean showDropIcons) {
        setAttribute("showDropIcons", showDropIcons, true);
    }
    /**
     * If true, when the user drags a droppable target over a folder in this TreeGrid, show  a different icon folder icon. This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} onto the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for example <code>"[SKIN]/folder.gif"</code> may be replaced by <code>"[SKIN]/folder_drop.gif"</code>).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDropIcons()  {
        return getAttributeAsBoolean("showDropIcons");
    }

    /**
    * This property allows the developer to customize the icon displayed next to a node. Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and it will be shown instead of the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon} for this node.<br> Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen showCustomIconOpen} and/or {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop showCustomIconDrop}  is true for this grid, customized icons for folder nodes will be appended with the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} suffixes on state change  as with the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for this treeGrid.  Also note that for custom folder icons, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} will never be appened.
    *
    * @param customIconProperty customIconProperty Default value is "icon"
    */
    public void setCustomIconProperty(String customIconProperty) {
        setAttribute("customIconProperty", customIconProperty, true);
    }
    /**
     * This property allows the developer to customize the icon displayed next to a node. Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and it will be shown instead of the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon} for this node.<br> Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen showCustomIconOpen} and/or {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop showCustomIconDrop}  is true for this grid, customized icons for folder nodes will be appended with the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} suffixes on state change  as with the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for this treeGrid.  Also note that for custom folder icons, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} will never be appened.
     *
     *
     * @return String
     *
     */
    public String getCustomIconProperty()  {
        return getAttributeAsString("customIconProperty");
    }

    /**
    * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show open state images when the folder is opened. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} will be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with  <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} is never appended to custom folder icons.<br> Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty} property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showCustomIconOpen showCustomIconOpen Default value is false
    */
    public void setShowCustomIconOpen(Boolean showCustomIconOpen) {
        setAttribute("showCustomIconOpen", showCustomIconOpen, true);
    }
    /**
     * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show open state images when the folder is opened. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} will be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with  <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} is never appended to custom folder icons.<br> Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty} property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowCustomIconOpen()  {
        return getAttributeAsBoolean("showCustomIconOpen");
    }

    /**
    * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show drop state images when the user is drop-hovering over the folder. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} will be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with  <code>"customFolder_drop.gif"</code>).<br> Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty customIconDropProperty} property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showCustomIconDrop showCustomIconDrop Default value is false
    */
    public void setShowCustomIconDrop(Boolean showCustomIconDrop) {
        setAttribute("showCustomIconDrop", showCustomIconDrop, true);
    }
    /**
     * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), show drop state images when the user is drop-hovering over the folder. If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} will be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with  <code>"customFolder_drop.gif"</code>).<br> Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty customIconDropProperty} property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowCustomIconDrop()  {
        return getAttributeAsBoolean("showCustomIconDrop");
    }

    /**
    * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), this property allows the developer to specify on a per-node basis whether a open state icon should be displayed when the folder is open. Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state icons, or false to suppress this.<br> If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code> for this node.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param customIconOpenProperty customIconOpenProperty Default value is "showOpenIcon"
    */
    public void setCustomIconOpenProperty(String customIconOpenProperty) {
        setAttribute("customIconOpenProperty", customIconOpenProperty, true);
    }
    /**
     * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), this property allows the developer to specify on a per-node basis whether a open state icon should be displayed when the folder is open. Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state icons, or false to suppress this.<br> If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code> for this node.
     *
     *
     * @return String
     *
     */
    public String getCustomIconOpenProperty()  {
        return getAttributeAsString("customIconOpenProperty");
    }

    /**
    * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), this property allows the developer to specify on a per-node basis whether a drop state icon (with {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix}) should be displayed when the  user drop-hovers over this folder.<br> Set <code>node[treeGrid.customIconDropProperty]</code> to true to show the drop state icons, or false to suppress this.<br> If not specified this this behavior is determined by <code>treeGrid.showCustomIconDrop</code> for this node.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param customIconDropProperty customIconDropProperty Default value is "showDropIcon"
    */
    public void setCustomIconDropProperty(String customIconDropProperty) {
        setAttribute("customIconDropProperty", customIconDropProperty, true);
    }
    /**
     * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}), this property allows the developer to specify on a per-node basis whether a drop state icon (with {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix}) should be displayed when the  user drop-hovers over this folder.<br> Set <code>node[treeGrid.customIconDropProperty]</code> to true to show the drop state icons, or false to suppress this.<br> If not specified this this behavior is determined by <code>treeGrid.showCustomIconDrop</code> for this node.
     *
     *
     * @return String
     *
     */
    public String getCustomIconDropProperty()  {
        return getAttributeAsString("customIconDropProperty");
    }

    /**
    * The filename of the icon displayed use as the default drag tracker when for multiple files and/or folders are being dragged.
    *
    * @param manyItemsImage manyItemsImage Default value is "[SKIN]folder_file.gif"
    */
    public void setManyItemsImage(String manyItemsImage) {
        setAttribute("manyItemsImage", manyItemsImage, true);
    }
    /**
     * The filename of the icon displayed use as the default drag tracker when for multiple files and/or folders are being dragged.
     *
     *
     * @return String
     *
     */
    public String getManyItemsImage()  {
        return getAttributeAsString("manyItemsImage");
    }

    /**
    * Should this treeGrid show connector lines illustrating the tree's hierachy? <P> For the set of images used to show connectors, see {@link com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}. <P> <b>Note</b>: in order for connector images to be perfectly connected, all styles for cells must have no top or bottom border or padding.  If you see small gaps in connector lines, check your CSS files.  See the example below for an example of correct configuration, including example CSS.
    *
    * @param showConnectors showConnectors Default value is false
    */
    public void setShowConnectors(Boolean showConnectors) {
        setAttribute("showConnectors", showConnectors, true);
    }
    /**
     * Should this treeGrid show connector lines illustrating the tree's hierachy? <P> For the set of images used to show connectors, see {@link com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}. <P> <b>Note</b>: in order for connector images to be perfectly connected, all styles for cells must have no top or bottom border or padding.  If you see small gaps in connector lines, check your CSS files.  See the example below for an example of correct configuration, including example CSS.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowConnectors()  {
        return getAttributeAsBoolean("showConnectors");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, this property determines whether we should show showing vertical continuation lines for each level of indenting within the tree. Setting to false will show only the hierachy lines are only shown for the most indented path ("sparse" connectors).
    *
    * @param showFullConnectors showFullConnectors Default value is true
    */
    public void setShowFullConnectors(Boolean showFullConnectors) {
        setAttribute("showFullConnectors", showFullConnectors, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, this property determines whether we should show showing vertical continuation lines for each level of indenting within the tree. Setting to false will show only the hierachy lines are only shown for the most indented path ("sparse" connectors).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFullConnectors()  {
        return getAttributeAsBoolean("showFullConnectors");
    }

    /**
    * The base filename of the opener icon for the folder node when 'showConnectors' is false for this TreeGrid.<br> The opener icon is displayed beside the folder icon in the Tree column for folder nodes. Clicking on this icon will toggle the open state of the folder.<br> The filenames for these icons are assembled from this base filename and the state of the node, as follows:<br> If the openerImage is set to <code>{baseName}.{extension}</code>,  <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or if this page is in RTL mode, <code>{baseName}_opened_rtl.{extension}</code> and <code>{baseName}_closed_rtl.{extension}</code> will be used.
    *
    * @param openerImage openerImage Default value is "[SKIN]opener.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOpenerImage(String openerImage)  throws IllegalStateException {
        setAttribute("openerImage", openerImage, false);
    }
    /**
     * The base filename of the opener icon for the folder node when 'showConnectors' is false for this TreeGrid.<br> The opener icon is displayed beside the folder icon in the Tree column for folder nodes. Clicking on this icon will toggle the open state of the folder.<br> The filenames for these icons are assembled from this base filename and the state of the node, as follows:<br> If the openerImage is set to <code>{baseName}.{extension}</code>,  <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or if this page is in RTL mode, <code>{baseName}_opened_rtl.{extension}</code> and <code>{baseName}_closed_rtl.{extension}</code> will be used.
     *
     *
     * @return String
     *
     */
    public String getOpenerImage()  {
        return getAttributeAsString("openerImage");
    }

    /**
    * The base filename for connector icons shown when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true. Connector icons are rendered into the title field of each row and show the dotted hierarchy lines between siblings of the same parent node. For each node, a connector icon may be shown:<ul> <li>As an opener icon for folder nodes, next to the folder icon</li> <li>In place of an opener icon for leaf nodes, next to the leaf icon</li> <li>As a standalone vertical continuation line in the indent to the left of the node, to show     a connection between some ancestor node's siblings (only relevant if     {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true).</li> </ul> Note that {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} governs whether connector lines will be displayed for all indent levels, or just for the innermost level of the tree. <P> The filenames for these icons are assembled from this base filename and the state of the node.  Assuming the connectorImage is set to <code>{baseName}.{extension}</code>, the full set of images to be displayed will be: <P> <code>{baseName}_ancestor[_rtl].{extension}</code> if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors}  is true, this is the URL for the vertical continuation image to be displayed at the  appropriate indent levels for ancestor nodes with subsequent children. <P> For nodes with no children: <ul> <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is no connector line  attached to the parent or previous sibling, and no connector line to the next sibling. For  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} trees, there will always be a  connector leading to the parent or previous sibling if its present in the tree so this  icon can only be displayed for the first row.</li> <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector  line attached to the parent or previous sibling, but there is a connector to the next  sibling. As with <code>_single</code> this will only ever be used for the first row if  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true</li> <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a connector   line attached to the next sibling of this node (but are showing a connection to the previous  sibling or parent).</li> <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector  line leading to both the previous sibling (or parent) and the next sibling. </ul> For folders with children. Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is false, open folders will never show a connector to subsequent siblings: <ul> <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder node with   children when no connector line is shown attaching to either the folder's previous sibling  or parent, or to any subsequent siblings.</li> <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children  when the there is no connector line attached to the parent or previous sibling, but there   is a connector to the next sibling.</li> <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children   if we are not showing a connector line attached to the next sibling of this node (but are  showing a connection to the previous sibling or parent).</li> <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children   where the we have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> <ul> <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with   children when no connector line is shown attaching to either the folder's previous sibling  or parent, or to any subsequent siblings.</li> <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children  when the there is no connector line attached to the parent or previous sibling, but there   is a connector to the next sibling.</li> <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children   if we are not showing a connector line attached to the next sibling of this node (but are  showing a connection to the previous sibling or parent).</li> <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children   where the we have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> (Note '[_rtl]' means that "_rtl" will be attached if isRTL() is true for this widget).
    *
    * @param connectorImage connectorImage Default value is "[SKIN]connector.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setConnectorImage(String connectorImage)  throws IllegalStateException {
        setAttribute("connectorImage", connectorImage, false);
    }
    /**
     * The base filename for connector icons shown when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true. Connector icons are rendered into the title field of each row and show the dotted hierarchy lines between siblings of the same parent node. For each node, a connector icon may be shown:<ul> <li>As an opener icon for folder nodes, next to the folder icon</li> <li>In place of an opener icon for leaf nodes, next to the leaf icon</li> <li>As a standalone vertical continuation line in the indent to the left of the node, to show     a connection between some ancestor node's siblings (only relevant if     {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true).</li> </ul> Note that {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} governs whether connector lines will be displayed for all indent levels, or just for the innermost level of the tree. <P> The filenames for these icons are assembled from this base filename and the state of the node.  Assuming the connectorImage is set to <code>{baseName}.{extension}</code>, the full set of images to be displayed will be: <P> <code>{baseName}_ancestor[_rtl].{extension}</code> if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors}  is true, this is the URL for the vertical continuation image to be displayed at the  appropriate indent levels for ancestor nodes with subsequent children. <P> For nodes with no children: <ul> <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is no connector line  attached to the parent or previous sibling, and no connector line to the next sibling. For  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} trees, there will always be a  connector leading to the parent or previous sibling if its present in the tree so this  icon can only be displayed for the first row.</li> <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector  line attached to the parent or previous sibling, but there is a connector to the next  sibling. As with <code>_single</code> this will only ever be used for the first row if  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true</li> <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a connector   line attached to the next sibling of this node (but are showing a connection to the previous  sibling or parent).</li> <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector  line leading to both the previous sibling (or parent) and the next sibling. </ul> For folders with children. Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is false, open folders will never show a connector to subsequent siblings: <ul> <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder node with   children when no connector line is shown attaching to either the folder's previous sibling  or parent, or to any subsequent siblings.</li> <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children  when the there is no connector line attached to the parent or previous sibling, but there   is a connector to the next sibling.</li> <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children   if we are not showing a connector line attached to the next sibling of this node (but are  showing a connection to the previous sibling or parent).</li> <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children   where the we have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> <ul> <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with   children when no connector line is shown attaching to either the folder's previous sibling  or parent, or to any subsequent siblings.</li> <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children  when the there is no connector line attached to the parent or previous sibling, but there   is a connector to the next sibling.</li> <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children   if we are not showing a connector line attached to the next sibling of this node (but are  showing a connection to the previous sibling or parent).</li> <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children   where the we have a connector line leading to both the previous sibling (or parent) and the  next sibling. </ul> (Note '[_rtl]' means that "_rtl" will be attached if isRTL() is true for this widget).
     *
     *
     * @return String
     *
     */
    public String getConnectorImage()  {
        return getAttributeAsString("connectorImage");
    }

    // ********************* Methods ***********************













        /**
         * Overridden to disallow editing of the {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} field of this grid's data tree. Also disallows editing of the auto-generated tree field, which displays the result of {@link com.smartgwt.client.widgets.tree.Tree#getTitle} on the node.
         *
         * @return Whether to allow editing this cell
         */
        public native Boolean canEditCell() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.canEditCell();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Handle a doubleClick on a tree node - override of ListGrid stringMethod of same name.  If the node is a folder, this implementation calls {@link com.smartgwt.client.widgets.tree.TreeGrid#toggleFolder} on it.  If the node is a leaf, calls {@link com.smartgwt.client.widgets.tree.TreeGrid#openLeaf} on it.
         */
        public native void recordDoubleClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.recordDoubleClick();
        }-*/;




        /**
         * This method overrides {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop} and works as follows: <br><br> First, {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop} (the superclass definition) is consulted.  If it returns false, then this method returns false immediately.<br> This handles the following cases:<br> - reordering of records withing this TreeGrid when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords canReorderRecords} is true<br> - accepting dropped records from another dragTarget when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords}    is true and the dragTarget gives us a valid set of records to drop into place.<br> - disallowing drop over disabled nodes, or nodes with <code>canAcceptDrop:false</code> <br> This method will also return false if the drop occurred over a leaf node whos immediate  parent has <code>canAcceptDrop</code> set to <code>false</code><br> If {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is true, and the user is dragging a node from one folder to another, this method will return true to allow the change of parent folder.<br> <br><br> Otherwise this method returns true.
         *
         * @return true if this component will accept a drop of the dragData
         */
        public native Boolean willAcceptDrop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.willAcceptDrop();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Returns the row number of the most recent mouse event.
         *
         * @return row number, or -2 if beyond last drawn row
         */
        public native int getEventRow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventRow();
        }-*/;

        /**
         * Returns the row number of the most recent mouse event.
         * @param y optional y-coordinate to obtain row number, in lieue of the y                        coordinate of the last mouse event
         *
         * @return row number, or -2 if beyond last drawn row
         */
        public native int getEventRow(int y) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventRow(y);
        }-*/;





        /**
         * Get the appropriate open/close opener icon for a node.
         * @param node tree node in question
         *
         * @return URL for the icon to show the node's open state
         */
        public native String getOpenIcon(TreeNode node) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getOpenIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;

        /**
         * Get an additional icon to show between the open icon and folder/node icon for a particular  node.
         * @param node tree node in question
         *
         * @return URL for the extra icon (null if none required)
         */
        public native String getExtraIcon(TreeNode node) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getExtraIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;

        /**
         * Get the appropriate icon for a node. <P> By default icons are derived from {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon}. Custom icons for individual nodes can be overriden by setting the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} on a node. <p> If you want to suppress icons altogether, provide an override of this method that simply returns null. <p>  Note that the full icon URL will be derived by applying {@link com.smartgwt.client.widgets.Canvas#getImgURL} to the value returned from this method.
         * @param node tree node in question
         *
         * @return URL for icon to show for this node
         */
        public native String getIcon(TreeNode node) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;



        /**
         * Add a folderOpened handler.
         * <p>
         * This method is called when a folder is opened either via the user manipulating the expand/collapse control in the UI or via {@link com.smartgwt.client.widgets.tree.TreeGrid#openFolder}.  You can return <code>false</code> to cancel the open.
         *
         * @param handler the folderOpened handler
         */
        public HandlerRegistration addFolderOpenedHandler(com.smartgwt.client.widgets.tree.events.FolderOpenedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType()) == 0) setupFolderOpenedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType());
        }
        private native void setupFolderOpenedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderOpened:function(){
                        var param = {"node" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderOpenedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderOpened = function(){
                    var param = {"node" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderOpenedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;


        /**
         * Add a folderClosed handler.
         * <p>
         * This method is called when a folder is closed either via the user manipulating the expand/collapse control in the UI or via {@link com.smartgwt.client.widgets.tree.TreeGrid#closeFolder}.  You can return <code>false</code> to cancel the close.
         *
         * @param handler the folderClosed handler
         */
        public HandlerRegistration addFolderClosedHandler(com.smartgwt.client.widgets.tree.events.FolderClosedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType()) == 0) setupFolderClosedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType());
        }
        private native void setupFolderClosedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderClosed:function(){
                        var param = {"node" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderClosedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderClosed = function(){
                    var param = {"node" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderClosedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a folderClick handler.
         * <p>
         * This method is called when a folder record is clicked on.
         *
         * @param handler the folderClick handler
         */
        public HandlerRegistration addFolderClickHandler(com.smartgwt.client.widgets.tree.events.FolderClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType()) == 0) setupFolderClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType());
        }
        private native void setupFolderClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderClick:function(){
                        var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderClick = function(){
                    var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;




        /**
         * Add a leafClick handler.
         * <p>
         * This method is called when a leaf record is clicked on.
         *
         * @param handler the leafClick handler
         */
        public HandlerRegistration addLeafClickHandler(com.smartgwt.client.widgets.tree.events.LeafClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType()) == 0) setupLeafClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType());
        }
        private native void setupLeafClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({leafClick:function(){
                        var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.LeafClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.leafClick = function(){
                    var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.LeafClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;




        /**
         * Add a nodeClick handler.
         * <p>
         * This method is called when a leaf or folder record is clicked on.  Note that if you set up a callback for <code>nodeClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#leafClick}, then both will fire (in that order) if a leaf is clicked on.
         *
         * @param handler the nodeClick handler
         */
        public HandlerRegistration addNodeClickHandler(com.smartgwt.client.widgets.tree.events.NodeClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType()) == 0) setupNodeClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType());
        }
        private native void setupNodeClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({nodeClick:function(){
                        var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.NodeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.nodeClick = function(){
                    var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.NodeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;




        /**
         * Add a folderContextClick handler.
         * <p>
         * This method is called when a context click occurs on a folder record.
         *
         * @param handler the folderContextClick handler
         */
        public HandlerRegistration addFolderContextClickHandler(com.smartgwt.client.widgets.tree.events.FolderContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType()) == 0) setupFolderContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType());
        }
        private native void setupFolderContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderContextClick:function(){
                        var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderContextClick = function(){
                    var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a leafContextClick handler.
         * <p>
         * This method is called when a context click occurs on a leaf record.
         *
         * @param handler the leafContextClick handler
         */
        public HandlerRegistration addLeafContextClickHandler(com.smartgwt.client.widgets.tree.events.LeafContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType()) == 0) setupLeafContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType());
        }
        private native void setupLeafContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({leafContextClick:function(){
                        var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.LeafContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.leafContextClick = function(){
                    var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.LeafContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a nodeContextClick handler.
         * <p>
         * This method is called when a context click occurs on a leaf or folder record.  Note that if you set up a callback for <code>nodeContextClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#leafContextClick}, then both will fire (in that order) if a leaf is contextclicked - unless <code>nodeContextClick()</code> returns false, in which case no further contextClick callbacks will be called.
         *
         * @param handler the nodeContextClick handler
         */
        public HandlerRegistration addNodeContextClickHandler(com.smartgwt.client.widgets.tree.events.NodeContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType()) == 0) setupNodeContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType());
        }
        private native void setupNodeContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({nodeContextClick:function(){
                        var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.NodeContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.nodeContextClick = function(){
                    var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.NodeContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;


        /**
         * Add a dataArrived handler.
         * <p>
         * Notification method fired whenever this TreeGrid recieves new data nodes from the  dataSource. Only applies to databound TreeGrids where {@link com.smartgwt.client.widgets.tree.TreeGrid#getData data} is a  {@link com.smartgwt.client..ResultTree} - either explicitly created and applied via {@link com.smartgwt.client.widgets.tree.TreeGrid#setData} or automatically generated via a {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} call.
         *
         * @param handler the dataArrived handler
         */
        public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.tree.events.DataArrivedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType());
        }
        private native void setupDataArrivedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dataArrived:function(){
                        var param = {"parentNode" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tree.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dataArrived = function(){
                    var param = {"parentNode" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.tree.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************





    /**
     * An array of field objects, specifying the order, layout, dynamic calculation, and sorting behavior of each field
     * in the treeGrid object. In TreeGrids, the fields array specifies columns. Each field in the fields array is
     * TreeGridField object. <p> If {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataSource dataSource} is also
     * set, this value acts as a set of overrides as explained in {@link com.smartgwt.client..DataBoundComponent#getFields
     * fields}.
     *
     * @param fields fields Default value is null
     */
    public void setFields(TreeGridField... fields) {
        setAttribute("fields", fields, true);
    }

    /**
     * Synonmy for {#link #getData)
     *
     * @return the underlying tree
     */
    public Tree getTree() {
        return getData();
    }

    public ListGridRecord[] getRecords() {
        Tree tree = getData();
        return tree.getData();
    }
    
    /**
     * You can specify the initial set of data for a databound TreeGrid using this property. The value of this attribute
     * should be a list of <code>parentId</code> linked ${isc.DocUtils.linkForRef('object:TreeNode')}s in a format
     * equivalent to that documented on {@link com.smartgwt.client.widgets.tree.Tree#getData data}.
     * <p/>
     *
     * @param initialData initialData Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialData(TreeNode[] data) throws IllegalStateException {
        setAttribute("initialData", data, false);
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * ${isc.DocUtils.linkForRef('group:treeDataBinding')} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * ${isc.DocUtils.linkForRef('group:treeDataBinding')} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * ${isc.DocUtils.linkForRef('group:treeDataBinding')} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * ${isc.DocUtils.linkForRef('group:treeDataBinding')} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required; see                                          {@link
     *                 com.smartgwt.client..DataBoundComponent#fetchData} for details
     */
    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                              only if server contact was required; see
     *                          {@link com.smartgwt.client..DataBoundComponent#fetchData} for details
     * @param requestProperties for databound components only - optional                            additional
     *                          properties to set on the DSRequest that will be issued
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Return the first selected record in this component.<br><br> This method is appropriate if <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}</code> is <code>"single"</code>, or if you only care about the first selected record in a multiple-record selection. To access all selected records, use <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelection}</code> instead.
     *
     * @return first selected record, or null if nothing selected
     */
    public native ListGridRecord getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Return the pointer to a particular record by record number. Synonym for {@link com.smartgwt.client.widgets.grid.ListGrid#getCellRecord}.
     * @param recordNum row index of record to return.
     *
     * @return Record object for the row.
     */
    public native ListGridRecord getRecord(int recordNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(recordNum);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * For databound trees, use this attribute to supply a ${isc.DocUtils.linkForRef('ResultTree.rootValue')} for this component's generated data object. <P>  This property allows you to have a particular component navigate a tree starting from any given node as the root.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param treeRootValue treeRootValue Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTreeRootValue(String treeRootValue) throws IllegalStateException {
        setAttribute("treeRootValue", treeRootValue, false);
    }

    /**
     * For databound trees, use this attribute to supply a ${isc.DocUtils.linkForRef('ResultTree.rootValue')} for this component's generated data object. <P>  This property allows you to have a particular component navigate a tree starting from any given node as the root.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param treeRootValue treeRootValue Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTreeRootValue(Integer treeRootValue) throws IllegalStateException {
        setAttribute("treeRootValue", treeRootValue, false);
    }

    /**
     * For databound trees, use this attribute to supply a ${isc.DocUtils.linkForRef('ResultTree.rootValue')} for this component's generated data object. <P>  This property allows you to have a particular component navigate a tree starting from any given node as the root.
     *
     * @return tree root value as String
     */
    public String getTreeRootValue() {
        return getAttribute("treeRootValue");
    }

}



