package tema2.binomica;

public class Complejo {

	private double parteReal;
	private double parteImag;
	private static final double epsilon = 1E-10;

	public Complejo() {
		parteReal = parteImag = 0;
	}

	public Complejo(double parteReal, double parteImag) {
		this.parteReal = parteReal;
		this.parteImag = parteImag;
	}

	public Complejo(Complejo otroComplejo) {
		parteReal = otroComplejo.parteReal;
		parteImag = otroComplejo.parteImag;
	}

	public double getParteReal() {
		return parteReal;
	}

	public double getParteImag() {
		return parteImag;
	}

	public double getMódulo() {
		return Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImag, 2));
	}

	public double getArgumento() {
		return Math.atan2(parteImag, parteReal);
	}

	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (!(objeto instanceof Complejo))
			return false; // Se compara un complejo con un objeto de otra clase
		Complejo c = (Complejo) objeto;
		return Math.abs(parteReal - c.parteReal) < epsilon
				&& Math.abs(parteImag - c.parteImag) < epsilon;
	}

	public String toString() {
		return String.format("%.2f + %.2fi", parteReal, parteImag);
	}

	public Complejo sumar(Complejo c) {
		double resParteReal = this.parteReal + c.parteReal;
		double resParteImag = this.parteImag + c.parteImag;
		Complejo resultado = new Complejo(resParteReal, resParteImag);
		return resultado;
	}

	public Complejo multiplicar(Complejo c) {
		double resParteReal = this.parteReal * c.parteReal - this.parteImag * c.parteImag;
		double resParteImag = this.parteReal * c.parteImag + this.parteImag * c.parteReal;
		Complejo resultado = new Complejo(resParteReal, resParteImag);
		return resultado;
	}
}
