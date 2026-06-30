package world;

import items.Item;
import character.Hero;
import character.Interactable;


public class Chest implements Interactable {

    private final Item item; 
    private boolean isOpen;

    public Chest(Item item) {
        this.item = item;
        this.isOpen = false;
    }

    @Override
    public void interact(Hero hero) {
        if (isOpen) {
            System.out.println("O baú já está vazio.");
            return;
        }
        System.out.println("Você abre o baú e encontra: " + item.getName() + "!");
        hero.getItem(item);
        this.setIsOpen(true);
    }

    public boolean getIsOpen() {
        return isOpen;
    }
    public void setIsOpen(boolean fact) {
    	this.isOpen = fact;
    }
}