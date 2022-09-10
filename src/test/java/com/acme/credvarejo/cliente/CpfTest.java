package com.acme.credvarejo.cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CpfTest {
	
	Cpf cpf;

	@Before
	public void setUp() throws Exception {
		cpf = new Cpf(1926369547);
	}

	/*
	@Test
	public void testCalculaDigitoMod11() {
		
	}

	 */

	@Test
	public void testIsCPF() {
		assertTrue(cpf.isCPF("81327778084"));
	}
	
	@Test
	public void testImprimeCPF() {
		assertEquals(cpf.imprimeCPF("19263695474"), "192.636.954-74");
	}

	@Test
	public void testGetNumero() {
		assertEquals(cpf.getNumero(), 1926369547);
	}

	@Test
	public void testSetNumero() {
		cpf.setNumero(1234567894);
		assertEquals(cpf.getNumero(), 1234567894);
	}

}
