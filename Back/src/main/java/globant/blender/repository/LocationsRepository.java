package globant.blender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import globant.blender.model.Location;
import globant.blender.model.User;

@Repository
public interface LocationsRepository extends CrudRepository<Location, Integer>{
	
}
