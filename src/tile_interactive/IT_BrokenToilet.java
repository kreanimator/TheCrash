package tile_interactive;

import main.GamePanel;

public class IT_BrokenToilet extends InteractiveTile{
    public static final String itName = "Broken Toilet";

    public IT_BrokenToilet(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;
        name = itName;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        down1 = (setup("objects/interactiveobjects/toilet2", gp.tileSize/2, gp.tileSize/2));
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 0;
        solidArea.height = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        destructible = false;
    }

    public void playSE() {

    }

    public InteractiveTile getDestroyedForm() {
        InteractiveTile tile = null;
        return tile;

    }
}
