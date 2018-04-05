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