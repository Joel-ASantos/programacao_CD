package Monitores;

public class Main {
    public static void main(String[] args) {
        Data packet = new Data();
        String[] menssages = {
            "primeira Mensagem",
            "segunda Mensagem",
            "terceira Mensagem",
            "END"
        };
        Sender sender = new Sender(packet, menssages);
        Receiver receiver = new Receiver(packet);

        sender.start();
        receiver.start();
    }
}