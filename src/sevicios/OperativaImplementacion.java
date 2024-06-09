package sevicios;

import java.util.Scanner;

import controladores.Inicio;
import dtos.VehiculoDto;

public class OperativaImplementacion implements OperativaInterfaz {
	Scanner sc = new Scanner(System.in);

	@Override
	public void eliminarCliente() {
		String matriculaString = "a";
		System.out.println("Escriba la matricula a eliminar");
		sc.next(matriculaString);
		boolean contador = false;
		VehiculoDto vehiculo = new VehiculoDto();
		for (VehiculoDto vehi : Inicio.listaVehiculos) {
			if (vehi.getMatriculaString().equals(matriculaString)) {
				vehiculo = vehi;
				contador = true;
				break;
			}

		}
		Inicio.listaVehiculos.remove(vehiculo);
		if (contador = true) {

			System.out.println("No se a aencontrado la matricula");
		}

	}

}
