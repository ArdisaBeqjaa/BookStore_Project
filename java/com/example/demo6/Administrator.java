package com.example.demo6;

import java.util.ArrayList;

public class Administrator extends Manager {
	
	private static ArrayList<Manager> managers = new ArrayList<>();
	
	

	
	private String username;
	private String password;
	
	Administrator(String username,String password){
		super(username,password);
		this.username=username;
		this.password=password;
	}
	
	public static double getSalaries() {
		
		double ans = 0;
		
		for (int i=0;i<Manager.getLibrarians().size();i++) {
			ans += Manager.getLibrarians().get(i).getSalary();
		}
		
		for (int i=0;i<Administrator.getManagers().size();i++) {
			ans += Administrator.getManagers().get(i).getSalary();
		}
		return ans;
	}
	
	
    public static void InstantiateManagers() {
 		
		Manager mag = new Manager("ardisa","3","Calvin",1340,"(912) 561-2628","ardis@gmail.com") ;
		managers.add(mag);
		
	    mag = new Manager("james","james1","james",1230,"(912) 218-2594","james@gmail.com") ;
		managers.add(mag);
		
		mag = new Manager("nicloe","nicole1","nicole",1400,"(912) 623-5353","nicole@gmail.com");
		managers.add(mag);
	}
	
	
    public static boolean partOfManager(Manager mag) {
    	
    	for (int i=0;i<managers.size();i++) 
    		if (managers.get(i).getUsername().equals(mag.getUsername()))
    			return true;
    		
    	return false;
    	
    }
    
    public static Manager reEnter(Manager mag) {
    	
    	for (int i=0;i<managers.size();i++) {
    		if (managers.get(i).getUsername().equals(mag.getUsername()))
    			return managers.get(i);
    	}
    	
    	return null;
    	
    }
    
    public static void AddManager(Manager mag) {
    	managers.add(mag);
    }
    
    public static boolean checker(String username,String password) {
    	
    	for (int i=0;i<usernames.length;i++) {
    		if (usernames[i].equals(username))
    			if (passwords[i].equals(password))
    				return true;
    	}
    	
    	return false;
    }
    
    public static boolean ManagerChecker(Manager mag) {
    	for (int i=0;i<managers.size();i++) {
    		if (managers.get(i).getUsername().equals(mag.getUsername()) && managers.get(i).getPassword().equals(mag.getPassword()))
    			return true;
    	}
    	return false;
    	
    	
    }
    
    public static Manager getBackManager(Manager mag) {
    	
    	for (int i=0;i<managers.size();i++){
    		if (managers.get(i).getUsername().equals(mag.getUsername()))
    			return managers.get(i);
    	}
    	return null;
    }
    
    public static ArrayList<Manager> getManagers(){
    	return managers;
    }
    
    public static void deleteManager(Manager mag) {
    	for (int i=0;i<managers.size();i++) {
    		if (managers.get(i).getUsername().equals(mag.getUsername()) ) {
    			managers.remove(i);
    			return;
    		}
    	}
    }
    
   public static void updateManagers(Manager mag) {
    	
    	for (int i=0;i<managers.size();i++){
    		if (managers.get(i).getUsername().equals(mag.getUsername())) {
    			managers.get(i).setEmail( mag.getEmail() );
    			managers.get(i).setPhone( mag.getPhone() );
    			managers.get(i).setSalary( mag.getSalary() );
    			managers.get(i).setPassword( mag.getPassword() );
    			managers.get(i).setUsername( mag.getUsername() );
    			return;
    		}
    			
    	}
    
    	
    }
	private static String[] usernames = {
			"ema",
			"cindy",
			"kevin",
			"2"
	};

	private static String[] passwords = {
			"3",
			"1",
			"9",
			"2"
	};

}
