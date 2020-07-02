package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.PayerTaxPerson;
import entities.PhysicalPerson;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<PayerTaxPerson> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Tax payer #" + (i+1) + " data: ");
			System.out.print("Individual or company(i/c)?");
			char choose = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			
			if(choose == 'i') {
				System.out.print("Health expenditures: ");
				Double health = sc.nextDouble();
				list.add(new PhysicalPerson(name, annualIncome, health));
			} else {
				System.out.print("Number of employees: ");
				Double numberOfEmployee = sc.nextDouble();
				list.add(new LegalPerson(name, annualIncome, numberOfEmployee));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		Double sum = 0.0;
		for(PayerTaxPerson x: list) {
			System.out.println(x.getName() + ": $" + String.format("%.2f", x.TaxPaid()));			
			sum += x.TaxPaid();
		}
		System.out.print("TOTAL TAXES: $" + String.format("%.2f", sum));
		
		sc.close();
	}
}
