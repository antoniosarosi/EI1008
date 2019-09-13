package practica2;

import java.util.Scanner;

public class Ej08 {

    public static void main(String[] args) throws ExcepcionFechaInvalida {

        Fecha fechaNacimiento = new Fecha(10, 7, 1999);
        Fecha fechaMax = new Fecha(1, 1, 2010);
        Fecha fechaMin = new Fecha(1, 1, 1900);

        Fecha mínimaFechaPosterior = new Fecha(1, 1, 2010);
        Fecha máximaFechaAnterior = new Fecha(1, 1, 1900);

        int intentos = 0;

        System.out.println("Adivina mi fecha de nacimiento\n");
        Scanner sc = new Scanner(System.in);

        boolean acierto = false;

        do {
            try {
                System.out.println();
                System.out.print("Día: "); int día = sc.nextInt();
                System.out.print("Mes: "); int mes = sc.nextInt();
                System.out.print("Año: "); int año = sc.nextInt();
                System.out.println();

                Fecha fecha = new Fecha(día, mes, año);

                intentos++; // Tenemos en cuenta intentos erróneos como fechas no válidas

                // Fecha no correcta para el juego (posterior a 2010 o anterior a 1900)
                if (fecha.compareTo(fechaMax) > 0) throw new ExcepcionEj07FechaNoCorrecta();
                if (fecha.compareTo(fechaMin) < 0) throw new ExcepcionEj07FechaNoCorrecta();

                // Establecer máxima fecha anterior y mínima fecha posterior
                if (fecha.compareTo(fechaNacimiento) < 0 && fecha.compareTo(máximaFechaAnterior) > 0)
                    máximaFechaAnterior = new Fecha(día, mes, año);

                else if (fecha.compareTo(fechaNacimiento) > 0 && fecha.compareTo(mínimaFechaPosterior) < 0)
                    mínimaFechaPosterior = new Fecha(día, mes, año);

                // Notificar intentos absurdos
                if (fecha.compareTo(máximaFechaAnterior) < 0)
                    System.out.println("Este intento no tiene sentido ya que se ha dado una fecha ANTERIOR a " +
                            "la máxima fecha anterior proporcionada antes, que es " + máximaFechaAnterior.toString());

                else if (fecha.compareTo(mínimaFechaPosterior) > 0)
                    System.out.println("Este intento no tiene sentido ya que se ha dado una fecha POSTERIOR a " +
                            "la mínima fecha posterior proporcionada antes, que es " + mínimaFechaPosterior.toString());

                // Comprobar acierto
                acierto = fecha.equals(fechaNacimiento);

                if (! acierto)
                    if (fecha.compareTo(fechaNacimiento) > 0)
                        System.out.println("La fecha que buscas es anterior");
                    else
                        System.out.println("La fecha que buscas es posterior");
            }

            catch (ExcepcionFechaInvalida e) {
                System.out.println("Error. La fecha que has introducido no es correcta, intenta otra vez");
            }

            catch (ExcepcionEj07FechaNoCorrecta e) {
                System.out.println("Ha ocurrido un error. Solo funciona con fechas válidas desde " +
                        fechaMin.toString() + " hasta " + fechaMax.toString());
            }

        } while (! acierto);

        sc.close();
        System.out.println("Has acertado, te ha tomado " + intentos + " intentos");
    }
}
