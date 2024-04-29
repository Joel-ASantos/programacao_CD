package Semaforos.carros;
import java.util.concurrent.Semaphore;

public class Carro extends Thread {
    private Semaphore estacionamento;

    public Carro(String nome, Semaphore estacionamento){
        super(nome);
        this.estacionamento = estacionamento;
    }

    public void run() {
        try {
            this.estacionamento.acquire();
        } catch (Exception e) {
            System.out.println("Thread Interrompida!");
        }
        System.out.println(this.getName() + "Entrou no estacionamento");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Thread interrompida");
        }
        System.out.println(this.getName() + "Saindo do estacionamento");
    }
}
