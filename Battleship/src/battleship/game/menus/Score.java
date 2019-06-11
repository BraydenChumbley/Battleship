/*
 * Tony Yu
 * June 6 2019
 * Scores of the player are sorted
 */
package battleship.game.menus;

import battleship.game.GAME_STATE;
import battleship.game.Game;
import battleship.game.Sorting;
import battleship.game.uicomponents.Button;
import battleship.game.uicomponents.InputField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author toyu2550
 */
public class Score extends JPanel {

    //private Image background;
    private JTextArea txtDisplay;
    private JLabel lblScore;
    private JButton backBtn;
    String display;
    
    Sorting sorting;

    public Score() {
     sorting=new Sorting();
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws IOException {
        setLayout(null);
        //background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST);
        setBackground(Color.black);

        setBounds(0, 0, Game.WIDTH, Game.HEIGHT);

        Rectangle b = getBounds();
        int startY = 200, height = 50;
        int padding = 10;

        backBtn = new Button("Back", padding, startY + (padding + height) * (-3), (int) (b.getWidth() - (90 * padding)), height);
        backBtn.setForeground(Color.red);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.MAIN_MENU);
            }
        });

        lblScore = new JLabel();
        txtDisplay = new JTextArea();

        FileReader fr = new FileReader("src\\battleship\\scoreFile.txt");
        BufferedReader br = new BufferedReader(fr);
       
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(4);
        data.add(3);
        data.add(5);
        
        sorting.quickSort(data, 0, data.size()-1);
        System.out.println(data);//------------------------
        txtDisplay.setText(display);

        lblScore.setText("SCORE"); //Not working
        lblScore.setForeground(Color.white); //Not working
        txtDisplay.setBounds(390, 100, 500, 700);
        txtDisplay.setForeground(Color.white);
        txtDisplay.setBackground(Color.gray);

        add(lblScore);
        add(txtDisplay);
        add(backBtn);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
