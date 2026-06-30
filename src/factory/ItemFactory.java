package factory;

import java.util.Random;

import items.Weapon;
import items.Armor;
import items.Item;
import items.CurePotion;

// Responsável por criar instâncias de Item.

public class ItemFactory {

    private static final String[] WEAPON_NAMES = {"Espada Curta", "Machado de Guerra", "Adaga Élfica"};
    private static final String[] ARMOR_NAMES = {"Couraça de Couro", "Cota de Malha", "Escudo Reforçado"};

    private ItemFactory() {
        // Classe utilitária: não deve ser instanciada.
    }

    public static Item createItems(Random random) {
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                return new CurePotion(10 + random.nextInt(11)); // cura entre 10 e 20
            case 1:
                String weaponName = WEAPON_NAMES[random.nextInt(WEAPON_NAMES.length)];
                return new Weapon(weaponName, 2 + random.nextInt(5)); // +2 a +6 de ataque
            default:
                String armorName = ARMOR_NAMES[random.nextInt(ARMOR_NAMES.length)];
                return new Armor(armorName, 1 + random.nextInt(4)); // +1 a +4 de defesa
        }
    }
}