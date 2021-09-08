package sleepfelix;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Homepage implements Initializable{

    private volatile boolean stop = false;
    private volatile boolean timestop = false;
    
    @FXML
    private Label time;

    @FXML
    private Text timer;

    @FXML
    private TextField alarmTime;

    @FXML
    private Button buttonCalendar;

    @FXML
    private Button buttonCalculator;

    @FXML
    public void buttonCalculatorOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCalculator.fxml"));
        
            Stage stage = (Stage) buttonCalculator.getScene().getWindow();
            stage.close();
        
        
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root, 450, 450));
        primaryStage.show();
        
        stage.close();
        stop = true;
    }

    
    @FXML
    public void buttonCalendarOnAction(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("FXMLCalendar.fxml"));
        
            Stage stage = (Stage) buttonCalendar.getScene().getWindow();
            stage.close();
        
        
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(new Scene(root, 600, 400));
        secondaryStage.setResizable(false);
        secondaryStage.show();
        
        stage.close();
        stop = true;
    }
    
    private void Timenow(){
        Thread thread = new Thread(() ->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            while(!stop){
                try{
                    Thread.sleep(50);
                }catch(Exception e){
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(()->{
                 time.setText(timenow);
                  if(timenow.equals(alarmTime.getText())){
                     JOptionPane.showMessageDialog(null, "Alarm");
                 }
                });
            }
        });
        thread.start();
    }
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timenow();
         
    }
    
}
