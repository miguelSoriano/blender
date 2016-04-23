package globant.blender.util;

import globant.blender.dto.SocialEventsDTO;
import globant.blender.model.SocialEvent;

public class SocialEventMapper {

	public static SocialEventsDTO mapSocialEventstoSocialEventsDTO(SocialEvent socialEvents,SocialEventsDTO socialEventDTO){
		SocialEventsDTO result = null;
		
		if(socialEvents != null){
			socialEvents.getTitle();
		}
		
		return result;
	}
}
