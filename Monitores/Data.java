package Monitores;

public class Data {
    private String message;
    private boolean isSending = true;

    public synchronized void send(String message){
        // enquanto o recebimento não termina, eu espero.
        while(!isSending){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread foi interrompida!");
            }
        }
        // posso enviar minha mensagem.
        this.message = message;
        
        // já enviei, não tô enviando.
        isSending = false;

        //aviso para thread de recebimento que o envio terminou
        notify();

    }
    public synchronized String receive(){
        // enquanto o envio não terminar eu espero.

        while(!isSending){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread foi interrompida!");
            }
        }

        // posso receber minha mensagem.
        String receiveMessage = this.message;

        // já recebi, pode enviar a próxima mensagem.
        isSending = true;
        
        // aviso para a thread de envio que o recebimento terminou.
        notify();

        return receiveMessage;
    }
}
