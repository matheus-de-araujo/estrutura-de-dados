public class No {

    private No esquerdo; //left
    private No direito; //right
    private No pai;

    private int valor;
    private int fb;

    private boolean RED;
    private boolean BLACK;

    public No(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
        this.pai = null;
        this.fb = 0;
        this.BLACK = false;
        this.RED = true;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public void setEsquerdo(No no) {
        this.esquerdo = no;
    }

    public No getEsquerdo() {
        return this.esquerdo;
    }

    public void setDireito(No no) {
        this.direito = no;
    }

    public No getDireito() {
        return this.direito;
    }

    public void setPai(No no) {
        this.pai = no;
    }

    public No getPai() {
        return this.pai;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public void setRedNode() {
        this.RED = true;
        this.BLACK = false;
    }

    public void setBlackNode() {
        this.RED = false;
        this.BLACK = true;
    }

    public boolean isBlackNode() {
        return this.BLACK;
    }

    public boolean isRedNode() {
        return this.RED;
    }

    public boolean isRoot() {
        return this.pai == null;
    }
  
}
