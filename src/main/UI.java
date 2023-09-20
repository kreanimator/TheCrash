package main;

import entity.Entity;
import entity.Player;
import object.misc.OBJ_HP;
import object.misc.OBJ_Money;
import object.weapon.OBJ_Ammo_Pistol;
import object.weapon.OBJ_Ammo_Shotgun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    public Font myFont;
    BufferedImage hpfull, hphalf, hpblank, pistolAmmo, shotgunAmmo, coin,background;
    BufferedImage frame1;
    BufferedImage addiction, hangover, speed, defense;

    public String currentDialogue = "";
    public String currentQuest = "";

    public boolean messageOn = false;
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();

    public boolean gameFinished = false;
    public int commandNumber = 0;
    public int titleScreenState = 0; // 0: first screen 1: second screen
    public int subState = 0;
    public int playerSlotCol = 0;
    public int playerSlotRow = 0;
    public int slotNpcCol = 0;
    public int slotNpcRow = 0;
    int counter = 0;
    public Entity npc;
    int charIndex = 0;
    String combinedText = "";

    public UI(GamePanel gp) {
        this.gp = gp;
        InputStream is = getClass().getResourceAsStream("/resources/font/GravityBold8.ttf");
        try {
            assert is != null;
            myFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        //CREATE HUD OBJECT

        Entity hpbar = new OBJ_HP(gp);
        hpfull = hpbar.image;
        hphalf = hpbar.image2;
        hpblank = hpbar.image3;



        Entity pistol = new OBJ_Ammo_Pistol(gp);
        pistolAmmo = pistol.down1;
        Entity shotgun = new OBJ_Ammo_Shotgun(gp);
        shotgunAmmo = shotgun.down1;
        Entity coins = new OBJ_Money(gp);
        coin = coins.down1;
    }

    public void addMessage(String text) {
        message.add(text);
        messageCounter.add(0);
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(myFont);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setColor(new Color(201, 236, 133));
        //TITLE STATE
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        //PLAY STATE
        if (gp.gameState == gp.playState) {
            drawplayerlife();
            drawEnemyLife();
            drawPlayerAmmo();
            drawInformationScreen();
            drawMessage();
            drawStatus();



        }
        //PAUSESTATE
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();

        }
        //DIALOGSTATE
        if (gp.gameState == gp.dialogState) {
            drawDialogueScreen();
        }
        //CHARACTER STATE
        if (gp.gameState == gp.charState) {
            drawCharScreen();
            drawInventoryScreen(gp.player, true);
        }
        //OPTIONS STATE
        if (gp.gameState == gp.optionsState) {
            drawOptionsScreen();
        }
        //GAME OVER STATE
        if (gp.gameState == gp.gameOverState) {
            drawGameOverScreen();
        }
        //TRANSITION STATE
        if (gp.gameState == gp.transitionState) {
            drawTransitionScreen();
        }
        //TRADE STATE
        if (gp.gameState == gp.tradeState) {
            drawTradeScreen();
        }
        //SLEEP STATE
        if (gp.gameState == gp.sleepState) {
            drawSleepScreen();
        }
        //QUEST STATE
        if (gp.gameState == gp.questState) {
            drawQuestScreen(gp.player, true);
        }
    }



    private void drawInventoryScreen(Entity entity, boolean cursor) {
        int frameX = 0;
        int frameY = 0;
        int frameWidth = 0;
        int frameHeight = 0;
        int slotCol = 0;
        int slotRow = 0;
        //FRAME
        if (entity == gp.player) {
            frameX = gp.tileSize * 12;
            frameY = gp.tileSize;
            frameWidth = gp.tileSize * 6;
            frameHeight = gp.tileSize * 5;
            slotCol = playerSlotCol;
            slotRow = playerSlotRow;

        } else {
            frameX = gp.tileSize * 2;
            frameY = gp.tileSize;
            frameWidth = gp.tileSize * 6;
            frameHeight = gp.tileSize * 5;
            slotCol = slotNpcCol;
            slotRow = slotNpcRow;
        }
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOT

        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize + 3;

        //DRAW PLAYERS ITEMS

        for (int i = 0; i < Entity.inventory.size(); i++) {

            //EQUIP CURSOR

            if (Entity.inventory.get(i) == entity.currentWeapon || Entity.inventory.get(i) == entity.currentArmor
                    || Entity.inventory.get(i) == entity.currentLight || Entity.inventory.get(i) == entity.currentShield) {
                g2.setColor(new Color(248, 183, 27));
                g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            }
            g2.drawImage(Entity.inventory.get(i).down1, slotX, slotY,gp.tileSize,gp.tileSize, null);

            //DISPLAY THE AMOUNT

            if (entity == gp.player && Entity.inventory.get(i).amount > 1) {
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 8f));
                int amountX;
                int amountY;
                String s = "" + Entity.inventory.get(i).amount;
                amountX = getXforAlignToRight(s, slotX + 44);
                amountY = slotY + gp.tileSize;
                //SHADOW
                g2.setColor(new Color(60, 60, 60));
                g2.drawString(s, amountX, amountY);
                //NUMBER
                g2.setColor(Color.WHITE);
                g2.drawString(s, amountX - 3, amountY - 3);
            }
            slotX += slotSize;

            if (i == 4 || i == 9 || i == 14) {
                slotX = slotXstart;
                slotY += slotSize;
            }
        }

        //CURSOR
        if (cursor) {
            int cursorX = slotXstart + (slotSize * slotCol);
            int cursorY = slotYstart + (slotSize * slotRow);
            int cursorWidth = gp.tileSize;
            int cursorHeight = gp.tileSize;

            //DRAWCURSOR
//            g2.setColor(new Color(201, 236, 133));
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
//            cursor1 = setup("ui/inventory/Frame_03",cursorWidth,cursorHeight);
//            g2.drawImage(cursor1,cursorX,cursorY,null);
            g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

            //DESCRIPTION FRAME

            int dFramex = frameX;
            int dFrameY = frameY + frameHeight;
            int dFrameWidth = frameWidth;
            int dFrameHeight = gp.tileSize * 5;


            //DRAW DESCRIPTION TEXT

            int textX = dFramex + 20;
            int textY = dFrameY + gp.tileSize;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10f));

            int itemIndex = getItemIndex(slotCol, slotRow);

            if (itemIndex < Entity.inventory.size()) {
                drawSubWindow(dFramex, dFrameY, dFrameWidth, dFrameHeight);
                for (String line : Entity.inventory.get(itemIndex).description.split("\n")) {

                    g2.drawString(line, textX, textY);
                    textY += 32;
                }

            }
        }


    }

    public int getItemIndex(int slotCol, int slotRow) {
        int itemIndex = slotCol + (slotRow * 5);

        return itemIndex;

    }
    public int getQuestIndex(int slotCol, int slotRow) {
        int questIndex = slotCol + (slotRow * 5);

        return questIndex;

    }


    private void drawplayerlife() {

        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;
        //DRAW BLANK HUD
        while (i < gp.player.maxHP / 2) {
            g2.drawImage(hpblank, x, y, null);
            i++;
            x += gp.tileSize - 10;
        }

        //RESET
        x = gp.tileSize / 2;
        i = 0;
        //DRAW CURRENT LIFE
        while (i < gp.player.life) {
            g2.drawImage(hphalf, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(hpfull, x, y, null);
            }
            i++;
            x += gp.tileSize - 10;
        }
    }
    public void drawEnemyLife(){
        //Enemy HP bar

        for(int i = 0; i < gp.enemy[1].length; i++){
            Entity enemy = gp.enemy[gp.currentMap][i];
            if(enemy != null && enemy.inCamera()){
                if ( enemy.hpBarOn && !enemy.boss) {

                    double oneScale = (double) gp.tileSize / enemy.maxHP;
                    double hpBarValue = oneScale * enemy.life;
                    g2.setColor(new Color(35, 35, 35));
                    g2.fillRect(enemy.getScreenX()- 1, enemy.getScreenY() - 16, gp.tileSize + 2, 12);
                    g2.setColor(new Color(255, 0, 30));
                    g2.fillRect(enemy.getScreenX(), enemy.getScreenY() - 15, (int) hpBarValue, 10);
                    enemy.hpBarCounter++;
                    if (enemy.hpBarCounter > 600) {
                        enemy.hpBarCounter = 0;
                        enemy.hpBarOn = false;
                    }
                } else if (enemy.boss) {
                    double oneScale = (double) gp.tileSize *8/ enemy.maxHP;
                    double hpBarValue = oneScale * enemy.life;

                    int x = gp.screenWidth/2 - gp.tileSize*4;
                    int y = gp.tileSize * 10;
                    g2.setColor(Color.WHITE);
                    g2.drawString(enemy.name,x+4, y -10);
                    g2.setColor(new Color(35, 35, 35));
                    g2.fillRect(x- 1, y - 1, gp.tileSize * 8 + 2, 22);
                    g2.setColor(new Color(255, 0, 30));
                    g2.fillRect(x, y, (int) hpBarValue, 20);
                    g2.setFont(g2.getFont().deriveFont(Font.BOLD,20f));


                }
            }
        }

    }

    public void drawPlayerAmmo() {
        //DRAW AMMO

        int x = gp.tileSize / 2;
        int y = gp.tileSize * 2;
        String shotgunammo = " = " + gp.player.shotgunAmmo;
        String pistolammo = " = " + gp.player.pistolAmmo;

        if (gp.player.currentWeapon.type == gp.player.typePistol) {
            g2.drawImage(pistolAmmo, 10, y - 30, gp.tileSize, gp.tileSize, null);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20f));
            g2.setColor(Color.WHITE);
            g2.drawString(pistolammo, x * 2, y);
        }
        if (gp.player.currentWeapon.type == gp.player.typeShotgun) {
            g2.drawImage(shotgunAmmo, 10, y - 30, gp.tileSize, gp.tileSize, null);
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20f));
            g2.drawString(shotgunammo, x * 2, y);

        }
    }

    private void drawMessage() {
        int messageX = gp.tileSize;
        int messageY = (gp.tileSize * 12)-24;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 8f));
        for (int i = 0; i < message.size(); i++) {
            if (message.get(i) != null) {
                g2.setColor(Color.BLACK);
                g2.drawString(message.get(i), messageX + 2, messageY + 2);
                g2.setColor(new Color(201, 236, 133));
                //g2.setColor(Color.WHITE);
                g2.drawString(message.get(i), messageX, messageY);
                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY += 24;

                if (messageCounter.get(i) > 180) {
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
    }


    private void drawTitleScreen() {
        try{
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/background.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
        g2.drawImage(background,0,0,gp.screenWidth,gp.screenHeight,null);
        if (titleScreenState == 0) {
            //TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80f));
            String text = "THE CRASH";
            int x = getXforCenteredText(text);

            int y = gp.screenHeight / 3;
            //SHADOW
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //MAIN COLOR
            g2.setColor(new Color(201, 236, 133));
//            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);

            //IMAGE

            //x = gp.screenWidth / 2 - (gp.tileSize / 2);
            y += gp.tileSize * 2;
            //g2.drawImage(gp.player.down1, x, y, gp.tileSize, gp.tileSize, null);

            //MENU
            //NEW GAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40f));
            text = "NEW GAME";
            x = getXforCenteredText(text);

            y += gp.tileSize * 2;

            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //MAIN COLOR
//            g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.drawString(text, x, y);
            if (commandNumber == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            //LOAD GAME
            text = "LOAD GAME";
            x = getXforCenteredText(text);

            y += gp.tileSize + gp.tileSize / 2;

            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //MAIN COLOR
            g2.setColor(new Color(201, 236, 133));
            //g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);
            if (commandNumber == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            //EXIT
            text = "EXIT";
            x = getXforCenteredText(text);

            y += gp.tileSize + gp.tileSize / 2;

            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //MAIN COLOR
            //g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.drawString(text, x, y);
            if (commandNumber == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        } else if (titleScreenState == 1) {

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40f));
            String text = "Select your class: ";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            g2.setColor(new Color(201, 236, 133));
            //g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);

            //GUNSLINGER
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30f));
            text = "GUNSLINGER";
            x = getXforCenteredText(text);
            y += gp.tileSize * 2;
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.drawString(text, x, y);
            if (commandNumber == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            //SURVIVOR
            text = "SURVIVOR";
            x = getXforCenteredText(text);
            y += gp.tileSize * 2;
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.drawString(text, x, y);
            if (commandNumber == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            //HARVESTER

            text = "HARVESTER";
            x = getXforCenteredText(text);
            y += gp.tileSize * 2;
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.drawString(text, x, y);
            if (commandNumber == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
            //ASSASIN

            text = "BACK";
            x = getXforCenteredText(text);
            y += gp.tileSize * 2;
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(text, x + 5, y + 5);
            //g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.drawString(text, x, y);
            if (commandNumber == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }
    }

    public void drawPauseScreen() {

        String text = "PAUSED";
        int x = getXforCenteredText(text);

        int y = gp.screenHeight / 2;

        g2.setFont(g2.getFont().deriveFont(40f));
        g2.drawString(text, x - gp.tileSize * 2, y);

    }

    public void drawDialogueScreen() {
        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 6);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10f));
        x += gp.tileSize;
        y += gp.tileSize;

        if(npc.dialogues[npc.dialogueSet][npc.dialogueIndex] != null){
  //          currentDialogue = npc.dialogues[npc.dialogueSet][npc.dialogueIndex];
            char[] characters = npc.dialogues[npc.dialogueSet][npc.dialogueIndex].toCharArray();

            if(charIndex < characters.length){
                String s = String.valueOf(characters[charIndex]);
                combinedText = combinedText + s;
                currentDialogue = combinedText;
                charIndex++;
            }
            if(gp.keyH.ePressed){
                charIndex = 0;
                combinedText = "";
                if(gp.gameState == gp.dialogState || gp.gameState == gp.cutSceneState){
                    npc.dialogueIndex++;
                    gp.keyH.ePressed = false;
                }
            }
        }
        else {
            npc.dialogueIndex = 0;
            if(gp.gameState == gp.dialogState){
                gp.gameState = gp.playState;
            }
            if(gp.gameState == gp.cutSceneState){
                gp.cutSceneManager.scenePhase++;
            }
        }

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }

    }
    private void drawInformationScreen(){
        final int frameX = 10;
        final int frameY = gp.tileSize * 11 -10;
        final int frameWidth = gp.tileSize * 5;
        final int frameHeight = gp.tileSize * 3;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        int frame1X = gp.tileSize + 20;
        int frame1Y = (gp.tileSize * 10)+10;
        int frame1Width = gp.tileSize/2;
        int frame1Height = gp.tileSize/2;

        //DRAWSTATUSFRAME
        //1
        g2.setColor(new Color(201, 236, 133));
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        //2
        frame1X = frame1X + frame1Width+3;
        g2.setColor(new Color(201, 236, 133));
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        g2.setColor(c);
        g2.fillRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        //3
        frame1X = frame1X + frame1Width+3;
        g2.setColor(new Color(201, 236, 133));
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        g2.setColor(c);
        g2.fillRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        //4
        frame1X = frame1X + frame1Width+3;
        g2.setColor(new Color(201, 236, 133));
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);
        g2.setColor(c);
        g2.fillRoundRect(frame1X, frame1Y, frame1Width, frame1Height, 10, 10);



    }

    private void drawCharScreen() {
        final int frameX = gp.tileSize * 2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize * 7;
        final int frameHeight = gp.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //TEXT

//        g2.setColor(Color.WHITE);
        g2.setColor(new Color(201, 236, 133));
        g2.setFont(g2.getFont().deriveFont(20f));
        int textX = frameX + gp.tileSize / 2;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 38;

        //NAMES

        g2.drawString("Level: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Life: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Strength: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Dexterity: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Attack: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Defense: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Exp: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Next level: ", textX, textY);
        textY += lineHeight;
        g2.drawString("Money: ", textX, textY);
        textY += lineHeight + gp.tileSize / 2;
        g2.drawString("Weapon: ", textX, textY);
        textY += lineHeight + 10;
        g2.drawString("Armor: ", textX, textY);
        textY += lineHeight;

        //VALUES

        int tailX = (frameX + frameWidth) - gp.tileSize / 2;
        textY = frameY + gp.tileSize;

        String value;
        value = String.valueOf(gp.player.level);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.life + "/" + gp.player.maxHP);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.strength);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.dexterity);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.attack);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.defense);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.exp);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.nextLevel);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        value = String.valueOf(gp.player.coin);
        textX = getXforAlignToRight(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;


        g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY - 15,gp.tileSize,gp.tileSize, null);
        textY += gp.tileSize;
        g2.drawImage(gp.player.currentArmor.down1, tailX - gp.tileSize, textY - 15,gp.tileSize,gp.tileSize, null);
    }

    private void drawGameOverScreen() {
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        int x;
        int y;
        String text;

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80f));

        text = "YOU DIED";
        //SHADOW
        g2.setColor(Color.DARK_GRAY);
        x = getXforCenteredText(text);
        y = gp.tileSize * 4;
        g2.drawString(text, x, y);
        //MAIN
        g2.setColor(Color.RED);
        g2.drawString(text, x - 4, y - 4);
        g2.setColor(Color.WHITE);

        //RETRY
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18f));
        text = "Retry";
        x = getXforCenteredText(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if (commandNumber == 0) {
            g2.drawString(">", x - 25, y);
        }


        //BACK TO THE MENU
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18f));
        text = "Quit";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text, x, y);
        if (commandNumber == 1) {
            g2.drawString(">", x - 25, y);
        }

    }

    private void drawOptionsScreen() {
        //g2.setColor(Color.WHITE);
        g2.setColor(new Color(201, 236, 133));
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20f));

        //SUB WINDOW
        int frameX = gp.tileSize * 6;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize * 8;
        int frameHeight = gp.tileSize * 10;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        switch (subState) {
            case 0:
                options_top(frameX, frameY);
                break;
            case 1:
                options_fullScreenNotification(frameX, frameY);
                break;
            case 2:
                options_controls(frameX, frameY);
                break;
            case 3:
                options_exitConfirmation(frameX, frameY);
                break;
        }
        gp.keyH.ePressed = false;
    }
    private void drawQuestScreen(Entity entity, boolean cursor) {
        int frameX = 0;
        int frameY = 0;
        int frameWidth = 0;
        int frameHeight = 0;
        int slotCol = 0;
        int slotRow = 0;


        //FRAME
        if (entity == gp.player) {
            frameX = gp.tileSize * 3;
            frameY = gp.tileSize * 2;
            frameWidth = gp.tileSize * 8;
            frameHeight = gp.tileSize * 8;
            slotCol = playerSlotCol;
            slotRow = playerSlotRow;

        } else {
            frameX = gp.tileSize * 2;
            frameY = gp.tileSize;
            frameWidth = gp.tileSize * 6;
            frameHeight = gp.tileSize * 5;
            slotCol = slotNpcCol;
            slotRow = slotNpcRow;
        }
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //g2.setColor(Color.WHITE);
        g2.setColor(new Color(201, 236, 133));
        g2.setFont(g2.getFont().deriveFont(20f));
        int headerX = frameX + gp.tileSize * 2;
        int headerY = frameY + gp.tileSize;
        final int lineHeight = 38;

        //NAMES

        g2.drawString("QUESTBOOK", headerX, headerY);

        //SLOT

        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + gp.tileSize * 2;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize + 3;

        //DRAW PLAYERS QUESTS

        for (int i = 0; i < Entity.quest.size(); i++) {

            slotX += slotSize;

            if (i == 4 || i == 9 || i == 14) {
                slotX = slotXstart;
                slotY += slotSize;
            }
        }

        //CURSOR
        if (cursor) {
            int cursorX = slotXstart + (slotSize * slotCol);
            int cursorY = slotYstart + (slotSize * slotRow);
            int cursorWidth = frameWidth - 40;
            int cursorHeight = gp.tileSize;

            //DRAWCURSOR
//            g2.setColor(Color.WHITE);
            g2.setColor(new Color(201, 236, 133));
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
            for (int i = 0; i < entity.quest.size(); i++) {
                g2.drawString(entity.quest.get(i).name,slotX, slotY+30);
            }

            //DESCRIPTION FRAME

            int dFramex = frameX + frameWidth;
            int dFrameHeight = gp.tileSize * 8;


            //DRAW DESCRIPTION TEXT

            int textX = dFramex + 20;
            int textY = frameY + gp.tileSize;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10f));

            int questIndex = getQuestIndex(slotCol, slotRow);

            if (questIndex < Entity.quest.size()) {
                drawSubWindow(dFramex, frameY, frameWidth, dFrameHeight);
                for (int i = 0; i < Entity.quest.size(); i++) {
                    g2.drawImage(Entity.quest.get(i).down1,textX,frameY+gp.tileSize/2,gp.tileSize,gp.tileSize,null);
                }
                for (String line : Entity.quest.get(questIndex).description.split("\n")) {


                    g2.drawString(line, textX+gp.tileSize, textY);
                    textY += 32;
                }

            }
        }


    }
//    private void drawQuestScreen() {
//        g2.setColor(Color.WHITE);
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20f));
//
//        //SUB WINDOW
//        int frameX = gp.tileSize * 6;
//        int frameY = gp.tileSize;
//        int frameWidth = gp.tileSize * 8;
//        int frameHeight = gp.tileSize * 10;
//        int x = frameX + gp.tileSize * 2;
//        int y = frameY + gp.tileSize / 2;
//
//        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10f));
//
//        currentQuest = npc.quests[npc.questIndex];
//
//        if(npc.quests[npc.questIndex] != null){
//            g2.drawString(currentQuest, x, y);
//            y += 40;
//        }
//    }



    public void options_top(int frameX, int frameY) {

        int textX;
        int textY;

        //TITLE
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16f));

//        String text = "Options";
//
//        textX = getXforCenteredText(text);
//        textY = frameY + gp.tileSize;
//        g2.drawString(text, textX, textY);

        //SAVE GAME

        String text = "Save game";

        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        if (commandNumber == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                gp.eHandler.savePoint(gp.dialogState);
            }
        }

        //FULL SCREEN ON/OFF

        textX = frameX + gp.tileSize;
        textY += gp.tileSize + 15;
        g2.drawString("Full Screen ", textX, textY);
        if (commandNumber == 1) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                if (!gp.fullScreenOn) {
                    gp.fullScreenOn = true;
                } else {
                    gp.fullScreenOn = false;
                }
                subState = 1;
            }
        }

        //MUSIC
        textY += gp.tileSize + 15;
        g2.drawString("Music ", textX, textY);
        if (commandNumber == 2) {
            g2.drawString(">", textX - 25, textY);
        }


        //SE
        textY += gp.tileSize + 15;
        g2.drawString("SE ", textX, textY);
        if (commandNumber == 3) {
            g2.drawString(">", textX - 25, textY);
        }


        //CONTROLS

        textY += gp.tileSize + 15;
        g2.drawString("Controls ", textX, textY);
        if (commandNumber == 4) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                subState = 2;
                commandNumber = 0;
            }
        }


        //QUIT GAME

        textY += gp.tileSize + 15;
        g2.drawString("Quit ", textX, textY);
        if (commandNumber == 5) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                subState = 3;
                commandNumber = 0;
            }
        }


        //BACK

        textY += gp.tileSize + 15;
        g2.drawString("Back ", textX, textY);
        if (commandNumber == 6) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                gp.gameState = gp.playState;
                commandNumber = 0;
            }
        }

        //FULL SCREEN CHECKBOX
        textX = frameX + gp.tileSize * 5;
        textY = frameY + gp.tileSize * 2 - 5;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(textX, textY, gp.tileSize / 2, gp.tileSize / 2);
        if (gp.fullScreenOn) {
            g2.fillRect(textX, textY, gp.tileSize / 2, gp.tileSize / 2);
        }

        //MUSIC VOLUME

        textY += gp.tileSize + 15;
        g2.drawRect(textX, textY, 120, 24); //120/5 = 24
        int volumeWidth = 24 * gp.music.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        //SE VOLUME

        textY += gp.tileSize + 15;
        g2.drawRect(textX, textY, 120, 24); //120/5 = 24
        volumeWidth = 24 * gp.se.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        gp.config.saveConfig();

    }

    public void options_fullScreenNotification(int frameX, int frameY) {
        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize * 3;

        currentDialogue = "The change will be \n   affected after \n      restart.";
        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, textX, textY);
            textY += 40;
        }

        //BACK

        textY = frameY + gp.tileSize * 9;
        g2.drawString("Back", textX, textY);
        if (commandNumber == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                subState = 0;
            }
        }
    }

    public void options_controls(int frameX, int frameY) {

        int textX;
        int textY;

        String text = "Controls";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        textX = frameX + gp.tileSize;
        textY += gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14f));

        g2.drawString("Move", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Action/Attack", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Speak", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Character Screen", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Pause", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Options", textX, textY);
        textY += gp.tileSize;


        textX = frameX + gp.tileSize * 6;
        textY = frameY + gp.tileSize * 2;

        g2.drawString("WASD", textX, textY);
        textY += gp.tileSize;
        g2.drawString("E/Enter", textX, textY);
        textY += gp.tileSize;
        g2.drawString("E", textX, textY);
        textY += gp.tileSize;
        g2.drawString("C", textX, textY);
        textY += gp.tileSize;
        g2.drawString("P", textX, textY);
        textY += gp.tileSize;
        g2.drawString("ESC", textX, textY);
        textY += gp.tileSize;

        //BACK
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize * 9;
        g2.drawString("Back", textX, textY);
        if (commandNumber == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                subState = 0;
                commandNumber = 3;
            }
        }

    }

    private void options_exitConfirmation(int frameX, int frameY) {

        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize * 2;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16f));
        currentDialogue = "Are you sure \n   that you want \n    to quit?";
        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, textX, textY);
            textY += 40;
        }

        //YES

        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gp.tileSize * 3;
        g2.drawString(text, textX, textY);
        if (commandNumber == 0) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                subState = 0;
                gp.stopMusic();
                gp.gameState = gp.titleState;
                gp.resetGame(true);
            }
        }

        //NO

        text = "NO";
        textX = getXforCenteredText(text);
        textY += gp.tileSize;
        g2.drawString(text, textX, textY);
        if (commandNumber == 1) {
            g2.drawString(">", textX - 25, textY);
            if (gp.keyH.ePressed) {
                subState = 0;
                commandNumber = 4;
            }
        }


    }

    private void drawTransitionScreen() {
        counter++;
        g2.setColor(new Color(0, 0, 0, counter * 5));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        if (counter == 50) {
            counter = 0;
            gp.gameState = gp.playState;
            gp.currentMap = gp.eHandler.tempMap;
            gp.player.worldX = gp.tileSize * gp.eHandler.tempCol;
            gp.player.worldY = gp.tileSize * gp.eHandler.tempRow;
            gp.eHandler.previousEventX = gp.player.worldX;
            gp.eHandler.previousEventY = gp.player.worldY;
            gp.changeArea();
        }
    }

    private void drawTradeScreen() {
        switch (subState) {
            case 0 -> tradeSelect();
            case 1 -> tradeBuy();
            case 2 -> tradeSell();
        }
        gp.keyH.ePressed = false;
    }

    public void tradeSelect() {
        npc.dialogueSet = 0;
        drawDialogueScreen();

        //DRAW WINDOW

        int x = gp.tileSize * 15;
        int y = gp.tileSize * 6;
        int width = gp.tileSize * 3;
        int height = (int) (gp.tileSize * 3.5);
        drawSubWindow(x, y, width, height);

        //DRAW TEXTS

        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString("Buy", x, y);
        if (commandNumber == 0) {
            g2.drawString(">", x - 24, y);
            if (gp.keyH.ePressed) {
                subState = 1;
            }
        }
        y += gp.tileSize;
        g2.drawString("Sell", x, y);
        if (commandNumber == 1) {
            g2.drawString(">", x - 24, y);
            if (gp.keyH.ePressed) {
                subState = 2;
            }
        }
        y += gp.tileSize;
        g2.drawString("Leave", x, y);
        if (commandNumber == 2) {
            g2.drawString(">", x - 24, y);
            if (gp.keyH.ePressed) {
                commandNumber = 0;
                gp.gameState = gp.dialogState;
                npc.startDialogue(npc,1);
            }
        }

    }

    public void tradeBuy() {

        //DRAW PLAYER INVENTORY
        drawInventoryScreen(gp.player, false);
        //DRAW NPC INVENTORY
        drawInventoryScreen(npc, true);

        // DRAW HINT WINDOW

        int x = gp.tileSize * 2;
        int y = gp.tileSize * 11;
        int width = gp.tileSize * 6;
        int height = gp.tileSize * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] for back", x + 24, y + 60);

        // DRAW PLAYER COINS WINDOW

        x = gp.tileSize * 12;

        drawSubWindow(x, y, width, height);
        g2.drawString("Your coins: " + gp.player.coin, x + 24, y + 60);

        //DRAW PRICE WINDOW

        int itemIndex = getItemIndex(slotNpcCol, slotNpcRow);
        if (itemIndex < npc.inventory.size()) {
            x = (int) (gp.tileSize * 5.5);
            y = (int) (gp.tileSize * 5.5);
            width = (int) (gp.tileSize * 2.5);
            height = gp.tileSize;
            drawSubWindow(x, y, width, height);
            g2.drawImage(coin, x + 10, y + 10, 32, 32, null);
            int price = npc.inventory.get(itemIndex).price;
            String text = "" + price;
            x = getXforAlignToRight(text, gp.tileSize * 8);
            g2.drawString(text, x - 20, y + 32);

            //BUY
            if (gp.keyH.ePressed) {
                if (npc.inventory.get(itemIndex).price > gp.player.coin) {
                    subState = 0;
                    npc.startDialogue(npc,2);
                    drawDialogueScreen();
                } else {
                    if (gp.player.canObtainItem(npc.inventory.get(itemIndex))) {
                        gp.player.coin -= npc.inventory.get(itemIndex).price;
                    } else {
                        subState = 0;
                        npc.startDialogue(npc,3);
                    }
                }

            }

        }

    }

    public void tradeSell() {
        drawInventoryScreen(gp.player, true);
        int x = gp.tileSize * 2;
        int y = gp.tileSize * 11;
        int width = gp.tileSize * 6;
        int height = gp.tileSize * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] for back", x + 24, y + 60);

        // DRAW PLAYER COINS WINDOW

        x = gp.tileSize * 12;

        drawSubWindow(x, y, width, height);
        g2.drawString("Your coins: " + gp.player.coin, x + 24, y + 60);

        //DRAW PRICE WINDOW

        int itemIndex = getItemIndex(playerSlotCol, playerSlotRow);
        if (itemIndex < gp.player.inventory.size()) {
            x = (int) (gp.tileSize * 15.5);
            y = (int) (gp.tileSize * 5.5);
            width = (int) (gp.tileSize * 2.5);
            height = gp.tileSize;
            drawSubWindow(x, y, width, height);
            g2.drawImage(coin, x + 10, y + 10, 32, 32, null);
            int price = gp.player.inventory.get(itemIndex).price / 2;
            String text = "" + price;
            x = getXforAlignToRight(text, gp.tileSize * 18);
            g2.drawString(text, x - 20, y + 32);

            //SELL
            if (gp.keyH.ePressed) {
                if (gp.player.inventory.get(itemIndex) == gp.player.currentWeapon ||
                        gp.player.inventory.get(itemIndex) == gp.player.currentArmor) {
                    commandNumber = 0;
                    subState = 0;
                    npc.startDialogue(npc,4);
                } else {
                    if (gp.player.inventory.get(itemIndex).amount > 1) {
                        gp.player.inventory.get(itemIndex).amount--;
                    } else {
                        gp.player.inventory.remove(itemIndex);
                    }
                    gp.player.coin += price;
                    gp.playSE(3);
                }

            }

        }
    }

    private void drawSleepScreen() {
        counter++;
        if (counter < 200) {
            gp.eManager.lighting.filterAlfa += 0.01f;
            if (gp.eManager.lighting.filterAlfa > 1f) {
                gp.eManager.lighting.filterAlfa = 1f;
            }
        }
        if (counter >= 200) {
            gp.eManager.lighting.filterAlfa -= 0.01f;
            if (gp.eManager.lighting.filterAlfa <= 0f) {
                gp.eManager.lighting.filterAlfa = 0f;
                counter = 0;
                gp.eManager.lighting.dayState = gp.eManager.lighting.day;
                gp.eManager.lighting.dayCounter =0;
                gp.gameState = gp.playState;
                gp.player.getImage();
            }
        }
    }


    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 45, 45);

        c = new Color(201, 236, 133);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c);
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 35, 35);

    }
    public void drawStatus(){

        if (Player.underEffect){
            int x = gp.tileSize + 20;
            int y = (gp.tileSize * 10)+10;

            speed = setup("ui/statusIcons/speed",gp.tileSize/2,gp.tileSize/2);
            g2.drawImage(speed,x,y,null);
        }
        if (Player.drunk){
            int x = (gp.tileSize*2)-1;
            int y = (gp.tileSize * 10)+10;
            defense = setup("ui/statusIcons/defense",gp.tileSize/2,gp.tileSize/2);
            g2.drawImage(defense,x,y,null);
        }

        if (Player.addict){
            int x = gp.tileSize + 20;
            int y = (gp.tileSize * 10)+10;

            addiction = setup("ui/statusIcons/addiction",gp.tileSize/2,gp.tileSize/2);
            g2.drawImage(addiction,x,y,null);
            //DEBUG
            g2.drawString(String.valueOf(gp.player.batteryCounter),x, y-20);
        }
        if (Player.hangover){
            int x = (gp.tileSize*2)-1;
            int y = (gp.tileSize * 10)+10;
            hangover = setup("ui/statusIcons/hangover",gp.tileSize/2,gp.tileSize/2);
            g2.drawImage(hangover,x,y,null);
        }
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }

    public int getXforAlignToRight(String text, int tailX) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }
    public BufferedImage setup(String imagePath, int width, int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {

            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/" + imagePath + ".png")));
            image = uTool.scaleImage(image, width, height);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }

}
