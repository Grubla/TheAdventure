package se.chalmers.kangaroo.model;


import java.util.ArrayList;
import java.util.List;

import se.chalmers.kangaroo.io.FileToMap;

/**
 * This is a class for representing a map. It consists of a matrix of Tiles.
 * The map has tiles but also other things; creatures, items and iteractiveobjects
 * @author alburgh
 * 
 */
public class GameMap {

	/* The map represented by a matrix of tiles */
	private Tile[][] map;
	private List<InteractiveObject> iObjects = new ArrayList<InteractiveObject>();
	private List<Item> items = new ArrayList<Item>();
	private List<Creature> creatures = new ArrayList<Creature>();

	/**
	 * Creates a GameMap with the level name. 
	 * The level name should be the path to the file. 
	 * Creates all tiles along with items and creatures.
	 */
	public GameMap(String level) {
		super();
		int[][] tiles = FileToMap.readTmxFileToMap(level);
		String itemList = "QWERT"; //<-- FROM CONSTANTS TODO:
		String creatureList = "QWERT"; // -^
		String iObjectsList = "QWERT"; // --^
		if(tiles != null)
			map = new Tile[tiles.length][tiles[0].length];
		else
			System.out.println("HEJ");
		Factory tf = new Factory();
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = tf.createTile((tiles[i][j]));
				if( itemList.contains(""+tiles[i][j]) )
					items.add(tf.createItem(tiles[i][j]));
				if( creatureList.contains(""+tiles[i][j]) )
					creatures.add(tf.createCreature(tiles[i][j]));
				if( iObjectsList.contains(""+tiles[i][j]))
					iObjects.add(tf.createIObjects(tiles[i][j]));
			}
		
	}

	/**
	 * Returns the i:th interactive object
	 * Will cast IndexOutOfBoundsException if i > getIObjectSize()
	 * 
	 * @return the list of InteractiveObjects
	 */
	public InteractiveObject getIObjectAt(int i) {
		return iObjects.get(i);
	}
	/**
	 * Return the amount of iObjects currently on the map.
	 * @return the amount
	 */
	public int getIObjectSize(){
		return iObjects.size();
	}

	/**
	 * Return the i:th item.
	 * Will cast IndexOutOfBoundsException if i > getItemSize()
	 * @return a list of the items
	 */
	public Item getItemAt(int i) {
		return items.get(i);
	}
	/**
	 * Return the amount of items currently on the map.
	 * @return the amount of items
	 */
	public int getItemSize(){
		return items.size();
	}
	
	/**
	 * Return the i:th creature.
	 * Will cast IndexOutOfBoundsException if i > getCreatureSize()
	 * @return a list of creatures
	 */
	public Creature getCreatureAt(int i) {
		return creatures.get(i);
	}
	/**
	 * Return the amount of creatures currently on the map.
	 * @return the number of creatures
	 */
	public int getCreatureSize(){
		return creatures.size();
	}
	/**
	 * Returns the tile at the given position
	 * @param x, position in x-axis, x < getTileWidth()
	 * @param y, position in y,axis, y < getTileHieght()
	 * @throws IndexOutOfBoundsException if -^
	 * @return the tile at the given position
	 */
	public Tile getTile(int x, int y){
		return map[x][y];
	}
	/**
	 * Returns the width of the map in tiles. 
	 * 
	 * @return
	 */
	public int getTileWidth(){
		return map.length;
	}
	/**
	 * Returns the height of the map in tiles
	 * @return
	 */
	public int getTileHeight(){
		return map[0].length;
	}
}
