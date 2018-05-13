import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DuniaRank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DuniaRank extends World
{

    /**
     * Constructor for objects of class DuniaRank.
     * 
     */
    public DuniaRank()
    {    
        super(300, 600, 1);
        setBackground("Rank.jpg");
        
        //showText("Rank", getWidth()/2, 100);
        addObject(new Pesan("Rank"),150,150);
        
        if (!UserInfo.isStorageAvailable())
        {
           // System.out.println("simpan ke storage gagal");
        }
        else
        {
            int i = 0;
            for (Object obj : UserInfo.getTop(5)) // for each of the top 5 scoring users
            {
                UserInfo user = (UserInfo)obj; // the UserInfo object of a top 5 scorer
                String username = user.getUserName(); // the name of the user
                int score = user.getScore(); // the high score of the user
                int rank = user.getRank(); // the rank of the user
                // display information (below is just to terminal for testing)
                //System.out.println(""+rank+") "+score+"  "+username);
                //showText(username + "  skore:  " + score, getWidth()/2, 150 + (i*30));
                addObject(new Pesan(username + "  skore:  " + score),150, 200 + (i*30));
                i++;
            }
        }
        
        addObject(new TombolMenu(),150,400);
        //Greenfoot.stop();
    }
}
