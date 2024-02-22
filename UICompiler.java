package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UICompiler extends Application {
    BorderPane borderPane = new BorderPane();
    public static int closetCount;
    @Override
    public void start(Stage primaryStage){
        HBox hBox = addHBox();
        VBox vBox = addVBox();
        VBox vBoxCustomFurniture = addVBoxFurniture();
        borderPane.setTop(hBox);
        borderPane.setLeft(vBox);
        borderPane.setRight(vBoxCustomFurniture);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setWidth(1300);
        primaryStage.setHeight(850);
        primaryStage.show();

    }


    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #b51212;");

        Text title = new Text("Ball State University: Residence Halls");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 27));
        title.setFill(Color.WHITESMOKE);

        hbox.getChildren().add(title);

        return hbox;
    }

    public VBox addVBox() {
        InteractiveFeatures features = new InteractiveFeatures();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #DAE6F3;");

        Group root = new Group();

        Button revealButton = new Button("Show me my room!");

        revealButton.setOnAction(e -> {
            UserCreatingFurniture creatingFurniture = new UserCreatingFurniture();

            creatingFurniture.spawnFurniture();

        });

        Text title = new Text("Dorm Selection");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        vbox.getChildren().addAll(title, revealButton);
        root.getChildren().add(features.getDormRoom());

        BorderPane.setAlignment(root, Pos.TOP_LEFT);
        BorderPane.setMargin(root, new Insets(12,12,12,12));
        borderPane.setCenter(root);

        return vbox;
    }

    public VBox addVBoxFurniture() {
        UserCreatingFurniture creatingFurniture = new UserCreatingFurniture();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: DAE6F3;");

        Group root = new Group();
        Group root2 = new Group();
        Group root3 = new Group();

        root.getChildren().add(creatingFurniture.getCustomFurniture());
        root2.getChildren().add(creatingFurniture.getExistingFurniture());
        root3.getChildren().add(creatingFurniture.deleteFurniture());

        Text title = new Text("Add Custom\nFurniture");
        Text title2 = new Text("Add Provided\nFurniture");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        vbox.getChildren().addAll(title, root, title2, root2, root3);

        return vbox;
    }

    public TilePane dormDataTilePane(String buttonName) {
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(5, 0, 5, 0));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(2);
        tile.setStyle("-fx-background-color: DAE6F3;");

        HBox hbox2 = addHBox2(buttonName);
        HBox hbox3 = addHBox3(buttonName);
        HBox hbox4 = addHBox4();

        tile.getChildren().addAll(hbox2, hbox3, hbox4);
        return tile;
    }

    public HBox addHBox4() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(8);

        Text title = new Text("Pet Friendly: ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Label label = new Label("Yes");
        hbox.getChildren().addAll(title, label);

        return hbox;
    }

    public HBox addHBox3(String buttonName) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(8);

        Text title = new Text("Food Courts Nearby: ");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        String dormData = dormRoomInfo(buttonName);
        Label label = new Label(dormData);
        hbox.getChildren().addAll(title, label);
        return hbox;
    }

    public HBox addHBox2(String dormName) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(8);

        Text title = new Text("Dorm Key: ");
        Label label;
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        String key = returnDormFurnitureInfo(dormName);

        label = new Label(key);
        hbox.getChildren().addAll(title, label);
        return hbox;
    }

    public String returnDormFurnitureInfo(String dormName) {
        String key = null;
        switch (dormName) {
            case "Dehority", "Noyer", "Studebaker West", "Woodworth" -> {
                key = """
                        Chair(s): 2
                        Bed(s): 2
                        Trashcan(s): 2
                        Desk(s): 2
                        Dresser(s): 2
                        Wardrobe(s): 2
                        Closet(s): 0
                        """;
                closetCount = 0;
            }
            case "Beyerl", "Schmidt-Wilson", "North West", "Botsford-Swinford" -> {
                key = """
                        Chair(s): 2
                        Bed(s): 2
                        Trashcan(s): 2
                        Desk(s): 2
                        Dresser(s): 2
                        Wardrobe(s): 0
                        Closet(s): 2
                        """;
                closetCount = 2;
            }
            case "Park", "Studebaker East", "Kinghorn" -> {
                key = """
                        Chair(s): 2
                        Bed(s): 2
                        Trashcan(s): 2
                        Desk(s): 2
                        Dresser(s): 2
                        Wardrobe(s): 0
                        Closet(s): 1
                        """;
                closetCount = 1;
            }
        }

        return key;
    }

    public String dormRoomInfo(String buttonName) {
        return switch (buttonName) {
            case "Dehority", "Woodworth", "Noyer", "Park", "Kinghorn" -> "- Woodworth Commons\n- Noyer Market";
            case "Beyerl", "Schmidt-Wilson", "North West", "Botsford-Swinford" -> "- North Dining Hall\n";
            case "Studebaker East", "Studebaker West" -> "- Woodworth Commons\n- Tom John Food Shop\n- Micro Cafe";
            default -> "";
        };
    }

}
