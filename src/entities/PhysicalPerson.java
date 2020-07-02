package entities;

public class PhysicalPerson extends PayerTaxPerson {

	private Double healthExpeditures;
	
	public PhysicalPerson() {
		super();
	}

	public PhysicalPerson(String name, Double annualIncome, Double healthExpeditures) {
		super(name, annualIncome);
		this.healthExpeditures = healthExpeditures;
	}

	public Double getHealthSpending() {
		return healthExpeditures;
	}

	public void setHealthSpending(Double healthExpeditures) {
		this.healthExpeditures = healthExpeditures;
	}	
	
	@Override
	public Double TaxPaid() {
		if (super.getAnnualIncome() < 20.000) {
			if(healthExpeditures > 0) {
				return super.getAnnualIncome() * 0.15 - healthExpeditures * 0.5;
			} else {
				return super.getAnnualIncome() * 0.15;
			}
		} else {
			if(healthExpeditures > 0) {
				return super.getAnnualIncome() * 0.25 - healthExpeditures * 0.5;
			} else {
				return super.getAnnualIncome() * 0.25;
			}
		}
	}
}
