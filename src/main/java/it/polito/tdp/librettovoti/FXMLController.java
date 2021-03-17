package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Libretto model=new Libretto();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private DatePicker pickerEsame;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//leggi e controlla dati
    	String nomeEsame=txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: campo nome esame vuoto");
    		return;
    	}
    	String votoEsame=txtVoto.getText();
    	int votoInt=0;
    	try {
    		votoInt=Integer.parseInt(votoEsame);    		
    	}catch(NumberFormatException nfe) {
    		txtResult.setText("ERRORE: voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18||votoInt>30){
    		txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    	}
/*
    	String dataEsame=txtData.getText();
    	LocalDate data=null;
    	try {
    		data=LocalDate.parse(dataEsame);
    	}catch(DateTimeParseException dtpe) {
    		txtResult.setText("ERRORE: la data non è nel formato corretto");
    	}
    	*/
    	LocalDate data=pickerEsame.getValue();
    	if(data==null) {
    		txtResult.setText("ERRORE: la data è obbligatoria");
    		return;
    	}
    	
    	//esegui azione
    	Voto voto=new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	
    	//aggiorna i risultati nella Vista
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerEsame.setValue(null);
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"dateEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        //assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    public void setModel(Libretto model) {
    	this.model=model;
    }
}
