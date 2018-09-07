package working_with_classes;

public class StockTesting1 {

	public static void main(String[] args) {
		int stock_count=4;
		StockHolding stock[]=new StockHolding[stock_count];//dynamic allocation
		//creating objects and storing in array
		System.out.println("Stock Holding instances:");
		stock[0]=new StockHolding(10.0f,15.0f,10," BMW");
		stock[1]=new StockHolding(11.0f,16.0f,20,"AUDI");
		stock[2]=new StockHolding(12.0f,17.0f,22,"THAR");
		stock[3]=new StockHolding(05.0f,07.0f,50,"JEEP");
		//sorting by company name 
		sort(stock);
		//print in reverse alphabetical order
		
			System.out.println("companyName      numberOfShares         purchaseSharePrice      currentSharePrice" );
		
		for(int i=stock_count-1;i>=0;i--)
		{
			stock[i].displayDetails();
		}
		//creating instances of ForeignStockHolding
		System.out.println(" foreign stock holding instances");
		stock_count=2;
		ForeignStockHolding st[]=new ForeignStockHolding[stock_count];
		st[0]=new ForeignStockHolding(10.0f,15.0f,10," BMW",1.5f);
		st[1]=new ForeignStockHolding(11.0f,16.0f,20,"AUDI",1.2f);
		sort(st);
		System.out.println("companyName      numberOfShares         purchaseSharePrice      currentSharePrice    Conversion rate" );
  
		
		for(int i=stock_count-1;i>=0;i--)
		{
			st[i].displayDetails();
		}
	}
	//we will be needing a method to get company name here,thus define that in StockHolding class
	static void sort(StockHolding stocks[])//insertion sort,
	{
		int size=stocks.length;
		for(int curr=0;curr<size;curr++)
		{
			StockHolding key_stock=stocks[curr];
			int comp_index=curr-1;
			while(comp_index>-1&&stocks[comp_index].fetchCompanyName().compareTo(key_stock.fetchCompanyName())>0)
			{
				stocks[comp_index+1]=stocks[comp_index];
				comp_index--;
			}
			stocks[comp_index+1]=key_stock;
		}
	}

}
