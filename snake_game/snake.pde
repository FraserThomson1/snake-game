public class snake{
  float xl = 0;
  float yl = 0;
  public snake(float x,float y){
      this.xl = x;
      this.yl = y;
  }
  
  
  
  void display(){
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
  
  
  
  
  void direction(){
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
  
  
  
  
  void gameover(){
      if(x > width || y > height || x < 0 || y < 0){
        stop();
      }
      for(int i = 0;i < co.size()-1;i ++){
        if(co.get(i).xl == x && co.get(i).yl == y){
          stop();
        }
      }
  }
  
  
  void eat(){
    if(x == ranX && y == ranY){
        ranX = int(random(0,width/scale))*scale;
        ranY = int(random(0,height/scale))*scale;                                    //when snake eats fruit
        remove = false;
    }
  }
}