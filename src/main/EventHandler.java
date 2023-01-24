package main;

import data.Progress;
import entity.Entity;
import tiles.TileManager;
import tiles.Tiles;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    EventRect[][][] eventRect;
    Entity gameMaster;
    int previousEventX,previousEventY;
    boolean canTouchEvent = true;
    int tempMap,tempCol,tempRow;


    public EventHandler(GamePanel gp) {
        this.gp = gp;
        gameMaster = new Entity(gp);
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        int map = 0;
        int col = 0;
        int row = 0;

        while (map < gp.maxMap && col<gp.maxWorldCol && row < gp.maxWorldRow){
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 20;
            eventRect[map][col][row].height = 20;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if (col == gp.maxWorldCol){
                col =0;
                row++;
                if(row == gp.maxWorldRow){
                    row = 0;
                    map ++;
                }
            }
        }
        setDialogue();

    }
    public void setDialogue(){
        gameMaster.dialogues[0][0] =  "You got toxic damage";
        gameMaster.dialogues[1][0] =  "Your progress has been saved!";
    }

    public void checkEvent() {

        //Check if the player 1 tile away from the event tile
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);

        int distance = Math.max(xDistance,yDistance);


        //TOXIC DAMAGE
        if(distance > gp.tileSize){
            canTouchEvent =true;
        }
        if(canTouchEvent) {
            //ROOFS
            if (hit(0,33, 60, "any")) {gp.roofDrawing = false;}
            if (hit(0,33, 61, "any")) {gp.roofDrawing = true;}
            if (hit(0,31, 82, "any")) {gp.roofDrawing = false;}
            if (hit(0,31, 81, "any")) {gp.roofDrawing = true;}
            if (hit(0,60, 28, "any")) {gp.roofDrawing = false;}
            if (hit(0,60, 29, "any")) {gp.roofDrawing = true;}
            if (hit(0,48, 15, "any")) {gp.roofDrawing = false;}
            if (hit(0,48, 16, "any")) {gp.roofDrawing = true;}
            if (hit(0,76, 15, "any")) {gp.roofDrawing = false;}
            if (hit(0,76, 16, "any")) {gp.roofDrawing = true;}
            if (hit(0,79, 38, "any")) {gp.roofDrawing = false;}
            if (hit(0,79, 39, "any")) {gp.roofDrawing = true;}




             if (hit(0,36, 8, "any")) {transition(1,39,89,gp.cave);gp.stopMusic();gp.playMusic(22);}

            else if (hit(1, 39, 89, "any")) {transition(0,36,8,gp.outside);gp.stopMusic();gp.playMusic(0);}
            else if (hit(1, 91, 48, "any")) {transition(2,1,46,gp.bunker);gp.stopMusic();gp.playMusic(27);}
            else if (hit(2, 1, 46, "any")) {transition(1,91,48,gp.cave);gp.stopMusic();gp.playMusic(22);}
            else if (hit(3, 31, 46, "any")) {slimeBoss();}


        }

    }

    private void transition(int map,int col, int row,int area ) {
        gp.gameState = gp.transitionState;
        gp.nextArea = area;
        tempMap = map;
        tempCol = col;
        tempRow = row;
        canTouchEvent = false;

    }
    public void savePoint(int gameState){
        if(gp.keyH.ePressed){
            gp.gameState = gameState;
            gp.player.attackCanceled = true;
            gameMaster.startDialogue(gameMaster,1);
            gp.player.life = gp.player.maxHP;
            //gp.aSetter.setEnemy();
            gp.saveLoad.save();
            }
    }

    public void toxicDamage(int gameState){
        gp.gameState = gameState;
        gameMaster.startDialogue(gameMaster,0);
        gp.player.life -=1;
        canTouchEvent = false;


    }

    public boolean hit(int map, int col, int row, String reqDirection) {
        boolean hit = false;
        if(map == gp.currentMap) {
            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventRect[map][col][row])) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;

                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }

        return hit;

    }
    public void slimeBoss(){
        if(!gp.bossBattleOn && !Progress.slimeBossDefeated){
            gp.gameState = gp.cutSceneState;
            gp.cutSceneManager.sceneNum = gp.cutSceneManager.slimeBoss;
        }

    }
}
