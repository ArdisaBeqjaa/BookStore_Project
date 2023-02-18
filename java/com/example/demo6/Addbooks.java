//package com.example.demo6;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//public class Addbooks implements EventHandler<ActionEvent> {
//
//
//    @Override
//    public void handle(ActionEvent actionEvent) {
//        if (comboBoxLibrarian.getValue() == null && quantity.getCharacters().toString().isEmpty()) {
//            warningsLibrarian.setText("Failed, Empty fields");
//            return;
//        }
//        else if (comboBoxLibrarian.getValue() == null) {
//            warningsLibrarian.setText("Failed to add,Empty ISBN");
//            return;
//        }
//        else if (quantity.getCharacters().toString().isEmpty()) {
//            warningsLibrarian.setText("Failed, Empty Quantity");
//            return;
//        }
//
//        else if(!quantity.getCharacters().toString().matches("\\d{1,}") || Integer.parseInt(quantity.getCharacters().toString()) == 0) {
//            warningsLibrarian.setText("Failed, Invalid Quantity");
//            return;
//        }
//
//
//        if (!Librarian.EnoughStock(comboBoxLibrarian.getValue().toString().substring(0,13), Integer.parseInt(quantity.getCharacters().toString())) ) {
//            warningsLibrarian.setText("Failed,not enough stock");
//            return;
//        }
//
//        String isbn = comboBoxLibrarian.getValue().toString().substring(0,13);
//        Integer quan = Integer.parseInt(quantity.getCharacters().toString());
//        date = new Date();
//
//
//        ArrayList<Book> stockbooks = BillNumber.getStockBooks();
//        for (int i=0;i<stockbooks.size();i++) {
//            if (stockbooks.get(i).getISBN().equals(isbn)) {
//
//                stockbooks.get(i).RemoveStock(quan);
//            }
//        }
//        try {
//            BillNumber.updateBooks(stockbooks);
//        } catch (IOException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//        Book book = new Book(isbn);
//
//        books.add(book);
//        bookQuantities.add(quan);
//
//        //comboBoxLibrarian.getSelectionModel().clearSelection();
//        bookISBN.clear();
//        quantity.clear();
//        warningsLibrarian.setText("Added");
//    }
//}
//
