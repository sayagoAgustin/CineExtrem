/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.bean;

import com.cinemaextrem.DAO.PeliculaDAO;
import com.cinemaextrem.model.Pelicula;
import com.cinemaextrem.util.UtilPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author Agustin
 */
@Named(value = "altaPeliBean")
@RequestScoped

public class altaPeliBean { 
    private Pelicula peli;
    private UploadedFile file;
    
    public String insertar() {
        PeliculaDAO a = new PeliculaDAO();
        a.insertar(peli);
        handleFileUpload(a.getPp().getIdPel().toString());
        return "index?faces-redirection=true";
    }
    
    public String nombrarImg(){
        String nombre = peli.getTitPel();
        return nombre.replace(" ", "");
    }

    /*
        handleFileUpload Sirver para cargar las imagenes
    */
    public void handleFileUpload(String nombre) {

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String realPath = UtilPath.rutaWeb(ec.getRealPath("/"));
        System.err.print(realPath);
       
        String pathDefinition = realPath + "web" + File.separator + "images" + 
                File.separator + "movies" +File.separator + nombre + ".jpg";
        System.err.print(pathDefinition);
        try {
            FileInputStream in = (FileInputStream) file.getInputstream();
            FileOutputStream out = new FileOutputStream(pathDefinition);

            byte[] buffer = new byte[(int) file.getSize()];
            int contador = 0;

            while ((contador = in.read(buffer)) != -1) {
                out.write(buffer, 0, contador);
            }
            in.close();
            out.close();

        } catch (IOException ioe) {
            System.err.print("error");
            ioe.printStackTrace();

        }
    }
    
    public Pelicula getPeli() {
        return peli;
    }

    public altaPeliBean() {
        peli = new Pelicula();
    }

    
    
    
    public void setPeli(Pelicula M) {
        this.peli = M;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
}
