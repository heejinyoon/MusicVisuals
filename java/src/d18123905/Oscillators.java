package d18123905;

import processing.core.*;

public class Oscillators {

    MyVisual mv;
    float cx, cy= 0;

    Oscil[] oscil = new Oscil[10]; //10 objects for oscil

    /*
    public void settings()
    {
        size(900, 650, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }*/
    public Oscillators (MyVisual mv)
    {
        this.mv = mv;
        cx = this.mv.width;
        cy = this.mv.height;

        for(int i=0; i < oscil.length; i++) {
            oscil[i] = new Oscil();
        }
    }

    public void draw_oscil() {
        mv.background(0);
        mv.smooth();
  
        for (int i = 0; i < oscil.length; i++){
            oscil[i].move();
            oscil[i].display();
        }
    }

    class Oscil{
  
        PVector pos= new PVector(mv.random(50, cx-50), mv.random(50, cy-50));
        PVector velocity = new PVector(mv.random(-0.05f, 0.05f), mv.random(-0.01f, 0.01f));
        PVector amplitude = new PVector(130, 130);
       
        void move() {
            pos.add(velocity);
        }
       
        void display() {
         
            float x = (float)Math.sin(pos.x) * amplitude.x;
            float y = (float)Math.sin(pos.y) * amplitude.y;
    
            mv.pushMatrix();
            mv.translate(cx/2, cy/2);
            //mv.fill(219, 163, 80);
            mv.fill(mv.getCurrentColour());
            //draw middle point line to connect with circle 
            mv.line(0, 0, x, y);
            //진동하는 서클그리기
            for(int i =0; i < mv.getAudioBuffer().size()-1; i++){
                mv.stroke(mv.getCurrentColour(), 255-(mv.getAudioPlayer().right.get(i)*200), 255 - (mv.getAudioPlayer().left.get(i)*200));
                mv.ellipse(x, y, 15+(mv.getAudioPlayer().right.get(i)*50), 15+(mv.getAudioPlayer().left.get(i)*50));
            }
            mv.popMatrix();
        }
    }
}





