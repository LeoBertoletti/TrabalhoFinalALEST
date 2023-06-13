import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ListaLogradourdoLeituraArquivo {
    private ListaLogradouro listaLogradouro;
    private String caminhoArquivo;

    public ListaLogradourdoLeituraArquivo(ListaLogradouro listaLogradouro, String caminhoArquivo) {
        this.listaLogradouro = listaLogradouro;
        this.caminhoArquivo = caminhoArquivo;

    }

    public void realizarLeitura() {
        File arquivoCSV = new File(caminhoArquivo);
        int linhasLidas = 0;
        try {
            Scanner leitor = new Scanner(arquivoCSV);
            leitor.nextLine(); // pula primeira linha
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] colunas = linha.split(";");
                processarLinha(colunas);
                linhasLidas++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(linhasLidas);
    }

    private void processarLinha(String[] colunas) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(colunas[0], formatter);
        int anoDataExtracao = dateTime.getYear();
        int mesDataExtracao = dateTime.getMonthValue();
        int diaDataExtracao = dateTime.getDayOfMonth();
        int horaDataExtracao = dateTime.getHour();
        int minDataExtracao = dateTime.getMinute();

        String descricao = colunas[1];
        String estado = colunas[2];
        String complemento = colunas[3];

        int anoImplantacao = 0;
        int mesImplantacao = 0;
        int diaImplantacao = 0;
        if (!colunas[4].equals("")) {
            if (colunas[4].contains("-"))
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            else
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(colunas[4], formatter);
            anoImplantacao = date.getYear();
            mesImplantacao = date.getMonthValue();
            diaImplantacao = date.getDayOfMonth();
        }
        String logradouroTipo = colunas[5].split(" ", 2)[0];
        String logradouroNome = colunas[5].split(" ", 2)[1];

        double numInicial;
        if (colunas[6].equals(""))
            numInicial = 0;
        else
            numInicial = Double.parseDouble(colunas[6]);

        double numFinal;
        if (colunas[7].equals(""))
            numFinal = 0;
        else
            numFinal = Double.parseDouble(colunas[7]);

        String defronte = colunas[8];
        String cruzamento = colunas[9];
        String lado = colunas[10];
        String fluxo = "";
        if (colunas.length >= 12)
            fluxo = colunas[11];
        String localInstalacao = "";
        if (colunas.length >= 13)
            localInstalacao = colunas[12];

        Logradouro logradouro = new Logradouro(logradouroTipo, logradouroNome);
        listaLogradouro.atualizar(logradouro);
    }
}