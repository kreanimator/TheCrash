package data;

import main.GamePanel;

import java.io.*;

public class SaveLoad {

    GamePanel gp;

    public SaveLoad(GamePanel gp) {
        this.gp = gp;
    }


    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DataStorage dt = new DataStorage();
            //Player stats
            dt.level = gp.player.level;
            dt.maxLife = gp.player.maxHP;
            dt.life = gp.player.life;
            dt.maxPistolAmmo = gp.player.maxPistolAmmo;
            dt.maxShotgunAmmo = gp.player.maxShotgunAmmo;
            dt.pistolAmmo = gp.player.pistolAmmo;
            dt.shotgunAmmo = gp.player.shotgunAmmo;
            dt.strength = gp.player.strength;
            dt.dexterity = gp.player.dexterity;
            dt.exp = gp.player.exp;
            dt.nextLevelExp = gp.player.nextLevel;
            dt.money = gp.player.coin;
            dt.worldX = gp.player.worldX;
            dt.worldY = gp.player.worldY;
            dt.currentMap = gp.currentMap;
            dt.currentArea = gp.currentArea;

            //Player inventory

            for(int i = 0; i< gp.player.inventory.size(); i++){
                dt.itemNames.add(gp.player.inventory.get(i).name);
                dt.itemAmounts.add(gp.player.inventory.get(i).amount);
            }
            //PLAYER EQUIPMENT
            dt.currentWeaponSlot = gp.player.getCurrentWeaponSlot();
            dt.currentShieldSlot = gp.player.getCurrentShieldSlot();
            dt.currentArmorSlot = gp.player.getCurrentArmorSlot();
            //OBJECTS ON MAP

            dt.mapObjectsName = new String[gp.maxMap][gp.obj[1].length];
            dt.mapObjectWorldX = new int[gp.maxMap][gp.obj[1].length];
            dt.mapObjectWorldY = new int[gp.maxMap][gp.obj[1].length];
            dt.mapObjectLootNames = new String[gp.maxMap][gp.obj[1].length];
            dt.mapObjectOpened = new boolean[gp.maxMap][gp.obj[1].length];

            for(int mapNum = 0; mapNum < gp.maxMap;mapNum++){
                for(int i =0 ; i < gp.obj[1].length; i++){
                    if(gp.obj[mapNum][i]==null){
                        dt.mapObjectsName[mapNum][i] = "NA";
                    }else{
                        dt.mapObjectsName[mapNum][i] = gp.obj[mapNum][i].name;
                        dt.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].worldX;
                        dt.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].worldY;
                        if(gp.obj[mapNum][i].loot != null){
                            dt.mapObjectLootNames[mapNum][i] = gp.obj[mapNum][i].loot.name;
                        }
                        dt.mapObjectOpened[mapNum][i] = gp.obj[mapNum][i].opened;

                    }
                }
            }

            //Write the DataStorage object

            oos.writeObject(dt);

        } catch (Exception e) {
            System.out.println("Save exception");
        }

    }

    public void load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            //Read the datastorage object
            DataStorage ds = (DataStorage)ois.readObject();
            gp.player.level = ds.level;
            gp.player.maxHP = ds.maxLife;
            gp.player.life = ds.life;
            gp.player.maxPistolAmmo = ds.maxPistolAmmo;
            gp.player.maxShotgunAmmo = ds.maxShotgunAmmo;
            gp.player.pistolAmmo = ds.pistolAmmo;
            gp.player.shotgunAmmo = ds.shotgunAmmo;
            gp.player.strength =ds.strength;
            gp.player.dexterity = ds.dexterity;
            gp.player.exp = ds.exp;
            gp.player.nextLevel = ds.nextLevelExp;
            gp.player.coin = ds.money;
            gp.player.worldX = ds.worldX;
            gp.player.worldY = ds.worldY;
            gp.currentMap = ds.currentMap;
            gp.currentArea = ds.currentArea;

            //PLAYER INVENTORY

            gp.player.inventory.clear();
            for(int i = 0; i < ds.itemNames.size();i++){
                gp.player.inventory.add(gp.entityGenerator.getObject(ds.itemNames.get(i)));
                gp.player.inventory.get(i).amount=ds.itemAmounts.get(i);
            }
            //PLAYER EQUIPMENT
            gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeaponSlot);
            gp.player.currentArmor = gp.player.inventory.get(ds.currentArmorSlot);
            gp.player.currentShield = gp.player.inventory.get(ds.currentShieldSlot);
            gp.player.getAttack();
            gp.player.getDefense();
            gp.player.getAtkImage();

            //OBJECTS ON MAP
            for(int mapNum = 0; mapNum < gp.maxMap; mapNum++){
                for(int i = 0; i< gp.obj[1].length; i++){
                    if(ds.mapObjectsName[mapNum][i].equals("NA")){
                        gp.obj[mapNum][i] = null;
                    }else {
                        gp.obj[mapNum][i] = gp.entityGenerator.getObject(ds.mapObjectsName[mapNum][i]);
                        gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
                        gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];
                        if(ds.mapObjectLootNames[mapNum][i] != null){
                            gp.obj[mapNum][i].setLoot(gp.entityGenerator.getObject(ds.mapObjectLootNames[mapNum][i]));
                        }
                        gp.obj[mapNum][i].opened = ds.mapObjectOpened[mapNum][i];
                        if(gp.obj[mapNum][i].opened){
                            gp.obj[mapNum][i].down1 = gp.obj[mapNum][i].image2;
                        }
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("Load exception!");
            System.out.println(e);
        }
    }
}
