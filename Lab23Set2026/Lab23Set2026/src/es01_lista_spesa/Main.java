package es01_lista_spesa;

 import java.util.ArrayList;
 import java.util.Arrays ;
/*
 * Crea una lista della spesa e inserisci almeno quattro prodotti.
 * Aggiungi un nuovo prodotto in fondo alla lista.
 * Inserisci poi un prodotto in una posizione precisa.
 * Modifica uno dei prodotti già presenti usando il suo indice.
 * Verifica se la lista contiene "latte".
 * Infine stampa tutti i prodotti e il numero totale di elementi.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> li_vuotaa=new ArrayList<>(); //CREA LISTA VUOTA
        ArrayList<String> li_spesa = new ArrayList<>(Arrays.asList("grana", "cola", "pasta","sugo"));
        li_spesa.add("acuqa");
        IO.println(li_spesa+"  --AZZIONE ADD GENERICA");
        li_spesa.add(2,"pandoro");
        IO.println(li_spesa+"  --AZZIONE ADD POSIZIONE SPECIFICA");
        li_spesa.set(1,"latte");
        IO.println(li_spesa+"  --AZZIONE SET SOSTITUISCE POSIZIONE SPECIFICA");

        // QUA VEDE SE C'è ELEMENTO
        if (li_spesa.contains("latte")){
            IO.println("c'è il latte");
        }
        else{IO.println("NON cè il LATTE");}

        int numero_elementi_li= li_spesa.size();
        IO.println("ECCO LA LISTA DELLA SPESA: "+li_spesa+" ci sono n prodotti: "+numero_elementi_li);


    }
}
