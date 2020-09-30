package com.example.demo.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.domain.model.Role;
import com.example.demo.domain.model.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	BCryptPasswordEncoder encoder;
	
	private User user;

	public UserDetailsImpl(User u , BCryptPasswordEncoder encoder) {
		this.user = u;
		this.encoder = encoder;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
		return authorities;
	}

	@Override
	public String getPassword() {
		return encoder.encode(user.getPassword());
	}

	@Override
	public String getUsername() {
		return user.getEmail_id();
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
