package py.edu.ucsa.lablecturaconsumo.clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import py.edu.ucsa.interfaces.Calculable;

public class Facturador {

	public void procesarConsumos(List<Calculable> clientes) {

		for (Calculable cliente : clientes) {
			cliente.calcularConsumo();
		}
	}

	public void generarFacturas(List<Cliente> clientes) {
		if (clientes != null) {
			for (Cliente c : clientes) {

				try {
					File file = new File("consumo-cliente" + c.getSuministro() + ".txt");
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

					String contenido = "";
					contenido = "El consumo del cliente " + c.getSuministro() + " es " + c.getMontoConsumo();
					bufferedWriter.write(contenido);
					bufferedWriter.close();

				} catch (IOException e) {
					System.out.println("Error al intentar generar el archivo facturas.txt. Error:" + e.getMessage());
					e.printStackTrace();
				}
			}

		}
	}

}
