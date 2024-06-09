package utilidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import controladores.Inicio;

public class Util {

	public static String creacionNombreFichero() {
		String nombre;
		LocalDate fecha=LocalDate.now();
		DateTimeFormatter formatoDateFormatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		nombre=formatoDateFormatter.format(fecha);
		
		return nombre;
	}
	
	public long autogeneracioIdVehiculo() {
		long id;
		int tamanio=Inicio.listaVehiculos.size();
		if (tamanio==0) {
			id=1;
		} else {

			long nuevoId=Inicio.listaVehiculos.get(tamanio).getId()+1;
		id=nuevoId;	
		}
		return id;
	}
	
	public long autogeneracioIdPrpietario() {
		long id;
		int tamanio=Inicio.listaPropietario.size();
		if (tamanio==0) {
			id=1;
		} else {

			long nuevoId=Inicio.listaPropietario.get(tamanio).getId()+1;
		id=nuevoId;	
		}
		return id;
	}
}
