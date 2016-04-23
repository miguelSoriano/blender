package globant.blender.services;

import globant.blender.model.SocialEvent;

public interface SocialEventsService {

	void persistSocialEvent(SocialEvent socialEvents);
	
	Iterable<SocialEvent> getSocialEvents();
}
