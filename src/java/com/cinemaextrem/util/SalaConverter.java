/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.util;

import com.cinemaextrem.model.Sala;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("salaConverter")
public class SalaConverter implements Converter {
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
               SalasService service = (SalasService) fc.getExternalContext().getApplicationMap().get("salasService");
                List<Sala> salas = service.getSalas();
                for (Sala sal : salas) {
                    if (sal.getNroSala()== Integer.parseInt(value)) {
                        return sal;
                    }
                }
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No se valido la Sala."));
            }
        }
        else {
            return null;
        }
        return null;
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Sala) object).getNroSala());
        }
        else {
            return null;
        }
    } 
}
