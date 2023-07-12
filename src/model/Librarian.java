package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Librarian extends Person {
    private String password;
    public static ArrayList<Librarian> arrlb = new ArrayList<>();

    public Librarian(String id, String name, int age, String sex, String phone, Calendar birth, String password) {
        super(id, name, age, sex, phone, birth);
        this.password = password;
    }

    public Librarian(String id, String name, int age, String sex, String phone, Calendar birth) {
        super(id, name, age, sex, phone, birth);
    }

    public Librarian() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Librarian{"+super.toString() +
                "password='" + password + '\'' +
                '}';
    }
}
