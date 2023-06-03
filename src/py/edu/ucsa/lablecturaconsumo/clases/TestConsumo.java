package py.edu.ucsa.lablecturaconsumo.clases;

import java.util.ArrayList;

import java.util.List;

import py.edu.ucsa.interfaces.Calculable;

public class TestConsumo {

	public static void main(String[] args) {

		Lectura.tomarDatosLecturas();
		Facturador facturador = new Facturador();

		List<Calculable> listaClientes = new ArrayList<>();
		listaClientes.addAll(Lectura.clientes);

		facturador.procesarConsumos(listaClientes);
		facturador.generarFacturas(Lectura.clientes);
	}

}
