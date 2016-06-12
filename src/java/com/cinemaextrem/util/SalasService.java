package com.cinemaextrem.util;

import com.cinemaextrem.DAO.SalaDAO;
import com.cinemaextrem.model.Pelicula;
import com.cinemaextrem.model.Sala;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
@ManagedBean(name="salasService", eager = true)
@ApplicationScoped
public class SalasService {
    private List<Sala> salas;
     
    @PostConstruct
    public void init() {
        SalaDAO s = new SalaDAO();
        Iterator iter = s.listarSalas().iterator();
        salas = new ArrayList<Sala>();
        while (iter.hasNext()) {
            salas.add((Sala) iter.next());
        }
        
    }

    public List<Sala> getSalas() {
        return salas;
    }

}
