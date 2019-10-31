package edu.caece.tpfinal.resources;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import edu.caece.tpfinal.domain.Foto;

public class LecturaCarpeta {
  	
	// RUTA DENTRO DEL MISMO PROYECTO
	protected String RUTA_CSV = "\\src\\main\\resources\\bd\\TP-FINAL\\Fotos";
	protected String rutaArchivo = "";
	
	ArrayList<Foto> fotos = null;
	
	@SuppressWarnings("finally")
	public ArrayList<Foto> recorrerCarpeta() throws Exception {
	  fotos = new ArrayList<Foto>();
	  	try {
	  		// Obtiene Ruta de Carpeta Con Fotos de Personas
	  		String path = System.getProperty("user.dir");
			rutaArchivo = path + RUTA_CSV;
		    File carpeta = new File(rutaArchivo);
		    
		    // Obtiene Carpeta Con Fotos de Personas
		    File[] archivos = carpeta.listFiles();
		    
		    // Verifica si esta vacio
		    if (archivos != null && archivos.length != 0) {
		    	
		    	// Recorre Carpetas
		    	for (int i=0; i< archivos.length; i++) {
		    		
		    		// Obtiene carpeta de fotos
		    		File archivo = archivos[i];
		    		
		    		// Verifica si es directorio con matricula
		        	if (archivo.isDirectory()) {
		        		
		        		// Imprime matricula del nombre de la carpeta
		        		System.out.println(archivo.getName());
		        		
		        		// Obtiene datos de fotos
		        		fotos = recorrerFotos(archivo);
		        	}
		        
		    	}
		    	
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return fotos;
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Foto> recorrerFotos(File carpeta) throws Exception {
	  try {
		  // Obtiene fotos de la carpeta
		  File[] archivos = carpeta.listFiles();
		    
		  // Verifica si la Carpeta de Fotos esta Vacia
		  if (archivos != null && archivos.length != 0) {
			  
			  // Recorre Fotos de Carpeta
			  for (int i=0; i< archivos.length; i++) {
				  
				  // Obtiene Bytes de Imagen del Archivo con la Foto
				  byte[] archivoBlob = Files.readAllBytes(Paths.get(archivos[i].getPath()));
		    	  
				  // Crea Objeto Foto
				  Foto foto = new Foto();
		    	  foto.setIdPersona(carpeta.getName());
		    	  foto.setNombreArchivo(archivos[i].getName());
		    	  foto.setArchivo(archivoBlob);
		    	  System.out.println(foto.toString());
		    	  
		    	  // Agrego Foto a la Lista de Fotos
		    	  fotos.add(foto);
			  }
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return fotos;
		}
	}
} 