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

public class CompanyTest {

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
		company = null;
	}

	private Company company;

	// metoda przygotowuje przyladowy sklep z list¹ koszulek
	private void init() throws PrizeException {
		company = new Company("Sklep 1", "Gdansk", "Grunwaldzka", "765",
				"48123123123");
		Collection<TShirt> shirts = new ArrayList<TShirt>();
		shirts.add(new TShirt("Bluzka", "CAT-123", Size.L, 100.));
		shirts.add(new TShirt("Bluzka 1", "CAT-124", Size.XL, 25.));
		shirts.add(new TShirt("Bluzka 2", "CAT-125", Size.S, 10.));

		company.settShirts(shirts);

	}

	// metoda porównuje dwie koszulki do siebie
	private void eqTShirt(TShirt expectedTShirt, TShirt actualTShirt) {
		Assert.assertEquals(expectedTShirt.getName(), actualTShirt.getName());
		Assert.assertEquals(expectedTShirt.getPrize() + "",
				actualTShirt.getPrize() + "");
		Assert.assertEquals(expectedTShirt.getCatalogNumber(),
				actualTShirt.getCatalogNumber());
		Assert.assertEquals(expectedTShirt.getSize(), actualTShirt.getSize());

	}

	@Test
	public void testTShirt() throws PrizeException {
		Assert.assertEquals(3, company.gettShirts().size());
		eqTShirt(new TShirt("Bluzka", "CAT-123", Size.L, 100.),
				((ArrayList<TShirt>) company.gettShirts()).get(0));
		eqTShirt(new TShirt("Bluzka 1", "CAT-124", Size.XL, 25.),
				((ArrayList<TShirt>) company.gettShirts()).get(1));
		eqTShirt(new TShirt("Bluzka 2", "CAT-125", Size.S, 10.),
				((ArrayList<TShirt>) company.gettShirts()).get(2));

	}

	@Test
	public void testPhoneNumber() {
		Assert.assertEquals("48123123123", company.getPhoneNumber());

		company.setPhoneNumber("481231231111");
		Assert.assertEquals("481231231111", company.getPhoneNumber());

	}

	@Test
	public void testLocalNo() {
		Assert.assertEquals("765", company.getLocalNo());

		company.setLocalNo("1");
		Assert.assertEquals("1", company.getLocalNo());

	}

	@Test
	public void testStreet() {
		Assert.assertEquals("Grunwaldzka", company.getStreet());

		company.setStreet("Ch³opska");
		Assert.assertEquals("Ch³opska", company.getStreet());

	}

	@Test
	public void testCity() {
		Assert.assertEquals("Gdansk", company.getCity());

		company.setCity("Warszawa");
		Assert.assertEquals("Warszawa", company.getCity());

	}

	@Test
	public void testName() {
		Assert.assertEquals("Sklep 1", company.getName());

		company.setName("Nowa nazwa");
		Assert.assertEquals("Nowa nazwa", company.getName());

	}

	@Test
	public void testFindTShirt() {

		TShirt find = company.findTShirt("CAT-123");
		eqTShirt(((ArrayList<TShirt>) company.gettShirts()).get(0), find);
	}
	
	@Test
	public void testDeleteTShirt() throws PrizeException {
		Assert.assertEquals(3, company.gettShirts().size());
		eqTShirt(new TShirt("Bluzka", "CAT-123", Size.L, 100.),
				((ArrayList<TShirt>) company.gettShirts()).get(0));
		eqTShirt(new TShirt("Bluzka 1", "CAT-124", Size.XL, 25.),
				((ArrayList<TShirt>) company.gettShirts()).get(1));
		eqTShirt(new TShirt("Bluzka 2", "CAT-125", Size.S, 10.),
				((ArrayList<TShirt>) company.gettShirts()).get(2));
		
		company.deleteTShirt(company.findTShirt("CAT-123"));
		
		Assert.assertEquals(2, company.gettShirts().size());
		eqTShirt(new TShirt("Bluzka 1", "CAT-124", Size.XL, 25.),
				((ArrayList<TShirt>) company.gettShirts()).get(0));
		eqTShirt(new TShirt("Bluzka 2", "CAT-125", Size.S, 10.),
				((ArrayList<TShirt>) company.gettShirts()).get(1));
		
	}
}
