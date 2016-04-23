package globant.blender.services;

import globant.blender.model.User;

public interface UsersService {

	void persistUser(User user);
	
	User findUserByemail(String email);
}
