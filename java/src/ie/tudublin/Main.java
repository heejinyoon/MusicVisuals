package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.Visual;

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
		processing.core.PApplet.runSketch( a, new CubeVisual());
	}

	public void StartCube() 
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new Visual());
	}
	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUS();			
	}
}