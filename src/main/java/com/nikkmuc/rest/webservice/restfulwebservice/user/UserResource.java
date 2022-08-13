package com.nikkmuc.rest.webservice.restfulwebservice.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "User")
@RequestMapping(path = "/users")
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping
    @Operation(summary = "Get all Users", description = "Returns a list of all Users.")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get User by ID", description = "Returns a User for a given ID.")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-" + id);
        return user;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete User by ID", description = "Deletes a User for a given ID.")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("id-" + id);
    }

    @PostMapping
    @Operation(summary = "Create new User", description = "Creates a new User.")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User tmpUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tmpUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
