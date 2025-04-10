module edu.farmingdale.module_06_assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.module_06_assignment to javafx.fxml;
    exports edu.farmingdale.module_06_assignment;
}