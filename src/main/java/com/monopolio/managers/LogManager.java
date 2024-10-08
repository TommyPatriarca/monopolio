package com.monopolio.managers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Gestisce e visualizza i log della Gui.
 */
public class LogManager {
    private Label logLabel;
    private Queue<String> logQueue;
    private String mainLog;

    public LogManager(Label logLabel) {
        this.logLabel = logLabel;
        this.logQueue = new LinkedList<>();
        this.mainLog = "";

        // Imposta l'allineamento del testo al centro
        logLabel.setAlignment(Pos.CENTER);

        // Personalizza lo stile del Label
        logLabel.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        logLabel.setFont(Font.font(logLabel.getFont().getName(), 14)); // Modifica la dimensione del font se necessario
        logLabel.setTextFill(Color.WHITE); // Modifica il colore del testo se necessario
    }

    /**
     * Imposta messaggio principale.
     * @param mainLog è il messaggio principale.
     */
    public void setMainLog(String mainLog) {
        this.mainLog = mainLog;
        updateLabelText();
    }

    /**
     * Aggiunge un nuovo messaggio alla coda.
     * @param message è il messaggio nuovo da aggiungere.
     */
    public void log(String message) {
        logQueue.offer(message);

        if (logQueue.size() > 3) {
            logQueue.poll();
        }
        updateLabelText();
    }

    /**
     * Combina il messaggio principale con i messaggi recenti.
     */
    private void updateLabelText() {
        StringBuilder sb = new StringBuilder();

        // Aggiungi la log principale con un distacco
        if (!mainLog.isEmpty()) {
            sb.append(mainLog).append("\n\n");
        }

        // Aggiungi le altre log dalla più recente alla più vecchia
        LinkedList<String> reversedQueue = new LinkedList<>(logQueue);
        while (!reversedQueue.isEmpty()) {
            sb.append(reversedQueue.pollLast()).append("\n");
        }

        logLabel.setText(sb.toString());
    }
}
