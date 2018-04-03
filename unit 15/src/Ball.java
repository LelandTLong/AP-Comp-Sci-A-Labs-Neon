//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 2;
		ySpeed = 1;
	}

	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 2;
		ySpeed = 1;
	}
	//add the other Ball constructors
	
	
	public Ball(int x, int y, int w, int h){
		super (x,y,w,h);
		xSpeed = 2;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h, Color c){
		super (x,y,w,h,c);
		xSpeed = 2;
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

      setX(getX()+ getXSpeed());
		//setY
      setY(getY()+ getYSpeed());
		//draw the ball at its new location
      draw(window);
   }
   
   @Override
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
	
	
	 public boolean didCollideLeft(Object obj){
		 Paddle compare = (Paddle)obj;
		 if((this.getX() <= compare.getX() + compare.getWidth()) && (this.getX()>=compare.getX()) &&//check if paddle is within bounds of x
					((compare.getY() <= this.getY()) && (this.getY() <= compare.getY() + compare.getHeight()) 
							)){
			return true;
			}
		 
		 return false;
	 }

	 
	 public boolean didCollideRight(Object obj){
		 Paddle compare = (Paddle)obj;
		 if((this.getX() <= compare.getX() + compare.getWidth()) && (this.getX() >= compare.getX()) &&//check if paddle is within bounds of x
					((compare.getY() <= this.getY()) && (this.getY() <= compare.getY() + compare.getHeight()) 
							)){
			return true;
			}
		 
		 return false;
	 }
	 
	 
	 
	 public boolean didCollideTop(Object obj){
		return getY() <= 10;
	 }
	 
	 
	 public boolean didCollideBottom(Object obj){
		return getY() >= 550;
	 }
	
	 
	@Override
   //add a toString() method
	public String toString(){
		String output = "";
		output = "" + getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed() + " " + getYSpeed();
		return output; 
	}
	
}