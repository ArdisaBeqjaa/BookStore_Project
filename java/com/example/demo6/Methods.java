package com.example.demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public  abstract class Methods {
//    create a funtion that will read the books form the list using binaryfiles
    ArrayList<Book> bookArrayList=new ArrayList<>();
    public static ArrayList<Book> readListBook(){
// create an arraylist of books
        ArrayList<Book> stockBooks = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream("Books.txt");
//            tek file i bejm write objektin
            ObjectInputStream op = new ObjectInputStream(fileInputStream);

            while(true){
                stockBooks.add( (Book) op.readObject() );
            }

        }
        catch(IOException i) {}
        catch(ClassNotFoundException c) {}

        return stockBooks;
    }

    public static ArrayList<String> piechart(){
        ArrayList<Book> arrayList3=readListBook();
        ArrayList<String>title=new ArrayList<>();

        for(int i=0;i<arrayList3.size();i++){
            title.add(arrayList3.get(i).getTitle());
        }
        return  title;
    }


    public static ArrayList<String> bookmenu1(){

        ArrayList<Book> arrayList = readListBook();
        ArrayList<String> x = new ArrayList<>();

        for (int i=0;i<arrayList.size();i++) {
            x.add( arrayList.get(i).getISBN()+" "+arrayList.get(i).getTitle()+" "+arrayList.get(i).getAuthor() );
        }

        return x;
    }
public  static int da(){
        return 0;
}
//per combo-box
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

    public static ArrayList<String> getAuthors(){

        ArrayList<String> ans = new ArrayList<>();
        ans.add("Chimamanda Ngozi Adichie");
        ans.add("Cormac McCarthy");
        ans.add("Haruki Murakami");
        ans.add("Donna Tartt");
        ans.add("Ann Patchett");
        ans.add("Chimamanda Ngozi Adichie");
        ans.add("Arundhati Roy");
        ans.add("Zadie Smith");

        return ans;
    }

    public static void removeDuplicatesSoldTitles(ArrayList<String> titles, ArrayList<Integer> quantities) {

        for (int k=0;k<2;k++) {

            for (int i=0;i<titles.size();i++) {
                for (int j=i+1;j<titles.size();j++) {
                    if (titles.get(i).equals(titles.get(j))){
                        quantities.set(i, quantities.get(i) + quantities.get(j));
                        titles.remove(j);
                        quantities.remove(j);
                    }
                }
            }

        }

        int n=titles.size()-1;
        try {
            if (  titles.get(n).equals( titles.get(n-1) ) ) {

                quantities.set(n-1,  quantities.get(n)+quantities.get(n-1) );
                quantities.remove(n);
                titles.remove(n);
            }
        }
        catch(IndexOutOfBoundsException e) {}

    }


}
