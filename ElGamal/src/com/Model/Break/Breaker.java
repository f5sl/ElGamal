/**
 * 
 */
package com.Model.Break;

import java.math.BigInteger;
import java.util.ArrayList;


import com.Model.ElGamalAlgorithm.ElGamalCypheredMessage;
import com.Model.ElGamalAlgorithm.ElGamalMachine;
import com.Model.ElGamalAlgorithm.PlainMessage;
import com.Model.ElGamalAlgorithm.PrivateKey;
import com.Model.ElGamalAlgorithm.PublicKey;
import com.Model.Utility.Convertitore;
import com.Model.Utility.Utility;

/**
 * Classe che ha il compito di implementare l'algoritmo di forzatura di un messaggio cifrato con 
 * ElGamal
 * @author Alessandro
 *
 */
public class Breaker {
	
	
	/**
	 * Metodo che decifra un messaggio sulla base dell'ipotesi che si conosca un messaggio in chiaro e che il "k" scelto
	 * per la cifratura sia lo stesso
	 * 
	 * @param messaggioCifrato1 Messaggio cifrato 1, di cui si conosce il testo in chiaro
	 * @param messaggioCifrato2 Messaggio cifrato 2, che si vuole decifrare "Forzatamente"
	 * @param messaggioDecifrato1 Messaggio in chiaro che corrisponde al messaggio cifrato 1
	 * @return Messaggio in chiaro corrispondente al messaggio cifrato 2
	 */
	public static PlainMessage forzaMessaggioDaMessaggioNoto(PublicKey chiavePubblica, ElGamalCypheredMessage messaggioCifrato1, 
													ElGamalCypheredMessage messaggioCifrato2,	PlainMessage messaggioDecifrato1 ){
		
		//istanzio un bigInteger corrispondente al testo in chiaro
		BigInteger BIMessaggioDecifrato1= Convertitore.convertiStringaInBigInteger(messaggioDecifrato1.get_message());
		//Recupero t dal messaggio 1		
		BigInteger t1 = messaggioCifrato1.get_t();
		//calcolo t inverso
		BigInteger t1_inverso = t1.modPow((BigInteger.valueOf(-1)), chiavePubblica.get_p());
		//Recupero t dal messaggio 2
		BigInteger t2 = messaggioCifrato2.get_t();
		
		//Decifro il messaggio 2
		BigInteger BIMessaggioDecifrato2 = t2.multiply(BIMessaggioDecifrato1).multiply(t1_inverso).mod(chiavePubblica.get_p());
		//Costruisco un messaggio in chiaro, a partire dal BigInteger corrispondente
		PlainMessage  messaggioDecifrato2 =  new PlainMessage(new String(BIMessaggioDecifrato2.toByteArray()));
		
		//Restituisco il messaggio in chiaro
		return messaggioDecifrato2;
	}
	
	/**
	 * Metodo che forza un messaggio applicando un algoritmo di logaritmo discreto, 
	 * in particolare baby step e giant step
	 * @param chiavePubblica
	 * @param messaggioCifrato
	 * @return
	 */
	public static PlainMessage forzaMessaggioConLogaritmoDiscreto(PublicKey chiavePubblica, ElGamalCypheredMessage messaggioCifrato){
		
		//Messaggio in chiaro che verr� restituito alla fine dle processo
		PlainMessage messaggioDecifrato = new PlainMessage();
		//Recupero un oggetto della classe utilit� per eseguire il calcolo della radice quadrata
		Utility utility = new Utility();
		//Chiave privata associata alla chiave pubblica con cui � stato cifrato il messaggio. E' l'informazione
		//che vogliamo andare a calcolare applicando il logaritmo discreto
		BigInteger a =BigInteger.valueOf(0);
		PrivateKey privateKey = new PrivateKey();
		
		//Recupero le informazioni sulla chiave pubblica con cui � stato cifrato il messaggio
		BigInteger p = chiavePubblica.get_p();		
		BigInteger alpha = chiavePubblica.get_alpha();		
		BigInteger beta = chiavePubblica.get_beta();
		
		//Calcolo N come la radice quadrata di p-1
		BigInteger N = utility.sqrt(p).add(BigInteger.valueOf(1));
		
		//variabile che indica se la chiave privata � stata trovata o meno
		boolean trovata =false;
		
		//Esponente di alpha
		BigInteger j;
		//Numero che moltiplicato per -N sar� l'esponente di alpha, quando alpha moltiplica beta
		BigInteger k;		
		
		//Elenco di alpha alla j
		ArrayList<BigInteger> elencoAlphaToJ = new ArrayList<BigInteger>();
		//elenco di beta per alpha elevato -Nk
		ArrayList<BigInteger> elencoBetaAlphaToMinusNK = new ArrayList<BigInteger>();
		
		//Ciclo per generare tutti gli alpha alla j
		for(j = BigInteger.valueOf(0); j.compareTo(N)<0;j = j.add(BigInteger.valueOf(1))){
			//calcolo alpha alla j e lo aggiungo all'elenco		
			BigInteger alphaToJ = alpha.modPow(j,p);
			elencoAlphaToJ.add(alphaToJ);			
		}
		
		//Ciclo per generare tutti i beta per alpha alla -Nk
		for(k = BigInteger.valueOf(0); k.compareTo(N)<0;k = k.add(BigInteger.valueOf(1))){
			//calcolo l'esponente
			BigInteger exponent = p.subtract(N.add(BigInteger.valueOf(1))).multiply(k);
			//calcolo beta per alpha alla -Nk e lo aggiungo all'elenco		
			BigInteger betaAlphaToNK = beta.multiply(alpha.modPow(exponent,p)).mod(p);
			elencoBetaAlphaToMinusNK.add(betaAlphaToNK);
		}
		
		//Ciclo per cercare la corrispondenza tra i valori di alpha alla j e quelli di beta per alpha alla -Nk
		//per ogni valore dell'elenco di alpha
		for(int indiceAlpha =0; indiceAlpha < elencoAlphaToJ.size() &&trovata ==false; indiceAlpha++){
			//cerco lo stesso valore nell'elenco di beta
			for(int indiceBeta = 0; indiceBeta <elencoBetaAlphaToMinusNK.size() &&trovata ==false; indiceBeta++){
			
				//se i valori coincidono, allora a sar� j+Nk
				if(elencoAlphaToJ.get(indiceAlpha).compareTo(elencoBetaAlphaToMinusNK.get(indiceBeta))==0){
					
					//calcolo a e restituisco la chiave privata associata
					a = BigInteger.valueOf(indiceAlpha).add(N.multiply(BigInteger.valueOf(indiceBeta)));
					privateKey.set_value(a);
					//dico che trovata � = true, cosi esco dal ciclo
					trovata = true;
				}
			}
		}
		
		//Recupero la macchina di ElGamal
		ElGamalMachine elgamalMachine = new ElGamalMachine();
		//Faccio decifrare il messaggio, con la chiave privata che ho ricostruito
		BigInteger BIMessaggioDecifrato = elgamalMachine.decifra(chiavePubblica, privateKey, messaggioCifrato);
		
		//Trasformo il bigInt in un messaggio testuale
		messaggioDecifrato.set_message(new String(BIMessaggioDecifrato.toByteArray()));
		
		//Restituisco il messaggio testuale ricostruito
		return messaggioDecifrato;
	}

}
