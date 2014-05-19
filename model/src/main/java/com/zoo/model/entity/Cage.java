package com.zoo.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 5/18/2014.
 */
@Entity
public class Cage {
    private int id;
    private String capacity;
    private String type;
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
    @Column(name = "capacity")
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cage cage = (Cage) o;

        if (id != cage.id) return false;
        if (capacity != null ? !capacity.equals(cage.capacity) : cage.capacity != null) return false;
        if (type != null ? !type.equals(cage.type) : cage.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cageByCageId")
    public Collection<Animal> getAnimalsById() {
        return animalsById;
    }

    public void setAnimalsById(Collection<Animal> animalsById) {
        this.animalsById = animalsById;
    }
}
