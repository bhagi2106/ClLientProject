package com.example.demo.client.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.client.Model.Client;




@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
	
	

}
