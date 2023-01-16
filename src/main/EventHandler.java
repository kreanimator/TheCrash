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
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
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

//            if (hit(0,29, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,31, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,32, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,31, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 56, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83,55, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,84, 55, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,85, 55, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 53, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,84, 53, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 52, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 51, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 50, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 47, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 46, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 46, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 45, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 38, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 38, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 37, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 37, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 37, "any")){toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 37, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 36, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 35, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 35, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 35, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 35, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 34, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,73, 34, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,72, 34, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,71, 34, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,71, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,70, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,69, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,68, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,67, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,67, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,66, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,65, 32, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,65, 31, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,66, 31, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,32, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 34, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 33, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,28, 32, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,27, 32, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,26, 32, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,28, 31, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,26, 30, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 30, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 30, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,26, 29, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,25, 29, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,24, 29, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,23, 29, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,23, 28, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,26, 46, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,26, 47, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,25, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,26, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,27, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,28, 47, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 47, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 47, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,28, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,32, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,33, 48, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,32, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,31, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,30, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,28, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,27, 49, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,27, 50, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,29, 50, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 78, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 78, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 78, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 78, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,73, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 79, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,73, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 80, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,73, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 81, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,83, 82, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,82, 83, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 84, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 85, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 85, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 85, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 85, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,80, 85, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,81, 85, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,74, 86, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 86, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,76, 86, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,77, 86, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,78, 86, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,79, 86, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
//            if (hit(0,75, 87, "any")) {toxicDamage(gp.dialogState);gp.playSE(17);}
           // if (hit(0,17,68,"any")){savePoint(gp.dialogState);}
             if (hit(0,85, 16, "any")) {transition(1,1,47,gp.cave);gp.stopMusic();gp.playMusic(22);}
            else if (hit(1, 1, 47, "any")) {transition(0,85,16,gp.outside);gp.stopMusic();gp.playMusic(0);}
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
