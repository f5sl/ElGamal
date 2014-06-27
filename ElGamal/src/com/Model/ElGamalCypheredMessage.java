/**
 * 
 */
package com.Model;

import java.math.BigInteger;

/**
 * Classe che modella un messaggio cifrato con ElGamal, come la coppia di due elementi, r e t
 * @author Alessandro
 *
 */
public class ElGamalCypheredMessage {
	
	//Attributi
	private BigInteger _t;
	private BigInteger _r;
	
	
	/**
	 * Costruttore con parametri
	 * @param _t
	 * @param _r
	 */
	public ElGamalCypheredMessage(BigInteger _t, BigInteger _r) {
		super();
		this._t = _t;
		this._r = _r;
	}
	/**
	 * @return the _t
	 */
	public BigInteger get_t() {
		return _t;
	}
	/**
	 * @param _t the _t to set
	 */
	public void set_t(BigInteger _t) {
		this._t = _t;
	}
	/**
	 * @return the _r
	 */
	public BigInteger get_r() {
		return _r;
	}
	/**
	 * @param _r the _r to set
	 */
	public void set_r(BigInteger _r) {
		this._r = _r;
	}

}
