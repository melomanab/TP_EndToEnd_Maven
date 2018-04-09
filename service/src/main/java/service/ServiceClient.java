package service;

import java.util.ArrayList;

import dao.DaoClient;
import domaine.Client;


public class ServiceClient {
	
	private DaoClient daoC = new DaoClient();
	
	public boolean createNewClient(Client c) {
		boolean insert = false;
		insert = this.daoC.createClient(c);
		return insert;
	}
	
	public Client getOneClient(Client c) {
		c = this.daoC.getClient(c.getIdClient());
		return c;
	}


	public boolean updateOneClient(Client c) {
		boolean updated=false;
		updated = this.daoC.updateClient(c);
		return updated;
	}
	

	public boolean deleteOneClient(Client c) {
		boolean deleted = false;

		deleted = this.daoC.deleteClient(c);
		
		return deleted;
	}
	
	public ArrayList<Client> getListeClients(){
		ArrayList<Client> listC = new ArrayList<Client>();
		listC = this.daoC.getAllClients();
		return listC;
	}
	/*	
	*/

}
