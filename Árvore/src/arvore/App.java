package arvore;
public class App {
    public static void main(String[] args) throws Exception {
        Btree a = new Btree();

        a.add(40);
        a.add(50);
    
       System.out.println(a.contLeaves()); 
        a.showLeaves();
       
        System.out.println(a.size());
        System.out.println(a.contNosInternos());
        System.out.println(a.altura());
        
        
    }
}
