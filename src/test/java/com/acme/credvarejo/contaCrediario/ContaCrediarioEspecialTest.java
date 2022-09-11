package com.acme.credvarejo.contaCrediario;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.credvarejo.cliente.Cliente;
import com.acme.credvarejo.cliente.Cpf;
import com.acme.credvarejo.conta.IdentificadorContaCrediario;

public class ContaCrediarioEspecialTest {
	
	ContaCrediarioEspecial ccEspecial;

	@Before
	public void setUp() throws Exception {
		IdentificadorContaCrediario icc = new IdentificadorContaCrediario(123L);
		Cpf cpf = new Cpf(1);
		Date clienteDesde = new Date(2021, 4, 9);
		Cliente cliente = new Cliente(cpf, "samuel", 22, clienteDesde, 800, 0);
		
		
		ccEspecial = new ContaCrediarioEspecial(icc, cliente, 250, 1000, 5, true, 10, 8);
	}
	
	@Test
	public void testEfetuarPagamento() {
		ccEspecial.efetuarPagamento(250);
		assertEquals(10, ccEspecial.getPontosAcumulados());
	}

	@Test
	public void testEfetuarPagamentoComDesconto() {
		ccEspecial.efetuarPagamento(250, 5);
		assertEquals(10, ccEspecial.getPontosAcumulados());
	}
	
	@Test
	public void testEfetuarPagamentoComDescontoIgualAZero() {
		ccEspecial.setPercentualDeDesconto(0);
		ccEspecial.efetuarPagamento(250, 0);
		assertEquals(10, ccEspecial.getPontosAcumulados());
	}
	
	@Test
	public void testEfetuarPagamentoComDescontoMaior() {
		ccEspecial.efetuarPagamento(250, 50);
		assertEquals(10, ccEspecial.getPontosAcumulados());
	}

	@Test
	public void testGetPercentualDeDesconto() {
		assertEquals(10, ccEspecial.getPercentualDeDesconto(), 0);
	}

	@Test
	public void testSetPercentualDeDesconto() {
		ccEspecial.setPercentualDeDesconto(0.8);
		assertEquals(0.8, ccEspecial.getPercentualDeDesconto(), 0);
	}

	@Test
	public void testGetPontosAcumulados() {
		assertEquals(8, ccEspecial.getPontosAcumulados());
	}

	@Test
	public void testSetPontosAcumulados() {
		ccEspecial.setPontosAcumulados(7);
		assertEquals(7, ccEspecial.getPontosAcumulados());
	}

}
