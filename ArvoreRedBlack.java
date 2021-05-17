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

        No novo = this.inserir(this.raiz, valor);

        System.out.println("Inserido o valor: " + valor);

        balancear(novo);

    } 

    private void balancear(No novo) {

        No noTio;

        No noPai = novo.getPai();

        String meuLado;

        while(noPai.isRedNode()) {

            if(noPai.getPai().getEsquerdo() == noPai) {
                noTio = noPai.getPai().getDireito();
                meuLado = "Esquerdo";
            }
    
            else {
                noTio = noPai.getPai().getEsquerdo();
                meuLado = "Direito";
            }
            
            if(noTio != null) {
                
                if(noTio.isRedNode()) {
                    noPai = caso01(noPai, noTio);
                }
    
                else {
                    noPai = caso02(noPai, meuLado);
                }
            }
    
            else {
                noPai = caso02(noPai, meuLado);
            }

            if(noPai == null) {
                return;
            }
        }
        
    }

    public No caso02(No no, String meuLado) {
        // if(meuLado == "Direito") {
        //     if(ladoDoFilho == "Direita") {
        //         No noPai = no.getPai();
        //         noPai = rotacaoSimplesEsquerda(noPai);
        //         no.setPai(noPai);
        //     }

        //     else {
        //         //no = rotaocaoDuplaEsquerda(no);
        //     }
        // }

        // else {
        //     if(ladoDoFilho == "Direita") {
        //         //no = rotaocaoDuplaDireita(no);
        //     }

        //     else {
        //         //no = rotacaoSimplesDireita(no);
        //     }
        // }

        return no;
    }

    public No caso01(No noPai, No noTio) {

        noTio.setBlackNode();
        noPai.setBlackNode();

        if(!noPai.getPai().isRoot()) {
            noPai.getPai().setRedNode();
        }

        return noPai.getPai().getPai();
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