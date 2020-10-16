import javax.swing.*;

/**
 * Simulering av en bandspelare och 2 kassetter.
 */
public class Main {

    /**
     * Huvudprogrammet av simuleringen.
     * @param args används ej
     */
    public static void main(String[] args) {

        String[] mixed = new String[]{
                "Abba: Dancing Queen",
                "Beatles: Here Comes The Sun",
                "Creedens Clearwater Revival: Have You Ever Seen The Rain",
                "Terry Reid: To Be Treated Right",
                "Eagels: Hotel California"};
        // Skapar en instans av klassen Cassette med 'mixed' some argument till konstruktorn
        Cassette mixTape = new Cassette(mixed);

        String[] mixed2 = new String[]{
                "Black Sabbath - Iron Man",
                "Deep Purple - Smoke On The Water",
                "Aerosmith - Dream On"};
        // Skapar en instans av klassen Cassette med 'mixed2' som argument till konstruktorn
        Cassette mixTape2 = new Cassette(mixed2);

        // Skapar en instans av klassen CassettePlayer
        CassettePlayer player = new CassettePlayer();

        String[] selection1 = new String[]{
                "Blandband Vol 1",
                "Blandband Vol 2"};

        // Skapar en icon för bandspelaren med hjälp av klassen ImageIcon
        ImageIcon icon = new ImageIcon(
                "icons/cassette.png");

        int pressedButton;
        while (true) {

            // Loopen utförs bara när det inte finns kassett i bandspelaren
            while (!player.hasCassette()) {
                player.diagnosticOutput();
                pressedButton = JOptionPane.showOptionDialog(null,
                        "Välj blandband att spela", "CassetteCollection", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, icon, selection1, selection1[0]);

                if (pressedButton == 0) {
                    player.insertCassette(mixTape);
                } else if (pressedButton == 1) {
                    player.insertCassette(mixTape2);
                } else {
                    JOptionPane.showMessageDialog(null, "Du valde att avsluta");
                    System.exit(0);
                }
            }
            String[] selection2 = new String[]{
                    "Play",
                    "Stop",
                    "Next",
                    "Rewind",
                    "Eject"};

            // Skapar en ny icon
            icon = new ImageIcon(
                    "icons/music.png");

            // Loopen utförs bara när det finns kassett i bandspelaren
            while (player.hasCassette()) {
                player.diagnosticOutput();
                pressedButton = JOptionPane.showOptionDialog(null, player.speakerOutput(),
                        "CassettePlayer", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        icon, selection2, selection2[0]);

                switch (pressedButton) {
                    case 0:
                        player.play();
                        player.speakerOutput();
                        break;
                    case 1:
                        player.stop();
                        break;
                    case 2:
                        player.next();
                        break;
                    case 3:
                        player.rewind();
                        break;
                    case 4:
                        player.eject();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Du valde att sluta");
                        System.exit(0);
                }
            }
        }
    }
}

