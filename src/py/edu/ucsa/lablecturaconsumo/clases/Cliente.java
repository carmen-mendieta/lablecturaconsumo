package py.edu.ucsa.lablecturaconsumo.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.edu.ucsa.interfaces.Calculable;

public abstract class Cliente implements Calculable {
	private int suministro;
	protected List<Lectura> lecturas = new ArrayList<>();
	private double montoConsumo;
	public static final int PRECIO_KWH = 458;

	public int getSuministro() {
		return suministro;
	}

	public void setSuministro(int suministro) {
		this.suministro = suministro;
	}

	public List<Lectura> getLecturas() {
		return lecturas;
	}

	public void setLecturas(List<Lectura> lecturas) {
		this.lecturas = lecturas;
	}

	public void agregarLectura(Lectura lectura) {
		this.lecturas.add(lectura);
	}

	public double getMontoConsumo() {
		return montoConsumo;
	}

	public void setMontoConsumo(double montoConsumo) {
		this.montoConsumo = montoConsumo;
	}

	public static int getPrecioKwh() {
		return PRECIO_KWH;
	}

	@Override
	public String toString() {
		return "Cliente [suministro=" + suministro + ", lecturas=" + lecturas + ", montoConsumo=" + montoConsumo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(suministro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return suministro == other.suministro;
	}
	

}

