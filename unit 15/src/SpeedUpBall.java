//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables
	private int xSpeed;
	private int ySpeed;
	
   public SpeedUpBall()
   {
	   super(200,200);

   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super (x,y,xSpd,ySpd);

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super (x,y,wid,ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);

   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super (x,y,wid,ht,col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);



   }

   public void setXSpeed( int xSpd )
   {
	   xSpeed = xSpd + 1;



   }

   public void setYSpeed( int ySpd )
   {
	   ySpeed = ySpd + 1;



   }
}

