package com.ldeng.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ldeng.entity.security.Role;


public interface RoleRepository extends MongoRepository<Role, String>{

}
