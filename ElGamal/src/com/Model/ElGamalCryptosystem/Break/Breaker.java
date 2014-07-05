/**
 * 
 */
package com.Model.ElGamalCryptosystem.Break;

import java.math.BigInteger;
import java.util.ArrayList;









import com.Model.Client.ElGamalClient;
import com.Model.ElGamalCryptosystem.ElGamalMachine;
import com.Model.ElGamalCryptosystem.Key.PrivateKey;
import com.Model.ElGamalCryptosystem.Key.PublicKey;
import com.Model.ElGamalCryptosystem.Message.ElGamalCypheredMessage;
import com.Model.ElGamalCryptosystem.Message.ElGamalPlainMessage;
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
	 * @param chiavePubblica E' la chiave pubblica del destinatario del messaggio
	 * @param t1 E' il t del messaggio cifrato di cui si conosce anche il messaggio in chiaro
	 * @param t2 E' il t del messaggio cifrato che si vuole "forzare"
	 * @param messaggioDecifrato1 E' il messaggio in chiaro che si conosce, associato a t1
	 * 
	 * @return Messaggio in chiaro, ottenuto forzando quello cifrato
	 */
	public static ElGamalPlainMessage forzaMessaggioDaMessaggioNoto(PublicKey chiavePubblica, BigInteger t1, 
													BigInteger t2,	ElGamalPlainMessage messaggioDecifrato1 ){
		
		//calcolo t inverso
		BigInteger t1_inverso = t1.modPow((BigInteger.valueOf(-1)), chiavePubblica.get_p());
	
		//Recupero il BigInteger del messaggio in chiaro
		BigInteger BIMessaggioDecifrato1 = Convertitore.convertiStringaInBigInteger(messaggioDecifrato1.get_message());
		
		//Decifro il messaggio 2
		BigInteger BIMessaggioDecifrato2 = t2.multiply(BIMessaggioDecifrato1).multiply(t1_inverso).mod(chiavePubblica.get_p());
		
		//Costruisco un messaggio in chiaro, a partire dal BigInteger corrispondente
		ElGamalPlainMessage  messaggioDecifrato2 =  new ElGamalPlainMessage(new String(BIMessaggioDecifrato2.toByteArray()));
		
		//Restituisco il messaggio in chiaro
		return messaggioDecifrato2;
	}
	
	/**
	 * Metodo che forza un messaggio applicando un algoritmo di logaritmo discreto, in particolare 
	 * Baby Step Giant Step
	 * 
	 * @param messaggioCifrato	E' il messaggio che si vuole forzare
	 * 
	 * @return Messaggio in chiaro, ottenuto forzando quello cifrato
	 */
	public static ElGamalPlainMessage forzaMessaggioConLogaritmoDiscreto(ElGamalCypheredMessage messaggioCifrato){
		
		//Messaggio in chiaro che verrà restituito alla fine del processo
		ElGamalPlainMessage messaggioDecifrato = new ElGamalPlainMessage();
		//Recupero un oggetto della classe utilità per eseguire il calcolo della radice quadrata
		Utility utility = new Utility();
		//Chiave pubblica associata al destinatario del messaggio
		PublicKey publicKey = messaggioCifrato.get_destinatario().get_publicKey();
		//Chiave privata associata alla chiave pubblica con cui è stato cifrato il messaggio. E' l'informazione
		//che vogliamo andare a calcolare applicando il logaritmo discreto
		BigInteger a =BigInteger.valueOf(0);
		PrivateKey privateKey = new PrivateKey();
		
		//Recupero le informazioni sulla chiave pubblica con cui è stato cifrato il messaggio
		BigInteger p = publicKey.get_p();		
		BigInteger alpha =  publicKey.get_alpha();		
		BigInteger beta =  publicKey.get_beta();
		
		//Calcolo N come la radice quadrata di p-1
		BigInteger N = utility.sqrt(p).add(BigInteger.valueOf(1));
		
		//variabile che indica se la chiave privata è stata trovata o meno
		boolean trovata = false;
		
		//Esponente di alpha
		BigInteger j;
		//Numero che moltiplicato per -N sarà l'esponente di alpha, quando alpha moltiplica beta
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
			
				//se i valori coincidono, allora a sarà j+Nk
				if(elencoAlphaToJ.get(indiceAlpha).compareTo(elencoBetaAlphaToMinusNK.get(indiceBeta))==0){
					
					//calcolo a e restituisco la chiave privata associata
					a = BigInteger.valueOf(indiceAlpha).add(N.multiply(BigInteger.valueOf(indiceBeta)));
					privateKey.set_value(a);
					//dico che trovata è = true, cosi esco dal ciclo
					trovata = true;
				}
			}
		}
		
		//Recupero la macchina di ElGamal
		ElGamalMachine elgamalMachine = new ElGamalMachine();
		
		//Costruisco un destinatario fittizio con i dati che ho recuperato
		ElGamalClient destinatarioFittizio = new ElGamalClient("Fittizio");
		destinatarioFittizio.set_privateKey(privateKey);
		destinatarioFittizio.set_publicKey(publicKey);
		
		//Setto al messaggio cifrato il destinatario fittizio
		messaggioCifrato.set_destinatario(destinatarioFittizio);
		messaggioCifrato.set_mittente(messaggioCifrato.get_mittente());
		
		//Faccio decifrare il messaggio, con la chiave privata che ho ricostruito
		messaggioDecifrato = elgamalMachine.decifra(messaggioCifrato);
			
		//Restituisco il messaggio testuale ricostruito
		return messaggioDecifrato;
	}

}
