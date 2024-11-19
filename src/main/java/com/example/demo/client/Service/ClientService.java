package com.example.demo.client.Service;

import java.util.List;

import com.example.demo.client.Model.Client;

public interface ClientService {
	public List<Client> getAllClients();
	void saveClient(Client client);
	Client getClientById(long id);
	void deleteClientById(long id);
}
