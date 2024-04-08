package Monitores;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver extends Thread {
    private Data packet;

    public Receiver(Data packet){
        this.packet = packet;
    }
    public void run(){
        while(true){
            String menssage = this.packet.receive();
            System.out.println("Mensagem recebida: "  + menssage);

            if(menssage == "END"){
                break;
            }
            int randomDelay = ThreadLocalRandom.current().nextInt(3000,7000);

            try {
                Thread.sleep(randomDelay);
            } catch (Exception e) {
                System.out.println("Thread foi interrompida!");
            }
        }
    }
}
