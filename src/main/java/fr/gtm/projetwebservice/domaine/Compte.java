package fr.gtm.projetwebservice.domaine;

public class Compte {

	private int idNumber;
	private int idClient;
	private float balance;
	double amount;
	
	public Compte(int idNumber, int idClient, float balance) {
		super();
		this.idNumber = idNumber;
		this.idClient = idClient;
		this.balance = balance;
		
	}
	
	
	

	public Compte(int idNumber, float balance) {
		super();
		this.idNumber = idNumber;
		this.balance = balance;
	}

	



	public Compte(int idNumber, double amount) {
		super();
		this.idNumber = idNumber;
		this.amount = amount;
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
	
	

	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "Compte [idNumber=" + idNumber + ", idClient=" + idClient + ", balance=" + balance + "]";
	}
	
	
	
	
	
}
