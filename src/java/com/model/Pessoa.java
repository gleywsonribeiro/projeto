package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findUserByIdWithDogs", query = "select p from Person p left join fetch p.dogs where p.id = :personId")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_USER_BY_ID_WITH_DOGS = "Person.findUserByIdWithDogs";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int age;
    private String name;

    @ManyToMany
    private List<Cachorro> dogs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cachorro> getDogs() {
        return dogs;
    }

    public void setDogs(List<Cachorro> dogs) {
        this.dogs = dogs;
    }

    
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa person = (Pessoa) obj;
            return person.getId() == id;
        }

        return false;
    }
}
