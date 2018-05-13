 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DuniaSaya here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DuniaSaya extends World
{
    private int lamaMain = 300; //300 detik

    private Roket roketBudi = new Roket();
    private Counter nilaiD = new Counter("","nilai.png");
    private Counter nyawaD = new Counter("","nyawa.png");
    private Counter waktuD = new Counter("","waktu.png");
    private Soal soal = new Soal();
    private GreenfootSound kkk = new GreenfootSound("bg2.wav");
    
    private SimpleTimer waktos = new SimpleTimer();
    
    /**
     * Constructor for objects of class DuniaSaya.
     * 
     */
    public DuniaSaya()
    {  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 600, 1); 
        prepare();
        waktos.mark();
        kkk.stop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Greenfoot.setWorld(new DuniaAwal());

        setBackground("math2.jpg");

        addObject(roketBudi, 300/2, 500);
        
        // fix 5 soal musuh, tidak ada remove object
        for(int i=0;i<5;i++){
            addObject(new Musuh(), Greenfoot.getRandomNumber(300),Greenfoot.getRandomNumber(200));
        }

        addObject(nilaiD,250,15);
        addObject(nyawaD,150,15);
        addObject(waktuD,50,15);

        nyawaD.setValue(roketBudi.getNyawa());   
        waktuD.setValue(this.lamaMain);

        kkk.playLoop();
        
        addObject(soal,47,62);
        soal.setLocation(150,65);
    }
    
    public Roket getRoket(){
        return roketBudi;
    }
    
    public Soal getSoal(){
        return soal;
    }
    
    public Counter getNilaiD(){
        return nilaiD;
    }
    
    public Counter getNyawaD(){
        return nyawaD;
    }
    
    public void resetPosMusuh(){
        try{
            for(int i=0;i<5;i++){
                this.getObjects(Musuh.class).get(i).setLocation(Greenfoot.getRandomNumber(300),Greenfoot.getRandomNumber(200));
            }
        } catch(Exception e){}
        
    }
    
    public void act(){
       //cek jumlah objeck yang terbuat dari class Musuh 
       int x = getObjects(Musuh.class).size();
       
       if(x<=0){
           Greenfoot.delay(100);
           showText("anda menag",100,200);
           //Greenfoot.stop();
           Greenfoot.setWorld(new DuniaAkhir());
       }
       
       if(waktos.millisElapsed()>1000){
           this.lamaMain = this.lamaMain -1;
           waktuD.setValue(this.lamaMain);
           waktos.mark();
       }
       
       if(lamaMain<=0){
        showText("anda gatot",100,200);
        //Greenfoot.stop();
        Greenfoot.setWorld(new DuniaAkhir());
       }       
    }
    
    
    public void stopped(){
        //showText("stopped", 200, 200);
        //kkk.stop();
        kkk.play();
    }
    
    public void started(){
        kkk.playLoop();
        //showText("started", 200, 200);
    }
}
