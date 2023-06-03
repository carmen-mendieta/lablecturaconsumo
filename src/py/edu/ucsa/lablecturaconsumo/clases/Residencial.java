package py.edu.ucsa.lablecturaconsumo.clases;

public class Residencial extends Cliente {
	
	private void sumarMontoConsumo(double montoASumar) {
		setMontoConsumo(getMontoConsumo() + montoASumar);
	}

	@Override
	public void calcularConsumo() {
		for (Lectura lectura : this.getLecturas()) {
			double montoConsumo = lectura.getConsumoKWH() * PRECIO_KWH;
			sumarMontoConsumo(montoConsumo);
		}
		
	}

}
