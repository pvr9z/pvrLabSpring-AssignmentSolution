package in.greatlearing.CollegeFest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.greatlearing.CollegeFest.entity.User;
import in.greatlearing.CollegeFest.repo.UserRepository;
import in.greatlearing.CollegeFest.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.getByUsername(username);
		return new MyUserDetails(user);
	}

}
