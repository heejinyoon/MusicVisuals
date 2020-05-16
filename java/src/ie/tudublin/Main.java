package ie.tudublin;

import d18123905.MyVisual;
import d18123905.Cube;


public class Main
{	
	public void test()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new Cube());
	}
	public void Code()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new MyVisual());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.Code();			
	}
}