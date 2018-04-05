float scale = 10;
ArrayList<snake> co = new ArrayList<snake>();
float ranX = int(random(0,width/scale))*scale;
float ranY = int(random(0,height/scale))*scale;
float x = 0;
float y = 0;
float xSpeed = 0;
float ySpeed = 0;
boolean remove = true;

void setup(){
  size(980,980);
  background(225);
  frameRate(20);
}



void draw(){   
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