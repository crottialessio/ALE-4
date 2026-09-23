# Array e ArrayList in Java

## 1. Che cos'è un array?

Un array è una struttura che permette di conservare più elementi
**dello stesso tipo**. Ogni elemento si trova in una posizione identificata da
un indice numerico che parte da `0`.

La lunghezza dell'array viene stabilita quando lo creiamo e non può cambiare.
Possiamo modificare i valori contenuti, ma non il numero delle posizioni.

```java
// Dichiariamo un array che può contenere 5 numeri interi.
int[] voti = new int[5];

// Inseriamo un valore in ogni posizione.
// Gli indici partono da 0, non da 1.
voti[0] = 7;
voti[1] = 8;
voti[2] = 6;
voti[3] = 9;
voti[4] = 5;
```

Possiamo immaginare l'array in questo modo:

| Indice | 0 | 1 | 2 | 3 | 4 |
|---:|---:|---:|---:|---:|---:|
| Valore | 7 | 8 | 6 | 9 | 5 |

La dimensione di un array viene decisa al momento della creazione e successivamente **non può cambiare**.

## Perché usare un array?

Senza un array dovremmo dichiarare una variabile diversa per ogni valore:

```java
int voto1 = 7;
int voto2 = 8;
int voto3 = 6;
int voto4 = 9;
int voto5 = 5;
```

Con un array possiamo raggruppare i valori e scorrerli con un ciclo:

```java
int[] voti = {7, 8, 6, 9, 5};

for (int voto : voti) {
    System.out.println(voto);
}
```

## Perché scegliere un array invece di un ArrayList?

L'array conviene quando conosciamo già il numero degli elementi e sappiamo che
non dovrà cambiare. Per esempio, possiamo usarlo per rappresentare i dodici
mesi dell'anno oppure i voti di cinque verifiche.

In questi casi l'array è una soluzione semplice e rende evidente che il numero
di valori è fisso. Se invece non sappiamo quanti elementi dovremo conservare,
un `ArrayList` è più comodo perché può cambiare dimensione.

## 2. Inizializzazione abbreviata

Se conosciamo già i valori, possiamo inserirli direttamente durante la creazione dell'array.

```java
// Java capisce automaticamente che servono 5 posizioni.
int[] voti = {7, 8, 6, 9, 5};

// Un array può contenere anche stringhe.
String[] nomi = {"Anna", "Luca", "Sara", "Marco"};
```

## 3. Leggere e modificare gli elementi

Per accedere a un elemento utilizziamo il nome dell'array seguito dall'indice tra parentesi quadre.

```java
int[] voti = {7, 8, 6, 9, 5};

// Leggiamo il valore che si trova all'indice 0.
System.out.println(voti[0]); // Stampa 7

// Sostituiamo il valore all'indice 2.
voti[2] = 7;
System.out.println(voti[2]); // Adesso stampa 7
```

L'indice dell'ultimo elemento è sempre `length - 1`.

```java
int[] voti = {7, 8, 6, 9, 5};

// voti.length vale 5, quindi l'ultimo indice è 4.
int ultimoVoto = voti[voti.length - 1];
System.out.println(ultimoVoto); // Stampa 5
```

Se proviamo ad accedere a una posizione inesistente, Java produce una `ArrayIndexOutOfBoundsException`.

```java
int[] voti = {7, 8, 6, 9, 5};

// ERRORE: gli indici validi vanno da 0 a 4.
System.out.println(voti[5]);
```

## 4. Scorrere un array con il ciclo for

Il ciclo `for` tradizionale permette di utilizzare sia l'indice sia il valore contenuto nell'array.

```java
int[] voti = {7, 8, 6, 9, 5};

// length restituisce il numero di elementi dell'array.
for (int i = 0; i < voti.length; i++) {
    // i è l'indice; voti[i] è il valore in quella posizione.
    System.out.println("Indice " + i + ": " + voti[i]);
}
```

Il ciclo continua finché `i` è minore di `voti.length`. Non bisogna usare `<=`, altrimenti si prova ad accedere a una posizione inesistente.

## 5. Il ciclo for-each

Quando non ci interessa conoscere l'indice, possiamo utilizzare il ciclo `for-each`.

```java
String[] nomi = {"Anna", "Luca", "Sara", "Marco"};

// A ogni ripetizione, nome contiene un elemento dell'array.
for (String nome : nomi) {
    System.out.println(nome);
}
```

Il `for-each` è più leggibile, ma non ci comunica la posizione dell'elemento.

## 6. Calcolare somma e media

```java
int[] voti = {7, 8, 6, 9, 5};
int somma = 0;

// Aggiungiamo ogni voto alla variabile somma.
for (int voto : voti) {
    somma = somma + voto;
}

// Il cast a double permette di ottenere un risultato con i decimali.
double media = (double) somma / voti.length;

System.out.println("Somma: " + somma);
System.out.println("Media: " + media);
```

Senza `(double)`, Java eseguirebbe una divisione tra numeri interi ed eliminerebbe l'eventuale parte decimale.

## Tipi primitivi e classi

In Java i tipi primitivi, come `int`, `double`, `boolean` e `char`,
rappresentano valori semplici. Per esempio, una variabile `int` contiene
direttamente un numero intero.

Le classi, invece, permettono di creare oggetti. Un oggetto può contenere dati
e offrire operazioni per utilizzarli. `String`, per esempio, è una classe e una
stringa è un oggetto.

Per ogni tipo primitivo esiste una classe corrispondente:

| Tipo primitivo | Classe corrispondente |
|---|---|
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |

Questa differenza è importante perché `ArrayList` è stato progettato per
contenere riferimenti a oggetti. Il tipo degli elementi viene indicato tra
parentesi angolari, per esempio `<String>` o `<Integer>`, e in quella posizione
Java permette di scrivere soltanto una classe, non un tipo primitivo.

Per questo `ArrayList<int>` non è valido: `int` rappresenta direttamente un
numero e non è un oggetto. Si usa invece `Integer`, una classe che permette di
rappresentare un numero intero come oggetto.

```java
// Non valido: int è un tipo primitivo.
// ArrayList<int> voti = new ArrayList<>();

// Valido: Integer è una classe.
ArrayList<Integer> voti = new ArrayList<>();
```

Quando scriviamo:

```java
voti.add(7);
```

Java converte automaticamente il valore `int` `7` in un oggetto `Integer`.
Questa conversione automatica si chiama **autoboxing**. Quando recuperiamo il
valore, Java può eseguire anche la conversione opposta:

```java
int primoVoto = voti.get(0);
```

In questo caso l'oggetto `Integer` viene riconvertito automaticamente in un
valore `int`; questa operazione si chiama **unboxing**.

## 7. Alcuni metodi della classe Arrays

La classe `Arrays` contiene operazioni utili per lavorare con gli array. Prima
di usarla dobbiamo importarla:

```java
import java.util.Arrays;
```

### Ordinare tutto l'array

`Arrays.sort` ordina direttamente gli elementi dell'array in ordine crescente.

```java
int[] numeri = {5, 2, 8, 1};

Arrays.sort(numeri);

System.out.println(Arrays.toString(numeri)); // [1, 2, 5, 8]
```

L'array originale viene modificato: il metodo non crea un secondo array.

### Ordinare soltanto un intervallo

Possiamo indicare l'indice iniziale e quello finale della parte da ordinare.
L'indice iniziale è incluso, mentre quello finale è escluso.

```java
int[] numeri = {9, 5, 2, 8, 1, 7};

// Ordina gli elementi agli indici 1, 2, 3 e 4.
Arrays.sort(numeri, 1, 5);

System.out.println(Arrays.toString(numeri)); // [9, 1, 2, 5, 8, 7]
```

Gli elementi agli indici `0` e `5` restano nella loro posizione.

### Ordinare altri tipi di dato

`Arrays.sort` può ordinare anche array di altri tipi. Con i numeri `double`
utilizza l'ordine crescente:

```java
double[] prezzi = {12.50, 3.99, 8.75, 5.20};

Arrays.sort(prezzi);

System.out.println(Arrays.toString(prezzi));
// [3.99, 5.2, 8.75, 12.5]
```

Con le stringhe utilizza l'ordine naturale, simile all'ordine alfabetico:

```java
String[] nomi = {"Sara", "Anna", "Luca", "Marco"};

Arrays.sort(nomi);

System.out.println(Arrays.toString(nomi));
// [Anna, Luca, Marco, Sara]
```

Le lettere maiuscole e minuscole vengono considerate diverse; per esempio,
una parola che inizia con una lettera maiuscola viene normalmente prima della
stessa parola scritta con l'iniziale minuscola.

## 8. Che cos'è un ArrayList?

Un `ArrayList` è simile a un array, ma può crescere e diminuire durante l'esecuzione del programma.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creiamo un ArrayList inizialmente vuoto.
        ArrayList<String> studenti = new ArrayList<>();

        // add aggiunge un elemento alla fine della lista.
        studenti.add("Anna");
        studenti.add("Luca");
        studenti.add("Sara");

        System.out.println(studenti);
    }
}
```

### Inizializzazione abbreviata

Se conosciamo già gli elementi, possiamo creare e riempire un `ArrayList` in
una sola istruzione usando `Arrays.asList`:

```java
import java.util.ArrayList;
import java.util.Arrays;

ArrayList<String> studenti = new ArrayList<>(
        Arrays.asList("Anna", "Luca", "Sara")
);
```

`Arrays.asList(...)` crea una lista a dimensione fissa. Passandola a
`new ArrayList<>(...)`, i suoi elementi vengono copiati in un nuovo
`ArrayList`, sul quale possiamo poi usare normalmente `add` e `remove`.

Da Java 9, e quindi anche in Java 27, possiamo scrivere la stessa cosa in modo
più semplice con `List.of(...)`:

```java
import java.util.ArrayList;
import java.util.List;

ArrayList<String> studenti = new ArrayList<>(
        List.of("Anna", "Luca", "Sara")
);
```

Anche `List.of(...)` crea inizialmente una lista non modificabile. Il
costruttore `new ArrayList<>(...)` ne copia gli elementi e produce un
`ArrayList` modificabile.

## 9. Operazioni principali su un ArrayList

### Perché può cambiare dimensione?

Un array normale ha una lunghezza fissa. Un `ArrayList`, invece, gestisce
automaticamente lo spazio in cui conserva gli elementi.

Possiamo immaginarlo come un contenitore con alcune posizioni libere. Quando lo
spazio termina, l'`ArrayList` crea internamente un contenitore più grande e vi
copia gli elementi già presenti. Per questo possiamo aggiungere nuovi valori
senza creare manualmente un altro array.

### add

`add` inserisce un nuovo elemento nella lista. Se indichiamo soltanto il
valore, l'elemento viene aggiunto alla fine e il numero di elementi aumenta di
uno.

```java
studenti.add("Anna");
studenti.add("Luca");
// La lista ora è [Anna, Luca].
```

Possiamo anche indicare la posizione in cui inserirlo. Gli elementi successivi
si spostano di una posizione verso destra.

```java
studenti.add(1, "Giulia");
// La lista ora è [Anna, Giulia, Luca].
```

In questo caso `Luca`, che si trovava all'indice `1`, viene spostato
all'indice `2` per lasciare spazio a `Giulia`.

### remove

`remove` elimina un elemento. Possiamo indicare il valore da eliminare oppure
la sua posizione. Quando un elemento viene rimosso, quelli successivi si
spostano verso sinistra e la dimensione della lista diminuisce.

```java
studenti.remove("Giulia"); // Rimuove il valore Giulia.
studenti.remove(0);        // Rimuove l'elemento all'indice 0.
```

Se lo stesso valore compare più volte, la rimozione tramite valore elimina
soltanto la prima occorrenza.

Per esempio, partendo da `[Anna, Giulia, Luca]`, la rimozione di `Giulia`
produce `[Anna, Luca]`: `Luca` passa dall'indice `2` all'indice `1` e non resta
una posizione vuota nel mezzo.

### contains

`contains` controlla se un determinato valore è presente nella lista. Restituisce
un valore `boolean`: `true` se lo trova, `false` altrimenti. Non modifica la
lista.

```java
boolean presente = studenti.contains("Luca");
System.out.println(presente); // true oppure false
```

Il confronto deve essere esatto: per esempio, `"Luca"` e `"luca"` sono due
stringhe diverse. Per effettuare il controllo, l'`ArrayList` esamina gli
elementi uno alla volta: termina quando trova quello cercato oppure quando
raggiunge la fine della lista.

### Complessità di tempo e memoria

Indichiamo con `n` il numero di elementi presenti nella lista.

| Operazione | Tempo | Memoria aggiuntiva | Motivo |
|---|---:|---:|---|
| `add(elemento)` in fondo | `O(1)` in media | `O(1)` normalmente | Normalmente inserisce nella prima posizione libera. |
| `add(indice, elemento)` | `O(n)` | `O(1)` normalmente | Può dover spostare molti elementi verso destra. |
| `remove` dell'ultimo elemento | `O(1)` | `O(1)` | Non deve spostare altri elementi. |
| `remove` per indice | `O(n)` | `O(1)` | Gli elementi successivi vengono spostati verso sinistra. |
| `remove` per valore | `O(n)` | `O(1)` | Prima cerca il valore, poi sposta gli elementi successivi. |
| `contains(elemento)` | `O(n)` | `O(1)` | Nel caso peggiore controlla tutta la lista. |

L'aggiunta in fondo è `O(1)` **in media**. Durante qualsiasi `add`, se lo spazio
interno è esaurito, l'`ArrayList` deve creare un contenitore più grande e
copiarvi i suoi `n` elementi. In quel caso servono temporaneamente `O(n)` tempo
e `O(n)` memoria. Poiché il ridimensionamento non avviene a ogni aggiunta, il
costo medio di una sequenza di aggiunte in fondo rimane `O(1)` per elemento.

Nel complesso, un `ArrayList` che contiene `n` elementi occupa `O(n)` memoria.
Può riservare anche alcune posizioni ancora vuote per rendere più rapide le
aggiunte successive.

### Esempio completo

```java
ArrayList<String> studenti = new ArrayList<>();

// Aggiunta di alcuni elementi.
studenti.add("Anna");
studenti.add("Luca");
studenti.add("Sara");

// get legge l'elemento che si trova a un certo indice.
System.out.println(studenti.get(0)); // Anna

// set sostituisce l'elemento che si trova a un certo indice.
studenti.set(1, "Marco");

// add può inserire un elemento in una posizione precisa.
studenti.add(1, "Giulia");

// remove elimina un elemento usando il suo valore.
studenti.remove("Sara");

// contains controlla se un valore è presente.
boolean presente = studenti.contains("Marco");

// size restituisce il numero di elementi.
System.out.println(studenti.size());
```

Possiamo scorrere un `ArrayList` con entrambi i tipi di ciclo.

```java
// Ciclo for tradizionale: usa size() e get().
for (int i = 0; i < studenti.size(); i++) {
    System.out.println(i + ": " + studenti.get(i));
}

// Ciclo for-each: legge direttamente ogni elemento.
for (String studente : studenti) {
    System.out.println(studente);
}
```

## 10. ArrayList di numeri

Come abbiamo visto, un `ArrayList` non può utilizzare direttamente i tipi
primitivi. Si usa quindi la classe corrispondente.

```java
// Usiamo Integer e non int.
ArrayList<Integer> voti = new ArrayList<>();

voti.add(7);
voti.add(8);
voti.add(6);

int somma = 0;

for (int voto : voti) {
    somma += voto;
}

double media = (double) somma / voti.size();

System.out.println("Voti: " + voti);
System.out.println("Media: " + media);
```

Java converte automaticamente tra `int` e `Integer` nella maggior parte delle situazioni comuni.

## 11. Array e ArrayList a confronto

| Operazione | Array | ArrayList |
|---|---|---|
| Creazione | `int[] numeri = new int[5];` | `ArrayList<Integer> numeri = new ArrayList<>();` |
| Dimensione | Fissa | Variabile |
| Numero di elementi | `numeri.length` | `numeri.size()` |
| Lettura | `numeri[0]` | `numeri.get(0)` |
| Modifica | `numeri[0] = 10` | `numeri.set(0, 10)` |
| Aggiunta | Non diretta | `numeri.add(10)` |
| Rimozione | Non diretta | `numeri.remove(0)` |
| Ricerca | Ciclo manuale | `numeri.contains(10)` |

`ArrayList` può risultare più semplice perché offre metodi pronti per aggiungere, rimuovere e cercare elementi. Inoltre, non è necessario conoscere in anticipo la quantità di dati.

Un array rimane utile quando il numero degli elementi è noto e non deve cambiare.

> Il numero di elementi è fisso oppure potrebbe cambiare?

- Se è fisso, un array è spesso sufficiente.
- Se può cambiare, un `ArrayList` è normalmente più comodo.

## 12. Altri metodi di ArrayList

### addAll

`addAll` aggiunge a una lista tutti gli elementi di un'altra lista. Senza
indice li inserisce in fondo; specificando un indice li inserisce a partire da
quella posizione.

```java
ArrayList<String> classeA = new ArrayList<>(List.of("Anna", "Luca"));
ArrayList<String> classeB = new ArrayList<>(List.of("Sara", "Marco"));

classeA.addAll(classeB);
System.out.println(classeA); // [Anna, Luca, Sara, Marco]
```

### clear e isEmpty

`clear` rimuove tutti gli elementi, lasciando la lista vuota. `isEmpty`
controlla se la lista non contiene elementi e restituisce un valore booleano.

```java
ArrayList<String> studenti = new ArrayList<>(List.of("Anna", "Luca"));

System.out.println(studenti.isEmpty()); // false

studenti.clear();

System.out.println(studenti);           // []
System.out.println(studenti.isEmpty()); // true
```

## 13. Assegnazione e copia di un ArrayList

In questo esempio `test1` contiene una lista. L'istruzione `test2 = test1` non
crea una nuova lista: entrambe le variabili fanno riferimento allo stesso
oggetto.

Il costruttore `new ArrayList<>(test1)`, invece, crea una nuova lista e vi
copia gli elementi di `test1`.

```java
ArrayList<Integer> test1 = new ArrayList<>(List.of(1, 2));

// test2 e test1 indicano la stessa lista.
ArrayList<Integer> test2 = test1;

// test3 indica una nuova lista con gli stessi elementi iniziali.
ArrayList<Integer> test3 = new ArrayList<>(test1);

System.out.println("Lista 1: " + test1); // [1, 2]
System.out.println("Lista 2: " + test2); // [1, 2]
System.out.println("Lista 3: " + test3); // [1, 2]

test1.set(1, 5);

System.out.println("Lista 1: " + test1); // [1, 5]
System.out.println("Lista 2: " + test2); // [1, 5]
System.out.println("Lista 3: " + test3); // [1, 2]
```

La modifica effettuata tramite `test1` è visibile anche tramite `test2`, perché
le due variabili indicano la stessa lista. `test3` non cambia perché indica una
lista diversa.
