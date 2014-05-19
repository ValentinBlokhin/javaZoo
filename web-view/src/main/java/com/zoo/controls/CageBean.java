package com.zoo.controls;

import com.zoo.model.entity.Cage;
import com.zoo.service.EntityService;
import com.zoo.service.Impl.CageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/18/2014.
 */
@ManagedBean
@SessionScoped
public class CageBean implements Serializable {

    private List<Cage> cageList;
    private Cage cage = new Cage();


    public CageBean() {
    }

    @PostConstruct
    public void loadData() {
        EntityService<Cage> service = new CageService();
        cageList = service.getAll(0, 1000);


    }


    public List<Cage> getCageList() {
        return cageList;
    }

    public void setCageList(List<Cage> cageList) {
        this.cageList = cageList;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }
}
