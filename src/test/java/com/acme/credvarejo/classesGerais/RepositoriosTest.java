package com.acme.credvarejo.classesGerais;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.ContaCrediario;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class RepositoriosTest {
	
	Repositorios repositorios;
	Cliente cliente;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		repositorios = new Repositorios(0);
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
	}

	@Test
	public void testSetClienteRepo() {

	}

	@Test
	public void testGetClienteRepo() {
		assertEquals(null,repositorios.getClienteRepo(1));
	}

	@Test
	public void testSetContaCrediarioRepo() {
		IdentificadorContaCrediario identificadorConta = new IdentificadorContaCrediario((long) 2);
		ContaCrediario contaCrediario = new ContaCrediario(identificadorConta, cliente, 25, 100, 14, true);

		repositorios.setContaCrediarioRepo(1, contaCrediario);
		assertEquals("samuel", repositorios.getContaCrediarioRepo(1).getCliente().getNome());
		
		
	}

	@Test
	public void testGetContaCrediarioRepo() {
		
	}

	@Test
	public void testSetMovimentoCrediarioCreditoRepo() {
		
	}

	@Test
	public void testGetMovimentoCrediarioCreditoRepo() {
		
	}

	@Test
	public void testSetMovimentoCrediarioDebitoRepo() {
		
	}

	@Test
	public void testGetMovimentoCrediarioDebitoRepo() {
		
	}

}
