package co.simplon.alt6.Class;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class NavigateGui extends Application {
    public boolean isDirectory(String fileName) {
        if (fileName.contains(".")) {
            return true;
        }
        return false;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // SCENE AND BORDERPANE
        primaryStage.setTitle("XPLORATOR");
        BorderPane borderPaneRoot = new BorderPane();
        Scene scene = new Scene(borderPaneRoot, 1200, 800);
        primaryStage.setScene(scene);

        // HEADER PATH
        Navigate navigate = new Navigate("/");
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(20));
        hBox1.setSpacing(20);
        Label labelPath = new Label("Chemin d\' acces");
        labelPath.setPadding(new Insets(5));
        TextField textFieldPath = new TextField(navigate.path);
        textFieldPath.setMinWidth(600);
        Button buttonPath = new Button("Valider");
        hBox1.getChildren().addAll(labelPath, textFieldPath, buttonPath);
        hBox1.setAlignment(Pos.CENTER);

        // ELEMENTS EN VERTICAL
        VBox vbox1 = new VBox();
        HBox input = new HBox();
        HBox menuIcons = new HBox();
        HBox propertiesBox = new HBox();

        // Input FILE/FOLDER CREATION
        TextField inputText = new TextField();
        inputText.setMinWidth(400);
        inputText.setAlignment(Pos.CENTER);
        input.getChildren().add(inputText);
        input.setAlignment(Pos.CENTER);
        input.setPadding(new Insets(30));

        // MENU ICONS HBOX
        Button folder = new Button("New folder");
        Image imageFolder = new Image("dossier.png");
        ImageView folderImage = new ImageView();
        folderImage.setImage(imageFolder);
        folderImage.setFitWidth(30);
        folder.setGraphic(folderImage);

        Button file = new Button("New file");
        Image imageFile = new Image("document.png");
        ImageView fileImage = new ImageView();
        fileImage.setImage(imageFile);
        fileImage.setFitWidth(30);
        file.setGraphic(fileImage);

        Button update = new Button("Update File/folder");
        Image imageUpdate = new Image("update.png");
        ImageView updateImage = new ImageView();
        updateImage.setImage(imageUpdate);
        updateImage.setFitWidth(30);
        update.setGraphic(updateImage);

        Button properties = new Button("Proprietes");
        Image imageProperties = new Image("prop.png");
        ImageView PropertiesImage = new ImageView();
        PropertiesImage.setImage(imageProperties);
        PropertiesImage.setFitWidth(30);
        properties.setGraphic(PropertiesImage);

        Button delete = new Button("Supprimer");
        Image imageDelete = new Image("delete.png");
        ImageView deleteImage = new ImageView();
        deleteImage.setImage(imageDelete);
        deleteImage.setFitWidth(30);
        delete.setGraphic(deleteImage);

        // STYLE MENU ICONS
        menuIcons.getChildren().addAll(folder, file, update, properties, delete);
        menuIcons.setSpacing(50);
        menuIcons.setAlignment(Pos.CENTER);
        menuIcons.setPadding(new Insets(20));

        // PROPERTIES TEXT AREA
        Text textProperties = new Text();
        propertiesBox.getChildren().add(textProperties);
        propertiesBox.setAlignment(Pos.CENTER);
        Font customFont = new Font("VERDANA", 16);
        textProperties.setFont(customFont);
        textProperties.setFill(Color.rgb(26, 93, 203));

        // APPEND LISTVIEW INPUT MENUICONS PROPERTIES RECTANGLE
        vbox1.setPadding(new Insets(30));
        ListView<String> listView1 = new ListView<>();
        listView1.getItems().addAll(navigate.ShowFilesList());
        vbox1.getChildren().addAll(listView1, input, menuIcons, propertiesBox);
        borderPaneRoot.setCenter(vbox1);
        borderPaneRoot.setTop(hBox1);
        primaryStage.show();

        // EVENT LISTENERS MENU ICONS BUTTONS
        buttonPath.setOnAction(e -> {
            String temp = textFieldPath.getText();
            navigate.path = temp;
            listView1.getItems().clear();
            listView1.getItems().addAll(navigate.ShowFilesList());
        });

        listView1.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                String selectedValue = listView1.getSelectionModel().getSelectedItem();
                if (selectedValue != null) {
                    if (selectedValue.equals("..")) {
                        String newPath = "";
                        String[] pathSplit = navigate.path.split("/");
                        for (int i = 0; i < pathSplit.length - 1; i++) {
                            newPath += pathSplit[i] + "/";
                        }
                        navigate.path = newPath;
                    } else {
                        navigate.path += selectedValue + "/";
                    }
                    textFieldPath.setText(navigate.path);
                    listView1.getItems().clear();
                    listView1.getItems().add("..");
                    listView1.getItems().addAll(navigate.ShowFilesList());
                }
            }
        });

        file.setOnAction(e -> {
            listView1.getSelectionModel().getSelectedItem();
            FileHandler file1 = new FileHandler(navigate.path);
            if (!inputText.getText().isEmpty()) {
                file1.createFile(inputText.getText());
                listView1.getItems().clear();
                listView1.getItems().add("..");
                listView1.getItems().addAll(navigate.ShowFilesList());
            }
        });

        folder.setOnAction(e -> {
            listView1.getSelectionModel().getSelectedItem();
            FileHandler file1 = new FileHandler(navigate.path);
            if (!inputText.getText().isEmpty()) {
                file1.createFolder(inputText.getText());
                listView1.getItems().clear();
                listView1.getItems().add("..");
                listView1.getItems().addAll(navigate.ShowFilesList());
            }
        });

        delete.setOnAction(e -> {
            String selectedValue = listView1.getSelectionModel().getSelectedItem();
            FileHandler file1 = new FileHandler(navigate.path);
            file1.deleteFolderAndContents(selectedValue);
            listView1.getItems().clear();
            listView1.getItems().add("..");
            listView1.getItems().addAll(navigate.ShowFilesList());
        });

        update.setOnAction(e -> {
            String selectedValue = listView1.getSelectionModel().getSelectedItem();
            FileHandler file1 = new FileHandler(navigate.path);
            file1.updateFileName(selectedValue, inputText.getText());
            listView1.getItems().clear();
            listView1.getItems().add("..");
            listView1.getItems().addAll(navigate.ShowFilesList());
        });

        properties.setOnAction(e -> {
            String selectedValue = listView1.getSelectionModel().getSelectedItem();
            FileHandler file1 = new FileHandler(navigate.path);
            textProperties.setText(file1.properties(selectedValue));
            listView1.getItems().clear();
            listView1.getItems().add("..");
            listView1.getItems().addAll(navigate.ShowFilesList());
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
