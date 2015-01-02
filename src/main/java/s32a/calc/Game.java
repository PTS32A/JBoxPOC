/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s32a.calc;

import javafx.scene.Node;

/**
 *
 * @author Juliusername
 */
public class Game {
    
    public Puck puck;
    
    public Game()
    {
        puck = new Puck();
    }
    
    public Node getPuck()
    {
        return puck.getVisualPuck();
    }
    
    public void run()
    {
        puck.run();
    }
}
