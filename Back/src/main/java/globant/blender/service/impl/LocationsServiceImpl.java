package globant.blender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import globant.blender.model.Locations;
import globant.blender.repository.LocationsRepository;
import globant.blender.services.LocationsService;

@Component
public class LocationsServiceImpl implements LocationsService{

	@Autowired
	private LocationsRepository locationsRepository;
	
	public void persistLocation(Locations location){
		locationsRepository.save(location);
	}
}
