package co.simplon.alt6.Class;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NavigateGui extends Application {
    @Override
    public void start(Stage stage) {
        Navigate navigation = new Navigate("/");

        // Scene scene = new Scene(navigation, 640, 480);
        // stage.setScene(scene);
        // stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
