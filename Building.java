package LS_Java_8;

public class Building implements Health{
    
    private String name;
    private int currentHealths;
    private int maxHealths;
    

    public Building(String _name, int _hp, int _maxHp) {
        this.name = _name;
        this.currentHealths = _hp;
        this.maxHealths = _maxHp;
    }

    @Override
    public String SetName() {
        return this.name;
    }

    @Override
    public int SetHp() {
        return this.currentHealths;
    }

    @Override
    public int SetMaxHp() {
        return this.maxHealths;
    }
}
