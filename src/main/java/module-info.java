module ru.gb.bullsandcows {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.bullsandcows to javafx.fxml;
    exports ru.gb.bullsandcows;
}