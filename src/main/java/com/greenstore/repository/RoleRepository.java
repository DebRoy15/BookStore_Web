package com.greenstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.greenstore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
	
	

}
