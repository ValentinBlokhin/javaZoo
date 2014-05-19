package com.zoo.controls;

import com.zoo.model.entity.Cage;
import com.zoo.service.EntityService;
import com.zoo.service.Impl.CageService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by ValentinBlokhin on 5/18/2014.
 */
@FacesConverter(value = "ConverterCages")
public class Converter implements javax.faces.convert.Converter {

    @Override
    public Cage getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        EntityService<Cage> cageService = new CageService();
        int cageId;

        try {
            cageId = Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Type the name of a Course and select it (or use the dropdown)",
                    "Type the name of a Course and select it (or use the dropdown)"));
        }
        return cageService.get(cageId);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Cage cage = null;

        if (o instanceof Cage) {
            cage = (Cage) o;
            StringBuilder asString = new StringBuilder();
            asString.append(cage.getId());
            return asString.toString();

        }
        return "";
    }
}
