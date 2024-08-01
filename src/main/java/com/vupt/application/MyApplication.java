package com.vupt.application;



import com.vupt.application.excel.importer.GDHSImportExcel;
import com.vupt.application.model.ReaderThread;
import com.vupt.application.utils.FileUtils;
import com.vupt.application.views.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

@Configuration
@SpringBootApplication
public class MyApplication extends Application {
    private final PipedInputStream pipeIn = new PipedInputStream();
    private final PipedInputStream pipeIn2 = new PipedInputStream();
    Thread errorThrower;
    private Thread reader;
    private Thread reader2;
    boolean quit;
    private TextArea txtArea;
    private static ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        this.applicationContext = SpringApplication.run(MyApplication.class);
        System.setProperty("java.awt.headless", "false");

    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileUtils.createFolder("output");

        MainController.loadView(primaryStage);
        txtArea = MainController.staticTaConsole;
        executeReaderThreads();
        //Thread closing on stag close event
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                closeThread();
                Platform.exit();
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }
    //method to handle thread closing on stage closing
    synchronized void closeThread()
    {
        System.out.println("Message: Stage is closed.");
        this.quit = true;
        notifyAll();
        try { this.reader.join(1000L); this.pipeIn.close(); } catch (Exception e) {
        }try { this.reader2.join(1000L); this.pipeIn2.close(); } catch (Exception e) {
    }System.exit(0);
    }

    public void executeReaderThreads() {
        try {
            PipedOutputStream pout = new PipedOutputStream(this.pipeIn);
            System.setOut(new PrintStream(pout, true));
        } catch (SecurityException se) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PipedOutputStream pout2 = new PipedOutputStream(this.pipeIn2);
            System.setErr(new PrintStream(pout2, true));
        } catch (IOException io) {
        } catch (SecurityException se) {
        }
        ReaderThread obj = new ReaderThread(pipeIn, pipeIn2, errorThrower, reader, reader2, quit, txtArea);
    }
}