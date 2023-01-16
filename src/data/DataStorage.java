package data;

import entity.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable {

    //PLAYER STATUS

    int level;
    int maxLife;
    int life;
    int maxPistolAmmo;
    int maxShotgunAmmo;
    int pistolAmmo;
    int shotgunAmmo;
    int strength;
    int dexterity;
    int exp;
    int nextLevelExp;
    int money;
    int worldX;
    int worldY;
    int currentMap;
    int currentArea;
    int currentMusic;
    //Player inventory

    ArrayList <String> itemNames = new ArrayList<>();
    ArrayList<Integer> itemAmounts = new ArrayList<>();
    int currentWeaponSlot;
    int currentArmorSlot;
    int currentShieldSlot;

    //OBJECTS ON MAP

    String[][] mapObjectsName;
    int [][] mapObjectWorldX;
    int [][] mapObjectWorldY;
    String [][] mapObjectLootNames;
    boolean [][] mapObjectOpened;

}
