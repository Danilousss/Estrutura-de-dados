//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class No {
    private final char caractere;
    private final int frequencia;
    private final No esquerda;
    private final No direita;

    public No(char caractere, int frequencia) {
        this(caractere, frequencia, (No)null, (No)null);
    }

    public No(char caractere, int frequencia, No esquerda, No direita) {
        this.caractere = caractere;
        this.frequencia = frequencia;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public char getCaractere() {
        return this.caractere;
    }

    public int getFrequencia() {
        return this.frequencia;
    }

    public No getEsquerda() {
        return this.esquerda;
    }

    public No getDireita() {
        return this.direita;
    }
}
