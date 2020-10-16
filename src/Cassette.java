/**
 * Created by Katri Vidén
 * Date: 2020-09-12
 * Time: 14:52
 * Project: Inlämningsuppgift3Del2
 * Copyright: MIT
 *
 * Simuleraring/modell av en kassett.
 */
public class Cassette {

    private int currentTrack = 0;
    private String[] cassetteContent;

    /**
     * Konstruktor som används för att instansiera kassettobjektet med innehåll.
     *
     * @param cassetteContent Refererar till kassettens innehåll.
     */
    public Cassette(String[] cassetteContent) {
        this.cassetteContent = cassetteContent;
    }

    /**
     * Sätter kassettens nuvarande position.
     *
     * @param currentTrack Refererar till kassettens position.
     */
    public void setCurrentTrackIndex(int currentTrack) {
        this.currentTrack = currentTrack;
    }

    /**
     * Hämtar kassettens nuvarande position.
     *
     * @return Den nuvarande positionen/index.
     */
    public int getCurrentTrackIndex() {
        return currentTrack;
    }

    /**
     * Sätter kassettens innehåll.
     *
     * @param cassetteContent String[] med låttitlar.
     */
    public void setCassetteContent(String[] cassetteContent) {
        // Denna används inte men skulle kunna användas för att simulera tex 'record' på bandspelaren.
        this.cassetteContent = cassetteContent;
    }

    /**
     * Hämtar kassettens innehåll.
     *
     * @return String[] med låttitlar.
     */
    public String[] getCassetteContent() {
        return cassetteContent;
    }
}

