package practica2;

import java.util.Calendar;

public class Fecha {

    // Atributos
    private int día, mes, año;

    // Constructores
    public Fecha(int día, int mes, int año) throws ExcepcionFechaInvalida {

        if (día > díasMes(mes, año) || día < 1) throw new ExcepcionFechaInvalida();

        this.día = día;
        this.mes = mes;
        this.año = año;
    }

    public Fecha(Fecha otraFecha) throws ExcepcionFechaInvalida {
        this(otraFecha.día, otraFecha.mes, otraFecha.año);
    }

    // Métodos

    @Override
    public String toString() {
        return String.format("%d/%d/%d", día, mes, año);
    }

    @Override
    public boolean equals(Object otroObjeto) {
        if (! (otroObjeto instanceof Fecha)) return false;
        if (this == otroObjeto) return true;

        Fecha otraFecha = (Fecha) otroObjeto;
        return día == otraFecha.día && mes == otraFecha.mes && año == otraFecha.año;
    }

    public int compareTo(Fecha otraFecha) {

        String mesPmtro = String.format("%02d", otraFecha.mes);
        String diaPmtro = String.format("%02d", otraFecha.día);

        String mesObj = String.format("%02d", this.mes);
        String diaObj = String.format("%02d", this.día);

        String strFechaPmtro = otraFecha.año + mesPmtro + diaPmtro;
        String strFechaObj = this.año + mesObj + diaObj;

        int intFechaPmtro = Integer.parseInt(strFechaPmtro);
        int intFechaObj = Integer.parseInt(strFechaObj);

        return Integer.compare(intFechaObj, intFechaPmtro);
    }

    public int getDía() { return día; }
    public int getMes() { return mes; }
    public int getAño() { return año; }

    public static boolean añoBisiesto(int año) {
        return año % 400 == 0 || año % 4 == 0 && año % 100 != 0;
    }

    public static int díasMes(int mes, int año) throws ExcepcionFechaInvalida{

        if (mes > 12 || mes < 1) throw new ExcepcionFechaInvalida();

        switch (mes) {
            case 1: // Enero
            case 3: // Marzo
            case 5: // Mayo
            case 7: // Julio
            case 8: // Agosto
            case 10: // Octubre
            case 12: // Diciembre
                return 31;

            case 4: // Abril
            case 6: // Junio
            case 9: // Septiembre
            case 11: // Noviembre
                return 30;

            case 2: // Febrero
                if (añoBisiesto(año)) return 29;
                else return 28;

            default: return 0;
        }
    }

    public static Fecha hoy() throws ExcepcionFechaInvalida {
        Calendar calendario = Calendar.getInstance();
        int día = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR);

        return new Fecha(día, mes, año);
    }

    public Fecha díaSiguiente() throws  ExcepcionFechaInvalida {

       int ultimoDia = díasMes(this.mes, this.año);
       int ultimoMes = 12;

       if (día + 1 > ultimoDia)
           if (mes + 1 > ultimoMes) return new Fecha(1, 1, año + 1);
           else return new Fecha(1, mes + 1, año);

       return new Fecha(día + 1, mes, año);
    }
}
