package com.spring.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.webflux.entity.User;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
