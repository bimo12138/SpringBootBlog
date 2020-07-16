package com.bimo.bimo.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.bimo.bimo.utils.simpleEncode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "auth")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User implements Serializable {

    @Id
    @GenericGenerator(name = "uuidGenerate", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerate")
    private String id;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "sex")
    private int sex;

    @Column(name = "age")
    private int age;

    @JsonIgnore
    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "lovers",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
    private Set<User> lover;

    public Set<User> getLover() {
        return lover;
    }

    public void setLover(Set<User> lover) {
        this.lover = lover;
    }

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
        this.sex = 0;
        this.age = 18;
    }

    public void setPassword(String password) {
        this.password = encodePassword(password);
    }

    private String encodePassword(String raw) {
        return simpleEncode.md5Encode(raw);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(encodePassword(password));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
