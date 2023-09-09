package entity;

import main.GamePanel;

public class LightSource extends Entity{

    public LightSource(){

    }
    public LightSource(GamePanel gp,int col, int row){
        this.gp = gp;
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

    }
}
