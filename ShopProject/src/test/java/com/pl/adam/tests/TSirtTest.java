package com.pl.adam.tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shop.projectfiles.Company;
import com.shop.projectfiles.PrizeException;
import com.shop.projectfiles.Size;
import com.shop.projectfiles.TShirt;

public class TSirtTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// przygotowanie danych do testu
		init();

	}

	@After
	public void tearDown() throws Exception {
		// usuniêcie wszelkich danych po wykonaniu testu
		tShirt = null;
	}

	private TShirt tShirt;

	private void init() throws PrizeException {
		tShirt = new TShirt("Bluzka 1", "CAT-124", Size.XL, 25.);

	}
	
	@Test(expected = PrizeException.class)
	public void testSetPrizeException() throws PrizeException{
		tShirt.setPrize(-100.);
	}
	
	@Test(expected = PrizeException.class)
	public void testConstruktorPrizeException() throws PrizeException{
		new TShirt("Bluzka 1", "CAT-124", Size.XL, -25.);
	}
	
	@Test
	public void testPrize() throws PrizeException{
		Assert.assertEquals(25.+"", tShirt.getPrize()+"");

		tShirt.setPrize(100.);
		Assert.assertEquals(100.+"", tShirt.getPrize()+"");
	}
	
	@Test
	public void testSize(){
		Assert.assertEquals(Size.XL, tShirt.getSize());

		tShirt.setSize(Size.S);
		Assert.assertEquals(Size.S, tShirt.getSize());
	}
	
	@Test
	public void testCatalogNumber(){
		Assert.assertEquals("CAT-124", tShirt.getCatalogNumber());

		tShirt.setCatalogNumber("CAT-111");
		Assert.assertEquals("CAT-111", tShirt.getCatalogNumber());
	}
	
	@Test
	public void testName(){
		Assert.assertEquals("Bluzka 1", tShirt.getName());

		tShirt.setName("Nowa nazwa");
		Assert.assertEquals("Nowa nazwa", tShirt.getName());
	}
	
	
}
