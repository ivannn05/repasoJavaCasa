package controladores;

import java.util.ArrayList;
import java.util.List;

import dtos.PropietarioDto;
import dtos.VehiculoDto;
import sevicios.FicheroImplementacion;
import sevicios.FicheroInterfaz;
import sevicios.MenuImplementacion;
import sevicios.MenuInterfaz;
import sevicios.OperativaImplementacion;
import sevicios.OperativaInterfaz;

public class Inicio {
	public static List<VehiculoDto> listaVehiculos = new ArrayList<VehiculoDto>();
	public static List<PropietarioDto> listaPropietario = new ArrayList<PropietarioDto>();

	public static void main(String[] args) {
		FicheroInterfaz fi= new FicheroImplementacion();
		MenuInterfaz mi = new MenuImplementacion();
		OperativaInterfaz op= new OperativaImplementacion();
try {
	fi.cargaDeFichero();
} catch (Exception e) {
	System.out.println("No hay datos anteriores");
}
		boolean cerrarMeu=false;
		int opc;
		for (VehiculoDto vehi : listaVehiculos) {
			System.out.println("Matricula"+vehi.getMatriculaString()+"\n");
			System.out.println("FechaMatriculacion"+vehi.getFechaMatriculacion());    
		}
		System.out.println("-----------");
		for (PropietarioDto vehi : listaPropietario) {
			System.out.println("DNI"+vehi.getDni()+"\n");
			System.out.println("FechaCompra"+vehi.getFechaCompra());    
		}
		while (!cerrarMeu) {
			opc=mi.mostrarMenuYSeleccion();
			try {	
			switch (opc) {
			
			case 0:
				cerrarMeu=true;
				System.out.println("Selecciono cerrar menu");
				fi.ficheroLog("Selecciono cerrar menu");
				break;
			case 1:
				System.out.println("Selecciono saludar");
				fi.ficheroLog("Selecciono saludar");
				break;

			default:
				System.out.println("Selecciono una opcion no existente");
				fi.ficheroLog("Selecciono una opcion no existente");
				break;
			}
			
			}catch (Exception e) {
				System.out.println("Ocurrio un error en la aplicacion");
				fi.ficheroLog("Ocurrio un error en la aplicacion Error:".concat(e.getMessage()));
			}
			
		}
		
	}

}
