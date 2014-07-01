/**
 * 
 */
package com.Model.ElGamalAlgorithm;

import java.math.BigInteger;

/**
 * Classe che modella la chiave pubblica di ElGamal
 * 
 * @author Alessandro
 *
 */
public class PublicKey {
	//Attributi
	private BigInteger _p;	
	private BigInteger _alpha;	
	private BigInteger _beta;
	
	/**
	 * Costruttore della chiave pubblica
	 * 
	 * @param p
	 * @param alpha
	 * @param a
	 */
	public PublicKey(BigInteger p, BigInteger alpha , BigInteger beta){		
		this.set_p(p);
		this.set_alpha(alpha);
		this.set_beta(beta);		
	}

	/**
	 * @return the _p
	 */
	public BigInteger get_p() {
		return _p;
	}

	/**
	 * @param _p the _p to set
	 */
	public void set_p(BigInteger _p) {
		this._p = _p;
	}

	/**
	 * @return the _alpha
	 */
	public BigInteger get_alpha() {
		return _alpha;
	}

	/**
	 * @param _alpha the _alpha to set
	 */
	public void set_alpha(BigInteger _alpha) {
		this._alpha = _alpha;
	}

	/**
	 * @return the _beta
	 */
	public BigInteger get_beta() {
		return _beta;
	}

	/**
	 * @param _beta the _beta to set
	 */
	public void set_beta(BigInteger _beta) {
		this._beta = _beta;
	}

}
