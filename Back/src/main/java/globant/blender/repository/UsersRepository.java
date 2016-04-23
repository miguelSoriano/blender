package globant.blender.repository;

import org.springframework.data.repository.CrudRepository;

import globant.blender.model.User;

public interface UsersRepository extends CrudRepository<User, Integer>{

	public User findUserByEmail(String email);
}
