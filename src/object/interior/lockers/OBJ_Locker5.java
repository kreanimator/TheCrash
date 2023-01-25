package object.interior.lockers;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Locker5 extends Object {
    GamePanel gp;
    public final static String objName = "Locker5";

    public OBJ_Locker5(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        int height = gp.tileSize*2;
        int width = gp.tileSize+24;
        image = setup("tiles/interior/lockers/locker5", width, height);
        image2 = setup("tiles/interior/lockers/locker5opened", width, height);
        down1 = image;
        collision = true;
        solidArea.x = 18;
        solidArea.y = 60;
        solidArea.width = 36;
        solidArea.height = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }

    public void setLoot(Entity loot) {
        this.loot = loot;
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You opened a locker and find a " + loot.name +" !";
        dialogues[1][0] = "You cannot carry anymore";
        dialogues[2][0] = "It's empty! ";

    }
    public void interact() {
        if (!opened) {
            gp.playSE(6);

            if (!gp.player.canObtainItem(loot)) {
                startDialogue(this,1);
            } else {
                down1 = image2;
                opened = true;
                startDialogue(this,0);
            }

        } else {
            startDialogue(this,2);
        }
    }
}
