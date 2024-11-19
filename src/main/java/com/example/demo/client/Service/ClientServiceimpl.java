package com.example.demo.client.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.Model.Client;
import com.example.demo.client.Repository.ClientRepository;

@Service
public class ClientServiceimpl implements ClientService{
	@Autowired
	public ClientRepository repo;

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		this.repo.save(client);
		
	}

	@Override
	public Client getClientById(long id) {
		// TODO Auto-generated method stub
		Optional<Client> optional=repo.findById(id);
		Client client=null;
		if(optional.isPresent())
		{
			client=optional.get();
		}
		else
		{
			throw new RuntimeException("Client not found for id ::"+id);
		}
		return client;
	}

	@Override
	public void deleteClientById(long id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
		
	}
	
}
