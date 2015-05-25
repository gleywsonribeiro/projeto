package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cachorro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int age;
    private String name;

    @ManyToMany(mappedBy = "dogs")
    private List<Pessoa> pessoas;

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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cachorro) {
            Cachorro dog = (Cachorro) obj;
            return dog.getId() == id;
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
