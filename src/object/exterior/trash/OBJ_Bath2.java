package object.exterior.trash;

import main.GamePanel;
import object.Object;

public class OBJ_Bath2 extends Object {
    GamePanel gp;
    public final static String objName = "Bath2";

    public OBJ_Bath2(GamePanel gp,int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();
        setDialogue();

        solidArea.x = 6;
        solidArea.y = 0;
        solidArea.width = gp.tileSize-12;
        solidArea.height = gp.tileSize;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize +24;

        down1 = setup("tiles/exterior/bath2", width, height);

    }

    public void setDialogue(){
        dialogues[0][0] = "Hey! I don't want to drink this!";


    }
    public void interact() {
        startDialogue(this,0);
    }
}
