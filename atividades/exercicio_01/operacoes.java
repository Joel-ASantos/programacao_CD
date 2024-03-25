package atividades.exercicio_01;
import java.util.Scanner;

public class operacoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        float soma,sub,mult,div;
        float var1,var2;
        System.out.println("Digite o primeiro valor: ");
        var1 = scanner.nextFloat();

        System.out.println("Digite o segundo valor: ");
        var2 = scanner.nextFloat();
        scanner.close();

        soma = var1 + var2;
        sub = var1 - var2;
        mult = var1 * var2;
        div = var1 / var2;

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + sub);
        System.out.println("Multiplicação: " + mult);
        System.out.println("Divisão: " + div);       
    }   
}