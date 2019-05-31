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
   
    //Set a name to all the audo clips 
    AudioClip menuTheme = new AudioClip("res\\audio\\song.wav");
    AudioClip creditsTheme = new AudioClip("res\\audio\\credits.wav");
    AudioClip battleTheme = new AudioClip("res\\audio\\battletheme.wav");
    AudioClip battleSetupTheme = new AudioClip("res\\audio\\battlesetup.wav");
    
    private Image background;

    public MainMenu() {
        menuTheme.play(); //When the menu runs start playing menu song
        //audio.stop();
        try {
            init();    
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init() throws IOException{
	setLayout(null);
	background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST); //
	setBounds(0, 0, Game.WIDTH, Game.HEIGHT); //Scale the background image to fit the whole screen
	
	JPanel btnPanel = new JPanel(); //JPanel is created for the buttons
	btnPanel.setLayout(null);
	btnPanel.setBounds(100, 0, 300, Game.HEIGHT); //Set the size of the JPanel
	btnPanel.setBackground(new Color(50, 50, 50, 200)); //Set the color of the background
	addButtons(btnPanel); //Add the buttons to JPanel
        
        ImageIcon titleImage = new ImageIcon(ImageIO.read(new File("res\\gfx\\title.png")).getScaledInstance(300, 90, Image.SCALE_FAST)); //Sets titleImage to the title of the image
        JLabel titleLbl = new JLabel(); //New JLabel is created for label
        titleLbl.setBounds(0,50,300,90); //Set the size of the label
        titleLbl.setIcon(titleImage); //Put the image onto the label
        btnPanel.add(titleLbl); //Add the label to the pannel
	add(btnPanel); 
        
	
    }
    
    public void addButtons(JPanel p){
	
	JButton play, options, credits, quit; //Create JButtons for all the options in menu
	int padding = 10;
	
	//Play Button
        
	play = new Button("START"); //Button displays START
        play.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 25)); //Set the font of the words
	play.setBounds(padding, p.getHeight()/4 + 25, p.getWidth()-padding*2, 40); //Set the size of the button
        ((Button) play).setTextColor(Color.ORANGE); //Set the font color 
        ((Button) play).setOutlineColor(Color.red); //Set the outline of the button
        ((Button)play).setBackgroundColor(Color.black); //Set the background of the button
        
	play.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		Game.setGameState(GAME_STATE.JOIN_MENU); //When the play button is clicked the Game State will change
	    }
	}
        );
        
        play.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)play).setBackgroundColor(Color.blue); //When the mouse is clicked the background turns blue
                ((Button)play).setBackgroundColor(Color.BLACK); //When the mouse is clicked the background turns black immediately after it turns blue to make it look like a clicked animation
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)play).setBackgroundColor(Color.blue); //When the mouse is pressed the background turns blue
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)play).setBackgroundColor(Color.BLACK); //When the mouse is released the background turns black
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)play).setOutlineColor(Color.cyan); //When the mouse is hovering over the button, the outline color of the button changes to cyan
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)play).setOutlineColor(Color.red); //When the mouse is no longer hovering over the button, the outline color changes back to normal
            }
        });
	
	
	//Options Button
	options = new Button("OPTIONS");
        options.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20));
        ((Button)options).setTextColor(Color.ORANGE);
        ((Button)options).setOutlineColor(Color.red);
        ((Button)options).setBackgroundColor(Color.BLACK);
	options.setBounds(padding, p.getHeight()/4 + 125, p.getWidth()-padding*2, 40);
	options.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Options" + options.getFont());
	    }
	});
        options.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)options).setBackgroundColor(Color.blue); //When the mouse is clicked the background turns blue
                ((Button)options).setBackgroundColor(Color.BLACK); //When the mouse is clicked the background turns black immediately after it turns blue to make it look like a clicked animation
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)options).setBackgroundColor(Color.blue); //When the mouse is pressed the background turns blue
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)options).setBackgroundColor(Color.BLACK); //When the mouse is released the background turns black
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)options).setOutlineColor(Color.cyan); //When the mouse is hovering over the button, the outline color of the button changes to cyan
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)options).setOutlineColor(Color.red); //When the mouse is no longer hovering over the button, the outline color changes back to normal
            }
        });
        
	//Credits Button
	credits = new Button("CREDITS");
        credits.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20));
        ((Button)credits).setTextColor(Color.ORANGE);
        ((Button)credits).setOutlineColor(Color.red);
        ((Button)credits).setBackgroundColor(Color.BLACK);
	credits.setBounds(padding, p.getHeight()/4 + 225, p.getWidth()-padding*2, 40);
	credits.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Credits");
                menuTheme.stop();
                creditsTheme.play();
	    }
	});
	credits.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)credits).setBackgroundColor(Color.blue); //When the mouse is clicked the background turns blue
                ((Button)credits).setBackgroundColor(Color.BLACK); //When the mouse is clicked the background turns black immediately after it turns blue to make it look like a clicked animation
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)credits).setBackgroundColor(Color.blue); //When the mouse is pressed the background turns blue
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)credits).setBackgroundColor(Color.BLACK); //When the mouse is released the background turns black
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)credits).setOutlineColor(Color.cyan); //When the mouse is hovering over the button, the outline color of the button changes to cyan
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)credits).setOutlineColor(Color.red); //When the mouse is no longer hovering over the button, the outline color changes back to normal
            }
        });
        
	//Quit Button
	quit = new Button("QUIT");
        quit.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20));
        ((Button)quit).setTextColor(Color.ORANGE);
        ((Button)quit).setOutlineColor(Color.red);
        ((Button)quit).setBackgroundColor(Color.BLACK);
	quit.setBounds(padding, p.getHeight()/4 + 325, p.getWidth()-padding*2, 40);
	quit.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	quit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)quit).setBackgroundColor(Color.blue); //When the mouse is clicked the background turns blue
                ((Button)quit).setBackgroundColor(Color.BLACK); //When the mouse is clicked the background turns black immediately after it turns blue to make it look like a clicked animation
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)quit).setBackgroundColor(Color.blue); //When the mouse is pressed the background turns blue
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)quit).setBackgroundColor(Color.BLACK); //When the mouse is released the background turns black
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)quit).setOutlineColor(Color.cyan); //When the mouse is hovering over the button, the outline color of the button changes to cyan
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)quit).setOutlineColor(Color.red); //When the mouse is no longer hovering over the button, the outline color changes back to normal
            }
        });
	p.add(play);
	p.add(options);
	p.add(credits);
	p.add(quit);
	
    }
    
    /**
     * This method is for drawing images in the menu
     * @param g - Graphics object
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);  //Background is being drawn    
    }
}
