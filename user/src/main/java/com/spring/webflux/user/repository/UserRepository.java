package com.spring.webflux.user.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.webflux.user.entity.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
