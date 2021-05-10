public class ArvoreRedBlack extends ArvoreAbstract {

    public ArvoreRedBlack(int valor) {
        super(valor);
        this.raiz.setBlackNode();
    }

    @Override
    public void inserir(int valor) {
        this.inserir(this.raiz, valor);

        /** 
         * Validar as propriedades da árvore, se preciso
         * balancear
        */
    }

    @Override
    public int remover(int valor) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int altura() {
        return this.altura(this.raiz);
    }

}