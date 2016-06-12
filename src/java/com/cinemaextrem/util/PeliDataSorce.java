package com.cinemaextrem.util;

import com.cinemaextrem.DAO.PeliculaDAO;
import com.cinemaextrem.model.Pelicula;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "peliDataSorce", eager = true)
@ApplicationScoped
public class PeliDataSorce {

    private List<Pelicula> Pelis;

    @PostConstruct
    public void init() {
        // Obtenemos un Iterador y recorremos la lista.
        PeliculaDAO a = new PeliculaDAO();

        Iterator iter = a.listarPeliLimit().iterator();
        Pelis = new ArrayList<Pelicula>();
        while (iter.hasNext()) {
            Pelis.add((Pelicula) iter.next());
        }
    }

    public PeliDataSorce() {
    }

    public List<Pelicula> getPelis() {
        return Pelis;
    }

    public void setPelis(List<Pelicula> Pelis) {
        this.Pelis = Pelis;
    }
    
}
