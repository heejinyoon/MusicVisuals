package d18123905;

import ie.tudublin.Visual;

public class Cube extends Visual
{   
    //private float cx;
    //private float cy;
    //private float cz;
    //private int cond;

    boolean twoCubes = false;
    boolean threeCubes = false;

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
        
        //cond = 0;
        //cx = width/2;
        //cy = height/2;
        //cz = -1000;
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        if (key == '1') {
            twoCubes = ! twoCubes;
        }
        if (key == '2') {
            threeCubes = ! threeCubes;
        }
    }

    /*
    public void Cam() {
        if(cz < 0 && cz >= -1000 && cond == 0) {
            camera(cx,cy,cz,width/2,height/2,0,0,1,0);
            cx += 2;
            cx = cx + width/2/500;
            cy = cy + height/2/500;
        }

        if(cz >= 0 && cz < 1000 && cond == 0) {
            camera(cx,cy,cz,width/2,height/2,0,0,1,0);
            cx += 2;
            cx = cx - width/2/500;
            cy = cy - height/2/500;
        } else if(cz == 1000) {
            cond = 1;
        }

        if(cz <= 1000 && cz > 0 && cond == 1) {
            camera(cx,cy,cz,width/2,height/2,0,0,1,0);
            cx -= 2;
            cx = cx - width/2/500;
            cy = cy - height/2/500;
        }

        if(cz <= 0 && cz > -1000 && cond == 1) {
            camera(cx,cy,cz,width/2,height/2,0,0,1,0);
            cx -= 2;
            cx = cx + width/2/500;
            cy = cy + height/2/500;
        } else if(cz == -1000) {
            cond = 0;
        }
    } 
    */

    float angle = 0;
    float smoothedBoxSize = 0;

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
        
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        

        if(twoCubes)
        {
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            box(smoothedBoxSize);
            //strokeWeight(1);
            //sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            box(smoothedBoxSize);
            popMatrix();

        } else if(threeCubes) {
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            box(smoothedBoxSize);
            //strokeWeight(1);
            //sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(0, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            box(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            box(smoothedBoxSize);
            popMatrix();
        }
        else
        {
            rotateY(angle);
            rotateX(angle);
            //strokeWeight(1);
            //sphere(smoothedBoxSize/ 2);            
            strokeWeight(5);
            
            box(smoothedBoxSize);
        }

        angle += 0.01f;
    }
}