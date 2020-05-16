# Music Visualiser Project

Name: Heejin Yoon

Student Number: D18123905

# Description of the assignment
Making music visualiser using processing3 in java. This program takes a audiofile as input and reads the audio's properties in order to create a sound reactive animation. Made 4 types of animation screen each have different design animation. 
# Instructions
This program takes multiple inputs that helps to control program. To start program and pause / replaying the music, 
just need to type number or character on the screen. 
- By pressing right, left key on the keyboard will reset the music. right key playing front music, left key playing back music 
- By pressing up, down key makes some special effect to control first music visualizer box size. 
- By pressing 1,2,3 or 4 on the keyboard the corresponding music visualizer will appear on the screen
- Pressing 0 will put you into auto mode that showing combination of 4 music visualizers

# How it works
This program begins operate things from the MyVisual file. Inside this file there are setup, draw function, which initialise all the separate randerer functions and make some menu methods to control animations. Program have 4 different animations which are inside sperate class files. 
first animation have circle shape drawing by several boxes like architecture. 
Second animation is showing wave signals.
Third animation is showing another circle shape but drawing by wave signals. 
Fourth animation is showing oscillators that have 10 edges. 
All animation size will change depends on the music amplitude. 
# What I am most proud of in the assignment
I made some functions inside WaveLine and WaveCircle class. which is showing the user that current playing status and the total length of music using circle design. I made it using lower opacity that makes don't interrupt to watch the main animation. 
```Java
public void draw_line() 
{
    mv.noStroke();
    mv.fill(mv.getCurrentColour(), 255, 255, 7);
    posX = PApplet.map(mv.getAudioPlayer().position(), 0, mv.getAudioPlayer().length(), 0, cx);
    mv.rect(0, cy/2 - 190, posX, cy/1.5f);
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
```

# Youtube video of my visualisation 
[![YouTube](http://img.youtube.com/vi/RqMRlnR7KJQ/0.jpg)](https://youtu.be/RqMRlnR7KJQ)


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

