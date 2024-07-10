import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("um", "dois", "tres", "quatro", "cinco");
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Xeroki Romiz", 25), new Pessoa("Xerelayne Santos", 30), new Pessoa("Fax da Silva Modem", 20));

        System.out.println();
        System.out.println("---------------------------");
        System.out.println("Lista de Exercícios Lambda");
        System.out.println("---------------------------");
        System.out.println();

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Números Pares: " + pares);

        System.out.println("---------------------------");
        System.out.println();

        List<Integer> dobro = numeros.stream()
                .map(n -> n * 2)
                .toList();
        System.out.println("Números Dobrados: " + dobro);

        System.out.println("---------------------------");
        System.out.println();

        boolean maiorQueDez = numeros.stream()
                .allMatch(n -> n > 10);
        System.out.println("Existe Número Maior Que 10? " + maiorQueDez);

        System.out.println("---------------------------");
        System.out.println();

        int maiorNumero = numeros.stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Maior número: " + maiorNumero);

        System.out.println("---------------------------");
        System.out.println();

        List<String> maiusculas = strings.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Strings em maiúsculas: " + maiusculas);

        System.out.println("---------------------------");
        System.out.println();

        List<String> ordenadasPorTamanho = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println("Strings ordenadas por tamanho: " + ordenadasPorTamanho);

        System.out.println("---------------------------");
        System.out.println();

        Map<Integer, List<Pessoa>> agrupadasPorIdade = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getIdade));
        System.out.println("Pessoas agrupadas por idade: " + agrupadasPorIdade);

        System.out.println("---------------------------");
        System.out.println();

        double media = numeros.stream()
                .collect(Collectors.averagingDouble(n -> n));
        System.out.println("Média dos números: " + media);

        System.out.println("---------------------------");
        System.out.println();

        List<Integer> removerDuplicados = numeros.stream()
                .distinct()
                .toList();
        System.out.println("Lista sem itens duplicados: " + removerDuplicados);

        System.out.println("---------------------------");
        System.out.println();

        List<Integer> outraLista = Arrays.asList(11, 12, 13, 14, 15);
        List<Integer> combinadas = Stream.of(numeros, outraLista)
                .flatMap(List::stream)
                .toList();
        System.out.println("Listas combinadas: " + combinadas);
        System.out.println("---------------------------");
    }
}
