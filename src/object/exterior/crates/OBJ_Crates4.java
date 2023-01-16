package object.exterior.crates;

import main.GamePanel;
import object.Object;

public class OBJ_Crates4 extends Object {
    GamePanel gp;
    public final static String objName = "Crates4";

    public OBJ_Crates4(GamePanel gp, int col , int row) {
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


        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 26;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = gp.tileSize;
        int height = gp.tileSize;

        down1 = setup("tiles/exterior/crates4", width, height);


    }
}
