package d18123905;

import processing.core.*;

public class Architecture {

    MyVisual mv;
    float h;
    float cx, cy= 0;
    float rotate = 60;
    float posX = 0;

    public Architecture(MyVisual mv)
    {
        this.mv = mv;
        h = this.mv.h; // pass the special effect variable
        cx = this.mv.width/2;
        cy = this.mv.height/3;
    }

    public void draw_visualiser(int s)
    {
        mv.colorMode(PApplet.HSB);
        mv.noStroke();
        mv.fill(mv.getCurrentColour(), 255, 255);
        for(int i = 0 ; i < mv.getFFT().specSize() ; i +=10)
        {   
            float m = PApplet.radians(PApplet.map(i, 0, mv.getFFT().specSize(), 0, 360));
            mv.pushMatrix();
            mv.translate(cx + (float)Math.cos(m) * s * 1.2f * (float)Math.tan(PApplet.radians(rotate)), cy * 2.0f + (float)Math.sin(m) * s * 1.2f);
            mv.rotateX(PApplet.radians(rotate));
            mv.box(s/6, s/6, mv.getFFT().getFreq(i/2) * h);
            mv.popMatrix();
        }
    }

    public void draw_arc(int s) 
    {
        mv.fill(mv.getCurrentColour(), 255, 255);
        mv.noStroke();
        posX = PApplet.map(mv.getAudioPlayer().position(), 0, mv.getAudioPlayer().length(), 0, PApplet.TWO_PI);
        mv.fill(mv.getCurrentColour(), 255, 255, 10);
        mv.arc(cx, cy * 2, s * 3.7f * (float)Math.tan(PApplet.radians(rotate))/2, s * (3.7f/2.0f), 0, posX);
        mv.fill(0);
        mv.ellipse(cx, cy * 2, s * 3.2f * (float)Math.tan(PApplet.radians(rotate))/2 , s * (3.2f/2.0f));
    }
}