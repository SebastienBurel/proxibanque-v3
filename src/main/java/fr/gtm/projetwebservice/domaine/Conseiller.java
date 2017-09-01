package fr.gtm.projetwebservice.domaine;

public class Conseiller {
	
	private long idConseiller;
	private String surname;
	private String name;
	private String login;
	private String password;
	
	public Conseiller(long idConseiller, String surname, String name, String login, String password) {
		super();
		this.idConseiller = idConseiller;
		this.surname = surname;
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public Conseiller(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		
	}
	
	public Conseiller() {
		super();
	}

	public long getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(long idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Conseiller [surname=" + surname + ", name=" + name + ", login=" + login + ", password=" + password
				+ "]";
	}
	
	
	
	
	
	

}
