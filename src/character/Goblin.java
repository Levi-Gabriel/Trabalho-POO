package character;

import items.Item;

public class Goblin extends Monster{
	
    public Goblin(Item itemDrop) {
        super("Goblin", 20, 5, 1, itemDrop);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " arranha " + target.getName() + " com sua adaga!");
        target.getDamage(this.attack);
    }

    @Override
    public String specialDescription() {
        return "É rápido, mas frágil.";
    }
}