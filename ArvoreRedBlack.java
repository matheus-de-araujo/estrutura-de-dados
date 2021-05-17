public class ArvoreRedBlack extends ArvoreAbstract {

    public ArvoreRedBlack(int valor) {
        super(valor);
        this.raiz.setBlackNode();
    }

    @Override
    public int remover(int valor) throws Exception {
        return 0;
    }

    @Override
    public int altura() {
        return this.altura(this.raiz);
    }

    @Override
    public void inserir(int valor) {

        this.inserir(this.raiz, valor);

        System.out.println("Inserido o valor: " + valor);

        this.raiz = balancear(this.raiz);

    } 

    private No balancear(No no) {

        if(no.getDireito() != null) {
            no.setDireito(balancear(no.getDireito()));
            
        }

        if(no.getEsquerdo() != null) {
            no.setEsquerdo(balancear(no.getEsquerdo()));
        }

        
        if(no.isRedNode()) {

            if(no.getDireito() != null) {
                if(no.getDireito().isRedNode()) {
                    no = balancear(no, "Direita");
                }
            }

            if(no.getEsquerdo() != null) {
                if(no.getEsquerdo().isRedNode()) {
                    no = balancear(no, "Esquerda");
                }
            }
        }

        return no;
    }

    private No balancear(No no, String ladoDoFilho) {

        No noIrmao;

        String meuLado;

        if(no.getPai().getEsquerdo() == no) {
            noIrmao = no.getPai().getDireito();
            meuLado = "Esquerdo";
        }

        else {
            noIrmao = no.getPai().getEsquerdo();
            meuLado = "Direito";
        }
        
        if(noIrmao != null) {
            
            if(noIrmao.isRedNode()) {
                caso01(no, noIrmao);
            }

            else {
                no = caso02(no, ladoDoFilho, meuLado);
            }
        }

        else {
            no = caso02(no, ladoDoFilho, meuLado);
        }

        return no;
    }

    public No caso02(No no, String ladoDoFilho, String meuLado) {
        if(meuLado == "Direito") {
            if(ladoDoFilho == "Direita") {
                No noPai = no.getPai();
                noPai = rotacaoSimplesEsquerda(noPai);
                no.setPai(noPai);
            }

            else {
                //no = rotaocaoDuplaEsquerda(no);
            }
        }

        else {
            if(ladoDoFilho == "Direita") {
                //no = rotaocaoDuplaDireita(no);
            }

            else {
                //no = rotacaoSimplesDireita(no);
            }
        }

        return no;
    }

    public void caso01(No no, No noIrmao) {
        noIrmao.setBlackNode();
        no.setBlackNode();

        if(!no.getPai().isRoot()) {
            no.getPai().setRedNode();
        }
    }

    public No rotacaoSimplesEsquerda(No A) {

        No B = A.getDireito();
        No C = B.getDireito();
        No D = A.getEsquerdo();
        No E = B.getEsquerdo();

        B.setDireito(C);
        A.setEsquerdo(D);
        A.setDireito(E);
        B.setEsquerdo(A);
        B.setPai(A.getPai());
        A.setPai(B);

        return B;
    }
}