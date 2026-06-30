package world;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import character.Monster;


public class Room {

    private final String name;
    private final String description;
    private final List<Monster> monsters;    
    private Chest chest;                        
    private final Map<Direction, Room> paths;   
    private boolean visited;
    private final boolean finalRoom;

    public Room(String name, String description, boolean finalRoom) {
        this.name = name;
        this.description = description;
        this.monsters = new ArrayList<>();
        this.paths = new HashMap<Direction, Room>();
        this.visited = false;
        this.finalRoom = finalRoom;
    }

    public void connect(Direction direction, Room destination) {
        this.paths.put(direction, destination);
    }

    public Room getpaths(Direction direction) {
        return this.paths.get(direction);
    }

    public Map<Direction, Room> getSaidas() {
        return this.paths;
    }

    public void addMonster(Monster monster) {
        this.monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
    	monsters.remove(monster);
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    public boolean areMonsterALive() {
        return monsters.stream().anyMatch(Monster::isAlive);
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Chest getChest() {
        return this.chest;
    }

    public boolean isFinalRoom() {
        return finalRoom;
    }

    public boolean isVisited() {
        return visited;
    }

    public void roomVisited() {
        this.visited = true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void description() {
        System.out.println("\n=== " + this.name + " ===");
        System.out.println(this.description);
        if (areMonsterALive()) {
            System.out.println("Monstros nesta sala:");
            for (Monster m : monsters) {
                if (m.isAlive()) {
                    System.out.println(" - " + m.getName());
                }
            }
        }
        if (chest != null && !chest.getIsOpen()) {
            System.out.println("Há um baú nesta sala.");
        }
        System.out.print("Saídas: ");
        for (Direction d : paths.keySet()) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}