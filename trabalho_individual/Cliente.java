package trabalho_individual;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private static String ip_endereco = "10.130.129.103";
    private static int PORTA = 12345;

    public static void main(String[] args) throws IOException {
        try {
            String mensagem = "MTk5MQ==";
            System.out.println("Conectando ao servidor");
            Socket socket = new Socket(ip_endereco, PORTA);
            System.out.println("Conectado ao servidor: " + socket);
            
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
            BufferedReader leitura = new BufferedReader(new InputStreamReader(in));
            PrintWriter out2 = new PrintWriter(socket.getOutputStream(), true);
          
            out2.println(mensagem);

            String resposta = leitura.readLine();
            System.out.println("Resposta do servidor: " + resposta);

            socket.close();
            in.close();
            out2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
