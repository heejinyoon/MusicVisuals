package d18123905;

import processing.core.*;

public class WaveLine {

    MyVisual mv;
    float cx, cy= 0;
    float posX = 0;

    public WaveLine(MyVisual mv)
    {
        this.mv = mv;
        cx = this.mv.width;
        cy = this.mv.height;
    }

    public void draw_wave()
    {
        mv.strokeWeight(1);
        mv.stroke(mv.getCurrentColour(), 255, 255, 170);
        for(int i = 0 ; i < mv.getAudioBuffer().size() -1 ; i ++)
        {   
            float x1 = PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, cx);
            float x2 = PApplet.map(i+1, 0, mv.getAudioBuffer().size(), 0, cx);
            mv.line(x1, cy/2 - 90 + mv.getAudioPlayer().left.get(i) * 70, x2, cy/2 - 90 + mv.getAudioPlayer().left.get(i+1) * 70);
            mv.line(x1, cy/2 + 130 + mv.getAudioPlayer().right.get(i) * 70, x2, cy/2 + 130 + mv.getAudioPlayer().right.get(i+1) * 70);
        }
    }

    public void draw_line() 
    {
        mv.noStroke();
        mv.fill(mv.getCurrentColour(), 255, 255, 7);
        posX = PApplet.map(mv.getAudioPlayer().position(), 0, mv.getAudioPlayer().length(), 0, cx);
        mv.rect(0, cy/2 - 190, posX, cy/1.5f);
    }
}