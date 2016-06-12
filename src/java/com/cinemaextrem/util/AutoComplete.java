/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.util;

import com.cinemaextrem.model.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

//import net.javabeat.primefaces.data.Player;
//import net.javabeat.primefaces.util.PlayerDataSource;
@ManagedBean
public class AutoComplete {

    @ManagedProperty("#{peliDataSorce}")
    private PeliDataSorce ds;
    private Pelicula pelis;

    public AutoComplete() {

    }
    
    public List<Pelicula> completePeli(String query) {

        List<Pelicula> allThemes = ds.getPelis();
        List<Pelicula> filteredThemes = new ArrayList<Pelicula>();
        for (int i = 0; i < allThemes.size(); i++) {
            Pelicula skin = allThemes.get(i);
            if (skin.getTitPel().toString().startsWith(query.toUpperCase())) {
                filteredThemes.add(skin);
            }
        }
        return filteredThemes;
    }

    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }

    public Pelicula getPelis() {
        return pelis;
    }

    public void setPelis(Pelicula pelis) {
        this.pelis = pelis;
    }

    public PeliDataSorce getDs() {
        return ds;
    }

    public void setDs(PeliDataSorce ds) {
        this.ds = ds;
    }
}
