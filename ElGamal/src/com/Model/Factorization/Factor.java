/**
 * 
 */
package com.Model.Factorization;

import java.math.BigInteger;

/**
 * Classe che modella un fattore come base ed esponente
 * @author Alessandro
 *
 */
public class Factor {
	
	private BigInteger _base;
	private int _power;
	
	
	
	public Factor() {
	}
	
	/**
	 * @param _base
	 * @param _power
	 */
	public Factor(BigInteger _base, int _power) {
		super();
		this._base = _base;
		this._power = _power;
	}
	/**
	 * @return the _base
	 */
	public BigInteger get_base() {
		return _base;
	}
	/**
	 * @param _base the _base to set
	 */
	public void set_base(BigInteger _base) {
		this._base = _base;
	}
	/**
	 * @return the _power
	 */
	public int get_power() {
		return _power;
	}
	/**
	 * @param _power the _power to set
	 */
	public void set_power(int _power) {
		this._power = _power;
	}

}
