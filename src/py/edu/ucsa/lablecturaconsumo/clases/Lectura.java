package py.edu.ucsa.lablecturaconsumo.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import py.edu.ucsa.interfaces.Calculable;

public class Lectura {
	private int suministro;
	private LocalDate lecturaAnterior;
	private LocalDate lecturaActual;
	private int consumoKWH;
	private String categoria;
	public static final List<Cliente> clientes = new ArrayList<>();

	public static void tomarDatosLecturas() {
		try (FileReader reader = new FileReader("LECTURA.txt");) {
			BufferedReader bufReader = new BufferedReader(reader);
			Lectura lectura = null;
			String line = null;
			Cliente cliente = null;

			while ((line = bufReader.readLine()) != null) {
				if (!line.equals("")) {
					cliente = null;
					String[] datoslectura = line.split("\t");
					lectura = new Lectura();
					lectura.setLecturaActual(getFechaLectura(datoslectura[0]));
					lectura.setLecturaAnterior(getFechaLectura(datoslectura[1]));

					int suministro = Integer.parseInt(datoslectura[2]);
					lectura.setSuministro(suministro);
					lectura.setConsumoKWH(Integer.parseInt(datoslectura[3]));

					String categoria = datoslectura[4];
					lectura.setCategoria(categoria);

					if ("S".equals(categoria)) {
						TarifaSocial clienteTarifaSocial = new TarifaSocial();
						clienteTarifaSocial.setPorcentajeTolerancia(12);
						clienteTarifaSocial.setSuministro(suministro);

						cliente = clienteTarifaSocial;
					} else if ("C".equals(categoria)) {
						Comercio clienteComercio = new Comercio();
						clienteComercio.setSuministro(suministro);
						clienteComercio.setPorcentajeComercio(18);

						cliente = clienteComercio;
					} else if ("I".equals(categoria)) {
						Industrial clienteIndustrial = new Industrial();
						clienteIndustrial.setSuministro(suministro);
						clienteIndustrial.setPorcentajeSubsidio(25);

						cliente = clienteIndustrial;
					} else if ("R".equals(categoria)) {
						Residencial clienteResidencial = new Residencial();
						clienteResidencial.setSuministro(suministro);

						cliente = clienteResidencial;
					}

					int indexClienteExistente = clientes.indexOf(cliente);
					if (indexClienteExistente != -1) {
						clientes.get(indexClienteExistente).agregarLectura(lectura);
					} else {
						cliente.agregarLectura(lectura);
						clientes.add(cliente);
					}

				}
			}

			for (Cliente cli : clientes) {
				System.out.println("Cliente con suministro " + cli.getSuministro());
				System.out.println("Lecturas:");
				for (Lectura lec : cli.getLecturas()) {
					System.out.println("Consumo: " + lec.getConsumoKWH());
					System.out.println("Categoria: " + getDescripcionCategoria(lec.getCategoria()));
					System.out.println("\n");
				}

			}

		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
			System.out.println(e.getMessage());
		}

	}

	private static LocalDate getFechaLectura(String fechaLectura) {
		return LocalDate.parse(fechaLectura, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	private static String getDescripcionCategoria(String codigoCategoria) {
		String descripcionCategoria = "";
		switch (codigoCategoria) {
		case "S": {
			descripcionCategoria = "Tarifa social";
			break;
		}
		case "C": {
			descripcionCategoria = "Comercio";
			break;
		}
		case "I": {
			descripcionCategoria = "Industrial";
			break;
		}
		case "R": {
			descripcionCategoria = "Residencial";
			break;
		}

		}

		return descripcionCategoria;
	}

	public Lectura() {

	}

	public Lectura(int suministro, LocalDate lecturaAnterior, LocalDate lecturaActual, int consumoKWH,
			String categoria) {
		super();
		this.suministro = suministro;
		this.lecturaAnterior = lecturaAnterior;
		this.lecturaActual = lecturaActual;
		this.consumoKWH = consumoKWH;
		this.categoria = categoria;
	}

	public int getSuministro() {
		return suministro;
	}

	public void setSuministro(int suministro) {
		this.suministro = suministro;
	}

	public LocalDate getLecturaAnterior() {
		return lecturaAnterior;
	}

	public void setLecturaAnterior(LocalDate lecturaAnterior) {
		this.lecturaAnterior = lecturaAnterior;
	}

	public LocalDate getLecturaActual() {
		return lecturaActual;
	}

	public void setLecturaActual(LocalDate lecturaActual) {
		this.lecturaActual = lecturaActual;
	}

	public int getConsumoKWH() {
		return consumoKWH;
	}

	public void setConsumoKWH(int consumoKWH) {
		this.consumoKWH = consumoKWH;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
