package com.monopolio.managers;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Gestisce l'uso dell'audio all'interno del gioco.
 */
public class SongManager {
    private InputStream is = getClass().getResourceAsStream("/audio/track.wav");
    private Clip clip;
    private boolean muted;

    public SongManager() {
        this.muted = false;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permette di avviare l'audio.
     */
    public void play() {
        if (!muted) {
            clip.setFramePosition(0); // Riavvia dall'inizio
            clip.start();
            clip.loop(100);
        }
    }

    /**
     * Permette di disattivare il volume dell'audio.
     */
    public void mute() {
        clip.stop();
        muted = true;
    }

    /**
     * Permette di attivare il volume dell'audio.
     */
    public void unmute() {
        muted = false;
        clip.start();
        clip.loop(100);
    }

    /**
     * @return lo stato dell'audio.
     */
    public boolean isMuted() {
        return muted;
    }
}
