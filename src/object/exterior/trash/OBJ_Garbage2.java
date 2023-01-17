package object.exterior.trash;

import main.GamePanel;
import object.Object;

public class OBJ_Garbage2 extends Object {
    GamePanel gp;
    public final static String objName = "Garbage2";

    public OBJ_Garbage2(GamePanel gp,int col,int row) {
        super(gp, col, row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;

        collision = true;
        getImage();
        setAction();

        solidArea.x = 20;
        solidArea.y = 20;
        solidArea.width = gp.tileSize *2;
        solidArea.height = gp.tileSize-10;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize *3;
        int height = gp.tileSize + 24;

        down1 = setup("tiles/exterior/garbage2", width, height);

    }

    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
