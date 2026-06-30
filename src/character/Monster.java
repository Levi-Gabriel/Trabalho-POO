package character;

import items.Item;

public abstract class Monster extends Character implements Interactable {
	protected Item itemDrop;
	
    public Monster(String name, int life, int attack, int defense, Item itemDrop) {
        super(name, life, attack, defense);
        this.itemDrop = itemDrop;
    }
    
    public abstract String specialDescription();

    public Item getItemDrop() {
        return itemDrop;
    }
    
    @Override
    public void interact(Hero hero) {
        System.out.println("Um " + name + " selvagem aparece! " + this.specialDescription());
    }
}