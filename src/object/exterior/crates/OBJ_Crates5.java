package object.exterior.crates;

import main.GamePanel;
import object.Object;

public class OBJ_Crates5 extends Object {
    GamePanel gp;
    public final static String objName = "Crates5";

    public OBJ_Crates5(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 14;
        solidArea.y = 12;
        solidArea.width = 22;
        solidArea.height = 22;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize;

        down1 = setup("tiles/exterior/crates5", width, height);


    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
