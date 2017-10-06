package pdf2image;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class DrawImage extends Canvas{  
	  
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("ImageSample.jpg");  
        g.drawImage(i, 120,100,this);  
          
    }  
        public void main(String[] args) {  
        DrawImage m=new DrawImage();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(900,900);  
        f.setVisible(true);  
    }  
  
}
