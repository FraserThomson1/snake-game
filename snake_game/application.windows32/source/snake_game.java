import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class snake_game extends PApplet {

float scale = 10;
ArrayList<snake> co = new ArrayList<snake>();
float ranX = PApplet.parseInt(random(0,width/scale))*scale;
float ranY = PApplet.parseInt(random(0,height/scale))*scale;
float x = 0;
float y = 0;
float xSpeed = 0;
float ySpeed = 0;
boolean remove = true;

public void setup(){
  
  background(225);
  frameRate(20);
}



public void draw(){   
  background(225);
  grid g = new grid();                                                         //display grid
  fruit f = new fruit();                                                       //display fruit
  snake s = new snake(x,y);                                                    //current head of snake
  
  co.add(s);
  co.get(co.size()-1).direction();
  co.get(co.size()-1).gameover();                                              //gameover?
  co.get(co.size()-1).eat();                                                   //eat? 
  s.display();                                                                 //display snake
                                                                                               
  
}
class fruit{
  public fruit(){
    stroke(0);
    fill(255,153,153);
    rect(ranX,ranY,scale,scale);
  }
}
class grid{
  public grid(){
    for(float x = 0;x < width;x += scale){
      stroke(0);
      line(x,0,x,height);
    }
    for(float y = 0;y < height;y += scale){                                        //grid,background
    stroke(0);
     line(0,y,width,y);
    }
  }
}
public class snake{
  float xl = 0;
  float yl = 0;
  public snake(float x,float y){
      this.xl = x;
      this.yl = y;
  }
  
  
  
  public void display(){
    fill(0,204,204);
    stroke(0);
    for(int i = co.size()-1;i >= 0;i --){
      snake s = co.get(i);
      rect(s.xl,s.yl,scale,scale);
    }
    if(remove == true){
      co.remove(0);                                                                
    }
    else{
      remove = true;
    }                      
  }
  
  
  
  
  public void direction(){
    if(keyPressed){
      if(key == 'd' && xSpeed != -1){
        xSpeed = 1;
        ySpeed = 0;
      }
      if(key == 'a' && xSpeed != 1){
        xSpeed = -1;
        ySpeed = 0;
      }
      if(key == 'w' && ySpeed != 1){          
        xSpeed = 0;
        ySpeed = -1;
      }
      if(key == 's' && ySpeed != -1){
        xSpeed = 0;
        ySpeed = 1;
      }
      }
      x += xSpeed*scale;
      y += ySpeed*scale;
  }
  
  
  
  
  public void gameover(){
      if(x > width || y > height || x < 0 || y < 0){
        stop();
      }
      for(int i = 0;i < co.size()-1;i ++){
        if(co.get(i).xl == x && co.get(i).yl == y){
          stop();
        }
      }
  }
  
  
  public void eat(){
    if(x == ranX && y == ranY){
        ranX = PApplet.parseInt(random(0,width/scale))*scale;
        ranY = PApplet.parseInt(random(0,height/scale))*scale;                                    //when snake eats fruit
        remove = false;
    }
  }
}
  public void settings() {  size(980,980); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "snake_game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
