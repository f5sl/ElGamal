/**
 * 
 */
package com.Model;

import java.math.BigInteger;

/**
 * Classe che implementa l'algoritmo di crittografia Elgamal
 *  
 * @author Alessandro
 *
 */
public class ElGamal {
	
	private BigInteger _p;
	
	private BigInteger _alpha;
	
	private BigInteger _beta;
	
	private BigInteger _message;
	
	private BigInteger _a;
	
	private BigInteger _r;
	
	private BigInteger _t;
	
	private int _k;
	
	
	/**
	 * Costruttore
	 * @param p
	 * @param alpha
	 * @param beta
	 * @param message
	 */
	public ElGamal(BigInteger p,BigInteger alpha, BigInteger a, int k){
		set_p(p);
		set_alpha(alpha);
		
		set_a(a);
		set_k(k);
	}
	/**
	 * Calcola Beta
	 */
	private void calcolaBeta(){		
		_beta = _alpha.modPow(_a, _p);
	}
	
	private void calcolaR(){
		_r = _alpha.modPow(BigInteger.valueOf(_k), _p);
	}
	
	private void calcolaT(BigInteger messaggio){
		_t = (_beta.modPow(BigInteger.valueOf(_k), _p)).abs().multiply(messaggio).mod(_p);
	}
	
	
	public ElGamalCypheredMessage cifra(BigInteger messaggio){
		calcolaBeta();
		calcolaR();
		calcolaT(messaggio);
		ElGamalCypheredMessage cifrato = new ElGamalCypheredMessage(_t, _r);
		
		return cifrato;
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

	/**
	 * @return the _message
	 */
	public BigInteger get_message() {
		return _message;
	}

	/**
	 * @param _message the _message to set
	 */
	public void set_message(BigInteger _message) {
		this._message = _message;
	}

	/**
	 * @return the _a
	 */
	public BigInteger get_a() {
		return _a;
	}

	/**
	 * @param _a the _a to set
	 */
	public void set_a(BigInteger _a) {
		this._a = _a;
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
	 * @return the _k
	 */
	public int get_k() {
		return _k;
	}
	/**
	 * @param _k the _k to set
	 */
	public void set_k(int _k) {
		this._k = _k;
	}
}
