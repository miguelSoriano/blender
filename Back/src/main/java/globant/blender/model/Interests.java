package globant.blender.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Interests {

	@Id 
	@GeneratedValue
	@Column(name="idInterests")
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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="InterestsCategories_idInterestsCategories")
	private InterestsCategory interestsCategory;
	
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

	public InterestsCategory getInterestsCategory() {
		return interestsCategory;
	}

	public void setInterestsCategory(InterestsCategory interestsCategory) {
		this.interestsCategory = interestsCategory;
	}
	
	
}
