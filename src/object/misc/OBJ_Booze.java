package object.misc;

import entity.Entity;
import main.GamePanel;

public class OBJ_Booze extends Entity {
    GamePanel gp;
    public final static String objName = "Booze";


    public OBJ_Booze(GamePanel gp) {
        super(gp);
        this.gp = gp;
        price =50;
        type = typeConsumable;
        name = objName;
        value = 1;
        stackable = true;
        down1 = setup("objects/booze",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\n Old good moonshine\nTemporarily increase your \ndefense but may cause addiction.";
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You used" + name + "\nYour defense was increased for "+ value + " !";
    }
    public boolean use (Entity entity){
        startDialogue(this,0);
        entity.defense += value;
        gp.player.drunk = true;
        gp.player.timesDrinked ++;
        gp.playSE(35);
        return true;

    }
}
