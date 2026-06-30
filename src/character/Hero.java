package character;

import items.Armor;
import items.Inventory;
import items.Item;
import items.Weapon;

// Representa o personagem controlado pelo jogador.

public class Hero extends Character {
    private final Inventory inventory; 
    private Weapon weapon;          
    private Armor armor;

    public Hero(String name, int life, int attack, int defense) {
        super(name, life, attack, defense);
        this.inventory = new Inventory();
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " ataca " + target.getName() + "!");
        target.getDamage(this.attack);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        boostAttack(weapon.getAttackBonus());
        System.out.println(this.name + " equipou " + this.weapon.getName() + " (+" + weapon.getAttackBonus() + " ataque)");
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
        boostDefense(armor.getDefenseBonus());
        System.out.println(this.name + " equipou " + armor.getName() + " (+" + armor.getDefenseBonus() + " defesa)");
    }

    public void getItem(Item item) {
        inventory.add(item);
        System.out.println(this.name + " recebeu: " + item.getName());
    }

    public void useItem(Item item) {
        if (inventory.contains(item)) {
            item.use(this);
            inventory.remove(item);
        } else {
            System.out.println(this.name + " não possui esse item.");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeappon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}