module com.github.grimbear42.charactercreator {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.github.grimbear42.charactercreator to javafx.fxml;
    exports com.github.grimbear42.charactercreator;
}
