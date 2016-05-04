package maze;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class background extends Canvas implements KeyListener, Runnable
{
	private Person ship;
	private Alien alienOne, alienTwo,alien3,alien4,alien5,alien6;
	private boolean alive1, alive2, alive3,alive4,alive5,alive6;
	private boolean leftRight = true;
	private boolean fired = false;
	private int lr = 0;

	/* uncomment once you are ready for this part
	 *
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public background()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff

		ship = new Person(300,300,5);
		alienOne = new Alien(100,100,1);
		alienTwo = new Alien(100,20,1);
		alien3 = new Alien(200,100,1);
		alien4 = new Alien(200,20,1);
		alien5 = new Alien(300,100,1);
		alien6 = new Alien(300,20,1);
		//a = new Ammo(ship.getX()+20,ship.getY(),1);
	
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.GREEN);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

	
	if (ship.getX() > -20)
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
	if (ship.getX() < 721)
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
	if (ship.getY() > -15)
		if(keys[2] == true)
		{
			ship.move("UP");
		}
	if (ship.getY() < 490)
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}


		
		//add code to move stuff
	if (leftRight == true) {
	alienOne.move("LEFT");
	alienTwo.move("LEFT");
	alien3.move("LEFT");
	alien4.move("LEFT");
	alien5.move("LEFT");
	alien6.move("LEFT");
	lr++;
}
if (lr == 60 && leftRight == true) {
	leftRight = false;
	lr = 0;
}
if (leftRight == false) {
	alienOne.move("RIGHT");
	alienTwo.move("RIGHT");
	alien3.move("RIGHT");
	alien4.move("RIGHT");
	alien5.move("RIGHT");
	alien6.move("RIGHT");
	lr++;
}
if (lr == 60 && leftRight == false) {
	leftRight = true;
	lr = 0;
}

		//add in collision detection
		
		//a.draw(graphToBack);

		
		alienTwo.draw(graphToBack);
		alienOne.draw(graphToBack);
		alien3.draw(graphToBack);
		alien4.draw(graphToBack);
		alien5.draw(graphToBack);
		alien6.draw(graphToBack);
		
		ship.draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

