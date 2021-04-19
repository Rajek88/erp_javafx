package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private FXMLLoader loader;
    private Object ControllerHome;

    @Override
    public void start(Stage primaryStage) throws Exception{
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        loader.load();
        Scene scene= new Scene(loader.getRoot());
        primaryStage.setTitle("Texture Softwares");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
