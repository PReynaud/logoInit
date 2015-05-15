package model;

import org.junit.After;
import org.junit.Before;


import static org.junit.Assert.*;

/**
 * Created by Dimitri on 15/05/2015.
 */
public class ImprovedTurtleTest {
    ImprovedTurtle turtle;

    @Before
    public void setUp() throws Exception {
        this.turtle = new ImprovedTurtle();
        this.turtle.reset();

    }

    @After
    public void tearDown() throws Exception {
        this.turtle = new ImprovedTurtle();
        turtle.reset();
    }

    @org.junit.Test
    public void testAddKnownTurtle() throws Exception {
        ImprovedTurtle oneTurtle = new ImprovedTurtle("Donatello");
        turtle.addKnownTurtle(oneTurtle);
        assertEquals("testAddKnownTurtle : Test nb known turtle", 1, turtle.getKnownTurtles().size());
        assertEquals("testAddKnownTurtle : Test turtle added", true, turtle.getKnownTurtles().get(0).equals(oneTurtle));
    }

    @org.junit.Test
    public void testRemoveKnownTurtle() throws Exception {
        ImprovedTurtle oneTurtle = new ImprovedTurtle("Donatello");
        turtle.addKnownTurtle(oneTurtle);
        turtle.removeKnownTurtle(new ImprovedTurtle());
        assertEquals("testRemoveKnownTurtle : remove unknown turtle", 1, turtle.getKnownTurtles().size());
        turtle.removeKnownTurtle(oneTurtle);
        assertEquals("testRemoveKnownTurtle : remove unknown turtle", 0, turtle.getKnownTurtles().size());
    }

    @org.junit.Test
    public void testAvancer() throws Exception {
        turtle.setPosition(0,0);
        turtle.avancer(10);
        assertEquals("testAvancer : bord haut pos X", 0, turtle.getX());
        assertEquals("testAvancer : bord haut pos Y", Turtle.MAX_Y-10, turtle.getY());
        turtle.gauche(180);
        turtle.avancer(10);
        assertEquals("testAvancer : bord bas pos X", 0, turtle.getX());
        assertEquals("testAvancer : bord bas pos Y", 0, turtle.getY());

        turtle.droite(90);
        turtle.avancer(10);
        assertEquals("testAvancer : bord droit pos X", Turtle.MAX_X - 10, turtle.getX());
        assertEquals("testAvancer : bord droit pos Y", 0, turtle.getY());
        turtle.gauche(180);
        turtle.avancer(10);
        assertEquals("testAvancer : bord gauche pos X", 0, turtle.getX());
        assertEquals("testAvancer : bord gauche pos Y", 0, turtle.getY());
    }

    @org.junit.Test
    public void testSaySomething() throws Exception {
        turtle.setPosition(0, 0);
        ImprovedTurtle oneTurtle = new ImprovedTurtle("Donatello"),
                otherTurtle = new ImprovedTurtle("Shredder");

        turtle.addKnownTurtle(oneTurtle);
        oneTurtle.reset();
        oneTurtle.setPosition(15, 0);
        otherTurtle.setPosition(15, 0);

        turtle.saySomething();
        assertEquals("testSaySomething : Turtle a portee", Turtle.MAX_Y - 20, oneTurtle.getY());
        assertEquals("testSaySomething : Turtle inconnue", 0, otherTurtle.getY());
        assertEquals("testSaySomething : Turtle inconnue", 15, otherTurtle.getX());
        turtle.saySomething();
        assertEquals("testSaySomething : Turtle hors de portee",Turtle.MAX_Y-20,oneTurtle.getY());
        assertEquals("testSaySomething : Turtle inconnue", 0, otherTurtle.getY());
        assertEquals("testSaySomething : Turtle inconnue", 15, otherTurtle.getX());
    }

    @org.junit.Test
    public void testEquals() throws Exception {
        turtle.equals(new ImprovedTurtle("Michelangelo"));
    }
}