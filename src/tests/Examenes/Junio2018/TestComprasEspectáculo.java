package tests.Examenes.Junio2018;

import static org.junit.Assert.*;

// Cambiar por el directorio donde tienes Compra y ComprasEspectáculo
import Examenes.Junio2018.Compra;
import Examenes.Junio2018.ComprasEspectáculo;
import Examenes.Junio2018.InvalidSizeException;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestComprasEspectáculo {

    private ComprasEspectáculo espectaculo;
    private String[] dnis =
            {"07999563W", "40472919A", "06500453D", "31574632W", "88789439D", "94245586G", "86080271B", "77206581C"};
    private int[] cantidades = {1, 3, 2, 4, 2, 1, 4, 3};

    @Before
    public void setUp() throws InvalidSizeException {
        espectaculo = new ComprasEspectáculo("Espectaculo Pruebas", 4);
        añadirCompras();
    }

    // Si añadir compras no va bien no funcionará nada, es lo primero que hay que hacer bien
    private void añadirCompras() throws InvalidSizeException {
        for (int i = 0; i < dnis.length; i++)
            assertTrue("añadirCompras() debería devolver true para el dni: "
                    + dnis[i] + " y cantidad: " + cantidades[i], espectaculo.añadirCompra(dnis[i], cantidades[i]));
    }

    @Test
    public void testAñadirCompras() throws InvalidSizeException {
        assertFalse("debería devolver false, el dni: " +
                dnis[1] + "\nya tiene " + cantidades[1] + " compras y está intentando comprar 2 más, el máximo es 4",
                espectaculo.añadirCompra(dnis[1], 2));

        assertTrue("debería devolver true, el dni: " + dnis[1] +
                "\ntiene " + cantidades[1] + " compras, si compra 1 más no sobrepasa el máximo (4)",
                espectaculo.añadirCompra(dnis[1], 1));

        Compra nueva1 = new Compra("89664102M", 2);
        Compra nueva2 = new Compra("01886611J", 5);

        assertTrue("debería devolver true al añadir el dni: " + nueva1.getDni() + "\ncon cantidad: " +
                nueva1.getCantidad(), espectaculo.añadirCompra(nueva1.getDni(), nueva1.getCantidad()));

        assertFalse("debería devolver true porque " + nueva2.getDni() + "\nestá intentando comprar " +
                nueva2.getCantidad() + " entradas", espectaculo.añadirCompra(nueva2.getDni(), nueva2.getCantidad()));
    }

    @Test
    public void testConsultarEntradas() {
        for (int i = 0; i < dnis.length; i++) {
            assertEquals("el DNI: " + dnis[i] +" debería tener " + cantidades[i] + " entradas",
                    cantidades[i], espectaculo.consultarEntradas(dnis[i]));
        }
    }

    @Test
    public void testContarComunes() throws InvalidSizeException {
        ComprasEspectáculo otroEspectaculo = new ComprasEspectáculo("Otroespectaculo", 4);
        String[] entradasParaAmbos = new String[dnis.length / 2];
        for (int i = 0, j = 0; i < dnis.length; i += 2, j++) {
            otroEspectaculo.añadirCompra(dnis[i], 1);
            entradasParaAmbos[j] = dnis[i];
        }
        assertEquals("La cantidad de personas que tienen entradas para ambos son: " + dnis.length / 2 +
                "\ncon DNIs: " + Arrays.toString(entradasParaAmbos),
                dnis.length / 2, espectaculo.contarComunes(otroEspectaculo));
    }

    @Test
    public void testRedimension() throws InvalidSizeException {
        String redimension = redimension();
        assertFalse(redimension, ! redimension.equals(""));
    }

    private String redimension() throws InvalidSizeException {
        String[] nuevos = {"38687810Q", "75165616Y", "74229986Q", "30949684X"};
        int i = 0;
        while (i < 2) {
            espectaculo.añadirCompra(nuevos[i], 1);
            i++;
        }
        try {
            while (i < nuevos.length) {
                espectaculo.añadirCompra(nuevos[i], 1);
                i++;
            }
            return "";
        }
        catch (Exception e) {
            return "Había 10 elementos en el vector, es decir ocupados == compras.length, " +
                    "\nhemos intentado añadir 2 compras más para que el vector se duplique, pero ha ocurrido\n" +
                    "el siguiente error:\n" + "\n" + e + "\n";
        }
    }

}