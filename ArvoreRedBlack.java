public class ArvoreRedBlack extends ArvoreAbstract {

    public ArvoreRedBlack(int valor) {
        super(valor);
        this.raiz.setBlackNode();
    }

    @Override
    public void inserir(int valor) {
        this.inserir(this.raiz, valor);
        System.out.println("Inserindo o valor: " + valor);
        /** 
         * Validar as propriedades da árvore, se preciso
         * balancear
        */
    }

    @Override
    public int remover(int valor) throws Exception {
        return 0;
    }

    @Override
    public int altura() {
        return this.altura(this.raiz);
    }

}