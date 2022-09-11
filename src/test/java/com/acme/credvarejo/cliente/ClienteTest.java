package com.acme.credvarejo.cliente;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente cliente;
	//private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		Cpf cpf = new Cpf(813277780);
		Date clienteDesde = new Date(2021, 4, 9);
		cliente = new Cliente(cpf, "samuel souza ferraz", 22, clienteDesde, 800, 0);
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	
	@Test
	public void testGetChave() {
		assertEquals(cliente.getChave(), "813277780");
	}

	@Test
	public void testValidar() {
		cliente.validar();
		assertEquals("Cliente Validado", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testGravaNomeCompleto() {
		cliente.gravaNomeCompleto("Samuel Ferraz");
		assertEquals(cliente.getNome(), "Samuel Ferraz");
	}

	@Test
	public void testGetPrimeiroNome() {
		assertEquals(cliente.getPrimeiroNome(), "samuel");
	}

	@Test
	public void testGetSegundoNome() {
		assertEquals(cliente.getSegundoNome(), "souza");
	}

	@Test
	public void testGetCpf() {
		
	}

	@Test
	public void testGetNome() {
		assertEquals(cliente.getNome(), "samuel souza ferraz");
	}

	@Test
	public void testGetIdade() {
		assertEquals(cliente.getIdade(), 22);
	}

	@Test
	public void testGetClienteDesde() {
		
	}

	@Test
	public void testGetRenda() {
		assertEquals(cliente.getRenda(), 800, 0);
	}

	@Test
	public void testGetSexo() {
		assertEquals(cliente.getSexo(), 0);
	}

	@Test
	public void testSetSexo() {
		cliente.setSexo(1);
		assertEquals(cliente.getSexo(), 1);
	}

	@Test
	public void testGetMasc() {
		assertEquals(cliente.getMasc(), 0);
	}

	@Test
	public void testGetFem() {
		assertEquals(cliente.getFem(), 1);
	}

	@Test
	public void testSetCpf() {
		
	}

	@Test
	public void testSetNome() {
		
	}

	@Test
	public void testSetIdade() {
		cliente.setIdade(32);
		assertEquals(cliente.getIdade(), 32);
	}

	@Test
	public void testSetClienteDesde() {
		
	}

	@Test
	public void testSetRenda() {
		cliente.setRenda(1200);
		assertEquals(cliente.getRenda(), 1200, 0);
	}

}
