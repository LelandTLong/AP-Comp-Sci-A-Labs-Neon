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
import java.util.Timer;
import java.util.TimerTask;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	//private Alien alienOne;
	//private Alien alienTwo;
	private Ammo ammo;
	private boolean gameOver = false;
	private int lives = 5;
	private Ammo enemyBullet = new Ammo(1000,1000,1);
	//private boolean timerOn = true;
	
	
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
		
		//alienOne = (new Alien(250,50,2));
        //alienTwo = (new Alien(450,50,2));
		//ammo = new Ammo();
        //ammo.setPos(900, 600);
        
        AlienHorde swarm = new AlienHorde(8);
        aliens = swarm.getSwarm();
        
        shots = new ArrayList<Ammo>();
        
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
		if(ship.getX() <= 720 && keys[1] == true)
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
			
			 shots.add(new Ammo(ship.getX() + 35, ship.getY()-20, 3));
			 int random = (int) (Math.random() * aliens.size());
			 enemyBullet = new Ammo(aliens.get(random).getX(),aliens.get(random).getY(),1);
			 
			 keys[4]=false;
			 
		}
		
		
		//add in collision detection
		
		//use two forloops later
		for (Alien enemies: aliens){
			enemies.draw(graphToBack);
			int temp = enemies.getY();
			enemies.move("RIGHT");
			
			
			
			
			
			 if(enemies.getX() <= 1000)
             {
                 if(enemies.getX() > 900)
                     enemies.setX(-20);
                 	 
             }
			for (Ammo bullets: shots){
				if (!(bullets.getY() <= enemies.getY() + 10 && bullets.getY() >= enemies.getY() - 20 && bullets.getX() >= enemies.getX() && bullets.getX() <= enemies.getX() + 60) ){
					//remove from matrix after getting hit to disappear permanently
					enemies.draw(graphToBack);
					
				}
				else {
					aliens.remove(enemies);
					shots.remove(bullets);
				}
			}
		}	
			
		
		
		
		
		
		
		for (Ammo bullets: shots){
			bullets.move("UP");
			bullets.draw(graphToBack); 
			if(bullets.getY()<=0)
             {
                 shots.remove(bullets);
             }
		}
		
		
            
         
		if (lives > 0){
			ship.draw(graphToBack);
		}
	
		
		
		
		
		
			
		//Timer timer = new Timer ();
		
		//TimerTask task = new TimerTask(){
			//public void run(){
				//int random = (int) (Math.random() * aliens.size());
				//Ammo enemyBullet = new Ammo(aliens.get(random).getX(),aliens.get(random).getY(),1);
				//if (enemyBullet.getY() < 550){
				
				enemyBullet.draw(graphToBack);
				enemyBullet.move("DOWN"); 
				
				//}
				if ((ship.getY() <= enemyBullet.getY() + 10 && ship.getY() >= enemyBullet.getY() - 20 && ship.getX() >= enemyBullet.getX() && ship.getX() <= enemyBullet.getX() + 60) ){
					//remove from matrix after getting hit to disappear permanently
					lives = lives - 1;
				}
				
			//}
		//};
		
		//if (timerOn == true){
			//timer.scheduleAtFixedRate(task,1000,1000);
			//timerOn = false;
		//}
			
		
		
		
		
		
		
		
		
		
		
		
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Lives: " + lives, 700, 550);
		//for (int i = 0 ; i < aliens.size(); i++){
			//aliens.get(i).draw(graphToBack);
		//}
		
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
