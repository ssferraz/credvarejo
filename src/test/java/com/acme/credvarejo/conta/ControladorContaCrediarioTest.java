package com.acme.credvarejo.conta;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.conta.RepositorioContaCrediario;
import com.acme.credvarejo.ado.conta.RepositorioMovimentoCrediario;
import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;

public class ControladorContaCrediarioTest {
	
	ControladorContaCrediario ccc;
	Cliente cliente;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	IdentificadorContaCrediario id;
	ControladorMovimentoCrediario controlador;
	
	


	@Before
	public void setUp() throws Exception {
		RepositorioContaCrediario rcc = new RepositorioContaCrediario();
		RepositorioMovimentoCrediario rmc = new RepositorioMovimentoCrediario();
		controlador = new ControladorMovimentoCrediario(rmc);
		id = new IdentificadorContaCrediario(1L);
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		
		ccc = new ControladorContaCrediario(rcc);
		System.setOut(new PrintStream(outputStreamCaptor));	
	}

	@Test
	public void testInserir() {
		ccc.inserir(cliente, 100, 5);
		assertEquals("Conta invalida", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testCreditarInvalido() {
		id = null;
		ccc.creditar(id, 150, controlador);
		assertEquals("Invalido!", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testDebitarInvalido() {
		id = null;
		ccc.debitar(id, 20, controlador);
		assertEquals("Invalido!", outputStreamCaptor.toString().trim());
	}

	
	@Test
	public void testBuscar() {
		
	}

	@Test
	public void testBuscarTodos() {
		
	}

}
