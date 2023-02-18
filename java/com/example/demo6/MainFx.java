package com.example.demo6;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainFx extends Application implements EventHandler<ActionEvent> {
//
ArrayList<String>isbnstock=new ArrayList<>();
	ArrayList<String>categorystock=new ArrayList<>();
	ArrayList<String>supplierstock=new ArrayList<>();
	ArrayList<Double> orpricestock=new ArrayList<Double>();
	ArrayList<Double> sellstock=new ArrayList<Double>();
	ArrayList<String> titlestock=new ArrayList<String>();
	ArrayList<String>authorstock=new ArrayList<>();
	ArrayList<String> stockstock=new ArrayList<String>();

	TextField loginField2=new TextField();
	PasswordField passField=new PasswordField();

	Button bttLibrarian = new Button("Librarian");
	Button bttManager = new Button("Manager");
	Button bttAdministrator = new Button("Administrator");
	
	//shared
	Book b20;
	String usernamePage;
	TextField username = new TextField();
	TextField stcokfield212=new TextField();
	Text textUsername = new Text("Username");
	PasswordField password = new PasswordField();
	Text textPassword = new Text("Password");
	Button bttSubmit = new Button("Submit");
	Button bttBack = new Button("Back");
	Text textWarningEmpty = new Text("Warning empty field");
	Text textSystem = new Text("System");
    
	//librarian variables
	Librarian librarian;
	Date date;
	final int[] xx = {0};
	ComboBox comboBoxLibrarian;
	ArrayList<String>name_combo=new ArrayList<>();
	TextField bookISBN = new TextField();
	TextField bookfield12=new TextField();
	Text textBookISBN = new Text("Book ISBN");
	TextField quantity = new TextField();
	Text textQuantity = new Text("Quantity");
	Button bttAdd = new Button("Add");
	Button bttBill = new Button("Bill");
	TextField warningsLibrarian = new TextField();
	BorderPane librarianPage = new BorderPane();
	ArrayList<Book> books = new ArrayList<>();
	ArrayList<Integer> bookQuantities = new ArrayList<>();
	TextField libLoginWarning = new TextField();
	
	//manager variables
	Manager manager;
	String name;
	TextField magLoginWarning = new TextField();
	Button bttSupply = new Button("Supply");
	Button bttCheckLibrarians = new Button("Check Librariansss");
	Button bttCheckStock = new Button("Check Stock");
	Button bttAddStock = new Button("Add Stock");
	Button bttNewCategory = new Button("New Category");
	Button bttCategory;
	Button bttCurrentBookStock;
	Button bttNewBook = new Button("New Book");
	Button bttAddBookToStock = new Button("Add to Stock");
	TextField addedOrNot = new TextField();
	Text textTitle = new Text("Title");
	TextField title = new TextField();
	int total_bill=0;
	Text textSupplier = new Text("Supplier");
	TextField supplier = new TextField();
	Text textOriginalPrice = new Text("Original Price");
	TextField originalPrice = new TextField();
	Text textSellingPrice = new Text("Selling Price");
	TextField sellingPrice = new TextField();
	Text textAuthor = new Text("Author");
	TextField author = new TextField();
	Text warnings=new Text();
	ArrayList<String>list_name=new ArrayList<>();
	Button stockCategoryAddBook = new Button("Add");
	TextField addedOrNotStockCategory = new TextField();
	Button bttBackManager = new Button("Back");
	TextField category = new TextField();
	Text textCategory = new Text("Category");
	ArrayList<String> categ = BillNumber.getCategories();
	TextField totalNumberBillsLibrarian = new TextField();
	Text textTotalNumberBillsLibrarian = new Text("Total Number of Bills");
	TextField booksSold = new TextField();
	Text textBooksSold = new Text("Books Sold");

	ArrayList<String>book_bought=new ArrayList<>();
	ArrayList<Integer>quantity_bought=new ArrayList<>();
	TextField totalAmountOfMoneyMadeInDay = new TextField();
	Text textTotalMoneyDay = new Text("Money made today");
	TextField totalAmountOfMoneyMadeInMonth = new TextField();
	Text textTotalMoneyMonth = new Text("Money made in a month");
	TextField totalAmountOfMoneyMadeInYear = new TextField();
	Text textTotalMoneyYear = new Text("Money made in a year");
	
	//administrator variables
	Administrator administrator;
	TextField admLoginWarning = new TextField();
	Button bttManageManager = new Button("Manage Managers");
	Button bttManageLibrarians = new Button("Manage Librarians");
	Button bttStats = new Button("Stats");
	

	

	public static void main(String[] args) throws IOException  {
//		call the method that generates the booklist
		BillNumber.setInitialStock();
		Manager.InstantiateLibrarians();
		Administrator.InstantiateManagers();
		ArrayList<Book>aa=new ArrayList<>();
//		aa.get(0).getTitle();
//		aa.get(0).getStock();

 		Application.launch(args);

	}
	private void ButtonOpenWebActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String url = "https://www.instagram.com/";
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		
        stage.setTitle("Library System");

		
		Scene scene = new Scene(mainPage(),500,500);
		scene.setFill(Color.BISQUE);
		stage.setScene(scene);
		stage.show();
		
		
		
	}
	
public SplitPane mainPage() {
		BorderPane b2=new BorderPane();

         SplitPane splitPane=new SplitPane();
		 VBox vBox=new VBox();
		 GridPane titlegrid=new GridPane();
		 Text maintitle=new Text("Online BookStore");
		 maintitle.setFont(Font.font("Times new roman",30));
		 maintitle.setFill(Color.rgb(47,79,79));

	titlegrid.add(maintitle,0,5);


		 titlegrid.setPadding(new Insets(20));
		 titlegrid.setAlignment(Pos.CENTER);

		GridPane gridPane=new GridPane();
	    Button register=new Button("Enter ");
//		Text login=new Text("   Login:   ");

        register.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
        Text title_login=new Text("LOG - IN");
        title_login.setFont(Font.font("Times new roman",30));
		title_login.setFill(Color.rgb(47,79,79));
//		Text pass=new Text( "   Password:   ");
		loginField2.setPromptText("Username");
		passField.setPromptText("Password");
title_login.setTextAlignment(TextAlignment.CENTER);

//        gridPane.add(title_login,6,0);
	b2.setTop(title_login);

		Image img=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\3621435.png");
		ImageView view=new ImageView(img);
		view.setFitHeight(30);
		view.setPreserveRatio(true);

	Button ig=new Button();
	ig.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
	ig.setGraphic(view);
	ig.setOnAction(e->{
		try {
			String url = "https://www.instagram.com/";
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (java.io.IOException x) {
			System.out.println(x.getMessage());
		}
	});

 Image img2=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\Popular-facebook-Logo-png-removebg-preview.png");
 ImageView view1=new ImageView(img2);
 view1.setFitHeight(30);
 view1.setPreserveRatio(true);

	Button fb=new Button();
	fb.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
    fb.setGraphic(view1);
	fb.setOnAction(e->{
		try {
			String url = "https://www.facebook.com/";
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (java.io.IOException x) {
			System.out.println(x.getMessage());
		}
	});


	Image img3=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\images-removebg-preview.png");
	ImageView view2=new ImageView(img3);



	Image img4=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\Beige_Library_Lovers_Day_Illustration_Instagram_Post-removebg-preview.png");

	ImageView imageView=new ImageView(img4);
	imageView.setFitWidth(350);
	imageView.setFitHeight(400);
	view2.setFitHeight(30);
	view2.setPreserveRatio(true);
	Button tt=new Button();
	tt.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
	tt.setGraphic(view2);

		VBox vBox1=new VBox();
		vBox1.getChildren().addAll(loginField2,passField,register);
        vBox1.setAlignment(Pos.CENTER);
		vBox1.setSpacing(30);
		b2.setCenter(vBox1);

		HBox media=new HBox();
		media.getChildren().addAll(ig,fb,tt);
//		b2.setCenter(gridPane);
		b2.setBottom(media);
		b2.setPadding(new Insets(30));


		splitPane.getItems().addAll(imageView,b2);



	splitPane.setBackground(
			new Background(
					new BackgroundFill(
							Color.rgb(95,158,160), null, new Insets(-10)
					)
			)
	);
	register.setOnAction(
			e->{
//				File filelib=new File("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\USERS\\lib.txt");
//				File filemanger=new File("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\USERS\\manager.txt");
//				File fileadmin=new File("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\USERS\\admin.txt");
////				File filelib2=new File("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\USERS\\lib2.txt");
//				try {
//					if(login(filelib,loginField2.getText(),passField.getText())){
//						register.getScene().setRoot((librarianMainPage()));
//						librarian = new Librarian(loginField2.getText(),passField.getText());
//					} else if(login(filemanger,loginField2.getText(),passField.getText()) ){
//						register.getScene().setRoot(mangaerMainPage());
//					}
////					else if(login(filelib2,textUsername.getText(),textPassword.getText())){
////						register.getScene().setRoot((librarianMainPage()));
////						librarian = new Librarian(textUsername.getText(),textPassword.getText());
////					}
//					else if(login(fileadmin,loginField2.getText(),passField.getText())) {
//						register.getScene().setRoot(administratorMainPage());
//					}
//
//				} catch (FileNotFoundException ex) {
//					throw new RuntimeException(ex);
//				}



				String user = loginField2.getText();
				String pass = passField.getText();
				librarian = new Librarian(user,pass);
				manager = new Manager(user,pass);

				if (Manager.LibrarianChecker(librarian)) {


					librarian = Manager.getBackLibrarian(librarian);

					register.getScene().setRoot((librarianMainPage()));

				}
				else if (Administrator.ManagerChecker(manager)) {


					manager = Administrator.getBackManager(manager);
					usernamePage = manager.getName();
					register.getScene().setRoot(( mangaerMainPage()));

				}
				else if ((Administrator.checker(user, pass))) {

					register.getScene().setRoot((administratorMainPage()));				}

			}
	);

	return splitPane;
}

	public BorderPane librarianLoginPage() {
		
		BorderPane borderLibrarian = new BorderPane();
		borderLibrarian.setMinSize(500,300);
		
		StackPane stackTextLibrarian = new StackPane();
		Text textLibrarian = new Text("Librarian Login");
		textLibrarian.setFont(Font.font("Times new roman",22));
		textLibrarian.setFont(new Font(30));
		stackTextLibrarian.getChildren().add(textLibrarian);
		stackTextLibrarian.setPadding(new Insets(20));
		borderLibrarian.setTop(stackTextLibrarian);
		
		libLoginWarning.setEditable(false);
		GridPane gridLibrarian = new GridPane();
		gridLibrarian.setAlignment(Pos.CENTER);
		gridLibrarian.setHgap(5);
	    gridLibrarian.setVgap(5);
	    gridLibrarian.add(textUsername,0,1);
	    gridLibrarian.add(username,1,1);
	    gridLibrarian.add(textPassword,0,2);
	    gridLibrarian.add(password,1,2);
	    gridLibrarian.add(textSystem, 0, 5);
	    gridLibrarian.add(libLoginWarning, 1, 5);
	    gridLibrarian.add(bttSubmit, 6, 6);
	    gridLibrarian.add(bttBack, 0, 6);
	    borderLibrarian.setCenter(gridLibrarian);
	    
	    bttSubmit.setOnAction(this);
	    bttBack.setOnAction(this);
	    
	   
		return borderLibrarian;
		
	}
ArrayList<Integer>quantity_list=new ArrayList<>();
	public BorderPane librarianMainPage(){

//	   we use oblist since ,ObservableList: A list that allows listeners to track changes when they occur.
//		if we click a book it will be added to the list
		comboBoxLibrarian = new ComboBox(FXCollections.observableArrayList(Methods.bookmenu1()));

		Text bookname=new Text("Book Title:");
		Text title = new Text("Libraraian");
		title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		StackPane stackHeader = new StackPane();

		stackHeader.getChildren().add(title);
		stackHeader.setPadding(new Insets(20));
		librarianPage.setTop(stackHeader);
		
		GridPane lib = new GridPane();
		lib.setAlignment(Pos.CENTER);
		lib.setHgap(5);
	    lib.setVgap(5);
		lib.add(bookname,0,0);
	    lib.add(comboBoxLibrarian,1,0);
	    lib.add(textQuantity, 0, 2);
	    lib.add(quantity, 1, 2);

	    lib.add(warnings, 1, 5);
		warnings.setFont(Font.font(15));
	    warnings.setFill(Color.CHOCOLATE);
		librarianPage.setCenter(lib);

	    HBox hbox = new HBox();
	    hbox.setAlignment(Pos.CENTER);
	    hbox.getChildren().addAll(bttBack,bttAdd,bttBill);
	    hbox.setPadding(new Insets(40));
	    hbox.setSpacing(30);
		librarianPage.setBottom(hbox);

		final int[] i = {0};
	    bttAdd.setOnAction(e->{
			total_bill++;


//			do marri vlerat nga useri
			i[0]++;
//            merr vec isbn
			String text = comboBoxLibrarian.getValue().toString().substring(0,13);
			 name=comboBoxLibrarian.getValue().toString().substring(13);
			 name_combo.add(name);

			System.out.println(name);
			Integer quantiy2 = Integer.parseInt(quantity.getCharacters().toString());
//			String quantiy2=(quantity.getCharacters().toString());
			quantity_list.add((quantiy2));
			date = new Date();


			ArrayList<Book> totalb = Methods.readListBook();
			for(int j=0;j<totalb.size();j++){
				if(totalb.get(j).getISBN().equals(text)){
					totalb.get(j).RemoveStock(quantiy2);
				}
			}

			try {
				BillNumber.updateBooks(totalb);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			finally {
				System.out.println("we added "+ i[0]+"books");
			}
////
//			crreate an object, for isbn.
			Book test1 = new Book(text);

			books.add(test1);
			list_name.add(name);
			bookQuantities.add(quantiy2);

			//comboBoxLibrarian.getSelectionModel().clearSelection();
			bookISBN.clear();
			quantity.clear();
			warnings.setText("Added");

		});
//      we will print the bill
		bttBill.setOnAction(e->{
			try {


				librarian.printbill(list_name, bookQuantities);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println( librarian.getNumberOfBills() );
			bookISBN.clear();
			quantity.clear();
			books.clear();
			bookQuantities.clear();
			warningsLibrarian.setText("Bill File Created!");
			Stage s2=new Stage();

		});

        bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
            	quantity.clear();
            	warningsLibrarian.clear();
            	bttBack.getScene().setRoot(mainPage());
            }
            	
        });
		librarianPage.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.rgb(95,158,160), null, new Insets(-10)
						)
				)
		);
		
		return librarianPage;
	}
	
    public BorderPane managerLoginPage() {
		
		BorderPane borderManagerLogin = new BorderPane();
		borderManagerLogin.setMinSize(500,300);
		
		StackPane stackTextLibrarian = new StackPane();
		Text textLibrarian = new Text("Manager Login");
		textLibrarian.setFont(new Font(30));
		stackTextLibrarian.getChildren().add(textLibrarian);
		stackTextLibrarian.setPadding(new Insets(20));
		borderManagerLogin.setTop(stackTextLibrarian);
		
		magLoginWarning.setEditable(false);
		GridPane gridManagerLogin = new GridPane();
		gridManagerLogin.setAlignment(Pos.CENTER);
		gridManagerLogin.setHgap(5);
	    gridManagerLogin.setVgap(5);
	    gridManagerLogin.add(textUsername,0,1);
	    gridManagerLogin.add(username,1,1);
	    gridManagerLogin.add(textPassword,0,2);
	    gridManagerLogin.add(password,1,2);
	    gridManagerLogin.add(textSystem, 0, 5);
	    gridManagerLogin.add(magLoginWarning, 1, 5);
	    gridManagerLogin.add(bttSubmit, 6, 6);
	    gridManagerLogin.add(bttBack, 0, 6);
	    borderManagerLogin.setCenter(gridManagerLogin);
	    
	    bttSubmit.setOnAction(event -> {
            if(event.getSource()==bttSubmit) {
            	
            	if (username.getCharacters().toString().isEmpty() || password.getCharacters().toString().isEmpty()) {
    				
            		magLoginWarning.setText("Empty Fields");
    				return;
    				
    			}
    			
    			String user = username.getCharacters().toString();
    			String pass = password.getCharacters().toString();
    			manager = new Manager(user,pass);
    			
    			if (Administrator.ManagerChecker(manager)) {
    				
    				username.clear();
    				password.clear();
    				manager = Administrator.getBackManager(manager);
    				usernamePage = manager.getName();
    				bttSubmit.getScene().setRoot(mangaerMainPage());
    				
    			}
    		    
    			else {
    				magLoginWarning.setText("Wrong Information");
    				username.clear();
    				password.clear();
    			}	
            }
        });
	    
	    bttBack.setOnAction(this);
	    
	   
		return borderManagerLogin;
		
	}
    
    
    public BorderPane mangaerMainPage() {

    	BorderPane borderManagerMain = new BorderPane();	
    	Text textHeaderManager = new Text("Manger");
		StackPane stackHeader = new StackPane();
		textHeaderManager.setFont(new Font(30));
		stackHeader.getChildren().add(textHeaderManager);
		stackHeader.setPadding(new Insets(20));
		borderManagerMain.setTop(stackHeader);
		
		Button bttbookStatistics = new Button("Book Statistics");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
	    grid.add(bttSupply,0,0);
	    grid.add(bttCheckLibrarians, 1, 0);
	    grid.add(bttBack, 4, 0);
	    grid.add(bttCheckStock, 2, 0);
	    grid.add(bttbookStatistics, 3, 0);
	    grid.setPadding(new Insets(30));
//		VBox vBox=new VBox()
	    borderManagerMain.setTop(grid);
	    
	    //--------------------
	    StackPane pane = new StackPane();
	    TableView table = new TableView();
    	TableColumn<Book,String> column1 = new TableColumn<>("ISBN");
    	TableColumn<Book,String> column2 = new TableColumn<>("Title");
    	TableColumn<Book,String> column3 = new TableColumn<>("Category");
    	TableColumn<Book,String> column4 = new TableColumn<>("Author");
    	TableColumn<Book,Double> column5 = new TableColumn<>("Original Price");
    	TableColumn<Book,Double> column6 = new TableColumn<>("Selling Price");
    	TableColumn<Book,String> column7 = new TableColumn<>("Supplier");
    	TableColumn<Book,Integer> column8 = new TableColumn<>("Stock");
    	
    	column1.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
    	column2.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
    	column3.setCellValueFactory(new PropertyValueFactory<Book,String>("category"));
    	column4.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
    	column5.setCellValueFactory(new PropertyValueFactory<Book,Double>("originalPrice"));
    	column6.setCellValueFactory(new PropertyValueFactory<Book,Double>("sellingPrice"));
    	column7.setCellValueFactory(new PropertyValueFactory<Book,String>("supplier"));
    	column8.setCellValueFactory(new PropertyValueFactory<Book,Integer>("stock"));
    	
    	table.getColumns().add(column1);
    	table.getColumns().add(column2);
    	table.getColumns().add(column3);
    	table.getColumns().add(column4);
    	table.getColumns().add(column5);
    	table.getColumns().add(column6);
    	table.getColumns().add(column7);
    	table.getColumns().add(column8);
    	table.setPrefWidth(70);

    	table.setItems(FXCollections.observableArrayList(Manager.getLowStock()));
        pane.getChildren().add(table);
    	
    	borderManagerMain.setCenter(pane);
//		splitPane2.getItems().addAll(grid,pane);

	    bttSupply.setOnAction(this);
	    bttCheckStock.setOnAction(this);

	    bttCheckLibrarians.setOnAction(
				e ->{

	    		bttCheckLibrarians.getScene().setRoot(librariansAllPage());

	    	
	    });
	    bttBack.setOnAction(event -> {
			bttBack.getScene().setRoot(mainPage());

	    });
    	
	    bttbookStatistics.setOnAction(event ->{
	    	bttbookStatistics.getScene().setRoot(managerStatisticsPage());
	    });

           borderManagerMain.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
    	return borderManagerMain;
    	
    }


	public  SplitPane chart(){
		SplitPane splitPane2=new SplitPane();
		BorderPane p1=new BorderPane();
		VBox vBox14=new VBox();
		VBox vBox15=new VBox();

		BorderPane p2=new BorderPane();
//    	BorderPane border = new BorderPane();
//
		Text text = new Text("Book Statistics");
		text.setFont(Font.font("Times new roman",30));

		text.setFill(Color.rgb(47,79,79));
//		StackPane stack = new StackPane();
//
//		text.setFont(new Font(30));
//		stack.getChildren().add(text);
//		stack.setPadding(new Insets(20));
//		border.setTop(stack);
		Image img12=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\sold-removebg-preview.png");
		ImageView view12=new ImageView(img12);
		view12.setFitHeight(30);
		view12.setPreserveRatio(true);

		Image im13=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\bought-removebg-preview (1).png");
		ImageView view13=new ImageView(im13);
		view13.setFitHeight(30);
		view13.setPreserveRatio(true);
		Button bttSold = new Button();
		Button bttBought = new Button();

		bttSold.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		bttSold.setGraphic(view12);

		bttBought.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		bttBought.setGraphic(view13);
//		GridPane grid = new GridPane();
//		grid.setAlignment(Pos.CENTER);
//		grid.setHgap(5);
//		grid.setVgap(5);
//		grid.add(bttSold, 0, 0);
//		grid.add(bttBought, 1, 0);
//		border.setCenter(grid);

		bttSold.setOnAction(event ->{
//			bttSold.getScene().setRoot(managerSoldPage2());
			bttSold.getScene().setRoot(maagerSold3());
		});

		bttBought.setOnAction(event -> {
			bttBought.getScene().setRoot(managerBoughtPage());
		});


//		StackPane stackBackButton = new StackPane();
//		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
			if(event.getSource()==bttBackManager) {
				bttBackManager.getScene().setRoot( administratorMainPage());
			}
		});
		bttBackManager.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		vBox14.setSpacing(40);
		vBox14.setPadding(new Insets(40));
		vBox14.setAlignment(Pos.CENTER);
		vBox14.getChildren().add(text);
		vBox14.getChildren().add(bttBackManager);
		vBox15.setSpacing(40);
		vBox15.setPadding(new Insets(40));
		vBox15.setAlignment(Pos.CENTER);
		vBox15.getChildren().add(bttSold);
		vBox15.getChildren().add(bttBought);
//		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
//		border.setBottom(stackBackButton);
		splitPane2.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
		splitPane2.getItems().addAll(vBox14,vBox15);
		return splitPane2;
	}
    public SplitPane managerStatisticsPage() {
    	SplitPane splitPane2=new SplitPane();
		BorderPane p1=new BorderPane();
		VBox vBox14=new VBox();
		VBox vBox15=new VBox();

		BorderPane p2=new BorderPane();
//    	BorderPane border = new BorderPane();
//
    	Text text = new Text("Book Statistics");
		text.setFont(Font.font("Times new roman",30));

		text.setFill(Color.rgb(47,79,79));
//		StackPane stack = new StackPane();
//
//		text.setFont(new Font(30));
//		stack.getChildren().add(text);
//		stack.setPadding(new Insets(20));
//		border.setTop(stack);
		Image img12=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\sold-removebg-preview.png");
		ImageView view12=new ImageView(img12);
		view12.setFitHeight(30);
		view12.setPreserveRatio(true);

		Image im13=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\bought-removebg-preview (1).png");
		ImageView view13=new ImageView(im13);
		view13.setFitHeight(30);
		view13.setPreserveRatio(true);
		Button bttSold = new Button();
		Button bttBought = new Button();

		bttSold.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		bttSold.setGraphic(view12);

		bttBought.setStyle("-fx-background-color:transparent ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		bttBought.setGraphic(view13);
//		GridPane grid = new GridPane();
//		grid.setAlignment(Pos.CENTER);
//		grid.setHgap(5);
//		grid.setVgap(5);
//		grid.add(bttSold, 0, 0);
//		grid.add(bttBought, 1, 0);
//		border.setCenter(grid);

		bttSold.setOnAction(event ->{
			bttSold.getScene().setRoot(managerSoldPage2());
		});
		
		bttBought.setOnAction(event -> {
			bttBought.getScene().setRoot(managerBoughtPage());
		});
		
		
//		StackPane stackBackButton = new StackPane();
//		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( mangaerMainPage() );
            }
	    });
		bttBackManager.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		vBox14.setSpacing(40);
		vBox14.setPadding(new Insets(40));
		vBox14.setAlignment(Pos.CENTER);
		vBox14.getChildren().add(text);
		vBox14.getChildren().add(bttBackManager);
	 vBox15.setSpacing(40);
	 vBox15.setPadding(new Insets(40));
	 vBox15.setAlignment(Pos.CENTER);
	 vBox15.getChildren().add(bttSold);
	 vBox15.getChildren().add(bttBought);
//		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
//		border.setBottom(stackBackButton);
		splitPane2.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
		splitPane2.getItems().addAll(vBox14,vBox15);
		return splitPane2;
    	
    }
public  BorderPane maagerSold3(){
	BorderPane borderPane2=new BorderPane();
	Methods.removeDuplicatesSoldTitles(name_combo,quantity_list);
	PieChart pieChart = new PieChart();
	Button backkk=new Button("Back");
	for (int i=0;i<name_combo.size();i++) {
		PieChart.Data test = new PieChart.Data(name_combo.get(i), quantity_list.get(i));
		pieChart.getData().add(test);
	}

	borderPane2.setCenter(pieChart);
	borderPane2.setPadding(new Insets(30));
	borderPane2.setTop(backkk);
	backkk.setOnAction(e->{
		backkk.getScene().setRoot(administratorMainPage());
	});
	return  borderPane2;
}
    public BorderPane managerSoldPage2(){
		BorderPane borderPane2=new BorderPane();
		Methods.removeDuplicatesSoldTitles(name_combo,quantity_list);
		PieChart pieChart = new PieChart();
		Button backkk=new Button("Back");
		for (int i=0;i<name_combo.size();i++) {
			PieChart.Data test = new PieChart.Data(name_combo.get(i), quantity_list.get(i));
			pieChart.getData().add(test);
		}

borderPane2.setCenter(pieChart);
		borderPane2.setPadding(new Insets(30));
		borderPane2.setTop(backkk);
		backkk.setOnAction(e->{
			backkk.getScene().setRoot(mangaerMainPage());
		});
		return  borderPane2;
	}
public BorderPane bought3(){

	BorderPane border = new BorderPane();

	Text text = new Text("Bought books ");
	StackPane stack = new StackPane();
	text.setFont(new Font(30));
	stack.getChildren().add(text);
	stack.setPadding(new Insets(20));
	border.setTop(stack);

	PieChart pieChart2 = new PieChart();

	for (int i=0;i<book_bought.size();i++) {
		PieChart.Data test2 = new PieChart.Data(book_bought.get(i), quantity_bought.get(i));
		pieChart2.getData().add(test2);
	}
	border.setCenter(pieChart2);
//
//
// 		Text text1 = new Text(BillNumber.getBooksBoughtDay());
// 		Text text2 = new Text(BillNumber.getBooksBoughtMonth());
// 		Text text3 = new Text(BillNumber.getBooksBoughtYear());
// 		Text text4 = new Text(BillNumber.getBooksBoughtTotal());
//
// 		GridPane grid = new GridPane();
//		grid.add(text1, 0, 0);
//		grid.add(text2, 1, 0);
//		grid.add(text3, 0, 1);
//		grid.add(text4, 1, 1);
//		grid.setHgap(50);
//		grid.setVgap(30);
//		grid.setAlignment(Pos.CENTER);
//		border.setCenter(grid);
//
// 		StackPane stackBackButton = new StackPane();
//		stackBackButton.getChildren().add(bttBackManager);
//		bttBackManager.setOnAction(event -> {
//            if(event.getSource()==bttBackManager) {
//            	bttBackManager.getScene().setRoot( managerStatisticsPage() );
//            }
//	    });
//		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
	border.setBottom(bttBackManager);
// 		creat an array list for the books bought
	return border;

}
    public BorderPane managerBoughtPage() {
    	
    	 BorderPane border = new BorderPane();
     	
     	Text text = new Text("Bought books ");
 		StackPane stack = new StackPane();
 		text.setFont(new Font(30));
 		stack.getChildren().add(text);
 		stack.setPadding(new Insets(20));
 		border.setTop(stack);

		PieChart pieChart2 = new PieChart();

		for (int i=0;i<book_bought.size();i++) {
			PieChart.Data test2 = new PieChart.Data(book_bought.get(i), quantity_bought.get(i));
			pieChart2.getData().add(test2);
		}
		border.setCenter(pieChart2);
//
//
// 		Text text1 = new Text(BillNumber.getBooksBoughtDay());
// 		Text text2 = new Text(BillNumber.getBooksBoughtMonth());
// 		Text text3 = new Text(BillNumber.getBooksBoughtYear());
// 		Text text4 = new Text(BillNumber.getBooksBoughtTotal());
//
// 		GridPane grid = new GridPane();
//		grid.add(text1, 0, 0);
//		grid.add(text2, 1, 0);
//		grid.add(text3, 0, 1);
//		grid.add(text4, 1, 1);
//		grid.setHgap(50);
//		grid.setVgap(30);
//		grid.setAlignment(Pos.CENTER);
//		border.setCenter(grid);
//
// 		StackPane stackBackButton = new StackPane();
//		stackBackButton.getChildren().add(bttBackManager);
//		bttBackManager.setOnAction(event -> {
//            if(event.getSource()==bttBackManager) {
//            	bttBackManager.getScene().setRoot( managerStatisticsPage() );
//            }
//	    });
//		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(bttBackManager);
// 		creat an array list for the books bought
 		return border;
    	
    }
    
    
    public BorderPane managerSoldPage() {
    	
        BorderPane border = new BorderPane();

    	Text text = new Text("Sold books throughout day/month/year/total");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);

		Text text1 = new Text(BillNumber.getBooksSoldDay());
		Text text2 = new Text(BillNumber.getBooksSoldMonth());
		Text text3 = new Text(BillNumber.getBooksSoldYear());
		Text text4 = new Text( BillNumber.getBooksSoldTotal());

		GridPane grid = new GridPane();
		grid.add(text1, 0, 0);
		grid.add(text2, 1, 0);
		grid.add(text3, 0, 1);
		grid.add(text4, 1, 1);
		grid.setHgap(50);
		grid.setVgap(30);
		grid.setAlignment(Pos.CENTER);
		border.setCenter(grid);

		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( managerStatisticsPage() );
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);

		return border;
    	
    }
    
    
    public BorderPane librariansAllPage() {
    	
    	BorderPane border = new BorderPane();
//		SplitPane splitPane=new SplitPane();
    	
    	Text textHeaderManager = new Text("All librarians");
		StackPane stackHeader = new StackPane();
		textHeaderManager.setFont(new Font(30));
		stackHeader.getChildren().add(textHeaderManager);
		stackHeader.setPadding(new Insets(20));
		border.setCenter(stackHeader);
		
		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBack);
		bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
               bttBack.getScene().setRoot( mangaerMainPage() );	
            }
	    });
		bttBack.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
		
		
		ArrayList<Librarian> librarians = Manager.getLibrarians();
		System.out.println(librarians);
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	int k=0;
     	int j=0;
     	
		for (int i=0;i<librarians.size();i++) {
    		if (i%5==0) {
    			k=0;
    			j++;
    		}
    			
//    		emri i buttonit do jet sipas renditjes qe jan tek librairanet
    		Button button = createButton3(librarians.get(i));
			button.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
			System.out.println("name is: "+librarians.get(i)+ "phone"+librarians.get(i).getPhone()+"salary"+librarians.get(i).moneyMadeInDay());
    		
			grid.add(button,k++,j);
			
    	}

//        splitPane.getItems().add(border,)
    	border.setCenter(grid);


		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
		return border;
    }
    
    //------------------------------------------------------------------


    private Button createButton3(Librarian lib) {
    	Button button;

    	if (lib.getName()==null)
    		button = new Button(lib.getUsername());

    	else
    		button = new Button(lib.getName());


        button.setOnAction(new ButtonHandler3(lib));
        return button ;
    }

    class ButtonHandler3 implements EventHandler<ActionEvent> {

    	private final Librarian lib;

        ButtonHandler3(Librarian lib) {
            this.lib = lib;
        }

        @Override
        public void handle(ActionEvent event) {
        	Stage stage = new Stage();
        	Scene scene = new Scene(selectLibrarianPage(lib));
        	stage.setWidth(465);
        	stage.setHeight(465);
        	stage.setScene(scene);
        	stage.show();

        }

    }


    //------------------------------------------------------------------
    
    
    public BorderPane selectLibrarianPage(Librarian lib) {
		System.out.println( lib.getNumberOfBills() );
    	BorderPane border = new BorderPane();

    	Text text;
    	if (lib.getName() == null) 
    		text = new Text("About: "+lib.getUsername());
    	else
    		text = new Text("About: "+lib.getName());

		text.setFont(Font.font("Times new roman",30));

		text.setFill(Color.rgb(47,79,79));
//		StackPane stack = new StackPane();
//		text.setFont(new Font(30));
//		stack.getChildren().add(text);
//		stack.setPadding(new Insets(20));

//		border.setTop(stack);
		Image profileimg=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\profile.PNG");
		ImageView imageViewProfile=new ImageView(profileimg);
		imageViewProfile.setFitHeight(80);
		imageViewProfile.setPreserveRatio(true);

		Image profileimg2=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\p22.PNG");
		ImageView imageViewProfile2=new ImageView(profileimg2);
		imageViewProfile2.setFitHeight(80);
		imageViewProfile2.setPreserveRatio(true);


		Image profileimg3=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\p333.PNG");
		ImageView imageViewProfile3=new ImageView(profileimg3);
		imageViewProfile3.setFitHeight(80);
		imageViewProfile3.setPreserveRatio(true);

		Image profileimg4=new Image("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\img\\p44.PNG");
		ImageView imageViewProfile4=new ImageView(profileimg4);
		imageViewProfile4.setFitHeight(80);
		imageViewProfile4.setPreserveRatio(true);

		GridPane grid = new GridPane();
//		if(lib.getUsername().equals("Ardsia"){
//
//		}
		Text salary=new Text("Money made today:");
		TextField salaryDay=new TextField();
		if(lib.getName().equals("Ardisa")){
			grid.add(imageViewProfile,0,0);
		} else if(lib.getName().equals("Julie")){
			grid.add(imageViewProfile2,0,0);
		} else if (lib.getName().equals("Leo")) {
			grid.add(imageViewProfile4,0,0);
		}
		else{
			grid.add(imageViewProfile3,0,0);

		}


		grid.add(text,0,1);
		grid.add(textTotalNumberBillsLibrarian,0,2);
		grid.add(totalNumberBillsLibrarian,1,2);

		grid.add(textBooksSold,0,3);
		grid.add(booksSold,1,3);

//		grid.add(textTotalMoneyDay,0,4);
//		grid.add(totalAmountOfMoneyMadeInDay,1,4);
		grid.add(salary,0,4);
		grid.add(salaryDay,1,4);
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
//		 --------------------
//     	grid.add(textTotalNumberBillsLibrarian, 0, 0);
//     	grid.add(totalNumberBillsLibrarian, 1, 0);
//
//     	grid.add(textBooksSold, 0, 1);
//     	grid.add(booksSold, 1, 1);
//
//     	grid.add(textTotalMoneyDay, 0, 2);
//     	grid.add(totalAmountOfMoneyMadeInDay, 1, 2);
//		 ------------------------

//     	grid.add(textTotalMoneyMonth, 0, 3);
//     	grid.add(totalAmountOfMoneyMadeInMonth, 1, 3);
     	
//     	grid.add(textTotalMoneyYear, 0, 4);

     	
     	totalNumberBillsLibrarian.setEditable(false);
     	booksSold.setEditable(false);
     	totalAmountOfMoneyMadeInDay.setEditable(false);
     	totalAmountOfMoneyMadeInMonth.setEditable(false);
     	totalAmountOfMoneyMadeInYear.setEditable(false);
     	
     	totalNumberBillsLibrarian.setText(Integer.toString(lib.getNumberOfBills()));
     	booksSold.setText(String.valueOf(total_bill));
//		booksSold.setText(Integer.toString(total_bill));
//     	totalAmountOfMoneyMadeInDay.setText(String.valueOf(234));
		salaryDay.setText(String.valueOf(lib.getSalary()));
     	totalAmountOfMoneyMadeInMonth.setText( Double.toString(lib.moneyMadeInMonth()) );

		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
     	

     	border.setCenter(grid);
    	
    	return border;
    }
    
    
    public BorderPane checkStoragePage() {
    	
    	BorderPane border = new BorderPane();
    	TableView table = new TableView();
    	TableColumn<Book,String> column1 = new TableColumn<>("ISBN");
    	TableColumn<Book,String> column2 = new TableColumn<>("Title");
    	TableColumn<Book,String> column3 = new TableColumn<>("Category");
    	TableColumn<Book,String> column4 = new TableColumn<>("Author");
    	TableColumn<Book,Double> column5 = new TableColumn<>("Original Price");
    	TableColumn<Book,Double> column6 = new TableColumn<>("Selling Price");
    	TableColumn<Book,String> column7 = new TableColumn<>("Supplier");
    	TableColumn<Book,Integer> column8 = new TableColumn<>("Stock");
    	
    	column1.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
    	column2.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
    	column3.setCellValueFactory(new PropertyValueFactory<Book,String>("category"));
    	column4.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
    	column5.setCellValueFactory(new PropertyValueFactory<Book,Double>("originalPrice"));
    	column6.setCellValueFactory(new PropertyValueFactory<Book,Double>("sellingPrice"));
    	column7.setCellValueFactory(new PropertyValueFactory<Book,String>("supplier"));
    	column8.setCellValueFactory(new PropertyValueFactory<Book,Integer>("stock"));
    	
    	table.getColumns().add(column1);
    	table.getColumns().add(column2);
    	table.getColumns().add(column3);
    	table.getColumns().add(column4);
    	table.getColumns().add(column5);
    	table.getColumns().add(column6);
    	table.getColumns().add(column7);
    	table.getColumns().add(column8);
    	
    	table.setItems(FXCollections.observableArrayList(BillNumber.getStockBooks()));
    	
    	border.setCenter(table);
    	
    	

    	Text text = new Text("Stock");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		
		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBack);
		bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
               bttBack.getScene().setRoot( mangaerMainPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(40, 0, 40, 0));
		border.setBottom(stackBackButton);
		
		border.setTop(stack);
    
    	return border;
    	
    }
    
    
    public BorderPane ManagerSupplyCickPage() {
    	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("ADD BOOKS");
		text.setFont(Font.font("Times new roman",30));
		text.setFill(Color.rgb(47,79,79));
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
    	
		GridPane supplyPageGrid = new GridPane();
		supplyPageGrid.setHgap(5);
		supplyPageGrid.setVgap(5);
//		supplyPageGrid.add(bttAddStock, 0, 0);
		Label book12=new Label("Book Title");
//		TextField bookfield12=new TextField();
//		book_bought.add(bookfield12.getText());



		Label isbn12=new Label("Isbn:");
		TextField isbnfiled12=new TextField();

		Label author12=new Label("Author:");
		ChoiceBox authorbox12=new ChoiceBox(FXCollections.observableArrayList(Methods.getAuthors()));

//		TextField authoriled12=new TextField();

		Label stock212=new Label("Category");
//		TextField stcokfield212=new TextField();
//		int xx= Integer.parseInt(stcokfield212.getText());
//		quantity_bought.add(xx);
//		quantity_bought.add(Integer.valueOf(stcokfield212.getText()));


		Label supplier12=new Label("Suppiler:");
		TextField supplierfiled12=new TextField();

		Label org_price12=new Label("Original Price");
		TextField orgfield12=new TextField();

		Label sell_price12=new Label("Selling Price");
		TextField sellfiled12=new TextField();



//		Label priceor=new Label("category");
//		TextField catfield=new TextField();
		Label category12=new Label("Stock");
		ChoiceBox menunewCategory12=new ChoiceBox(FXCollections.observableArrayList(Methods.getAllCategories()));

        Button addmore=new Button("Add");
		addmore.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		supplyPageGrid.add(book12,0,0);
		supplyPageGrid.add(bookfield12,1,0);
		supplyPageGrid.add(isbn12,0,1);
		supplyPageGrid.add(isbnfiled12,1,1);

		supplyPageGrid.add(author12,0,2);
		supplyPageGrid.add(authorbox12,1,2);

		supplyPageGrid.add(supplier12,0,4);
		supplyPageGrid.add(supplierfiled12,1,4);
		supplyPageGrid.add(menunewCategory12,1,7);
		supplyPageGrid.add(org_price12,0,5);
		supplyPageGrid.add(orgfield12,1,5);
		supplyPageGrid.add(sell_price12,0,6);
		supplyPageGrid.add(sellfiled12,1,6);
		supplyPageGrid.add(stock212,0,7);
		supplyPageGrid.add(stcokfield212,1,3);
//		supplyPageGrid.add(bttNewCategory, 0, 5);

		supplyPageGrid.add(category12,0,3);
		supplyPageGrid.add(bttBack, 1,9);
		supplyPageGrid.add(addmore,0,9);

		final int[] k = {0};
		addmore.setOnAction(
				e->{
					k[0]++;
                 book_bought.add(bookfield12.getText());
				 quantity_bought.add(Integer.valueOf(stcokfield212.getText()));
//					try {
////						book = new Book(isbnstock.get(i),tiltestock.get(i),categorystock.get(i),supplierstock.get(i),orpricestock.get(i),sellstock.get(i),stockstock.get(i));
//
////						Book(String ISBN, String title, String category, String supplier, double originalPrice, double sellingPrice,String author, int stock){
//
//							BillNumber.setStock2(isbnstock,titlestock,categorystock,supplierstock,orpricestock,sellstock,authorstock,stockstock);
//					} catch (IOException ex) {
//						throw new RuntimeException(ex);
//					}

//
//				duhet ta shkruaj ne nje binary file
//
					FileOutputStream out = null;
					try {
						out = new FileOutputStream("Books.txt");
					} catch (FileNotFoundException ex) {
						throw new RuntimeException(ex);
					}
					ObjectOutputStream objout = null;
					try {
						objout = new ObjectOutputStream(out);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}

					Book book = new Book(isbnfiled12.getText(),bookfield12.getText(),category12.getText(),"adfad",65.00,73.96,"Marcel Proust",5);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}

					book = new Book("0096184570112","HarryPotter","ficiotn","adfad",65.00,73.96,"Marcel Proust",5);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}

					book = new Book("0096184570112","Divergent","adventure","Ingram Content Group, Inc",65.00,73.96,"Marcel Proust",5);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
					book = new Book("0096184570112","Hamlet","literature","Ingram Content Group, Inc",65.00,73.96,"Marcel Proust",5);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
					book = new Book("4647500268094","Biology","science","university of france",15.00,18.00,"James Joyce",2);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
					book = new Book("0096184570112","Divergent","adventure","Ingram Content Group, Inc",65.00,73.96,"Marcel Proust",5);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
					book = new Book("0096184570112","Hamlet","literature","Ingram Content Group, Inc",65.00,73.96,"Marcel Proust",5);
					try {
						objout.writeObject(book);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}






				}
		);

//		bttAddStock.setOnAction(this);
		bttNewCategory.setOnAction(this);
		bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
               bttBack.getScene().setRoot(mangaerMainPage());	
            }
	    });
		bttBack.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		supplyPageGrid.setAlignment(Pos.CENTER);
        border.setCenter(supplyPageGrid);

		supplyPageGrid.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
    	return border;
    }
    
    public BorderPane chooseNewCategoryAddStock() {
    	
    	ChoiceBox menuNewCategory = new ChoiceBox(FXCollections.observableArrayList(Manager.getAllCategories()));
    	   	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("Add new Book Category");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		TextField textAddCategoryWarning = new TextField();
		textAddCategoryWarning.setEditable(false);
		
		Button bttAddCategory = new Button("Add");
		bttBack = new Button("Back");
		
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	grid.add(textCategory, 0, 0);
     	grid.add(menuNewCategory, 1, 0);
     	grid.add(bttBack, 0, 5);
     	grid.add(textSystem, 0, 4);
     	grid.add(textAddCategoryWarning, 1, 4);
     	grid.add(bttAddCategory, 2, 5);
     	border.setCenter(grid);
     	
     	bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
            	bttBack.getScene().setRoot( ManagerSupplyCickPage()  );	
            }
	    });
     	
     	bttAddCategory.setOnAction(event -> {

     		if (event.getSource()==bttAddCategory) {



     			if (menuNewCategory.getSelectionModel().getSelectedItem().toString().isEmpty()) {
     				textAddCategoryWarning.setText("Failed, Empty field");
     				return;
     			}

     			if (category.getCharacters().toString().matches("\\d{1,}")) {
     				textAddCategoryWarning.setText("Failed, Invalid Category");
     				return;
     			}
     			if (BillNumber.partOfCateogriesChecker(categ,menuNewCategory.getSelectionModel().getSelectedItem().toString())) {
     				textAddCategoryWarning.setText("Failed, Not New");
     				return;
     			}



     			String bcateg = menuNewCategory.getSelectionModel().getSelectedItem().toString();
     			categ.add(bcateg);
     			textAddCategoryWarning.setText("Added!");
     			
     			
     		}
     		
     		
     	});
     	
     	
     	
		return border;
    	
    	
    }
    
    public BorderPane chooseAddCurretStock() {
    	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("Choose category to add");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		
		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( ManagerSupplyCickPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
		
		
		categ = BillNumber.removeDuplicates(categ);
		
        
        GridPane grid = new GridPane();
     	grid.setHgap(5);
     	grid.setVgap(5);
     	int j=0;
     	int k=0;
    	
    	for (int i=0;i<categ.size();i++) {
    		if (i%5==0) {
    			k=0;
    			j++;
    		}
    			
    		
    		Button button = createButton(categ.get(i));
    		
			grid.add(button,k++,j);
			
    	}
    	
    	
    	
    	grid.setAlignment(Pos.CENTER);
    	border.setCenter(grid);
    	
    	
    	return border;
    }
    
    
    //----------------------------------------------------------------------------
    
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setOnAction(new ButtonHandler(button.getText()));
        return button ;
    }
    
    class ButtonHandler implements EventHandler<ActionEvent> {
    	
        private final String text;
        
        ButtonHandler(String text) {
            this.text = text ;
        }
        
        @Override
        public void handle(ActionEvent event) {
        	Stage stage = new Stage();
        	Scene scene = new Scene(categoryStock(text));
        	stage.getIcons().add(new Image("C:\\Users\\User\\eclipse-workspace\\JavaFx\\src\\project\\Images\\bookIcon.png"));
        	stage.setWidth(465);
        	stage.setHeight(465);
        	stage.setScene(scene);
        	stage.show();
        	
        }

    }
    //-----------------------------------------------------------------------
    
    
    public BorderPane categoryStock(String category) {
    	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("Choose Book to add");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		
		ArrayList<Book> books = BillNumber.getBookFromCategory(category);
		GridPane grid = new GridPane();
     	grid.setHgap(5);
     	grid.setVgap(5);
     	int j=0;
     	int k=0;
		
     	if (books.isEmpty()) {}
     	else {
     		for (int i=0;i<books.size();i++) {
        		if (i%5==0) {
        			k=0;
        			j++;
        		}
        		Button button = createButton2(books.get(i));
        		
    			grid.add(button,k++,j);
    			
        	}
     	}
		
		grid.add(bttNewBook, k++, j);
		grid.setAlignment(Pos.CENTER);
    	border.setCenter(grid);
    	
    	bttNewBook.setOnAction(event -> {
			
            if(event.getSource()==bttNewBook) {
            	bookISBN.clear();
     		    title.clear();
     		    supplier.clear();
     		    originalPrice.clear();
     		    sellingPrice.clear();
     		    author.clear();
     		    quantity.clear();
            	
            	
            	bttNewBook.getScene().setRoot( stockCategoryNewBookPage(category) );
            }
   
            
 	    });
    	
    	
    	return border;
    	
    	
    }
    
    //-------------------------------------------------------------------
    
    private Button createButton2(Book book) {
        Button button = new Button(book.getTitle());
        button.setOnAction(new ButtonHandler2(book));
        return button ;
    }
    
    class ButtonHandler2 implements EventHandler<ActionEvent> {
    	
    	private final Book book;
    	
        ButtonHandler2(Book book) {
            this.book = book;
        }
        
        @Override
        public void handle(ActionEvent event) {
        	Stage stage = new Stage();
        	Scene scene = new Scene(stockBookPage(book));
        	stage.getIcons().add(new Image("C:\\Users\\User\\eclipse-workspace\\JavaFx\\src\\project\\Images\\bookIcon.png"));
        	stage.setWidth(465);
        	stage.setHeight(465);
        	stage.setScene(scene);
        	stage.show();
        	
        }

    }
    
    //-------------------------------------------------------------------
    
    
    public BorderPane stockBookPage(Book book) {
    	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("Add \""+book.getTitle()+"\" To stock");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		
		
		GridPane grid = new GridPane();
     	grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	grid.add(textQuantity, 0, 0);
     	grid.add(quantity, 1, 0);
     	grid.add(bttAddBookToStock,2, 4);
     	grid.add(addedOrNot, 1, 3);
     	grid.add(textSystem, 0, 3);
    	border.setCenter(grid);
    	
		
    	addedOrNot.setEditable(false);
		bttAddBookToStock.setOnAction(event -> {
			
            if(event.getSource()==bttAddBookToStock) {
            	
            	if(!quantity.getCharacters().toString().matches("\\d{1,}")){
    				addedOrNot.setText("Failed, Invalid Quantity");
    				return;
    			}
    			
    			if (quantity.getCharacters().toString().isEmpty()) {
    				addedOrNot.setText("Failed, Empty Quantity");
    				return;
    			}
    			
    		    ArrayList<Book> stockbooks = BillNumber.getStockBooks();
    		    
    		    for (int i=0;i<stockbooks.size();i++) {
    		    	if (stockbooks.get(i).getISBN().equals(book.getISBN())) {
    		    		
    		    		stockbooks.get(i).AddStock(Integer.parseInt(quantity.getCharacters().toString()));
    		    		stockbooks.get(i).addPurchasedDate(new Date());
    		    		stockbooks.get(i).addQuantitiesPurchased(Integer.parseInt(quantity.getCharacters().toString()));
    		    	}    		    	   
    		    }
    		    
    		    try {
					BillNumber.updateBooks(stockbooks);
				} catch (IOException e) {
					e.printStackTrace();
				}
    		    
    		    quantity.clear();
    		    
    		    addedOrNot.setText("Added");
             }
            
 	    });
    	
    	
    	
    	return border;
    	
    	
    }
    
    
    public BorderPane stockCategoryNewBookPage(String category) {
    	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("Add book to "+category+" category");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		GridPane gridSupplier = new GridPane();
		ToggleGroup Supplier = new ToggleGroup();
		RadioButton r1 = new RadioButton("Ingram Content Group, Inc");
	    RadioButton r2 = new RadioButton("Baker & Taylor");
        RadioButton r3 = new RadioButton("BCH Fulfillment & Distribution");
        RadioButton r4 = new RadioButton("Cardinal Publishers Group");
        RadioButton r5 = new RadioButton("Bella Distribution");
        RadioButton r6 = new RadioButton("Publishers Group West");
	    r1.setToggleGroup(Supplier);
	    r2.setToggleGroup(Supplier);
	    r3.setToggleGroup(Supplier);
	    r4.setToggleGroup(Supplier);
	    r5.setToggleGroup(Supplier);
	    r6.setToggleGroup(Supplier);
	    gridSupplier.add(r1, 0, 0);
	    gridSupplier.add(r2, 1, 0);
	    gridSupplier.add(r3, 1, 2);
	    gridSupplier.add(r4, 0, 1);
	    gridSupplier.add(r5, 0, 2);
	    gridSupplier.add(r6, 1, 1);
	    gridSupplier.setHgap(5);
	    gridSupplier.setVgap(5);
	  
	       
	 
		
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	grid.add(textBookISBN, 0, 0);
     	grid.add(bookISBN, 1, 0);
     	grid.add(textTitle,0, 1);
     	grid.add(title, 1, 1);
     	grid.add(textSupplier, 0, 2);
     	grid.add(gridSupplier, 1, 2);
     	grid.add(textOriginalPrice, 0, 3);
     	grid.add(originalPrice, 1, 3);
     	grid.add(textSellingPrice,0,4);
     	grid.add(sellingPrice, 1, 4);
     	grid.add(textAuthor, 0, 5);
     	grid.add(author, 1, 5);
     	grid.add(textQuantity, 0, 6);
     	grid.add(quantity, 1, 6);
     	grid.add(textSystem, 0, 9);
     	grid.add(addedOrNotStockCategory, 1, 9);
     	grid.add(stockCategoryAddBook, 2, 10);
     	grid.add(bttBack, 0, 10);
     	
     	
     	addedOrNotStockCategory.setEditable(false);
     	bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
            	bttBack.getScene().setRoot( categoryStock(category) );
            }
            
 	    });
     	stockCategoryAddBook.setOnAction(event -> {
            if(event.getSource()==stockCategoryAddBook) {
            	
            	RadioButton chk = (RadioButton)Supplier.getSelectedToggle(); 

    			if (bookISBN.getCharacters().toString().isEmpty() || title.getCharacters().toString().isEmpty() || Supplier.getSelectedToggle() == null
    					|| originalPrice.getCharacters().toString().isEmpty() || sellingPrice.getCharacters().toString().isEmpty() || author.getCharacters().toString().isEmpty()
    					|| quantity.getCharacters().toString().isEmpty()) {
    				addedOrNotStockCategory.setText("Failed, Empty Fields");
    				return;
    			}
    			
    			if (!bookISBN.getCharacters().toString().matches("\\d{13}")) {
    				addedOrNotStockCategory.setText("Failed, Invalid ISBN");
    				return;
    			}
    			
    			if ( !(quantity.getCharacters().toString().matches("\\d{1,}")) || !(originalPrice.getCharacters().toString().matches("\\d{1,}")) 
    					|| !(sellingPrice.getCharacters().toString().matches("\\d{1,}")) ||  Integer.parseInt(sellingPrice.getCharacters().toString())==0 
    					|| Integer.parseInt(originalPrice.getCharacters().toString()) == 0 || Integer.parseInt(quantity.getCharacters().toString()) == 0) {
    				
    				addedOrNotStockCategory.setText("Failed, Invalid Numbers");
    				return;
    			}
    			
    			if (BillNumber.isPartOfBooks(bookISBN.getCharacters().toString())){
    				addedOrNotStockCategory.setText("Failed, Already In Stock");
    				return;
    				
    			}
    			
    			String bIsbn = bookISBN.getCharacters().toString();
    			String bTitle = title.getCharacters().toString();
    			String bSupplier = chk.getText();
    			int bSellingPrice = Integer.parseInt(sellingPrice.getCharacters().toString());
    			int bOriginalPrice = Integer.parseInt(originalPrice.getCharacters().toString());
    			String bAuthor = author.getCharacters().toString();
    			int bStock = Integer.parseInt(quantity.getCharacters().toString());
    			
    		    Book book = new Book(bIsbn,bTitle,category,bSupplier,bOriginalPrice,bSellingPrice,bAuthor,bStock);
    		    book.addQuantitiesPurchased(bStock);
    		    date = new Date();
    		    book.addPurchasedDate(date);
            	
    		    ArrayList<Book> stockbooks = BillNumber.getStockBooks();
    		    stockbooks.add(book);
    		    try {
					BillNumber.updateBooks(stockbooks);
				} catch (IOException e) {}
    		    
    		    bookISBN.clear();
    		    title.clear();
    		    Supplier.getSelectedToggle().setSelected(false);
    		    originalPrice.clear();
    		    sellingPrice.clear();
    		    author.clear();
    		    quantity.clear();
    		    
    		    
    		    addedOrNotStockCategory.setText("Added");
    		    
            }
            
 	    });
     	
     	border.setCenter(grid);
		
		
    	
    	return border;
    }
    
    //------------------------------------------------------------------------Administrator--------------------------------------------------------------------------
    
    public BorderPane administratorLoginPage() {
    	
    	
    	BorderPane border = new BorderPane();
    	
    	
    	StackPane stackTextAdministrator = new StackPane();
		Text textAdministrator = new Text("Administrator Login");
		textAdministrator.setFont(new Font(30));
		stackTextAdministrator.getChildren().add(textAdministrator);
		stackTextAdministrator.setPadding(new Insets(20));
		border.setTop(stackTextAdministrator);
		
		admLoginWarning.setEditable(false);
		GridPane gridAdministratorLogin = new GridPane();
		gridAdministratorLogin.setAlignment(Pos.CENTER);
		gridAdministratorLogin.setHgap(5);
	    gridAdministratorLogin.setVgap(5);
	    gridAdministratorLogin.add(textUsername,0,1);
	    gridAdministratorLogin.add(username,1,1);
	    gridAdministratorLogin.add(textPassword,0,2);
	    gridAdministratorLogin.add(password,1,2);
	    gridAdministratorLogin.add(textSystem, 0, 5);
	    gridAdministratorLogin.add(admLoginWarning, 1, 5);
	    gridAdministratorLogin.add(bttSubmit, 6, 6);
	    gridAdministratorLogin.add(bttBack, 0, 6);
	    border.setCenter(gridAdministratorLogin);
	    
	    bttSubmit.setOnAction(event -> {
	    	
             if (username.getCharacters().toString().isEmpty() || password.getCharacters().toString().isEmpty()) {
				admLoginWarning.setText("Empty Fields");
				return;
			}
             
            String user = username.getCharacters().toString();
 			String pass = password.getCharacters().toString();
 			
 			administrator = new Administrator(user,pass);
 			if (!(Administrator.checker(user, pass))) {
 				admLoginWarning.setText("Wrong Information");
				username.clear();
				password.clear();
				return;
 			}
 			bttSubmit.getScene().setRoot(administratorMainPage());
 			
	    });
	    
	    bttBack.setOnAction(event -> {
	    	
	         bttBack.getScene().setRoot(mainPage());
	    	
	    });
	    
    	
    	return border;
    	
    }
    
    
    public BorderPane administratorMainPage() {
    	BorderPane border = new BorderPane();
    	
    	
    	Text text = new Text("Administrator");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		Button bttManageManager = new Button("Manage Managers");
		Button bttManageLibrarians = new Button("Manage Librarians");
		Button bttStats = new Button("Stats");

		Button addlib=new Button("add librarians");
		Button addmanager=new Button("add manager");
		Button charts=new Button("Charts");
		charts.setOnAction(e->{
			charts.getScene().setRoot(chart());
		});
		charts.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
	    grid.setVgap(5);
	    grid.add(bttManageLibrarians, 0, 0);
	    grid.add(bttManageManager, 1, 0);
//	    grid.add(bttStats, 2, 0);
		grid.add(addlib,0,1);
		grid.add(addmanager,1,1);
		grid.add(charts,2,1);
	    grid.add(bttBack, 2, 0);

	    border.setCenter(grid);
	    addlib.setOnAction(event->{
			addlib.getScene().setRoot(addLibrarian());
		});
		addlib.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");

		addmanager.setOnAction(event->{
			addmanager.getScene().setRoot(addManager());
		});
		addmanager.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");

		bttManageLibrarians.setOnAction(event ->{
	    	if (event.getSource() == bttManageLibrarians) {
//	    		bttManageLibrarians.getScene().setRoot(administratorManageLibrariansPage());
				bttManageLibrarians.getScene().setRoot(administratorManageLibrariansPage());
//				bttManageLibrarians.getScene().setRoot(librariansAllPage());

			}
	    });
		bttManageLibrarians.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");


		bttManageManager.setOnAction(event ->{
	    	bttManageManager.getScene().setRoot(administratorManagerPage());
	    });
		bttManageManager.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");


		bttStats.setOnAction(event ->{
	    	bttStats.getScene().setRoot(administratorCostPage());
	    });

	    
	    bttBack.setOnAction(event-> {
	    	if (event.getSource() == bttBack) {
	    		username.clear();
	    		password.clear();
	    		bttBack.getScene().setRoot(mainPage());
	    	}
	    });
		bttBack.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
    	
    	return border;
    }
    
    public BorderPane administratorManageLibrariansPage(){
//
//        BorderPane border = new BorderPane();
//
//    	Text textHeaderManager = new Text("Selectt Librarians");
//		StackPane stackHeader = new StackPane();
//		textHeaderManager.setFont(new Font(30));
//		stackHeader.getChildren().add(textHeaderManager);
//		stackHeader.setPadding(new Insets(20));
//		border.setTop(stackHeader);
//
//		StackPane stackBackButton = new StackPane();
//		stackBackButton.getChildren().add(bttBack);
//		bttBack.setOnAction(event -> {
//            if(event.getSource()==bttBack) {
//               bttBack.getScene().setRoot( administratorMainPage() );
//            }
//	    });
//		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
//		border.setBottom(stackBackButton);
//
//		Button bttAddNew = new Button("Add New");
//		ArrayList<Librarian> librarians = Manager.getLibrarians();
//
//		GridPane grid = new GridPane();
//		grid.setHgap(5);
//     	grid.setVgap(5);
//     	grid.setAlignment(Pos.CENTER);
//     	int k=0;
//     	int j=0;
//
//		for (int i=0;i<librarians.size();i++) {
//    		if (i%5==0) {
//    			k=0;
//    			j++;
//
//    		}
//
//
//    		Button button = createButton4(librarians.get(i));
//
//			grid.add(button,k++,j);
//
//    	}
//		grid.add(bttAddNew, k, j);
//    	border.setCenter(grid);
//
//    	bttAddNew.setOnAction(event-> {
//    		bttAddNew.getScene().setRoot(addLibrarian());
//    	});
//
//
//    	return border;


		BorderPane border = new BorderPane();
//		SplitPane splitPane=new SplitPane();

		Text textHeaderManager = new Text("Manage Librarians");
		StackPane stackHeader = new StackPane();
		textHeaderManager.setFont(new Font(30));
		stackHeader.getChildren().add(textHeaderManager);
		stackHeader.setPadding(new Insets(20));
		border.setCenter(stackHeader);

		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBack);
		bttBack.setOnAction(event -> {
			if(event.getSource()==bttBack) {
				bttBack.getScene().setRoot( administratorMainPage() );
			}
		});
		bttBack.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);


		ArrayList<Librarian> librarians = Manager.getLibrarians();
		System.out.println(librarians);
		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		int k=0;
		int j=0;

		for (int i=0;i<librarians.size();i++) {
			if (i%5==0) {
				k=0;
				j++;
			}

//    		emri i buttonit do jet sipas renditjes qe jan tek librairanet
			Button button = createButton3(librarians.get(i));
			button.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
			System.out.println("name is: "+librarians.get(i)+ "phone"+librarians.get(i).getPhone()+"salary"+librarians.get(i).moneyMadeInDay());

			grid.add(button,k++,j);

		}

//        splitPane.getItems().add(border,)
		border.setCenter(grid);


		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
		return border;
    }
    
    //-----------------------------------------------
    
    private Button createButton4(Librarian lib) {
    	Button button;
  
    	if (lib.getName()==null) 
    		button = new Button(lib.getUsername());
    	
    	else 
    		button = new Button(lib.getName());
    	
        
//        button.setOnAction(new ButtonHandler4(lib));
		button.setOnAction(e->{
			lib.getPhone();
			System.out.println(lib.getUsername()+lib.getPhone());
		});
        return button ;
    }
    
    class ButtonHandler4 implements EventHandler<ActionEvent> {
    	
    	private final Librarian lib;
    	
        ButtonHandler4(Librarian lib) {
            this.lib = lib;
        }
        
        @Override
        public void handle(ActionEvent event) {
        	Stage stage = new Stage();
        	Scene scene = new Scene(editLibrarianPage(lib));
        	stage.getIcons().add(new Image("C:\\Users\\User\\eclipse-workspace\\JavaFx\\src\\project\\Images\\bookIcon.png"));
        	stage.setWidth(465);
        	stage.setHeight(465);
        	stage.setScene(scene);
        	stage.show();
        	
        }

    }
    
    //-------------------------------------------------
    
    
    public BorderPane addLibrarian() {
    	
        BorderPane border = new BorderPane();
    	
    	Text text = new Text("Add new Librarian");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		TextField name = new TextField();
		Text textName = new Text("Name");
		TextField salary = new TextField();
		Text textSalary = new Text("Salary");
		TextField phone = new TextField();
		Text textPhone = new Text("Phone");
		TextField email = new TextField();
		Text textEmail = new Text("Email");
		TextField username = new TextField();
		Text textUsername = new Text("Username");
		TextField password = new TextField();
		Text textPassword = new Text("Password");
		Button bttAdd = new Button("Submitx");
		Button bttBack = new Button("Back");
		TextField libWarningNew = new TextField();
		
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	grid.add(textName,0,0);
	    grid.add(name,1,0);
	    grid.add(textPassword,0,1);
	    grid.add(password,1,1);
	    grid.add(textUsername,0,2);
	    grid.add(username, 1, 2);
	    grid.add(textSalary, 0, 3);
	    grid.add(salary, 1, 3);
	    grid.add(textPhone, 0, 4);
	    grid.add(phone, 1, 4);
	    grid.add(textEmail, 0, 5);
	    grid.add(email, 1, 5);
//	    grid.add(textSystem, 0, 8);
//	    grid.add(libWarningNew, 1, 8);
	    grid.add(bttAdd, 3, 9);
	    grid.add(bttBack, 0, 9);
	    border.setCenter(grid);
	    
	    bttBack.setOnAction(event -> {
	    	bttBack.getScene().setRoot(administratorMainPage());
	    });
	    
	    bttAdd.setOnAction(event -> {


//
//			librarian = new Librarian( username.getCharacters().toString(), password.getCharacters().toString(), name.getCharacters().toString(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
//					email.getCharacters().toString());
//
//
//			Manager.AddLibrarian(librarian);
//	    	libWarningNew.setText("Succes!");
			librarian = new Librarian( username.getCharacters().toString(), password.getCharacters().toString(), name.getCharacters().toString(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
					email.getCharacters().toString());

			Manager.AddLibrarian(librarian);
			libWarningNew.setText("Succes!");

//			try {
//				FileWriter writer=new FileWriter("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\USERS\\lib2.txt");
//				writer.write(textUsername.getText());
//				writer.write(textPassword.getText());
//				writer.close();
//
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
			username.clear();
	    	name.clear();
	    	password.clear();
	    	salary.clear();
	    	phone.clear();
	    	email.clear();
		});
		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
	    return border;
		
		
    	
    }
    
    public BorderPane editLibrarianPage(Librarian lib) {
    	
    	BorderPane border = new BorderPane();
    	
    	Text text = new Text("Edit Librarian");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		libLoginWarning.clear();
		
		TextField name = new TextField();
		Text textName = new Text("Name");
		TextField salary = new TextField();
		Text textSalary = new Text("Salary");
		TextField phone = new TextField();
		Text textPhone = new Text("Phone");
		TextField email = new TextField();
		Text textEmail = new Text("Email");
		TextField username = new TextField();
		Text textUsername = new Text("Username");
		TextField password = new TextField();
		Text textPassword = new Text("Password");
		Button bttSubmit = new Button("Submit");
		Button bttDelete = new Button("Delete");
		
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	grid.add(textName,0,0);
	    grid.add(name,1,0);
	    grid.add(textPassword,0,1);
	    grid.add(password,1,1);
	    grid.add(textUsername,0,2);
	    grid.add(username, 1, 2);
	    grid.add(textSalary, 0, 3);
	    grid.add(salary, 1, 3);
	    grid.add(textPhone, 0, 4);
	    grid.add(phone, 1, 4);
	    grid.add(textEmail, 0, 5);
	    grid.add(email, 1, 5);
	    grid.add(textTotalNumberBillsLibrarian, 2, 0);
	    grid.add(totalNumberBillsLibrarian, 3, 0);
	    grid.add(textBooksSold, 2, 1);
	    grid.add(booksSold, 3, 1);
	    grid.add(textTotalMoneyDay, 2, 2);
	    grid.add(totalAmountOfMoneyMadeInDay, 3, 2);
	    grid.add(textTotalMoneyMonth, 2, 3);
	    grid.add(totalAmountOfMoneyMadeInMonth, 3, 3);	    
     	grid.add(textTotalMoneyYear, 2, 4);
     	grid.add(totalAmountOfMoneyMadeInYear, 3, 4);
     	grid.add(textSystem, 0, 8);
     	grid.add(libLoginWarning, 1, 8);
     	
     	HBox hbox = new HBox();
     	hbox.getChildren().addAll(bttSubmit,bttDelete);
     	hbox.setAlignment(Pos.CENTER);
     	hbox.setSpacing(5);
     	hbox.setPadding(new Insets(0,0,20,0));
     	border.setBottom(hbox);
     	
     	totalNumberBillsLibrarian.setEditable(false);
     	booksSold.setEditable(false);
     	totalAmountOfMoneyMadeInDay.setEditable(false);
     	totalAmountOfMoneyMadeInMonth.setEditable(false);
     	totalAmountOfMoneyMadeInYear.setEditable(false);
     	libLoginWarning.setEditable(false);
  	
     	totalNumberBillsLibrarian.setText(Integer.toString(lib.getNumberOfBills()));
     	booksSold.setText(Integer.toString(lib.getBooksSold()));
     	totalAmountOfMoneyMadeInDay.setText( Double.toString(lib.moneyMadeInDay()) );
     	totalAmountOfMoneyMadeInMonth.setText( Double.toString(lib.moneyMadeInMonth()) );
     	totalAmountOfMoneyMadeInYear.setText( Double.toString(lib.moneyMadeInYear()) );
	    
	    name.setEditable(false);
	    name.setText(lib.getName());
	    username.setText(lib.getUsername());
	    password.setText(lib.getPassword());
	    salary.setText(Double.toString(lib.getSalary()));
	    email.setText(lib.getEmail());
	    phone.setText(lib.getPhone());
	    
	    bttDelete.setOnAction(event ->{
	    	
	    	if (password.getCharacters().isEmpty() || username.getCharacters().isEmpty() || salary.getCharacters().isEmpty() || phone.getCharacters().isEmpty() || email.getCharacters().isEmpty()) {
	    		libLoginWarning.setText("Empty Fields");
	    		return;
	    	}
	    	
	    	
	    	if (!(Librarian.checkEmail(email.getCharacters().toString()))) {
	    		email.clear();
	    		libLoginWarning.setText("Invalid Email");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkPassword(password.getCharacters().toString()))) {
	    		password.clear();
	    		libLoginWarning.setText("Invalid Password");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkPhone(phone.getCharacters().toString()))) {
	    		phone.clear();
	    		libLoginWarning.setText("Invalid Phone Number");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkSalary(salary.getCharacters().toString()))) {
	    		salary.clear();
	    		libLoginWarning.setText("Invalid Salary");
	    		return;
	    	}
	    	
	    	librarian = new Librarian( username.getCharacters().toString(), password.getCharacters().toString(), lib.getName(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
	    			email.getCharacters().toString());
	    	
	    	Manager.deleteLibrarian(librarian);
	    	username.clear();
	    	name.clear();
	    	password.clear();
	    	salary.clear();
	    	phone.clear();
	    	email.clear();
	    	totalNumberBillsLibrarian.clear();
	    	booksSold.clear();
	    	totalAmountOfMoneyMadeInDay.clear();
	    	totalAmountOfMoneyMadeInMonth.clear();
	    	totalAmountOfMoneyMadeInYear.clear();
	    	libLoginWarning.setText("Deleted Succesfully!");
	    	
	    	
	    	
	    });
	    
	    bttSubmit.setOnAction(event ->{
	    	
	    	if (password.getCharacters().isEmpty() || username.getCharacters().isEmpty() || salary.getCharacters().isEmpty() || phone.getCharacters().isEmpty() || email.getCharacters().isEmpty()) {
	    		libLoginWarning.setText("Empty Fields");
	    		return;
	    	}
	    	
	    	
	    	if (!(Librarian.checkEmail(email.getCharacters().toString()))) {
	    		email.clear();
	    		libLoginWarning.setText("Invalid Email");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkPassword(password.getCharacters().toString()))) {
	    		password.clear();
	    		libLoginWarning.setText("Invalid Password");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkPhone(phone.getCharacters().toString()))) {
	    		phone.clear();
	    		libLoginWarning.setText("Invalid Phone Number");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkSalary(salary.getCharacters().toString()))) {
	    		salary.clear();
	    		libLoginWarning.setText("Invalid Salary");
	    		return;
	    	}
	    	
	    	librarian = new Librarian( username.getCharacters().toString(), password.getCharacters().toString(), lib.getName(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
	    			email.getCharacters().toString());
	    	
	    	
	    	Manager.updateLibrarians(librarian);
	    	libLoginWarning.setText("Success!");    	
	    	
	    });
	    
	    
	    
	    border.setCenter(grid);
    	
    	return border;
    }
    
    
    public BorderPane administratorManagerPage() {
    	
        BorderPane border = new BorderPane();
    	
    	Text text = new Text("Select Manager");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBack);
		bttBack.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");

		bttBack.setOnAction(event -> {
            if(event.getSource()==bttBack) {
               bttBack.getScene().setRoot( administratorMainPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
		
		Button bttAddNew = new Button("Add New");
		bttAddNew.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");


		ArrayList<Manager> managers = Administrator.getManagers();
		
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	int k=0;
     	int j=0;
     	
		for (int i=0;i<managers.size();i++) {
    		if (i%5==0) {
    			k=0;
    			j++;
    		}
    			
    		
    		Button button = createButton5(managers.get(i));
			button.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
			grid.add(button,k++,j);
			
    	}
		grid.add(bttAddNew, k, j);
    	border.setCenter(grid);
    	
//    	bttAddNew.setOnAction(event-> {
//    		bttAddNew.getScene().setRoot(addManager());
//    	});

		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
		
		return border;
    	
    }
    
    
    //----------------------------------------------------------------------
    
    
    private Button createButton5(Manager mag) {
    	Button button;
  
 
   		button = new Button(mag.getName());
    	
        
        button.setOnAction(new ButtonHandler5(mag));
        return button ;
    }
    
    class ButtonHandler5 implements EventHandler<ActionEvent> {
    	
    	private final Manager mag;
    	
        ButtonHandler5(Manager mag) {
            this.mag = mag;
        }
        
        @Override
        public void handle(ActionEvent event) {
        	Stage stage12 = new Stage();
        	Scene scene = new Scene( editManagerPage(mag) );
//        	stage12.getIcons().add(new Image("C:\\Users\\User\\eclipse-workspace\\JavaFx\\src\\project\\Images\\bookIcon.png"));
        	stage12.setWidth(465);
        	stage12.setHeight(465);
        	stage12.setScene(scene);
        	stage12.show();
        	
        }

    }
    
    //---------------------------------------------------------------------
    
    
    public BorderPane addManager() {
    	
//
//        BorderPane border = new BorderPane();
//
//    	Text text = new Text("Add new Manager");
//		StackPane stack = new StackPane();
//		text.setFont(new Font(30));
//		stack.getChildren().add(text);
//		stack.setPadding(new Insets(20));
//		border.setTop(stack);
//
//		TextField name = new TextField();
//		Text textName = new Text("Name");
//		TextField salary = new TextField();
//		Text textSalary = new Text("Salary");
//		TextField phone = new TextField();
//		Text textPhone = new Text("Phone");
//		TextField email = new TextField();
//		Text textEmail = new Text("Email");
//		TextField username = new TextField();
//		Text textUsername = new Text("Username");
//		TextField password = new TextField();
//		Text textPassword = new Text("Password");
//		Button bttAdd = new Button("Submit");
//		Button bttBack = new Button("Back");
//		TextField magWarningNew = new TextField();
//
//		GridPane grid = new GridPane();
//		grid.setHgap(5);
//     	grid.setVgap(5);
//     	grid.setAlignment(Pos.CENTER);
//     	grid.add(textName,0,0);
//	    grid.add(name,1,0);
//	    grid.add(textUsername,0,1);
//	    grid.add(username,1,1);
//	    grid.add(textPassword,0,2);
//	    grid.add(password, 1, 2);
//	    grid.add(textSalary, 0, 3);
//	    grid.add(salary, 1, 3);
//	    grid.add(textPhone, 0, 4);
//	    grid.add(phone, 1, 4);
//	    grid.add(textEmail, 0, 5);
//	    grid.add(email, 1, 5);
////	    grid.add(textSystem, 0, 8);
////	    grid.add(magWarningNew, 1, 8);
//	    grid.add(bttAdd, 3, 9);
//	    grid.add(bttBack, 0, 9);
//	    border.setCenter(grid);
//
//	    bttBack.setOnAction(event -> {
//	    	bttBack.getScene().setRoot( administratorManagerPage());
//	    });
//
//	    bttAdd.setOnAction(event -> {
//
//	    	if (password.getCharacters().isEmpty() || username.getCharacters().isEmpty() || salary.getCharacters().isEmpty() || phone.getCharacters().isEmpty() || email.getCharacters().isEmpty() || name.getCharacters().isEmpty()) {
//	    		magWarningNew.setText("Failed, Empty Fields!");
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkName(name.getCharacters().toString()))) {
//	    		magWarningNew.setText("Invalid Name");
//	    		name.clear();
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkEmail(email.getCharacters().toString()))) {
//	    		magWarningNew.setText("Invalid email");
//	    		email.clear();
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkPassword(password.getCharacters().toString()))) {
//	    		magWarningNew.setText("Invalid password");
//	    		password.clear();
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkSalary(salary.getCharacters().toString()))) {
//	    		magWarningNew.setText("Invalid salary");
//	    		salary.clear();
//	    		return;
//	    	}
//	    	if (!(Librarian.checkPhone(phone.getCharacters().toString()))) {
//	    		magWarningNew.setText("Invalid phone");
//	    		phone.clear();
//	    		return;
//	    	}
//
//
//			manager = new Manager( username.getCharacters().toString(), password.getCharacters().toString(), name.getCharacters().toString(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
//					email.getCharacters().toString());
//	    	Administrator.AddManager(manager);
////	    	magWarningNew.setText("Succes!");
////
////	    	username.clear();
////	    	name.clear();
////	    	password.clear();
////	    	salary.clear();
////	    	phone.clear();
////	    	email.clear();
//
//	    });
//
//
//	    return border;
//
		BorderPane border = new BorderPane();

		Text text = new Text("Add new Manager ");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);

		TextField name11 = new TextField();
		Text textName = new Text("Name");
		TextField salary11 = new TextField();
		Text textSalary = new Text("Salary");
		TextField phone11 = new TextField();
		Text textPhone = new Text("Phone");
		TextField email11 = new TextField();
		Text textEmail = new Text("Email");
		TextField username11 = new TextField();
		Text textUsername = new Text("Username");
		TextField password11 = new TextField();
		Text textPassword = new Text("Password");
		Button bttAdd = new Button("Submitx");
		Button bttBack = new Button("Back");
		TextField libWarningNew11 = new TextField();

		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(textName,0,0);
		grid.add(name11,1,0);
		grid.add(textPassword,0,1);
		grid.add(password11,1,1);
		grid.add(textUsername,0,2);
		grid.add(username11, 1, 2);
		grid.add(textSalary, 0, 3);
		grid.add(salary11, 1, 3);
		grid.add(textPhone, 0, 4);
		grid.add(phone11, 1, 4);
	    grid.add(textEmail, 0, 5);
		grid.add(email11, 1, 5);
//		grid.add(textSystem, 0, 8);
//		grid.add(libWarningNew11, 1, 8);
		grid.add(bttAdd, 3, 9);
		grid.add(bttBack, 0, 9);
		border.setCenter(grid);

		bttBack.setOnAction(event -> {
			bttBack.getScene().setRoot(administratorMainPage());
		});

		bttAdd.setOnAction(event -> {


//
//			librarian = new Librarian( username.getCharacters().toString(), password.getCharacters().toString(), name.getCharacters().toString(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
//					email.getCharacters().toString());
//
//
//			Manager.AddLibrarian(librarian);
//	    	libWarningNew.setText("Succes!");
			manager = new Manager( username11.getCharacters().toString(), password11.getCharacters().toString(), name11.getCharacters().toString(), Double.parseDouble(salary11.getCharacters().toString()), phone11.getCharacters().toString(),
					email11.getCharacters().toString());

			Administrator.AddManager(manager);
			libWarningNew11.setText("Succes!");

//			try {
//				FileWriter writer=new FileWriter("C:\\Users\\USER\\IdeaProjects\\demo6\\src\\main\\java\\com\\example\\demo6\\USERS\\lib2.txt");
//				writer.write(textUsername.getText());
//				writer.write(textPassword.getText());
//				writer.close();
//
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//			username.clear();
//			name.clear();
//			password.clear();
//			salary.clear();
//			phone.clear();
//			email.clear();
		});
		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
 return  border;
	}
    
    
    public BorderPane editManagerPage(Manager mag) {
    	
    	BorderPane border = new BorderPane();

//    	Text text = new Text("Manager :"+manager.getName());
//		Text	 text = new Text("Manager :"+manager.getName());
		Text text;
		if (manager.getName() == null)
			text = new Text("Manager: "+manager.getUsername());
		else
			text = new Text("Manager: "+manager.getName());

		text.setFont(Font.font("Times new roman",30));

		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		magLoginWarning.clear();
		
		TextField name = new TextField();
		Text textName = new Text("Name");
		TextField salary = new TextField();
		Text textSalary = new Text("Salary");
		TextField phone = new TextField();
		Text textPhone = new Text("Phone");
		TextField email = new TextField();
		Text textEmail = new Text("Email");
		TextField username = new TextField();
		Text textUsername = new Text("Username");
		TextField password = new TextField();
		Text textPassword = new Text("Password");
		Button bttSubmit = new Button("Submit");
//		Button bttDelete = new Button("Delete");
		bttSubmit.setStyle("-fx-background-color:#2F4F4F ; -fx-background-radius: 50px; -fx-text-fill: #ffffff");
		
		GridPane grid = new GridPane();
		grid.setHgap(5);
     	grid.setVgap(5);
     	grid.setAlignment(Pos.CENTER);
     	grid.add(textName,0,0);
	    grid.add(name,1,0);
	    grid.add(textPassword,0,1);
	    grid.add(password,1,1);
	    grid.add(textUsername,0,2);
	    grid.add(username, 1, 2);
	    grid.add(textSalary, 0, 3);
	    grid.add(salary, 1, 3);
	    grid.add(textPhone, 0, 4);
	    grid.add(phone, 1, 4);
	    grid.add(textEmail, 0, 5);
	    grid.add(email, 1, 5);
	    grid.add(textSystem, 0, 8);
	    grid.add(magLoginWarning, 1, 8);
     	
     	HBox hbox = new HBox();
//     	hbox.getChildren().addAll(bttSubmit,bttDelete);
     	hbox.setAlignment(Pos.CENTER);
     	hbox.setSpacing(5);
     	hbox.setPadding(new Insets(0,0,20,0));
     	border.setBottom(hbox);
     	
     	
     	magLoginWarning.setEditable(false);	    
	    name.setEditable(false);
	    
	    name.setText(mag.getName());
	    username.setText(mag.getUsername());
	    password.setText(mag.getPassword());
	    salary.setText(Double.toString(mag.getSalary()));
	    email.setText(mag.getEmail());
	    phone.setText(mag.getPhone());
//
//	    bttDelete.setOnAction(event ->{
//
//	    	if (password.getCharacters().isEmpty() || username.getCharacters().isEmpty() || salary.getCharacters().isEmpty() || phone.getCharacters().isEmpty() || email.getCharacters().isEmpty()) {
//	    		magLoginWarning.setText("Empty Fields");
//	    		return;
//	    	}
//
//
//	    	if (!(Librarian.checkEmail(email.getCharacters().toString()))) {
//	    		email.clear();
//	    		magLoginWarning.setText("Invalid Email");
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkPassword(password.getCharacters().toString()))) {
//	    		password.clear();
//	    		magLoginWarning.setText("Invalid Password");
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkPhone(phone.getCharacters().toString()))) {
//	    		phone.clear();
//	    		magLoginWarning.setText("Invalid Phone Number");
//	    		return;
//	    	}
//
//	    	if (!(Librarian.checkSalary(salary.getCharacters().toString()))) {
//	    		salary.clear();
//	    		magLoginWarning.setText("Invalid Salary");
//	    		return;
//	    	}
//
//	    	manager = new Manager( username.getCharacters().toString(), password.getCharacters().toString(), mag.getName(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
//	    			email.getCharacters().toString());
//
//	    	Administrator.deleteManager(manager);
//	    	username.clear();
//	    	name.clear();
//	    	password.clear();
//	    	salary.clear();
//	    	phone.clear();
//	    	email.clear();
//	    	magLoginWarning.setText("Deleted Succesfully!");
//	    });
	    
	    bttSubmit.setOnAction(event ->{
	    	
	    	if (password.getCharacters().isEmpty() || username.getCharacters().isEmpty() || salary.getCharacters().isEmpty() || phone.getCharacters().isEmpty() || email.getCharacters().isEmpty()) {
	    		magLoginWarning.setText("Empty Fields");
	    		return;
	    	}
	    	
	    	
	    	if (!(Librarian.checkEmail(email.getCharacters().toString()))) {
	    		email.clear();
	    		magLoginWarning.setText("Invalid Email");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkPassword(password.getCharacters().toString()))) {
	    		password.clear();
	    		magLoginWarning.setText("Invalid Password");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkPhone(phone.getCharacters().toString()))) {
	    		phone.clear();
	    		magLoginWarning.setText("Invalid Phone Number");
	    		return;
	    	}
	    	
	    	if (!(Librarian.checkSalary(salary.getCharacters().toString()))) {
	    		salary.clear();
	    		magLoginWarning.setText("Invalid Salary");
	    		return;
	    	}
	    	
	    	manager = new Manager( username.getCharacters().toString(), password.getCharacters().toString(), mag.getName(), Double.parseDouble(salary.getCharacters().toString()), phone.getCharacters().toString(),
	    			email.getCharacters().toString());
	    	
	    	
	    	Administrator.updateManagers(manager);
//	    	magLoginWarning.setText("Success!");
	    	
	    });
	    
	    border.setCenter(grid);
		border.setBackground(
				new Background(
						new BackgroundFill(
								javafx.scene.paint.Color.CADETBLUE, null, new Insets(-10)
						)
				)
		);
    	return border;
    	
    }
    
    
    
    
    public BorderPane administratorStatPage() {
    	
        BorderPane border = new BorderPane();
    	
    	Text text = new Text("Book Statistics");
		StackPane stack = new StackPane();
		text.setFont(new Font(30));
		stack.getChildren().add(text);
		stack.setPadding(new Insets(20));
		border.setTop(stack);
		
		Button bttSold = new Button("Sold");
		Button bttBought = new Button("Bought");
        Button bttIncome = new Button("Income");
        Button bttCost = new Button("Cost");

		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.add(bttSold, 0, 0);
		grid.add(bttBought, 1, 0);
		grid.add(bttIncome, 2, 0);
		grid.add(bttCost, 3, 0);
		border.setCenter(grid);
		
		
		bttSold.setOnAction(event ->{
			bttSold.getScene().setRoot(administratorSoldPage());
		});
		
		bttBought.setOnAction(event -> {
			bttBought.getScene().setRoot(administratorBoughtPage());
		});
		
		bttIncome.setOnAction(event -> {
			bttIncome.getScene().setRoot( administratorIncomePage() );
		});
		
		bttCost.setOnAction(event -> {
			bttCost.getScene().setRoot( administratorCostPage() );
		});
		
		
		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( administratorMainPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
		
		return border;
    }
    
    public BorderPane administratorIncomePage() {
    	
        BorderPane border = new BorderPane();
     	
     	Text text = new Text("Income throughout day/month/year");
 		StackPane stack = new StackPane();
 		text.setFont(new Font(30));
 		stack.getChildren().add(text);
 		stack.setPadding(new Insets(20));
 		border.setTop(stack);
 		
 		TextField totalBooksDay = new TextField();
 		Text textTotalBooksDay = new Text("Total Books Today");
 		TextField totalIncomeDay = new TextField();
 		Text textIncomeDay = new Text("Total Income Today");
 		
 		TextField totalBooksMonth = new TextField();
 		Text textTotalBooksMonth = new Text("Total Books in a Month");
 		TextField totalIncomeMonth = new TextField();
 		Text textIncomeMonth = new Text("Total Income in a Month");
 		
 		TextField totalBooksYearly = new TextField();
 		Text textTotalBooksYearly = new Text("Total Books in a Year");
 		TextField totalIncomeYearly = new TextField();
 		Text textIncomeYearly = new Text("Total Income in a Year");
 		
 		
  		GridPane grid = new GridPane();
 		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.add(textTotalBooksDay, 0, 0);
		grid.add(totalBooksDay, 1, 0);
		grid.add(textIncomeDay, 0, 1);
		grid.add(totalIncomeDay,1,1);
		grid.add(textTotalBooksMonth, 2, 0);
		grid.add(totalBooksMonth,3,0);
		grid.add(textIncomeMonth, 2, 1);
		grid.add(totalIncomeMonth, 3, 1);
		grid.add(textTotalBooksYearly, 4, 0);
		grid.add(totalBooksYearly, 5, 0);
		grid.add(textIncomeYearly, 4, 1);
		grid.add(totalIncomeYearly, 5, 1);
		
		border.setCenter(grid);
		
		totalBooksDay.setEditable(false);
		totalIncomeDay.setEditable(false);
		totalBooksMonth.setEditable(false);
		totalIncomeMonth.setEditable(false);
		totalBooksYearly.setEditable(false);
		totalIncomeYearly.setEditable(false);
		totalBooksDay.setText(String.valueOf(xx));
//		totalBooksDay.setText( Integer.toString( BillNumber.getIntBooksSoldDay() ) );
//		totalIncomeDay.setText( Double.toString( BillNumber.getIncomeDay()) );
//		totalBooksMonth.setText( Integer.toString( BillNumber.getIntBooksSoldMonth() )  );
//	    totalIncomeMonth.setText( Double.toString( BillNumber.getIncomeMonth())  );
//	    totalBooksYearly.setText( Integer.toString( BillNumber.getIntBooksSoldYear() ));
//	    totalIncomeYearly.setText( Double.toString( BillNumber.getIncomeYear() ));
 		
 		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( administratorStatPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
 		
 		return border;
    	
    }
    
    public BorderPane administratorCostPage() {
    	
        BorderPane border = new BorderPane();
     	
     	Text text = new Text("Bought books throughout day/month/year");
 		StackPane stack = new StackPane();
 		text.setFont(new Font(30));
 		stack.getChildren().add(text);
 		stack.setPadding(new Insets(20));
 		border.setTop(stack);
 		
 		
 		TextField totalBooksDay = new TextField();
 		Text textTotalBooksDay = new Text("Total Books Today");
 		TextField totalIncomeDay = new TextField();
 		Text textIncomeDay = new Text("Total Cost Today");
 		
 		TextField totalBooksMonth = new TextField();
 		Text textTotalBooksMonth = new Text("Total Books in a Month");
 		TextField totalIncomeMonth = new TextField();
 		TextField salaryMonth = new TextField();
 		Text textSalaryMonth = new Text("Salary Total This Month");
 		Text textIncomeMonth = new Text("Total Cost in a Month");
 		
 		TextField totalBooksYearly = new TextField();
 		Text textTotalBooksYearly = new Text("Total Books in a Year");
 		TextField totalIncomeYearly = new TextField();
 		TextField salaryYear = new TextField();
 		Text textSalaryYear = new Text("Salary Total In a  Year");
 		Text textIncomeYearly = new Text("Total Cost in a Year");
 		
 		
  		GridPane grid = new GridPane();
 		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.add(textTotalBooksDay, 0, 0);
		grid.add(totalBooksDay, 1, 0);
		grid.add(textIncomeDay, 0, 1);
		grid.add(totalIncomeDay,1,1);
		
		grid.add(textTotalBooksMonth, 2, 0);
		grid.add(totalBooksMonth,3,0);
		grid.add(textIncomeMonth, 2, 1);
		grid.add(totalIncomeMonth, 3, 1);
		grid.add(textSalaryMonth,2,2);
		grid.add(salaryMonth, 3, 2);
		
		grid.add(textTotalBooksYearly, 4, 0);
		grid.add(totalBooksYearly, 5, 0);
		grid.add(textIncomeYearly, 4, 1);
		grid.add(totalIncomeYearly, 5, 1);
		grid.add(textSalaryYear, 4, 2);
		grid.add(salaryYear, 5, 2);
		
		border.setCenter(grid);
		
//		totalBooksDay.setEditable(false);
//		totalIncomeDay.setEditable(true);
//		totalBooksMonth.setEditable(false);
//		totalIncomeMonth.setEditable(false);
//		totalBooksYearly.setEditable(false);
//		totalIncomeYearly.setEditable(false);
//		salaryMonth.setEditable(false);
//		salaryYear.setEtable(false);

		totalBooksDay.setText("4");

		totalIncomeDay.setText( Double.toString( BillNumber.getCostDay()) );
		
//		totalBooksMonth.setText( Integer.toString( BillNumber.getTotalBoughtBooksMonth() )  );
//	    totalIncomeMonth.setText( Double.toString( BillNumber.getCostMonth())  );
//	    salaryMonth.setText( Double.toString(Administrator.getSalaries()) );
//
//	    totalBooksYearly.setText( Integer.toString( BillNumber.getTotalBoughtBooksYear() ));
//	    totalIncomeYearly.setText( Double.toString( BillNumber.getCostYear() ));
	    salaryYear.setText( Double.toString(Administrator.getSalaries()*12) );
 		
 		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( administratorStatPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
 		
 		return border;
    	
    }



	public BorderPane administratorSoldPage() {
    
        BorderPane border = new BorderPane();
     	
     	Text text = new Text("Bought books throughout day/month/year/total");
 		StackPane stack = new StackPane();
 		text.setFont(new Font(30));
 		stack.getChildren().add(text);
 		stack.setPadding(new Insets(20));
 		border.setTop(stack);
 		
 		Text text1 = new Text(BillNumber.getBooksSoldDay());
 		Text text2 = new Text(BillNumber.getBooksSoldMonth());
 		Text text3 = new Text(BillNumber.getBooksSoldYear());
 		Text text4 = new Text( BillNumber.getBooksSoldTotal());
 		
 		GridPane grid = new GridPane();
		grid.add(text1, 0, 0);
		grid.add(text2, 1, 0);
		grid.add(text3, 0, 1);
		grid.add(text4, 1, 1);
		grid.setHgap(50);
		grid.setVgap(30);
		grid.setAlignment(Pos.CENTER);
		border.setCenter(grid);
 		
 		
 		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( administratorStatPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
 		
 		return border;
    }
    
    public BorderPane administratorBoughtPage() {
    	
    	
        BorderPane border = new BorderPane();
     	
     	Text text = new Text("Bought books throughout day/month/year/total");
 		StackPane stack = new StackPane();
 		text.setFont(new Font(30));
 		stack.getChildren().add(text);
 		stack.setPadding(new Insets(20));
 		border.setTop(stack);
//
// 		Text text1 = new Text(BillNumber.getBooksBoughtDay());
// 		Text text2 = new Text(BillNumber.getBooksBoughtMonth());
// 		Text text3 = new Text(BillNumber.getBooksBoughtYear());
// 		Text text4 = new Text(BillNumber.getBooksBoughtTotal());
 		
 		GridPane grid = new GridPane();
//		grid.add(text1, 0, 0);
//		grid.add(text2, 1, 0);
//		grid.add(text3, 0, 1);
//		grid.add(text4, 1, 1);
		grid.setHgap(50);
		grid.setVgap(30);
		grid.setAlignment(Pos.CENTER);
		border.setCenter(grid);
 		
 		
 		StackPane stackBackButton = new StackPane();
		stackBackButton.getChildren().add(bttBackManager);
		bttBackManager.setOnAction(event -> {
            if(event.getSource()==bttBackManager) {
            	bttBackManager.getScene().setRoot( administratorStatPage() );	
            }
	    });
		stackBackButton.setPadding(new Insets(0, 0, 40, 0));
		border.setBottom(stackBackButton);
 		
 		return border;
    	
    	
    }
    
    
    
	
	@Override
	public void handle(ActionEvent e) {
		
		if (e.getSource()==bttLibrarian) {
			bttLibrarian.getScene().setRoot(librarianLoginPage()); 
		}
		if (e.getSource()==bttSubmit) {
			
			if (username.getCharacters().toString().isEmpty() || password.getCharacters().toString().isEmpty()) {
				
				libLoginWarning.setText("Empty Fields");
				return;
				
			}
			
			String user = username.getCharacters().toString();
			String pass = password.getCharacters().toString();
			librarian = new Librarian(user,pass);
			
			if (Manager.LibrarianChecker(librarian)) {
				
				username.clear();
				password.clear();
				librarian = Manager.getBackLibrarian(librarian);
				usernamePage = librarian.getName();
				bttSubmit.getScene().setRoot(librarianMainPage());
				
			}
		    
			else {
				libLoginWarning.setText("Wrong Information");
				username.clear();
				password.clear();
			}
		}
		if (e.getSource()==bttBack) {
			username.clear();
			password.clear();
			bttBack.getScene().setRoot(mainPage());
		}

		if (e.getSource()==bttManager) {
			magLoginWarning.clear();
			bttManager.getScene().setRoot(managerLoginPage());
			
		}
		
		if (e.getSource()==bttSupply) {
			bttSupply.getScene().setRoot(ManagerSupplyCickPage());
			
		}
		
		if (e.getSource()==bttAddStock) {
			bttAddStock.getScene().setRoot(chooseAddCurretStock());
		}
		
		if (e.getSource()==bttCheckStock) {
			bttCheckStock.getScene().setRoot(checkStoragePage());
		}
		if (e.getSource()==bttNewCategory) {
			bttNewCategory.getScene().setRoot(chooseNewCategoryAddStock());
		}
		
		if (e.getSource()==bttAdministrator) {
			bttAdministrator.getScene().setRoot(administratorLoginPage());
		}
		
		if (e.getSource()==bttManageLibrarians) {
			bttManageLibrarians.getScene().setRoot( administratorManageLibrariansPage() );
		}
	}
	public boolean login(File filelib, String usernamelib, String passlib) throws FileNotFoundException {
		Scanner input = new Scanner(filelib);
		ArrayList<Librarian>lib22=new ArrayList<>();

		while(input.hasNext()){
			String line=input.next();
			String  line2=input.next();

			if (usernamelib.equals(line)&&passlib.equals(line2))return true;



		}
		return false;
	}
	public static boolean LibrarianChecker(Librarian lib2) {
		ArrayList<Librarian>librarians=new ArrayList<>();
		for (int i=0;i<librarians.size();i++) {
			if (librarians.get(i).getUsername().equals(lib2.getUsername()) && librarians.get(i).getPassword().equals(lib2.getPassword()))
				return true;
		}
		return false;


	}

}