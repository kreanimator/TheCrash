package object.exterior.trash;

import main.GamePanel;
import object.Object;

public class OBJ_Garbage3 extends Object {
    GamePanel gp;
    public final static String objName = "Garbage3";

    public OBJ_Garbage3(GamePanel gp, int col,int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();
        setAction();

        solidArea.x = 12;
        solidArea.y = 24;
        solidArea.width = gp.tileSize +24;
        solidArea.height = gp.tileSize-18;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize *2;
        int height = gp.tileSize +24;

        down1 = setup("tiles/exterior/garbage3", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
