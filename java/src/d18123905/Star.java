package d18123905;

import ie.tudublin.Visual;

public class Star extends Visual
{   
    float cx, cy; //width and height 
    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }
    
    public void setup()
    {
        colorMode(HSB);
        noCursor();
            
        setFrameSize(256);
    
        startMinim();
        loadAudio("heroplanet.mp3");
        //getAp().play();
        //startListening(); 
        cx = width * 0.5f;
        cy = height * 0.5f;
    }
    
    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            //getAudioPlayer().mute();
        }  
    }
    
    float angle = 0;
    int edges = 5;
    float smoothedBoxSize = 0;

    void stars(int x, int y, float radius1, float radius2, int edges) {
        float angle = TWO_PI / edges;
        float halfAngle = angle / 2.0f;
        beginShape();
        for(float a = 0; a < TWO_PI; a+= angle) {
            float sx = x + cos(a) * radius2;
            float sy = y + sin(a) * radius2;
            vertex(sx, sy);
            sx = x + cos(a + halfAngle) * radius1;
            sy = y + sin(a + halfAngle) * radius1;
            vertex(sx, sy);
        }
        endShape(CLOSE);
    }
    
    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        //strokeWeight(5);
        //Cam(); 
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);

        float radius1Size = 30 + (getAmplitude() * 300);
        float radius2Size = 70 + (getAmplitude() * 300);

        pushMatrix();
        translate(cx, cy);
        rotate(angle);
        rotate(angle);
        stars(0, 0, radius1Size, radius2Size, edges);
        popMatrix();
            
        angle += 0.01f;

    }
}