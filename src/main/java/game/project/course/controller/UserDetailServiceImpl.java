package game.project.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import game.project.course.domain.UserRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private final UserRepository repo;

	@Autowired
	public UserDetailServiceImpl(UserRepository uRepo) {
		this.repo = uRepo;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	game.project.course.domain.User curruser = repo.findByusername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordhash(), 
        		AuthorityUtils.createAuthorityList(curruser.getUserRole()));
        return user;
    }
	
}
