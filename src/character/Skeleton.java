package character;

import items.Item;

public class Skeleton extends Monster {

    public Skeleton(Item itemDrop) {
        super("Esqueleto", 30, 7, 3, itemDrop);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " golpeia " + target.getName() + " com uma espada enferrujada!");
        target.getDamage(this.attack);
    }

    @Override
    public String specialDescription() {
        return "Seus ossos rangem a cada movimento.";
    }
}