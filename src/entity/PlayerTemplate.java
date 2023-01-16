package entity;

import main.GamePanel;

public class PlayerTemplate extends Entity{
    public static final String npcName = "Template";
    public PlayerTemplate(GamePanel gp) {
        super(gp);
        name = npcName;
        getImage();
    }
    public void getImage() {
        up1 = setup("player/up1", gp.tileSize, gp.tileSize);
        up2 = setup("player/up2", gp.tileSize, gp.tileSize);
        up3 = setup("player/up3", gp.tileSize, gp.tileSize);
        down1 = setup("player/down1", gp.tileSize, gp.tileSize);
        down2 = setup("player/down2", gp.tileSize, gp.tileSize);
        down3 = setup("player/down3", gp.tileSize, gp.tileSize);
        left1 = setup("player/left1", gp.tileSize, gp.tileSize);
        left2 = setup("player/left2", gp.tileSize, gp.tileSize);
        left3 = setup("player/left3", gp.tileSize, gp.tileSize);
        right1 = setup("player/right1", gp.tileSize, gp.tileSize);
        right2 = setup("player/right2", gp.tileSize, gp.tileSize);
        right3 = setup("player/right3", gp.tileSize, gp.tileSize);
    }
}
