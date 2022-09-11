package com.acme.credvarejo.conta;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;

public class ContaCrediarioTest {
	
	ContaCrediario contaCrediario;

	@Before
	public void setUp() throws Exception {
		IdentificadorContaCrediario identificadorConta = new IdentificadorContaCrediario((long) 2);
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		contaCrediario = new ContaCrediario(identificadorConta, cliente, 25, 100, 14, true);
	}

	@Test
	public void testGetChave() {
		assertEquals(contaCrediario.getChave(), "2");
	}

	
	@Test
	public void testValidar() {
		
	}
	

	@Test
	public void testContaCrediario() {
		
	}

	@Test
	public void testEfetuarPagamento() {
		
	}

	@Test
	public void testEfetuarCompra() {
		
	}

	@Test
	public void testDesativar() {
		
	}

	@Test
	public void testReativar() {
		
	}

	@Test
	public void testGetIdentificadorConta() {
		
	}

	@Test
	public void testSetIdentificadorConta() {
		
	}

	/*
	@Test
	public void testGetCliente() {
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		assertTrue(contaCrediario.getCliente().equals(cliente));
	}

	@Test
	public void testSetCliente() {
		
	}
    */
	@Test
	public void testGetSaldoDevido() {
		assertEquals(contaCrediario.getSaldoDevido(), 25, 0);
	}

	@Test
	public void testSetSaldoDevido() {
		contaCrediario.setSaldoDevido(40);
		assertEquals(contaCrediario.getSaldoDevido(), 40, 0);
	}

	@Test
	public void testGetLimiteDeCredito() {
		assertEquals(contaCrediario.getLimiteDeCredito(), 100.0, 0);
	}

	@Test
	public void testSetLimiteDeCredito() {
		contaCrediario.setLimiteDeCredito(125);
		assertEquals(contaCrediario.getLimiteDeCredito(), 125.0, 0);
	}

	@Test
	public void testGetVencimento() {
		assertEquals(contaCrediario.getVencimento(), 14);
	}

	@Test
	public void testSetVencimento() {
		contaCrediario.setVencimento(15);
		assertEquals(contaCrediario.getVencimento(), 15);
	}

	@Test
	public void testIsAtiva() {
		assertTrue(contaCrediario.isAtiva());
	}

	@Test
	public void testSetAtiva() {
		contaCrediario.setAtiva(false);
		assertTrue(!contaCrediario.isAtiva());
	}

}
