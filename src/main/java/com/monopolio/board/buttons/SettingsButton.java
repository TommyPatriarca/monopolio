package com.monopolio.board.buttons;

import com.monopolio.managers.AlertManager;
import com.monopolio.ui.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Gestisce bottone impostazioni.
 */
public class SettingsButton extends VBox {
    private Game game;
    private Stage primaryStage;
    private VBox subButtonsContainer;

    public SettingsButton(Game game, Stage primaryStage) {
        this.game = game;
        this.primaryStage = primaryStage;
        design();
        Image settingsImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/settings.png")), 30, 30, true, true);
        ImageView icon = new ImageView(settingsImage);

        Button mainButton = new Button();
        mainButton.setGraphic(icon);
        mainButton.setOnAction(event -> toggleSubButtons());

        subButtonsContainer = new VBox();
        subButtonsContainer.setSpacing(5);
        subButtonsContainer.setPadding(new Insets(5));
        subButtonsContainer.setBackground(new Background(new BackgroundFill(Color.web("#1081F9"), new CornerRadii(10), Insets.EMPTY)));

        getChildren().addAll(mainButton, subButtonsContainer);
        setSpacing(5);
    }

    /**
     * Disattiva i bottoni del sub-menù.
     */
    private void toggleSubButtons() {
        if (subButtonsContainer.getChildren().isEmpty()) {
            addSubButtons();
        } else {
            removeSubButtons();
        }
    }

    /**
     * Attiva i pulsanti del sub-menù.
     */
    private void addSubButtons() {
        Button rulesButton = createSubButton("Rules", event -> AlertManager.showRules());
        Button soundButton = createSubButton("Sound", event -> {});
        Button graphicsButton = createSubButton("Graphics", event -> {});
        Button languageButton = createSubButton("Language", event -> {});

        subButtonsContainer.getChildren().addAll(rulesButton, soundButton, graphicsButton, languageButton);
    }

    /**
     * Rimuove i bottoni del sub-menù.
     */
    private void removeSubButtons() {
        subButtonsContainer.getChildren().clear();
    }

    /**
     * Crea i bottoni del sub-menù.
     * @param text indica ciò che verrà scritto sul pulsante.
     * @param handler gestisce gli eventi di quando il bottone viene premuto.
     * @return il bottone.
     */
    private Button createSubButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button button = new Button(text);
        button.setPrefWidth(100);
        button.setOnAction(handler);
        return button;
    }

    /**
     * Imposta stile bottone.
     */
    public void design() {
        setBackground(new Background(new BackgroundFill(Color.web("#1081F9"), new CornerRadii(10), Insets.EMPTY)));
        setPadding(new Insets(5));
        setSpacing(5);
        setPrefSize(50, 50);
        setStyle(getStyle() + "-fx-cursor: hand; -fx-background-color: #1081F9; -fx-text-fill: white; -fx-background-radius: 15;");
    }
}
