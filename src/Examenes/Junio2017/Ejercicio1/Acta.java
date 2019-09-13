package Examenes.Junio2017.Ejercicio1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Acta {

    private String código;
    private int curso;
    private NotaEstudiante[] notas;

    public Acta(String código, int curso, NotaEstudiante[] notas) {
        this.código = código;
        this.curso = curso;
        this.notas = notas;
    }

    // busqueda binaria iterativa, O(log n)
    public void calificar(String DNI, double nota) {
        int inicio = 0;
        int fin = notas.length - 1;
        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            if (notas[mitad].getDNI().compareTo(DNI) > 0)
                fin = mitad - 1;
            else if (notas[mitad].getDNI().compareTo(DNI) < 0)
                inicio = mitad + 1;
            else {
                notas[mitad].setNota(nota);
                return;
            }
        }
        throw new NoSuchElementException();
    }

    // O(n)
    public void enviarSMS(String[] vectorDNI) {
        int i1 = 0, i2 = 0;
        while (i1 < notas.length && i2 < vectorDNI.length) {
            if (notas[i1].getDNI().compareTo(vectorDNI[i2]) < 0)
                i1++;
            else if (notas[i1].getDNI().compareTo(vectorDNI[i2]) > 0)
                i2++;
            else {
                SMS.enviar(notas[i1].getDNI(), notas[i1].getNota());
                i2++;
            }
        }
    }

    public Acta siguienteConvocatoria() {

        LinkedList<NotaEstudiante> nuevaActa = new LinkedList<>();
        /* La lista enlazada es para no recorrer el vector notas dos veces. Habría que recorrerlo una vez solo para
           contar a los suspensos y no presentados para saber el tamaño del vector de la nueva acta, y luego otra vez
           para meter dentro a los suspensos y no presentados. Eso seguiría siendo O(n) pero no tiene mucho sentido */

        for (NotaEstudiante estudiante : notas)
            if (! estudiante.getPresentado())
                nuevaActa.add(new NotaEstudiante(estudiante.getDNI(), estudiante.getConvocatoria()));
            else if (estudiante.getNota() < 5)
                nuevaActa.add(new NotaEstudiante(estudiante.getDNI(), estudiante.getConvocatoria() + 1));

        NotaEstudiante[] nuevoVector = new NotaEstudiante[nuevaActa.size()];
        int i = 0;
        for (NotaEstudiante estudiante : nuevaActa) {
            nuevoVector[i] = estudiante;
            i++;
        }
        return new Acta(código, curso, nuevoVector);
    }
}
