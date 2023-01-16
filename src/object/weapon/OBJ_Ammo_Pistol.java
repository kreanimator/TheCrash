package object.weapon;

import entity.Entity;
import main.GamePanel;

public class OBJ_Ammo_Pistol extends Entity {
    GamePanel gp;
    public final static String objName = "10 mm";

    public OBJ_Ammo_Pistol(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = typeConsumable;
        price = 200;
        stackable = true;
        name = objName;
        value = 10;
        down1 = setup("objects/10mm",gp.tileSize/2,gp.tileSize/2);
        image = setup("objects/10mm",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\n10 mm pistol ammo.";


    }
    public void setDialogue(){
        dialogues[0][0] = "You used " + name + "\n You got " + value + " more bullets.";
    }
    public boolean use (Entity entity){
        startDialogue(this,0);
        entity.pistolAmmo += value;
        if ( gp.player.pistolAmmo > gp.player.maxPistolAmmo){
            gp.player.pistolAmmo = gp.player.maxPistolAmmo;
        }
        gp.playSE(10);
        return true;

    }
}
