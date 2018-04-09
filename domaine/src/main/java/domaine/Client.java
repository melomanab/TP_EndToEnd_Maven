package domaine;

public class Client {

	int idClient;
	String nom;
	String prenom;
	int age;
	int idConseiller;
	
	public Client(int idClient, String nom, String prenom, int age, int idConseiller) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.idConseiller = idConseiller;
	}
	
	public Client() {
		super();
	}
	

	// Getter/Setters
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}
	
	 // toString()
	public String toString() {
		
		return "idClient: " + this.getIdClient() + 
				"\tNom:" +  this.getNom()+ "\tPrenom:" +  this.getPrenom() +
				"\tAge:" +  this.getAge() + "\tidConseiller:" + this.getIdConseiller() ;
	}
	
	
	
}
