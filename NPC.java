package LS_Java_8;

public class NPC implements Health{
    private String name;
    
    private int currentHealthPoint;

    public NPC (String _name, int _hp) {
        this.name = _name;
        this.currentHealthPoint = _hp;
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
        return SetHp();
    }
}
