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
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import static s32a.calc.PhysEngine.toPixelPosX;
import static s32a.calc.PhysEngine.toPixelPosY;

/**
 *
 * @author Juliusername
 */
public class Puck {
    
    public PhysEngine physEngine;
    
    private Circle puck;
    
    private float startX;
    private float startY;
    private float radius;
    
    public Puck()
    {
        physEngine = new PhysEngine();
        
        puck = new Circle();
        puck.setRadius(5);
        puck.setFill(Color.BLACK);
        
        startX = 50;
        startY = 50;
        radius = 2;
        
        /**
         * Set ball position on JavaFX scene. We need to convert JBox2D coordinates 
         * to JavaFX coordinates which are in pixels.
         */
        puck.setLayoutX(toPixelPosX(startX)); 
        puck.setLayoutY(toPixelPosY(startY));
        
        puck.setCache(true); //Cache this object for better performance
         
        //Create an JBox2D body defination for ball.
        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(startX, startY);
         
        CircleShape cs = new CircleShape();
        cs.m_radius = radius * 0.1f;  //We need to convert radius to JBox2D equivalent
         
        // Create a fixture for ball
        FixtureDef fd = new FixtureDef();
        fd.shape = cs;
        fd.density = 0.9f;
        fd.friction = 0.3f;        
        fd.restitution = 0.6f;
 
        /**
        * Virtual invisible JBox2D body of ball. Bodies have velocity and position. 
        * Forces, torques, and impulses can be applied to these bodies.
        */
          Body body = physEngine.world.createBody(bd);
          body.createFixture(fd);
          puck.setUserData(body);
    }
    
    public Node getVisualPuck()
    {
        return this.puck;
    }
    
    public void run()
    {
        
    }
}
