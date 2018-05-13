import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DuniaAwal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DuniaAwal extends World
{
    /**
     * Constructor for objects of class DuniaAwal.
     * 
     */
    public DuniaAwal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 600, 1);
        setBackground("math1.jpg");
        //this.showText("Basic Math", getWidth()/2, 100);
        //this.showText("Cimahi 2018", getWidth()/2, 150);
        prepare();
    }

    public void act(){
       
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    { 
        
        
        addObject(new MenuLevel(0,"Penjumlahan"),150,150);
        addObject(new MenuLevel(1,"Pengurangan"),150,210);
        addObject(new MenuLevel(2,"Perkalian"),150,270);
        addObject(new MenuLevel(3,"Pembagian"),150,330);

        addObject(new Rank(),150,390);
        
        addObject(new Pesan("Faisal Najib"),150,470);
        addObject(new Pesan("Cimahi IT"),150,500);
        addObject(new Pesan("2018"),150,530);
    }
}
