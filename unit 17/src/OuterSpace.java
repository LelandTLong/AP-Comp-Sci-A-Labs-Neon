//� A+ Computer Science  -  www.apluscompsci.com
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

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Ammo ammo;
	
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	
	//my variables
	//private AlienHorde swarm;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(400,450,2);
		
		alienOne = (new Alien(250,50,2));
        alienTwo = (new Alien(450,50,2));
		ammo = new Ammo();
        ammo.setPos(900, 600);
        
        AlienHorde swarm = new AlienHorde(18);
        aliens = swarm.getSwarm();
        
        //swarm = new AlienHorde(5);
        //System.out.println(swarm.size());
        
        
        
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
		
		
		
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		
		
		

		if(ship.getX() >= 0 && keys[0] == true)
		{
			ship.move("LEFT");
		}

		//add code to move stuff
		if(ship.getX() <= 710 && keys[1] == true)
		{
			ship.move("RIGHT");
		}
		
		if(ship.getY() >= 0 && keys[2] == true)
		{
			ship.move("UP");
		}
		
		if(ship.getY() <= 480 && keys[3] == true)
		{
			ship.move("DOWN");
		}
		
		if(keys[4] == true)
		{
			
			 ammo = new Ammo(ship.getX() + 35, ship.getY()-20, 3);
	
			 keys[4]=false;
			 
		}
		
		
		//add in collision detection
		
		//use two forloops later
		/*if (!(ammo.getY() <= alienOne.getY() + 10 && ammo.getY() >= alienOne.getY() - 20 && ammo.getX() >= alienOne.getX() && ammo.getX() <= alienOne.getX() + 60) ){
			//remove from matrix after getting hit to disappear permanently
			alienOne.draw(graphToBack);
			
		}*/
		
		ammo.move("UP");
		ammo.draw(graphToBack);
		ship.draw(graphToBack);
		//alienTwo.draw(graphToBack);
		
		for (int i = 0 ; i < aliens.size(); i++){
			aliens.get(i).draw(graphToBack);
		}
		
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
		/*if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}*/
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

