package globant.blender.dto;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@ApiObject
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"title","description"
})
public class LocationDTO extends AbstractDTO{

	@ApiObjectField(name="title")
	@JsonProperty("title")
	private String title;
	
	@ApiObjectField(name="description")
	@JsonProperty("description")
	private String description;

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
	
	
}
