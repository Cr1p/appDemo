package com.app.demo.daoTest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.demo.config.ApplicationContextDAOConfig;
import com.app.demo.dao.ClienteDAO;
import com.app.demo.dto.request.ClienteRequest;
import com.app.demo.dto.response.ClienteResponse;
import com.app.demo.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextDAOConfig.class })
public class ClienteDAOTest {
	@Autowired
	private ClienteService clienteService;

	@Test
	public void testObtenerPaciente() {
		ClienteResponse response = new ClienteResponse();
		ClienteRequest request = new ClienteRequest();

		request.setIdCliente(1);
		try {
			response = clienteService.obtenerCliente(request);
			System.out.println(response.getCliente().toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	@Ignore
	public void testInsertarPaciente() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testActualizarPaciente() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testEliminarPaciente() {
		fail("Not yet implemented");
	}

}
