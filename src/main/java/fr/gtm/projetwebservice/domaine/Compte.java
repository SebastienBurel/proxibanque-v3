package fr.gtm.projetwebservice.domaine;

public class Compte {

	private int idNumber;
	private int idClient;
	private float balance;
	
	public Compte(int idNumber, int idClient, float balance) {
		super();
		this.idNumber = idNumber;
		this.idClient = idClient;
		this.balance = balance;
	}

	public Compte() {
		super();
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
	
}
