package sleepfelix;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FXMLCalendarController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private Button confirm;

    @FXML
    private DatePicker calendar;

    @FXML
    private TableView<FXMLCalendarController> table;
    
    @FXML
    private TableColumn<FXMLCalendarController, Integer> colDate;

    @FXML
    private TableColumn<FXMLCalendarController, Integer> colHours;

   
    
    
    
    @FXML
    void backOnAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
            Stage stageTwo = new Stage();
            stageTwo.setScene(new Scene(root, 800, 400));
            stageTwo.show();
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
