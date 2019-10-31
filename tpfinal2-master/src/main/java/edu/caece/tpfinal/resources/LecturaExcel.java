package edu.caece.tpfinal.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.caece.tpfinal.domain.Persona;
import edu.caece.tpfinal.domain.Usuario;

public class LecturaExcel {

	// RUTA DENTRO DEL MISMO PROYECTO
	protected String RUTA_CSV = "\\src\\main\\resources\\bd\\TP-FINAL\\DatosBD.xlsx";
	protected String rutaArchivo = "";
	
	XSSFWorkbook worbook = null;
	XSSFSheet sheet = null;

	public void leerArchivo() {
		try {
			// Lectura Excel
			String path = System.getProperty("user.dir");
			rutaArchivo = path + RUTA_CSV;
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			worbook = new XSSFWorkbook(file); 
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Usuario> obtenerUsuarios() {
		ArrayList<Usuario> usuarios = null;
		try {
			leerArchivo();
			sheet = worbook.getSheetAt(0);
			usuarios = leerHojaUsuarios();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			return usuarios;
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Persona> obtenerPersonas() {
		ArrayList<Persona> personas = null;
		try {			
			leerArchivo();
			sheet = worbook.getSheetAt(1);
			personas = leerHojaPersonas();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			return personas;
		}
	}

	public ArrayList<Usuario> leerHojaUsuarios() {
		
		// Creacion de Lista de Usuarios
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Obtiene Todas las Filas de Excel
		Iterator<Row> rowIterator = sheet.iterator();
		Row fila;
		
		// Con Esto Descarto Primera Fila con Titulos
		rowIterator.next(); 
		
		// Se Recorre Cada Fila Hasta el Final
		System.out.println("Lista Usuarios");
		while (rowIterator.hasNext()) {
		
			// Recorro Fila del Excel
			fila = rowIterator.next();
			
			 // Se Obtienen celdas de fila del Excel
			Iterator<Cell> iterador = fila.cellIterator();
			Cell celda;
			
			 // Se Recorre Cada Celda de la fila del Excel
			while (iterador.hasNext()) {
				
				// Creo Objeto Usuario
				Usuario usuario = new Usuario();
				
				// Leo Celda Nombre del Excel
				celda = iterador.next();
				usuario.setNombre(celda.getStringCellValue());
				
				// Leo Celda Apellido del Excel
				celda = iterador.next();
				usuario.setApellido(celda.getStringCellValue());
				
				// Leo Celda Email del Excel
				celda = iterador.next();
				usuario.setEmail(celda.getStringCellValue());
				
				// Leo Celda Rol del Excel
				celda = iterador.next();
				//usuario.setIdRol(Double.valueOf(celda.getNumericCellValue()));
				
				System.out.println(usuario.toString());
				
				// Agrego a Lista de Usuarios
				usuarios.add(usuario);
			}
		}
		return usuarios;
	}
	
public ArrayList<Persona> leerHojaPersonas() {
		
		// Creacion de Lista de Personas
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		// Obtiene Todas las Filas de Excel
		Iterator<Row> rowIterator = sheet.iterator();
		Row fila;
		
		// Con Esto Descarto Primera Fila con Titulos
		rowIterator.next(); 
		
		// Se Recorre Cada Fila Hasta el Final
		System.out.println("Lista Personas");
		while (rowIterator.hasNext()) {
		
			// Recorro Fila del Excel
			fila = rowIterator.next();
			
			 // Se Obtienen celdas de fila del Excel
			Iterator<Cell> iterador = fila.cellIterator();
			Cell celda;
			
			 // Se Recorre Cada Celda de la fila del Excel
			while (iterador.hasNext()) {
				
				// Creo Objeto Persona
				Persona persona = new Persona();
				
				// Leo Celda Nombre del Excel
				celda = iterador.next();
				persona.setNombre(celda.getStringCellValue());
				
				// Leo Celda Apellido del Excel
				celda = iterador.next();
				persona.setApellido(celda.getStringCellValue());
				
				// Leo Celda DNI del Excel
				celda = iterador.next();
				persona.setDni(celda.getStringCellValue());
				
				// Leo Celda Funcion del Excel
				celda = iterador.next();
				//persona.setIdFuncion(Double.valueOf(celda.getNumericCellValue()));
				
				// Leo Celda Matricula del Excel
				celda = iterador.next();
				persona.setMatricula(celda.getStringCellValue());
				
				System.out.println(persona.toString());
				
				// Agrego a Lista de Personas
				personas.add(persona);
			}
		}
		return personas;
	}
	
}	
