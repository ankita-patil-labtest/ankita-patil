public class User{
  
  private double billAmount;
	private boolean isEmployee;
	private boolean isAffiliate;
	private boolean isLoyalCustomer;
	private boolean isGrocery;
	
	public double getBillAmount() {
		return billAmount;
	}
	public boolean isEmployee() {
		return isEmployee;
	}
	public boolean isAffiliate() {
		return isAffiliate;
	}
	public boolean isLoyalCustomer() {
		return isLoyalCustomer;
	}
	public boolean isGrocery() {
		return isGrocery;
	}
	public User(double billAmount, boolean isEmployee, boolean isAffiliate, boolean isLoyalCustomer,
			boolean isGrocery) {
		super();
		this.billAmount = billAmount;
		this.isEmployee = isEmployee;
		this.isAffiliate = isAffiliate;
		this.isLoyalCustomer = isLoyalCustomer;
		this.isGrocery = isGrocery;
	}
}
