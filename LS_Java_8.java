package LS_Java_8;



public class LS_Java_8 {
    public static void main(String[] args) {
        
        Hero ovellord = new Hero("Владыка", 8, 9, 9, 9);
        NPC npc = new NPC("Гнарл", 9);
        Building tower = new Building("Башня", 7, 9);

        Render render = new Render();
        
        render.showIndicator(ovellord);
        render.showIndicator(npc);
        render.showIndicator(tower);









    }
}