package com.nikkmuc.rest.webservice.restfulwebservice.user;

import com.nikkmuc.rest.webservice.restfulwebservice.exception.UserNotFoundException;
import com.nikkmuc.rest.webservice.restfulwebservice.user.entities.Post;
import com.nikkmuc.rest.webservice.restfulwebservice.user.entities.User;
import com.nikkmuc.rest.webservice.restfulwebservice.user.repositories.PostRepository;
import com.nikkmuc.rest.webservice.restfulwebservice.user.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Tag(name = "JPA-User")
@RequestMapping(path = "/jpa/users/", produces = {"application/json"})
public class UserJPAResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    @Operation(summary = "Get all Users", description = "Returns a list of all Users.")
    public List<User> retrieveAllUsers(){

        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get User by ID", description = "Returns a User for a given ID.")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-" + id);
        EntityModel<User> model = EntityModel.of(user.get());

        WebMvcLinkBuilder linkToUsers =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete User by ID", description = "Deletes a User for a given ID.")
    public void deleteUser(@PathVariable int id){
        userRepository.findById(id);
        }

    @PostMapping
    @Operation(summary = "Create new User", description = "Creates a new User.")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User tmpUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tmpUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/posts")
    @Operation(summary = "Get all Posts of Users", description = "Returns a list of all Posts of User with id.")
    public List<Post> retrieveAllUsers(@PathVariable int id){

        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-" + id);
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/{id}/posts")
    @Operation(summary = "Create new Post for User", description = "Creates a new Post for the User with id.")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){

        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-" + id);
        }

        User tmpUser = userOptional.get();
        post.setUser(tmpUser);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
