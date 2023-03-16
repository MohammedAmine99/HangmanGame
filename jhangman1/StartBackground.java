/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jhangman1;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;


 
public class StartBackground extends JPanel{
     final ImageIcon start = new ImageIcon("C:/Users/PC/Documents/NetBeansProjects/JHangman1/src/img/HANGMAN.gif");
    
      public StartBackground () {
           JLabel Bg = new JLabel(start);
            Bg.setIcon(new ImageIcon(resizeImage(start.getImage(), 800, 600)));
       Bg.setBounds(0, 0, 500, 500);
            this.add(Bg);

        Bg.setLayout(null);
      }
      private Image resizeImage(Image img, int width, int height) {
        return img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}

