package com.monopolio.managers;

import com.monopolio.Monopolio;
import com.monopolio.cli.Cli;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 * Rappresenta i vari tipi di messaggi che vengono utilizzati nel gioco.
 */
public class AlertManager {

    /**
     * Gestisce la finestra dell'alert.
     * @param string è ciò che stampa l'alert
     * @return "true" se è stato schiacciato il bottone ok, "false" se è stato schiacciato il bottone annulla
     */
    public static boolean showDialog(String string) {
        if(Monopolio.getInterfaceType() == InterfaceManager.InterfaceType.GUI) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            //alert.initOwner(primaryStage); // Imposta la finestra genitore
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText(string);

            // Applica lo stile alert personalizzato
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: #001845E0; -fx-border-radius: 10;");

            // Rimuove l'intestazione predefinita
            dialogPane.setHeader(null);

            dialogPane.getStyleClass().add("custom-alert");
            Stage stage = (Stage) dialogPane.getScene().getWindow();
            //stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.TRANSPARENT);

            // Modifica lo stile del contenuto del messaggio
            dialogPane.lookup(".content.label").setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-background-radius: 10;");

            // Modifica lo stile dei pulsanti dell'alert
            alert.getButtonTypes().forEach(buttonType -> {
                Button button = (Button) dialogPane.lookupButton(buttonType);
                button.setStyle("-fx-cursor: hand; -fx-background-color: #1081F9; -fx-text-fill: white; -fx-background-radius: 10;");
            });

            Optional<ButtonType> result = alert.showAndWait();
            return result.get() == ButtonType.OK;
        }

        return false;
    }

    /**
     * Stampa a schermio un messaggio.
     * @param string è il testo del messaggio che viene stampato.
     */
    public static void show(String string) {
        if(Monopolio.getInterfaceType() == InterfaceManager.InterfaceType.GUI) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            //alert.initOwner(primaryStage); // Imposta la finestra genitore
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText(string);

            // Applica lo stile alert personalizzato
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: #001845E0; -fx-border-radius: 10;");

            // Rimuove l'intestazione predefinita
            dialogPane.setHeader(null);

            dialogPane.getStyleClass().add("custom-alert");
            Stage stage = (Stage) dialogPane.getScene().getWindow();
            //stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.TRANSPARENT);

            // Modifica lo stile del contenuto del messaggio
            dialogPane.lookup(".content.label").setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-background-radius: 10;");

            // Modifica lo stile dei pulsanti dell'alert
            alert.getButtonTypes().forEach(buttonType -> {
                Button button = (Button) dialogPane.lookupButton(buttonType);
                button.setStyle("-fx-cursor: hand; -fx-background-color: #1081F9; -fx-text-fill: white; -fx-background-radius: 10;");
            });

            alert.showAndWait();
        }
    }


    /**
     * Stampa a schermo le regole del gioco.
     */
    public static void showRules() {
        if(Monopolio.getInterfaceType() == InterfaceManager.InterfaceType.GUI) {
            show("Obiettivo: Essere l'ultimo giocatore con soldi e proprietà.\n" +
                    "Setup: Ogni giocatore inizia con una quantità di denaro e si muove attorno al tabellone acquistando proprietà e pagando affitti.\n" +
                    "Turno: Lanci il dado e muovi il tuo pezzo. Puoi acquistare proprietà su cui atterri e costruire case o hotel per aumentare l'affitto.\n" +
                    "Affitto: Se atterri su una proprietà di un altro giocatore, devi pagare l'affitto in base alle regole specifiche della proprietà.\n" +
                    "Eventi speciali: Atterra su caselle \"Probabilità\" o \"Imprevisti\" per ricevere una carta che può darti vantaggi o svantaggi.\n" +
                    "Prigione: Puoi finire in prigione per diverse ragioni. Puoi uscire pagando una multa o tentando di tirare un doppio al dado.\n" +
                    "Fallimento: Se non puoi pagare un affitto o una tassa, devi vendere proprietà o dichiararti fallito. L'ultimo giocatore rimasto vince.");
        } else {
            // CLI
            System.out.println("Rules");
        }
    }

    /**
     * Viene utilizzato per mostrare un messaggio di errore .
     * @param error stringa di errore da stampare a schermo
     */
    public static void showError(String error) {
        if(Monopolio.getInterfaceType() == InterfaceManager.InterfaceType.GUI) {
            SoundManager.error();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.initOwner(primaryStage); // Imposta la finestra genitore
            alert.setTitle("Attenzione");
            alert.setHeaderText(null);
            alert.setContentText(error);

            // Applica lo stile alert personalizzato
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: #001845E0; -fx-border-radius: 10;");

            // Rimuove l'intestazione predefinita
            dialogPane.setHeader(null);

            // Arrotonda i bordi dell'alert
            dialogPane.getStyleClass().add("custom-alert");
            Stage stage = (Stage) dialogPane.getScene().getWindow();
            //stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.TRANSPARENT);

            // Modifica lo stile del contenuto del messaggio
            dialogPane.lookup(".content.label").setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-background-radius: 10;");

            // Modifica lo stile dei pulsanti dell'alert
            alert.getButtonTypes().forEach(buttonType -> {
                Button button = (Button) dialogPane.lookupButton(buttonType);
                button.setStyle("-fx-cursor: hand; -fx-background-color: #1081F9; -fx-text-fill: white; -fx-background-radius: 10;");
            });

            alert.showAndWait();
        }else{
            //CLI
            Cli.messageRed(error);
        }
    }


}
