package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.CubeVisual1;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
	}

	public void startUS()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new MyVisual());
	}
	
	public void startCube() 
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new CubeVisual1());
	}
	
	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUS();			
	}
}