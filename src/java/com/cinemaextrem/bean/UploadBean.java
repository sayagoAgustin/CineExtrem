/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaextrem.bean;

import com.cinemaextrem.util.UtilPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * Bean para subir fotos al servidor
 * 
 */
@ManagedBean
@SessionScoped
public class UploadBean implements Serializable{

    public UploadBean() {
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String realPath = UtilPath.rutaWeb(ec.getRealPath("/"));
//       System.err.print(realPath);
        
        /*
        +Direccion donde se guardan las imagenes
        +Se debe colocar el id de la pelicula para poder buscarla
        */
        String pathDefinition = realPath + "web" + File.separator + "images" + 
                File.separator + "movies" +File.separator + file.getFileName();
        
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
            ioe.printStackTrace();

        }
    }
    
    public void deleteImagen(){
        try {
            File fichero = new File("B:\\UNSE\\PracticaProfecional\\CinemaExtrem\\ejemplostemp\\build\\web\\images\\camara-digita.jpg");
//            FileReader fr=new FileReader(fichero);
            fichero.delete();
            System.out.println("Eliminado");
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
