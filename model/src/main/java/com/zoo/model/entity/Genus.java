package com.zoo.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
@Entity
@Table(name = "genus")
public class Genus {
    private int id;
    private String name;
    private Collection<Animal> animalsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genus genus = (Genus) o;

        if (id != genus.id) return false;
        if (name != null ? !name.equals(genus.name) : genus.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "genusByGenusId")
    public Collection<Animal> getAnimalsById() {
        return animalsById;
    }

    public void setAnimalsById(Collection<Animal> animalsById) {
        this.animalsById = animalsById;
    }
}
