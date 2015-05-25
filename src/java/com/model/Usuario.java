package com.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findUserByEmail", query = "select u from User u where u.email = :email")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_EMAIL = "User.findUserByEmail";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private Papel papel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    
    
    public boolean isAdmin() {
        return Papel.ADMIN.equals(papel);
    }

    public boolean isUser() {
        return Papel.USER.equals(papel);
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario user = (Usuario) obj;
            return user.getId() == id;
        }

        return false;
    }
}
