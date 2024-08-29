package EstruturaDedados;

public class Node {
    private int x;
    private Node prox;
    public Node(int x)
    {
        this.x = x;
        this.prox = null;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setProx(Node prox){
        this.prox = prox;
    }

    public int getX(){
        return this.x;
    }

    public Node getProx(){
        return this.prox;
    }
}
