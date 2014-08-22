package com.smartgwt.sample.showcase.client.calendar;

import java.util.Date;

import com.smartgwt.client.widgets.Canvas;
import java.util.Date;

import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.calendar.HeaderLevel;
import com.smartgwt.client.widgets.calendar.Timeline;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.TimelineData;
import com.smartgwt.sample.showcase.client.data.TimelineLaneData;

public class TimelineFilteringSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example shows how individual events, " +
            "lanes and even date-columns can be filtered out of the Timeline at runtime.  " +
            "Select the checkboxes, or enter a string into the text-boxes below to see the " +
            "view reconstructed accordingly.</p>";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            TimelineFilteringSample panel = new TimelineFilteringSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Timeline calendar = new Timeline();
	public FormItem eventItem;
	public FormItem laneItem;
	public FormItem hideUnusedLanesItem;
	public FormItem hideWednesdaysItem;
	public FormItem hideWeekendsItem;

    public Canvas getViewPanel() {
		VLayout layout = new VLayout();
		layout.setWidth100();
		layout.setHeight100();

		layout.addMember(getToolStrip());
		
        HeaderLevel[] headerLevels = new HeaderLevel[]{
            new HeaderLevel(TimeUnit.WEEK), 
            new HeaderLevel(TimeUnit.DAY)
        };
        
        ListGridField[] laneFields = new ListGridField[]{
            new ListGridField("title", "Developer", 120)
        };
        
        calendar.setHeight(451);
        calendar.setStartDate(new Date(112, 5, 2));
        calendar.setEndDate(new Date(112, 5, 22));
        calendar.setCanEditLane(true);
        calendar.setShowEventDescriptions(false);
        calendar.setEventSnapGap(1); // snap to 1 minute intervals
        calendar.setLaneEventPadding(2); // add a little space around events
        // set up the grid 
        calendar.setHeaderLevels(headerLevels);
        calendar.setLanes(TimelineLaneData.getRecords());
        calendar.setLaneFields(laneFields);
        calendar.setData(TimelineData.getRecords());

        // install some customizers
        /*
        calendar.setShowDateCustomizer(new ShowDateCustomizer() {
			@Override
			public boolean showDate(Date date, CalendarView calendarView) {
				if (date == null) return false;
		        Boolean hideWednesdays = !(Boolean)hideWednesdaysItem.getValue();
		        if (hideWednesdays && date.getDay() == 3) return false;
				return true;
			}
		});
		*/
        
        /*
        calendar.setShowEventCustomizer(new ShowEventCustomizer() {
			@Override
			public boolean showEvent(CalendarEvent event, CalendarView calendarView) {
		        String text = (String)eventItem.getValue();
		        if (event != null && text != "") {
		        	String eventName = event.getName();
		            if (!eventName.toLowerCase().contains(text.toLowerCase())) {
		                return false;
		            }
		        }
		        return true;
		        //return this.Super("shouldShowLane");
			}
		});
		*/
        
        /*
        calendar.setShowLaneCustomizer(new ShowLaneCustomizer() {
			@Override
			public boolean showLane(Lane lane, CalendarView calendarView) {
		        String text = (String)laneItem.getValue();
		        if (lane != null && text != "") {
		        	String laneName = lane.getName();
		            if (!laneName.toLowerCase().contains(text.toLowerCase())) {
		                return false;
		            }
		        }
		        return true;
		        //return this.Super("shouldShowLane");
			}
		});
		*/
        
        layout.addMember(calendar);
        
        return layout;
	}
	
	public ToolStrip getToolStrip() {
		ToolStrip toolStrip = new ToolStrip();
    	
        ChangedHandler defaultChangedHandler = new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				rebuildTimeline();
			}
		};
        
    	eventItem = new FormItem("eventItem");
    	eventItem.setTitle("Filter by Event Name");
    	eventItem.setTitleOrientation(TitleOrientation.TOP);
    	eventItem.setChangeOnKeypress(false);
    	eventItem.addChangedHandler(defaultChangedHandler);
    	
    	laneItem = new FormItem("laneItem");
    	laneItem.setTitle("Filter by Lane Name");
    	laneItem.setTitleOrientation(TitleOrientation.TOP);
    	laneItem.setChangeOnKeypress(false);
    	laneItem.addChangedHandler(defaultChangedHandler);
    	
    	hideUnusedLanesItem = new FormItem("hideUnusedLanesItem");
    	hideUnusedLanesItem.setTitle("Hide Unused Lanes");
    	hideUnusedLanesItem.setType("boolean");
    	hideUnusedLanesItem.setTitleOrientation(TitleOrientation.TOP);
    	hideUnusedLanesItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				calendar.setHideUnusedLanes((Boolean)event.getValue());
				rebuildTimeline();
			}
		});

    	hideWednesdaysItem = new FormItem("hideWednesdaysItem");
    	hideWednesdaysItem.setTitle("Hide Wednesdays");
    	hideWednesdaysItem.setType("boolean");
    	hideWednesdaysItem.setTitleOrientation(TitleOrientation.TOP);
    	hideWednesdaysItem.addChangedHandler(defaultChangedHandler);

    	hideWeekendsItem = new FormItem("hideWednesdaysItem");
    	hideWeekendsItem.setTitle("Hide Wednesdays");
    	hideWeekendsItem.setType("boolean");
    	hideWeekendsItem.setTitleOrientation(TitleOrientation.TOP);
    	hideWeekendsItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				calendar.setShowWeekends(!(Boolean)event.getValue());
				rebuildTimeline();
			}
		});

    	toolStrip.addFormItem(eventItem);
    	toolStrip.addFormItem(laneItem);
    	toolStrip.addFormItem(hideUnusedLanesItem);
    	toolStrip.addFormItem(hideWednesdaysItem);
    	toolStrip.addFormItem(hideWeekendsItem);

		return toolStrip;
	}
    public void rebuildTimeline() {
    	calendar.getSelectedView().rebuild();
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}