/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.DAO;

import com.cinemaextrem.model.Pelicula;
import com.cinemaextrem.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Agustin
 */
public class PeliculaDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Pelicula pp;
    
    public void insertar(Pelicula medi) {
        Transaction tx = session.beginTransaction();
        try {
            medi.setTitPel(medi.getTitPel().toUpperCase());
            pp = medi;
            session.save(medi);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en insertar " + e.getMessage());
            tx.rollback();
        }
    }
    
    public Pelicula getPp() {
        return pp;
    }   

    public List<Pelicula> listarPeliLimit() {
        session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Pelicula order by idPel desc").setMaxResults(20).list();
    }
    
    
    
    
    
}
