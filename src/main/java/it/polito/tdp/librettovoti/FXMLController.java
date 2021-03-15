package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextField txtData;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//leggi e controlla dati
    	String nomeEsame=txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	String votoEsame=txtVoto.getText();
    	int votoInt=0;
    	try {
    		votoInt=Integer.parseInt(votoEsame);    		
    	}catch(Exception e) {
    		txtResult.setText("ERRORE: voto non valido");
    		return;
    	}

    	String dataEsame=txtData.getText();
    	LocalDate data=LocalDate.parse(dataEsame);
    	//TODO: AGGIUNGERE I CONTROLLI
    	
    	//esegui azione
    	Voto voto=new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	
    	//aggiorna i risultati nella Vista
    	txtResult.setText(model.toString());
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    public void setModel(Libretto model) {
    	this.model=model;
    }
}
