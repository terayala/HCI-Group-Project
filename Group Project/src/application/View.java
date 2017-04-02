package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/*View Class manages the View/UI for the media player*/
public class View {

	//Class variables
	Model model;
	Controller controller;
	final Stage stage;
	
	//Constructor
	public View(final Stage s, Model m, Controller c){
		model = m;
		controller =c;
		stage = s;
		
		stage.setMaximized(true);
		
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(0, 10, 10, 0));
				
		//Create MenuBar
		MenuBar menuBar = new MenuBar();
		
		//Create Menus
		Menu file = new Menu("File");
		Menu controls = new Menu("Controls");
		Menu playlist = new Menu("Playlist");
		Menu help = new Menu("Help");
		
		//Create and add File Menu options
		MenuItem selDir = new MenuItem("Select Directory");
		MenuItem exit = new MenuItem("Exit");
		file.getItems().addAll(selDir, exit);
		
		//Create and add Controls Menu options
		MenuItem play = new MenuItem("Play");
		MenuItem pause = new MenuItem("Pause");
		MenuItem next = new MenuItem("Next");
		MenuItem previous = new MenuItem("Previous");
		MenuItem slomo = new MenuItem("Slow Motion");
		MenuItem skipFive = new MenuItem("Skip Ahead 5 Seconds");
		MenuItem shuffle = new MenuItem("Shuffle Playlist");
		MenuItem  repeat = new MenuItem("Repeat Song");
		controls.getItems().addAll(play, pause, next, previous, slomo, skipFive, shuffle, repeat);
		
		//Create and add Playlist Menu options
		MenuItem save = new MenuItem("Save Current Playlist");
		MenuItem open = new MenuItem("Open Existing Playlist");		
		playlist.getItems().addAll(save, open);
		
		//Create and add Help Menu option
		MenuItem helpMe = new MenuItem("Tips and Tricks");
		help.getItems().addAll(helpMe);
		
		//Add all menus to the MenuBar
		menuBar.getMenus().addAll(file, controls, playlist, help); 
		
		root.setTop(menuBar);
		
		//List of songs
		ListView<String> titles = new ListView<String>();
		
		ObservableList<String> items =FXCollections.observableArrayList (
				"First", "Second", "Third", "Fourth","First", "Second", "Third", "Fourth",
				"First", "Second", "Third", "Fourth", "First", "Second", "Third", "Fourth");
		titles.setItems(items);
				
		root.setRight(titles);
		
		BorderPane bottom = new BorderPane();
		
		VBox southOfList = new VBox();
		//southOfList.setCenterShape(true);
		
		Button shuffleB = new Button ("Shuffle");
		Button deleteB = new Button ("Delete");
		
		
		//shuffleB.isScaleShape();
		//shuffleB.isResizable();
		
		southOfList.getChildren().addAll(shuffleB, deleteB);
		//southOfList.setCenterShape(true);
		//southOfList.isCenterShape();
		//southOfList.setScaleShape(true);
		//southOfList.isFillWidth();
		southOfList.setBackground(new Background(new BackgroundFill(Paint.valueOf("GREY"), null, null)));
		VBox.setMargin(shuffleB, new Insets(10, 90, 10, 90));
		VBox.setMargin(deleteB, new Insets(10, 90, 10, 90));
		
		Label songInfo=new Label("Song Info");
		songInfo.setMinSize(1600.0, 80.0);
		
		
		bottom.setLeft(songInfo);
		//bottom.setCenter(songInfo);
		bottom.setRight(southOfList);
		
		root.setBottom(bottom);
		
		
		BorderPane player = new BorderPane();
		player.setPadding(new Insets(10, 10, 10, 10));
		
		//player.setCenter(albumnCover);
		
		//player.setSouth(buttonBar);
		
		root.setLeft(player);
		
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	//Audio Viewing
	
}
