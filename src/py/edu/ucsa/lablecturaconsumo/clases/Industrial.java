package py.edu.ucsa.lablecturaconsumo.clases;

public class Industrial extends Cliente {
	private int porcentajeSubsidio;

	public int getPorcentajeSubsidio() {
		return porcentajeSubsidio;
	}

	public void setPorcentajeSubsidio(int porcentajeSubsidio) {
		this.porcentajeSubsidio = porcentajeSubsidio;
	}
	
	private void sumarMontoConsumo(double montoASumar) {
		setMontoConsumo(getMontoConsumo() + montoASumar);
	}

	@Override
	public void calcularConsumo() {
		
		int consumoTope=1000;
		for (Lectura lectura : this.getLecturas()) {
			if(lectura.getConsumoKWH() > consumoTope) {
				int consumoSubsidio=(lectura.getConsumoKWH() / 100) * getPorcentajeSubsidio();
				double montoPagarLectura = (lectura.getConsumoKWH() * PRECIO_KWH) - consumoSubsidio;
				sumarMontoConsumo(montoPagarLectura);
			}else {
				int consumoSubsidio=(lectura.getConsumoKWH() / 100) * 5;
				double montoPagarLectura = (lectura.getConsumoKWH() * PRECIO_KWH) - consumoSubsidio;
				sumarMontoConsumo(montoPagarLectura);
			}
		}
		
		
	}

}
