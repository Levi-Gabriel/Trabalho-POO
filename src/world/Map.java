package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import factory.ItemFactory;
import factory.MonsterFactory;
import items.Item;
import character.Monster;

public class Map {

    private List<Room> rooms; 
    private Room initialRoom;
    private Random random;

    private static final String[] ROOM_NAMES = {
        "Corredor Sombrio", "Câmara de Pedra", "Salão Esquecido", "Cripta Antiga",
        "Galeria Úmida", "Passagem Estreita", "Sala do Eco", "Recanto Empoeirado"
    };

    private static final String[] ROOM_DESCRIPTIONS = {
        "O ar é pesado e cheira a mofo.",
        "Tochas bruxuleantes iluminam paredes rachadas.",
        "O silêncio aqui é quase ensurdecedor.",
        "Pegadas antigas marcam o chão de pedra.",
        "Você ouve um gotejar distante de água."
    };

    public Map(int roomQuantity, long seed) {
        this.rooms = new ArrayList<>();
        this.random = new Random(seed);
        this.initialRoom = this.generateDungeon(roomQuantity);
    }

    /**
     * Gera uma masmorra em formato de "corredor" com
     * ramificações simples.
     */
    
    // Atualmente, o jogador só consegue se mover para leste e oeste, 
    // no futuro eu implemento um grafo para melhorar esse mapa 
    
    private Room generateDungeon(int roomQuantity) {
    	Room previous = null;
    	Room first = null;

        for (int i = 0; i < roomQuantity; i++) {
            boolean isFinal = (i == roomQuantity - 1);
            String name = ROOM_NAMES[random.nextInt(ROOM_NAMES.length)] + " " + (i + 1);
            String description = ROOM_DESCRIPTIONS[random.nextInt(ROOM_DESCRIPTIONS.length)];
            Room room = new Room(name, description, isFinal);

            fillRoom(room, isFinal);
            rooms.add(room);

            if (previous != null) {
            	previous.connect(Direction.LESTE, room);
            	room.connect(Direction.OESTE, previous);
            } else {
            	first = room;
            }
            previous = room;
        }
        return first;
    }

    private void fillRoom(Room room, boolean isFinal) {
        // Sala final sempre recebe um Dragão.
        if (isFinal) {
            Item finalDrop = ItemFactory.createItems(random);
            Monster dragon = MonsterFactory.createDragon(finalDrop);
            room.addMonster(dragon);
            return;
        }

        // Chance de ter de 0 a 2 monstros comuns.
        int Monstersqtt = random.nextInt(3);
        for (int i = 0; i < Monstersqtt; i++) {
            Item drop = ItemFactory.createItems(random);
            Monster monster = MonsterFactory.createMonsters(random, drop);
            room.addMonster(monster);
        }

        // 50% de chance de ter um baú com item.
        if (random.nextBoolean()) {
            Item itemChest = ItemFactory.createItems(random);
            room.setChest(new Chest(itemChest));
        }
    }

    public Room getInitialRoom() {
        return initialRoom;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}