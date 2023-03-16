package jhangman1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryScreenPanel extends JPanel implements ActionListener {

    final String[] categoryButtonsText = {"CyberSecurity", "AI", "Web Dev"};
    private CategoryButton[] categoryButtons = new CategoryButton[3];
    private BackButton backButton;
    private MainGamePanel mainGamePanel;
    private Words words;

    public CategoryScreenPanel(int WIDTH, int HEIGHT, ImageIcon backgroundImg, JPanel container, CardLayout cardLayout, MainGamePanel mainGamePanel, Words words) {
        this.mainGamePanel = mainGamePanel;
        this.words = words;

        JLabel categoryScreenBg = new JLabel(backgroundImg);

        this.setLayout(new BorderLayout());
        this.add(categoryScreenBg);

        categoryScreenBg.setLayout(null);
        
           // Ajouter le JLabel avec le texte spécifié **
        JLabel welcomeLabel = new JLabel("<html><center> Welcome to Hangman! The objective of the game is to guess the hidden word before the hangman is fully drawn. You can guess the word by selecting letters one at a time. If the letter is in the word, it will be revealed in the blank spaces. If the letter is not in the word, the hangman will start to be drawn, piece by piece. You have a limited number of incorrect guesses before the hangman is fully drawn and the game is over. Good luck!</center></html>");
        Font font = new Font("Caveat", Font.PLAIN, 18); // la police ne change pas ??????
        welcomeLabel.setBounds(120,180, 550, 200); // Définir les coordonnées et les dimensions du JLabel
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(Color.WHITE);
        categoryScreenBg.add(welcomeLabel);
        
         ImageIcon imageIcon = new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/JHangman1/src/img/background2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, WIDTH, HEIGHT);
        categoryScreenBg.add(imageLabel);

        JPanel buttonsPanel = new JPanel();
        int buttonsPanelWidth = 500;
        int buttonsPanelHeight = 50;
        int buttonsPanelX = (WIDTH / 2) - (buttonsPanelWidth / 2);
        int buttonsPanelY = HEIGHT - (buttonsPanelHeight * 3);
        buttonsPanel.setBounds(buttonsPanelX, buttonsPanelY, buttonsPanelWidth, buttonsPanelHeight);
        buttonsPanel.setLayout(new GridLayout());
       

        categoryScreenBg.add(buttonsPanel);

        for (int i=0; i<this.categoryButtonsText.length; i++) {
            CategoryButton categoryButton = new CategoryButton(this.categoryButtonsText[i], container, cardLayout);
            categoryButton.setCategory(this.categoryButtonsText[i].toLowerCase());
            this.categoryButtons[i] = categoryButton;
            categoryButton.setBackground(new Color(4, 139, 154));
            categoryButton.addActionListener(this);
            buttonsPanel.add(categoryButton);
        }

        String backButtonText = "BACK";
        this.backButton = new BackButton(backButtonText, container, cardLayout);
        this.backButton.addActionListener(this);
        buttonsPanel.add(this.backButton);
        backButton.setBackground(new Color(4, 139, 154));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

         for (CategoryButton categoryButton : this.categoryButtons) {
             if (e.getSource() == categoryButton) {
                 categoryButton.swapCard(this.words, this.mainGamePanel);
             }
         }

         if (e.getSource() == this.backButton) {
             this.backButton.swapCard("1");
         }
    }
}
