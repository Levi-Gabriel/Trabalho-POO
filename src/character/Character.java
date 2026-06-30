package character;

public abstract class Character {

    private static int totalChar = 0;
    protected String name;
    protected int life;
    protected int maxLife;
    protected int attack;
    protected int defense;

    public Character(String name, int life, int attack, int defense) {
        this.name = name;
        this.life = life;
        this.maxLife = life;
        this.attack = attack;
        this.defense = defense;
        Character.totalChar++;
    }

    public static int getTotalChar() {
        return Character.totalChar;
    }

    public void getDamage(int damage) {
        int finalDamage = Math.max(1, damage - this.defense);
        this.life -= finalDamage;
        if (this.life < 0) {
            this.life = 0;
        }
        System.out.println(this.name + " sofreu " + finalDamage + " de dano! (Vida: " + life + "/" + maxLife + ")");
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return defense;
    }

    public String heal(int power) {
        this.life = Math.min(maxLife, this.life + power);
        return this.name + " agora está com" + this.life + "/" + maxLife;
    }

    public void attack(Character target) {};
    
    protected String boostAttack(int boost) {
        this.attack += boost;
        return "O ataque de " + this.name + " passou a ser " + this.attack;
    }

    protected String boostDefense(int boost) {
        this.defense += boost;
        return "A defesa de " + this.name + " passou a ser " + this.defense;
    }
    @Override
    public String toString() {
        return this.name + " [Vida: " + this.life + "/" + this.maxLife + ", Ataque: " + this.attack + ", Defesa: " + this.defense + "]";
    }
} 