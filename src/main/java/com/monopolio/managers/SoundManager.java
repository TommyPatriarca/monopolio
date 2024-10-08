package com.monopolio.managers;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Gestisce l'uso dell'audio all'interno del gioco.
 */
public class SoundManager {
    private static Clip clip;

    /**
     * Permette di avviare l'audio.
     */
    public static void play() {
        try {
            InputStream file = SoundManager.class.getResourceAsStream("/audio/buttonSound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(file));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

            clip.start();

    }

    /**
     * Rappresenta il suono dell'errore e si sente nel gioco quando si vuole utilizzare un'opzione invalida.
     */
    public static void error() {
        try {
            InputStream file = SoundManager.class.getResourceAsStream("/audio/error.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(file));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        clip.start();

    }

    /**
     * Rappresenta il suono dei dadi quando vengono lanciati.
     */
    public static void dices() {
        try {
            InputStream file = SoundManager.class.getResourceAsStream("/audio/dice.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(file));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        clip.start();

    }

    /**
     * Raoppresenta il suono dei "Tesori" quando vengono estratti.
     */
    public static void treasure() {
        try {
            InputStream file = SoundManager.class.getResourceAsStream("/audio/treasure.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(file));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        clip.start();

    }
}
