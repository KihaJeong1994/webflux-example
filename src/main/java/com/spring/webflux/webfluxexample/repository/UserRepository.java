package com.spring.webflux.webfluxexample.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.webflux.webfluxexample.entity.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
