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

        String ladoPai;

        String meuLado;

        if(noPai.getDireito() == novo) {
            meuLado = "Direito";
        }

        else {
            meuLado = "Esquerdo";
        }

        while(noPai.isRedNode()) {

            if(noPai.getPai().getEsquerdo() == noPai) {
                noTio = noPai.getPai().getDireito();
                ladoPai = "Esquerdo";
            }
    
            else {
                noTio = noPai.getPai().getEsquerdo();
                ladoPai = "Direito";
            }
            
            if(noTio != null) {
                
                if(noTio.isRedNode()) {
                    noPai = caso01(noPai, noTio);
                }
    
                else {
                    caso02(noPai, ladoPai, meuLado);
                    return;
                }
            }
    
            else {
                caso02(noPai, ladoPai, meuLado);
                return;
            }

            if(noPai == null) {
                return;
            }
        }

    }

    private void caso02(No noPai, String ladoPai, String meuLado) {

        if(ladoPai == "Direito") {
            if(meuLado == "Direito") {
                noPai = rotacaoSimplesEsquerda(noPai);
                if(noPai.getPai() == null) {
                    this.raiz = noPai;
                }
            }

            // else {
            //     //no = rotaocaoDuplaEsquerda(no);
            // }
        }

        else {
            if(meuLado == "Direito") {
                //no = rotaocaoDuplaDireita(no);
            }

            else {
                noPai = rotacaoSimplesDireita(noPai);
                if(noPai.getPai() == null) {
                    this.raiz = noPai;
                }
            }
        }
    }

    private No caso01(No noPai, No noTio) {

        noTio.setBlackNode();
        noPai.setBlackNode();

        if(!noPai.getPai().isRoot()) {
            noPai.getPai().setRedNode();
        }

        return noPai.getPai().getPai();
    }

    private No rotacaoSimplesEsquerda(No A) {

        No B = A.getEsquerdo();
        No C = A.getPai();

        A.setEsquerdo(C);
        C.setDireito(B);
        A.setPai(C.getPai());
        C.setPai(A);

        return A;
    }

    private No rotacaoSimplesDireita(No A) {

        No B = A.getDireito();
        No C = A.getPai();

        A.setDireito(C);
        C.setEsquerdo(B);
        A.setPai(C.getPai());
        C.setPai(A);

        return A;
    }
}