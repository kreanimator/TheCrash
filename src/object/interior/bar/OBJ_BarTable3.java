package object.interior.bar;

import main.GamePanel;
import object.Object;

public class OBJ_BarTable3 extends Object {
    GamePanel gp;
    public final static String objName = "BarTable3";

    public OBJ_BarTable3(GamePanel gp,int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.height = 12;
        solidArea.width = gp.tileSize*2;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int height = gp.tileSize;
        int width = gp.tileSize *2;

        down1 = setup("tiles/interior/bar/bartable3", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
