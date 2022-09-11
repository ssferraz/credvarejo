package com.acme.credvarejo.ado.cliente;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;

public class RepositorioClienteTest {
	
	RepositorioCliente repositorio;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		repositorio = new RepositorioCliente(0);
		System.setOut(new PrintStream(outputStreamCaptor));	
	}

	@Test
	public void testIncluir() {
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);

		assertEquals(repositorio.posicao, 1);
	}

	@Test
	public void testAlterar() { 
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);

		
		repositorio.alterar(1, "Edgar");
		repositorio.buscarPorChave(1);
		assertEquals("Cliente: Edgar", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testExcluir() {
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);

		
		repositorio.excluir(1);
		assertEquals(repositorio.posicao, 0);
	}

	@Test
	public void testBuscarPorChave() {
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);

		
		repositorio.buscarPorChave(1);
		assertEquals("Cliente: samuel", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testBuscarTodos() {
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);

		repositorio.buscarTodos();
		assertEquals("Cliente: samuel", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testAlterarVazio() {
		repositorio.alterar(1, "Marcos");
		assertEquals("Vazio!", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testAlterarInvalido() {
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);
		
		repositorio.alterar(2, "Marcos");
		assertEquals("Invalido!", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testExcluirVazio() {
		repositorio.excluir(1);
		assertEquals("Vazio!", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testBuscarPorChaveInvalido() {
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		repositorio.incluir(cliente);
		
		repositorio.buscarPorChave(2);
		assertEquals("Invalido!", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testBuscarTodosVazio() {		
		repositorio.buscarTodos();
		assertEquals("Vazio!", outputStreamCaptor.toString().trim());
	}
}
