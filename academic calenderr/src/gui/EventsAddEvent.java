package gui;

import java.util.EventObject;

public class EventsAddEvent extends EventObject{
	private String event;
	private String date;
	private String time;
	private String type;

	public EventsAddEvent(Object source,String event,String date,String time,String type) {
		super(source);
		this.event=event;
		this.date=date;
		this.time=time;
		this.type=type;
	}

	public String getEvent() {
		return this.event;
	}

	public String getDate( ) {
		return this.date;
	}

	public String getTime( ) {
		return this.time ;
	}

	public String getType() {
		return this.type;
	}
	
}
