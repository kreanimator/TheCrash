package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_Lockpick extends Entity {
    GamePanel gp;
    public final static String objName = "Lockpick";
    public OBJ_Lockpick(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = typeConsumable;
        price = 1000;
        name = objName;
        value = 1;
        stackable = true;
        down1 = setup("objects/lockpick",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nAllows to open one door";
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You use the " + name + "and opened a locker!";
        dialogues [1][0] = "What the hell are you doing?";

    }
//    public boolean use (Entity entity){
//        int objectIndex = getDetected(entity, gp.obj, "Locker");
//
//        if (objectIndex != 999){
//          startDialogue(this,0);
//            gp.obj[gp.currentMap][objectIndex] = null;
//            gp.playSE(6);
//            return true;
//        }else {
//            startDialogue(this,1);
//            return false;
//        }
//
//    }
}
