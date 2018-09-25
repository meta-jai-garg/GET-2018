package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.UserRoles;

public interface UserRolesService {
	List<UserRoles> allUsers(String username);
}
