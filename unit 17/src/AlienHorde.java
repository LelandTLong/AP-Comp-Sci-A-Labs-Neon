import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class AlienHorde {
	ArrayList <Alien> swarm = new ArrayList<Alien>();
	private Image image;
	
	public AlienHorde(){
		
	}
	
	public AlienHorde(int count){
		for (int i = 0; i< count; i++){
			
		}
	
		
		
		try
		{
			image = ImageIO.read(new File("C:\\Users\\longl5895\\Desktop\\AP-Comp-Sci-A-Labs-Neon\\unit 17\\src\\alien.JPG"));
		}
		catch(Exception e)
		{
			
		}
		
		
		
	}
	
	public ArrayList<Alien> getSwarm(){
		return swarm;
   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end class
