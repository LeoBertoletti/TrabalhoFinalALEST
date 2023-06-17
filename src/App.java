import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaLogradouros listaLogradouro = new ListaLogradouros();

        ListaLogradourdoLeituraArquivo leituraArquivo = new ListaLogradourdoLeituraArquivo(listaLogradouro,
                "C:\\Users\\Leo\\Documents\\ALEST\\TrabalhoFinalALEST\\src\\dataEditado.csv");

        leituraArquivo.realizarLeitura();
        // System.out.println("Entradas únicas na lista: " +
        // listaLogradouro.getQuantidade());
        System.out.println(listaLogradouro.buscar("ipiranga").getListaSinalizacao().inicio.getDataImplantacao());

        Menu: while (true) {
            System.out.println("1 - Logradouro com mais sinalizações registradas.");
            System.out.println("2 - Mês com mais sinalizações instaladas em uma rua.");
            System.out.println("3 - Modo navegação.");
            System.out.println("4 - Encerrar programa.");

            Scanner scanner = new Scanner(System.in);
            int key = scanner.nextInt();
            scanner.nextLine();
            switch (key) {
                case 1:
                    int maior = Integer.MIN_VALUE;
                    String nomeLogradouro = "";
                    for (Logradouro i = listaLogradouro.inicio; i != null; i = i.getProximo()) {
                        if (i.getListaSinalizacao().getQuantidade() > maior) {
                            maior = i.getListaSinalizacao().getQuantidade();
                            nomeLogradouro = i.getTipo() + " " + i.getNome();
                        }
                    }
                    System.out.println("Logradouro com mais sinalizações registradas: " + nomeLogradouro);
                    System.out.println();
                    scanner.close();
                    break;
                case 2:
                    LocalDate aux = LocalDate.MIN;
                    String mes = "";
                    System.out.println("Digite o nome da rua: ");
                    String rua = scanner.nextLine();
                    for (Sinalizacao j = listaLogradouro.buscar(rua)
                            .getListaSinalizacao().inicio; j != null; j = j
                                    .getProximo()) {
                        try {
                            if (j.getDataImplantacao().isAfter(aux)) {
                                aux = j.getDataImplantacao();
                                mes = aux.getMonth().toString();
                            }
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    System.out.println(
                            "Mês com mais sinalizações instaladas na " + listaLogradouro.buscar(rua) + ": " + mes);
                    System.out.println();
                    break;
                case 3:
                    int indexador = 1;
                    int total = listaLogradouro.getQuantidade();
                    System.out.println("Item " + indexador + " de " + total);
                    System.out.println(listaLogradouro.inicio.getProximo());

                    break;
                case 4:
                    break Menu;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}