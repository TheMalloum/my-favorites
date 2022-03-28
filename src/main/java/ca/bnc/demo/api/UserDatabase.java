package ca.bnc.demo.api;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class UserDatabase {
    public static HashMap<String, HelloWorld> users = new HashMap<String, HelloWorld>();

    public static HelloWorld get(String id) {
        HelloWorld user = users.get(id);
        return user;
    }

    public static Collection<HelloWorld> get() {
        return users.values();
    }

    public static void update(String id, HelloWorld user) {
        user.setId(id);
        user.setLastModified(new Date());
        users.put(id, user);
    }


    public static void remove(String id) {
        users.remove(id);
    }
}