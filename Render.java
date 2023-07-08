package LS_Java_8;

public class Render {
    
    public void showIndicator(Object object) {
        if(object instanceof Health) {
            System.out.print(((Health) object).SetName());
            System.out.print(" hp ");
            Streak(((Health) object).SetMaxHp(), ((Health) object).SetHp());
        }

        if(object instanceof Mana) {
            System.out.print(" mana ");
            Streak(((Mana) object).SetMaxMana(), ((Mana) object).SetMana());
        }
        System.out.println();  
    }

    private void Streak (int maxCount, int count) {
        System.out.print("[");
        for(int i = 0; i <= maxCount; i++) {
            if(i <= count) System.out.print("#");
            else System.out.print(" ");
        }
        System.out.print("] ");
    }
}
