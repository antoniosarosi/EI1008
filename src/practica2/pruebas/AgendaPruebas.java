package practica2.pruebas;

import practica2.Ej10.Agenda;
// import practica2.Ej09.Agenda;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;
import practica2.Tarea;

import java.util.Arrays;

public class AgendaPruebas {

    public static void main(String[] args) throws ExcepcionFechaInvalida {

        // Prueba para el método añadir

        Agenda agenda = new Agenda();

        Tarea tarea1 = new Tarea(new Fecha(1, 4, 2019), "Examen Arquitectura Computadores");
        agenda.añadir(tarea1);

        System.out.println(agenda.toString());

        System.out.println("Debería haber 1 tarea: hay " + agenda.cantidad() +
                (agenda.cantidad() == 1 ? " (BIEN)\n" : " (ERROR)\n"));

        Tarea tarea2 = new Tarea(new Fecha(8, 4, 2019), "Examen Física");
        agenda.añadir(tarea2);

        System.out.println(agenda.toString());

        System.out.println("Ahora debería haber 2 tareas: hay " + agenda.cantidad() +
                (agenda.cantidad() == 2 ? " (BIEN)\n" : " (ERROR)\n"));

        Tarea tarea3 = new Tarea(new Fecha(17, 12, 2018), "Examen Estructura Computadores");
        agenda.añadir(tarea3);

        System.out.println("Hemos añadido una tarea (Examen Estructura Computadores) anterior a las 2 de antes, debería salir como primera:\n");
        System.out.println(agenda.toString());

        Tarea tarea4 = new Tarea(new Fecha(5, 4, 2019), "Comprar leche");
        agenda.añadir(tarea4);

        System.out.println("Hemos añadido una tarea (Comprar leche) que debería salir como tercera: \n");
        System.out.println(agenda.toString());

        Tarea tarea5 = new Tarea(new Fecha(19, 12, 2018), "Examen Matemáticas I");
        agenda.añadir(tarea5);

        System.out.println("Hemos añadido una tarea (Examen Matemáticas) que debería salir como segunda: \n");
        System.out.println(agenda.toString());

        Tarea tarea6 = new Tarea(new Fecha(7, 4, 2019), "Comprar Pan");
        agenda.añadir(tarea6);

        System.out.println("Hemos añadido una tarea (Comprar Pan) que debería salir como penúltima: \n");
        System.out.println(agenda.toString());

        Tarea tarea7 = new Tarea(new Fecha(3, 4, 2019), "Deberes Programación");
        agenda.añadir(tarea7);

        System.out.println("Hemos añadido una tarea (Deberes Programación) que debería salir como cuarta: \n");
        System.out.println(agenda.toString());

        Tarea tarea8 = new Tarea(new Fecha(1, 1, 2020), "Comprar PC");
        agenda.añadir(tarea8);

        Tarea tarea9 = new Tarea(new Fecha(1, 6, 2020), "Ir de vacaciones");
        agenda.añadir(tarea9);

        System.out.println("Hemos añadido dos tareas que deberían salir al final: \n");
        System.out.println(agenda.toString());

        Tarea tarea10 = new Tarea(new Fecha(12, 12, 2018), "Examen Ingles");
        agenda.añadir(tarea10);

        System.out.println("Hemos añadido una tarea que debería salir primera: \n");
        System.out.println(agenda.toString());

        // Prueba para el método consultar

        System.out.println("Pruebas del método consultar: \n");

        Tarea tarea11 = new Tarea(new Fecha(17, 3, 2019), "Hacer la cena");
        agenda.añadir(tarea11);

        Tarea tarea12 = new Tarea(new Fecha(17, 3, 2019), "Hacer la compra");
        agenda.añadir(tarea12);

        Tarea tarea13 = new Tarea(new Fecha(17, 3, 2019), "fregar platos");
        agenda.añadir(tarea13);

        System.out.println(agenda.toString());
        System.out.println();

        System.out.println("Consulta para el día 17/03/2019: ");
        System.out.println(Arrays.toString(agenda.consultar(new Fecha(17, 3, 2019))) + "\n");

        System.out.println("Consulta para el día 17/2/2018: ");
        System.out.println(Arrays.toString(agenda.consultar(new Fecha(17, 12, 2018))) + "\n");

        System.out.println("Consulta para el día 1/1/2030: ");
        System.out.println(Arrays.toString(agenda.consultar(new Fecha(1, 1, 2030))));
        System.out.println();

        // Prueba método borrarPasadas y borrar

        System.out.println("Pruebas de borrarPasadas y borrar \n");

        Tarea tarea14 = new Tarea(new Fecha(14, 3, 2019), "Una tarea al azar");
        agenda.añadir(tarea14);

        System.out.println(agenda.toString());

        agenda.borrarPasadas(new Fecha(1, 1, 2019));

        System.out.println("Hemos borrado lo anterior al día 1 de enero de 2019\n");
        System.out.println(agenda.toString());

        System.out.println("Hemos borrado lo anterior a hoy\n");
        agenda.borrar();

        System.out.println(agenda.toString());

        System.out.println("Borramos todo lo anterior al primer día de 2020\n");

        agenda.borrarPasadas(new Fecha(1, 1, 2020));
        System.out.println(agenda.toString());

        System.out.println("\n\nUnas últimas pruebas para casos poco comunes al borrar:\n");
        agenda = new Agenda();

        for (int i = 1; i < 31; i++)
            agenda.añadir(new Tarea(new Fecha(i, 3, 2019), "tarea " + i));

        System.out.println(agenda);

        System.out.println("\nBorrar todas las tareas: \n");
        agenda.borrarPasadas(new Fecha(1, 4, 2019));
        System.out.format("Agenda = ' %s '", agenda);

        agenda = new Agenda();
        for (int i = 1; i < 31; i++)
            agenda.añadir(new Tarea(new Fecha(i, 3, 2019), "tarea " + i));

        System.out.println("\n\nBorrar todas las tareas excepto la última: \n");
        agenda.borrarPasadas(new Fecha(30, 3, 2019));
        System.out.println(agenda);

        agenda = new Agenda();
        for (int i = 1; i < 31; i++)
            agenda.añadir(new Tarea(new Fecha(i, 3, 2019), "tarea " + i));

        System.out.println("\nNo borrar ninguna tarea: ");
        agenda.borrarPasadas(new Fecha(1, 3, 2019));
        System.out.println(agenda);

        System.out.println("PRUEBA TRANBOLIKA");

        agenda = new Agenda();
        int j = 1, k = 3;
        for (int i = 1; i < 82; i++) {
            if (j == 30) { j = 1; k++; }
            agenda.añadir(new Tarea(new Fecha(j, k, 2019), "tarea " + i));
            if (i == 11 || i == 21 || i == 41 || i == 81) System.out.println(agenda);
            j++;
        }

        System.out.println("\nBORRAR PASO A PASO\n");
        j = 1; k = 3;
        for (int i = 1; i < 82; i++) {
            if (j == 30) { j = 1; k++; }
            agenda.borrarPasadas(new Fecha(j, k, 2019));
            if (i == 42 || i == 62 || i == 72 || i == 81) System.out.println(agenda);
            j++;
        }

        agenda = new Agenda();
        j = 1; k = 3;
        for (int i = 1; i < 82; i++) {
            if (j == 31) { j = 1; k++; }
            agenda.añadir(new Tarea(new Fecha(j, k, 2019), "tarea " + i));
            j++;
        }

        System.out.println("\nBORRAR DE GOLPE A LA MITAD\n");
        agenda.borrarPasadas(new Fecha(12, 4, 2019));
        System.out.println(agenda);

        System.out.println("\nBORRAR DE GOLPE A LA MITAD otra vez\n");
        agenda.borrarPasadas(new Fecha(2, 5, 2019));
        System.out.println(agenda);

        System.out.println("\nBORRAR DE GOLPE A LA MITAD otra vez\n");
        agenda.borrarPasadas(new Fecha(17, 5, 2019));
        System.out.println(agenda);


        System.out.println("BORRAR DE GOLPE");
        agenda = new Agenda();
        j = 1; k = 3;
        for (int i = 1; i < 82; i++) {
            if (j == 31) { j = 1; k++; }
            agenda.añadir(new Tarea(new Fecha(j, k, 2019), "tarea " + i));
            j++;
        }
        agenda.borrarPasadas(new Fecha(2, 5, 2019));
        System.out.println(agenda);

        agenda = new Agenda();
        j = 1; k = 3;
        for (int i = 1; i < 82; i++) {
            if (j == 31) { j = 1; k++; }
            agenda.añadir(new Tarea(new Fecha(j, k, 2019), "tarea " + i));
            j++;
        }

        System.out.println("BORRAR TODOOOO");

        agenda.borrarPasadas(new Fecha(21, 5, 2019));
        System.out.println(agenda);
    }

}
