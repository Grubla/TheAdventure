package se.chalmers.kangaroo.model;

import java.awt.Polygon;

/**
 * 
 * @author pavlov
 *
 */
public class CrabCreature extends Creature{
	private int speed = 3;
	private Polygon creaturePoly;
	
	
	protected CrabCreature(Position spawnPos, Direction direction) {
		super(spawnPos, direction);
		creaturePoly.npoints = 12;
		int polyX[] = {0,14,14,20,20,44,44,50,50,64,64,54,54,10,10,0};
		int polyY[] = {2,2,0,0,6,6,0,0,2,2,16,16,32,32,16,16};
		if(polyX.length == polyY.length){
			for(int i = 0; i < polyX.length; i++){
				
			}
		}
	}

}