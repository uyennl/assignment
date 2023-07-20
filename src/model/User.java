package model;

import java.util.ArrayList;
import java.util.Calendar;

public class User extends Person {
    public static ArrayList<User> uss = new ArrayList<>();

    public User(String id, String name) {
        super(id, name);
    }

    public User(String id, String name, int age, String sex, String phone, Calendar birth) {
        super(id, name, age, sex, phone, birth);
    }


    public User(String name) {
        super(name);
    }


}
