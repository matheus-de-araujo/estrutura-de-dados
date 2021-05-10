public abstract class ArvoreAbstract {
    
    protected No raiz;
    protected int altura;

    public ArvoreAbstract(int valor) {
        this.raiz = new No(valor);
        this.altura = 0;
    }

    /**
     * @description Método que chama outro método a partir da raiz da árvore 
     * navegando de forma recursiva visitando os nós. RED: RAIZ -> ESQUERDA -> DIREITA
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     */  
    public void preOrdem() {
        preOrdem(this.raiz);
    }

    private void preOrdem(No no) {
        if(no != null) {
            System.out.print(no.getValor() + ", ");
            preOrdem(no.getEsquerdo());
            preOrdem(no.getDireito());
        }
    }

    /**
     * @description Método que chama outro método a partir da raiz da árvore 
     * navegando de forma recursiva visitando os nós. ERD: ESQUERDA -> RAIZ -> DIREITA
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     */  
    public void emOrdem() {
        emOrdem(this.raiz);
    }

    private void emOrdem(No no) {
        if(no != null) {
            emOrdem(no.getEsquerdo());
            System.out.print(no.getValor() + ", ");
            emOrdem(no.getDireito());
        }
    }

    
    /**
     * @description Método que chama outro método a partir da raiz da árvore 
     * navegando de forma recursiva visitando os nós. ERD: ESQUERDA -> DIREITA -> RAIZ
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     */
    public void posOrdem() {
        posOrdem(this.raiz);
    }

    private void posOrdem(No no) {
        if(no != null) {
            posOrdem(no.getEsquerdo());
            posOrdem(no.getDireito());
            System.out.print(no.getValor() + ", ");
        }
    }

    public abstract void inserir(int valor);
    
    /**
     * @description Método que acontece a sobrecarga de método, e a partir da 
     * raiz navega-se entre os nós de forma recursiva procurando o local exato
     * onde deve ser inserido o valor. 
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     * @param no No - acesso nó recursivo
     * @param valor float - valor a ser inserido na árvore.
     */ 
    protected void inserir(No no, int valor) {

        if(valor < no.getValor()) {
            //esquerda
            if(no.getEsquerdo() == null) {
                No novo = new No(valor);
                no.setEsquerdo(novo);
                novo.setPai(no);
            }

            else  {
                inserir(no.getEsquerdo(), valor);
            }
        }

        else {
            // direita
            if(no.getDireito() == null) {
                No novo = new No(valor);
                no.setDireito(novo);
                novo.setPai(no);
            }

            else {
                inserir(no.getDireito(), valor);
            }
        }
    }

    public abstract int remover(int valor) throws Exception;

    /**
     * @description Método que remove valor em uma arvore binária de busca, 
     * existem três possibiliades para o nó: nó folha (sem filhos), nó com apenas
     * um filho a esquerda ou a direita ou nó com dois filhos (duas sub-arvores)
     * o método navega pela árvore nó a nó, até encontrar o nó desejado, remove-o
     * conforme cada caso, e retorna o valor, caso não encontre o nó solta exceção. 
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     * @param no No - acesso recursivo
     * @param valor float - valor a ser removido
     * @return float - valor a ser removido da árvore 
     * @exception Exception - tratamento caso nó não seja encontrado
     */
    protected int remover(No no, int valor) throws Exception {
        
        /*valor não encontrado*/
        if(no == null) {
            throw new Exception("Valor nao encontrado");
        }
        /*valor maior que o nó, procurar na direita*/
        else if(valor > no.getValor()) {
            int response = remover(no.getDireito(), valor);
            
            if(no.getDireito().getValor() == valor) {
                no.setDireito(null);
            }
            return response;
        }
        /*valor menor que o nó, procurar na esquerda*/
        else if(valor < no.getValor()) {
            int response = remover(no.getEsquerdo(), valor);
            
            if(no.getEsquerdo().getValor() == valor) {
                no.setEsquerdo(null);
            }
            return response;
        }
        /*valor encontrado esquerdo possui um filho*/
        else if (no.getValor() == valor
                && no.getEsquerdo() != null 
                && no.getDireito() == null
        ) {
            No aux = no.getEsquerdo();
            no.setValor(no.getEsquerdo().getValor());
            no.setEsquerdo(null);
            return aux.getValor();
            
        }
        /*valor encontrado direito possui um filho*/
        else if (no.getValor() == valor
                && no.getEsquerdo() == null 
                && no.getDireito() != null
        ) {
            No aux = no.getDireito();
            no.setValor(no.getDireito().getValor());
            no.setDireito(null);
            return aux.getValor();
            
        }
        /*valor encontrado sem filhos*/
        else if (no.getValor() == valor
                && no.getEsquerdo() == null 
                && no.getDireito() == null
        ) {
            return no.getValor();
        }
        /*valor encontrado, e possui dois filhos*/
        else {
            No noAux = removerMaximo(no.getEsquerdo());
            int response = no.getValor();
            no.setValor(noAux.getValor());
            
            if(no.getValor() == no.getEsquerdo().getValor())
                no.setEsquerdo(null);
                
            return response;
        }
    }

    /**
     * @description método usado na remoção, objetivo encontrar o maior valor na
     * subárvore a esquerda, removê-lo e retornar o nó
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     * @param no No - raz da sub-arvore para buscar o maior valor
     * @return No - nó removido
     */
    public No removerMaximo(No no) {
        if(no.getDireito() == null 
                && no.getEsquerdo() == null) {
            return no;
        }
        else if(no.getDireito() != null 
                && no.getDireito().getDireito() == null
                && no.getDireito().getEsquerdo() == null) {
            
            No aux = no.getDireito();
            no.setDireito(null);
            return aux;
        }
        
        else if(no.getDireito() != null
                && no.getDireito().getDireito() == null
                && no.getDireito().getEsquerdo() != null) {
            
            No aux = no.getDireito();
            no.setDireito(no.getDireito().getEsquerdo());
            return aux;
        }
        
        else {
            return removerMaximo(no.getDireito());
        }
    }


    /**
     * @description Calcula altura a partir da raiz
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     */
    public abstract int altura();
    
    /**
     * @description Calcula altur a partir do nó
     * @author Hagamenon Oliveira <haganicolau@gmail.com>
     * @param no No - No da árvore.
     */
    public int altura(No no) {
        if(no != null) {

            int esq = altura(no.getEsquerdo()) + 1;
            int dir = altura(no.getDireito()) + 1;
            int h = esq > dir ? esq : dir;
            
            this.altura = h;


            return h;
        }

        return 0;   
    }
}
