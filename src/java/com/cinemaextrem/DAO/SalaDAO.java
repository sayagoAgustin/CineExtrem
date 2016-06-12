/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.DAO;

import com.cinemaextrem.model.Sala;
import com.cinemaextrem.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class SalaDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Sala sala;
    
    public List<Sala> listarSalas() {
        session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Sala").list();
    }

    public Sala getSala() {
        return sala;
    }
    
}
