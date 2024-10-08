package com.monopolio.cli;

import com.monopolio.board.Box;
import com.monopolio.board.boxes.*;
import com.monopolio.managers.AlertManager;
import com.monopolio.managers.GameManager;
import com.monopolio.player.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Classe che permette l'interazione tramite linea di comando con l'utente.
 */
public class Cli implements Serializable {
    private Scanner s = new Scanner(System.in);
    private ArrayList<Box> posssedute1 = new ArrayList<Box>();
    private ArrayList<Box> posssedute2 = new ArrayList<Box>();
    private ArrayList<Box> posssedute3 = new ArrayList<Box>();
    private ArrayList<Box> posssedute4 = new ArrayList<Box>();
    private Player[] players = new Player[4];
    private GameManager gameManager;

    /**
     * Stampa a schermo il titolo del programma e successivamente chiama le funzioni per inizializzare e stampare la griglia.
     */
    public void startCli() {
        messageRed("\n------------------------------------- MONOPOLIO --------------------------------------------\n");
        askName();
        initBoard();
        printBoard();
        handle(false);
    }

    public void loadCli() {
        messageRed("\n------------------------------------- MONOPOLIO --------------------------------------------\n");
        printBoard();
        handle(true);
    }


    public void gameSelection(){
        int selection = 0;
        messagePrint("[0] Carica partita\n[1] Nuova partita");
        messagePrint("\nSelezione -> ");
        try {
             selection = Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e) {
            messageRed("Non hai inserto un numero");
        }
        switch (selection){
            case 0:
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.ser"));
                    Player[] players = (Player[]) in.readObject();
                    Box[] cities = (Box[]) in.readObject();
                    in.close();

                    gameManager = new GameManager(players, cities);
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                loadCli();
                break;
            case 1: gameManager = new GameManager(); startCli();
            break;
        }


    }

    /**
     * Chiede quanti giocatori voglio giocare e gli chiede il nome.
     */
    public void askName() {
        int nPlayer = 0;
        boolean flag2, flag;

        do {
            messagePrint("Quanti giocatori vogliono giocare? ( minimo -> 2 massimo -> 4)");
            messagePrint("\nSelezione -> ");
            try {
                nPlayer = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                messageRed("Non hai inserto un numero");
            }

        } while (!(nPlayer >= 2 && nPlayer <= 4));


        //Inserisce nomi
        switch (nPlayer) {
            case 2:
                flag = true;
                do {
                    messagePrint("\nInserisci il nome del giocatore 1");
                    messagePrint("\nSelezione -> ");
                    String n1 = s.nextLine();

                    Player player1 = new Player(n1);
                    players[0] = player1;

                    messagePrint("\nInserisci il nome del giocatore 2");
                    messagePrint("\nSelezione -> ");
                    String n2 = s.nextLine();
                    Player player2 = new Player(n2);
                    players[1] = player2;

                    Player player3 = new Player("");
                    players[2] = player3;
                    Player player4 = new Player("");
                    players[3] = player4;

                    flag2 = gameManager.duplicateNames(players);

                    //SE I NOMI SONO DUPLICATI
                    if (flag2 == false) {
                        gameManager.setPlayer(0, player1);
                        gameManager.getPlayer(0).setMyTurn(true);
                        gameManager.setPlayer(1, player2);
                        gameManager.setPlayer(2, player3);
                        gameManager.setPlayer(3, player4);
                        message("\n");
                        flag = false;
                    } else {
                        messageRed("Non puoi inserire un nome uguale ad un altro");
                    }

                } while (flag);
                break;

            case 3:
                flag = true;
                do {
                    messagePrint("\nInserisci il nome del giocatore 1");
                    messagePrint("\nSelezione -> ");
                    String n1 = s.nextLine();
                    Player player1 = new Player(n1);
                    players[0] = player1;

                    messagePrint("\nInserisci il nome del giocatore 2");
                    messagePrint("\nSelezione -> ");
                    String n2 = s.nextLine();
                    Player player2 = new Player(n2);
                    players[1] = player2;

                    messagePrint("\nInserisci il nome del giocatore 3");
                    messagePrint("\nSelezione -> ");
                    String n3 = s.nextLine();
                    Player player3 = new Player(n3);
                    players[2] = player3;

                    Player player4 = new Player("");
                    players[3] = player4;

                    flag2 = gameManager.duplicateNames(players);

                    //SE I NOMI SONO DUPLICATI
                    if (flag2 == false) {
                        gameManager.setPlayer(0, player1);
                        gameManager.getPlayer(0).setMyTurn(true);
                        gameManager.setPlayer(1, player2);
                        gameManager.setPlayer(2, player3);
                        gameManager.setPlayer(3, player4);
                        message("\n");
                        flag = false;
                    } else {
                        messageRed("Non puoi inserire un nome uguale ad un altro");
                    }

                } while (flag);
                break;

            case 4:
                flag = true;
                do {
                    messagePrint("\nInserisci il nome del giocatore 1");
                    messagePrint("\nSelezione -> ");
                    String n1 = s.nextLine();
                    Player player1 = new Player(n1);
                    players[0] = player1;

                    messagePrint("\nInserisci il nome del giocatore 2");
                    messagePrint("\nSelezione -> ");
                    String n2 = s.nextLine();
                    Player player2 = new Player(n2);
                    players[1] = player2;

                    messagePrint("\nInserisci il nome del giocatore 3");
                    messagePrint("\nSelezione -> ");
                    String n3 = s.nextLine();
                    Player player3 = new Player(n3);
                    players[2] = player3;

                    messagePrint("\nInserisci il nome del giocatore 4");
                    messagePrint("\nSelezione -> ");
                    String n4 = s.nextLine();
                    Player player4 = new Player(n4);
                    players[3] = player4;

                    flag2 = gameManager.duplicateNames(players);

                    //SE I NOMI SONO DUPLICATI
                    if (flag2 == false) {
                        gameManager.setPlayer(0, player1);
                        gameManager.getPlayer(0).setMyTurn(true);
                        gameManager.setPlayer(1, player2);
                        gameManager.setPlayer(2, player3);
                        gameManager.setPlayer(3, player4);
                        message("\n");
                        flag = false;
                    } else {
                        messageRed("Non puoi inserire un nome uguale ad un altro");
                    }

                } while (flag);
                break;
        }
    }

    /**
     * Inizializza la griglia delle città inserendo le città nelle varie posizioni.
     */
    public void initBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 || i == 8 || j == 0 || j == 8) {
                    int number;
                    if (i == 0) {
                        number = j + 1;
                    } else if (j == 8) {
                        number = 9 + i;
                    } else if (i == 8) {
                        number = 25 - j;
                    } else {
                        number = 33 - i;
                    }
                    gameManager.initCity(number - 1);
                }
            }
        }
    }


    /**
     * Chiama tutte le funzioni che permettono lo svolgimento del gioco.
     */
    public void handle(boolean load) {
        boolean flag = false;

        if(load) {
            initBoard();
        }

        while (true) {
            int count = 0;

            for (Player player : gameManager.getPlayers()) {
                if (player.getName().isEmpty()) {
                    count++;
                }
            }

            //FINITO IL GIOCO
            if (count == 3) {
                message("\033[0;32m" + gameManager.getCurrentPlayer().getName().toUpperCase() + " HA VINTO!" + "\033[0m");
                return;
            }

            if (!gameManager.getCurrentPlayer().getName().isEmpty()) {
                askDice();
                flag = false;
                while (!flag) {
                    flag = askChoose();
                }
            }
        }
    }


    /**
     * Chiede all'utente di lanciare i dadi e verifica che sia possibile farlo.
     */
    public void askDice() {
        boolean flag = false, flag2 = false;
        int d1 = 0, d2 = 0;

        message("\n\n-----------------------------------------------------------------------------");
        message("\033[0;32m" + "TURNO DI " + gameManager.getCurrentPlayer().getName().toUpperCase() + "\033[0m");


        if (gameManager.getCurrentPlayer().inPrison()) {
            if (gameManager.getCurrentPlayer().getTurnsInPrison() == 2) {
                message("\033[0;32m" + gameManager.getCurrentPlayer().getName().toUpperCase() + " è uscito di prigione" + "\033[0m");
                gameManager.getCurrentPlayer().setInPrison(false);
                askDice();
            } else {
                messageRed("\nSei in prigione! Non potrai avanzare in questo turno");
                message("Vuoi pagare 100$ per uscire subito di prigione? (sennò starai in prigione per 3 turni) (si/no)");
                messagePrint("Selezione -> ");
                String choose = s.nextLine();

                do {
                    if (choose.toLowerCase().trim().equals("si")) {
                        //ESCE DI PRIGIONE
                        message("\033[0;32m" + gameManager.getCurrentPlayer().getName().toUpperCase() + " è uscito di prigione" + "\033[0m");
                        gameManager.getCurrentPlayer().setInPrison(false);
                        gameManager.getCurrentPlayer().removeMoney(100);
                        askDice();
                        flag2 = true;
                    } else if (choose.toLowerCase().trim().equals("no")) {
                        gameManager.getCurrentPlayer().setTurnsInPrison(gameManager.getCurrentPlayer().getTurnsInPrison() + 1);
                        flag2 = true;
                    }
                } while (!flag2);
            }
        } else {
            gameManager.getCurrentPlayer().setInPrison(false);

            do {
                message("\nInserire " + "si" + " per tirare i dadi");
                messagePrint("Selezione -> ");
                String choose = s.nextLine();
                if (choose.toLowerCase().trim().equals("si")) {
                    d1 = gameManager.throwDice();
                    message("\033[0;36m" + "Dado 1 -> " + d1 + "\033[0m");
                    d2 = gameManager.throwDice();
                    message("\033[0;36m" + "Dado 2 -> " + d2 + "\033[0m");
                    message("\033[0;36m" + "Spostamento di " + (d1 + d2) + " caselle" + "\033[0m");
                    flag = true;
                }
            } while (!flag);

            gameManager.getCurrentPlayer().moveForward(d1 + d2);
            //CITY
            if (gameManager.getCity(gameManager.getCurrentPlayer().getPosition()) instanceof City) {
                City city = (City) gameManager.getCity(gameManager.getCurrentPlayer().getPosition());
                message("\033[0;36m" + "Posizione attuale: " + gameManager.getCity(gameManager.getCurrentPlayer().getPosition()).getNome().replace("\n", " ") + " -> Prezzo: " + city.getPrice() + "$" + "\033[0m");
                if (city.isOwned() && city.getOwner() != gameManager.getCurrentPlayer()) {
                    city.getPaid(gameManager.getCurrentPlayer());
                    city.getOwner().addMoney(city.getPayment(city.getHouseNumber()));
                    messageRed(gameManager.getCurrentPlayer().getName().toUpperCase() + " ha pagato per essere passato su una proprietà già acquistata");
                    //message("\033[0;36m" + "Saldo attuale: " + gameManager.getCurrentPlayer().getMoney() + "\033[0m");
                }
                //STATION
            } else if (gameManager.getCity(gameManager.getCurrentPlayer().getPosition()) instanceof Stations) {
                Stations stations = (Stations) gameManager.getCity(gameManager.getCurrentPlayer().getPosition());
                message("\033[0;36m" + "Posizione attuale: " + gameManager.getCity(gameManager.getCurrentPlayer().getPosition()).getNome().replace("\n", " ") + " -> Prezzo: " + stations.getPrice() + "$" + "\033[0m");
                if (stations.isOwned() && stations.getOwner() != gameManager.getCurrentPlayer()) {
                    stations.getPaid(gameManager.getStationsOwned(gameManager.getCurrentPlayer()), gameManager.getCurrentPlayer());
                    stations.getOwner().addMoney(stations.getBasePayment());
                    messageRed(gameManager.getCurrentPlayer().getName().toUpperCase() + " ha pagato per essere passato su una proprietà già acquistata");
                    //message("\033[0;36m" + "Saldo attuale: " + gameManager.getCurrentPlayer().getMoney() + "\033[0m");
                }
            } else {
                message("\033[0;36m" + "Posizione attuale: " + gameManager.getCity(gameManager.getCurrentPlayer().getPosition()).getNome().replace("\n", " ") + "\033[0m");

                //TREASURES
                if (gameManager.getCity(gameManager.getCurrentPlayer().getPosition()) instanceof Treasures) {
                    Treasures treasures = (Treasures) gameManager.getCity(gameManager.getCurrentPlayer().getPosition());
                    message("\033[0;32m" + gameManager.getCurrentPlayer().getName().toUpperCase() + " ha ottenuto un premio per essere passato sulla casella Tesori" + "\033[0m");
                    gameManager.extractTreasure(treasures.pickRandomIndex(), gameManager.getCurrentPlayer());
                    //PRISON
                } else if (gameManager.getCity(gameManager.getCurrentPlayer().getPosition()) instanceof ToPrison) {
                    ToPrison toPrison = (ToPrison) gameManager.getCity(gameManager.getCurrentPlayer().getPosition());
                    messageRed(gameManager.getCurrentPlayer().getName().toUpperCase() + " è andato in prigione per essere passato sulla casella Vai in Prigione");
                    toPrison.toPrison(gameManager.getCurrentPlayer());
                    //TAXES
                } else if (gameManager.getCity(gameManager.getCurrentPlayer().getPosition()) instanceof Taxes) {
                    Taxes taxes = (Taxes) gameManager.getCity(gameManager.getCurrentPlayer().getPosition());
                    messageRed(gameManager.getCurrentPlayer().getName().toUpperCase() + " ha pagato per essere passato sulla casella Tassa");
                    taxes.redeemTaxes(gameManager.getCurrentPlayer());
                } else if (gameManager.getCity(gameManager.getCurrentPlayer().getPosition()) instanceof Chances) {
                    Chances chance = (Chances) gameManager.getCity(gameManager.getCurrentPlayer().getPosition());
                    gameManager.extractChance(chance.pickRandomIndex(), gameManager.getCurrentPlayer());
                }
            }
            message("\033[0;36m" + "Saldo attuale: " + gameManager.getCurrentPlayer().getMoney() + "$" + "\033[0m");
        }
    }

    /**
     * Chiede all'utente l'azione se vuole terminare il turno, comprare una proprietà, vendere una proprietà o visualizzare le proprietà degli altri giocatori.
     */
    public boolean askChoose() {
        int selection = 5, selezione = 5;
        boolean flag = false;

        if (gameManager.getCurrentPlayer().inPrison()) {
            //FINE TURNO
            for (int i = 0; i < 4; i++) {
                if (gameManager.getPlayer(i).isMyTurn()) {
                    gameManager.getPlayer(i).setMyTurn(false);
                    if (i == 3 || gameManager.getPlayer(i + 1).getName().isEmpty()) {
                        gameManager.getPlayer(0).setMyTurn(true);
                    } else {
                        gameManager.getPlayer(i + 1).setMyTurn(true);
                    }
                    break;
                }
            }
        } else {
            do {
                message("\nQuale azione vuoi eseguire ?\n[0] Termina Turno\n[1] Compra Proprietà\n[2] Vendi Proprietà \n[3] Visualizza Proprietà Possedute da ogni giocatore \n[4] Visualizza Posizione di tutti i giocatori \n[5] Visualizza Griglia di gioco \n[6] Salva partita \n[104] Dichiara Bancarotta");
                messagePrint("\nSelezione -> ");
                try {
                    selection = Integer.parseInt(s.nextLine());
                    if (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6 && selection != 104) {
                        messageRed("\n Hai richiesto un'azione inesistente");
                    }
                } catch (NumberFormatException e) {
                    messageRed("Non hai inserto un numero");
                }
            } while (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6 && selection != 104);

            switch (selection) {
                case 0:
                    //SALDO NEGATIVO
                    do {
                        if (gameManager.getCurrentPlayer().getMoney() < 0) {
                            AlertManager.showError("Non puoi terminare il turno con il saldo in negativo");
                            return false;
                        } else {
                            flag = true;
                        }
                    } while (!flag);

                    //FINE TURNO
                    for (int i = 0; i < 4; i++) {
                        if (gameManager.getPlayer(i).isMyTurn()) {
                            gameManager.getPlayer(i).setMyTurn(false);
                            if (i == 3 || gameManager.getPlayer(i + 1).getName().isEmpty()) {
                                gameManager.getPlayer(0).setMyTurn(true);
                            } else {
                                gameManager.getPlayer(i + 1).setMyTurn(true);
                            }
                            break;
                        }
                    }

                    break;
                case 1:
                    Box box = gameManager.getCity(gameManager.getCurrentPlayer().getPosition());

                    do {
                        message("\nQuale azione vuoi eseguire ?\n[0] Torna Indietro\n[1] Compra Città\n[2] Compra Casa");
                        messagePrint("\nSelezione -> ");
                        try {
                            selezione = Integer.parseInt(s.nextLine());
                            if (selezione != 0 && selezione != 1 && selezione != 2) {
                                messageRed("\n Hai richiesto un'azione inesistente");
                            }
                        } catch (NumberFormatException e) {
                            messageRed("Non hai inserto un numero");
                        }
                    } while (selezione != 0 && selezione != 1 && selezione != 2);

                    switch (selezione) {
                        case 0:
                            return false;
                        case 1:
                            if (gameManager.buyPropety()) {
                                //SALVO LE PROPRIETA PER STAMPARLE
                                for (int i = 0; i < 4; i++) {
                                    if (gameManager.getPlayer(i).isMyTurn()) {
                                        switch (i) {
                                            case 0:
                                                posssedute1.add(box);
                                                break;
                                            case 1:
                                                posssedute2.add(box);
                                                break;
                                            case 2:
                                                posssedute3.add(box);
                                                break;
                                            case 3:
                                                posssedute4.add(box);
                                                break;
                                        }
                                    }
                                }
                            }
                            break;

                        case 2:
                            gameManager.buyHouse(box);
                            break;
                    }

                    message("\033[0;33m" + "Saldo attuale: " + gameManager.getCurrentPlayer().getMoney() + "\033[0m");
                    return false;

                case 2:
                    Box save = null;
                    flag = false;
                    boolean flag2 = false;
                    int count = 0;

                    do {
                        message("\nQuale azione vuoi eseguire ?\n[0] Torna Indietro\n[1] Vendi Città\n[2] Vendi Casa");
                        messagePrint("\nSelezione -> ");
                        try {
                            selezione = Integer.parseInt(s.nextLine());
                            if (selezione != 0 && selezione != 1 && selezione != 2) {
                                messageRed("\n Hai richiesto un'azione inesistente");
                            }
                        } catch (NumberFormatException e) {
                            messageRed("Non hai inserto un numero");
                        }
                    } while (selezione != 0 && selezione != 1 && selezione != 2);


                    switch (selezione) {
                        case 0:
                            return false;
                        case 1:
                            do {
                                printArr();
                                message("\nQuale proprietà vuoi vendere? (Inserire 'no' per annullare la vendita) ");
                                messagePrint("Selezione -> ");

                                String choose = s.nextLine();

                                if (choose.toLowerCase().trim().equals("no")) {
                                    return false;
                                } else {
                                    //CONTROLLO ESISTENZA CITTA
                                    for (Box c : gameManager.getCities()) {
                                        if (c.getNome().replace("\n", " ").toLowerCase().trim().equals(choose.toLowerCase().trim())) {
                                            message("Se vendi questa città otterrai solamente la metà del prezzo d'acquisto, vuoi vendere lo stesso? (si/no)");
                                            messagePrint("Selezione -> ");
                                            choose = s.nextLine();

                                            if (choose.toLowerCase().trim().equals("si")) {
                                                save = c;
                                                flag2 = true;
                                                flag = true;
                                            } else {
                                                flag = true;
                                                flag2 = false;
                                            }
                                            count++;
                                        }
                                    }

                                    if (count == 0) {
                                        messageRed("La città che hai inserito non esiste");
                                    }
                                }

                            } while (!flag);


                            if (gameManager.sellPropety(save) && flag2) {
                                //RIMUOVO LE PROPRIETA PER STAMPARLE
                                for (int i = 0; i < 4; i++) {
                                    if (gameManager.getPlayer(i).isMyTurn()) {
                                        switch (i) {
                                            case 0:
                                                posssedute1.remove(save);
                                                break;
                                            case 1:
                                                posssedute2.remove(save);
                                                break;
                                            case 2:
                                                posssedute3.remove(save);
                                                break;
                                            case 3:
                                                posssedute4.remove(save);
                                                break;
                                        }
                                    }
                                }
                            }
                            break;
                        case 2:
                            do {
                                printArr();
                                message("\nDi quale proprietà vuoi vendere la casa? (Inserire 'no' per annullare la vendita) ");
                                messagePrint("Selezione -> ");

                                String choose = s.nextLine();

                                if (choose.toLowerCase().trim().equals("no")) {
                                    return false;
                                } else {
                                    //CONTROLLO ESISTENZA CITTA
                                    for (Box c : gameManager.getCities()) {
                                        if (c.getNome().replace("\n", " ").toLowerCase().trim().equals(choose.toLowerCase().trim())) {
                                            message("Se vendi questa casa otterrai solamente la metà del prezzo d'acquisto, vuoi vendere lo stesso? (si/no)");
                                            messagePrint("Selezione -> ");
                                            choose = s.nextLine();

                                            if (choose.toLowerCase().trim().equals("si")) {
                                                save = c;
                                                flag2 = true;
                                                flag = true;
                                            } else {
                                                flag = true;
                                                flag2 = false;
                                            }
                                            count++;
                                        }
                                    }

                                    if (count == 0) {
                                        messageRed("La città che hai inserito non esiste");
                                    }
                                }

                            } while (!flag);

                            gameManager.sellHouse(save);
                    }

                    message("\033[0;33m" + "Saldo attuale: " + gameManager.getCurrentPlayer().getMoney() + "\033[0m");
                    return false;

                case 3:
                    printAll();
                    return false;
                case 4:
                    printAllPosition();
                    return false;
                case 5:
                    printBoard();
                    return false;
                case 6:
                    messagePrint(" Gioco salvato con successo");
                    gameManager.saveGame();
                    return false;
                case 104:
                    messageRed(gameManager.getCurrentPlayer().getName().toUpperCase() + " ha dichiarato bancarotta e si è ritirato");
                    gameManager.bankrupt(gameManager.currentPlayerIndex());
                    return true;
            }
        }
        return true;
    }

    /**
     * Stampa un messaggio a scelta.
     *
     * @param text messaggio che viene stampato.
     */
    public static void message(String text) {
        System.out.println(text);
    }

    /**
     * Stampa un messaggio a scelta senza andare a capo.
     *
     * @param text messaggio che viene stampato.
     */
    public void messagePrint(String text) {
        System.out.print(text);
    }

    /**
     * Stampa un messaggio a scelta di colore rosso.
     *
     * @param text messaggio che viene stampato.
     */
    public static void messageRed(String text) {
        System.out.println("\033[0;31m" + text + "\033[0m" + "\n");
    }

    /**
     * Stampa le proprietà possedute del giocatore a cui spetta il turno
     */
    public void printArr() {
        for (int i = 0; i < 4; i++) {
            if (gameManager.getPlayer(i).isMyTurn()) {
                switch (i) {
                    case 0:
                        if (posssedute1.isEmpty()) {
                            message("\033[0;33m" + "Proprietà possedute: { nessuna }" + "\033[0m");
                        } else {
                            messagePrint("\033[0;33m" + "Proprietà possedute: { " + "\033[0m");
                            for (Box box : posssedute1) {
                                if (posssedute1.size() == 1) {
                                    messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "\033[0m");
                                } else {
                                    messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                }
                            }
                            messagePrint("\033[0;33m" + " }" + "\033[0m");
                        }
                        break;
                    case 1:
                        if (posssedute2.isEmpty()) {
                            message("\033[0;33m" + "Proprietà possedute: { nessuna }" + "\033[0m");
                        } else {
                            messagePrint("\033[0;33m" + "Proprietà possedute: { " + "\033[0m");
                            for (Box box : posssedute2) {
                                if (posssedute2.size() == 1) {
                                    messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "\033[0m");
                                } else {
                                    messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                }
                            }
                            messagePrint("\033[0;33m" + " }" + "\033[0m");
                        }
                        break;
                    case 2:
                        if (posssedute3.isEmpty()) {
                            message("\033[0;33m" + "Proprietà possedute: { nessuna }" + "\033[0m");
                        } else {
                            messagePrint("\033[0;33m" + "Proprietà possedute: { " + "\033[0m");
                            for (Box box : posssedute3) {
                                if (posssedute3.size() == 1) {
                                    messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "\033[0m");
                                } else {
                                    messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                }
                            }
                            messagePrint("\033[0;33m" + " }" + "\033[0m");
                        }
                        break;
                    case 3:
                        if (posssedute4.isEmpty()) {
                            message("\033[0;33m" + "Proprietà possedute: { nessuna }" + "\033[0m");
                        } else {
                            messagePrint("\033[0;33m" + "Proprietà possedute: { " + "\033[0m");
                            for (Box box : posssedute4) {
                                if (posssedute4.size() == 1) {
                                    messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "\033[0m");
                                } else {
                                    messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                }
                            }
                            messagePrint("\033[0;33m" + " }" + "\033[0m");
                        }
                        break;
                }
            }
        }
    }

    /**
     * Stampa le proprietà di tutti i giocatori dopo la scelta dell'operazione.
     */
    public void printAll() {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    if (posssedute1.isEmpty()) {
                        message("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { nessuna }" + "\033[0m");
                    } else {
                        if (gameManager.getPlayer(i).getName().isEmpty()) {
                            break;
                        } else {
                            messagePrint("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { " + "\033[0m");
                            for (Box box : posssedute1) {
                                if(box instanceof City){
                                    City city = (City) box;
                                    if(city.getHouseNumber() > 0){
                                        messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "+" + city.getHouseNumber() + " case" + "\033[0m");
                                    }else{
                                        messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                    }
                                }
                            }
                            message("\033[0;33m" + " }" + "\033[0m");
                        }

                    }
                    break;
                case 1:
                    if (posssedute2.isEmpty() && !Objects.equals(gameManager.getPlayer(i).getName(), "")) {
                        message("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { nessuna }" + "\033[0m");
                    } else {
                        if (gameManager.getPlayer(i).getName().isEmpty()) {
                            break;
                        } else {
                            messagePrint("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { " + "\033[0m");
                            for (Box box : posssedute2) {
                                    if(box instanceof City){
                                        City city = (City) box;
                                        if(city.getHouseNumber() > 0){
                                            messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "+" + city.getHouseNumber() + " case" + "\033[0m");
                                        }else{
                                            messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                        }
                                    }
                            }
                            message("\033[0;33m" + " }" + "\033[0m");
                        }
                    }
                    break;
                case 2:
                    if (posssedute3.isEmpty() && !Objects.equals(gameManager.getPlayer(i).getName(), "")) {
                        message("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { nessuna }" + "\033[0m");
                    } else {
                        if (gameManager.getPlayer(i).getName().isEmpty()) {
                            break;
                        } else {
                            messagePrint("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { " + "\033[0m");
                            for (Box box : posssedute3) {
                                if(box instanceof City){
                                    City city = (City) box;
                                    if(city.getHouseNumber() > 0){
                                        messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "+" + city.getHouseNumber() + " case" + "\033[0m");
                                    }else{
                                        messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                    }
                                }
                            }
                            message("\033[0;33m" + " }" + "\033[0m");
                        }
                    }
                    break;
                case 3:
                    if (posssedute4.isEmpty() && !Objects.equals(gameManager.getPlayer(i).getName(), "")) {
                        message("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { nessuna }" + "\033[0m");
                    } else {
                        if (gameManager.getPlayer(i).getName().isEmpty()) {
                            break;
                        } else {
                            messagePrint("\033[0;33m" + gameManager.getPlayer(i).getName().toUpperCase() + " possiede: { " + "\033[0m");
                            for (Box box : posssedute4) {
                                if(box instanceof City){
                                    City city = (City) box;
                                    if(city.getHouseNumber() > 0){
                                        messagePrint("\033[0;33m" + box.getNome().replace("\n", " ") + "+" + city.getHouseNumber() + " case" + "\033[0m");
                                    }else{
                                        messagePrint("\033[0;33m" + "  " + box.getNome().replace("\n", " ") + "\033[0m");
                                    }
                                }
                            }
                            message("\033[0;33m" + " }" + "\033[0m");
                        }
                    }
                    break;
            }
        }
    }


    /**
     * Stampa la posizione dei player del gioco
     */
    public void printAllPosition() {
        for (int i = 0; i < 4; i++) {
            if (!gameManager.getPlayer(i).getName().isEmpty()) {
                message("\033[0;36m" + "  " + gameManager.getPlayer(i).getName().toUpperCase() + " si trova nella casella: " + gameManager.getCity(gameManager.getPlayer(i).getPosition()).getNome() + " e possiede un saldo di: " + gameManager.getPlayer(i).getMoney() + "$" + "\033[0m");
            }
        }
    }

    /**
     * Stampa la griglia del gioco
     */
    public void printBoard() {
        String[] playerMarkers = new String[32];
        for (int i = 0; i < playerMarkers.length; i++) {
            playerMarkers[i] = "   ";
        }
        String[] playerColors = new String[]{"\033[0;31m", "\033[0;32m", "\033[0;33m", "\033[0;34m"};
        for (int i = 0; i < 4; i++) {
            if (!gameManager.getPlayer(i).getName().isEmpty()) {
                int position = gameManager.getPlayer(i).getPosition();
                playerMarkers[position] += playerColors[i] + " x " + "\033[0m";
            }
        }

        String[] Yellow = new String[]{
                " - " + "\033[0;43m" + "      Traona     " + "\033[0m" + "" + playerMarkers[1],
                " - " + "\033[0;43m" + "      Andalo     " + "\033[0m" + "" + playerMarkers[3]
        };
        String[] Orange = new String[]{
                " - " + "\033[48;5;208m" + "      Regoledo   " + "\033[0m" + "" + playerMarkers[5],
                " - " + "\033[48;5;208m" + "     Talamona    " + "\033[0m" + "" + playerMarkers[6],
                " - " + "\033[48;5;208m" + "      Morbegno   " + "\033[0m" + "" + playerMarkers[7]
        };
        String[] White = new String[]{
                " - " + "\033[0;47m" + "      Ardenno    " + "\033[0m" + "" + playerMarkers[9],
                " - " + "\033[0;47m" + "     Villapinta  " + "\033[0m" + "" + playerMarkers[10],
                " - " + "\033[0;47m" + "     Berbenno    " + "\033[0m" + "" + playerMarkers[11]
        };
        String[] Pink = new String[]{
                " - " + "\033[48;5;213m" + "      Castione   " + "\033[0m" + "" + playerMarkers[15],
                " - " + "\033[48;5;213m" + "     Albosaggia  " + "\033[0m" + "" + playerMarkers[19]
        };
        String[] Purple = new String[]{
                " - " + "\033[0;45m" + "      Sondrio    " + "\033[0m" + "" + playerMarkers[19],
                " - " + "\033[0;45m" + "      Chiesa     " + "\033[0m" + "" + playerMarkers[18],
                " - " + "\033[0;45m" + "     Caspoggio   " + "\033[0m" + "" + playerMarkers[17]
        };
        String[] Green = new String[]{
                " - " + "\033[0;42m" + "    San Giacomo  " + "\033[0m" + "" + playerMarkers[23],
                " - " + "\033[0;42m" + "      Tirano     " + "\033[0m" + "" + playerMarkers[21]
        };
        String[] LightBlue = new String[]{
                " - " + "\033[48;5;123m" + "      Livigno    " + "\033[0m" + "" + playerMarkers[27],
                " - " + "\033[48;5;123m" + "      Sondalo    " + "\033[0m" + "" + playerMarkers[26],
                " - " + "\033[48;5;123m" + "      Grosio     " + "\033[0m" + "" + playerMarkers[25]
        };
        String[] Blue = new String[]{
                " - " + "\033[0;44m" + "     Trepalle    " + "\033[0m" + "" + playerMarkers[29],
                " - " + "\033[0;44m" + "      Bormio     " + "\033[0m" + "" + playerMarkers[31]
        };
        String[] Stations = new String[]{
                " - " + "\033[0;44m" + "  Stazione Nord  " + "\033[0m" + "" + playerMarkers[4],
                " - " + "\033[0;44m" + "   Stazione Est  " + "\033[0m" + "" + playerMarkers[12],
                " - " + "\033[0;44m" + "   Stazione Sud  " + "\033[0m" + "" + playerMarkers[20],
                " - " + "\033[0;44m" + "  Stazione Ovest " + "\033[0m" + "" + playerMarkers[28]
        };
        String[] Special = new String[]{
                " - " + "\033[0;44m" + "       Via       " + "\033[0m" + "" + playerMarkers[0],
                " - " + "\033[0;44m" + "    Probabilità  " + "\033[0m" + "" + playerMarkers[2],
                " - " + "\033[0;44m" + "    Probabilità  " + "\033[0m" + "" + playerMarkers[22],
                " - " + "\033[0;44m" + "      Tasse      " + "\033[0m" + "" + playerMarkers[30],
                " - " + "\033[0;44m" + "    Imprevisti   " + "\033[0m" + "" + playerMarkers[14],
                " - " + "\033[0;44m" + "     Prigione    " + "\033[0m" + "" + playerMarkers[8],
                " - " + "\033[0;44m" + "    Parcheggio   " + "\033[0m" + "" + playerMarkers[16],
                " - " + "\033[0;44m" + " Vai in Prigione " + "\033[0m" + "" + playerMarkers[24]
        };



        message(Special[0] + Yellow[0] + Special[1] + Yellow[1] +Stations[0] + Orange[0] + Orange[1] + Orange[2] +Special[5]);
        message(" ");
        message(" ");
        message(Blue[1] + "                                                                                                                                                                          " + White[0]);
        message(" ");
        message(" ");
        message(Special[3] + "                                                                                                                                                                          "+ White[1]);
        message(" ");
        message(" ");
        message(Blue[0] + "                                                                                                                                                                        " + White[2]);
        message(" ");
        message(" ");
        message(Stations[3] + "                                                                                                                                                                          " + Stations[1]);
        message(" ");
        message(" ");
        message(LightBlue[0] + "                                                                                                                                                                          " + Pink[0]);
        message(" ");
        message(" ");
        message(LightBlue[1] + "                                                                                                                                                                          " + Special[4]);
        message(" ");
        message(" ");
        message(LightBlue[2] + "                                                                                                                                                                          " + Pink[1]);
        message(" ");
        message(" ");
        message(Special[7] + Green[0] + Special[2] + Green[1] + Stations[2] + Purple[0] + Purple[1] + Purple[2] + Special[6]);
    }

}
