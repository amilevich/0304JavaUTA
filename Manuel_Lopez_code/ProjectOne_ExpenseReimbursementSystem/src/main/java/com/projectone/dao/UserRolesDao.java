package com.projectone.dao;

import com.projectone.models.UserRoles;
import com.projectone.models.Users;

public interface UserRolesDao {

	//CREATE
	public int insertUserRole(UserRoles p);
	//READ
	public UserRoles selectUserRolesByName(Integer ersUserRoleId);
	//UPDATE
	//DELETE
}
