/**
 * 
 */
package com.Model;

import java.math.BigInteger;

/**Classe che modella la chiave privata di Bob
 * 
 * @author Alessandro
 *
 */
public class PrivateKey {

	//Attributi
	private BigInteger _value;
	
	public PrivateKey(){}
	
	/**
	 * Costruttore
	 * 
	 * @param valore
	 */
	public PrivateKey(BigInteger valore) {
		this.set_value(valore);
	}	

	/**
	 * @return the _value
	 */
	public BigInteger get_value() {
		return _value;
	}

	/**
	 * @param _value the _value to set
	 */
	public void set_value(BigInteger _value) {
		this._value = _value;
	}
	
}
