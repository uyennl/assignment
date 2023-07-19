package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Librarian extends Person {

    private String password;
    public static ArrayList<Librarian> lbs = new ArrayList<>();

    public Librarian(String id, String name, int age, String sex, String phone, Calendar birth, String password) {
        super(id, name, age, sex, phone, birth);
        this.password = password;
    }

    public Librarian(String id, String name, int age, String sex, String phone, Calendar birth) {
        super(id, name, age, sex, phone, birth);
    }

    public Librarian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Librarian{" + super.toString() +
                "password='" + password + '\'' +
                '}';
    }
}

