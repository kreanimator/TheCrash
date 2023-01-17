package object.trees;


import entity.Entity;
import entity.NPC;
import main.GamePanel;



public class OBJ_Tree1 extends NPC {
    GamePanel gp;
    public static final String objName = "Tree1";


    public OBJ_Tree1(GamePanel gp, int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        name = objName;
        speed = 0;
        direction = "down";
        type = typeObstacle;
        collision = true;

        getImage();
        setAction();

        solidArea.x = 36;
        solidArea.y = gp.tileSize;
        solidArea.width = 24;
        solidArea.height = gp.tileSize+24;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public void getImage() {
        int width= gp.tileSize *2;
        int height = gp.tileSize * 3;

        down1 = setup("tiles/trees/tree1/1",width,height );
        down2 = setup("tiles/trees/tree1/2",width,height );
        down3 = setup("tiles/trees/tree1/3",width,height );
        up1 = setup("tiles/trees/tree1/4",width,height );
        up2= setup("tiles/trees/tree1/5",width,height );
        up3 = setup("tiles/trees/tree1/6",width,height );
        left1 = setup("tiles/trees/tree1/7",width,height );
        left2 = setup("tiles/trees/tree1/8",width,height );
        left3 = setup("tiles/trees/tree1/9",width,height );
        right1 = setup("tiles/trees/tree1/10",width,height );
        right2 = setup("tiles/trees/tree1/11",width,height );
        right3 = setup("tiles/trees/tree1/12",width,height );
    }
    public void interact(){
        gp.player.attackCanceled = false;
        gp.player.shotCanceled = false;
    }

}
