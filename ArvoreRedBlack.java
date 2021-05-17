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

        if(this.altura() > 2) {
            balancear(novo);
        }

    } 

    private void balancear(No novo) {

        No noPai = novo.getPai();
        No noTio = noPai.myBrother();

        while(noPai.isRedNode()) {
            
            if(noTio != null) {
                
                if(noTio.isRedNode()) {
                    noPai = caso01(noPai, noTio);
                }
    
                else {
                    caso02(noPai, novo);
                    return;
                }
            }
    
            else {
                caso02(noPai, novo);
                return;
            }

            if(noPai == null) {
                return;
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

    private void caso02(No noPai, No novo) {

        String ladoInsercao = "";
        if(noPai.getPai().getPai() != null) {
            if(noPai.getPai().onRight()) {
                ladoInsercao = "Direito";
            }
            else {
                ladoInsercao = "Esquerdo";
            }
        }

        if(noPai.onRight()) {
            if(novo.onRight()) {
                noPai = rotacaoSimplesEsquerda(noPai);
            }

            else {
                noPai = rotaocaoDuplaEsquerda(noPai);
            }
        }

        else {
            if(novo.onRight()) {
                noPai = rotaocaoDuplaDireita(noPai);
            }

            else {
                noPai = rotacaoSimplesDireita(noPai);
            }
        }

        if(noPai.getPai() == null) {
            this.raiz = noPai;
            return;
        }

        if(ladoInsercao == "Direito") {
            noPai.getPai().setDireito(noPai);
        }

        else {
            noPai.getPai().setEsquerdo(noPai);
        }
    }

    private No rotacaoSimplesEsquerda(No A) {

        No B = A.getEsquerdo();
        No C = A.getPai();

        A.setBlackNode();
        C.setRedNode();

        A.setEsquerdo(C);
        C.setDireito(B);
        A.setPai(C.getPai());
        C.setPai(A);

        return A;
    }

    private No rotacaoSimplesDireita(No A) {

        No B = A.getDireito();
        No C = A.getPai();

        A.setBlackNode();
        C.setRedNode();

        A.setDireito(C);
        C.setEsquerdo(B);
        A.setPai(C.getPai());
        C.setPai(A);

        return A;
    }

    private No rotaocaoDuplaEsquerda(No A) {
        No B = A.getPai();
        No C = A.getEsquerdo();
        No D = C.getDireito();

        A.setEsquerdo(D);
        C.setDireito(A);

        B.setDireito(C);
        C.setPai(B);
        A.setPai(C);

        No noPai = rotacaoSimplesEsquerda(C);
        return noPai;
    }

    private No rotaocaoDuplaDireita(No A) {

        No B = A.getPai();
        No C = A.getDireito();
        No D = C.getEsquerdo();

        A.setDireito(D);
        C.setEsquerdo(A);

        B.setEsquerdo(C);
        C.setPai(B);
        A.setPai(C);

        No noPai = rotacaoSimplesDireita(C);
        return noPai;
    }

}