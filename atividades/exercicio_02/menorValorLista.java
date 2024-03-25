package atividades.exercicio_02;
import java.util.ArrayList;
import java.util.List;

public class menorValorLista {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(12);
        numeros.add(34);
        numeros.add(10);
        numeros.add(24);
        
        Integer maior = Integer.MIN_VALUE;
        for (Integer number : numeros) {
            if(number > maior){
                maior = number;
            }
        }
        System.out.println("O maior numero: " + maior);
    }
}
