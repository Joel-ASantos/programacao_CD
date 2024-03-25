package atividades.exercicio_03;
import java.util.concurrent.atomic.AtomicInteger;

public class somaNumeroPrimo {
    public static void main(String[] args) {
        int inicioIntervalo = 1;
        int fimIntervalo = 100;
        int numThreads = 4; 

        
        int tamanhoParte = (fimIntervalo - inicioIntervalo + 1) / numThreads;
        AtomicInteger somaPrimos = new AtomicInteger(0);
        Thread[] threads = new Thread[numThreads];

        
        for (int i = 0; i < numThreads; i++) {
            final int inicio = inicioIntervalo + i * tamanhoParte;
            final int fim = (i == numThreads - 1) ? fimIntervalo : inicio + tamanhoParte - 1;

            threads[i] = new Thread(() -> {
                int somaLocal = 0;
                for (int num = inicio; num <= fim; num++) {
                    if (isPrimo(num)) {
                        somaLocal += num;
                    }
                }
                somaPrimos.addAndGet(somaLocal);
            });

            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A soma dos números primos no intervalo é: " + somaPrimos);
    }
    private static boolean isPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
