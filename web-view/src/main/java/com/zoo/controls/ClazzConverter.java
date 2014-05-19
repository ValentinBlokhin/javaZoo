package com.zoo.controls;

import com.zoo.model.entity.Clazz;
import com.zoo.service.EntityService;
import com.zoo.service.Impl.ClazzService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

/**
 * Created by ValentinBlokhin on 5/18/2014.
 */
@FacesConverter(value = "clazzConverter")
public class ClazzConverter implements javax.faces.convert.Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Clazz clazz = new Clazz();
        EntityService<Clazz> clazzService = new ClazzService();
        int clazzId;

        try {
            clazzId = Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Type the name of a Clazz and select it (or use the dropdown)",
                    "Type the name of a Clazz and select it (or use the dropdown)"));
        }
        return clazzService.get(clazzId);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Clazz clazz = null;

        if (o instanceof Clazz) {
            clazz = (Clazz) o;
            StringBuilder asString = new StringBuilder();
            asString.append(clazz.getId()).append("-");
            asString.append(clazz.getName());

        }
        return "";
    }
}
