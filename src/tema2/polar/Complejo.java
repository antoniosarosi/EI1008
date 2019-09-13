package tema2.polar;

public class Complejo {

	private double módulo;
	private double argumento;
	private static final double epsilon = 1E-10;

	public Complejo() {
		módulo = argumento = 0;
	}

	public Complejo(double parteReal, double parteImag) {
		módulo = Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImag, 2));
		argumento = Math.atan2(parteImag, parteReal);
	}

	public Complejo(Complejo otroComplejo) {
		módulo = otroComplejo.módulo;
		argumento = otroComplejo.argumento;
	}

	public double getParteReal() {
		return módulo * Math.cos(argumento);
	}

	public double getParteImag() {
		return módulo * Math.sin(argumento);
	}

	public double getMódulo() {
		return módulo;
	}

	public double getArgumento() {
		return argumento;
	}

	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (!(objeto instanceof Complejo))
			return false; // Se compara un complejo con un objeto de otra clase
		Complejo c = (Complejo) objeto;
		return Math.abs(módulo - c.módulo) < epsilon
				&& Math.abs(argumento - c.argumento) < epsilon;
	}

	public String toString() {
		return String.format("%.2f + %.2fi", getParteReal(), getParteImag());
	}

	public Complejo sumar(Complejo c) {
		double resParteReal = this.getParteReal() + c.getParteReal();
		double resParteImag = this.getParteImag() + c.getParteImag();
		Complejo resultado = new Complejo(resParteReal, resParteImag);
		return resultado;
	}

	public Complejo multiplicar(Complejo c) {
		Complejo resultado = new Complejo();
		resultado.módulo = this.módulo * c.módulo;
		resultado.argumento = this.argumento + c.argumento;
		return resultado;
	}
}
