package factory;

import java.util.Random;

import character.Dragon;
import character.Goblin;
import character.Monster;
import character.Skeleton;
import items.Item;

/**
 * 	Responsável por criar instâncias de Monstro.
 * Padrão de projeto Factory Method.
 * Mapa não precisa conhecer as classes concretas de monstro, apenas
 * solicita "um monstro aleatório" ou "um dragão".
 */

// Classe utilitária

public class MonsterFactory {

    private MonsterFactory() {}

    public static Monster createMonsters(Random random, Item itemDrop) {
        int type = random.nextInt(2); // Dragão é criado à parte (boss)
        switch (type) {
            case 0:
                return new Goblin(itemDrop);
            case 1:
                return new Skeleton(itemDrop);
            default:
                return new Goblin(itemDrop);
        }
    }

    public static Monster createDragon(Item itemDrop) {
        return new Dragon(itemDrop);
    }
}