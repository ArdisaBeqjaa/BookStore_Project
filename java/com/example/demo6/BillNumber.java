package com.example.demo6;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public abstract class BillNumber {

	public static int billNumber=0;
	public static double  totalIncome=0;
	public static int totalBooksSold=0;

	public static int  totalnr(){
		totalBooksSold++;
		return totalBooksSold;
	}
	
	public static void updateBooks(ArrayList<Book> arr) throws IOException {
		
		FileOutputStream out = new FileOutputStream("Books.txt");
		ObjectOutputStream objout = new ObjectOutputStream(out);
		
		for (int i=0;i<arr.size();i++) {
			objout.writeObject(arr.get(i));
		}
		
		out.close();
		objout.close();
		
	}
	
	public static ArrayList<Book> getStockBooks(){
		
		ArrayList<Book> stockBooks = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("Books.txt");
		    ObjectInputStream objis = new ObjectInputStream(fis);
		    
		    while(true){
	            stockBooks.add( (Book) objis.readObject() );
	        }
		    
		}
		catch(IOException i) {}
		catch(ClassNotFoundException c) {}

		return stockBooks;
	}
	ArrayList<String>isbnstock=new ArrayList<>();
	ArrayList<String>tiltestock=new ArrayList<>();
	ArrayList<String>categorystock=new ArrayList<>();
	ArrayList<String>supplierstock=new ArrayList<>();
	ArrayList<String>authorstock=new ArrayList<>();
	ArrayList<Double>orpricestock=new ArrayList<>();
	ArrayList<Double>sellstock=new ArrayList<>();
	ArrayList<Integer>stockstock=new ArrayList<>();
//						Book(String ISBN, String title, String category, String supplier, double originalPrice, double sellingPrice,String author, int stock){

//	public static void setStock2(ArrayList<String>isbnstock,ArrayList<String>tiltestock,ArrayList<String>categorystock,ArrayList<Double>orpricestock,ArrayList<Double>sellstock,ArrayList<String>authorstock,ArrayList<Integer>stockstock) throws  IOException{
//		FileOutputStream out2 = new FileOutputStream("Books.txt");
//		ObjectOutputStream objout2 = new ObjectOutputStream(out2);
//
//		Book book = new Book("0096184570112","ELTA","ficiotn","adfad",65.00,73.96,"Marcel Proust",5);
//		objout2.writeObject(book);
//
//       for(int i=0;i<isbnstock.size();i++){
//		   book = new Book(isbnstock.get(i),tiltestock.get(i),categorystock.get(i),orpricestock.get(i),sellstock.get(i),authorstock.get(i),stockstock.get(i));
//		   objout2.writeObject(book);
//	   }
//
//
//	}
	public static void setInitialStock() throws IOException {
		FileOutputStream out = new FileOutputStream("Books.txt");
		ObjectOutputStream objout = new ObjectOutputStream(out);

		Book book = new Book("123400000010","Anna Karenina","ficiotn","aa",1225.00,1233.96,"Marcel Proust",10);
		objout.writeObject(book);


		 book = new Book("543210000000","HarryPotter","ficiotn","xx",1432.00,1783.96,"Marcel Proust",9);
		objout.writeObject(book);

		book = new Book("567687","Divergent","adventure","pp inc",2335.00,1000.96,"Marcel Proust",5);
		objout.writeObject(book);
		book = new Book("009800000007","To Kill a Mockingbird","literature","rr inc",65.00,73.96,"Marcel Proust",9);
		objout.writeObject(book);
		book = new Book("12553","The Great Gatsby","science","ox inc",2423.00,18.00,"James Joyce",6);
		objout.writeObject(book);
		book = new Book("13333212","Divergent","adventure","gg inc",1233.00,73.96,"Marcel Proust",8);
		objout.writeObject(book);
		book = new Book("12312","Hamlet","literature","cc inc",1342.00,73.96,"Marcel Proust",9);
		objout.writeObject(book);
		book = new Book("4231","Invisible Man","science","ff inc",1115.00,18.00,"James Joyce",3);
		objout.writeObject(book);

		book = new Book("0629","A Passage to India","Novel","dd inc",5.00,6.59,"Miguel de Cervantes",10);
		objout.writeObject(book);

		book = new Book("671389","Invisible Man","Magic realism","uu inc",13.00,16.99,"Gabriel Garcia Marquez",3);
		objout.writeObject(book);
		
		book = new Book("3111","Catch-22","Tragedy","uu inc",10.00,11.95,"F. Scott Fitzgerald",7);
		objout.writeObject(book);
		

		
	    book = new Book("26399996","An Immense World","Historical novel","xx inc",17.00,19.99,"Leo Tolstoy",3);
	    objout.writeObject(book);
	    
	    book = new Book("3145","Valley of the Dolls by Jacqueline Susann","aa inc","Publishers Group West",12.00,14.99,"William Shakespeare",12);
	    objout.writeObject(book);
	    
	    book = new Book("8153","All the Lovers in the Night","Epic","bb inc",15.00,22.99,"Mieko Kawakami",4);
	    objout.writeObject(book);
	    
	    book = new Book("14580","Afterlives","Novel","ll inc",10.00,14.40,"Abdulrazak Gurnah",9);
	    objout.writeObject(book);
	   
		objout.close();
		out.close();

	}
	
	public static void showStock() {
		
		try {
			FileInputStream fis = new FileInputStream("Books.txt");
		    ObjectInputStream objis = new ObjectInputStream(fis);
		    
		    while(true){
	            System.out.println( (Book) objis.readObject() );
	        }
		    
		}
		catch(IOException i) {}
		catch(ClassNotFoundException c) {}

	}
	
	public static ArrayList<String> getCategories() {
		
		ArrayList<String> ans = new ArrayList<>();
		
		ArrayList<Book> books = BillNumber.getStockBooks();
		
		for (int i=0;i<books.size();i++) {
			ans.add( books.get(i).getCategory() );
		}
		
		
		return removeDuplicates(ans);
		
	}
	
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
  
        ArrayList<T> newList = new ArrayList<T>();
  
        for (T element : list) {
  
            if (!newList.contains(element)) {
  
                newList.add(element);
            }
        }
  
        return newList;
    }
	
	public static ArrayList<Book> getBookFromCategory(String category){
		
		ArrayList<Book> ans = new ArrayList<>();
		ArrayList<Book> stockbooks = BillNumber.getStockBooks();
		
		for (int i=0; i<stockbooks.size(); i++) {
			if (stockbooks.get(i).getCategory().equals(category)) {
				ans.add(stockbooks.get(i));
			}
		}
		
		return ans;
		
	}
	
	public static void addBookToStock(Book book) throws IOException {
		
		ArrayList<Book> stockbooks = BillNumber.getStockBooks();
		stockbooks.add(book);
		BillNumber.updateBooks(stockbooks);
	}
	
	public static String showStringStock() {
		
		String ans="Currently in Stock:\n";
	    ArrayList<Book> stockbooks = BillNumber.getStockBooks();
	    
	    for (int i=0;i<stockbooks.size();i++) {
	    	ans = ans.concat(stockbooks.get(i)+"\n");
	    }
	    
	    return ans;
	}
	
    public static boolean partOfCateogriesChecker(ArrayList<String> categoriesStock,String category) {
		
		
		for (int i=0;i<categoriesStock.size();i++) {
			if (categoriesStock.get(i).equals(category))
				return true;
		}
		return false;
	}
    
    public static void printBookDates(ArrayList<Book> arr) {
    	
    	ArrayList<Book> stockbooks = arr;
    	ArrayList<Date> dates;
  
    	for (int i=0;i<stockbooks.size();i++) {
    		
    		dates = stockbooks.get(i).getDates();
    		if (dates.isEmpty()) {
        		System.out.println("empty");
        		continue;
        	}
    		for (int j=0;j<dates.size();j++) {
    			System.out.println(dates.get(j));
    		}
    		
    	}
    }
    
    public static String getBooksSoldTotal() {
    	
    	String ans = "For Books Sold in Total We Have\n\n";
    	
        ArrayList<Book> array = BillNumber.getStockBooks();
    	
    	for (int i=0;i<array.size();i++) {
    		ans = ans.concat(array.get(i).getSoldDatesQuantitiesTotal());
    	}
    	return ans;
    }
    
//    public static String getBooksBoughtTotal() {
//
//        String ans = "For Books Bought in Total We Have\n\n";
//
//        ArrayList<Book> array = BillNumber.getStockBooks();
//
//    	for (int i=0;i<array.size();i++) {
//    		ans = ans.concat(array.get(i).getBoughtDatesQuantitiesTotal());
//    	}
//    	return ans;
//
//    }
    
    public static String getBooksSoldDay() {
    	
    	String ans = "For Books Sold Today We Have:\n\n";
    	
    	ArrayList<Book> array = BillNumber.getStockBooks();
    	
    	for (int i=0;i<array.size();i++) {
    		ans = ans.concat(array.get(i).getSoldDatesQuantitiesDay());
    	}
    	return ans;
    }
    
 public static String getBooksSoldMonth() {
    	
    	String ans = "For Books Sold In A Month We Have\n\n";
    	
    	ArrayList<Book> arr = BillNumber.getStockBooks();
    	for (int i=0;i<arr.size();i++) {
    		ans = ans.concat(arr.get(i).getSoldDatesQuantitiesMonth());
    	}
    	return ans;
    }
 
  public static String getBooksSoldYear() {
 	
 	String ans = "For Books Sold In A Year We Have\n\n";
 	
 	ArrayList<Book> arr = BillNumber.getStockBooks();
 	for (int i=0;i<arr.size();i++) {
 		ans = ans.concat(arr.get(i).getSoldDatesQuantitiesYear());
 	}
 	return ans;
 }
  
  
//  public static String getBooksBoughtDay() {
//
//	  String ans = "For Books Bought Today We Have\n\n";
//
//  	ArrayList<Book> array = BillNumber.getStockBooks();
//
//  	for (int i=0;i<array.size();i++) {
//  		ans = ans.concat(array.get(i).getBoughtDatesQuantitiesDay());
//  	}
//  	return ans;
//
//  }
//
//public static String getBooksBoughtMonth() {
//
//	  String ans = "For Books Bought In A Month We Have\n\n";
//
//  	ArrayList<Book> array = BillNumber.getStockBooks();
//
//  	for (int i=0;i<array.size();i++) {
//  		ans = ans.concat(array.get(i).getBoughtDatesQuantitiesMonth());
//  	}
//  	return ans;
//
//  }

//public static String getBooksBoughtYear() {
//
//	  String ans = "For Books Bought In A Year We Have\n\n";
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//
//	for (int i=0;i<array.size();i++) {
//		ans = ans.concat(array.get(i).getBoughtDatesQuantitiesYear());
//	}
//	return ans;
//
//}
//
//public static int getIntBooksSoldDay() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	int ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksSoldDay();
//	}
//	return ans;
//
//}

//public static int getIntBooksSoldMonth() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	int ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksSoldMonth();
//	}
//	return ans;
//}
//
//public static int getIntBooksSoldYear() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	int ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksSoldYear();
//	}
//	return ans;
//
//}

//public static double getIncomeDay() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	double ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksSoldDay()*array.get(i).getSellingPrice();
//	}
//
//	return ans;
//
//}
//
//public static double getIncomeMonth() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	double ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksSoldMonth()*array.get(i).getSellingPrice();
//	}
//
//	return ans;
//
//}

//public static double getIncomeYear() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	double ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksSoldYear()*array.get(i).getSellingPrice();
//	}
//
//	return ans;
//
//}
//
//public static int getTotalBoughtBooksDay() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	int ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksBoughtDay();
//	}
//	return ans;
//
//}

//public static int getTotalBoughtBooksMonth() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	int ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksBoughtMonth();
//	}
//	return ans;
//}
//
//public static int getTotalBoughtBooksYear() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	int ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksBoughtYear();
//	}
//	return ans;
//
//}

public static double getCostDay() {
	
	ArrayList<Book> array = BillNumber.getStockBooks();
	double ans=0;
	
	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksBoughtDay()*array.get(i).getOriginalPrice();
		ans+=array.get(i).getOriginalPrice();
	}
	
	return ans;
	
}

//public static double getCostMonth() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	double ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksBoughtMonth()*array.get(i).getOriginalPrice();
//	}
//
//	return ans;
//
//}
//public static double getCostYear() {
//
//	ArrayList<Book> array = BillNumber.getStockBooks();
//	double ans = 0;
//
//	for (int i=0;i<array.size();i++) {
//		ans+=array.get(i).getTotalBooksBoughtYear()*array.get(i).getOriginalPrice();
//	}
//
//	return ans;
//
//}

public static boolean isPartOfBooks(String ISBN) {
	
	ArrayList<Book> array = BillNumber.getStockBooks();
	
	for (int i=0;i<array.size();i++) {
		if (array.get(i).getISBN().equals(ISBN))
			return true;
	}
	return false;
}

public static ArrayList<String> getISBNName(){

	ArrayList<Book> array = BillNumber.getStockBooks();
	ArrayList<String> ans = new ArrayList<>();

	for (int i=0;i<array.size();i++) {
		ans.add( array.get(i).getISBN()+" - "+array.get(i).getTitle() );
	}

	return ans;
}
    
	
}
