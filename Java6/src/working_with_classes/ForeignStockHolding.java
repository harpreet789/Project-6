package working_with_classes;

public class ForeignStockHolding extends StockHolding{//inheritance
	
	float conversionRate;
	ForeignStockHolding()
	{
		super();//call to super class's default contructor
		conversionRate=0;
		
	}
	ForeignStockHolding(float purc_price,float curr_price,int share_count,String company,float rate)
	{
		super(purc_price,curr_price,share_count,company);
		conversionRate=rate;
	}
    
	//methods,now conversion rate is also useed for calculation
	float costInDollars() {
		return conversionRate*purchaseSharePrice*numberOfShares;
	}
	float valueInDollars() {
		return  conversionRate *currentSharePrice* numberOfShares;
	}

		void displayDetails()
		{
			System.out.println(this.companyName + "                " 
						+this.numberOfShares + "                   " + this.purchaseSharePrice + "                    "+ this.currentSharePrice + "                " + this.conversionRate  );
		}
	
	
}
