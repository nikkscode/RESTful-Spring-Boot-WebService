package com.nikkmuc.rest.webservice.restfulwebservice.user.repositories;

import com.nikkmuc.rest.webservice.restfulwebservice.user.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
