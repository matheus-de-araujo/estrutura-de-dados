public class Main {

    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";

    public static void main(String [] args) {

        ArvoreRedBlack arb = new ArvoreRedBlack(8);
        arb.inserir(2);
        arb.inserir(1);
        arb.inserir(3);
        arb.inserir(4);
        arb.inserir(7);
        arb.inserir(5);
        arb.inserir(9);

        System.out.println(red + "Acabou" + reset);

    }
}
