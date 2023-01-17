package entity;

import main.GamePanel;
import main.KeyHandler;
import object.armor.OBJ_Armor_Learther;
import object.armor.OBJ_Shield;
import object.misc.*;
import object.projectiles.OBJ_Bullet;
import object.projectiles.OBJ_ShotgunBullet;
import object.weapon.OBJ_Ammo_Shotgun;
import object.weapon.OBJ_Melee_Bat_normal;
import object.weapon.OBJ_Shotgun;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public boolean attackCanceled = false;
    public boolean shotCanceled = false;
    public boolean updateLight = false;
    public boolean underEffect;
    public boolean drunk;
    public boolean addict = false;
    public boolean hangover = false;

    int standCounter = 0;
    public int timesUsed = 0;
    public int timesDrinked = 0;


    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 14;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 32;
//        solidArea.width = gp.tileSize / 2;
//        solidArea.height = gp.tileSize / 2;


        setDefaultValues();

    }

    public void setDefaultValues() {


        worldX = gp.tileSize * 26; //First map
        worldY = gp.tileSize * 82;
//        worldX = gp.tileSize * 2; //Second map
//        worldY = gp.tileSize * 47;
//        worldX = gp.tileSize * 2; //third map
//        worldY = gp.tileSize * 46;
//        worldX = gp.tileSize * 4; //boss map
//        worldY = gp.tileSize * 40;
       // setDefaultPositions();
        defaultSpeed = 4;
        speed = defaultSpeed;

        direction = "down";
//PLAYER STATUS
        level = 1;
        strength = 1;
        dexterity = 1;
        exp = 0;
        nextLevel = 100;
        coin = 0;
        currentWeapon = new OBJ_Melee_Bat_normal(gp);
        currentArmor = new OBJ_Armor_Learther(gp);
        currentShield = new OBJ_Shield(gp);
        currentLight = null;
        attack = getAttack();
        defense = getDefense();
        maxHP = 6;
        life = maxHP;
        maxPistolAmmo = 10;
        maxShotgunAmmo = 6;
        pistolAmmo = 5;
        shotgunAmmo = 3;

        getImage();
        getAtkImage();
        getGuardImage();
        setItems();
    }

    public void setItems() {
        inventory.clear();
        inventory.add(currentWeapon);
        inventory.add(currentArmor);
        inventory.add(currentShield);
//        inventory.add(new OBJ_BarrelShield(gp));
//       inventory.add(new OBJ_Key(gp));
//        inventory.add(new OBJ_Wrench(gp));
        inventory.add(new OBJ_Shotgun(gp));
//        inventory.add(new OBJ_Pistol(gp));
//        inventory.add(new OBJ_Armor_Metal(gp));
//        inventory.add(new OBJ_Ammo_Pistol(gp));
        inventory.add(new OBJ_Ammo_Shotgun(gp));
       inventory.add(new OBJ_Ammo_Shotgun(gp));
//        inventory.add(new OBJ_Ammo_Shotgun(gp));
//        inventory.add(new OBJ_Lockpick(gp));
        inventory.add(new OBJ_KeyCard(gp));
       inventory.add(new OBJ_Flashlight(gp));
        inventory.add(new OBJ_SweetBubaleh(gp));
        inventory.add(new OBJ_Amphetamine(gp));
        inventory.add(new OBJ_Amphetamine(gp));
        inventory.add(new OBJ_Amphetamine(gp));
        inventory.add(new OBJ_Booze(gp));
        inventory.add(new OBJ_Booze(gp));
        inventory.add(new OBJ_Booze(gp));

    }

    public void setDefaultPositions() {

        //gp.currentMap = 3;
        worldX = gp.tileSize * 26;
        worldY = gp.tileSize * 82;
        direction = "down";
    }

    public void restoreStatus() {
        life = maxHP;
        invincible = false;
        transparent = false;
        attacking = false;
        guarding = false;
        knockBack = false;
        updateLight = true;
        speed = defaultSpeed;
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

    public void getAtkImage() {

        if (currentWeapon.type == typeMelee) {
            atkup1 = setup("player/attack/atkup1", gp.tileSize, (gp.tileSize * 2));
            atkup2 = setup("player/attack/atkup2", gp.tileSize, (gp.tileSize * 2));
            atkup3 = setup("player/attack/atkup3", gp.tileSize, (gp.tileSize * 2));
            atkdown1 = setup("player/attack/atkdown1", gp.tileSize, (gp.tileSize * 2));
            atkdown2 = setup("player/attack/atkdown2", gp.tileSize, (gp.tileSize * 2));
            atkdown3 = setup("player/attack/atkdown3", gp.tileSize, (gp.tileSize * 2));
            atkleft1 = setup("player/attack/atkleft1", (gp.tileSize * 2), gp.tileSize);
            atkleft2 = setup("player/attack/atkleft2", (gp.tileSize * 2), gp.tileSize);
            atkleft3 = setup("player/attack/atkleft3", (gp.tileSize * 2), gp.tileSize);
            atkright1 = setup("player/attack/atkright1", (gp.tileSize * 2), gp.tileSize);
            atkright2 = setup("player/attack/atkright2", (gp.tileSize * 2), gp.tileSize);
            atkright3 = setup("player/attack/atkright3", (gp.tileSize * 2), gp.tileSize);

        }

//        if (currentWeapon.type == typePistol) {
//            atkup1 = setup("player/rangedAttack/pistolup1", gp.tileSize, (gp.tileSize * 2));
//            atkup2 = setup("player/rangedAttack/pistolup2", gp.tileSize, (gp.tileSize * 2));
//            atkup3 = setup("player/rangedAttack/pistolup3", gp.tileSize, (gp.tileSize * 2));
//            atkdown1 = setup("player/rangedAttack/pistoldown1", gp.tileSize, (gp.tileSize * 2));
//            atkdown2 = setup("player/rangedAttack/pistoldown2", gp.tileSize, (gp.tileSize * 2));
//            atkdown3 = setup("player/rangedAttack/pistoldown3", gp.tileSize, (gp.tileSize * 2));
//            atkleft1 = setup("player/rangedAttack/pistolleft1", (gp.tileSize * 2), gp.tileSize);
//            atkleft2 = setup("player/rangedAttack/pistolleft2", (gp.tileSize * 2), gp.tileSize);
//            atkleft3 = setup("player/rangedAttack/pistolleft3", (gp.tileSize * 2), gp.tileSize);
//            atkright1 = setup("player/rangedAttack/pistolright1", (gp.tileSize * 2), gp.tileSize);
//            atkright2 = setup("player/rangedAttack/pistolright2", (gp.tileSize * 2), gp.tileSize);
//            atkright3 = setup("player/rangedAttack/pistolright3", (gp.tileSize * 2), gp.tileSize);
//        }
//        if (currentWeapon.type == typeShotgun) {
//            atkup1 = setup("player/rangedAttack/shotgunup1", gp.tileSize, (gp.tileSize * 2));
//            atkup2 = setup("player/rangedAttack/shotgunup2", gp.tileSize, (gp.tileSize * 2));
//            atkup3 = setup("player/rangedAttack/shotgunup3", gp.tileSize, (gp.tileSize * 2));
//            atkdown1 = setup("player/rangedAttack/shotgundown1", gp.tileSize, (gp.tileSize * 2));
//            atkdown2 = setup("player/rangedAttack/shotgundown2", gp.tileSize, (gp.tileSize * 2));
//            atkdown3 = setup("player/rangedAttack/shotgundown3", gp.tileSize, (gp.tileSize * 2));
//            atkleft1 = setup("player/rangedAttack/shotgunleft1", (gp.tileSize * 2), gp.tileSize);
//            atkleft2 = setup("player/rangedAttack/shotgunleft2", (gp.tileSize * 2), gp.tileSize);
//            atkleft3 = setup("player/rangedAttack/shotgunleft3", (gp.tileSize * 2), gp.tileSize);
//            atkright1 = setup("player/rangedAttack/shotgunright1", (gp.tileSize * 2), gp.tileSize);
//            atkright2 = setup("player/rangedAttack/shotgunright2", (gp.tileSize * 2), gp.tileSize);
//            atkright3 = setup("player/rangedAttack/shotgunright3", (gp.tileSize * 2), gp.tileSize);
//        }
    }
    public void getGuardImage(){
        guardDown = setup("player/guard/down", gp.tileSize, gp.tileSize);
        guardUp = setup("player/guard/up", gp.tileSize, gp.tileSize);
        guardLeft=setup("player/guard/left", gp.tileSize, gp.tileSize);
        guardRight=setup("player/guard/right", gp.tileSize, gp.tileSize);

    }

    public void update() {
        if (knockBack) {
            gp.cDetector.checkTile(this);
            // CHECK OBJECT COLLISION
           gp.cDetector.checkObject(this, true);


            //CHECK NPC COLLISION
           gp.cDetector.checkEntity(this, gp.npc);


            //CHECK ENEMY COLLISION
            gp.cDetector.checkEntity(this, gp.enemy);

            // CHECK INTERACTIVE TILES COLLISION

            gp.cDetector.checkEntity(this, gp.iTile);
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

            }
            else if(attacking){
                attacking();
            }

        }

        else if (attacking) {
            attacking();

        }
        else if(keyH.spacePressed){
                guarding=true;
                guardCounter++;
        }else if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.ePressed) {
            if (keyH.upPressed) {
                direction = "up";

            }
            if (keyH.downPressed) {
                direction = "down";

            }
            if (keyH.leftPressed) {
                direction = "left";

            }
            if (keyH.rightPressed) {
                direction = "right";

            }




            // CHECK TILE COLLISION

            collisionOn = false;
            gp.cDetector.checkTile(this);


            // CHECK OBJECT COLLISION
            int objIndex = gp.cDetector.checkObject(this, true);
            pickUp(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cDetector.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //CHECK ENEMY COLLISION
            int enemyIndex = gp.cDetector.checkEntity(this, gp.enemy);
            contactEnemy(enemyIndex);
            // CHECK INTERACTIVE TILES COLLISION

            gp.cDetector.checkEntity(this, gp.iTile);

            //CHECK EVENT

            gp.eHandler.checkEvent();
            //SETTING WEAPON TYPE AND AMMO
            if (currentWeapon.type == typePistol) {
                projectiles = new OBJ_Bullet(gp);
            }
            if (currentWeapon.type == typeShotgun) {
                projectiles = new OBJ_ShotgunBullet(gp);
            }

            //Setting effects items




            //IF COLLISION IS FALSE, PLAYER CAN MOVE

            if (!collisionOn && !keyH.ePressed) {
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }
            //Check if under effect
            if(underEffect){
                useCounter++;
                if (useCounter == 600){
                    speed = defaultSpeed;
                    underEffect = false;
                    useCounter = 0;
                }
            }
            if(timesUsed ==3){
                addict = true;
                speed = 1;
            }

            if(drunk){
                useCounter++;
                if (useCounter == 600){
                    defense = getDefense();
                    drunk = false;
                    useCounter = 0;
                }
            }
            if(timesDrinked ==3){
                hangover = true;
                defense = 0;
            }



            if (keyH.ePressed && !attackCanceled ) {
                if (currentWeapon.type == typeMelee || currentWeapon.type == typeCrowbar) {
                    gp.playSE(4);
                    attacking = true;
                    spriteCounter++;
                }
            }

            gp.keyH.ePressed = false;

            attackCanceled = false;

            guarding = false;
            guardCounter = 0;

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
//            guarding = false;
//            guardCounter = 0;
        }
        else {
            standCounter ++;
            if(standCounter == 13) {
                spriteNumber = 2;
                standCounter = 0;
            }
        }

        //Check if under effect

        if (gp.keyH.shotKeyPressed && !projectiles.alive && shotAvailableCounter == 30
                && projectiles.haveResource(this) && !shotCanceled) {
            shooting = true;
            //SET DEFAULT BULLET POSITION
            projectiles.set(worldX, worldY, direction, true, this);
            //SUBTRACT THE COST
            projectiles.subtractResource(this);

            //ADD IT TO THE LIST
//
//            gp.projectilesList.add(projectiles);

            //CHECK IF SLOT IS VACANT

            for (int i = 0; i < gp.projectile.length; i++) {
                if (gp.projectile[gp.currentMap][i] == null) {
                    gp.projectile[gp.currentMap][i] = projectiles;
                    break;
                }
            }
            shotAvailableCounter = 0;
            if (currentWeapon.type == typePistol) {
                gp.playSE(12);

            }
            if (currentWeapon.type == typeShotgun) {
                gp.playSE(13);
            }

        }
        gp.keyH.shotKeyPressed = false;
        shotCanceled = false;
        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                transparent = false;
                invincibleCounter = 0;
            }
        }
        if (shotAvailableCounter < 30) {
            shotAvailableCounter++;
        }
        if (pistolAmmo > maxPistolAmmo) {
            pistolAmmo = maxPistolAmmo;
        }
        if (shotgunAmmo > maxShotgunAmmo) {
            shotgunAmmo = maxShotgunAmmo;
        }
        if (life > maxHP) {
            life = maxHP;
        }
        if(!keyH.godModeOn){
        if (life <= 0) {
            gp.gameState = gp.gameOverState;
            gp.ui.commandNumber = -1;
            gp.stopMusic();
            gp.playSE(19);
        }
        }
    }

    public int getDefense() {
        return defense = (dexterity + currentArmor.defenseValue) + currentShield.defenseValue;
    }

    public int getAttack() {

        attackArea = currentWeapon.attackArea;
        motion1Duration = currentWeapon.motion1Duration;
        motion2Duration = currentWeapon.motion2Duration;
        motion3Duration = currentWeapon.motion3Duration;
        return attack = strength + currentWeapon.attackValue;
    }

    void damageProjectile(int i) {
        if (i != 999) {
            Entity projectile = gp.projectile[gp.currentMap][i];
            projectile.alive = false;
            generateParticle(projectile, projectile);
        }
    }

    void damageInteractiveTile(int i) {
        if (i != 999 && gp.iTile[gp.currentMap][i].destructible && gp.iTile[gp.currentMap][i].isCorrectItem(this) && !gp.iTile[gp.currentMap][i].invincible) {

            gp.iTile[gp.currentMap][i].life--;
            gp.iTile[gp.currentMap][i].invincible = true;
            //Generate particle
            generateParticle(gp.iTile[gp.currentMap][i], gp.iTile[gp.currentMap][i]);
            if (gp.iTile[gp.currentMap][i].life == 0) {
                gp.iTile[gp.currentMap][i].playSE();
                gp.iTile[gp.currentMap][i] = gp.iTile[gp.currentMap][i].getDestroyedForm();
            }


        }
    }


    public void pickUp(int i) {

        String text;

        if (i != 999) {

            //PICKUP ONLY ITEMS
            if (gp.obj[gp.currentMap][i].type == typePickupOnly) {
                gp.obj[gp.currentMap][i].use(this);
                gp.obj[gp.currentMap][i] = null;
            }

            //OBSTACLES
            else if (gp.obj[gp.currentMap][i].type == typeObstacle ) {
                if (keyH.ePressed || keyH.shotKeyPressed) {
                    attackCanceled = true;
                    shotCanceled = true;
                    gp.obj[gp.currentMap][i].interact();
                }
            }

            //INVENTORY ITEMS
            else {
                if (canObtainItem(gp.obj[gp.currentMap][i])) {
                    gp.playSE(1);
                    text = " Got a " + gp.obj[gp.currentMap][i].name + "!";
                } else {
                    text = "Inventory is full!";
                }
                gp.ui.addMessage(text);
                gp.obj[gp.currentMap][i] = null;
            }

        }


    }

    public void interactNPC(int i) {
        if (i != 999) {
        if (gp.keyH.ePressed || gp.keyH.shotKeyPressed) {
                attackCanceled = true;
                shotCanceled = true;
                gp.npc[gp.currentMap][i].speak();
            }
            gp.npc[gp.currentMap][i].move(direction);
    }
    }

    private void contactEnemy(int i) {
        if (i != 999) {
            if (!invincible && !gp.enemy[gp.currentMap][i].dying) {
                gp.playSE(17);
                int damage = gp.enemy[gp.currentMap][i].attack - defense;
                if (damage < 1) {
                    damage = 1;
                }

                life -= damage;
                invincible = true;
                transparent = true;
            }

        }
    }

    void damageEnemy(int i, Entity attacker, int attack, int knockBackPower) {

        if (i != 999) {
            if (!gp.enemy[gp.currentMap][i].invincible) {
                gp.enemy[gp.currentMap][i].playSE();
                if (knockBackPower > 0) {
                    setKnockBack(gp.enemy[gp.currentMap][i],attacker, knockBackPower);
                }
                if(gp.enemy[gp.currentMap][i].offBalance){
                    attack *= 5;
                }


                int damage = attack - gp.enemy[gp.currentMap][i].defense;
                if (damage < 0) {
                    damage = 0;
                }

                gp.enemy[gp.currentMap][i].life -= damage;

                gp.ui.addMessage(damage + " damage!");
                gp.enemy[gp.currentMap][i].invincible = true;
                generateParticle(gp.player.currentWeapon, gp.enemy[gp.currentMap][i]);
                gp.enemy[gp.currentMap][i].damageReaction();

                if (gp.enemy[gp.currentMap][i].life <= 0) {
                    gp.enemy[gp.currentMap][i].dying = true;
                    gp.ui.addMessage("Killed " + gp.enemy[gp.currentMap][i].name + "!");
                    gp.ui.addMessage("Exp " + gp.enemy[gp.currentMap][i].exp + "!");
                    exp += gp.enemy[gp.currentMap][i].exp;
                    checkLevelUp();
                }
            }

        }
    }
    public void setDialogue() {}

    private void checkLevelUp() {
        if (exp >= nextLevel) {
            level++;
            nextLevel = nextLevel * 2;
            maxHP += 2;
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            gp.playSE(8);
            gp.ui.addMessage("Congratulations you got level " + level);
        }
    }
    public int getCurrentWeaponSlot(){
        int currentWeaponSlot = 0;
        for(int i =0; i < inventory.size();i++){
            if(inventory.get(i) == currentWeapon){
                currentWeaponSlot = i;
            }
        }return currentWeaponSlot;
    }
    public int getCurrentArmorSlot(){
        int currentArmorSlot = 0;
        for(int i =0; i < inventory.size();i++){
            if(inventory.get(i) == currentArmor){
                currentArmorSlot = i;
            }
        }return currentArmorSlot;

    }
    public int getCurrentShieldSlot(){
        int currentShieldSlot = 0;
        for(int i =0; i < inventory.size();i++){
            if(inventory.get(i) == currentShield){
                currentShieldSlot = i;
            }
        }return currentShieldSlot;

    }

    public void selectItem() {
        int itemIndex = gp.ui.getItemIndex(gp.ui.playerSlotCol, gp.ui.playerSlotRow);
        if (itemIndex < inventory.size()) {
            Entity selectedItem = inventory.get(itemIndex);
            if (selectedItem.type == typeMelee || selectedItem.type == typeCrowbar) {
                currentWeapon = selectedItem;
                attack = getAttack();
                getAtkImage();
            }
            if (selectedItem.type == typePistol || selectedItem.type == typeShotgun) {
                currentWeapon = selectedItem;
                attack = getAttack();
                getAtkImage();
            }
            if (selectedItem.type == typeArmor) {
                currentArmor = selectedItem;
                defense = getDefense();
            }
            if (selectedItem.type == typeShield) {
                currentShield = selectedItem;
                defense = getDefense();
            }
            if (selectedItem.type == typeLight) {
                if (currentLight == selectedItem) {
                    currentLight = null;
                } else {
                    currentLight = selectedItem;
                }
            }
            updateLight = true;
            if (selectedItem.type == typeConsumable) {
                if (selectedItem.use(this)) {
                    if (selectedItem.amount > 1) {
                        selectedItem.amount--;
                    } else {
                        inventory.remove(itemIndex);
                    }
                }


                //later

            }

        }
    }

    public int searchItemInInventory(String itemName) {
        int itemIndex = 999;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name.equals(itemName)) {
                itemIndex = i;
                break;
            }
        }
        return itemIndex;
    }

    public boolean canObtainItem(Entity item) {
        boolean canObtain = false;

        Entity newItem = gp.entityGenerator.getObject(item.name);
        //CHECK IF STACKABLE

        if (newItem.stackable) {
            int index = searchItemInInventory(newItem.name);
            if (index != 999) {
                inventory.get(index).amount++;
                canObtain = true;
                //New ITEM need to find if slot is vacant
            } else {
                if (inventory.size() != maxInventorySize) {
                    inventory.add(newItem);
                    canObtain = true;
                }

            }
        } else { //NOT STACKABLE
            if (inventory.size() != maxInventorySize) {
                inventory.add(newItem);
                canObtain = true;
            }
        }
        return canObtain;

    }

    public void getSleepImage(BufferedImage image) {
        up1 = image;
        up2 = image;
        up3 = image;
        down1 = image;
        down2 = image;
        down3 = image;
        left1 = image;
        left2 = image;
        left3 = image;
        right1 = image;
        right2 = image;
        right3 = image;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch (direction) {
            case "up" -> {
                if (!attacking) {
                    if (spriteNumber == 1) {image = up1;}
                    if (spriteNumber == 2) {image = up2;}
                    if (spriteNumber == 3) {image = up3;}
                }
                if (attacking) {
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNumber == 1) {image = atkup1;}
                    if (spriteNumber == 2) {image = atkup2;}
                    if (spriteNumber == 3) {image = atkup3;}
                }
                if(guarding){
                    image = guardUp;
                }
                break;
            }
            case "down" -> {
                if (!attacking) {
                    if (spriteNumber == 1) {image = down1;}
                    if (spriteNumber == 2) {image = down2;}
                    if (spriteNumber == 3) {image = down3;}
                }
                if (attacking) {

                    if (spriteNumber == 1) {image = atkdown1;}
                    if (spriteNumber == 2) {image = atkdown2;}
                    if (spriteNumber == 3) {image = atkdown3;}
                }
                if(guarding){
                    image = guardDown;
                }
                break;
            }

            case "left" -> {
                if (!attacking) {
                    if (spriteNumber == 1) {image = left1;}
                    if (spriteNumber == 2) {image = left2;}
                    if (spriteNumber == 3) {image = left3;}
                }
                if (attacking) {
                    tempScreenX = screenX - gp.tileSize;
                    if (spriteNumber == 1) {image = atkleft1;}
                    if (spriteNumber == 2) {image = atkleft2;}
                    if (spriteNumber == 3) {image = atkleft3;}
                }
                if(guarding){
                    image = guardLeft;
                }
                break;
            }
            case "right" -> {
                if (!attacking) {
                    if (spriteNumber == 1) {image = right1;}
                    if (spriteNumber == 2) {image = right2;}
                    if (spriteNumber == 3) {image = right3;}
                }
                if (attacking) {
                    if (spriteNumber == 1) {image = atkright1;}
                    if (spriteNumber == 2) {image = atkright2;}
                    if (spriteNumber == 3) {image = atkright3;}
                    break;
                }
                if(guarding){
                    image = guardRight;
                }
                if (transparent) {
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                }
            }
        }

        int x = tempScreenX;
        int y = tempScreenY;
        if(tempScreenX > worldX){
            x = worldX;
        }
        if(tempScreenY > worldY){
            y = worldY;
        }
        int rightOffset = gp.screenWidth - gp.player.screenX;
        if(rightOffset > gp.worldWidth - gp.player.worldX){
            x = gp.screenWidth - (gp.worldWidth-worldX);
        }
        int bottomOffset = gp.screenHeight - gp.player.screenY;
        if(bottomOffset > gp.worldHeight-gp.player.worldY){
            y = gp.screenHeight - (gp.worldHeight-worldY);
        }
        if(drawing) {
            g2.drawImage(image, x, y, null);
            //CHECK SOLID AREA
            g2.setColor(Color.RED);
            g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
            if (addict){
                x = gp.screenWidth/2;
                y = gp.tileSize;
                g2.setFont(gp.ui.myFont.deriveFont(20f));
                g2.setColor(Color.GREEN);
                g2.drawString("ADDICTED",x,y);
            }
            if (hangover){
                x = gp.screenWidth/2;
                y = gp.tileSize;
                g2.setFont(gp.ui.myFont.deriveFont(20f));
                g2.setColor(Color.GREEN);
                g2.drawString("HANGOVER",x,y);
            }
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));


    }

}

