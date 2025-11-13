module com.example.animalgallery {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animalgallery to javafx.fxml;
    exports com.example.animalgallery;
}