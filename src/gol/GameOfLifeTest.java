package gol;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeTest {

    @Test
    public void cellsCanBeMarkedAlive() {
        Game game = new Game();

        game.markAlive(0, 0);

        assertThat(game.isAlive(0, 0), is(true));
        assertThat(game.isAlive(1, 0), is(false));
    }

    @Test
    public void asStringHelperMethodConvertsGameToString() {
        Game game = new Game();

        game.markAlive(0, 0);
        game.markAlive(1, 2);

        int rows = 2;
        int cols = 3;

        assertThat(asString(game, rows, cols), is("X--" + "\n"
                                                + "--X"));
    }

    @Test
    public void getGameHelperMethodConvertsStringToGame() {
        Game game = getGame("-X",
                            "X-");

        assertThat(game.isAlive(0, 0), is(false));
        assertThat(game.isAlive(0, 1), is(true));

        assertThat(game.isAlive(1, 0), is(true));
        assertThat(game.isAlive(1, 1), is(false));
    }

    @Test
    public void canToggleCellState() {
        Game game = new Game();

        assertThat(game.isAlive(0, 0), is(false));

        game.toggle(0, 0);

        assertThat(game.isAlive(0, 0), is(true));

        game.toggle(0, 0);

        assertThat(game.isAlive(0, 0), is(false));
    }

    @Test
    public void gameKnowsNeighbourCounts() {
        Game game = getGame("XXX",
                            "-X-",
                            "--X");

        assertThat(game.getNeighbourCount(0, 0), is(2));
        assertThat(game.getNeighbourCount(0, 1), is(3));
        assertThat(game.getNeighbourCount(0, 2), is(2));

        assertThat(game.getNeighbourCount(1, 0), is(3));
        assertThat(game.getNeighbourCount(1, 1), is(4));
        assertThat(game.getNeighbourCount(1, 2), is(4));

        assertThat(game.getNeighbourCount(2, 0), is(1));
        assertThat(game.getNeighbourCount(2, 1), is(2));
        assertThat(game.getNeighbourCount(2, 2), is(1));
    }

    @Test
    public void gameKnowsTheRules() {
        Game game = new Game();

        assertThat(game.nextState(true, 1), is(false));
        assertThat(game.nextState(true, 2), is(true));
        assertThat(game.nextState(true, 3), is(true));
        assertThat(game.nextState(true, 4), is(false));

        assertThat(game.nextState(false, 1), is(false));
        assertThat(game.nextState(false, 2), is(false));
        assertThat(game.nextState(false, 3), is(true));
        assertThat(game.nextState(false, 4), is(false));
    }

    @Test
    public void blinkerWorksCorrectly() {
        Game game = getGame("---",
                            "XXX",
                            "---");
        game.nextFrame();

        assertThat(asString(game, 3, 3), is("-X-" + "\n"
                                          + "-X-" + "\n"
                                          + "-X-"));
    }

    private String asString(Game game, int rows, int columns) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            if (row > 0) {
                builder.append("\n");
            }

            for (int col = 0; col < columns; col++) {
                String symbol = game.isAlive(row, col) ? "X" : "-";
                builder.append(symbol);
            }

        }
        return builder.toString();
    }

    private Game getGame(String ... rows) {

        Game game = new Game();
        for (int row = 0; row < rows.length; row++) {
            for (int col = 0; col < rows[0].length(); col++) {
                String symbol = String.valueOf(rows[row].charAt(col));
                if ("X".equals(symbol)) {
                    game.markAlive(row, col);
                }
            }
        }

        return game;
    }
}