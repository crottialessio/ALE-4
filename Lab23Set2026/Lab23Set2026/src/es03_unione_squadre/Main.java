    package es03_unione_squadre;

/*
 * Crea due liste che rappresentano due squadre di giocatori.
 * Inserisci almeno tre nomi in ciascuna squadra.
 * Crea una terza lista e unisci le squadre.
 * Inserisci il capitano all'inizio della nuova lista.
 * Cerca la posizione di un giocatore scelto da te.
 * Infine rimuovi dalla lista tutti i membri di una delle due squadre.
 */

import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> squadra_rossa=new ArrayList<>(Arrays.asList("MESSI","RONALDO","NEYMAR"));
        ArrayList<String> squadra_blu=new ArrayList<>(Arrays.asList("LAUTARO","THURAM","DIMARCO"));
        ArrayList<String> squadra_mista= new ArrayList<>();
        squadra_mista.addAll(squadra_blu); //AGGIUNGERE A LISTA TUTTI GLI ELEMENTI DI UNA LISTA
        squadra_mista.addAll(squadra_rossa);
        IO.println(squadra_mista);
        squadra_mista.addFirst("SOMMER");   //AGGIUNGERE PER PRIMO
        IO.println(squadra_mista);
        IO.println(squadra_mista.indexOf("DIMARCO")+" :indice DIMARCO"); //TROVARE INDICE

    }
}
