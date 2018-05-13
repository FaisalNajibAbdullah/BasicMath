import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soal extends Actor
{
    private int pg_a = 0;
    private int pg_b = 0;
    private int pg_c = 0;
    
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;    
    private String prefix;
    
    public int value =0;
    private int levelSoal = 0;
    
    //0 Penjumlahan
    //1 Pengurangan
    //2 Perkalian
    //3 Pembagian
    //4 kompleks?
    
    
    public Soal(){
        setImage("soal.png");
        background = getImage();  // get image from class     
        doSoalBaru();
    }
    
    /**
     * Act - do whatever the Soal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //updateImage();
        //updateMusuhImg();        
    } 
    
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        //GreenfootImage text = new GreenfootImage(prefix + value, 22, Color.BLACK, transparent);
        GreenfootImage text = new GreenfootImage(prefix , 22, Color.YELLOW, transparent);
        
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    public void setLevel(int level){
        levelSoal = level;
    }
    
    public void doSoalBaru(){
        //0 penjumlahan
        if(levelSoal == 0){
            pg_a = Greenfoot.getRandomNumber(20);
            pg_b = Greenfoot.getRandomNumber(20);
            //pg_c = Greenfoot.getRandomNumber(10);
            
            value = pg_a + pg_b;
            prefix = ""+ pg_a + " + " + pg_b + " = ";
        }
        
        //1 pengurangan
        if(levelSoal == 1){
            int temp1 = Greenfoot.getRandomNumber(20);
            int temp2 = Greenfoot.getRandomNumber(20);
            //pg_c = Greenfoot.getRandomNumber(10);
            if(temp1<temp2){
                pg_a = temp2;
                pg_b = temp1;
            } else{
                pg_a = temp1;
                pg_b = temp2;
            }
            
            value = pg_a - pg_b;
            prefix = ""+ pg_a + " - " + pg_b + " = ";
        }
        
        //2 perkalian
        if(levelSoal == 2){
            pg_a = Greenfoot.getRandomNumber(20);
            pg_b = Greenfoot.getRandomNumber(20);
            //pg_c = Greenfoot.getRandomNumber(10);
            
            value = pg_a * pg_b;
            prefix = ""+ pg_a + " x " + pg_b + " = ";
        }
        
        //3 pembagian
        if(levelSoal == 3){
            int temp1 = Greenfoot.getRandomNumber(19) +1;
            int temp2 = Greenfoot.getRandomNumber(19) +1;
            //pg_c = Greenfoot.getRandomNumber(10);
            
            int temp3 = temp1 * temp2;
            // 42 = 6 * 7
            value = temp1;
            pg_a = temp3;
            pg_b = temp2;
            
            prefix = ""+ pg_a + " : " + pg_b + "= ";
        }
        
        this.prefix = prefix;
        updateImage();
        updateMusuhImg();
    }
    
    private void updateMusuhImg(){
        try{
            for(int i=0;i<5;i++){
                this.getWorld().getObjects(Musuh.class).get(i).value = this.value + i;
                this.getWorld().getObjects(Musuh.class).get(i).updateImage();
            }
        } catch(Exception e){
        }
    }
}
