import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Roket extends Actor
{
    private SimpleTimer waktos = new SimpleTimer();
    private int nilai = 0;
    private int nyawa = 5;
    
    //ini adalah konstruktor
    public Roket(){
        setImage("rocket.png");
        setRotation(270);
        
        waktos.mark();
    }
    
    /**
     * Act - do whatever the Roket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("up")){
            
           setLocation(getX(), getY()-3);
        }
        
        if(Greenfoot.isKeyDown("down")){
            
            setLocation(getX(), getY()+3);
        }
        
        if(Greenfoot.isKeyDown("left")){
            
            setLocation(getX()-3, getY());
        }
        
         if(Greenfoot.isKeyDown("right")){
            
            setLocation(getX()+3, getY());

        }
        
        if(Greenfoot.isKeyDown("space")){
            
            if(waktos.millisElapsed() > 300){
                getWorld().addObject(new Peluru(), getX(), getY()-45);
            
                waktos.mark();
            }
        }
        
        
        if(isTouching(Musuh.class)){
              kurangNyawa();
              //removeTouching(Musuh.class);
              
              //TODO nyawa
              DuniaSaya dny = (DuniaSaya)getWorld();
              Counter dnyNyawa = dny.getNyawaD();
              dnyNyawa.setValue(this.getNyawa());
              
              dny.getSoal().doSoalBaru();
              dny.resetPosMusuh();
              
              
              if(nyawa<=0){
                  saveScore();
                  //getWorld().showText("KALAH", 100, 100);
                  getWorld().removeObject(this);
                  Greenfoot.setWorld(new DuniaAkhir());
                  //Greenfoot.stop();
              }
        }
        
        try{
            if(nyawa<=0){
                  saveScore();
                  //getWorld().showText("KALAH", 100, 100);
                  getWorld().removeObject(this);
                  Greenfoot.setWorld(new DuniaAkhir());
                  //Greenfoot.stop();
            }
        } catch(Exception e){
        }
    }
    
    private void saveScore(){
        UserInfo myInfo = UserInfo.getMyInfo();
        if (this.nilai > myInfo.getScore()) {
            myInfo.setScore(this.nilai);
            myInfo.store();
        } 
    }
    
    public void tambahNilai(){
        this.nilai = this.nilai + 10;
    }
    
    public int getNilai(){
        return this.nilai;
    }
    
    public void kurangNyawa(){
        this.nyawa = this.nyawa-1;
    }
    
    public int getNyawa(){
        return this.nyawa;
    }
}
