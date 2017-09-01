package fr.gtm.projetwebservice.domaine;

public class ResultatVirement {
	
	private float balanceCredit;
	private float balanceDebit;
	private float newbalanceCredit;
	private float newbalanceDebit;
	
	public ResultatVirement(float balanceCredit, float balanceDebit, float newbalanceCredit, float newbalanceDebit) {
		super();
		this.balanceCredit = balanceCredit;
		this.balanceDebit = balanceDebit;
		this.newbalanceCredit = newbalanceCredit;
		this.newbalanceDebit = newbalanceDebit;
	}

	public float getBalanceCredit() {
		return balanceCredit;
	}

	public void setBalanceCredit(float balanceCredit) {
		this.balanceCredit = balanceCredit;
	}

	public float getBalanceDebit() {
		return balanceDebit;
	}

	public void setBalanceDebit(float balanceDebit) {
		this.balanceDebit = balanceDebit;
	}

	public float getNewbalanceCredit() {
		return newbalanceCredit;
	}

	public void setNewbalanceCredit(float newbalanceCredit) {
		this.newbalanceCredit = newbalanceCredit;
	}

	public float getNewbalanceDebit() {
		return newbalanceDebit;
	}

	public void setNewbalanceDebit(float newbalanceDebit) {
		this.newbalanceDebit = newbalanceDebit;
	}

	public ResultatVirement() {
		super();
	}
	
	
	

}
