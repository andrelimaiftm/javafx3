module br.edu.iftm.javafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens br.edu.iftm.javafx3 to javafx.fxml;
    exports br.edu.iftm.javafx3;
}