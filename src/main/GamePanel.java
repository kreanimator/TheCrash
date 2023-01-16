package main;

import ai.PathFinder;
import data.SaveLoad;
import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile_interactive.InteractiveTile;
import tiles.Map;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //48 x 48 tile
    //How many tiles will be displayed on the screen
    public final int maxScrCol = 22;
    public final int maxScrRow = 14;
    public final int screenWidth = maxScrCol * tileSize;
    public final int screenHeight = maxScrRow * tileSize;

    //WORLD SETTINGS

    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
    public final int maxMap = 10;
    public int currentMap = 0;
    //FOR FULL SCREEN

    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    //    BufferedImage tempScreen;
//    Graphics2D g2;
    boolean fullScreenOn = false;

    //FPS
    int FPS = 60;

    //SYSTEM
    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    Map map = new Map(this);
    SaveLoad saveLoad = new SaveLoad(this);

    public CollisionDetector cDetector = new CollisionDetector(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Config config = new Config(this);
    public EntityGenerator entityGenerator = new EntityGenerator(this);
    Thread gameThread;
    public PathFinder pFinder = new PathFinder(this);
    public EnvironmentManager eManager = new EnvironmentManager(this);
    public CutSceneManager cutSceneManager = new CutSceneManager(this);

    //ENTITY AND OBJECTS
    public Player player = new Player(this, keyH);
    public Entity[][] obj = new Entity[maxMap][500];
    public Entity[][] npc = new Entity[maxMap][500];
    public Entity[][] enemy = new Entity[maxMap][500];
    public InteractiveTile[][] iTile = new InteractiveTile[maxMap][200];
    public Entity[][] projectile = new Entity[maxMap][20];
    //    public ArrayList <Entity> projectilesList = new ArrayList<>();
    public ArrayList<Entity> particleList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE

    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogState = 3;
    public final int charState = 4;
    public final int optionsState = 5;
    public final int gameOverState = 6;
    public final int transitionState = 7;
    public final int tradeState = 8;
    public final int sleepState = 9;
    public final int mapState = 10;
    public final int cutSceneState = 11;
    public final int questState = 12;

    //OTHERS
    public boolean bossBattleOn = false;

    //AREA

    public int currentArea;
    public int nextArea;
    public final int outside = 50;
    public final int indoor = 51;
    public final int cave = 52;
    public final int bunker = 53;
    public int currentMusic;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {
        aSetter.setObject();
        aSetter.setNPC();
        eManager.setup();
        aSetter.setEnemy();
        aSetter.setInteractiveTile();


        // playMusic(0);
        gameState = titleState;
        currentArea = outside;
        if (fullScreenOn) {
            setFullScreen();
        }


    }

    public void resetGame(boolean restart) {
        //currentArea = outside;
        player.setDefaultPositions();
        removeTempEntity();
        bossBattleOn =false;
        player.restoreStatus();
        aSetter.setNPC();
        player.resetCounters();
        aSetter.setEnemy();
        if (restart) {
            player.setDefaultValues();
            aSetter.setObject();
            aSetter.setInteractiveTile();
            eManager.lighting.resetDay();
        }

    }

    public void setFullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;//0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;


        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
//            1.UPDATE: information such as characters position
                update();
//            2.DRAW: draw the screen with the updated information
                repaint();

                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }

        }

    }

    public void update() {

        if (gameState == playState) {
            //PLAYER
            player.update();

            //NPC

            for (int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null) {
                    npc[currentMap][i].update();
                }
            }

            //ENEMIES
            for (int i = 0; i < enemy[1].length; i++) {
                if (enemy[currentMap][i] != null) {
                    if (enemy[currentMap][i].alive && !enemy[currentMap][i].dying) {
                        enemy[currentMap][i].update();
                    }
                    if (!enemy[currentMap][i].alive) {
                        enemy[currentMap][i].checkDrop();
                        enemy[currentMap][i] = null;
                    }
                }
            }

            //PROJECTILES

            for (int i = 0; i < projectile[1].length; i++) {
                if (projectile[currentMap][i] != null) {
                    if (projectile[currentMap][i].alive) {
                        projectile[currentMap][i].update();
                    }
                    if (!projectile[currentMap][i].alive) {
                        projectile[currentMap][i] = null;
                    }
                }
            }
            //PARTICLES
            for (int i = 0; i < particleList.size(); i++) {
                if (particleList.get(i) != null) {
                    if (particleList.get(i).alive) {
                        particleList.get(i).update();
                    }
                    if (!particleList.get(i).alive) {
                        particleList.remove(i);
                    }
                }
            }
            for (int i = 0; i < iTile[1].length; i++) {
                if (iTile[currentMap][i] != null) {
                    iTile[currentMap][i].update();
                }
            }


            //LIGHT
            eManager.update();

        }
        if (gameState == pauseState) {


        }


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //DEBUG

        long drawStart = 0;
        if (keyH.checkDrawTime) {
            drawStart = System.nanoTime();
        }


        //TITLE SCREEN

        if (gameState == titleState) {
            ui.draw(g2);
        }
        //MAP

        else if (gameState == mapState) {
            map.drawFullMap(g2);
        }
        //OTHERS
        else {


            // TILE
            tileM.draw(g2);


            //INTERACTIVE TILE
            for (int i = 0; i < iTile[1].length; i++) {
                if (iTile[currentMap][i] != null) {
                    iTile[currentMap][i].draw(g2);
                }
            }

            //ADD ENTITIES TO THE LIST
            entityList.add(player);
            for (int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null) {
                    entityList.add(npc[currentMap][i]);
                }
            }
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null) {
                    entityList.add(obj[currentMap][i]);
                }
            }
            for (int i = 0; i < enemy[1].length; i++) {
                if (enemy[currentMap][i] != null) {
                    entityList.add(enemy[currentMap][i]);
                }
            }
            for (int i = 0; i < projectile[1].length; i++) {
                if (projectile[currentMap][i] != null) {
                    entityList.add(projectile[currentMap][i]);
                }
            }
            for (int i = 0; i < particleList.size(); i++) {
                if (particleList.get(i) != null) {
                    entityList.add(particleList.get(i));
                }
            }
            // SORT
            entityList.sort(Comparator.comparingInt(o -> o.worldY));
            //The old code that Intellij changed to comparator
//            entityList.sort((o1, o2) -> {
//                int result = Integer.compare(o1.worldY, o2.worldY);
//                return result;
//            });
            //DRAW ENTITIES

            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            // EMPTY ENTITY LIST
            entityList.clear();



            //Environment
            eManager.draw(g2);

            //MINIMAP
            map.drawMiniMap(g2);





            //UI
            ui.draw(g2);
            //CUTSCENE MANAGER
            cutSceneManager.draw(g2);
        }

        if (keyH.checkDrawTime) {

            long drawFinish = System.nanoTime();
            long passed = drawFinish - drawStart;
            long x = player.worldX / tileSize;
            long y = player.worldY / tileSize;
            g2.setColor(Color.WHITE);
            g2.drawString("Draw string: " + passed, 10, 400);
            g2.drawString("Player X = " + x, 10, 448);
            g2.drawString("Player Y = " + y, 10, 496);
            System.out.println("Draw time " + passed);
        }
        g2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public int getCurrentMusic(){
        if (currentArea == outside){
            currentMusic = 0;
        } else if (currentArea == cave) {
            currentMusic = 22;
        }else if (currentArea == bunker) {
            currentMusic = 27;
        }
        return currentMusic;

    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }
    public void changeArea(){

//        if(nextArea != currentArea){
//            stopMusic();
//            if(nextArea == outside){
//                playSE(0);
//            }
//            if(nextArea == cave){
//                playSE(22);
//            }
//            if(nextArea == outside){
//                playSE(27);
//            }
//        }

        currentArea = nextArea;
        aSetter.setEnemy();
    }
    public void removeTempEntity(){
        for(int mapNum = 0; mapNum < maxMap; mapNum++){
            for (int i =0; i < obj[1].length; i++){
                if(obj[mapNum][i]!= null && obj[mapNum][i].temp){
                    obj[mapNum][i] = null;

                }

            }
        }
    }
}
