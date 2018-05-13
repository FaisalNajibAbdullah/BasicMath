import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rank extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix = "Rank";
    
    public Rank(){
        setImage("Mlain.png");
        background = getImage();
        updateImage();
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            DuniaRank dnyrk = new DuniaRank();            
            Greenfoot.setWorld(dnyrk);            
        }
    }
    
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
