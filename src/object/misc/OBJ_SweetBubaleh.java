package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_SweetBubaleh extends Entity{
    GamePanel gp;
    public final static String objName = "Sweet Bubalekh";


    public OBJ_SweetBubaleh(GamePanel gp) {
        super(gp);
        this.gp = gp;
        price =30;
        type = typeConsumable;
        name = objName;
        value = 1;
        stackable = true;
        down1 = setup("objects/soda",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nWow! It is famous \n" + name+ "\nRestores some amount of HP.";
        setDialogue();
    }

    public void setDialogue(){
        dialogues[0][0] = "You used" + name + "\nYou restored " + value + " HP.";
    }
    public boolean use (Entity entity){
        startDialogue(this,0);
        entity.life += value;
        gp.playSE(32);
        return true;

    }
}
