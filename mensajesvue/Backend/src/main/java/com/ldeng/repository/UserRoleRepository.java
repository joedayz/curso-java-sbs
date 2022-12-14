package com.ldeng.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ldeng.entity.security.UserRole;

public interface UserRoleRepository extends MongoRepository<UserRole, String> {

}
