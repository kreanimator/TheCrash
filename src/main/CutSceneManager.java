package main;

import enemies.SlimeBoss;
import entity.PlayerTemplate;
import object.exterior.doors.OBJ_IronDoor;

import java.awt.*;
import java.util.Objects;


public class CutSceneManager {
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;

    //SCENE NUMBER
    public final int NA = 0;
    public final int slimeBoss = 1;

    public CutSceneManager(GamePanel gp) {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        switch (sceneNum) {
            case slimeBoss -> scene_SlimeBoss();
        }

    }

    private void scene_SlimeBoss() {
        if (scenePhase == 0) {
            gp.bossBattleOn = true;

            //SHUT THE DOOR

            for (int i = 0; i < gp.obj[1].length; i++) {
                if (gp.obj[gp.currentMap][i] == null) {
                    gp.obj[gp.currentMap][i] = new OBJ_IronDoor(gp,30,46);
                    gp.obj[gp.currentMap][i].temp = true;
                    gp.playSE(28);
                    break;
                }
            }
            //Search a vacant slot to place a player template image

            for (int i = 0; i < gp.npc[1].length; i++) {
                if (gp.npc[gp.currentMap][i] == null) {
                    gp.npc[gp.currentMap][i] = new PlayerTemplate(gp);
                    gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
                    gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
                    gp.npc[gp.currentMap][i].direction = gp.player.direction;
                    break;
                }
            }
            gp.player.drawing = false;
            scenePhase++;
        }
        if (scenePhase == 1) {
            gp.player.worldX += 2;
            if (gp.player.worldX > gp.tileSize * 48) {
                scenePhase++;
            }
        }
        if (scenePhase == 2) {
            //Search the boss
            for (int i = 0; i < gp.enemy[1].length; i++) {
                if (gp.enemy[gp.currentMap][i] != null &&
                       gp.enemy[gp.currentMap][i].name.equals(SlimeBoss.enName)) {
                    gp.enemy[gp.currentMap][i].sleep = false;
                    gp.ui.npc = gp.enemy[gp.currentMap][i];
                    scenePhase++;
                    break;
                }
            }
        }
        if (scenePhase == 3) {
            //The boss speaks
            gp.ui.drawDialogueScreen();
        }
        if (scenePhase == 4) {
            //Return to the player
            for (int i = 0; i < gp.npc[1].length; i++) {
                if (gp.npc[gp.currentMap][i] != null && Objects.equals(gp.npc[gp.currentMap][i].name, PlayerTemplate.npcName)) {
                    gp.player.worldX = gp.npc[gp.currentMap][i].worldX;
                    gp.player.worldY = gp.npc[gp.currentMap][i].worldY;

                    gp.npc[gp.currentMap][i] = null;
                    break;

                }
            }
            gp.player.drawing = true;

            //RESET SCENE NUM & PHASE

            sceneNum = NA;
            scenePhase = 0;
            gp.gameState = gp.playState;
            gp.stopMusic();
            gp.playMusic(30);
        }
    }
}
