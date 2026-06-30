package items;

import character.Hero;

public class Armor extends Item{
	private final int defenseBonus;
	
	public Armor(String name, int defenseBonus) {
        super(name, "Armadura que concede +" + defenseBonus + " de defesa.");
        this.defenseBonus = defenseBonus;
	}

    @Override
    public void use(Hero hero) {
        hero.equipArmor(this);
    }
 
    public int getDefenseBonus() {
        return defenseBonus;
    }
}
