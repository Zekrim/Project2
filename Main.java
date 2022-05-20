import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
 
    public Main() {
        super("Keyboard");
 
        getContentPane().setBackground(Color.WHITE);
        setSize(1440, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < 10; i++) {
            g2d.drawRect(7 + 144 * i, 650, 144, 250);
        }
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }
 
    public static void main(String[] args) throws Exception {
        new Main().setVisible(true);
        while(true) {
            if(KeyListener.isKeyPressed('A')) {
                System.out.println("Test");
            }
            if(KeyListener.isKeyPressed('S')) {

            }
            if(KeyListener.isKeyPressed('D')) {

            }
            if(KeyListener.isKeyPressed('F')) {

            }
            if(KeyListener.isKeyPressed('G')) {

            }
            if(KeyListener.isKeyPressed('H')) {

            }
            if(KeyListener.isKeyPressed('J')) {

            }
            if(KeyListener.isKeyPressed('K')) {

            }
            if(KeyListener.isKeyPressed('L')) {

            }
            if(KeyListener.isKeyPressed(';')) {
                
            }
            
            System.out.println("test2");
        }
    }

    
}