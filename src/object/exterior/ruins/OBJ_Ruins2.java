package object.exterior.ruins;

import main.GamePanel;
import object.Object;

public class OBJ_Ruins2 extends Object {
    GamePanel gp;
    public final static String objName = "Ruins2";

    public OBJ_Ruins2(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 10;
        solidArea.y = 20;
        solidArea.width = gp.tileSize;
        solidArea.height = 24;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize + 24;
        int height = gp.tileSize+24;

        down1 = setup("tiles/exterior/ruins2", width, height);


    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
