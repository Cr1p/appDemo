/**
 * 
 */
package com.app.demo.dao.impl;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.demo.dao.ClienteDAO;
import com.app.demo.dto.request.ClienteRequest;
import com.app.demo.dto.response.ClienteResponse;
import com.app.demo.entidad.Cliente;
import com.app.demo.entidad.Confirmacion;

/**
 * @author Andy
 *
 */
@Repository("clienteDAO")
@Transactional
public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	protected SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}


	@Override
	public ClienteResponse obtenerCliente(ClienteRequest request) throws Exception {
		SqlSession session = getSqlSessionFactory().openSession();
		String query = "ClienteMapper.ObtenerCliente";
		HashMap map = new HashMap();
		
//		map.put("idCliente", request.getIdCliente());
//		System.out.println("idCliente: "+request.getIdCliente());
		ClienteResponse response = new ClienteResponse();
		System.out.println("dao");
		try {
			Cliente cliente = session.selectOne(query,map);
			response.setCliente(cliente);
			session.close();
		} catch (Exception e) {
			System.out.println("error DAO: "+e);
			
		}
		System.out.println("paso dao");
		return response;
	}


	@Override
	public ClienteResponse insertarCliente(ClienteRequest request) throws Exception {

		SqlSession session = getSqlSessionFactory().openSession();
		String query = "ClienteMapper.insertarCliente";
		HashMap map = new HashMap();
		
		map.put("clienteJSON", request.getClienteJSON());
		
		ClienteResponse response = new ClienteResponse();
		System.out.println("dao");
		try {
			
			Confirmacion confirmacion = session.selectOne(query,map);
			response.setConfirmacion(confirmacion);
		} catch (Exception e) {
			System.out.println("error DAO: "+e);
		}
		System.out.println("paso dao");
		return response;
	}


	@Override
	public ClienteResponse actualizarCliente(ClienteRequest request) throws Exception {
		SqlSession session = getSqlSessionFactory().openSession();
		String query = "ClienteMapper.actualizarCliente";
		HashMap map = new HashMap();
		
		map.put("clienteJSON", request.getClienteJSON());
		
		ClienteResponse response = new ClienteResponse();
		System.out.println("dao");
		try {
			
			Confirmacion confirmacion = session.selectOne(query,map);
			response.setConfirmacion(confirmacion);
		} catch (Exception e) {
			System.out.println("error DAO: "+e);
		}
		System.out.println("paso dao");
		return response;
	}


	@Override
	public ClienteResponse eliminarCliente(ClienteRequest request) throws Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSessionFactory().openSession();
		String query = "ClienteMapper.eliminarCliente";
		HashMap map = new HashMap();
		
		map.put("idCliente", request.getClienteJSON());
		
		ClienteResponse response = new ClienteResponse();
		System.out.println("dao");
		try {
			
			Confirmacion confirmacion = session.selectOne(query,map);
			response.setConfirmacion(confirmacion);
		} catch (Exception e) {
			System.out.println("error DAO: "+e);
		}
		System.out.println("paso dao");
		return response;
	}


	@Override
	public ClienteResponse calcularPromDes(ClienteRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ClienteResponse calcularPosibleMuerte(ClienteRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
