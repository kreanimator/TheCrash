package object.exterior.toilets;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_Toilet1 extends Object {
    GamePanel gp;
    public final static String objName = "Toilet1";



    public OBJ_Toilet1(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        solidArea.x = 24;
        solidArea.y = 34;
        solidArea.width = 45;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        int height = gp.tileSize+36;
        int width = gp.tileSize*2;
        image = setup("tiles/exterior/toilet1", width, height);
        down1 = image;
        collision = true;
        setDialogue();
    }


    public void setDialogue(){
        dialogues[0][0] = "Fuck! This stinks!";


    }
    public void interact() {
            startDialogue(this,0);

    }
}
