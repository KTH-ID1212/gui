package se.kth.id1212.gui.javafx.helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * The first JavaFX application. Displays a window with a button and adds an
 * event handler for that button.
 */
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane rootNode = new FlowPane(10, 10);
        
        Label resultLabel = new Label();
        
        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultLabel.setText("Hello World!");
            }
        });
        rootNode.getChildren().add(btn);
        rootNode.getChildren().add(resultLabel);

        Scene scene = new Scene(rootNode, 200, 50);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
