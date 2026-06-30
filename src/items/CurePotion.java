package items;

import character.Hero;

public class CurePotion extends Item{
	private final int power;
	
	public CurePotion(int power) {
	    super("Poção de Cura", "Recupera " + power + " pontos de vida.");
	    this.power = power;
	}
	
	@Override
    public void use(Hero hero) {
	    hero.heal(this.power);
	    System.out.println(hero.getName() + " bebeu uma poção e recuperou " + this.power + " de vida!");
    }
	public int getPower() {
	    return this.power;
	}
}

