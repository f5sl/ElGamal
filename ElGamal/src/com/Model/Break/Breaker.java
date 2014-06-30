/**
 * 
 */
package com.Model.Break;

import java.math.BigInteger;

import com.Model.ElGamalCypheredMessage;
import com.Model.PlainMessage;
import com.Model.PublicKey;
import com.Model.Utility.Convertitore;

/**
 * Classe che ha il compito di implementare l'algoritmo di forzatura di un messaggio cifrato con 
 * ElGamal
 * @author Alessandro
 *
 */
public class Breaker {
	
	
	/**
	 * 
	 * @param messaggioCifrato1
	 * @param messaggioCifrato2
	 * @param messaggioDecifrato1
	 * @return
	 */
	public static PlainMessage forzaMessaggioDaMessaggioNoto(PublicKey chiavePubblica, ElGamalCypheredMessage messaggioCifrato1, 
													ElGamalCypheredMessage messaggioCifrato2,	PlainMessage messaggioDecifrato1 ){
		
		//istanzio un bigInteger corrispondente al testo in chiaro
		BigInteger BIMessaggioDecifrato1= Convertitore.convertiStringaInBigInteger(messaggioDecifrato1.get_message());
		
		
		BigInteger t1 = messaggioCifrato1.get_t();
		
		BigInteger t1_inverso = t1.modPow((BigInteger.valueOf(-1)), chiavePubblica.get_p());
		
		BigInteger t2 = messaggioCifrato2.get_t();
		
		BigInteger BIMessaggioDecifrato2 = t2.multiply(BIMessaggioDecifrato1).multiply(t1_inverso).mod(chiavePubblica.get_p());
		
		PlainMessage  messaggioDecifrato2 =  new PlainMessage(new String(BIMessaggioDecifrato2.toByteArray()));
		
		return messaggioDecifrato2;
	}

}
