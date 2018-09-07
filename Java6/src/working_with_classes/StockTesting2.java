package working_with_classes;
import java.util.Scanner;
public class StockTesting2 {

	public static void main(String[] args) throws Exception {
		//firstly we create sccanner instance for taking input
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter stock count: ");
		int stock_count;
		stock_count=scn.nextInt();
		StockHolding stocks[]=new StockHolding[stock_count];
		for(int i=0;i<stock_count;i++)
		{
			int type_of_stock,share_count;
			float prch_price,curr_price;
			String company;
			System.out.println(" Enter the type of the stock: type-1 for standard , type-2 for foreign :: ");
			type_of_stock=scn.nextInt();
			System.out.println(" Enter share's purchase price ");
			prch_price=scn.nextFloat();
			System.out.println(" Enter share's current price ");
			curr_price=scn.nextFloat();
			System.out.println(" Enter the share count :");
			share_count=scn.nextInt();
			String extra_input=scn.nextLine();
			System.out.println(" Enter the company name :");
			company=scn.nextLine();
			if(type_of_stock==2)
			{
				float rate;
				System.out.println("Enter the conversion rate :");
				rate=scn.nextFloat();
				stocks[i]=new ForeignStockHolding(prch_price,curr_price,share_count,company,rate);
			}
			else
			{
				stocks[i]=new StockHolding(prch_price,curr_price,share_count,company);
			}
			
		}
		label :while(true)
		{
		
			System.out.println(" make a choice :");
			System.out.println("1.Display stock information with the lowest value:");
			System.out.println("2.Display stock with the highest value");
			System.out.println("3.Display the most profitable stock");
			System.out.println("4.Display the least profitable stock");
			System.out.println("5.List all stocks sorted by company name (A-Z)");
			System.out.println("6.List all stocks sorted from the lowest value to the highest value");
			System.out.println("7.Exit");
			int choice=scn.nextInt();
			//using switch cases
			switch(choice)
			{
			case 1:
				System.out.println(" the stock with lowest value is:");
				lowestValueStock(stocks);
				break;
			case 2:
				System.out.println(" the stock with highest value is:");
				highestValueStock(stocks);
				break;
			case 3:
				System.out.println(" the most profitable stock is:");
				mostProfitable(stocks);
				break;
			case 4:
				System.out.println(" the least profitable stock is:");
				leastProfitable(stocks);
				break;
			case 5:
				System.out.println(" the Stocks sorted by company name : ");
				sort_by_name(stocks);
				display_stocks(stocks);
				break;
			case 6:
				System.out.println(" the stocks sorted by value are: ");
				sort_by_value(stocks);
				display_stocks(stocks);
				break;
			case 7:
				break label;
			default:
				System.out.println(" try a valid  choice");
			}
		}
		scn.close();
		
	}
	public static void lowestValueStock(StockHolding stocks[])
	{
		int size=stocks.length;
		StockHolding stock_obj=stocks[0];
		for(int i=1;i<size;i++)
		{
			if(stocks[i].valueInDollars()<stock_obj.valueInDollars())
				stock_obj=stocks[i];
		}
		stock_obj.displayDetails();
		return;
	}
	public static void highestValueStock(StockHolding stocks[])
	{
		int size=stocks.length;
		StockHolding stock_obj=stocks[0];
		for(int i=1;i<size;i++)
		{
			if(stocks[i].valueInDollars()>stock_obj.valueInDollars())
				stock_obj=stocks[i];
		}
		stock_obj.displayDetails();
		return;
	}
	public static void mostProfitable(StockHolding stocks[])//we need value of purchase and current price,so to fetch that we define therse two methods in stock holding class
	{
		
		int size=stocks.length;
		StockHolding stock_obj=stocks[0];
		for(int i=1;i<size;i++)
		{
			if(stocks[i].fetchCurrentPrice()-stocks[i].fetchPurchasePrice()>stock_obj.fetchCurrentPrice()-stock_obj.fetchCurrentPrice())
				stock_obj=stocks[i];
		}
		stock_obj.displayDetails();
		return;
	}
	public static void leastProfitable(StockHolding stocks[])
	{
		
		int size=stocks.length;
		StockHolding stock_obj=stocks[0];
		for(int i=1;i<size;i++)
		{
			if(stocks[i].fetchCurrentPrice()-stocks[i].fetchPurchasePrice()<stock_obj.fetchCurrentPrice()-stock_obj.fetchCurrentPrice())
				stock_obj=stocks[i];
		}
		stock_obj.displayDetails();
		return;
	}
	public static void sort_by_name(StockHolding stocks[])//insertion sort,
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
	public static void sort_by_value(StockHolding stocks[])
	{
		int size=stocks.length;
		for(int curr=0;curr<size;curr++)
		{
			StockHolding key_stock=stocks[curr];
			int comp_index=curr-1;
			while(comp_index>-1&&stocks[comp_index].valueInDollars()>key_stock.valueInDollars())
			{
				stocks[comp_index+1]=stocks[comp_index];
				comp_index--;
			}
			stocks[comp_index+1]=key_stock;
		}
	}
	public static void display_stocks(StockHolding stocks[])
	{
		System.out.println("companyName      numberOfShares         purchaseSharePrice      currentSharePrice" );
		int size=stocks.length;
		for(int i=0;i<size;i++)
		{
			stocks[i].displayDetails();
		}
	}

}
