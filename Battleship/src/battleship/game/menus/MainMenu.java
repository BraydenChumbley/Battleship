/*
 * Brayden Josh Tony
 * May 27 2019
 * This is the main menu 
 */
package battleship.game.menus;

import battleship.game.AudioClip;
import battleship.game.uicomponents.Button;
import battleship.game.GAME_STATE;
import battleship.game.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.Font.font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author toyu2550
 */
public class MainMenu extends JPanel {

    private Image background;

    public MainMenu() {
        //Game.menuTheme.play();

        //audio.stop();
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws IOException {
        setLayout(null);
        background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST);
        setBounds(0, 0, Game.WIDTH, Game.HEIGHT);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btnPanel.setBounds(100, 0, 300, Game.HEIGHT);
        btnPanel.setBackground(new Color(50, 50, 50, 200));
        addButtons(btnPanel);

        ImageIcon titleImage = new ImageIcon(ImageIO.read(new File("res\\gfx\\title.png")).getScaledInstance(300, 90, Image.SCALE_FAST));
        JLabel titleLbl = new JLabel();
        titleLbl.setBounds(0, 50, 300, 90);
        titleLbl.setIcon(titleImage);
        btnPanel.add(titleLbl);

        add(btnPanel);

    }

    public void addButtons(JPanel p) {

        JButton play, options, credits, quit, score; //Create JButtons for all the options in menu
        int padding = 10;

        //Play Button
        play = new Button("START", padding, p.getHeight() / 4 + 25, p.getWidth() - padding * 2, 40); //Button displays START
        play.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 25)); //Set the font of the words

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.JOIN_MENU); //When the play button is clicked the Game State will change
            }
        });

        //Options Button
        options = new Button("OPTIONS", padding, p.getHeight() / 4 + 125, p.getWidth() - padding * 2, 40); //Button displays OPTIONS
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Options" + options.getFont());
            }
        });

        //Credits Button
        credits = new Button("CREDITS", padding, p.getHeight() / 4 + 225, p.getWidth() - padding * 2, 40); //Button displays CREDITS
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.CREDITS_MENU);
            }
        });

        //Score Button
        score = new Button("SCORE", padding, p.getHeight() / 4 + 325, p.getWidth() - padding * 2, 40); //Button displays SCORE
        score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.SCORE);
            }
        });

        //Quit Button
        quit = new Button("QUIT", padding, p.getHeight() / 4 + 425, p.getWidth() - padding * 2, 40); //Button displays QUIT
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        play.addMouseListener((MouseListener) play);
        options.addMouseListener((MouseListener) options);
        credits.addMouseListener((MouseListener) credits);
        score.addMouseListener((MouseListener) score);
        quit.addMouseListener((MouseListener) quit);

        p.add(play);
        p.add(options);
        p.add(credits);
        p.add(score);
        p.add(quit);

    }

    /**
     * This method is for drawing images in the menu
     *
     * @param g - Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);  //Background is being drawn    
    }
}
