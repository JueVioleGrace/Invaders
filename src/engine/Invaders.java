package engine;

import screen.*;

import java.util.List;

/**
 * Created by Ryan on 7/28/2015.
 */
public class Invaders {

    /**
     * Start running the game
     */

    public static void run() {

        // Get a list of levels to play
        List<GameSettings> levelSettings = Levels.getLevels();

        // Hold on to all of the game's information
        GameState gameState = new GameState(1, 0, Constants.MAX_LIVES, 0, 0);
        
        // Show Title Screen below this line
        Screen screen = new TitleScreen();
        screen.show();

        ScreenType NextScreenType = screen.getNextScreenType();
        while (NextScreenType != ScreenType.EndGame) {
            if (NextScreenType == ScreenType.TitleScreen) {
                screen = new TitleScreen();
                screen.show();
                NextScreenType = screen.getNextScreenType();
            } else if (NextScreenType == ScreenType.GameScreen) {
                screen = new GameScreen(gameState, levelSettings);
                screen.show();
                NextScreenType = screen.getNextScreenType();
            } else if (NextScreenType == ScreenType.ScoreScreen) {
                screen = new ScoreScreen(gameState);
                screen.show();
                NextScreenType = screen.getNextScreenType();
            } else if (NextScreenType == ScreenType.ScoreScreen) {
                screen = new HighScoreScreen();
                screen.show();
                NextScreenType = screen.getNextScreenType();
            }
        }
    }
}
