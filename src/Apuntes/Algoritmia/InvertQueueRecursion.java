package Apuntes.Algoritmia;

import Apuntes.EstructuraDatos.Colas.ColaIntegerSimple;
import Apuntes.EstructuraDatos.Colas.ColaNodoSimple;

public class InvertQueueRecursion {

    public static void invertQueue(ColaIntegerSimple queue) {
        if (queue.isEmpty()) return;
        int first = queue.poll();
        invertQueue(queue);
        queue.add(first);
    }

    public static void main(String[] args) {
        ColaIntegerSimple queue = new ColaNodoSimple();
        for (int i = 1; i <= 5 ; i++)
            queue.add(i);

        System.out.println(queue);
        invertQueue(queue);
        System.out.println(queue);
    }
}
