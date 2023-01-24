package object.interior.bar;

import main.GamePanel;
import object.Object;

public class OBJ_BarTable1 extends Object {
    GamePanel gp;
    public final static String objName = "BarTable1";

    public OBJ_BarTable1(GamePanel gp,int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();

        solidArea.x = 6;
        solidArea.y = 12;
        solidArea.width = gp.tileSize-6;
        solidArea.height = (gp.tileSize*2)-32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize *2;

        down1 = setup("tiles/interior/bar/bartable1", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
