/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s32a.calc;

import java.util.Timer;
import javafx.scene.Node;

/**
 *
 * @author Juliusername
 */
public class Game {
    
    public Puck puck;
    private Timer puckTimer;
    public boolean allowRun;
    private int roundNo;
    
    public Game()
    {
        puck = new Puck(this);
        puckTimer = new Timer();
        allowRun = false;
        roundNo = 0;
    }
    
    public Node getPuck()
    {
        return puck.getVisualPuck();
    }
    
    public void beginGame()
    {
        puckTimer.scheduleAtFixedRate(puck, 0, 20);
        startRound();
    }
        
    public void startRound()
    {
        roundNo++;
        allowRun = true;
    }
    
    public void endRound()
    {
        allowRun = false;
    }
}
