package com.stock.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stock.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
