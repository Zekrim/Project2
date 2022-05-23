import javax.swing.*;
import java.awt.*;

public class Main extends JFrame { // Class that displays a rudimentary keyboard and allows you to play musical tones using the home row

    private static boolean[] homeRow = new boolean[10]; // an array to store the state of the home row keys
    private static final double[] frequencies = {174.61, 196.00, 220.00, 246.94, 261.63, 293.66, 329.63, 349.23, 392.00, 440}; // Constants representing frequencies of tones F3-A4
    public Main() { // Defines a structure for the GUI to use
        super("Keyboard");
        getContentPane().setBackground(Color.WHITE);
        setSize(1440, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);                
    }
 
    void drawRectangles(Graphics g) { // Creates the Piano "Keys"
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < 10; i++) {
            g2d.drawRect(7 + 144 * i, 650, 144, 250);
        }
    }
 
    public void paint(Graphics g) { // Draws the pianos onto the frame
        super.paint(g);
        drawRectangles(g);
    }

    public static double[] tone(double hz, double duration) { // Plays a sine wave representing a particular tone
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a; 
    } 

    private static void updateHomeRowArr() { // Updates the state of the array using the home row
        homeRow[0] = KeyListener.isKeyPressed('A');
        homeRow[1] = KeyListener.isKeyPressed('S');
        homeRow[2] = KeyListener.isKeyPressed('D');
        homeRow[3] = KeyListener.isKeyPressed('F');
        homeRow[4] = KeyListener.isKeyPressed('G');
        homeRow[5] = KeyListener.isKeyPressed('H');
        homeRow[6] = KeyListener.isKeyPressed('J');
        homeRow[7] = KeyListener.isKeyPressed('K');
        homeRow[8] = KeyListener.isKeyPressed('L');
        homeRow[9] = KeyListener.isKeyPressed(';');
    }
  
    public static void main(String[] args) throws Exception {
        new Main().setVisible(true);
        
        while(true) {
            updateHomeRowArr();
            double averageFrequency = 0;
            int numKeysPressed = 0;
            for(int i = 0; i < homeRow.length; i++) {
                if(homeRow[i]) {
                    averageFrequency += frequencies[i];
                    numKeysPressed++; 
                }
            }
            if(numKeysPressed != 0) { // Plays the combination of all of the frequencies to emulate chords
                averageFrequency /= numKeysPressed; // It does *not* handle coords well
                System.out.println(averageFrequency);
                StdAudio.play(tone(averageFrequency, 0.2));
            }
        }
    }    
}