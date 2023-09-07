package object.exterior;

import entity.Entity;
import main.GamePanel;
import object.Object;
import object.misc.OBJ_Tent;

public class OBJ_Generator extends Object {
    GamePanel gp;
    public final static String objName = "Generator";



    public OBJ_Generator(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        int height = gp.tileSize*2;
        int width = gp.tileSize+12;
        image = setup("tiles/exterior/generator", width, height);

        down1 = image;
        collision = true;
        solidArea.x = 16;
        solidArea.y = 40;
        solidArea.width = 30;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }



}
