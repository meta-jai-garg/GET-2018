package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>{

}
