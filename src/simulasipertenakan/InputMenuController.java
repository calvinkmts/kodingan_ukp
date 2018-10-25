/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasipertenakan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 * FXML Controller class
 *
 * @author calvi
 */
public class InputMenuController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    private Boolean stateAyam;
    private Boolean stateSapi;
    private Boolean stateDomba;
    
    @FXML
    private TextField textField_sapi;
    @FXML
    private TextField textField_ayam;
    @FXML
    private TextField textField_domba;
    @FXML
    private Button button_submit;
    @FXML
    private Label label_total;
    @FXML
    private Label label_totalHarga;
    @FXML
    private Label label_sapi;
    @FXML
    private Label label_ayam;
    @FXML
    private Label label_domba;
    @FXML
    private Spinner<Integer> spinner_hari;

    public InputMenuController() {
        this.stateDomba = false;
        this.stateSapi = false;
        this.stateAyam = false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //label_total.setText("0");
        label_totalHarga.setText("");
        label_sapi.setText("");
        label_ayam.setText("");
        label_domba.setText("");
        button_submit.setDisable(true);
        
        SpinnerValueFactory<Integer> valueFactory = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000000);
        
        spinner_hari.setValueFactory(valueFactory);
        
    }
    
    private void changeButtonState() {
        if (stateAyam.equals(true) && stateSapi.equals(true) && stateDomba.equals(true)) {
            button_submit.setDisable(false);
            
            Integer jumlahSapi = Integer.parseInt(textField_sapi.getText());
            Integer jumlahDomba = Integer.parseInt(textField_domba.getText());
            Integer jumlahAyam = Integer.parseInt(textField_ayam.getText());
            
            int jumlahHari = spinner_hari.getValue();
//            System.out.println(jumlahAyam * 50 * jumlahHari);
//            System.out.println(jumlahDomba * (jumlahHari / 7) * 500);
//            System.out.println(jumlahSapi * jumlahHari * 200);
//            System.out.println(jumlahHari);
            
            int totalHarga = jumlahAyam * 50 * jumlahHari 
                    + jumlahDomba * (jumlahHari / 7) * 500 
                    + jumlahSapi * jumlahHari * 200;
            
            label_totalHarga.setText(Integer.toString(totalHarga));
            
            DBConnect conn = new DBConnect();
            conn.insertData(jumlahSapi, jumlahAyam, jumlahDomba, jumlahHari, totalHarga);
        }
        else {
            button_submit.setDisable(true);
            label_totalHarga.setText("");
        }
    }

    @FXML
    private void handleSubmitButton(ActionEvent event) {
        System.out.println("Hello Test");
        
    }

    @FXML
    private void cekInputSapi(KeyEvent event) {
        stateSapi = false;
        try {
            Integer i1 = Integer.parseInt(textField_sapi.getText());
            label_sapi.setText(Integer.toString(i1));
            if (i1 >= 0 && i1 <= 10) {
                stateSapi = true;
                label_sapi.setText("Input Valid");
            } else if (i1 < 0) {
                label_sapi.setText("Input can't be less than 0");
            } else if (i1 > 10) {
                label_sapi.setText("Input can't be more than 10");
            } else {
                label_sapi.setText("Input Valid");
            }
        }catch (NumberFormatException e) {
            label_sapi.setText("Input is not valid");
        }
        changeButtonState();
    }
    
    @FXML
    private void cekInputDomba(KeyEvent event) {
        stateDomba = false;
         try {
            Integer i3 = Integer.parseInt(textField_domba.getText());
            label_domba.setText(Integer.toString(i3));
            if (i3 >= 0 && i3 <= 10) {
                stateDomba = true;
                label_domba.setText("Input Valid");
            } else if (i3 < 0) {
                label_domba.setText("Input can't be less than 0");
            } else if (i3 > 10) {
                label_domba.setText("Input can't be more than 10");
            } else {
                label_domba.setText("Input Valid");
            }
        }catch (NumberFormatException e) {
            label_domba.setText("Input is not valid");
        }
        changeButtonState();
    }

    

    @FXML
    private void cekInputAyam(KeyEvent event) {
        stateAyam = false;
        try {
            Integer i2 = Integer.parseInt(textField_ayam.getText());
            label_ayam.setText(Integer.toString(i2));
            if (i2 >= 0 && i2 <= 10) {
                stateAyam = true;
                label_ayam.setText("Input Valid");
            } else if (i2 < 0) {
                label_ayam.setText("Input can't be less than 0");
            } else if (i2 > 10) {
                label_ayam.setText("Input can't be more than 10");
            } else {
                label_ayam.setText("Input Valid");
            }
        }catch (NumberFormatException e) {
            label_ayam.setText("Input is not valid");
        }
        changeButtonState();
    }

    @FXML
    private void checkValue(MouseEvent event) {
        changeButtonState();
    }



    
}
