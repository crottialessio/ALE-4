package es00_cast_e_parse;

/*
 * Crea due String contenenti due numeri interi, uno pari e uno dispari.
 * Prova a convertirle in int con un cast e osserva l'errore di compilazione.
 * Usa il parse per convertire a int.
 * Calcola la loro media e salvala in una variabile double.
 * Stampa il risultato e osserva.
 */
public class Main {
    public static void main(String[] args) {
        String str1 = "10";
        String str2 = "11";

        // int n1= (int) str1;   NON VA DA STRING A INT
        int n1=Integer.parseInt(str1);
        int n2=Integer.parseInt(str2);
        int mediaint= (n1+n2)/2; //perdo il decimale
        //double media_db1=(double) mediaint; // CAST ESPLICITO
        double db_media=(double) (n1+n2)/2;  // TIENE IL DECIMALE
        IO.println(mediaint);
        IO.println(db_media);

    }

}
