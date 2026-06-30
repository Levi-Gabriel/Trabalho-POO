package items;

import character.Hero;

public class Weapon extends Item{
    private final int attackBonus;

    public Weapon(String name, int bonusAttack) {
        super(name, "Arma que concede +" + bonusAttack + " de ataque.");
        this.attackBonus = bonusAttack;
    }
    
    @Override
    public void use(Hero hero) {
        hero.equipWeapon(this);
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}


