package d18123905;

import processing.core.*;

public class WaveCircle {
    
    MyVisual mv;
    float cx, cy= 0;
    float posX = 0;

    public WaveCircle(MyVisual mv)
    {
        this.mv = mv;
        cx = this.mv.width/2;
        cy = this.mv.height/2;
    }

    public void draw_cirwav()
    {
        mv.strokeWeight(1);
        mv.stroke(mv.getCurrentColour(), 255, 255, 170);
        for(int i = 0 ; i < mv.getAudioBuffer().size() - 1; i ++)
        {   
            float a1 = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, PApplet.TWO_PI);
            float a2 = PApplet.map(i+1, 0, mv.getAudioBuffer().size(), 0, PApplet.TWO_PI);
            mv.line(cx + (float)Math.cos(a1) * (-300 + mv.getAudioPlayer().left.get(i) * 50), cy + (float)Math.sin(a1) * (-300 + mv.getAudioPlayer().left.get(i) * 50),
                    cx + (float)Math.cos(a2) * (-300 + mv.getAudioPlayer().left.get(i+1) * 50), cy + (float)Math.sin(a2) * (-300 + mv.getAudioPlayer().left.get(i+1) * 50));
            mv.line(cx + (float)Math.cos(a1) * (-200 + mv.getAudioPlayer().left.get(i) * 50), cy + (float)Math.sin(a1) * (-200 + mv.getAudioPlayer().left.get(i) * 50),
                    cx + (float)Math.cos(a2) * (-200 + mv.getAudioPlayer().left.get(i+1) * 50), cy + (float)Math.sin(a2) * (-200 + mv.getAudioPlayer().left.get(i+1) * 50));
        }
    }

    public void draw_cir(int s) 
    {
        mv.noStroke();
        mv.fill(mv.getCurrentColour(), 255, 255, 15);
        posX = PApplet.map(mv.getAudioPlayer().position(), 0, mv.getAudioPlayer().length(), 0, PApplet.TWO_PI);
        mv.arc(cx, cy, s * 3.5f, s * 3.5f, 0, posX);
        mv.fill(0);
        mv.ellipse(cx, cy, s * 3.0f, s * 3.0f);
    }
}