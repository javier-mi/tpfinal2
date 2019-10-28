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

	protected String rutaArchivo = "";
	
	XSSFWorkbook worbook = null;
	XSSFSheet sheet = null;
	
	@SuppressWarnings("finally")
	public ArrayList<Usuario> obtenerUsuarios() {
		ArrayList<Usuario> usuarios = null;
		try {
			String path = System.getProperty("user.dir");
			rutaArchivo = path + "\\src\\main\\resources\\bd\\TP-FINAL\\Datos.xlsx";
			leerExcel();
			usuarios = leerHojaUsuarios();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			return usuarios;
		}
	}
	
	public void leerExcel() {
		try {
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			worbook = new XSSFWorkbook(file); // Leer Archivo Excel
			sheet = worbook.getSheetAt(0); // Obtener Hoja a Leer
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void recorrerDatosHoja() {
		Iterator<Row> rowIterator = sheet.iterator(); // Obtener Filas de Excel
		Row row;
		rowIterator.next(); // Primera fila contiene tìtulos
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

	public ArrayList<Usuario> leerHojaUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Iterator<Row> rowIterator = sheet.iterator(); // Obtener Filas de Excel
		Row row;
		rowIterator.next(); // Primera fila contiene tìtulos
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
				System.out.println(usuario.toString());
				usuarios.add(usuario);
			}
		}
		return usuarios;
	}
	
}	
