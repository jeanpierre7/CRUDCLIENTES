package com.duoc.restspringjpa.controlador;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.duoc.restspringjpa.modelo.Cliente;

import com.duoc.restspringjpa.modelo.repository.ClienteRepository;



@RestController
public class RESTControlador {
	@Autowired
	ClienteRepository daoCliente;
	
		@GetMapping("/")
		public List<Cliente> getClientes() {

		  return daoCliente.findAll();
		}
		
		@GetMapping("/cliente/{rut}")
		public Cliente getCliente(@PathVariable String rut) {

		  return daoCliente.findById(rut).get();
		}
		
		@PostMapping("/cliente")
		public boolean addCliente(@RequestBody Cliente nuevo) {
			Cliente cliente = nuevo;
		if(!daoCliente.existsById(cliente.getRut())) {
					daoCliente.save(cliente);
					return true;
				}
			return false;
		}
		
		@PutMapping("/cliente")
		public boolean modifyCliente(@RequestBody Cliente body) {
		if(daoCliente.existsById(body.getRut())) {
			daoCliente.save(body);
			return true; 
		}
		return false;
	}
		
		@DeleteMapping("/cliente/{rut}")
		public boolean deleteCliente(@PathVariable String rut) {
			if (rut.equals("99999999-9")) {
				daoCliente.deleteAll();
				return true;
			}else if(!rut.equals("99999999-9")){
				if(daoCliente.existsById(rut)) {
				this.daoCliente.deleteById(rut);
				return true;
			}else {
				
				return false;
			}
			
	
		}
			return false;
		
	}
		
}
