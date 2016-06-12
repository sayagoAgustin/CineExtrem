/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.DAO;

import com.cinemaextrem.model.Funcion;
import com.cinemaextrem.model.Pelicula;
import com.cinemaextrem.model.Sala;
import com.cinemaextrem.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Agustin
 */
public class FuncionDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    Funcion f;
    
    public void insertar(Funcion fun) {
        Transaction tx = session.beginTransaction();
        try {
            System.out.println("1234567");
            session.save(fun);
            System.out.println("Exitoooooo");
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en insertar " + e.getMessage());
            tx.rollback();
        }
    }
//public List<Funcion> listarFunciones() throws SQLException {
//        session= HibernateUtil.getSessionFactory().openSession();
////        return session.createQuery("select f, p.titPel from Funcion f join f.pelicula p where f.fecFunI > now()").list();
//        return session.createQuery("from Funcion where fecFunI > now()").list();
//    }    

public List<Funcion> listarFunciones(int sala) throws SQLException {
        session= HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Funcion f where f.fecFunI > now() and f.sala.nroSala ="+ sala);
//        q.setParameter("nro", sala);
//        return session.createQuery("from Funcion where fecFunI > now() and nroSala = 3").list();
        return q.list();
    }  

    public void actualizar(Funcion funcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
