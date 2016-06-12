package com.cinemaextrem.util;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import com.cinemaextrem.model.Funcion;
import com.cinemaextrem.DAO.FuncionDAO;
import com.cinemaextrem.bean.AltaFuncionBean;
import com.cinemaextrem.model.Pelicula;
import com.cinemaextrem.model.Sala;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;

@ManagedBean
@ViewScoped
public class FuncionEvnto implements Serializable {

    private Funcion funcion;
    private ScheduleModel funModel;
    private List<Funcion> listaFuncion;
    private FuncionDAO fDao;

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public ScheduleModel getFunModel() {
        return funModel;
    }

    public void setFunModel(ScheduleModel funModel) {
        this.funModel = funModel;
    }

    public List<Funcion> getListaFuncion() {
        return listaFuncion;
    }

    public void setListaFuncion(List<Funcion> listaFuncion) {
        this.listaFuncion = listaFuncion;
    }

    public FuncionDAO getfDao() {
        return fDao;
    }

    public void setfDao(FuncionDAO fDao) {
        this.fDao = fDao;
    }

    @PostConstruct
    public void inicializar() {
        fDao = new FuncionDAO();
        funcion = new Funcion();
        funModel = new DefaultScheduleModel();

        try {

            FacesContext contextoEL = FacesContext.getCurrentInstance();
            Application appli = contextoEL.getApplication();
            listaFuncion = fDao.listarFunciones((int) appli.evaluateExpressionGet(contextoEL, "#{salaSelecteOneView.sala.nroSala}", int.class));

        } catch (SQLException ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error en sql."));
        }
        for (Funcion fu : listaFuncion) {
            DefaultScheduleEvent evt = new DefaultScheduleEvent();
            evt.setEndDate((Date) fu.getFecFunF());
            evt.setStartDate((Date) fu.getFecFunI());
            evt.setTitle(fu.getPelicula().getTitPel());
            evt.setData(fu.getIdFun());
            evt.setDescription("");
            evt.setAllDay(false);
            evt.setEditable(true);

            funModel.addEvent(evt);
        }
    }

    public void alSeleccionarFuncion(SelectEvent selectEvent) {

        ScheduleEvent func = (ScheduleEvent) selectEvent.getObject();

        for (Funcion fu : listaFuncion) {
            if (Objects.equals(fu.getIdFun(), (Integer) func.getData())) {
                //getData tiene que ser el ide en inicializar.
                this.funcion = fu;
                break;
            }
        }
    }

    public void alMover(SelectEvent selectEvento) {
        ScheduleEvent funci = new DefaultScheduleEvent("", (Date) selectEvento.getObject(), (Date) selectEvento.getObject());
        funcion = new Funcion();
        funcion.setFecFunI(new java.sql.Date(funci.getStartDate().getTime()));
        funcion.setFecFunF(new java.sql.Date(funci.getEndDate().getTime()));
    }

    public void guardar() {System.out.println("primero");
        if (funcion.getIdFun() == null) {
            System.out.println("primero");
            if (funcion.getFecFunI().getTime() <= funcion.getFecFunF().getTime()) {
                fDao = new FuncionDAO();
                try {
                    
                    AltaFuncionBean a = new AltaFuncionBean();
                    funcion.setSala(a.mostrarSala());
                    funcion.setPelicula(a.mostrarPeli());
                    funcion.setDimPel(funcion.getSala().getTipoDeProy());
                    fDao.insertar(funcion);
                    inicializar();
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos al insertar la Funcion", "Error"));
                }
                funcion = new Funcion();
            } else {

            }
        } else {
            try {
                fDao.actualizar(funcion);
                inicializar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos incorrectos al actualizar la Funcion", "Error"));
            } catch (Exception e) {
            }
        }
    }

}
