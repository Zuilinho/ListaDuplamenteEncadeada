package listaduplamenteencadeada;
/**
 *
 * @author Luan Magalhaes e Luiz Filho 
 */
public class Main {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla(10);

        lista.add("Luan");
        lista.add("Luiz");
        lista.add("Pedro");
        lista.add("Ricardo");
        lista.add("Daniel");
        lista.add("Fernanda");
        lista.add("Henrique");
        lista.add("Bianca");
        lista.add("Mickey");
        lista.add("Mouse");
        
        System.out.println("Tamanho: " + lista.obterTamanho());
        
        System.out.println("Lista: " + lista);
        
        System.out.println("Esta cheia? " + lista.estaCheia());
        
        lista.remove(1);
        
        System.out.println("Lista: " + lista);
        
        System.out.println("No 1: " + lista.get(1));
        
        lista.limparLista();
        
        System.out.println("Lista: " + lista);
        
        System.out.println("Esta vazia? " + lista.estaVazia());
        
    }
}
