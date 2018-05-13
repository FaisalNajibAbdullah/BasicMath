import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musuh extends Actor
{   
    private static final Color transparent = new Color(0,0,0,0);
    
    private GreenfootImage background;
    public int value;
    private int target;
    private String prefix;
    
    public Musuh()
    {
        setImage("musuh.png");        
        background = getImage();  // get image from class        
        value = 0;
        target = 0;
        //this.prefix = prefix;     
        
        value=Greenfoot.getRandomNumber(10);
        prefix ="";
        this.prefix = prefix;
        updateImage();
       
    }
    /**
     * Act - do whatever the Musuh wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if(isAtEdge()){
            setLocation(Greenfoot.getRandomNumber(300), 0);
        
        }
        
        setLocation(getX(), getY()+1);
        
        int val1 = this.getWorld().getObjects(Soal.class).get(0).value;
        if(isTouching(Peluru.class)){
              DuniaSaya dunya = (DuniaSaya)getWorld();
              
              if(this.value==val1){
                  Roket rkt = dunya.getRoket();
                  rkt.tambahNilai();
              
                  Counter nilaiD = dunya.getNilaiD();
                  nilaiD.setValue(rkt.getNilai());
              } else 
              {
                  Roket rkt = dunya.getRoket();
                  rkt.kurangNyawa();
                  
                  Counter dnyNyawa = dunya.getNyawaD();
                  dnyNyawa.setValue(rkt.getNyawa());
              }
              
              getWorld().addObject(new Ledak(), getX(), getY());
              
              removeTouching(Peluru.class);
              
              dunya.getSoal().doSoalBaru();
              dunya.resetPosMusuh();
              //getWorld().removeObject(this);
              
        }
    }
    
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()+25-text.getHeight())/2);
        setImage(image);
    }
}
