/**
 * 
 */
package com.Model.Factorization;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Classe che esegue la fattorizzazione di un numero 
 * @author Alessandro
 *
 */
public class Factorizator {
	
	public Factorizator(){
		
	}
	/**
	 * Metodo che fattorizza un numero	
	 * @param daFattorizzare
	 * @return
	 */
	public ArrayList<BigInteger> fattorizza(BigInteger daFattorizzare){
		//Array list di fattori primi
		ArrayList<BigInteger> fattori = new ArrayList<BigInteger>();
		
		//Aggiungo il numero 1 alla lista dei fattori		
		fattori.add(BigInteger.valueOf(1));	
		
		//Calcolo tutti i fattori primi del numero
		for(BigInteger i = BigInteger.valueOf(2); i.compareTo(daFattorizzare)<=0 ;i = i.add(BigInteger.valueOf(1))){
			
			//Se il fattore divide il numero
			if(daFattorizzare.mod(i).compareTo(BigInteger.valueOf(0))==0){			
				//Finche il fattore divide il numero (e.g. 2 divide 12 per 2 volte)
				while (daFattorizzare.mod(i).compareTo(BigInteger.valueOf(0))==0) {
					fattori.add(i);		   
					//calcolo il nuovo numero da fattorizzare come quello di partenza, diviso per il fattore
			        daFattorizzare = daFattorizzare.divide(i);
				}				
			}			
		}		
		//Restituisco i fattori primi
		return fattori;
	}
	
	/**
	 * Metodo che restituisce tutti i divisori di un numero la cui scomposizione in fattori primi è quella passata 
	 * come parametri
	 * @param fattori Array di fattori
	 * @return
	 */
	public ArrayList<BigInteger> calcolaDivisoriDiUnNumeroDaFattori(ArrayList<BigInteger> fattori){
		//array in cui metto i divisori
		ArrayList<BigInteger> divisori = new ArrayList<BigInteger>();
		
		//dimensione dell'array dei fattori
		int n = fattori.size();
		int h = 0;
		BigInteger valore;
		//per tutti i fattori
		for (int i = n-1; i>=0;i--){		
			//vado sul numero immediatamente a sinistra di quello di partenza
			for(int w = i-1 ; w>=0; w--){
				
				valore = fattori.get(i);
				
				for(int j = w-h; j>=0 ; j--){					
										
						valore = valore.multiply(fattori.get(j));
						
							divisori.add(valore);
		
				}
				
				
			}
			
			
		}
		return divisori;
		
	}
	
	/**
	 * Algoritmo bruteforce che restituisce i divisori di un numero
	 * @param numeroDaDividere
	 * @return
	 */
	public ArrayList<BigInteger> divisoriNumero(BigInteger numeroDaDividere){
		ArrayList<BigInteger> divisori = new ArrayList<BigInteger>();
		
		for (BigInteger i = BigInteger.valueOf(1); i.compareTo(numeroDaDividere)<=0;i = i.add(BigInteger.valueOf(1))){
			if(numeroDaDividere.mod(i).equals(BigInteger.valueOf(0))){
				divisori.add(i);
			}
		}
		
		return divisori;
	}
	
	
	/**
	 * Algoritmo che restituisce i divisori di un numero in base alla sua fattorizzazione
	 * @param numeroDaDividere è il numero di cui si vogliono ottenere i divisori
	 * @return Divisori del numero passato come parametro
	 */
	
	public ArrayList<BigInteger> divisoriNumeroAvanzato(BigInteger numeroDaDividere){
		
		//Array list di divisori
		ArrayList<BigInteger> divisori = new ArrayList<BigInteger>();
		
		//Sicuramente 1 è un divisore del numero
		divisori.add(BigInteger.valueOf(1));
		//indice dell'array di divisori
		int indiceArray =0;
		
		/*Calcolo tutti i divisori del numero in questo modo:
		 * - Ogni volta eseguo la divisone del numero per un fattore
		 * - Se la divisone non da resto il divisore divide il numero
		 * - Vedo se il divisore è già stato inserito nella lista dei divisori e:
		 * 		
		 * 		-Se non presente, determino l'insieme degli elementi con cui moltiplicare quello nuovo
		 * 		 nell'insieme di TUTTI i divisori
		 * 
		 * 		-Se presente, determino l'insieme degli elementi con cui moltiplicare quello nuovo nell'insieme
		 * 		 formato dagli ultimi elementi, a partire dalla posizione del divisore.
		 *  in tal caso non lo inserisco di
		 *   nuovo perchè è già presente.
		 * - Eseguo il prodotto del divisore attuale con quello degli altri divisori già inseriti nella lista
		 * 	 in questo modo ho già la lista di tutti i divisori fatta.
		 * 
		 */
		for(BigInteger i = BigInteger.valueOf(2); i.compareTo(numeroDaDividere)<=0 ;i = i.add(BigInteger.valueOf(1))){
			
			
			//Se il fattore divide il numero
			if(numeroDaDividere.mod(i).compareTo(BigInteger.valueOf(0))==0){			
				//Finche il fattore divide il numero (e.g. 2 divide 12 per 2 volte)
				while (numeroDaDividere.mod(i).compareTo(BigInteger.valueOf(0))==0) {
					//dimensione dell'array dei divisori
					int n = divisori.size();			
					
					/* 
					 * Verifico se l'elemento da inserire è già presente nell'array.
					 * Se lo fosse, potrebbe essere solo nella posizione indice Array, determinata come la metà della
					 * dimensione dell'array. Infatti, se l'elemento non è presente, andrà aggiunto non solo lui stesso, 
					 * ma anche tutta la sequenza di divisori generati dal prodotto dei divisori già presenti, per lui stesso.
					 * Quindi aggiungendo ogni prodotto del nuovo divisore per ciascuno degli elementi dell'array di partenza,
					 * questo raddoppia di dimensione, E, poichè il primo elemento dell'array di parnteza è 1, l'elemento esattamente
					 * a metà del nuovo array di divisori sarà il nuovo divisore. 
					 * 
					 * e.g.
					 * 
					 * numero da dividere = 20
					 * 
					 * array divisori : {1} , variabile "indiceArray" = 0
					 * 
					 * trovo 2 come divisore di 20 -> devo aggiungerlo, non è presente, lo aggiungo
					 * 
					 * array divisori : {1,2} , variabile "indiceArray" = size/2 = 1
					 * 
					*/
					if(divisori.get(indiceArray).compareTo(i)!=0){
						//Faccio il prodotto del nuovo divisore con gli elementi dell'array, per ogni elemento
						for(int k = 0; k<n;k++){
							divisori.add(divisori.get(k).multiply(i));
						}
						//calcolo indiceArray come la metà della dimensione dell'array
						indiceArray= divisori.size()/2;						
						
					}
					/*
					 * In questo caso l'elemento è presente nell'array. Conseguenze:
					 * - L'elemento si trova in posizione indiceArray;
					 * - OGNI elemento che si trova nelle ultime posizione, in numero pari al valore di "indiceArray",
					 *   è stato generato a partire dagli elementi nelle posizioni dalla prima fino al valore di "indiceArray".
					 * - Quindi, sono da considerarsi come "nuove scoperte" solo i divisori generati dal prodotto tra il nuovo 
					 *   divisore e gli elementi dalla posizione  size() - indiceArray.
					 *   
					 *    e.g.
					 *    
					 *    numero da dividere = 20
					 *    
					 *    array divisori : {1,2} , variabile "indiceArray" = 1
					 *    
					 *    trovo 2 come divisore di 10 (20/2) ->devo aggiungerlo, E' presente! Non lo aggiungo, altrimenti
					 *    duplicherei i divisori, quindi faccio il prodotto solo con gli ultimi dimensione-indiceArray = 2-1 
					 *    elementi, che mi genera 4.
					 *    
					 *    array divisori : {1,2,4} , variabile "indiceArray" = 1, non cambia perchè non ho inserito un 
					 *    fattore non presente, ho solo inserito un divisore, multiplo di un elemento già presente. 
					 */
					else{
						for(int k = n -indiceArray; k<n;k++){
							divisori.add(divisori.get(k).multiply(i));
						}
					}
					//calcolo il nuovo numero da dividere come quello di partenza, diviso per il fattore
					numeroDaDividere = numeroDaDividere.divide(i);
				}				
			}			
		}		
		//Restituisco i divisori 
		return divisori;
		
	}
	
	
	
	
	/**
	 * Metodo che trova la radice quadrata di un numero n
	 * @param n
	 * @return
	 */
	public BigInteger sqrt(BigInteger n) {
		  BigInteger a = BigInteger.ONE;
		  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		  while(b.compareTo(a) >= 0) {
		    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
		    if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
		    else a = mid.add(BigInteger.ONE);
		  }
		  return a.subtract(BigInteger.ONE);
		}

}
