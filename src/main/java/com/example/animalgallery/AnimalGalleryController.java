package com.example.animalgallery;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

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

    public Button prevButton;
    public Button nextButton;

    public Button uploadButton;

    public Pane addTextPane;
    public TextArea textToAdd;
    public Button textCancelButton;
    public Button textSubmitButton;

    public Label imgText;

    public VBox imagePreviewCollection;

    public MenuButton imgMenu;
    public MenuItem deleteMenuButton;
    public MenuItem addTextMenuButton;
    public MenuItem detailMenuButton;

    public ColorPicker textColor;

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

    public Pane detailPane;
    public Label detailName;
    public Label detailType;
    public Label detailSize;
    public Label detailDimensions;
    public Button detailCloseButton;

    private ArrayList<File> imageFiles = new ArrayList<File>();
    private ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
    private ArrayList<Image> images = new ArrayList<Image>();
    private ArrayList<Button> imageButtons = new ArrayList<Button>();
    private int currentImage = 1;

    private GaussianBlur blurEffect = new GaussianBlur(10);

    private FileChooser fileChooser = new FileChooser();
    private File selectedFile;

    public ChoiceBox<String> imageChoiceBox;

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

        imageFiles.add(imgFile1);
        imageFiles.add(imgFile2);
        imageFiles.add(imgFile3);
        imageFiles.add(imgFile4);
        imageFiles.add(imgFile5);

        imgPreview1.setImage(img1);
        imgPreview2.setImage(img2);
        imgPreview3.setImage(img3);
        imgPreview4.setImage(img4);
        imgPreview5.setImage(img5);

        imageViews.add(imgPreview1);
        imageViews.add(imgPreview2);
        imageViews.add(imgPreview3);
        imageViews.add(imgPreview4);
        imageViews.add(imgPreview5);

        imageButtons.add(imgPreview1Button);
        imageButtons.add(imgPreview2Button);
        imageButtons.add(imgPreview3Button);
        imageButtons.add(imgPreview4Button);
        imageButtons.add(imgPreview5Button);

        images.add(img1);
        images.add(img2);
        images.add(img3);
        images.add(img4);
        images.add(img5);

        for (File imgFile : imageFiles) {
            imageChoiceBox.getItems().add(imgFile.getName());
        }

        displayImage.setImage(img1);
        imageChoiceBox.setValue(imgFile1.getName());
        imgPreview1.setEffect(blurEffect);
        currentImage = 1;
    }

    public void setDisplayedImage(ActionEvent event) throws Exception {
        Button sourceButton = (Button) event.getSource();

        imgText.setText("");

        currentImage = imageButtons.indexOf(sourceButton) + 1;
        File imgFile = imageFiles.get(currentImage-1);
        displayImage.setImage(images.get(currentImage-1));
        imageChoiceBox.setValue(imgFile.getName());
        for (ImageView imagePreview : imageViews) {
            if (imageViews.indexOf(imagePreview) + 1 == currentImage) {
                imagePreview.setEffect(blurEffect);
            } else {
                imagePreview.setEffect(null);
            }
        }
    }

    public void nextImg () throws Exception {
        imgText.setText("");
        if (currentImage < imageFiles.size()) {
            currentImage++;
        } else {
            currentImage = 1;
        }
        File imgFile = imageFiles.get(currentImage-1);
        displayImage.setImage(images.get(currentImage-1));
        imageChoiceBox.setValue(imgFile.getName());

        for (ImageView imagePreview : imageViews) {
            if (imageViews.indexOf(imagePreview) + 1 == currentImage) {
                imagePreview.setEffect(blurEffect);
            } else {
                imagePreview.setEffect(null);
            }
        }
    }

    public void previousImg () throws Exception {
        imgText.setText("");
        if (currentImage > 1) {
            currentImage--;
        } else {
            currentImage = imageFiles.size();
        }
        File imgFile = imageFiles.get(currentImage-1);
        displayImage.setImage(images.get(currentImage-1));
        imageChoiceBox.setValue(imgFile.getName());

        for (ImageView imagePreview : imageViews) {
            if (imageViews.indexOf(imagePreview) + 1 == currentImage) {
                imagePreview.setEffect(blurEffect);
            } else {
                imagePreview.setEffect(null);
            }
        }
    }

    public void upload () throws Exception {
        uploadButton.setDisable(true);
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imageFiles.add(selectedFile);
            imageChoiceBox.getItems().add(selectedFile.getName());
            FileInputStream imgInput = new FileInputStream(selectedFile);
            Image img = new Image(imgInput);
            ImageView imgPreview = new ImageView(img);
            imgPreview.setPreserveRatio(true);
            imgPreview.setFitHeight(150);
            imgPreview.setFitWidth(169);
            Button imgPreviewButton = new Button("", imgPreview);
            imgPreviewButton.setOnAction(actionEvent -> {
                try {
                    setDisplayedImage(actionEvent);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            imageViews.add(imgPreview);
            imageButtons.add(imgPreviewButton);
            images.add(img);

            imagePreviewCollection.getChildren().add(imgPreviewButton);
        }
        uploadButton.setDisable(false);
    }

    public void delete () throws Exception {
        imgText.setText("");
        Button imgPreviewButton = imageButtons.get(currentImage-1);
        ImageView imgPreview = imageViews.get(currentImage-1);
        File imgFile = imageFiles.get(currentImage-1);
        Image image = images.get(currentImage-1);

        imageViews.remove(imgPreview);
        imageFiles.remove(imgFile);
        imageButtons.remove(imgPreviewButton);
        images.remove(image);
        imagePreviewCollection.getChildren().remove(imgPreviewButton);
        imageChoiceBox.getItems().remove(imgFile.getName());

        currentImage = 1;
        File imgFile2 = imageFiles.getFirst();
        displayImage.setImage(images.get(currentImage-1));
        imageChoiceBox.setValue(imgFile2.getName());
        for (ImageView imagePreview2 : imageViews) {
            if (imageViews.indexOf(imagePreview2) + 1 == currentImage) {
                imagePreview2.setEffect(blurEffect);
            } else {
                imagePreview2.setEffect(null);
            }
        }
    }

    public void addText () {
        addTextPane.setDisable(false);
        addTextPane.setVisible(true);
        addTextPane.toFront();
        textToAdd.clear();

        displayImage.setEffect(blurEffect);
    }

    public void cancelAddText () {
        addTextPane.setDisable(true);
        addTextPane.setVisible(false);
        textToAdd.clear();

        displayImage.setEffect(null);
    }

    public void submitText () {
        String text = textToAdd.getText();
        imgText.setText(text);
        imgText.setTextFill(textColor.getValue());
        imgText.toFront();

        cancelAddText();
    }

    public void changeTextColor () {
        imgText.setTextFill(textColor.getValue());
    }

    public void showDetails() throws Exception {
        File imgFile = imageFiles.get(currentImage - 1);
        Image img = displayImage.getImage();
        String fileName = imgFile.getName();

        detailName.setText(fileName);

        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
        detailType.setText(fileType);

        double fileSizeInKB = imgFile.length() / 1024.0;
        detailSize.setText(fileSizeInKB + " KB");

        int width = (int) img.getWidth();
        int height = (int) img.getHeight();
        detailDimensions.setText(width + " x " + height + " pixels");

        detailPane.setDisable(false);
        detailPane.setVisible(true);
        detailPane.toFront();

        displayImage.setEffect(blurEffect);
    }

    public void closeDetailPane() {
        detailPane.setDisable(true);
        detailPane.setVisible(false);

        displayImage.setEffect(null);
    }

    public void chooseImage() throws Exception {
        String name = imageChoiceBox.getValue();

        for (File imageFile : imageFiles) {
            if (imageFile.getName().equals(name)) {
                currentImage = imageFiles.indexOf(imageFile) + 1;
                break;
            }
        }

        displayImage.setImage(images.get(currentImage-1));

        for (ImageView imagePreview : imageViews) {
            if (imageViews.indexOf(imagePreview) + 1 == currentImage) {
                imagePreview.setEffect(blurEffect);
            } else {
                imagePreview.setEffect(null);
            }
        }
    }
}
