package object.exterior.toilets;

import main.GamePanel;
import object.Object;

public class OBJ_Toilet2 extends Object {
    GamePanel gp;
    public final static String objName = "Toilet2";



    public OBJ_Toilet2(GamePanel gp, int col , int row) {
        super(gp,col,row);
        this.gp = gp;
        type = typeObstacle;
        name = objName;
        solidArea.x = 18;
        solidArea.y = 34;
        solidArea.width = 38;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        int height = gp.tileSize*2;
        int width = gp.tileSize*2;
        image = setup("tiles/exterior/toilet2", width, height);
        down1 = image;
        collision = true;
        setDialogue();
    }


    public void setDialogue(){
        dialogues[0][0] = "Fuck! This stinks!";


    }
    public void interact() {
        startDialogue(this,0);

    }
}
