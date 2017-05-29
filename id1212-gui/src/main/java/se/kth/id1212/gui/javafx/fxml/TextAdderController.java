package se.kth.id1212.gui.javafx.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Contains the event handlers.
 */
public class TextAdderController implements Initializable {
    static final String NO_OF_ADDED_LINES_PREFIX = "Number of added lines: ";
    private static final int DEFAULT_MAX_LINE_COUNT = 3;
    static final String MAX_LINE_COUNT_PARAM_NAME = "maxLines";
    private int noOfAddedLines = 0;
    private int maxLineCount;

    @FXML
    private Label label;
    @FXML
    private TextArea allTextArea;
    @FXML
    private TextField textToAddField;
    @FXML
    private Text numberOfAddedLinesText;
    @FXML
    private Button addButton;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            maxLineCount = Integer.parseInt(System.getProperty(
                    MAX_LINE_COUNT_PARAM_NAME));
        } catch (Exception e) {
            maxLineCount = DEFAULT_MAX_LINE_COUNT;
        }
        
        okButton.defaultButtonProperty().bind(okButton.focusedProperty());
        cancelButton.defaultButtonProperty().bind(cancelButton.focusedProperty());
    }

    @FXML
    private void addHandler(ActionEvent ae) {
        allTextArea.appendText(textToAddField.getText() + "\n");
        numberOfAddedLinesText.setText(
                NO_OF_ADDED_LINES_PREFIX + ++noOfAddedLines);
        if (noOfAddedLines == maxLineCount) {
            addButton.setDisable(true);
            textToAddField.setDisable(true);
        }
    }
    
    @FXML
    private void okButtonHandler(ActionEvent ae) {
        System.out.println(allTextArea.getText());
        shutdown();
    }

    private void shutdown() {
        Platform.exit();
    }

    @FXML
    private void cancelButtonHandler(ActionEvent ae) {
        shutdown();
    }

}
