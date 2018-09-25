package com.metacube.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRoles;

@Service
public class CustomService implements UserDetailsService {

	@Autowired
	private EmployeeService empService;
	@Autowired
	private UserRolesService userRolesService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = empService.getEmployeeByEmail(username);
		System.out.println("Employee : " + employee);
		if (employee == null) {
			System.out.println("Employee not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(employee.getEmailId(), employee.getPassword(),
				employee.getIsActive(), true, true, true, getGrantedAuthorities(username));
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(String username) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<UserRoles> user = userRolesService.allUsers(username);
        for(UserRoles roles : user){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRole()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
	}

}
