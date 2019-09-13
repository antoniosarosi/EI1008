package tests.practica2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import practica3.Agenda;
import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;
import practica2.Tarea;


public class AgendaTest {

    private Agenda agenda;
    private Tarea[] tars;

    @Before
    public void setUp() throws Exception {
        agenda = new Agenda();
        Tarea tar1 = new Tarea(new Fecha(1, 3, 2019), "Tarea 1");
        Tarea tar2 = new Tarea(new Fecha(10, 3, 2019), "Tarea 2");
        Tarea tar3 = new Tarea(new Fecha(20, 3, 2019), "Tarea 3");
        tars = new Tarea[] {tar1, tar2, tar3};
    }

    @Test
    public void añadirTestLaTareaVaUltima() {
        StringBuilder expectedString = new StringBuilder();
        for (Tarea t : tars) expectedString.append(t).append("\n");
        for (Tarea t : tars) agenda.añadir(t);
        assertEquals("añadir() falla si la tarea va última", expectedString.toString(), agenda.toString());
    }

    @Test
    public void añadirTestLaTareaVaPrimera() throws ExcepcionFechaInvalida {
        Tarea tar = new Tarea(new Fecha(1, 2, 2019), "Esta tarea va antes que todas");
        StringBuilder expectedString = new StringBuilder(tar.toString() + "\n");
        for (Tarea t : tars) expectedString.append(t).append("\n");

        for (Tarea t : tars) agenda.añadir(t);

        agenda.añadir(tar);
        assertEquals("añadir() falla si la tarea va primera", expectedString.toString(), agenda.toString());
    }

    @Test
    public void añadirTestLaTareaVaEnMedio() throws ExcepcionFechaInvalida {
        Tarea tar1 = new Tarea(new Fecha(5, 3, 2019), "Esta tarea va SEGUNDA");
        Tarea tar2 = new Tarea(new Fecha(15, 3, 2019), "Esta tarea va CUARTA");
        Tarea[] tars2 = {tar1, tar2};

        StringBuilder expectedString = new StringBuilder();
        int j = 0, k = 0;
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                expectedString.append(tars[k].toString()).append("\n");
                k++;
            }
            else {
                expectedString.append(tars2[j].toString()).append("\n");
                j++;
            }
        }

        for (Tarea t : tars) agenda.añadir(t);

        agenda.añadir(tar1);
        agenda.añadir(tar2);

        assertEquals("añadir() falla si la tarea va en medio de las que había",
                expectedString.toString(), agenda.toString());
    }

    @Test
    public void consultarTestUnaSolaTareaEnEseDia() {
        for (Tarea t : tars) agenda.añadir(t);
        Tarea[] expected = new Tarea[] {tars[0]};
        assertArrayEquals("consultar() falla si solo hay una tarea en ese día",
                agenda.consultar(tars[0].getFecha()), expected);
    }

    @Test
    public void consultarTestMasDeUnaTareaEnEseDia() throws ExcepcionFechaInvalida {
        for (Tarea t : tars) agenda.añadir(t);
        Tarea tar1 = new Tarea(new Fecha(1, 3, 2019), "Una tarea");
        Tarea tar2 = new Tarea(new Fecha(1, 3, 2019), "Otra tarea");
        agenda.añadir(tar1);
        agenda.añadir(tar2);

        Tarea[] expected = new Tarea[] {tars[0], tar1, tar2};

        assertArrayEquals("consultar() falla si hay más de una tarea ese día",
                agenda.consultar(tars[0].getFecha()), expected);
    }

    @Test
    public void consultarTestNoHayNadaEnEseDia() throws ExcepcionFechaInvalida {
        for (Tarea t : tars) agenda.añadir(t);
        Tarea[] expected = {};

        assertArrayEquals("consultar() falla si ese dia no hay nada",
                agenda.consultar(new Fecha(5,2, 2018)), expected);
    }

    @Test(timeout = 100)
    public void borrarPasadasTestSimple() throws ExcepcionFechaInvalida {
        Tarea tarea1 = new Tarea(new Fecha(12, 12, 2018), "Examen Ingles");
        Tarea tarea2 = new Tarea(new Fecha(17, 12,2018), "Examen Estructura Computadores");
        Tarea tarea3 = new Tarea(new Fecha(19, 12, 2018), "Examen Matemáticas I");
        Tarea tarea4 = new Tarea(new Fecha(14, 3, 2019), "Una tarea al azar");
        Tarea tarea5 = new Tarea(new Fecha(17, 3, 2019), "Hacer la cena");
        Tarea tarea6 = new Tarea(new Fecha(17, 3, 2019), "Hacer la compra");
        Tarea tarea7 = new Tarea(new Fecha(17, 3, 2019), "fregar platos");
        Tarea tarea8 = new Tarea(new Fecha(1, 4, 2019), "Examen Arquitectura Computadores");
        Tarea tarea9 = new Tarea(new Fecha(3, 4, 2019), "Deberes Programación");
        Tarea tarea10 = new Tarea(new Fecha(5, 4, 2019), "Comprar leche");
        Tarea tarea11 = new Tarea(new Fecha(7, 4, 2019), "Comprar Pan");
        Tarea tarea12 = new Tarea(new Fecha(8, 4, 2019), "Examen Física");
        Tarea tarea13 = new Tarea(new Fecha(1, 1, 2020), "Comprar PC");
        Tarea tarea14 = new Tarea(new Fecha(1, 6, 2020), "Ir de vacaciones");

        Tarea[] tareas = {
                tarea1, tarea2, tarea3, tarea4, tarea5, tarea6, tarea7, tarea8,
                tarea9, tarea10, tarea11, tarea12, tarea13, tarea14
        };

        for (Tarea t : tareas) agenda.añadir(t);

        // Borrar pasadas del día 1/1/2019
        Tarea[] expected1 = {
                tarea4, tarea5, tarea6, tarea7, tarea8,
                tarea9, tarea10, tarea11, tarea12, tarea13, tarea14
        };

        StringBuilder expectedString1 = new StringBuilder();
        for (Tarea t : expected1) expectedString1.append(t.toString()).append("\n");

        agenda.borrarPasadas(new Fecha(1, 1, 2019));
        assertEquals("borrarPasadas falla en algo", expectedString1.toString(), agenda.toString());


        // Borrar pasadas del día 1/1/2020
        Tarea[] expected2 = {tarea13, tarea14};

        StringBuilder expectedString2 = new StringBuilder();
        for (Tarea t : expected2) expectedString2.append(t.toString()).append("\n");

        agenda.borrarPasadas(new Fecha(1, 1, 2020));
        assertEquals("borrarPasadas falla en algo", expectedString2.toString(), agenda.toString());
    }

    @Test(timeout = 100)
    public void borrarPasadasTestHayQueBorrarTodo() throws ExcepcionFechaInvalida {
        for (Tarea t : tars) agenda.añadir(t);
        agenda.borrarPasadas(new Fecha(21, 3, 2019));
        String expectedString = "";
        assertEquals("borrarPasadas() falla si tenemos que borrar todas las tareas",
                expectedString, agenda.toString());
    }

    @Test(timeout = 100)
    public void borrarPasadasTestHayQueBorrarTodoMenosUltima() throws ExcepcionFechaInvalida {
        for (Tarea t : tars) agenda.añadir(t);
        agenda.borrarPasadas(new Fecha(20, 3, 2019));
        String expectedString = tars[2].toString() + "\n";
        assertEquals("borrarPasadas() falla si tenemos que borrar todas las tareas menos la ultima",
                expectedString, agenda.toString());
    }

    @Test(timeout = 100)
    public void borrarPasadasTestNoHayQueBorrarNada() throws ExcepcionFechaInvalida {
        for (Tarea t : tars) agenda.añadir(t);
        String expectedString = agenda.toString();
        agenda.borrarPasadas(new Fecha(1, 3, 2019));
        assertEquals("borrarPasadas() falla si no tenemos que borrar ninguna tarea",
                expectedString, agenda.toString());
    }
}