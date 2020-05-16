package d18123905;

import ie.tudublin.*;
import java.util.List;
import java.io.*;

public class MyVisual extends Visual
{    
    WaveLine wl;
    WaveCircle wc;
    Architecture arc;
    Oscillators oscil;

    boolean p = false;
    float h = 0.8f;

    public void settings()
    {
        size(900, 650, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("thoughts.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wl = new WaveLine(this);
        wc = new WaveCircle(this);
        arc = new Architecture(this); 
        oscil = new Oscillators(this);

        colorMode(HSB);
    }

    public void mouseClicked() {
        //mouseX
        float s = map(mouseY, height, 0, 0, getAudioPlayer().length());

        if (mouseX >= width - 10) {
            getAudioPlayer().cue((int)s);
        }
    }

    public void keyPressed()
    {   
        switch(keyCode) {
            case RIGHT:
                getAudioPlayer().skip(1000);   //play music front 
                break;
            case LEFT:
                getAudioPlayer().skip(-1000);  //play music back 
                break;
            case UP:
                h += 0.1f;    //increase special effect
                break;
            case DOWN:
                h -= 0.1f;   //decrease special effect 
                break;
        }
        h = constrain(h, 0.8f, 5);
        println(getAudioPlayer().getVolume());

        switch(key) {
            case '1': 
                visual = 1;
                break;
            case '2':
                visual = 2;
                break;
            case '3':
                visual = 3;
                break;
            case '4':
                visual = 4;
                break;
            case '0':
                visual = 0;
                break;
            case 'q':
                if(getAudioPlayer().isPlaying()) {
                    getAudioPlayer().pause();
                }
                break;
            case 's':
                if(getAudioPlayer().isPlaying()) {
                    getAudioPlayer().pause();
                } else {
                    getAudioPlayer().play();
                }
                break;
            case 'm':
                if(getAudioPlayer().isMuted()) {
                    getAudioPlayer().unmute();
                } else {
                    getAudioPlayer().mute();
                }
                break;
        }
    }

    char visual = 0;

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude(); 
        
        // call this to change color based on the values 
        calculateCurrentColor();
        
        int s = width / 7;
        colorMode(HSB);
        //drawing after image 
        noStroke();
        fill(0, 80);
        rectMode(CORNER);
        rect(0, 0, width + 1, height + 1);

        //position is true 
        p = true;
        colorMode(HSB);
        if (visual == 0) {
            int n = 9;
            for (int i = 1; i <= n; i++) {
                colorMode(HSB);
                if(getAudioPlayer().position() < getAudioPlayer().length() * (1.0f / (float)n)) {
                    arc.draw_visualiser(s);
                    arc.draw_arc(s);
                } else if (getAudioPlayer().length() * ((1.0f/(float)n) * (float)i)
                        <= getAudioPlayer().position() && getAudioPlayer().position() 
                        < getAudioPlayer().length() * ((1.0f / (float)n) * (float)i+1.0f)) {
                    if(i % 3 == 0) {
                    arc.draw_visualiser(s);
                    arc.draw_arc(s);
                    } else if ( i % 3 == 1) {
                    wl.draw_line();
                    wl.draw_wave();
                    } else if ( i % 3 == 2) {
                    wc.draw_cirwav();
                    wc.draw_cir(s);
                    } else {
                    oscil.draw_oscil();
                    }
                }
            }
        } else if (visual == 1) {
            arc.draw_visualiser(s);
            arc.draw_arc(s);
        } else if (visual == 2) {
            wl.draw_line();
            wl.draw_wave();
        } else if (visual == 3){
            wc.draw_cirwav();
            wc.draw_cir(s);
        } else {
            oscil.draw_oscil();
        }

        fill(getCurrentColour(), 255, 255, 170);
    }
}
