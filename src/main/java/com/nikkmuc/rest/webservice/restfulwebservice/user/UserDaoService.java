package com.nikkmuc.rest.webservice.restfulwebservice.user;


import com.nikkmuc.rest.webservice.restfulwebservice.user.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users  = new ArrayList<>();
    private static int usersCount = 5;

    static {
        users.add(new User(100, "Dave", new Date()));
        users.add(new User(321, "Brian", new Date()));
        users.add(new User(32, "Sarah", new Date()));
        users.add(new User(313, "Martha", new Date()));
        users.add(new User(90, "John", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

     public User save(User user) {
        if (user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
     }
    public User findOne(int id){
        User userTmp = null;
        for(User user: users) {
            if(user.getId()==id){
                userTmp = user;
            }
        }
        return userTmp;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User userTmp = iterator.next();
            if (userTmp.getId() == id){
                iterator.remove();
                return userTmp;
            }
        }
        return null;
    }



}
