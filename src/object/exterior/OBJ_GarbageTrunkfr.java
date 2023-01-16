package object.exterior;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_GarbageTrunkfr extends Object {
    GamePanel gp;
    public final static String objName = "Garbage trunk front";



    public OBJ_GarbageTrunkfr(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        int height = gp.tileSize;
        int width = gp.tileSize;
        image = setup("tiles/exterior/garbage_tunkfr1", width, height);
        image2 = setup("tiles/exterior/garbage_tunkfr2", width, height);
        down1 = image;
        collision = true;
        solidArea.x = 0;
        solidArea.y = 24;
        solidArea.width = 48;
        solidArea.height = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }

    public void setLoot(Entity loot) {
        this.loot = loot;
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You opened a garbage tunk and find a " + loot.name +" !";
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
            }
            startDialogue(this,0);
        } else {
            startDialogue(this,2);
        }
    }
}
