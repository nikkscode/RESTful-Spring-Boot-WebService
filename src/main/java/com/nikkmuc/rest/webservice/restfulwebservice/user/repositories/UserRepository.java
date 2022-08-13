package com.nikkmuc.rest.webservice.restfulwebservice.user.repositories;

import com.nikkmuc.rest.webservice.restfulwebservice.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
