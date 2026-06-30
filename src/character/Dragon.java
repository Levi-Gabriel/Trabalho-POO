package character;

import items.Item;

public class Dragon extends Monster {

    private final int specialPower = 10;

    public Dragon(Item itemDrop) {
        super("Dragão", 60, 12, 6, itemDrop);
    }

    @Override
    public void attack(Character target) {
        System.out.println(this.name + " solta um sopro de fogo sobre " + target.getName() + "!");
        target.getDamage(this.attack + this.specialPower);
    }

    @Override
    public String specialDescription() {
        return "Suas escamas brilham e o ar fica quente. Cuidado!";
    }
}