package py.edu.ucsa.lablecturaconsumo.clases;

public class Comercio extends Cliente {
	private int porcentajeComercio;

	public int getPorcentajeComercio() {
		return porcentajeComercio;
	}

	public void setPorcentajeComercio(int porcentajeComercio) {
		this.porcentajeComercio = porcentajeComercio;
	}

	private void sumarMontoConsumo(double montoASumar) {
		setMontoConsumo(getMontoConsumo() + montoASumar);
	}

	@Override
	public void calcularConsumo() {

		for (Lectura lectura : this.getLecturas()) {
			double total = lectura.getConsumoKWH() * PRECIO_KWH;
			double montoConsumoLectura = total + (total * this.porcentajeComercio / 100);
			sumarMontoConsumo(montoConsumoLectura);

		}

	}

}
