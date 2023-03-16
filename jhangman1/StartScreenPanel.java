package jhangman1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreenPanel extends JPanel implements ActionListener {

    private PlayButton playButton;
    private ExitButton exitButton;

    public StartScreenPanel(int WIDTH, int HEIGHT, ImageIcon backgroundImg, JPanel container, CardLayout cardLayout) {

        JLabel startScreenBg = new JLabel(backgroundImg);

        // Sets up the button dimensions
        int buttonWidth = 100;
        int buttonHeight = 50;
        int buttonY = HEIGHT - (buttonHeight * 3);

        // Sets up the PLAY button
        String playButtonText = "PLAY";
        int playButtonX = (WIDTH / 2) - (buttonWidth + 20);
        this.playButton = new PlayButton(playButtonText, playButtonX, buttonY, buttonWidth, buttonHeight, container, cardLayout);
        this.playButton.addActionListener(this);
        playButton.setBackground(new Color(4, 139, 154));
      
        // Create an ImageIcon object from the image file
//ImageIcon iconplay = new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/JHangman1/src/img/PalyButton.jpg");
// Set the icon on the playButton
//playButton.setIcon(iconplay);

        // Sets up the EXIT button
        String exitButtonText = "EXIT";
        int exitButtonX = (WIDTH / 2) + 20;
        this.exitButton = new ExitButton(exitButtonText, exitButtonX, buttonY, buttonWidth, buttonHeight);
        this.exitButton.addActionListener(this);
          exitButton.setBackground(new Color(4, 139, 154));
  //      ImageIcon iconexit = new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/JHangman1/src/img/ExitButton.jpg");
     // Set the icon on the playButton
  //     exitButton.setIcon(iconexit);
              

        this.setLayout(new BorderLayout());
        this.add(startScreenBg);

        startScreenBg.setLayout(null);
        startScreenBg.add(this.playButton);
        startScreenBg.add(this.exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.playButton) {
            this.playButton.swapCard("2");
        }

        if (e.getSource() == this.exitButton) {
            System.exit(0);
        }
    }
}
