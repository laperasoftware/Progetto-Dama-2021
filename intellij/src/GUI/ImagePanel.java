package GUI;
import java.awt.*;
import javax.swing.*;


    class ImagePanel extends JPanel {
        private Image img;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {

            this.img = img;


            Dimension size = new Dimension(1650,1080);
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);


        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }


    }

