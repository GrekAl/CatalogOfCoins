package org.numismat.springboot.service;

import java.util.HashSet;
import java.util.Set;

import org.numismat.springboot.mapper.UserMapper;
import org.numismat.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

	private final UserMapper userMapper;

    @Autowired
    public UserDetailService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getUserByLogin(username);
		Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.isAdmin() ? "ROLE_ADMIN" : "ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
	}

}
