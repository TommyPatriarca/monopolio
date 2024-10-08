package com.monopolio.listeners;

import com.monopolio.managers.AlertManager;
import com.monopolio.managers.GameManager;
import com.monopolio.managers.SceneManager;
import com.monopolio.ui.EndGame;
import com.monopolio.ui.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Gestisce la bancarotta selezionata dai giocatori, rimuovendili dal gioco.
 */
public class BankruptListener implements EventHandler<ActionEvent> {
    private GameManager gameManager;
    private Game game;
    private SceneManager sceneManager;

    public BankruptListener(GameManager gameManager, Game game, SceneManager sceneManager) {
        this.gameManager = gameManager;
        this.game = game;
        this.sceneManager = sceneManager;
    }

    /**
     * Aspetta un click del tasto "bancarotta" e se è rimasto solo un giocatore dichiara la vincita.
     * @param actionEvent è l'evento che corrisponde al click del bottone.
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        if(!AlertManager.showDialog("Are you sure you want to bankrupt? you will lose the game")) return;
        gameManager.bankrupt(gameManager.currentPlayerIndex());
        if(gameManager.lastPlayer()){
            EndGame endGame = new EndGame(true);
            sceneManager.closePane();
            endGame.start(new Stage());
        }
    }




}
