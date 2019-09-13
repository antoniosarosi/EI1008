package Apuntes.Algoritmia;

public class OperationAlgorithms {

    public static class Sumatorio {

        // O(1)
        public static long constant(long n) {
            return (1 + n) * n / 2;
        }

        // O(n)
        public static long iterative(long n) {
            long sumatorio = 0;
            for (long i = 1; i <= n; i++)
                sumatorio += i;
            return sumatorio;
        }

        // O(n)
        public static long recursive(long n) {
            if (n == 1) return 1;
            else return recursive(n - 1) + n;
        }
    }


    public static class Factorial {

        // O(n)
        public static long iterative(int n) {
            long productorio = 1;
            for (int i = 2; i <= n; i++)
                productorio *= i;
            return productorio;
        }

        // O(n)
        public static long recursive(int n) {
            if (n == 0)
                return 1;
            else
                return recursive(n - 1) * n;
        }
    }


    public static class Fibonnacci {

        // O(n)
        public static long iterative(int n) {
            long penultimo = 1;
            long ultimo = 1;
            long aux;
            for (int i = 2; i < n; i++) {
                aux = penultimo + ultimo;
                penultimo = ultimo;
                ultimo = aux;
            }
            return ultimo;
        }

        // O(2^n)
        public static long recursive(int n) {
            if (n == 1 || n == 2)
                return 1;
            else
                return recursive(n - 1) + recursive(n - 2);
        }
    }


    public static class Hanoi {

        private static void hanoi(int n, String A, String C, String B) {
            if (n == 1)
                System.out.println("Mover disco superior de la aguja " + A + " a la aguja " + C);
            else {
                hanoi(n - 1, A, B, C);
                System.out.println("Mover disco superior de la aguja " + A + " a la aguja " + C);
                hanoi(n - 1, B, C, A);
            }
        }

        public static void hanoi(int numDiscos) {
            hanoi(numDiscos, "A", "C", "B");
        }
    }

}
