/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepfelix;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author k3vin
 */
public class FXMLDocumentController {
    
    @FXML
    private PasswordField txtpass;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    @FXML
    private Label label;

    @FXML
    private TextField txtuname;

    @FXML
    private Button btnok;
    
    @FXML
    private Button cancel;
    
    public void cancelOnAction(ActionEvent e){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    
  
    public void loginOnAction(ActionEvent e) {

       String uname = txtuname.getText();
       String pass = txtpass.getText();
       
       if(uname.equals("") && pass.equals("")){
           
           JOptionPane.showMessageDialog(null, "Username or Password Blank");
           
       } else{
           
         validateLogin();
           
       }
        
    }
    
   public void validateLogin(){
       DatabaseConnection connectNow = new DatabaseConnection();
       Connection connectDB = connectNow.getConnection();
       
       String verifyLogin = "SELECT count(1) FROM useraccount where username = '" + txtuname.getText() + "' AND password = '" + txtpass.getText() + "'";
       
       try{
           Statement statement = connectDB.createStatement();
           ResultSet queryResult = statement.executeQuery(verifyLogin);
           
           while(queryResult.next()){
               if(queryResult.getInt(1)==1){
                   JOptionPane.showMessageDialog(null, "Login Success");
                    Stage stage = (Stage) cancel.getScene().getWindow();
                    stage.close();
                    
                     try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLHomepage.fxml"));
            Stage stageTwo = new Stage();
            stage.setScene(new Scene(root, 800, 400));
            stage.show();
         
                     }
             catch (IOException e) {
            e.printStackTrace();
               }
                    
               } else {
                    JOptionPane.showMessageDialog(null, "Try Again");
               }
           }
           
       } catch (Exception e) {
           e.printStackTrace();
        }
   } 


    
}
