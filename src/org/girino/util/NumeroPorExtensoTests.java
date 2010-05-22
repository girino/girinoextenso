package org.girino.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class NumeroPorExtensoTests {

	@Test
	public void testGetInstance() {
		NumeroPorExtenso instance = NumeroPorExtenso.getDefaultInstance();
		assertNotNull(instance);
	}

	@Test
	public void testConverteInteiro() {
		NumeroPorExtenso n = NumeroPorExtenso.getDefaultInstance();
		assertEquals("um mil", n.converteInteiro(new BigDecimal(1000)));
		assertEquals("um mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um milhão", n.converteInteiro(new BigDecimal(1000000)));
		assertEquals("dois milhões", n.converteInteiro(new BigDecimal(2000000)));
		assertEquals("um", n.converteInteiro(new BigDecimal(1)));
		assertEquals("um", n.converteInteiro(new BigDecimal(1.01)));
		
		// testa outras possibilidades
		// mil sem um
		n = new NumeroPorExtenso(true, true, true);
		assertEquals("mil", n.converteInteiro(new BigDecimal(1000)));
		assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil, trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um milhão", n.converteInteiro(new BigDecimal(1000000)));

		// sem virgulas
		n = new NumeroPorExtenso(true, false, true);
		assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um bilhão trinta e quatro milhões doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
		// sem virgulas, outra opção
		n = new NumeroPorExtenso(true, false, false);
		assertEquals("mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um bilhão trinta e quatro milhões doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
		// sem virgulas, mil com um
		n = new NumeroPorExtenso(false, false, false);
		assertEquals("um mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um bilhão trinta e quatro milhões doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
		// com virgulas, mil sem virgula
		n = new NumeroPorExtenso(false, true, false);
		assertEquals("um mil e um", n.converteInteiro(new BigDecimal(1001)));
		assertEquals("doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(12345.67)));
		assertEquals("um bilhão, trinta e quatro milhões, doze mil trezentos e quarenta e cinco", n.converteInteiro(new BigDecimal(1034012345.67)));
	}

	@Test
	public void testConverteMoedaBigDecimalStringArrayStringArrayInt() {
		NumeroPorExtenso n = NumeroPorExtenso.getDefaultInstance();
		assertEquals("um mil litros e duzentos e cinquenta mililitros", n.converteMoeda(new BigDecimal(1000.250), new String[] {"litro","litros"}, new String[] {"mililitro", "mililitros"}, 1000));
	}

	@Test
	public void testConverteMoedaBigDecimal() {
		NumeroPorExtenso n = NumeroPorExtenso.getDefaultInstance();
		assertEquals("um mil reais", n.converteMoeda(new BigDecimal(1000)));
		assertEquals("um mil e um reais", n.converteMoeda(new BigDecimal(1001)));
		assertEquals("doze mil, trezentos e quarenta e cinco reais e sessenta e sete centavos", n.converteMoeda(new BigDecimal(12345.67)));
		assertEquals("um milhão de reais", n.converteMoeda(new BigDecimal(1000000)));
		assertEquals("dois milhões de reais", n.converteMoeda(new BigDecimal(2000000)));
		assertEquals("um real", n.converteMoeda(new BigDecimal(1)));
		assertEquals("um real e um centavo", n.converteMoeda(new BigDecimal(1.01)));
	}

}
