import java.awt.Color;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] ball;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);

    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line
        ball = new BouncingBall[numBolas];
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate an number of balls determined with numBolas and show the balls
        for(int i= 0; i<numBolas;i++){
            Random aleat = new Random(); 
            int ejex = aleat.nextInt(276);
            int ejey = aleat.nextInt(ground);
            int diametro = aleat.nextInt(50);

            int red = aleat.nextInt(256);
            int green = aleat.nextInt(256);
            int blue = aleat.nextInt(256);
            Color color = new Color(red, green, blue);

            ball[i] = new BouncingBall(ejex, ejey, diametro, color, ground, myCanvas);
            ball[i].draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            for(int i=0;i<numBolas;i++){
                myCanvas.wait(10);           // small delay
                ball[i].move();
                // stop once ball has travelled a certain distance on x axis
                if(ball[i].getXPosition() >= 550)  {
                    finished = true;
                }
            }
        }
    }
}
