package laba2;

abstract class Weapon {
    private String name;
    private int damage;
    private int durability;

    public Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    public abstract void attack();
    public abstract void afterAttack();

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}

class Sword extends Weapon {
    private static int swordCount = 0;
    public Sword(String name, int damage, int durability) {
        super(name, damage, durability);
        swordCount++;
    }
    @Override
    public void attack() {
        System.out.println(getName() + " with " + getDamage() + " damage and " + getDurability() + "% durability!");
    }
    @Override
    public void afterAttack(){
        System.out.println("new durability" + (getDurability() - 10));
    }

    public static int swordCount(){
        return swordCount;
    }
}

class Bow extends Weapon {
    public Bow(String name, int damage, int durability) {
        super(name, damage, durability);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " with arrows with " + getDamage() + " damage and " + getDurability() + "% durability!");
    }
    @Override
    public void afterAttack(){
        System.out.println("new durability" + (getDurability() - 10));
    }
}

class Wand extends Weapon {
    public Wand(String name, int damage, int durability) {
        super(name, damage, durability);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " with " + getDamage() + " power and " + getDurability() + "% durability!");
    }

    @Override
    public void afterAttack(){
        System.out.println("new durability" + (getDurability() - 10));
    }
}

 class SuperSword extends Sword {
    public SuperSword(String name, int damage, int durability) {
        super(name, damage, durability);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " with " + getDamage() + " power and " + getDurability() + "% durability!");
    }
}

public class Main {
    public static void main(String[] args) {
        SuperSword superSword = new SuperSword("Super", 100, 100);
        superSword.attack();
        //
        System.out.println("____________________");
        Sword sword = new Sword("Sword", 10, 100);
        sword.setName("Excalibur");
        //
        System.out.println("Name: " + sword.getName());
        System.out.println("Damage: " + sword.getDamage());
        System.out.println("Durability: " + sword.getDurability());
        //
        sword.attack();
        System.out.println("Swords: " + sword.swordCount());
        System.out.println("____________________");

        Bow bow = new Bow("Golden Bow", 8, 80);
        bow.setDamage(20);
        bow.attack();
        bow.afterAttack();
        System.out.println("____________________");

        Wand wand = new Wand("Magic Wand", 15, 50);
        wand.setDurability(70);
        wand.attack();
    }
}