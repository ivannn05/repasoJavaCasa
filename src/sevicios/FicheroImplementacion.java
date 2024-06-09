package sevicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import dtos.PropietarioDto;
import dtos.VehiculoDto;

public class FicheroImplementacion implements FicheroInterfaz {

	@Override
	public void ficheroLog(String mensaje) {

		String ruta="C:\\Users\\IVAN IMFORMATICA\\Desktop\\Log-".concat(utilidades.Util.creacionNombreFichero()).concat(".txt");
		try {
			BufferedWriter escribe = new BufferedWriter(new FileWriter(ruta,true));
			escribe.write(mensaje.concat("\n"));
			escribe.close();
		} catch (IOException e) {
			System.out.println(" Error 404 :Ocurrio un error en el fichero log");
		}
		
	}

	@Override
	public void cargaDeFichero() {
		String ruta="C:\\Users\\IVAN IMFORMATICA\\Desktop\\vehiculosYpropietarios.txt";
		try {
			String linea;
			BufferedReader leer =new BufferedReader(new FileReader(ruta));
			while ((linea=leer.readLine() )!= null) {
				String[] arrayLineas=linea.split(";");
				PropietarioDto propietario=new PropietarioDto();
				VehiculoDto vehiculo = new VehiculoDto();
				vehiculo.setMatriculaString(arrayLineas[0]);
				LocalDate fecha=LocalDate.parse(arrayLineas[1]);
				vehiculo.setFechaMatriculacion(fecha);
				propietario.setDni(arrayLineas[2]);
				LocalDate fechaCompra=LocalDate.parse(arrayLineas[3]);
				propietario.setFechaCompra(fechaCompra);
			}
			leer.close();
			
			
			
		} catch (Exception e) {
			System.out.println(" Error 505 :Ocurrio un error en la carga del fichero");
			ficheroLog("Ocurrio un error en la carga del fichero Error:".concat(e.getMessage()));
		}
		
	}

}
