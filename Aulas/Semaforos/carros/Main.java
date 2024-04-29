package Semaforos.carros;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore estacionamento = new Semaphore(10);

        for(int i = 0; i < 20;i++){
            new Carro("Carro" + i,estacionamento).start();
        }
    }
}
