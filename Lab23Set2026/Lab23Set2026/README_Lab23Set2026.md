# Allenamento su liste e array in Java
## Cast e parse

Il **cast** converte un valore da un tipo numerico a un altro tipo compatibile.
Si scrive il tipo desiderato tra parentesi prima del valore. Il cast esplicito
serve soprattutto quando si passa da un tipo più ampio a uno più ristretto,
perché durante la conversione alcune informazioni possono andare perse.

```java
double altezza = 178.9;
int centimetri = (int) altezza;

System.out.println(centimetri); // 178
```

In questo caso la parte decimale viene eliminata, non arrotondata. Altri esempi
di conversioni che richiedono un cast sono `long` in `int`, `int` in `short` e
`double` in `float`.

```java
long abitanti = 8_000_000L;
int abitantiInt = (int) abitanti;

int quantita = 300;
short quantitaShort = (short) quantita;

double prezzo = 19.99;
float prezzoFloat = (float) prezzo;
```

Il cast non controlla se il valore entra nel nuovo tipo. Se il valore è troppo
grande o troppo piccolo, il risultato può essere diverso da quello atteso.

```java
int quantita = 40_000;
short quantitaShort = (short) quantita;

System.out.println(quantitaShort); // Il risultato non è 40000.
```

Quando si passa da un tipo più ristretto a uno più ampio, invece, Java esegue
normalmente la conversione in modo automatico. Il cast non è necessario e
l'ambiente di sviluppo può segnalarlo come ridondante.

```java
int numero = 12;
long numeroLong = numero;
double numeroDecimale = numero;

System.out.println(numeroDecimale); // 12.0
```

Le principali conversioni automatiche seguono questa direzione:

```text
byte -> short -> int -> long -> float -> double
                  char -> int
```

Questo schema indica quali conversioni Java accetta automaticamente, ma non
garantisce sempre che ogni cifra rimanga identica. Per esempio, un `long` molto
grande convertito in `float` può perdere precisione, anche se il cast non è
richiesto.

### Cast nella divisione tra interi

Se entrambi gli operandi di una divisione sono `int`, Java esegue una divisione
intera ed elimina la parte decimale. Questo avviene anche se il risultato viene
salvato successivamente in una variabile `double`.

```java
int somma = 7;
int quantita = 2;

double media = somma / quantita;
System.out.println(media); // 3.0, non 3.5
```

Per ottenere un risultato decimale, almeno uno dei due operandi deve essere
convertito in `double` prima della divisione.

```java
double media = (double) somma / quantita;
System.out.println(media); // 3.5
```

È possibile convertire anche il denominatore: il risultato è lo stesso.

```java
double media = somma / (double) quantita;
```

Il cast effettuato dopo la divisione arriva invece troppo tardi, perché la parte
decimale è già stata eliminata.

```java
double media = (double) (somma / quantita);
System.out.println(media); // 3.0
```

Il **parse** interpreta il testo contenuto in una `String` e produce un valore
numerico. Non si può convertire una stringa con un cast perché `String` e `int`
non sono tipi numerici compatibili.

```java
String testo = "25";
int numero = Integer.parseInt(testo);

System.out.println(numero + 5); // 30
```

Esistono metodi di parse per diversi tipi primitivi:

```java
int intero = Integer.parseInt("25");
double decimale = Double.parseDouble("12.5");
boolean risposta = Boolean.parseBoolean("true");
```

Se il testo non rappresenta un numero valido, per esempio `"ciao"`, il parse
di un numero causa un errore chiamato `NumberFormatException`.

In sintesi:

- il cast converte un valore tra tipi compatibili, per esempio da `double` a `int`;
- il parse interpreta una `String`, per esempio trasformando `"25"` nel numero `25`.

## Metodi di ArrayList usati negli esercizi

| Metodo | Definizione |
|---|---|
| `add(elemento)` | Aggiunge un elemento in fondo alla lista. |
| `add(indice, elemento)` | Inserisce un elemento nella posizione indicata. |
| `addAll(lista)` | Aggiunge alla fine tutti gli elementi di un'altra lista. |
| `get(indice)` | Restituisce l'elemento presente nella posizione indicata. |
| `set(indice, elemento)` | Sostituisce l'elemento presente nella posizione indicata. |
| `remove(indice)` | Rimuove l'elemento che si trova all'indice indicato. |
| `remove(elemento)` | Rimuove la prima occorrenza dell'elemento indicato. |
| `removeAll(lista)` | Rimuove tutti gli elementi presenti anche nella lista indicata. |
| `clear()` | Rimuove tutti gli elementi dalla lista. |
| `size()` | Restituisce il numero di elementi presenti. |
| `isEmpty()` | Restituisce `true` se la lista è vuota. |
| `contains(elemento)` | Controlla se un elemento è presente nella lista. |
| `indexOf(elemento)` | Restituisce l'indice della prima occorrenza oppure `-1`. |

> **Attenzione — liste di Integer**  
> `remove(2)` rimuove l'elemento all'indice `2`, mentre
> `remove(Integer.valueOf(2))` rimuove il valore `2`.

## Array

Un array contiene un numero fisso di elementi dello stesso tipo. Gli indici
partono da `0`; il primo elemento si trova all'indice `0` e l'ultimo all'indice
`length - 1`.

| Sintassi o metodo | Definizione |
|---|---|
| `new int[5]` | Crea un array di cinque interi. |
| `{1, 2, 3}` | Crea e inizializza un array con valori già conosciuti. |
| `array[indice]` | Legge l'elemento nella posizione indicata. |
| `array[indice] = valore` | Modifica l'elemento nella posizione indicata. |
| `array.length` | Indica il numero di posizioni dell'array. |

La lunghezza di un array non può cambiare dopo la creazione. Non esistono
quindi metodi diretti per aggiungere o rimuovere elementi: per queste operazioni
è generalmente più adatto un `ArrayList`.
