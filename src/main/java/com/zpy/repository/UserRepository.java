package com.zpy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zpy.entity.User;

public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Integer> {

}
