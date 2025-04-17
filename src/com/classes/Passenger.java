package com.classes;
import java.time.LocalDateTime;

/**
 *
 * @author Djenidi
 */
public class Passenger {
    private int id;
    private String name;
    private String firstName;
    private String email;
    private String phone;
    private LocalDateTime dateOfBirth;
    
    public Passenger(int id, String name, String firstName, String email, String phone, LocalDateTime date)
    {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = date;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
