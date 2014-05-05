package com.zoo.model.entity;

import javax.persistence.*;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
@Entity
@Table(name = "animal")
public class Animal {
    private int id;
    private String name;
    private String sex;
    private int age;
    private Cage cageByCageId;
    private Clazz clazzByClassId;
    private Genus genusByGenusId;

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

    @Basic
    @Column(name = "Sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (id != animal.id) return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        if (sex != null ? !sex.equals(animal.sex) : animal.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CAGE_id", referencedColumnName = "id", nullable = false)
    public Cage getCageByCageId() {
        return cageByCageId;
    }

    public void setCageByCageId(Cage cageByCageId) {
        this.cageByCageId = cageByCageId;
    }

    @ManyToOne
    @JoinColumn(name = "Class_id", referencedColumnName = "id", nullable = false)
    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }

    @ManyToOne
    @JoinColumn(name = "Genus_id", referencedColumnName = "id", nullable = false)
    public Genus getGenusByGenusId() {
        return genusByGenusId;
    }

    public void setGenusByGenusId(Genus genusByGenusId) {
        this.genusByGenusId = genusByGenusId;
    }
}
