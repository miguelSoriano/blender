package globant.blender.dto;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import globant.blender.model.CohabitationCategory;
import globant.blender.model.EventStatus;
import globant.blender.model.EventsCategory;
import globant.blender.model.Location;
import globant.blender.model.SocialEvent;
import globant.blender.model.User;

@ApiObject
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id"
})
public class SocialEventsDTO extends AbstractDTO{

	@ApiObjectField(name="id")
	@JsonProperty("id")
	private int id;
	
	@ApiObjectField(name="title")
	@JsonProperty("title")
	private String title;

	@ApiObjectField(name="description")
	@JsonProperty("description")
	private String description;

	@ApiObjectField(name="date")
	@JsonProperty("date")
	private String date;
	
	@ApiObjectField(name="hour")
	@JsonProperty("hour")
	private String hour;
	
	@ApiObjectField(name="location")
	@JsonProperty("location")
	private LocationDTO location;
	
	private CohabitationCategory cohabitationCategory;

	private EventsCategory eventsCategory;	

	private EventStatus eventStatus;
	
	private List<User> users;
	
	public SocialEventsDTO(){
		
	}
	
	public SocialEventsDTO(SocialEvent socialEvents){
		this.title = socialEvents.getTitle();
		
		LocationDTO location = new LocationDTO();
		location.setDescription(description);
		location.setTitle(socialEvents.getLocation().getTitle());
		
		this.location = location;
		
		this.id = socialEvents.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public CohabitationCategory getCohabitationCategory() {
		return cohabitationCategory;
	}

	public void setCohabitationCategory(CohabitationCategory cohabitationCategory) {
		this.cohabitationCategory = cohabitationCategory;
	}

	public EventsCategory getEventsCategory() {
		return eventsCategory;
	}

	public void setEventsCategory(EventsCategory eventsCategory) {
		this.eventsCategory = eventsCategory;
	}

	public EventStatus getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
