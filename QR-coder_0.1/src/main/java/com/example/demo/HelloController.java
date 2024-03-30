package com.example.demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    private int qrCodeCounter = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCreate;

    @FXML
    private TextField insertUrl;

    @FXML
    private ImageView qrCodeInput;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize() {

        buttonCreate.setOnAction(event -> {
            String url = insertUrl.getText();
            qrCodeCounter++;
            if (!url.isEmpty()) {

                int size = 300;

                String filePath = "qr_code/qr_code" + qrCodeCounter + ".png";
                generateQRCode(url, size, filePath);

                try {
                    qrCodeInput.setImage(new Image(new File(filePath).toURI().toURL().toString()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void generateQRCode(String url, int size, String filePath) {

        QRCodeGenerator.generateQRCode(url, size, filePath);
    }

}
