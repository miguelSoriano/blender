package globant.blender.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import globant.blender.model.SocialEvent;
import globant.blender.repository.SocialEventsRepository;
import globant.blender.services.SocialEventsService;

@Component
public class SocialEventsServiceImpl implements SocialEventsService{
	
	@Autowired
	private SocialEventsRepository socialEventsRepository ;

	public void persistSocialEvent(SocialEvent socialEvents){
		socialEventsRepository.save(socialEvents);
	}
	
	public Iterable<SocialEvent> getSocialEvents(){		
		return socialEventsRepository.findAll();
	}
	
}
