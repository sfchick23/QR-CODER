package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGenerator {

    private static final String CHARSET = "UTF-8";
    private static final String FILE_FORMAT = "png";

    public static void generateQRCode(String url, int size, String filePath) {
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
            hints.put(EncodeHintType.MARGIN, 1);
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, size, size, hints);

            File qrFile = new File(filePath);
            MatrixToImageWriter.writeToFile(bitMatrix, FILE_FORMAT, qrFile);
            System.out.println("QR code successfully created: " + qrFile.getAbsolutePath());
        } catch (WriterException | IOException e) {
            System.err.println("Error when creating a QR code: " + e.getMessage());
        }
    }

}

