package globant.blender.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import globant.blender.model.SocialEvent;

@Repository
public interface SocialEventsRepository extends CrudRepository<SocialEvent, Integer>{

}
