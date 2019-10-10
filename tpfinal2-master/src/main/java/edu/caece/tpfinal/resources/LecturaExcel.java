package edu.caece.tpfinal.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.caece.tpfinal.domain.Usuario;

public class LecturaExcel {
	
	protected String nombreArchivo = "Datos.xlsx";
	protected String rutaArchivo = "C:\\TP-FINAL\\" + nombreArchivo;

	public void leerExcel() {
		try {
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			XSSFWorkbook worbook = new XSSFWorkbook(file); // Leer Archivo Excel
			XSSFSheet sheet = worbook.getSheetAt(0); // Obtener Hoja a Leer
			recorrerDatosHoja(sheet);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Usuario> obtenerUsuarios() {
		ArrayList<Usuario> usuarios = null;
		try {
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			XSSFWorkbook worbook = new XSSFWorkbook(file); // Leer Archivo Excel
			XSSFSheet sheet = worbook.getSheetAt(0); // Obtener Hoja a Leer
			usuarios = leerHojaUsuarios(sheet);
		} catch (Exception e) {
			e.getMessage();
		} finally {
			return usuarios;
		}
	}
	
	public void recorrerDatosHoja(XSSFSheet sheet) {
		Iterator<Row> rowIterator = sheet.iterator(); // Obtener Filas de Excel
		Row row;
		while (rowIterator.hasNext()) { // Se Recorre Cada Fila Hasta el Final
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator(); // Se Obtiene Celdas por Fila
			Cell cell;
			while (cellIterator.hasNext()) { // Se Recorre Cada Celda
				cell = cellIterator.next(); // Se Obtiene Celda en Específico y se Imprime
				System.out.print(cell.getStringCellValue()+" | ");
			}
			System.out.println();
		}
	}

	public ArrayList<Usuario> leerHojaUsuarios(XSSFSheet sheet) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Iterator<Row> rowIterator = sheet.iterator(); // Obtener Filas de Excel
		Row row;
		while (rowIterator.hasNext()) { // Se Recorre Cada Fila Hasta el Final
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator(); // Se Obtiene Celdas por Fila
			Cell cell;
			while (cellIterator.hasNext()) { // Se Recorre Cada Celda
				Usuario usuario = new Usuario();
				cell = cellIterator.next();
				usuario.setNombre(cell.getStringCellValue());
				cell = cellIterator.next();
				usuario.setApellido(cell.getStringCellValue());
				cell = cellIterator.next();
				usuario.setEmail(cell.getStringCellValue());
				cell = cellIterator.next();
				usuario.setContrasenia(cell.getStringCellValue());
				usuarios.add(usuario);
			}
		}
		return usuarios;
	}
	
}	
