package com.duoc.restspringjpa.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.duoc.restspringjpa.modelo.Cliente;
import com.duoc.restspringjpa.modelo.repository.ClienteRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class AddClienteTest {

	@Autowired
	TestEntityManager manager;
	@Autowired
	ClienteRepository dao;
	
	@Before
	public void setUp() throws Exception {
		
		Cliente c1 = new Cliente("18862877-k", "jean pierre", "leyton reyes", "jean.leyton@mayor.cl", 987467823);
		this.manager.persist(c1);
		Cliente c2 = new Cliente("8965213-4", "juan carlos", "fuenzalida reyes", "juan@mayor.cl", 94561234);
		this.manager.persist(c2);
		Cliente c3 = new Cliente("5874693-9", "Michael", "Perez Jackson", "michael@mayor.cl", 97894562);
		this.manager.persist(c3);
		Cliente c4 = new Cliente("16897423-7", "michaela", "gonzales gonzalesa", "michaela@mayor.cl", 987467823);
		this.manager.persist(c4);
	}

	@Test
	public void cuandoAddClienteEntonces5() {
	 this.dao.save(new Cliente("12356123-5", "nuevo", "nuevo", "nuevo@mayor.cl", 256524545));
	 int largo = this.dao.findAll().size();
	 assertTrue("SON " + largo + " PERO DEBERÍAN SER 5", largo == 5);
	}
	
	


}
