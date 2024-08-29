package EstruturaDedados;

public class Main {
    public static void main(String[] args) {
        Fila f = new Fila();
        f.peak();

        f.push(3);
        f.push(4);
        f.push(5);
        f.push(8);
        f.push(9);
        f.show();
        System.out.println(f.peak());
        f.pop();
        f.show();
    }
}