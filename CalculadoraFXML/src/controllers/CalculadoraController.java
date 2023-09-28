package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Operaciones;

public class CalculadoraController {

    @FXML
    private TextField txtOperador1;

    @FXML
    private TextField txtOPerador2;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnCalcular;

    @FXML
    private RadioButton rbSumar;

    @FXML
    private ToggleGroup tgOperadores;

    @FXML
    private RadioButton rbRestar;

    @FXML
    private RadioButton rbMultiplicar;

    @FXML
    private RadioButton rbDividir;

    @FXML
    void calcular(ActionEvent event) {
    	
    	try {
    		/* Hacemos referencia a los dos Textfields donde 
    			se introducen los numeros a calcular */
    		double op1 = Double.parseDouble(this.txtOperador1.getText());
    		double op2 = Double.parseDouble(this.txtOPerador2.getText());
    		
    		Operaciones operaciones = new Operaciones(op1, op2);
    		if(this.rbSumar.isSelected()) {
    			this.lblResultado.setText(operaciones.sumar()+"");
    		} else if(this.rbRestar.isSelected()){
    			this.lblResultado.setText(operaciones.restar()+"");
    		} else if(this.rbMultiplicar.isSelected()){
    			this.lblResultado.setText(operaciones.multiplicar()+"");
    		} else if(this.rbDividir.isSelected()){
    			// Muestra una ventana de aviso si el operador 2 es 0
    			if(op2 == 0) {
    				Alert alert = new Alert(Alert.AlertType.ERROR);
    				alert.setHeaderText(null);
    				alert.setTitle("Error");
    				alert.setContentText("El operador 2 no puede ser 0");
    				alert.showAndWait();
    			} else {
    				this.lblResultado.setText(operaciones.dividir()+"");
    			}
    		} 
    	} catch (NumberFormatException e) {
    		// Muestra una ventana de alerta si el formato de los operadores es incorrecta
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    }
}
