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
