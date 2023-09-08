package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Entity {

    public GamePanel gp;
    public BufferedImage image, image2, image3;
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public BufferedImage atkup1, atkup2, atkup3, atkdown1, atkdown2, atkdown3, atkleft1, atkleft2,
            atkleft3, atkright1, atkright2, atkright3, guardUp, guardDown, guardLeft, guardRight;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    public String[][] dialogues = new String[20][20];

    public Entity attacker;
    public Entity linkedEntity;
    public boolean temp = false;

    //STATE
    public int worldX, worldY;
    public String direction = "down";
    public int spriteNumber = 1;
    public int dialogueSet = 0;
    public int dialogueIndex = 0;
    public int questIndex = 0;
    public boolean collisionOn = false;
    public boolean invincible = false;
    public boolean attacking = false;
    public boolean shooting = false;
    public boolean alive = true;
    public boolean dying = false;
    public boolean hpBarOn = false;
    public boolean onPath = false;
    public boolean knockBack = false;
    public String knockbackDirection;
    public boolean guarding = false;
    public boolean transparent = false;
    public boolean offBalance = false;
    public Entity loot;
    public boolean opened = false;
    public boolean inRage = false;
    public boolean sleep = false;
    public boolean drawing = true;



    //COUNTER
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;
    public int dyingCounter = 0;
    public int hpBarCounter = 0;
    public int shotAvailableCounter = 0;
    public int knockBackCounter = 0;
    public int guardCounter = 0;
    public int offBalanceCounter = 0;
    public int useCounter = 0;

    //CHARACTERS ATRIBUTES
    public String name;

    public double speed;
    public int maxHP;
    public int life;
    public int defaultSpeed;
    public int maxPistolAmmo;
    public int maxShotgunAmmo;
    public int pistolAmmo;
    public int shotgunAmmo;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevel;
    public int coin;
    public int motion1Duration = 0;
    public int motion2Duration = 0;
    public int motion3Duration = 0;
    public Entity currentWeapon;
    public Entity currentArmor;
    public Entity currentShield;
    public Entity currentLight;
    public Projectiles projectiles;
    public boolean boss;

    //ITEM ATTRIBUTES
    public ArrayList<Entity> inventory = new ArrayList<>();
    public static ArrayList<Entity> quest = new ArrayList<>();
    public final int maxInventorySize = 20;
    public int attackValue;
    public int defenseValue;
    public String description = "";
    public int useCost;
    public int value;
    public int price;
    public int knockBackPower;
    public boolean stackable = false;
    public int amount = 1;
    public int lightRadius;


    //TYPE
    public int type;
//    public final int typePlayer = 0;
//    public final int typeNPC = 1;
    public final int typeEnemy = 2;
    public final int typeMelee = 3;
    public final int typeCrowbar = 4;
    public final int typePistol = 5;
    public final int typeShotgun = 6;
    public final int typeArmor = 7;
    public final int typeConsumable = 8;
    public final int typePickupOnly = 9;
    public final int typeObstacle = 10;
    public final int typeLight = 11;
    public final int typeShield = 12;



    public Entity(GamePanel gp) {
        this.gp = gp;

    }
    public Entity() {

    }
    public int getScreenX(){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        return screenX;
    }
    public int getScreenY(){
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        return screenY;
    }


    public int getLeftX() {
        return worldX + solidArea.x;
    }

    public int getRightX() {
        return worldX + solidArea.x + solidArea.width;
    }

    public int getTopY() {
        return worldY + solidArea.y;
    }

    public int getBottomY() {
        return worldY + solidArea.y + solidArea.height;
    }

    public int getCol() {
        return (worldX + solidArea.x) / gp.tileSize;
    }

    public int getRow() {
        return (worldY + solidArea.y) / gp.tileSize;
    }

    public int getXDistance(Entity target) {
        int xDistance = Math.abs(getCenterX() - target.getCenterX());
        return xDistance;
    }

    public int getYDistance(Entity target) {
        int yDistance = Math.abs(getCenterY() - target.getCenterY());
        return yDistance;
    }

    public int getCenterX() {
        int centerX = worldX + left1.getWidth() / 2;
        return centerX;

    }

    public int getCenterY() {
        int centerY = worldY + up1.getHeight() / 2;
        return centerY;
    }

    public int getTileDistance(Entity target) {
        int tileDistance = ((getXDistance(target) + getYDistance(target)) / gp.tileSize);
        return tileDistance;
    }

    public int getGoalCol(Entity target) {
        int goalCol = (target.worldX + target.solidArea.x) / gp.tileSize;
        return goalCol;
    }

    public int getGoalCRow(Entity target) {
        int goalRow = (target.worldY + target.solidArea.y) / gp.tileSize;
        return goalRow;
    }

    public void resetCounters() {
        spriteCounter = 0;
        actionLockCounter = 0;
        invincibleCounter = 0;
        dyingCounter = 0;
        hpBarCounter = 0;
        shotAvailableCounter = 0;
        knockBackCounter = 0;
        guardCounter = 0;
        offBalanceCounter = 0;
    }

    public void setLoot(Entity loot) {

    }

    public void move(String direction) {

    }

    public void setAction() {

    }

    public void damageReaction() {

    }

    public void setKnockBack(Entity target, Entity attacker, int knockBackPower) {
        this.attacker = attacker;
        target.knockbackDirection = attacker.direction;
        target.speed += knockBackPower;
        target.knockBack = true;
    }

    public void checkCollision() {
        collisionOn = false;
        gp.cDetector.checkTile(this);
        gp.cDetector.checkObject(this, false);
        gp.cDetector.checkEntity(this, gp.npc);
        gp.cDetector.checkEntity(this, gp.enemy);
        gp.cDetector.checkEntity(this, gp.iTile);
        boolean contactPlayer = gp.cDetector.checkPlayer(this);

        if (this.type == typeEnemy && contactPlayer) {
            damagePlayer(attack);
        }

    }

    public void update() {
        if (!sleep) {
            if (knockBack) {
                checkCollision();
                if (collisionOn) {
                    knockBackCounter = 0;
                    knockBack = false;
                    speed = defaultSpeed;
                } else {
                    switch (knockbackDirection) {
                        case "up" -> worldY -= speed;
                        case "down" -> worldY += speed;
                        case "left" -> worldX -= speed;
                        case "right" -> worldX += speed;
                    }

                }

                knockBackCounter++;
                if (knockBackCounter == 10) {
                    knockBackCounter = 0;
                    knockBack = false;
                    speed = defaultSpeed;

                } else if (attacking) {
                    attacking();
                }

            } else {
                setAction();
                checkCollision();

                //IF COLLISION IS FALSE, ENTITY CAN MOVE

                if (!collisionOn) {
                    switch (direction) {
                        case "up" -> worldY -= speed;
                        case "down" -> worldY += speed;
                        case "left" -> worldX -= speed;
                        case "right" -> worldX += speed;
                    }
                }
                spriteCounter++;
                if (spriteCounter > 12) {
                    if (spriteNumber == 1) {
                        spriteNumber = 2;
                    } else if (spriteNumber == 2) {
                        spriteNumber = 3;
                    } else if (spriteNumber == 3) {
                        spriteNumber = 1;
                    }
                    spriteCounter = 0;
                }
                if (invincible) {
                    invincibleCounter++;
                    if (invincibleCounter > 40) {
                        invincible = false;
                        invincibleCounter = 0;
                    }
                }
                if (shotAvailableCounter < 30) {
                    shotAvailableCounter++;
                }
            }
            if (offBalance) {
                offBalanceCounter++;
                if (offBalanceCounter > 60) {
                    offBalance = false;
                    offBalanceCounter = 0;
                }
            }
        }
    }

    public String getOppositeDirection(String direction) {
        String oppositeDirection = "";

        switch (direction) {
            case "up":
                oppositeDirection = "down";
                break;
            case "down":
                oppositeDirection = "up";
                break;
            case "left":
                oppositeDirection = "right";
                break;
            case "right":
                oppositeDirection = "left";
                break;
        }
        return oppositeDirection;
    }

    void attacking() {

        spriteCounter++;
        if (spriteCounter <= motion1Duration) {
            spriteNumber = 1;
        }
        if (spriteCounter > motion1Duration && spriteCounter < motion2Duration) {
            spriteNumber = 2;
        }
        if (spriteCounter > motion2Duration && spriteCounter < motion3Duration) {
            spriteNumber = 3;


            //Save current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //Adjust player's worldX/Y for the attack

            switch (direction) {
                case "up":
                    worldY -= attackArea.height;
                    break;
                case "down":
                    worldY += attackArea.height;
                    break;
                case "left":
                    worldX -= attackArea.width;
                    break;
                case "right":
                    worldX += attackArea.width;
                    break;
            }
            //attackArea becomes solid area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            if (type == typeEnemy) {
                if (gp.cDetector.checkPlayer(this)) {
                    damagePlayer(attack);
                }

            } else {//Player
                //Check enemy collision with the updated worldX , worldT, solidArea
                int enemyIndex = gp.cDetector.checkEntity(this, gp.enemy);
                gp.player.damageEnemy(enemyIndex, this, attack, currentWeapon.knockBackPower);
                //After checking collision restore original data
                int iTileIndex = gp.cDetector.checkEntity(this, gp.iTile);
                gp.player.damageInteractiveTile(iTileIndex);
                int projectileIndex = gp.cDetector.checkEntity(this, gp.projectile);
                gp.player.damageProjectile(projectileIndex);
            }
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }

        if (spriteCounter > motion3Duration) {
            spriteNumber = 1;
            spriteCounter = 0;
            attacking = false;

        }
    }

    public void checkAttacking(int rate, int straight, int horizontal) {
        boolean targetInRange = false;
        int xDis = getXDistance(gp.player);
        int yDis = getYDistance(gp.player);

        switch (direction) {
            case "up":
                if (gp.player.getCenterY() < getCenterY() && yDis < straight && xDis < horizontal) {
                    targetInRange = true;
                }
                break;
            case "down":
                if (gp.player.getCenterY() > getCenterY() && yDis < straight && xDis < horizontal) {
                    targetInRange = true;
                }
                break;
            case "left":
                if (gp.player.getCenterX() < getCenterX() && xDis < straight && yDis < horizontal) {
                    targetInRange = true;
                }
                break;
            case "right":
                if (gp.player.getCenterX() > getCenterX() && xDis < straight && yDis < horizontal) {
                    targetInRange = true;
                }
                break;
        }
        if (targetInRange) {
            //Check if initiates attack

            int i = new Random().nextInt(rate);
            if (i == 0) {
                attacking = true;
                spriteNumber = 1;
                spriteCounter = 0;
                shotAvailableCounter = 0;
            }
        }

    }


    public void damagePlayer(int attack) {
        if (!gp.player.invincible) {
            gp.playSE(17);
            int damage = attack - gp.player.defense;
            //Get opposite direction of the attack
            String canGuardDirection = getOppositeDirection(direction);

            if (gp.player.guarding && gp.player.direction.equals(canGuardDirection)) {
                //PARRY
                if (gp.player.guardCounter < 10) {
                    damage = 0;
                    gp.playSE(26);
                    setKnockBack(this, gp.player, knockBackPower);
                    offBalance = true;
                    spriteCounter = -60;
                } else {
                    //NORMAL GUARD
                    damage /= 3;
                    gp.playSE(25);
                }
            } else {
                gp.playSE(17);
                //Not guarding
                if (damage < 1) {
                    damage = 1;
                }
            }
            if (damage < 0) {
                damage = 0;
            }
            if (damage != 0) {
                transparent = true;
                setKnockBack(gp.player, this, knockBackPower);
            }
            gp.player.life -= damage;
            gp.player.invincible = true;
        }
    }

    public void checkStopChasing(Entity target, int distance, int rate) {

        if (getTileDistance(target) > distance) {
            int i = new Random().nextInt(rate);
            if (i == 0) {
                onPath = false;
            }
        }

    }

    public void checkStartChasing(Entity target, int distance, int rate) {

        if (getTileDistance(target) < distance) {
            int i = new Random().nextInt(rate);
            if (i == 0) {
                onPath = true;
            }
        }

    }

    public void getRandomDirection(int interval) {
        actionLockCounter++;
        if (actionLockCounter > interval) {
            Random random = new Random();
            int i = random.nextInt(100) + 1; // pick up a number from 1 to 100
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }

    public void moveTowardPlayer(int interval) {
        actionLockCounter++;
        if (actionLockCounter > interval) {
            if (getXDistance(gp.player) > getYDistance(gp.player)) {
                if (gp.player.getCenterX() < getCenterX()) {
                    direction = "left";
                } else {
                    direction = "right";
                }

            } else if (getXDistance(gp.player) < getYDistance(gp.player)) {
                if (gp.player.getCenterY() < getCenterY()) {
                    direction = "up";
                } else {
                    direction = "down";
                }
            }
            actionLockCounter = 0;

        }

    }

    public void checkShoot(int rate, int shootInterval, int sound) {
        int i = new Random().nextInt(rate);
        if (i == 0 && !projectiles.alive && shotAvailableCounter == shootInterval) {
            projectiles.set(worldX, worldY, direction, true, this);
            //CHECK IF VACANT
            for (int j = 0; j < gp.projectile.length; j++) {
                if (gp.projectile[gp.currentMap][j] == null) {
                    gp.projectile[gp.currentMap][j] = projectiles;
                    break;
                }
            }
            shotAvailableCounter = 0;
            gp.playSE(sound);
        }

    }

    public void playSE() {

    }

    public void speak() {
    }

    public void startDialogue(Entity entity, int setNum) {
        gp.gameState = gp.dialogState;
        gp.ui.npc = entity;
        dialogueSet = setNum;
    }

    public void npcReactionToAction() {
        switch (gp.player.direction) {
            case "up" -> direction = "down";
            case "down" -> direction = "up";
            case "left" -> direction = "right";
            case "right" -> direction = "left";
        }
    }

    public void interact() {

    }

    public boolean use(Entity entity) {
        return false;
    }

    public void checkDrop() {

    }

    public void dropItem(Entity droppedItem) {
        for (int i = 0; i < gp.obj[1].length; i++) {
            if (gp.obj[gp.currentMap][i] == null) {
                gp.obj[gp.currentMap][i] = droppedItem;
                gp.obj[gp.currentMap][i].worldX = worldX;
                gp.obj[gp.currentMap][i].worldY = worldY;
                break;
            }
        }
    }

    public Color getParticleColor() {
        Color color = null;
        return color;
    }

    public int getParticleSize() {
        int size = 0;
        return size;
    }

    public int getParticleSpeed() {
        int speed = 0;
        return speed;
    }

    public int getParticleLife() {
        int maxHP = 0;
        return maxHP;
    }


    public void generateParticle(Entity generator, Entity target) {
        Color color = generator.getParticleColor();
        int size = generator.getParticleSize();
        int speed = generator.getParticleSpeed();
        int maxHP = generator.getParticleLife();

        Particles p1 = new Particles(gp, target, color, size, speed, maxHP, -2, -1);
        gp.particleList.add(p1);
        Particles p2 = new Particles(gp, target, color, size, speed, maxHP, 2, 1);
        gp.particleList.add(p2);
        Particles p3 = new Particles(gp, target, color, size, speed, maxHP, 0, -1);
        gp.particleList.add(p3);
        Particles p4 = new Particles(gp, target, color, size, speed, maxHP, -1, 0);
        gp.particleList.add(p4);
        Particles p5 = new Particles(gp, target, color, size, speed, maxHP, 1, 0);
        gp.particleList.add(p5);
        Particles p6 = new Particles(gp, target, color, size, speed, maxHP, 0, 1);
        gp.particleList.add(p6);
        Particles p7 = new Particles(gp, target, color, size, speed, maxHP, -2, 1);
        gp.particleList.add(p7);
        Particles p8 = new Particles(gp, target, color, size, speed, maxHP, 2, -1);
        gp.particleList.add(p8);
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

    public boolean inCamera() {
        boolean inCamera = false;
        if (worldX + gp.tileSize * 16> gp.player.worldX+gp.tileSize - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize * 16 > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            inCamera = true;
        }
        return inCamera;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;


        if (inCamera()) {
            int tempScreenX = getScreenX();
            int tempScreenY = getScreenY();


            switch (direction) {
                case "up" -> {
                    if (!attacking) {
                        if (spriteNumber == 1) {
                            image = up1;
                        }
                        if (spriteNumber == 2) {
                            image = up2;
                        }
                        if (spriteNumber == 3) {
                            image = up3;
                        }
                    }
                    if (attacking) {
                        tempScreenY = getScreenY() - up1.getHeight();
                        if (spriteNumber == 1) {
                            image = atkup1;
                        }
                        if (spriteNumber == 2) {
                            image = atkup2;
                        }
                        if (spriteNumber == 3) {
                            image = atkup3;
                        }
                    }
                }
                case "down" -> {
                    if (!attacking) {
                        if (spriteNumber == 1) {
                            image = down1;
                        }
                        if (spriteNumber == 2) {
                            image = down2;
                        }
                        if (spriteNumber == 3) {
                            image = down3;
                        }
                    }
                    if (attacking) {
                        if (spriteNumber == 1) {
                            image = atkdown1;
                        }
                        if (spriteNumber == 2) {
                            image = atkdown2;
                        }
                        if (spriteNumber == 3) {
                            image = atkdown3;
                        }
                    }
                }
                case "left" -> {
                    if (!attacking) {
                        if (spriteNumber == 1) {
                            image = left1;
                        }
                        if (spriteNumber == 2) {
                            image = left2;
                        }
                        if (spriteNumber == 3) {
                            image = left3;
                        }
                    }
                    if (attacking) {
                        tempScreenX = getScreenX() - left1.getWidth();
                        if (spriteNumber == 1) {
                            image = atkleft1;
                        }
                        if (spriteNumber == 2) {
                            image = atkleft2;
                        }
                        if (spriteNumber == 3) {
                            image = atkleft3;
                        }
                    }
                }
                case "right" -> {
                    if (!attacking) {
                        if (spriteNumber == 1) {
                            image = right1;
                        }
                        if (spriteNumber == 2) {
                            image = right2;
                        }
                        if (spriteNumber == 3) {
                            image = right3;
                        }
                    }
                    if (attacking) {
                        if (spriteNumber == 1) {
                            image = atkright1;
                        }
                        if (spriteNumber == 2) {
                            image = atkright2;
                        }
                        if (spriteNumber == 3) {
                            image = atkright3;
                        }
                    }
                }
            }

            if (invincible) {
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.6f);
            }

            if (dying) {
                dyingAnimation(g2);
            }
            if (gp.player.worldX < gp.player.screenX) {
                tempScreenX = worldX;
            }
            if (gp.player.worldY < gp.player.screenY) {
                tempScreenY = worldY;
            }
            int rightOffset = gp.screenWidth - gp.player.screenX;
            if (rightOffset > gp.worldWidth - gp.player.worldX) {
                tempScreenX = gp.screenWidth - (gp.worldWidth - worldX);
            }
            int bottomOffset = gp.screenHeight - gp.player.screenY;
            if (bottomOffset > gp.worldHeight - gp.player.worldY) {
                tempScreenY = gp.screenHeight - (gp.worldHeight - worldY);
            }
            if (inCamera()) {

                g2.drawImage(image, tempScreenX, tempScreenY, null);
            } else if (gp.player.worldX < gp.player.screenX ||
                    gp.player.worldY < gp.player.screenY ||
                    rightOffset > gp.worldWidth - gp.player.worldX ||
                    bottomOffset > gp.worldHeight - gp.player.worldY) {
                g2.drawImage(image, tempScreenX, tempScreenY, null);
            }
        }

            //CHECK SOLID AREA
            g2.setColor(Color.RED);
            g2.drawRect(getScreenX() + solidArea.x, getScreenY() + solidArea.y, solidArea.width, solidArea.height);

            changeAlpha(g2, 1f);



    }

    private void dyingAnimation(Graphics2D g2) {
        dyingCounter++;

        int i = 5;
        if (dyingCounter == i) {
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i && dyingCounter <= i * 2) {
            changeAlpha(g2, 1f);
        }
        if (dyingCounter > i * 2 && dyingCounter <= i * 3) {
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i * 3 && dyingCounter <= i * 4) {
            changeAlpha(g2, 1f);
        }
        if (dyingCounter > i * 4 && dyingCounter <= i * 5) {
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i * 5 && dyingCounter <= i * 6) {
            changeAlpha(g2, 1f);
        }
        if (dyingCounter > i * 6 && dyingCounter <= i * 7) {
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i * 7 && dyingCounter <= i * 8) {
            changeAlpha(g2, 1f);

        }
        if (dyingCounter > i * 8) {
            alive = false;
        }
    }

    public void changeAlpha(Graphics2D g2, float alphaValue) {

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }

    public int getDetected(Entity user, Entity[][] target, String targetName) {
        int index = 999;
        int nextWorldX = user.getLeftX();
        int nextWorldY = user.getTopY();

        switch (user.direction) {
            case "up":
                nextWorldY = (int) (user.getTopY() - gp.player.speed);
                break;
            case "down":
                nextWorldY = (int) (user.getBottomY() + gp.player.speed);
                break;
            case "left":
                nextWorldX = (int) (user.getLeftX() - gp.player.speed);
                break;
            case "right":
                nextWorldX = (int) (user.getRightX() + gp.player.speed);
                break;
        }
        int col = nextWorldX / gp.tileSize;
        int row = nextWorldY / gp.tileSize;

        for (int i = 0; i < target[1].length; i++) {
            if (target[gp.currentMap][i] != null) {
                if (target[gp.currentMap][i].getCol() == col &&
                        target[gp.currentMap][i].getRow() == row &&
                        target[gp.currentMap][i].name.equals(targetName)) {
                    index = i;
                    break;
                }
            }
        }
        return index;

    }

    public void searchPath(int goalCol, int goalRow) {
        int startCol = (worldX + solidArea.x) / gp.tileSize;
        int startRow = (worldY + solidArea.y) / gp.tileSize;
        gp.pFinder.setNode(startCol, startRow, goalCol, goalRow, this);
        if (gp.pFinder.search()) {

            //NEXT WORLDX & WORLDY
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;


            //Entities solid area position

            int enLeftX = worldX + solidArea.x;
            int enRightX = worldX + solidArea.x + solidArea.width;
            int enTopY = worldY + solidArea.y;
            int enBottomY = worldY + solidArea.y + solidArea.height;

            if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "up";
            } else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "down";
            } else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
                //left or right
                if (enLeftX > nextX) {
                    direction = "left";
                }
                if(enLeftX < nextX){
                    direction = "right";
                }
            }
            else if (enTopY > nextY && enLeftX > nextX) {
                //up or left
                direction = "up";
                checkCollision();
                if (collisionOn) {
                    direction = "left";
                }
            }
            else if (enTopY > nextY && enLeftX < nextX) {
                //up or right
                direction = "up";
                checkCollision();
                if (collisionOn) {
                    direction = "right";
                }
            }
            else if (enTopY < nextY && enLeftX > nextX) {
                //down or left
                direction = "down";
                checkCollision();
                if (collisionOn) {
                    direction = "left";
                }
            } else if (enTopY < nextY && enLeftX < nextX) {
                //down or right
                direction = "down";
                checkCollision();
                if (collisionOn) {
                    direction = "right";
                }

            }
            //If reaches the goal , stop the search
//            int nextCol = gp.pFinder.pathList.get(0).col;
//            int nextRow = gp.pFinder.pathList.get(0).row;
//            if(nextCol ==goalCol && nextRow == goalRow){
//                onPath = false;
//            }
        }

    }
}
