package org.example.springpostgress;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

@Id
@Column(name = "userid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
@Column(name = "username")
    private  String username;
@Column(name = "email")

    private  String email;
    @Column(name = "phone")

    private  String phone;

    @Column(name = "location")
    private  String location;

public UserEntity() {
    }



    public UserEntity(long id, String username, String email,String phone,String location) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone=phone;
        this.location=location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
