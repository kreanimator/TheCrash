package object.exterior.ladders;

import main.GamePanel;
import object.Object;

public class OBJ_LadderUp1 extends Object {

    GamePanel gp;
    public final static String objName = "LadderUp1";
    public OBJ_LadderUp1(GamePanel gp, int col, int row) {


        super(gp,col,row);
        this.gp = gp;
        name = objName;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = gp.tileSize;
        solidArea.width = gp.tileSize*2;
        solidArea.height = gp.tileSize;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;;
    }
    public void getImage() {
        int width = gp.tileSize *2;
        int height = gp.tileSize*2;

        down1 = setup("tiles/exterior/ladders/ladderup1", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
