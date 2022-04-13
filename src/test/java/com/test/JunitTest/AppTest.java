package com.test.JunitTest;

import DB.conexion;
import DAO.LoginDAO;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public AppTest() {
		
	}
	
	@BeforeClass
	public static void setUpClass() {}
	
	@AfterClass
	public static void tearDownClass() {}
	
	@Before
	public void setUp() {}
	
	@After
	public void tearDown() {}
	
	
	
	@Test
	public void testUsuarioCorrecto() throws Exception {
		System.out.println("Prueba de Usuario Correcto");
		try {
			
			LoginDAO instance = new LoginDAO();
			String rut = instance.validar("leo", "123123");
			assertEquals(rut, "15737935-6");
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUsuarioIncorrecto() throws Exception {
		System.out.println("Prueba de Usuario Incorrecto");
		try {
			LoginDAO instance = new LoginDAO();
			String rut = instance.validar("leo", "00000");
			assertEquals(rut, "15737935-6");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUsuarioVacio() throws Exception {
		System.out.println("Prueba de Usuario Vacío");
		try {
			LoginDAO instance = new LoginDAO();
			String rut = instance.validar("", "");
			assertEquals(rut, "15737935-6");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConexion() {
		System.out.println("Prueba de Conexión");
		try {
			conexion instance = new DB.conexion();
			String resultado = "";
			if(instance.conectar() != null) {
				resultado = "Conexion Establecida..";
			}else {
				resultado = "Conexion fallo";
			}
			assertEquals(resultado, "Conexion Establecida..");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	

	
}
