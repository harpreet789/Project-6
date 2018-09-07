package working_with_classes;

public class StockHolding {

	float purchaseSharePrice, currentSharePrice;
	int numberOfShares;
	String companyName;
	StockHolding()//constructor for initilization
	{
		purchaseSharePrice=0;
		currentSharePrice=0;
		numberOfShares=0;
		companyName="";
	}
	//parametrized constructor
	StockHolding(float purc_price,float curr_price,int share_count,String company)
	{
		purchaseSharePrice=purc_price;
		currentSharePrice=curr_price;
		numberOfShares=share_count;
		companyName=company;
	}
	//methods
	float costInDollars()
	{
		return purchaseSharePrice*numberOfShares;
	}
	float valueInDollars()
	{
		return currentSharePrice*numberOfShares;
	}
	String fetchCompanyName()
	{
		return companyName;
	}
	float fetchPurchasePrice()
	{
		return purchaseSharePrice;
	}
	float fetchCurrentPrice()
	{
		return currentSharePrice;
	}
	
	void displayDetails()
	{
		System.out.println(this.companyName + "              " +this.numberOfShares + "                    " + this.purchaseSharePrice + "                      "+ this.currentSharePrice );
	}
}

