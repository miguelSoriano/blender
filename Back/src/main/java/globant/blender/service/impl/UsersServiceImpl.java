package globant.blender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import globant.blender.model.User;
import globant.blender.repository.UsersRepository;
import globant.blender.services.UsersService;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository ;
	
	@Override
	public void persistUser(User user) {
		usersRepository.save(user);
	}
	
	public User findUserByemail(String email) {
		return usersRepository.findUserByEmail(email);
	}

}
