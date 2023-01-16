package object.weapon;

import entity.Entity;
import main.GamePanel;

public class OBJ_Ammo_Shotgun extends Entity {

    GamePanel gp;
    public final static String objName = "Shotgun shell";

    public OBJ_Ammo_Shotgun(GamePanel gp) {
        super(gp);
        price = 300;
        this.gp = gp;
        type = typeConsumable;
        stackable = true;
        name = objName;
        value = 6;
        down1 = setup("objects/shotgunShell",gp.tileSize/2,gp.tileSize/2);
        description = "[" + name + "]\n12 mm shotgun ammo.";
    }
    public void setDialogue(){
        dialogues[0][0] = "You used " + name + "\n You got " + value + " more shells.";;
    }
    public boolean use (Entity entity){
        startDialogue(this,0);
        entity.shotgunAmmo += value;
        if ( gp.player.shotgunAmmo > gp.player.maxShotgunAmmo){
            gp.player.shotgunAmmo = gp.player.maxShotgunAmmo;
        }
        gp.playSE(14);
        return true;

    }
}
