package py.edu.ucsa.lablecturaconsumo.clases;

public class TarifaSocial extends Cliente {
	private int porcentajeTolerancia;

	public int getPorcentajeTolerancia() {
		return porcentajeTolerancia;
	}

	public void setPorcentajeTolerancia(int porcentajeTolerancia) {
		this.porcentajeTolerancia = porcentajeTolerancia;
	}
	
	private void sumarMontoConsumo(double montoASumar) {
		setMontoConsumo(getMontoConsumo() + montoASumar);
	}

	@Override
	public void calcularConsumo() {
		
		int consumoMinimo=300;
		int porcentaje=(consumoMinimo/100) * getPorcentajeTolerancia();
		for (Lectura lectura : this.getLecturas()) {
			if(lectura.getConsumoKWH() < (consumoMinimo + porcentaje)) {
				double montoPagarLectura = (lectura.getConsumoKWH() * PRECIO_KWH) / 2;
				sumarMontoConsumo(montoPagarLectura);
			}else {
				double montoPagarLectura = lectura.getConsumoKWH() * PRECIO_KWH;
				sumarMontoConsumo(montoPagarLectura);
			}
		}

	}

}
