/*
 * The MIT License
 *
 * Copyright 2017 Leif Lindbäck <leifl@kth.se>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
