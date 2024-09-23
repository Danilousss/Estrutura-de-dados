import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\aluno\\Desktop\\Entrada.txt";
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            int caractere;

            while ((caractere = br.read()) != -1) {
                sb.append((char) caractere);
            }
            br.close();

            String textoOriginal = sb.toString();

            List<Character> listaCaracteres = new ArrayList<>();
            for (int i = 0; i < textoOriginal.length(); i++) {
                listaCaracteres.add(textoOriginal.charAt(i));
            }

            List<No> listaNos = new ArrayList<>();
            for (char c : listaCaracteres) {
                boolean encontrado = false;
                for (No no : listaNos) {
                    if (no.getCaractere() == c) {
                        listaNos.set(listaNos.indexOf(no), new No(no.getCaractere(), no.getFrequencia() + 1, no.getEsquerda(), no.getDireita()));
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    listaNos.add(new No(c, 1));
                }
            }

            PriorityQueue<No> pq = new PriorityQueue<>(Comparator.comparingInt(No::getFrequencia));
            pq.addAll(listaNos);

            No raiz;
            while (pq.size() > 1) {
                No raiz1 = pq.poll();
                No raiz2 = pq.poll();
                No noPai = new No('\u0000', raiz1.getFrequencia() + raiz2.getFrequencia(), raiz1, raiz2);
                pq.add(noPai);
            }

            raiz = pq.poll();

            List<LetraCodigo> listaCodigos = new ArrayList<>();
            codificador(raiz, "", listaCodigos);

            StringBuilder codificado = new StringBuilder();
            for (char c : listaCaracteres) {
                boolean encontrado = false;
                for (LetraCodigo lc : listaCodigos) {
                    if (lc.getLetra() == c) {
                        codificado.append(lc.getCodigo());
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    codificado.append(" ");
                }
            }

            List<String> blocosDe8Bits = separarEmBlocosDe8Bits(codificado.toString());
            StringBuilder codificadoFormatado = new StringBuilder();
            int blocosPorLinha = 8;

            for (int i = 0; i < blocosDe8Bits.size(); i++) {
                codificadoFormatado.append(blocosDe8Bits.get(i));
                if ((i + 1) % blocosPorLinha == 0) {
                    codificadoFormatado.append("\n");
                } else {
                    codificadoFormatado.append(" ");
                }
            }

            FileWriter fw = new FileWriter("C:\\Users\\aluno\\Desktop\\saida.txt");
            fw.write(codificadoFormatado.toString());
            fw.close();

            System.out.println("Texto Original: " + textoOriginal);
            System.out.println("Texto Codificado: " + codificadoFormatado);

            StringBuilder decodificado = new StringBuilder();
            No noAtual = raiz;

            for (char bit : codificado.toString().toCharArray()) {
                if (bit == '0') {
                    noAtual = noAtual.getEsquerda();
                } else if (bit == '1') {
                    noAtual = noAtual.getDireita();
                }
                if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
                    decodificado.append(noAtual.getCaractere());
                    noAtual = raiz;
                }
            }

            System.out.println("Texto Decodificado: " + decodificado);

        } catch (IOException e) {

            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static void codificador(No no, String codigo, List<LetraCodigo> listaCodigos) {
        if (no.getEsquerda() == null && no.getDireita() == null) {
            listaCodigos.add(new LetraCodigo(no.getCaractere(), codigo));
        } else {
            if (no.getEsquerda() != null) {
                codificador(no.getEsquerda(), codigo + "0", listaCodigos);
            }

            if (no.getDireita() != null) {
                codificador(no.getDireita(), codigo + "1", listaCodigos);
            }
        }
    }

    public static List<String> separarEmBlocosDe8Bits(String codigoBinario) {
        List<String> blocosDe8Bits = new ArrayList<>();
        int comprimento = codigoBinario.length();
        int restante = comprimento % 8;
        if (restante != 0) {
            codigoBinario = String.format("%" + (comprimento + (8 - restante)) + "s", codigoBinario).replace(' ', '0');
        }

        for (int i = 0; i < codigoBinario.length(); i += 8) {
            String bloco = codigoBinario.substring(i, Math.min(i + 8, codigoBinario.length()));
            blocosDe8Bits.add(bloco);
        }

        return blocosDe8Bits;
    }
}
