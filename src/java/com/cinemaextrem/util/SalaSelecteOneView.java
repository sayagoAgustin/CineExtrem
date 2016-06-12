/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.util;

import com.cinemaextrem.model.Sala;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class SalaSelecteOneView {
    private String option;   
    private Sala sala; 
    private List<Sala> salas;
     
    @ManagedProperty("#{salasService}")
    private SalasService service;
     
    @PostConstruct
    public void init() {
        salas = service.getSalas();
    }
 
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
    public Sala getSala() {
        return sala;
    }
 
    public void setSala(Sala theme) {
        this.sala = theme;
    }
 
    public List<Sala> getSalas() {
        return salas;
    }
 
    public void setService(SalasService service) {
        this.service = service;
    }
}
