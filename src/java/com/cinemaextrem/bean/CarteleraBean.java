/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.bean;

import com.cinemaextrem.DAO.PeliculaDAO;
import com.cinemaextrem.model.Pelicula;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
//import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Agustin
 */
@Named(value = "carteleraBean")
@SessionScoped
public class CarteleraBean implements Serializable{
    Pelicula p;
    public CarteleraBean() {
    }
    private List<Pelicula> pel;

    public List<Pelicula> getPel() {
        PeliculaDAO a = new PeliculaDAO();
        this.pel = a.listarPeliLimit();
        return pel;
    }

    public Pelicula getP() {
        return p;
    }

    public void setP(Pelicula p) {
        this.p = p;
    }
    
    

    public String mostrarUnaMovie(Pelicula peli){
        this.p = peli;
        return "unaPeli";
    }
    
//    private String ruta;
//    public String getRuta(int nombre) {
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        String realPath = UtilPath.rutaWeb(ec.getRealPath("/"));
//        System.err.print(realPath);
//       
//        String pathDefinition = realPath + "web" + File.separator + "images" + 
//                File.separator + "movies" +File.separator + nombre + ".jpg";
//        
//        System.err.print(pathDefinition);
//        ruta = pathDefinition;
//        return ruta;
//    }
    
}
