package object.exterior.fridges;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Fridge2 extends Object {
    GamePanel gp;
    public final static String objName = "Fridge2";

    public OBJ_Fridge2(GamePanel gp,int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();

        solidArea.x = 12;
        solidArea.y = 24;
        solidArea.width = gp.tileSize-12;
        solidArea.height = gp.tileSize-24;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize+24;

        down1 = setup("tiles/exterior/fridge2", width, height);

    }

    public void setLoot(Entity loot) {
        this.loot = loot;
        setDialogue();
    }
    public void setDialogue(){
        dialogues[0][0] = "You shook that old fridge and find a " + loot.name +" !";
        dialogues[1][0] = "You cannot carry anymore";
        dialogues[2][0] = "It's empty! ";

    }
    public void interact() {
        if (!opened) {
            gp.playSE(33);

            if (!gp.player.canObtainItem(loot)) {
                startDialogue(this,1);
            } else {
                opened = true;
                startDialogue(this,0);
            }

        } else {
            startDialogue(this,2);
        }
    }

}
