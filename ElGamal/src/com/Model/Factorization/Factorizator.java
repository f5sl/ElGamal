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
	 * Avanzat
	 * @param numeroDaDividere
	 * @return
	 */
	
	public ArrayList<BigInteger> divisoriNumeroAvanzato(BigInteger numeroDaDividere){
		
		//Array list di fattori primi
		ArrayList<BigInteger> fattori = new ArrayList<BigInteger>();
		
		fattori.add(BigInteger.valueOf(1));	
		int indiceArray =0;
		//Calcolo tutti i fattori primi del numero
		for(BigInteger i = BigInteger.valueOf(2); i.compareTo(numeroDaDividere)<=0 ;i = i.add(BigInteger.valueOf(1))){
			
			
			//Se il fattore divide il numero
			if(numeroDaDividere.mod(i).compareTo(BigInteger.valueOf(0))==0){			
				//Finche il fattore divide il numero (e.g. 2 divide 12 per 2 volte)
				while (numeroDaDividere.mod(i).compareTo(BigInteger.valueOf(0))==0) {
					
					if(fattori.get(indiceArray).compareTo(i)!=0){								
						fattori.add(i);				
						indiceArray++;
						//calcolo il nuovo numero da fattorizzare come quello di partenza, diviso per il fattore
						
					}
					int n = fattori.size()-1;
					for(int k = 0; k<=n;k++){
						fattori.add(fattori.get(k).multiply(i));
					}
					numeroDaDividere = numeroDaDividere.divide(i);
				}				
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
