public class ArvoreRedBlack extends ArvoreAbstract {

    public ArvoreRedBlack(int valor) {
        super(valor);
        this.raiz.setBlackNode();
    }

    @Override
    public void inserir(int valor) {

        this.inserir(this.raiz, valor);

        System.out.println("Inserindo o valor: " + valor);

        if(precisaValidar(this.raiz)) {
            System.out.println("Precisa Balancear!!!");
        }
    }

    @Override
    public int remover(int valor) throws Exception {
        return 0;
    }

    @Override
    public int altura() {
        return this.altura(this.raiz);
    }

    private boolean precisaValidar(No no) {

        if(no.getDireito() != null) {
            if(precisaValidar(no.getDireito())) {
                return true;
            }
        }
        
        if(no.getEsquerdo() != null) {
            if(precisaValidar(no.getEsquerdo())) {
                return true;
            }
        }
        
        if(no.isRedNode()) {

            if(no.getDireito() != null) {
                if(no.getDireito().isRedNode()) {
                    balancear(no, "Direita");
                }
            }

            if(no.getEsquerdo() != null) {
                if(no.getEsquerdo().isRedNode()) {
                    balancear(no, "Esquerda");
                }
            }
        }

        return false;
    }

    private void balancear(No no, String ladoFilho) {
        if(no.getPai().getEsquerdo() == no) {
            if(no.getPai().getDireito() == null) {
                
            }
            if(no.getPai().getDireito().isRedNode()) {

                no.getPai().getDireito().setBlackNode();
                no.setBlackNode();

                if(!no.getPai().isRoot()) {
                    no.getPai().setRedNode();
                }
            }

            else {
                if(ladoFilho == "Direita") {

                }

                else {
                    no.getPai().setRedNode();
                    no.setBlackNode();

                    // No noAux = no.getPai();
                    // no.setPai(no.getPai().getPai());
                    // no.getPai().setPai(no);
                    // no.setEsquerdo(no);

                }
            }
        }

        else {

            if(no.getPai().getEsquerdo().isRedNode()) {
                
                no.getPai().getEsquerdo().setBlackNode();
                no.setBlackNode();

                if(!no.getPai().isRoot()) {
                    no.getPai().setRedNode();
                }
            }
        }
    }
}