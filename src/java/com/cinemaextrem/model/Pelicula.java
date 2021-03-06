package com.cinemaextrem.model;
// Generated 11/06/2016 02:41:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pelicula generated by hbm2java
 */
public class Pelicula  implements java.io.Serializable {


     private Integer idPel;
     private String titPel;
     private String genPel;
     private String sinoPeli;
     private String actPel;
     private String dirPel;
     private Integer durPeli;
     private String claPeli;
     private String idiomaPel;
     private String dimPel;
     private Integer estPel;
     private Set<Funcion> funcions = new HashSet<Funcion>(0);

    public Pelicula() {
    }

	
    public Pelicula(String titPel) {
        this.titPel = titPel;
    }
    public Pelicula(String titPel, String genPel, String sinoPeli, String actPel, String dirPel, Integer durPeli, String claPeli, String idiomaPel, String dimPel, Integer estPel, Set<Funcion> funcions) {
       this.titPel = titPel;
       this.genPel = genPel;
       this.sinoPeli = sinoPeli;
       this.actPel = actPel;
       this.dirPel = dirPel;
       this.durPeli = durPeli;
       this.claPeli = claPeli;
       this.idiomaPel = idiomaPel;
       this.dimPel = dimPel;
       this.estPel = estPel;
       this.funcions = funcions;
    }
   
    public Integer getIdPel() {
        return this.idPel;
    }
    
    public void setIdPel(Integer idPel) {
        this.idPel = idPel;
    }
    public String getTitPel() {
        return this.titPel;
    }
    
    public void setTitPel(String titPel) {
        this.titPel = titPel;
    }
    public String getGenPel() {
        return this.genPel;
    }
    
    public void setGenPel(String genPel) {
        this.genPel = genPel;
    }
    public String getSinoPeli() {
        return this.sinoPeli;
    }
    
    public void setSinoPeli(String sinoPeli) {
        this.sinoPeli = sinoPeli;
    }
    public String getActPel() {
        return this.actPel;
    }
    
    public void setActPel(String actPel) {
        this.actPel = actPel;
    }
    public String getDirPel() {
        return this.dirPel;
    }
    
    public void setDirPel(String dirPel) {
        this.dirPel = dirPel;
    }
    public Integer getDurPeli() {
        return this.durPeli;
    }
    
    public void setDurPeli(Integer durPeli) {
        this.durPeli = durPeli;
    }
    public String getClaPeli() {
        return this.claPeli;
    }
    
    public void setClaPeli(String claPeli) {
        this.claPeli = claPeli;
    }
    public String getIdiomaPel() {
        return this.idiomaPel;
    }
    
    public void setIdiomaPel(String idiomaPel) {
        this.idiomaPel = idiomaPel;
    }
    public String getDimPel() {
        return this.dimPel;
    }
    
    public void setDimPel(String dimPel) {
        this.dimPel = dimPel;
    }
    public Integer getEstPel() {
        return this.estPel;
    }
    
    public void setEstPel(Integer estPel) {
        this.estPel = estPel;
    }
    public Set<Funcion> getFuncions() {
        return this.funcions;
    }
    
    public void setFuncions(Set<Funcion> funcions) {
        this.funcions = funcions;
    }




}


