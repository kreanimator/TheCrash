package object.misc;

import entity.Entity;
import main.GamePanel;


public class OBJ_Key extends Entity {
    GamePanel gp;
    public final static String objName = "Key";


    public OBJ_Key(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = typeConsumable;
        price = 1000;
        name = objName;
        stackable = true;
        down1 = setup("objects/key",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nA strange old key.";
        setDialogue();

    }
    public void setDialogue(){
        dialogues[0][0] = "You use the " + name + "and opened a locker!";
        dialogues [1][0] = "What the hell are you doing?";

    }
    public boolean use (Entity entity){
     int objectIndex = getDetected(entity, gp.obj, "Chest");

     if (objectIndex != 999){
         startDialogue(this,0);
         gp.obj[gp.currentMap][objectIndex] = null;
         gp.playSE(6);
         return true;
     }else {
         startDialogue(this,1);
         return false;
     }
    }
}
