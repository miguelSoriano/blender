package globant.blender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import globant.blender.model.Locations;

@Repository
public interface LocationsRepository extends CrudRepository<Locations, String>{
	
}
