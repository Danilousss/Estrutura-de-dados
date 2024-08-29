package arvore;
public class Btree {
    // atributos da classe
    Bnode raiz;

    // construtor
    public Btree(){
        raiz = null;
    }

    public void add(int valor){
        if(raiz!=null){
            raiz.add(valor);
        }
        else{
            raiz = new Bnode(valor);
        }
    }
    public void showLeaves(){
        if(raiz!=null) raiz.showLeaves();
        else System.out.println("Não possue Folhas()");
    }
    
     public int contLeaves(){
        if(raiz!=null) return raiz.contLeaves();
        return 0;
    }
     public int somaLeaves(){
           if(raiz!=null) return raiz.somaLeaves();
        return 0;
     }
    public void show(){
        if(raiz!=null) raiz.show();
        else System.out.println("Arvore Vazia!!! ");
    }
    public int contNosInternos(){
        if(raiz!=null) return raiz.contNosInternos();
        return 0;
    }
    public int altura(){
         if(raiz!=null) return raiz.altura();
        return 0;
    }

    public int size(){
        if(raiz!=null) return raiz.size();
        return 0;
    }

    public int soma(){
        if(raiz!=null) return raiz.soma();
        return 0;
    }
}
