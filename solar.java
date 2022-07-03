import java.awt.*;
import java.applet.*;
import java.util.Random;
/*
    <applet code="appletprogram" height="720" width="1080" background="#000">
    </applet>
 */
public class appletprogram extends Applet {
    Dimension screen;
    Random random;
            
    public void init(){
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screen.width, screen.height);
        setBackground(Color.decode("#000"));
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.decode("#FFEB3B"));      
        g.fillOval(-400, 200,600,600);  
        g.setColor(Color.decode("#FFF9C4"));
        g.drawOval(-400, 200, 603, 603);
        
        String[][] planet = {
            {"#B0BEC5", "#F57F17", "#0D47A1", "#5D4037", "#FF5722", "#FFD700", "#4FC3F7", "#80DEEA", "#BCAAA4"}, //[0] fillColor Array
            {"#ECEFF1", "#FBC02D", "#BBDEFB", "#BBDEFB", "#BBDEFB", "#FFF9C4", "#E1F5FE", "#E0F7FA", "#EFEBE9"}, //[1] drawColor Array
            {"30", "40", "35", "45", "160", "130", "110", "100", "15"}, //[2] size Array
            {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"}, //[3] planetName Array 
            {"250", "325", "400", "475", "550", "800", "1000", "1300", "1600"}, //[4] x array
            {"600", "550", "500", "600", "350", "600", "450", "350", "250"} //[4] y array
        };
        
        for(int p=0; p<planet[0].length; p++){
            String fillC = planet[0][p];
            String drawC = planet[1][p];
            int size = Integer.parseInt(planet[2][p]);
            int sizeOut = Integer.parseInt(planet[2][p])+1;
            String pName = planet[3][p];
            int x = Integer.parseInt(planet[4][p]);  
            int y = Integer.parseInt(planet[5][p]);  
            int yText = y+sizeOut+15;
            
            g.setColor(Color.decode(fillC));
            g.fillOval(x, y, size, size);
            g.setColor(Color.decode(drawC));
            g.drawOval(x, y, sizeOut, sizeOut);
            g.drawString(pName, x, yText);
            if(p == 5){
                g.setColor(Color.white);
                g.drawArc((x-5), (y+35),170,50,170,170);
                g.setColor(Color.white);
                g.drawArc((x-10), (y+40),170,50,170,170);
                g.setColor(Color.white);
                g.drawArc((x-15), (y+45),170,50,170,170);
            }
        }

        for(int oval=0; oval<=5000;oval++){
            random = new Random();
            int y = random.nextInt((screen.height+1000));
            int x = random.nextInt((screen.width+1000));
            float xr = random.nextFloat();
            float xg = random.nextFloat();
            float xb = random.nextFloat();
            if(oval%2 == 1){
                int w = random.nextInt(7);
                int h = random.nextInt(7);
                g.setColor(new Color(xr, xg, xb));
                g.drawOval(y, x, h, h); //ganjil is draw
            } else {
                random = new Random();
                int w = random.nextInt(5);
                int h = random.nextInt(5);
                g.setColor(new Color(xr, xg, xb));
                g.fillOval(y, x, h, h); //ganjil is draw
            }
        }
    }
}
