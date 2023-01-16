package object.exterior;

import entity.Entity;
import main.GamePanel;
import object.Object;

public class OBJ_WarningSign extends Object {
    GamePanel gp;
    public final static String objName = "Danger sign";

    public OBJ_WarningSign(GamePanel gp, int col, int row) {
        super(gp, col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        lightRadius = 300;
        collision = true;
        getImage();
        setAction();

        solidArea.x = 6;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {

        down1 = setup("tiles/exterior/danger", gp.tileSize, gp.tileSize);


    }

    public void setAction() {

    }

    public void update() {

    }
}
