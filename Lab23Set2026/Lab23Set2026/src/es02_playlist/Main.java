package es02_playlist;

/*
 * Crea una playlist contenente cinque titoli di canzoni.
 * Stampa ogni titolo insieme alla sua posizione nella lista.
 * Rimuovi una canzone conoscendo il suo indice.
 * Rimuovi poi un'altra canzone conoscendone il titolo.
 * Stampa la prima e l'ultima canzone rimaste.
 * Svuota la playlist e verifica che sia effettivamente vuota.
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>(Arrays.asList("VIENI TE","VELENO 6", "Poter scegliere","old school","FORSE UN GIORNO"));
        playlist.remove(1); //RIMUOVERE DA INDICE
        IO.println(playlist);
        playlist.remove("Poter scegliere"); //RIMUOVERE CON NOME ELEMENTO
        IO.println(playlist);

        IO.println("prima "+playlist.get(0)+" ultimo: "+playlist.get(2)); //PRENDERE UN ELEMENTO
        IO.println(playlist.get(playlist.size()-1)); //PER VEDERE L'ULTIMO

        playlist.clear();
        if(playlist.isEmpty()){
            IO.println("LA LISTA è vuota");
        }
        else {IO.println("LA LISTA NON è vuota");}

    }
}
