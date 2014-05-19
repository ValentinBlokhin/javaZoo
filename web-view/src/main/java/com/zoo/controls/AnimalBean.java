package com.zoo.controls;

import com.zoo.model.entity.Animal;
import com.zoo.model.entity.Cage;
import com.zoo.model.entity.Clazz;
import com.zoo.model.entity.Genus;
import com.zoo.service.EntityService;
import com.zoo.service.Impl.AnimalService;
import com.zoo.service.Impl.CageService;
import com.zoo.service.Impl.ClazzService;
import com.zoo.service.Impl.GenusService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ValentinBlokhin on 5/15/2014.
 */


@ManagedBean
@SessionScoped
public class AnimalBean implements Serializable {

    private List<Animal> services;
    private List<Cage> cages;
    private List<Clazz> clazzs;
    private List<Genus> genuses;


    private Animal animal = new Animal();
    private Cage cage = new Cage();
    private Clazz clazz = new Clazz();
    private Genus genus = new Genus();
    EntityService<Cage> cageEntityService = new CageService();
    EntityService<Clazz> clazzEntityService = new ClazzService();
    EntityService<Genus> genusEntityService = new GenusService();

    private EntityService<Animal> animalDao = new AnimalService();

    private ArrayList<String> sexArray;


    public AnimalBean() {
    }

    @PostConstruct
    public void loadData() {
        EntityService<Animal> animals = new AnimalService();
        services = animals.getAll(0, 1000);


        cages = cageEntityService.getAll(0, 1000);
        clazzs = clazzEntityService.getAll(0, 1000);

        genuses = genusEntityService.getAll(0, 1000);

        sexArray = new ArrayList<String>();
        sexArray.add(0, "male");
        sexArray.add(1, "female");
    }


    public List<Animal> getServices() {
        return services;
    }

    public void addAnimal() {
        animalDao.saveOrUpdate(animal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Animal added", "animal message"));
    }

    public Cage getCageById(int id) {
        return cageEntityService.get(id);

    }

    public Clazz getClazzById(int id) {
        return clazzEntityService.get(id);
    }

    public Genus getGenusById(int id) {
        return genusEntityService.get(id);
    }

    public Animal getAnimal() {
        return animal;
    }

    public List<Cage> getCages() {
        System.out.println(cages.size());
        return cages;
    }

    public Cage getCage() {
        return cage;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public List<Clazz> getClazzs() {
        return clazzs;
    }

    public Genus getGenus() {
        return genus;
    }

    public List<Genus> getGenuses() {
        return genuses;
    }

    public ArrayList<String> getSexArray() {
        return sexArray;
    }

    public void setServices(List<Animal> services) {
        this.services = services;
    }

    public void setCages(List<Cage> cages) {
        this.cages = cages;
    }

    public void setClazzs(List<Clazz> clazzs) {
        this.clazzs = clazzs;
    }

    public void setGenuses(List<Genus> genuses) {
        this.genuses = genuses;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


}
