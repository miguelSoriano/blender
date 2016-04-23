package globant.blender.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SocialEvents")
public class SocialEvent {

	@Id 
	@GeneratedValue
	@Column(name="idSocialEvents")
	private int id;
	
	@Column(name="title")	
	private String title;
	
	@Column(name="description")	
	private String description;
	
	@Column(name="createdDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="updatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Locations_idLocations")
	private Location location;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CohabitationCategories_idCohabitationCategories")
	private CohabitationCategory cohabitationCategory;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EventsCategories_idEventsCategories")
	private EventsCategory eventsCategory;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EventStatuses_idEventStatuses")
	private EventStatus eventStatus;
	
	@ManyToMany(targetEntity = User.class)
	@JoinTable(
	      name="SocialEventsUsers",
	      joinColumns=@JoinColumn(name="SocialEvents_idSocialEvents", referencedColumnName="idSocialEvents"),
	      inverseJoinColumns=@JoinColumn(name="Users_idUsers", referencedColumnName="idUsers"))
	private Set<User> users;
	
	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}	
}
