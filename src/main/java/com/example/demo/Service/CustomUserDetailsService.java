package example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import example.demo.Repo.UsersRepository;
import example.demo.VO.CustomUserDetails;
import example.demo.VO.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UsersRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<User> users = userRepo.findByName(name);
		
		users.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		
		return users.map(CustomUserDetails::new).get();
	}

}
