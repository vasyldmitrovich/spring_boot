package com.shopoftrifles.repository;

import com.shopoftrifles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Will be AUTO IMPLEMENTED by Spring into a Bean called userRepository CRUD refers Create, Read, Update, Delete
public interface UserRepo extends JpaRepository<User, Long> {

}
