package object.interior.tables;

import main.GamePanel;
import object.Object;

public class OBJ_Table1 extends Object {
    GamePanel gp;
    public final static String objName = "Table1";

    public OBJ_Table1(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;
        getImage();


        solidArea.x = 0;
        solidArea.y = 14;
        solidArea.width = 40;
        solidArea.height = 12;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {
        int width = 40;
        int height = 40;

        down1 = setup("tiles/interior/tables/table1", width, height);
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }
}
