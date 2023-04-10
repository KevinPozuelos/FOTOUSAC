package photousac;

import Vista.JFPrincipal;

public class PhotoUsac {

    public static ListaSimple ListaGeneral = new ListaSimple();
    public static BinManager bin = new BinManager();
    public static String User;
    public static Pila Conversor;
    public static Cola ConversorC;

    public static void main(String[] args) {

        Conversor = new Pila();
        ConversorC = new Cola();
        User = "";
        JFPrincipal pri = new JFPrincipal();
        pri.setVisible(true);
        bin.writeObject(ListaGeneral);

    }

}
