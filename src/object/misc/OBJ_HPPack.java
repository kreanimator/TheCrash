package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_HPPack extends Entity {
    GamePanel gp;
    public final static String objName = "HP Pack";


    public OBJ_HPPack(GamePanel gp) {
        super(gp);
        this.gp = gp;
        price =150;
        type = typeConsumable;
        name = objName;
        value = 5;
        stackable = true;
        down1 = setup("objects/hppack",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nRestores some amount of HP.";
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You used" + name + "\nYou restored " + value + " HP.";
    }
    public boolean use (Entity entity){
        startDialogue(this,0);
        entity.life += value;
        gp.playSE(11);
        return true;

    }
}
