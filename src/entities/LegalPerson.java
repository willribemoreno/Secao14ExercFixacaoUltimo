package entities;

public class LegalPerson extends PayerTaxPerson {
	
	private Double numberOfEmployee;
	
	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, Double annualIncome, Double numberOfEmployee) {
		super(name, annualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}

	public Double getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Double numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	
	@Override
	public Double TaxPaid() {
		if(numberOfEmployee > 10) {
			return super.getAnnualIncome() * 0.14;
		} else {
			return super.getAnnualIncome() * 0.16;
		}
	}
}
