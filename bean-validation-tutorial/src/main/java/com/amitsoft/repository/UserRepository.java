package com.amitsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amitsoft.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
