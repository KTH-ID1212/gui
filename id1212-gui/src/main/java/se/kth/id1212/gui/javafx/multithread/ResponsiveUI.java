package se.kth.id1212.gui.javafx.multithread;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResponsiveUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text resultText = new Text();

        Button sleepButton = new Button("Go To Bed");
        sleepButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultText.setText("Sleeping...");
                new SleepService(resultText).start();
            }
        });

        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.getChildren().add(sleepButton);
        rootNode.getChildren().add(resultText);

        Scene scene = new Scene(rootNode, 200, 50);

        primaryStage.setTitle("Sleeper");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    private static class SleepService extends Service<String> {
        private static final int SLEEP_TIME = 10000;

        private SleepService(Text resultText) {
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent e) {
                    resultText.setText((String) e.getSource().getValue());
                }
            });
        }

        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws InterruptedException {
                    Thread.sleep(SLEEP_TIME); //This simulates a lenghty task, like a network call.
                    return "Woke up!";
                }
            };
        }
    }
}
