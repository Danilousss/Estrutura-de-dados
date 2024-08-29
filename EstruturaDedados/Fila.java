package EstruturaDedados;

public class Fila {
    private Pilha p1;
    private Pilha p2;

    public Fila(){
        this.p1 = new Pilha();
        this.p2 = new Pilha();

    }
    public void pop(){
        if(p1.isEmpty()){
            System.out.println("Tentativa de remover em pilha vazia");
        }else{
            System.out.println("Valor retirado com sucesso ");
            p1.pop();
        }
    }
    public void push(int x) {

        if (p1.isEmpty()) {
            p1.push(x);
        } else {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
            p1.push(x);
            while (!p2.isEmpty()) {
                p1.push(p2.pop());
            }
        }
    }
    public void show(){
        System.out.println("Pilha 1: ");
        p1.show();
        System.out.println();

    }
    public boolean isEmpty() {
        if (p1 == null) {
            System.out.println("true");
            return true;
        }else{
            System.out.println("false");
            return false;
        }
    }
    public int peak(){
        Node aux = p1.topo;
        if(aux == null){
            System.out.println("Fila vazia");
            return -99999;
        }else{
            System.out.print("Primeiro valor da fila: ");
            return aux.getX();
        }

    }

}
