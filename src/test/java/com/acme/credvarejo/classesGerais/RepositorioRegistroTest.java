package com.acme.credvarejo.classesGerais;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.Before;
import org.junit.Test;

public class RepositorioRegistroTest {

	RepositorioRegistro repositorio;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		repositorio = new RepositorioRegistro(0);
		System.setOut(new PrintStream(outputStreamCaptor));	
	}

	@Test
	public void testIncluir() {
	
		
	}

	@Test
	public void testAlterar() {
		
	}

	@Test
	public void testExcluir() {
		
	}

	@Test
	public void testBuscarChave() {
		repositorio.buscarChave("1");
		assertEquals("Vazio!", outputStreamCaptor.toString().trim());	
	}

	@Test
	public void testBuscarTodos() {
		repositorio.buscarTodos();
		assertEquals("Vazio!", outputStreamCaptor.toString().trim());	
	}

}
