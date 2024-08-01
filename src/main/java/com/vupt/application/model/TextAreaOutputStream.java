package com.vupt.application.model;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;

public class TextAreaOutputStream  extends OutputStream {
    private TextArea textArea;
    public TextAreaOutputStream(TextArea textArea){
        this.textArea=textArea;
    }

    @Override
    public void write(int b) throws IOException {
        Platform.runLater(()->textArea.appendText(String.valueOf((char) b)));
    }
}
