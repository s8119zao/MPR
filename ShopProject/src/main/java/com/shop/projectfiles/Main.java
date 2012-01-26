package com.shop.projectfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shop.listeners.BuyTShirt;
import com.shop.listeners.Customer;
import com.shop.listeners.ProcessTShirtListener;

public class Main {

	public static void main(String[] args) throws PrizeException {

		Company company = new Company("Sklep 1", "Gdansk", "Grunwaldzka",
				"765", "48123123123");
		Company company2 = new Company("Sklep 2", "Gdansk", "Niepodleglowci",
				"7", "48111222333");

		Collection<TShirt> shirts = new ArrayList<TShirt>();
		
		TShirt myTShirt = new TShirt("Bluzka", "CAT-123", Size.L, 100.);
		shirts.add(myTShirt);
		shirts.add(new TShirt("Bluzka 1", "CAT-124", Size.XL, 25.));
		shirts.add(new TShirt("Bluzka 2", "CAT-125", Size.S, 10.));

		company.settShirts(shirts);

		for (TShirt ts : shirts) {
			ts.setCompany(company);
		}

		company.printTShirts();
		TShirt tShirtToDel = new TShirt("Bluzka 1", "CAT-124", Size.XL, 100.);

		try {
			tShirtToDel.setPrize(-100.0);
		} catch (PrizeException e) {
			System.out.println("Wyj¹tek przechwycony.");
		}

		company.deleteTShirt(company.findTShirt("CAT-124"));
		company.printTShirts();
		
		System.out.println(company);

		Customer customer = new Customer("Adam");

		ProcessTShirtListener buy = new BuyTShirt();

		customer.addTShirtProcessListener(buy);
		customer.settShirt(myTShirt);
		customer.processTShirt();
		
		System.out.println("Hibernate");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.persist(company);

		session.save(company2);

		session.getTransaction().commit();

		List<Company> companies = new ArrayList<Company>();

		int i = 1;
		do {
			companies.add((Company) session.get(Company.class, i));
			i++;
		} while (session.get(Company.class, i) != null);

		session.close();
		System.out.println(companies.size());
		for (Company c : companies) {
			System.out.println(c.getName() + " posida " + c.gettShirts().size()
					+ " koszulek");
		}

	}
}
