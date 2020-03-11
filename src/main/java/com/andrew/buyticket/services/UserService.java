package com.andrew.buyticket.services;

import com.andrew.buyticket.exceptions.NotFoundException;
import com.andrew.buyticket.models.User;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String name);

    User findById(Long id);

    void delete(Long id);
}

   /* public int counter = 3;
    public List<Map<String, String>> userList = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1");
            put("text", "Andrew");
        }});
        add(new HashMap<String, String>() {{
            put("id", "2");
            put("text", "Max");
        }});
        add(new HashMap<String, String>() {{
            put("id", "3");
            put("text", "Vlad");
        }});
    }};

    public List<Map<String, String>> getUserList() {
        return userList;
    }

    public Map<String, String> getUser(String id) {
        return findUserById(id);
    }

    public Map<String, String> addUser(Map<String, String> user) {
        user.put("id", String.valueOf(counter++));
        userList.add(user);
        return user;
    }

    public Map<String, String> updateUser(String id, Map<String, String> user) {
        Map<String, String> userFromDb = findUserById(("id"));
        userFromDb.putAll(user);
        userFromDb.put("id", id);
        return userFromDb;
    }

    public void dropUser(String id) {
        Map<String, String> user = findUserById(id);
        userList.remove(user);
    }

    public Map<String, String> findUserById(String id) {
        return userList.stream()
                .filter(x -> x.get("id")
                        .equals(id)).findFirst()
                .orElseThrow(NotFoundException::new);
    }*/

