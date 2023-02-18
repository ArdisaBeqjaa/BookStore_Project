package com.example.demo6;
import java.util.ArrayList;

public class Manager extends Librarian {
	
	private static ArrayList<Librarian> librarians = new ArrayList<>();

	Manager(String username, String password) {
		super(username, password);
		
	}
	private int total_money;

	
	Manager(String username,String password,String name,double salary,String phone,String email){
		super(username,password,name,salary,phone,email);
	}
	
     public static void InstantiateLibrarians() {
		
		Librarian lib = new Librarian("noah","12","Ardisa",1500,"069 80 33 000","aflie@librarian.com") ;
		librarians.add(lib);


		lib = new Librarian("leo","1","zoe",500,"069 152 493","zoe@gmail.com");
		librarians.add(lib);
		
		lib = new Librarian("anna","NDt8f6xL","anna",2310,"067 742 832","anna@gmail.com");
		librarians.add(lib);
		
		lib = new Librarian("james","vGtM6beC","james",3410,"067 253 939","james@gamil.com");
		librarians.add(lib);
		
		lib = new Librarian("1","1","Sara",1330,"068 632 553","sara@gamil.com");
		librarians.add(lib);

		 lib = new Librarian("noah","1","Noah",1500,"067 632 353","noah@gmail.com");
		 librarians.add(lib);

		 lib = new Librarian("noah","1","John",1200,"069 632 353","john@gmail.com");
		 librarians.add(lib);

		 lib = new Librarian("noah","1","kevin",1220,"069 632 353","kevin@gmail.com");
		 librarians.add(lib);

		 lib = new Librarian("noah","1","cindy",1790,"069 632 353","cindy@gmail.com");
		 librarians.add(lib);

		 lib = new Librarian("noah","1","jessica",1340,"067 632 353","jesssica@gmail.com");
		 librarians.add(lib);


	 }
	
    
    public static String checkStock() {
    	
    	ArrayList<Book> stockbooks = BillNumber.getStockBooks();
    	String ans = "Warning!\n";
    	int check=0;
    	
    	for (int i=0;i<stockbooks.size();i++) {
    		if (stockbooks.get(i).getStock()<5) {
    			check=1;
    			ans = ans.concat("Book: "+stockbooks.get(i).getTitle()+", With ISBN code: "+stockbooks.get(i).getISBN()+", Has Stock: "+stockbooks.get(i).getStock()+"\n");
    		}
    	}
    	
    	if (check==0)
    		return "Every book has 5 or more items in stock";
    	return ans;
    	
    }
    
    public static ArrayList<Book> getLowStock(){
    	
    	ArrayList<Book> stockbooks = BillNumber.getStockBooks();
    	ArrayList<Book> ans = new ArrayList<>();
    	
    	for (int i=0;i<stockbooks.size();i++) {
    		
    		if (stockbooks.get(i).getStock() < 5 ) {
    			ans.add(stockbooks.get(i));
    		}
    		
    	}
    	
    	return ans;
    	
    }
    
    public static void AddLibrarian(Librarian lib) {
    	librarians.add(lib);
    }
    
    public static ArrayList<Librarian> getLibrarians() {
    	return librarians;
    }
    
    public static boolean partOfLibrarian(Librarian lib) {
    	
    	for (int i=0;i<librarians.size();i++) 
    		if (librarians.get(i).getUsername().equals(lib.getUsername()))
    			return true;
    		
    	return false;
    	
    }
    
    public static Librarian reEnter(Librarian lib) {
    	
    	for (int i=0;i<librarians.size();i++) {
    		if (librarians.get(i).getUsername().equals(lib.getUsername()))
    			return librarians.get(i);
    	}
    	
    	return null;
    	
    }
    
    public static boolean LibrarianChecker(Librarian lib) {
    	for (int i=0;i<librarians.size();i++) {
    		if (librarians.get(i).getUsername().equals(lib.getUsername()) && librarians.get(i).getPassword().equals(lib.getPassword()))
    			return true;
    	}
    	return false;
    	
    	
    }
    
    public static Librarian getBackLibrarian(Librarian lib) {
    	
    	for (int i=0;i<librarians.size();i++){
    		if (librarians.get(i).getUsername().equals(lib.getUsername()))
    			return librarians.get(i);
    	}
    	return null;
    }
    
    public static void updateLibrarians(Librarian lib) {
    	
    	for (int i=0;i<librarians.size();i++){
    		if (librarians.get(i).getUsername().equals(lib.getUsername())) {
    			librarians.get(i).setEmail( lib.getEmail() );
    			librarians.get(i).setPhone( lib.getPhone() );
    			librarians.get(i).setSalary( lib.getSalary() );
    			librarians.get(i).setPassword( lib.getPassword() );
    			librarians.get(i).setUsername( lib.getUsername() );
    			return;
    		}
    			
    	}
    
    	
    }
    
    public static void deleteLibrarian(Librarian lib) {
    	for (int i=0;i<librarians.size();i++) {
    		if (librarians.get(i).getUsername().equals(lib.getUsername())) {
    			librarians.remove(i);
    			return;
    		}
    	}
    }
    
    public static ArrayList<String> getAllCategories(){
    	
    	ArrayList<String> ans = new ArrayList<>();
    	ans.add("Modernist");
    	ans.add("Fiction");
    	ans.add("Novel");
    	ans.add("Magic Realism");
    	ans.add("Tragedy");
    	ans.add("Adventure Fiction");
    	ans.add("Historical Novel");
    	ans.add("Epic");
    	ans.add("War");
    	ans.add("Autobiography and memoir");
    	ans.add("Biography");
    	ans.add("Non-fiction novel");
    	ans.add("Self-help");
    	ans.add("Short stories");
    	ans.add("Horror");
    	ans.add("Mystery");
    	ans.add("Romance");
    	ans.add("Thriller");
    	return ans;
    }
}
