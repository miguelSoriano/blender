package globant.blender.services;

import globant.blender.model.Location;

public interface LocationsService {

	void persistLocation(Location location);
	
	Location findById(Integer id);
}
