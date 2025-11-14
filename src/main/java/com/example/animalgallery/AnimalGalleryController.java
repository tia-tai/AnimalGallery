package com.example.animalgallery;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class AnimalGalleryController {
    public ImageView imgPreview1;
    public ImageView imgPreview2;
    public ImageView imgPreview3;
    public ImageView imgPreview4;
    public ImageView imgPreview5;
    public ImageView displayImage;

    public Button imgPreview1Button;
    public Button imgPreview2Button;
    public Button imgPreview3Button;
    public Button imgPreview4Button;
    public Button imgPreview5Button;

    public Label fileName;

    private File imgFile1;
    private File imgFile2;
    private File imgFile3;
    private File imgFile4;
    private File imgFile5;

    private FileInputStream img1Input;
    private FileInputStream img2Input;
    private FileInputStream img3Input;
    private FileInputStream img4Input;
    private FileInputStream img5Input;

    private Image img1;
    private Image img2;
    private Image img3;
    private Image img4;
    private Image img5;


    public void initialize() throws Exception {
        imgFile1 = new File("src/main/images/horse.jpg");
        img1Input = new FileInputStream(imgFile1);
        img1 = new Image(img1Input);

        imgFile2 = new File("src/main/images/kangaroo.jpg");
        img2Input = new FileInputStream(imgFile2);
        img2 = new Image(img2Input);

        imgFile3 = new File("src/main/images/monkey.jpg");
        img3Input = new FileInputStream(imgFile3);
        img3 = new Image(img3Input);

        imgFile4 = new File("src/main/images/piranha.jpg");
        img4Input = new FileInputStream(imgFile4);
        img4 = new Image(img4Input);

        imgFile5 = new File("src/main/images/seahorse.jpg");
        img5Input = new FileInputStream(imgFile5);
        img5 = new Image(img5Input);

        imgPreview1.setImage(img1);
        imgPreview2.setImage(img2);
        imgPreview3.setImage(img3);
        imgPreview4.setImage(img4);
        imgPreview5.setImage(img5);

        displayImage.setImage(img1);
        fileName.setText(imgFile1.getName());
    }

    public void setDisplayedImage(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();

        if (sourceButton == imgPreview1Button) {
            System.out.println("Button 1 clicked");
            displayImage.setImage(img1);
            fileName.setText(imgFile1.getName());
        } else if (sourceButton == imgPreview2Button) {
            System.out.println("Button 2 clicked");
            displayImage.setImage(img2);
            fileName.setText(imgFile2.getName());
        } else if (sourceButton == imgPreview3Button) {
            System.out.println("Button 3 clicked");
            displayImage.setImage(img3);
            fileName.setText(imgFile3.getName());
        } else if (sourceButton == imgPreview4Button) {
            System.out.println("Button 4 clicked");
            displayImage.setImage(img4);
            fileName.setText(imgFile4.getName());
        } else if (sourceButton == imgPreview5Button) {
            System.out.println("Button 5 clicked");
            displayImage.setImage(img5);
            fileName.setText(imgFile5.getName());
        }
    }
}
