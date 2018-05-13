import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ledak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ledak extends Actor
{
    private SimpleTimer st = new SimpleTimer();
    
    public Ledak(){
        setImage("ledak.png");
        st.mark();
        Greenfoot.playSound("blast.wav");
        
    }
    
    /**
     * Act - do whatever the Ledak wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(st.millisElapsed()>100){
            getWorld().removeObject(this);
        }
    }    
}
