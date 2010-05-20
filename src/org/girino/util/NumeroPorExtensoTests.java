package org.girino.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class NumeroPorExtensoTests {

	@Test
	public void testGetInstance() {
		NumeroPorExtenso instance = NumeroPorExtenso.getInstance();
		assertNotNull(instance);
	}

	@Test
	public void testConverteInteiro() {
		NumeroPorExtenso n = NumeroPorExtenso.getInstance();
		assertEquals("um mil", n.converteInteiro(new BigDecimal(1000)));
		assertEquals("um mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um milhão", n.converteInteiro(new BigDecimal(1000000)));
		assertEquals("dois milhões", n.converteInteiro(new BigDecimal(2000000)));
		assertEquals("um", n.converteInteiro(new BigDecimal(1)));
		assertEquals("um", n.converteInteiro(new BigDecimal(1.01)));
	}

	@Test
	public void testConverteMoedaBigDecimalStringArrayStringArrayInt() {
		NumeroPorExtenso n = NumeroPorExtenso.getInstance();
		assertEquals("um mil litros e duzentos e cinquenta mililitros", n.converteMoeda(new BigDecimal(1000.250), new String[] {"litro","litros"}, new String[] {"mililitro", "mililitros"}, 1000));
	}

	@Test
	public void testConverteMoedaBigDecimal() {
		NumeroPorExtenso n = NumeroPorExtenso.getInstance();
		assertEquals("um mil reais", n.converteMoeda(new BigDecimal(1000)));
		assertEquals("um mil e um reais", n.converteMoeda(new BigDecimal(1001)));
		assertEquals("doze mil, trezentos e quarenta e cinco reais e sessenta e sete centavos", n.converteMoeda(new BigDecimal(12345.67)));
		assertEquals("um milhão de reais", n.converteMoeda(new BigDecimal(1000000)));
		assertEquals("dois milhões de reais", n.converteMoeda(new BigDecimal(2000000)));
		assertEquals("um real", n.converteMoeda(new BigDecimal(1)));
		assertEquals("um real e um centavo", n.converteMoeda(new BigDecimal(1.01)));
	}

}
