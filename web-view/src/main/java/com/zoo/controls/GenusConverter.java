package com.zoo.controls;

import com.zoo.model.entity.Genus;
import com.zoo.service.EntityService;
import com.zoo.service.Impl.GenusService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

/**
 * Created by ValentinBlokhin on 5/18/2014.
 */
@FacesConverter(value = "genusConverter")
public class GenusConverter implements javax.faces.convert.Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        EntityService<Genus> genusService = new GenusService();
        int genusId;

        try {
            genusId = Integer.parseInt(s);

        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Type the name of a Genus and select it (or use the dropdown)",
                    "Type the name of a Genus and select it (or use the dropdown)"));
        }


        return genusService.get(genusId);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Genus genus = null;

        if (o instanceof Genus) {
            genus = (Genus) o;
            StringBuilder asString = new StringBuilder();
            asString.append(genus.getId()).append("-");
            asString.append(genus.getName());

        }
        return "";
    }
}
