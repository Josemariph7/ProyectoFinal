module com.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.json;
    requires junit;
    requires org.junit.jupiter.api;

    opens controller to javafx.fxml;
    exports controller;
    opens view to javafx.graphics;
    exports view;
    opens model to javafx.base;

}