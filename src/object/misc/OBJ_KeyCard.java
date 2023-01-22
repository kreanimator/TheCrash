package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_KeyCard extends Entity {

    GamePanel gp;
    public final static String objName = "Key Card";
    public OBJ_KeyCard(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = typeConsumable;
        name = objName;
        value = 1;
        down1 = setup("objects/keycard",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nAn old bunker key card.";
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] =  "You use the " + name + "and opened a bunker! \nWow it is dark out there, you'd better find a flashlight!";
        dialogues [1][0] = "What the hell are you doing?";
    }
    public boolean use (Entity entity){
        int objectIndex = getDetected(entity, gp.obj, "Bunker Door");

        if (objectIndex != 999){
            startDialogue(this,0);
            gp.obj[gp.currentMap][objectIndex] = null;
            gp.playSE(28);
            return true;
        }else {
            startDialogue(this,1);
            gp.playSE(6);
            return false;
        }

    }
}
