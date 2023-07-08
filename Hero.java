package LS_Java_8;

public class Hero implements Health, Mana {
    private String name;
    
    private int maxHealthPoint;
    private int currentHealthPoint;

    private int maxManaPoint;
    private int currentManaPoint;

    public Hero (String _name, int _hp, int _maxHp, int _mana, int _maxMana) {
        this.name = _name;
        this.currentHealthPoint = _hp;
        this.maxHealthPoint = _maxHp;
        this.currentManaPoint = _mana;
        this.maxManaPoint = _maxMana;
    }

    @Override
    public String SetName() {
        return this.name;
    }

    @Override
    public int SetHp() {
        return this.currentHealthPoint;
    }

    @Override
    public int SetMaxHp() {
        return this.maxHealthPoint;
    }

    @Override
    public int SetMana() {
        return this.currentManaPoint;
    }

    @Override
    public int SetMaxMana() {
        return this.maxManaPoint;
    }
}
