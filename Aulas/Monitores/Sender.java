package Monitores;
import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread {
    private Data packet;
    private String[] messages;

    public Sender(Data packet,String[] messages){
        this.packet = packet; 
        this.messages = messages;
    }
    public void run(){
        for (String message : this.messages) {
            System.out.println("Mensagem enviada: " + message);
            this.packet.send(message);
            int randomDelay = ThreadLocalRandom.current().nextInt(3000,7000);

            try {
                Thread.sleep(randomDelay);
            } catch (Exception e) {
                System.out.println("Thread foi interrompida!");
            }
        }
    }
}
