//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	//add the other Ball constructors
	
	
	public Ball(int x, int y, int w, int h){
		super (x,y,w,h);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color c){
		super (x,y,w,h,c);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color c, int xSpeed, int ySpeed){
		super (x,y,w,h,c);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}
	
	
	
	
	
   //add the set methods
   public void setXSpeed(int x){
		xSpeed = x;
	}
	
	public void setYSpeed(int y){
		ySpeed = y;
	}

	
	
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  draw(window,Color.WHITE);

      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      draw(window, Color.BLACK);
   }
   
   
	public boolean equals(Object obj)
	{
		Ball two = (Ball)obj;
		if (getX() == two.getX() && getY() == two.getY() && getWidth() == two.getWidth() && getHeight() == two.getHeight() && getXSpeed() == two.getXSpeed() && getYSpeed() == two.getYSpeed())
			return true;

		return false;
	}   

   //add the get methods
	
	
	public int getXSpeed(){
		return xSpeed;
	}
	
	public int getYSpeed(){
		return ySpeed;
	}
	
	
   //add a toString() method
	public String toString(){
		String output = "";
		output = "" + getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed() + " " + getYSpeed();
		return output; 
	}
	
}