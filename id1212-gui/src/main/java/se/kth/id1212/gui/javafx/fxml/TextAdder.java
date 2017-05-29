package se.kth.id1212.gui.javafx.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starts the TextAdder application.
 */
public class TextAdder extends Application {

    @Override
    public void init() {
        System.setProperty(TextAdderController.MAX_LINE_COUNT_PARAM_NAME,
                           getParameters().getNamed().get(
                                   TextAdderController.MAX_LINE_COUNT_PARAM_NAME));
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "TextAdderFxml.fxml"));
        loader.getNamespace().put("numberOfAddedLinesTextInitialLabel",
                                  TextAdderController.NO_OF_ADDED_LINES_PREFIX + "0");

        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args The application takes one parameter, maxLines, which
     *             specifies the number of lines of text that can be added.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
