import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DuniaAkhir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DuniaAkhir extends World
{

    /**
     * Constructor for objects of class DuniaAkhir.
     * 
     */
    public DuniaAkhir()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 600, 1);
        setBackground("tekno.jpg");
        addObject(new Pesan("Permainan Berakhir"),150,335);

        //showText("Permainan Berakhir", getWidth()/2, getHeight()/2);
        //Greenfoot.stop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {        
        addObject(new Rank(),85,385);        
        addObject(new TombolMenu(),215,385);
    }
}
