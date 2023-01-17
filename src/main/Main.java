package main;

import javax.swing.*;

public class Main {

    public static JFrame window;

    public static void main(String[] args) {
        window = new JFrame();
        window.setUndecorated(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.config.loadConfig();

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}

/*TODO: 1.Develop quest system. 17.01.2023 In progress
   TODO: 2. Fix drawing sort algorithm ( Problem with drawing large entities with small collision area
   TODO: 3. Fix projectiles collision (Do not collide with objects, solid tiles etc).
   TODO: 4. Fix shot cancellation while interacting with objects and npc's. Update: Solved 17.01.2023
   TODO: 5. Fix save and load method (Do not fix the current condition of enemies, npcs,objects etc).
   TODO: 7. Fix pathfinding (Entity does not see high and long objects need to add multiple checkpoints for each object)
   TODO: 8. Develop addiction mechanics.
   TODO: 9. Fix position of light circle while player is near to the edge of the map.
   TODO: 10. Develop multiple lighting system.
   TODO: 11. Add interior objects.
   TODO: 12. Add and fill more levels.
   TODO: 13. Fix attack cancellation with all objects. Update: Solved 17.01.2023
 */

