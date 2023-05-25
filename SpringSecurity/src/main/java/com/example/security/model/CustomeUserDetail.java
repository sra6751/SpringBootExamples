package com.example.security.model;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.security.entity.UserEntity;

public class CustomeUserDetail implements UserDetails{
	
	@Autowired
	UserEntity userEntity;
	
	

	public CustomeUserDetail(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(userEntity.getRole()));
		return set;
	}

	@Override
	public String getPassword() {
		return this.userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return this.userEntity.getuserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
