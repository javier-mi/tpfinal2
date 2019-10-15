package edu.caece.tpfinal.resources;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import edu.caece.tpfinal.domain.Foto;

public class LecturaCarpeta {
  
    //Carpeta del usuario
    //String sCarpAct = System.getProperty("user.dir");
	protected static String nombreArchivo = "Fotos";
	protected static String rutaArchivo = "C:\\TP-FINAL\\" + nombreArchivo;
	
	@SuppressWarnings("finally")
	public ArrayList<Foto> recorrerCarpeta() throws Exception {
	  ArrayList<Foto> fotos = new ArrayList<Foto>();
	  	try {
		    File carpeta = new File(rutaArchivo);
		    File[] archivos = carpeta.listFiles();
		    if (archivos != null && archivos.length != 0) {
		    	for (int i=0; i< archivos.length; i++) {
		    		File archivo = archivos[i];
		        	if (archivo.isDirectory()) {
		        		System.out.println(archivo.getName());
		        		fotos = recorrerFotos(archivo);
		        	}
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return fotos;
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Foto> recorrerFotos(File carpeta) throws Exception {
	  ArrayList<Foto> fotos = new ArrayList<Foto>();
	  try {
		  File[] archivos = carpeta.listFiles();
		  if (archivos != null && archivos.length != 0) {
			  for (int i=0; i< archivos.length; i++) {
				  byte[] archivo = Files.readAllBytes(Paths.get(archivos[i].getPath()));
		    	  Foto foto = new Foto();
		    	  foto.setUsuario(archivos[i].getName());
		    	  foto.setFoto(archivo);
		    	  //System.out.println(foto.toString());
		    	  fotos.add(foto);
			  }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return fotos;
		}
	}
} 