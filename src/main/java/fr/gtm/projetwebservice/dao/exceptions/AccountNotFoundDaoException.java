package fr.gtm.projetwebservice.dao.exceptions;

public class AccountNotFoundDaoException extends Exception {

	public AccountNotFoundDaoException() {
		super("Erreur : Le compte n est pas dans la base de donnees");
		
	}

	public AccountNotFoundDaoException(String message) {
		super(message);
	}
	
}
