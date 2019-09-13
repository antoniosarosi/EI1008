package practica2;

import java.util.Scanner;

public class Ej07  {

    public static void main(String[] args) throws ExcepcionFechaInvalida {

        Fecha fechaNacimiento = new Fecha(10, 7, 1999);
        Fecha fechaMax = new Fecha(1, 1, 2010);
        Fecha fechaMin = new Fecha(1, 1, 1900);

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

                intentos++;

                // Fechas no válidas para el juego
                if (fecha.compareTo(fechaMax) > 0) throw new ExcepcionEj07FechaNoCorrecta();
                if (fecha.compareTo(fechaMin) < 0) throw new ExcepcionEj07FechaNoCorrecta();

                acierto = fecha.equals(fechaNacimiento);

                if (! acierto)
                    if (fecha.compareTo(fechaNacimiento) > 0)
                        System.out.println("La fecha que buscas es anterior");
                    else
                        System.out.println("La fecha que buscas es posterior");
            }

            catch (ExcepcionFechaInvalida e) {
                System.out.println("La fecha que has introducido no es correcta, intenta otra vez");
            }

            catch (ExcepcionEj07FechaNoCorrecta e) {
                System.out.println("Solo fechas válidas desde 1/1/1900 a 1/1/2010");
            }

        } while (! acierto);

        sc.close();
        System.out.println("Has acertado, te ha tomado " + intentos + "intentos");
    }
}
