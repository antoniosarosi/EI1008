package Examenes.Julio2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CalificacionesFinales {

    private Estudiante[] estudiantes;

    public CalificacionesFinales() {
        this.estudiantes = new Estudiante[0];
    }

    public static boolean esBásica(String asignatura) {
        return true;
    }

    public CalificacionesFinales(String nombreFichero) throws FileNotFoundException {

        // Guardar los estudiantes de uno en uno
        List<Estudiante> listaEstudiantes = new LinkedList<>();

        Scanner sc = new Scanner(new File(nombreFichero));
        while (sc.hasNextLine()) {
            boolean dentroDeLaLista = false;
            String dni = sc.next();
            String asignatura = sc.next();
            double nota = sc.nextDouble();
            // Buscar si estaba y actualizarlo si tiene suspensos
            for (Estudiante e : listaEstudiantes)
                if (e.getDni().equals(dni)) {
                    dentroDeLaLista = true;
                    if (nota < 5)
                        e.contarSuspensa(esBásica(asignatura));
                    break;
                }
            // Si no estaba creamos uno nuevo
            if (! dentroDeLaLista)
                listaEstudiantes.add(new Estudiante(dni));
        }
        // Ahora ya sabemos el tamaño que tendrá el vector, lo creamos y metemos a los estudiantes
        estudiantes = new Estudiante[listaEstudiantes.size()];
        int i = 0;
        for (Estudiante e : listaEstudiantes) {
            estudiantes[i] = e;
            i++;
        }
    }

}
