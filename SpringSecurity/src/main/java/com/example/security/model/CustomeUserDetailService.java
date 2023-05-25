package com.example.security.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.entity.UserEntity;
import com.example.security.repository.UserRepository;

@Service
public class CustomeUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = this.userRepository.findByUserName(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User Not Found with userName :"+username);
		}
		return new CustomeUserDetail(userEntity);
	}

}
