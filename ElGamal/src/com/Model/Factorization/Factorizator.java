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
	 * Metodo per trovare i fattori primi
	 * @param daFattorizzare
	 * @return
	 */
	public ArrayList<Factor> fattorizza(BigInteger daFattorizzare){
		//Array list di fattori primi
		ArrayList<Factor> fattori = new ArrayList<Factor>();
		
		//Aggiungo il numero 1 alla lista dei fattori
		Factor one = new Factor(BigInteger.valueOf(1),1);
		fattori.add(one);	
		
		//Calcolo tutti i fattori primi del numero
		for(BigInteger i = BigInteger.valueOf(2); i.compareTo(daFattorizzare)<=0 ;i = i.add(BigInteger.valueOf(1))){
			
			//Se il fattore divide il numero
			if(daFattorizzare.mod(i).compareTo(BigInteger.valueOf(0))==0){
				
				//Definisco la potenza
				int power =0;
				
				//Finche il fattore divide il numero (e.g. 2 divide 12 per 2 volte)
				while (daFattorizzare.mod(i).compareTo(BigInteger.valueOf(0))==0) {
					//incremento la potenza
					power++;			   
					//calcolo il nuovo numero da fattorizzare come quello di partenza, diviso per il fattore
			        daFattorizzare = daFattorizzare.divide(i);
			      }
				
				//Costruisco un fattore primo, come fattore divisore e potenza
				Factor primeFactor = new Factor(i,power);
				
				//Aggiungo il fattore all'array dei fattori primi
				fattori.add(primeFactor);
			}			
		}		
		//Restituisco i fattori primi
		return fattori;
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
