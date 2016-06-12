/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.util;

import com.cinemaextrem.DAO.PeliculaDAO;
import com.cinemaextrem.model.Pelicula;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "peliConverter")
public class PeliConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                PeliDataSorce service = (PeliDataSorce) fc.getExternalContext().getApplicationMap().get("peliDataSorce");
                List<Pelicula> peliculas = service.getPelis();
                for (Pelicula movie : peliculas) {
                    System.out.println("valor: "+ value);
                    if (movie.getTitPel().equals(value)) {
                        return movie;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Error-.------------------");
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Pelicula) object).getTitPel());
        } else {
            return null;
        }
    }
}
