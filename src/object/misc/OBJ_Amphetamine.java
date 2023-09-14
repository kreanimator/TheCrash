package object.misc;

import entity.Entity;
import entity.Player;
import main.GamePanel;

public class OBJ_Amphetamine extends Entity {

    GamePanel gp;
    public final static String objName = "Amphetamine";




    public OBJ_Amphetamine(GamePanel gp) {
        super(gp);
        this.gp = gp;
        price =50;
        type = typeConsumable;
        name = objName;
        value = 2;
        stackable = true;
        down1 = setup("objects/amphetamine",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\nTemporarily increase your \nspeed but may cause addiction.";
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You used" + name + "\nYour speed was increased for "+ value + " !";
    }
    public boolean use (Entity entity){

        startDialogue(this,0);

        entity.speed += value;
        Player.underEffect = true;
        gp.playSE(34);
        gp.player.timesUsed++;


        return true;

    }

}
