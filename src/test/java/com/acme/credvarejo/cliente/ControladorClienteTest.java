package com.acme.credvarejo.cliente;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.ado.cliente.RepositorioCliente;
import com.acme.credvarejo.conta.ContaCrediario;

public class ControladorClienteTest {
	
	ControladorCliente controlador;
	Cliente cliente;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		RepositorioCliente repositorio = new RepositorioCliente(0);
		controlador = new ControladorCliente(repositorio);
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void testIncluir() {
		controlador.incluir(cliente);
		assertEquals("Cliente Validado", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testIncluirComSexoInvalido() {
		cliente.setSexo(3);
		controlador.incluir(cliente);
		assertEquals("Cliente invalido", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void testIncluirComClienteNulo() {
		cliente = null;
		controlador.incluir(cliente);
		assertEquals("Invalido!", outputStreamCaptor.toString().trim());
	}
	
	
	@Test
	public void testAlterar() {
		controlador.incluir(cliente);
		controlador.alterar(1, "Franco");
		assertEquals("Cliente Validado", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testExcluir() {
		controlador.incluir(cliente);
		controlador.excluir(1);
		outputStreamCaptor.reset();
		controlador.buscar(1);
		assertEquals("Invalido!", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testBuscar() {
		controlador.incluir(cliente);
		outputStreamCaptor.reset();
		controlador.buscar(1);
		assertEquals("Cliente: samuel", outputStreamCaptor.toString().trim());
	}

	@Test
	public void testBuscarTodos() {
		controlador.buscarTodos();
		assertEquals("Vazio!", outputStreamCaptor.toString().trim());
	}

}
