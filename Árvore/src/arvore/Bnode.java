package arvore;
public class Bnode {
    //atributos
    private int x;
    private Bnode esq, dir;

    //construtor
    public Bnode(int valor){
        x = valor;
        esq = null;
        dir = null;
    }

    public void add(int valor){
        if(valor > x){
            if(dir!=null) dir.add(valor);
            else dir = new Bnode(valor);
        }
        else{
            if(esq!=null) esq.add(valor);
            else esq = new Bnode(valor);
        }
    }

    public void show(){
        
        if(dir!=null) dir.show();
        System.out.println(x);
        if(esq!=null) esq.show();
        
    }
    public void showLeaves(){
        if(esq == null && dir == null){
            System.out.println(x);
        }
        else{
        if(esq != null) esq.showLeaves();
        if(dir != null) dir.showLeaves();
        }
      
    }
    public int contLeaves(){
       if(esq == null && dir == null){
            return 1;
        } else {
            int folhas = 0;
            if(esq != null) folhas += esq.contLeaves();
            if(dir != null) folhas += dir.contLeaves();
            return folhas;
        }
    }
    public int somaLeaves(){
         if(esq == null && dir == null){
          return x; 
         }else{
             int n =0;
             if(esq != null)  n += esq.somaLeaves();
             if(dir!= null) n+= dir.somaLeaves();
             return n;
         }      
    }
    public int contNosInternos(){
        return size()-contLeaves();
    }
    public int altura(){
          if (esq == null && dir == null) {
        return 1;
    }
    
    // Calcula a altura dos filhos
    int alturaEsq = (esq != null) ? esq.altura() : 0;
    int alturaDir = (dir != null) ? dir.altura() : 0;
    
    // A altura do nó atual é a maior altura dos filhos mais 1
    return Math.max(alturaEsq, alturaDir) + 1;
    }

    public int size(){
        int e = 0, d = 0;
        if(esq!=null) e = esq.size();
        if(dir!=null) d = dir.size();
        return 1 + e + d;
    }

    public int soma(){
        int e = 0, d = 0;
        if(esq!=null) e = esq.soma();
        if(dir!=null) d = dir.soma();
        return x + e + d;
    }
}
