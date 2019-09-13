package Examenes.Junio2018;

public class ComprasEspectáculo {

    private final int TAMAÑO_INICIAL = 10;
    // Capacidad inicial del vector de compras.

    private String descripción;
    // Descripcion del espectaculo.

    private int máximo;
    // Numero máximo de entradas que una misma persona puedeadquirir para ese espectaculo.

    private Compra[] compras;
    // Datos de las compras realizadas para ese espectaculo (ordenados de menor a mayor por DNI del comprador).

    private int ocupados;
    // Indica las posiciones realmente ocupadas en el vector.

    public ComprasEspectáculo(String descripción, int máximo) {
        this.descripción = descripción;
        this.máximo = máximo;
        this.compras = new Compra[TAMAÑO_INICIAL];
        this.ocupados = 0; // Inicialmente el vector no contiene datos.
    }

    // Busqueda binaria iterativa, O(log n)
    public int consultarEntradas(String dni) {
        int inicio = 0;
        int fin = compras.length - 1;
        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            if (compras[mitad].getDni().compareTo(dni) > 0)
                fin = mitad - 1;
            else if (compras[mitad].getDni().compareTo(dni) < 0)
                inicio = mitad + 1;
            else
                return compras[mitad].getCantidad();
        }
        return 0;
    }

    private void redimensionar(int nuevoTamaño) throws InvalidSizeException {
        if (nuevoTamaño < ocupados)
            throw new InvalidSizeException();
        if (nuevoTamaño == ocupados)
            return;
        Compra[] nuevo = new Compra[nuevoTamaño];
        for (int i = 0; i < ocupados; i++)
            nuevo[i] = compras[i];
        compras = nuevo;
    }

    public boolean añadirCompra(String dni, int cantidad) throws InvalidSizeException {
        if (cantidad > máximo)
            return false;
        if (ocupados == 0) {
            compras[0] = new Compra(dni, cantidad);
            ocupados++;
            return true;
        }

        // Buscar existentes, O(n)
        for (int i = 0; i < ocupados; i++) {
            Compra c = compras[i];
            if (c.getDni().equals(dni))
                if (c.getCantidad() + cantidad <= máximo) {
                    c.setCantidad(c.getCantidad() + cantidad);
                    return true;
                } else
                    return false;
        }

        // O(n)
        if (ocupados == compras.length)
            redimensionar(compras.length * 2);

        // Comprobar si va último, O(1)
        if (dni.compareTo(compras[ocupados - 1].getDni()) > 0) {
            compras[ocupados] = new Compra(dni, cantidad);
            ocupados++;
            return true;
        }
        // Buscar posicion para que siga ordenado, O(n)
        for (int i = 0; i < ocupados; i++)
            if (dni.compareTo(compras[i].getDni()) < 0) {
                // Desplazar a la derecha a partir i
                for (int j = ocupados - 1; j >= i; j--)
                    compras[j + 1] = compras[j];
                // Crear la nueva compra
                compras[i] = new Compra(dni, cantidad);
                ocupados++;
                return true;
            }
        return false;
    }

    public int contarComunes(ComprasEspectáculo otro) {
        int comunes = 0;
        int i1 = 0;
        int i2 = 0;

        // recorrer los vectores a la vez, O(n)
        while (i1 < this.ocupados && i2 < otro.ocupados) {
            if (this.compras[i1].getDni().equals(otro.compras[i2].getDni()))
                comunes++;
            if (this.compras[i1].getDni().compareTo(otro.compras[i2].getDni()) < 0)
                i1++;
            else
                i2++;
        }
        return comunes;
    }

}
