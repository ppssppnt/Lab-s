module org.openjfx.lab4_client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.fasterxml.jackson.databind;

    opens org.openjfx.lab4_client to javafx.fxml;
    exports org.openjfx.lab4_client;
}