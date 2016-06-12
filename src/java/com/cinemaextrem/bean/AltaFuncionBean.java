/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.bean;

import com.cinemaextrem.model.Funcion;
import com.cinemaextrem.model.Pelicula;
import com.cinemaextrem.model.Sala;
import com.cinemaextrem.util.AutoComplete;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Agustin
 */
@ManagedBean
@SessionScoped
public class AltaFuncionBean {

    private Funcion fun;
    private Pelicula pelis;
    String asd;

    public AltaFuncionBean() {

    }

    public void setPelis(Pelicula pelis) {
        this.pelis = pelis;
    }

    public Funcion getFun() {
        return fun;
    }

    public void setFun(Funcion fun) {
        this.fun = fun;
    }

    /*
     *FacesContext contextoEL = FacesContext.getCurrentInstance();
     *Application appli = contextoEL.getApplication();
     *String miPropiedad = (String) appli.evaluateExpressionGet(contextoEL, "#{autoComplete.pelis.titPel}",String.class);
     Esta funcion optine el nombre de la pelicula seleccionada en el texto autocompletable.    
     */
    public String verfic() {

        FacesContext contextoEL = FacesContext.getCurrentInstance();
        Application appli = contextoEL.getApplication();
        Integer miPropiedad;
        miPropiedad = appli.evaluateExpressionGet(contextoEL, "#{autoComplete.pelis.idPel}", Integer.class);
        System.out.println(miPropiedad);
        return "index";
    }

    public String getAsd() {
        try {
            FacesContext contextoEL = FacesContext.getCurrentInstance();
            Application appli = contextoEL.getApplication();
            return asd = (String) appli.evaluateExpressionGet(contextoEL, "#{autoComplete.pelis.titPel}", String.class);
        } catch (Exception e) {
            return "error al conseguir pelicula";
        }

    }

    public Pelicula mostrarPeli() {
        FacesContext contextoEL = FacesContext.getCurrentInstance();
        Application appli = contextoEL.getApplication();
//        System.out.println("Seleccionado peli" + (String) appli.evaluateExpressionGet(contextoEL, "#{autoComplete.pelis}", Pelicula.class).getTitPel());
        return ((Pelicula) appli.evaluateExpressionGet(contextoEL, "#{autoComplete.pelis}", Pelicula.class));
    }
    public Sala mostrarSala() {
        FacesContext contextoEL = FacesContext.getCurrentInstance();
        Application appli = contextoEL.getApplication();
        return ((Sala) appli.evaluateExpressionGet(contextoEL, "#{salaSelecteOneView.sala}", Sala.class));
    }

}
