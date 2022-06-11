package listaduplamenteencadeada;
import java.util.Objects;

public class ListaDupla<T> {

    Node<T> base;
    Node<T> topo;
    int tamanho;
    int capacidade;

    public ListaDupla(int capacidade) {
        this.capacidade = capacidade;
    }

    public void add(T value) {
        if (!(estaCheia()) == true) {
            Node<T> no = new Node(value);
            if (estaVazia() == true) {
                this.base = no;
                this.topo = no;
                this.tamanho++;
            } else {
                no.setAnterior(topo);
                this.topo.setProximo(no);
                this.topo = no;
                this.tamanho++;
            }
        } else {
            System.out.println("Cheia?" + estaCheia());
        }

    }

    public void add(int pos, T value) {
        if (!this.estaCheia()) {
            pos = Objects.checkIndex(pos, this.tamanho);

            if (pos == this.tamanho) {
                this.add(value);
            } else {
                Node<T> node = new Node(value);
                Node<T> proximo = this.getNode(pos);
                Node<T> anterior = proximo.getAnterior();

                if (anterior == null) {
                    node.setProximo(proximo);
                    proximo.setAnterior(node);
                    this.base = node;
                } else {
                    node.setAnterior(anterior);
                    node.setProximo(proximo);

                    anterior.setProximo(node);
                    proximo.setAnterior(node);
                }

                this.tamanho++;
            }
        }
    }

    public Node<T> getNode(int pos) throws IllegalArgumentException {
        if (!(pos < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida, informe outra por gentileza");
        }
        Node<T> recebePosicao;
        pos = Objects.checkIndex(pos, this.tamanho);

        if (pos < tamanho / 2) {
            recebePosicao = base;
            for (int i = 0; i < pos; i++) {
                recebePosicao = recebePosicao.proximo;

            }
        } else {
            recebePosicao = this.topo;
            for (int i = tamanho; i > pos; i--) {
                recebePosicao = recebePosicao.anterior;
            }
        }

        return recebePosicao;
    }

    public void set(int pos, T value) {
        getNode(pos).value = value;
    }

    public T get(int pos) {
        Node<T> node = getNode(pos);

        return node.value;
    }

    private T remove(Node<T> no) {
        T value = no.value;

        Node<T> anterior = no.anterior;
        Node<T> proximo = no.proximo;

        if (anterior == null) {
            no.anterior = null;
            no.proximo = null;
            base = proximo;
        } else if (proximo == null) {

            no.anterior = null;
            no.proximo = null;
            topo = anterior;
        } else {
            proximo.anterior = anterior;
            anterior.proximo = proximo;
            no.anterior = null;
            no.proximo = null;

        }

        tamanho--;
        return value;
    }

    public T remove(int pos) {
        if (estaVazia()) {
            throw new IllegalArgumentException("Impossível remover dessa lista, pois ela está vazia");
        } else {
            Node<T> no = getNode(pos);
            return remove(no);
        }
    }

    @Override
    public String toString() {
        String str = "(" + tamanho + ") ";
        Node local = base;
        while (local != null) {
            str += local.value + "  ";
            local = local.proximo;
        }
        return str;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public boolean estaCheia() {
        return this.capacidade == tamanho;
    }

    public void definirCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int obterCapacidade() {
        return capacidade;
    }

    public int obterTamanho() {
        return this.tamanho;
    }

    public void limparLista() {
        this.topo = null;
        this.base = null;
        this.tamanho = 0;
    }
}
