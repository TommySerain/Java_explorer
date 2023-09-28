package co.simplon.alt6.Class;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import java.io.IOException;
import java.util.Stack;

public class NavigateGui extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

//        GridPane grid = new GridPane();
//        Text title = new Text("COUCOU C\'est un test");
//        grid.addRow(3, title);

//        StackPane root = new StackPane();
//        Label label = new Label("COUCOU C\'EST UN TEST");
////        root.getChildren().add(new ButtonBar());
//        root.getChildren().add(new Text("CSsqdqsdqsdqsdqsd"));
//        Rectangle rectangle = new Rectangle(400, 200, Color.rgb(35, 34, 36));
//        root.getChildren().addAll(rectangle, label);
//        rectangle.toBack();

//        VBox vbox = new VBox();
//        vbox.setAlignment(Pos.CENTER);
//        vbox.setPadding(new Insets(25));
//        Label labelvbox = new Label("CECI EST UN TEST VBOX");
//        Image image = new Image("discord.png");
//        ImageView discordImage = new ImageView();
//        discordImage.setImage(image);
//        discordImage.setFitWidth(20);
//        Button buttonTest = new Button("Valider");
//        buttonTest.setGraphic(discordImage);
//        buttonTest.setOnAction( (e) -> {
//                System.out.println("Boutton cliqué !");
//        });
//        vbox.getChildren().addAll(labelvbox, buttonTest);


        primaryStage.setTitle("XPLORATOR");
        BorderPane borderPaneRoot = new BorderPane();
        Scene scene = new Scene(borderPaneRoot, 1200, 800);
        primaryStage.setScene(scene);

        Rectangle rectangleImage = new Rectangle(400, 300);
        Image backgroundImage = new Image("fond_explorateur.jpg");
//        ImageView viewBackgroundImage = new ImageView();
        rectangleImage.setFill(new ImagePattern(backgroundImage));

        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10, 20, 20, 10));
        hBox1.setSpacing(20);
        Label labelPath = new Label("Chemin d\' acces");
        labelPath.setPadding(new Insets(5));
        TextField textFieldPath = new TextField();
        Button buttonPath = new Button("Valider");
        hBox1.getChildren().addAll(labelPath, textFieldPath, buttonPath);

        VBox vbox1 = new VBox();
        Button folder = new Button("folder");
        Button file = new Button("file");
        Image imageFolder = new Image("dossier.png");
        Image imageFile = new Image("document.png");
        ImageView folderImage = new ImageView();
        ImageView fileImage = new ImageView();
        folderImage.setImage(imageFolder);
        folderImage.setFitWidth(30);
        folder.setGraphic(folderImage);
        fileImage.setImage(imageFile);
        fileImage.setFitWidth(30);
        folder.setGraphic(folderImage);
        file.setGraphic(fileImage);
        vbox1.setPadding(new Insets(50));
        ListView<String> listView1 = new ListView<>();
        Navigate navigate = new Navigate("/");
        listView1.getItems().addAll(navigate.ShowFilesList());
        vbox1.getChildren().addAll(listView1, folder, file, rectangleImage);
        borderPaneRoot.setCenter(vbox1);

        borderPaneRoot.setTop(hBox1);
        primaryStage.show();

        buttonPath.setOnAction((e) -> {
            String nom = textFieldPath.getText();
            listView1.getItems().add(nom);
        });

    }

    public static void main(String[] args) {
        launch();
    }
}