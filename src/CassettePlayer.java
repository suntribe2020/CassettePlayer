/**
 * Created by Katri Vidén
 * Date: 2020-09-12
 * Time: 14:52
 * Project: Inlämningsuppgift3Del2
 * Copyright: MIT
 *
 * Simuleraring/modell av en bandspelare.
 */
public class CassettePlayer {

    private Cassette currentCassette = null;
    private boolean playing = false;

    /**
     * Konstruktor som används för att skriva ut ett litet meddelande till terminalen.
     */
    public CassettePlayer() {
        System.out.println("Grattis till din nya bandspelare!");
    }

    /**
     * Kontrollerar om bandspelaren har en kassett i.
     *
     * @return true eller false
     */
    public boolean hasCassette() {
        return currentCassette != null;
    }

    /**
     * Simulerar att kassetten sätts in i bandspelaren.
     *
     * @param newCassette Cassette-objekt som bandspelaren ska använda.
     */
    public void insertCassette(Cassette newCassette) {
        System.out.println("*Click* Du stoppar in en kassett i bandspelaren!");
        this.currentCassette = newCassette;
    }

    /**
     * Simulerar att bandspelaren sätts på.
     * playing sätts till true.
     */
    public void play() {
        if (currentCassette == null) {
            // Om kassett saknas så rapporteras detta.
            System.out.println("Det finns ingen kassett i bandspelaren!");
        } else if (currentCassette.getCurrentTrackIndex() == -1) {
            // Om kassetten har nått slutet så rapporteras detta.
            System.out.println("Bandet är slut, spola tillbaka för att lyssna igen.");
        } else if (!playing) {
            System.out.println("Du tryckte på play.");
            playing = true;
        } else {
            System.out.println("Bandet spelas redan.");
        }
    }

    /**
     * Simulerar att bandspelaren stoppas.
     * playing sätts till false.
     */
    public void stop() {
        if(playing) {
            System.out.println("Du tryckte på stopp, musiken slutar spela.");
            playing = false;
        } else {
            System.out.println("Bandet står redan stilla.");
        }
    }

    /**
     * Simulerar att bandspelaren hoppar över till nästa låt.
     */
    public void next() {
        if (currentCassette.getCurrentTrackIndex() == -1) {
            // Om bandet är slut (-1) rapporteras detta till terminalen.
            System.out.println("Du är redan i slutet av bandet.");
        } else if (currentCassette.getCurrentTrackIndex() < currentCassette.getCassetteContent().length - 1) {
            // Ökar värdet på currentTrack med +1 för att simulera byte av låt/position
            currentCassette.setCurrentTrackIndex(currentCassette.getCurrentTrackIndex() + 1);
            System.out.println("Du valde att hoppa till nästa låt.");
        } else {
            // Om bandet är i slutet sätts currentTrack till -1 för
            // att representera att bandet är slut. Playing sätts till false
            // för att simulera att bandspelaren stängs av.
            System.out.println("Bandet tog slut, spola tillbaka för att lyssna igen.");
            currentCassette.setCurrentTrackIndex(-1);
            playing = false;
        }
    }

    /**
     * Hämtar den nuvarande sångtiteln.
     *
     * @return En sträng med den nuvarande sångtitel.
     */
    private String getCurrentTrackName() { // private för  att den endast används inom klassen
        // ex; return content[1]
        int currentTrackIndex = currentCassette.getCurrentTrackIndex();
        return currentCassette.getCassetteContent()[currentTrackIndex];
    }

    /**
     * Simulerar att bandet spolas tillbaka.
     * Playing sätts till false.
     */
    public void rewind() {
        if (currentCassette.getCurrentTrackIndex() != 0) {
            currentCassette.setCurrentTrackIndex(0);
            System.out.println("Bandet spolas tillbaka.");
        } else {
            System.out.println("Bandet har redan spolats tillbaka.");
        }
        playing = false;
    }

    /**
     * Skriver ut information till användaren om
     * vad som sker i själva applikationen medans den körs.
     *
     * @return En sträng som skrivs ut i bandspelaren.
     */
    public String speakerOutput() {
        String output;
        if (currentCassette == null) {
            System.out.println("Inget band i spelaren");
            return "Du tog ut kassetten";
        }
        if (playing) {
            output = '\u266a' + " Nu spelas: " + getCurrentTrackName() + " " + '\u266a';
        } else if (currentCassette.getCurrentTrackIndex() == -1) {
            output = "Bandet är slut, spola tillbaka för att lyssna igen";
        } else {
            output = "Bandspelaren är avstängd.";
        }
        return output;
    }

    /**
     * currentCassette sätts till null för att simulera att
     * det inte finns någon kassett i bandspelaren.
     * playing sätts till false.
     */
    public void eject() {
        currentCassette = null;
        System.out.println("*Click* Du tog ut kassetten");
        playing = false;
    }

    /**
     * Presenterar programmets diagnostik i terminalen.
     */
    public void diagnosticOutput() {
        System.out.println("--------------------");
        System.out.println("****** Player ******");
        System.out.println();
        System.out.println("playing: " + playing);
        System.out.println("currentCassette: " + hasCassette());
        System.out.println("---------------------");
        System.out.println("***** Cassette *****");
        System.out.println();
        if(hasCassette()) {
            System.out.println("currentTrack: " + currentCassette.getCurrentTrackIndex());
            System.out.println("cassetteContent length: " + currentCassette.getCassetteContent().length);
        } else {
            System.out.println("Ingen kassett i bandspelaren");
        }
        System.out.println("---------------------");

    }
}
