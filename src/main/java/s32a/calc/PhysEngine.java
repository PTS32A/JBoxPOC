/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s32a.calc;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 *
 * @author Kargathia
 */
public class PhysEngine {

    public World world;
    
    private static final int width = 100;
    private static final int height = 100;
    
    public PhysEngine() {
        
        //Creating a physics world (the 0,0 vector means no gravity in either direction)
        world = new World(new Vec2(0, 0));
        
        
    }
   
    //Convert a JBox2D x coordinate to a JavaFX pixel x coordinate
    public static float toPixelPosX(float posX) {
        float x = width*posX / 100.0f;
        return x;
    }
    
    //Convert a JBox2D y coordinate to a JavaFX pixel y coordinate
    public static float toPixelPosY(float posY) {
        float y = height - (1.0f*height) * posY / 100.0f;
        return y;
    }
}
