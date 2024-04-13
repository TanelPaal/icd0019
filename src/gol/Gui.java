package gol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Gui {

    private static final int MARGIN = 80;
    private static final int CELL_SIZE = 40;
    private static final int NEXT_FRAME_DELAY = 500;

    private final int columns;
    private final int rows;
    private final Game game;

    private boolean isRunning = false;

    private final JFrame frame = new JFrame();

    public Gui(int columns, int rows, Game game) {
        this.columns = columns;
        this.rows = rows;
        this.game = game;
    }

    public void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Game of Life");

        int width = this.columns * CELL_SIZE + MARGIN * 2;
        int height = this.rows * CELL_SIZE + MARGIN * 3;

        frame.setBounds(500, 200, width, height);

        Timer timer = new Timer(NEXT_FRAME_DELAY, event -> nextFrame());
        JButton startButton = new JButton("Start");
        JButton nextButton = new JButton("Next frame");
        JButton clearButton = new JButton("Clear");
        startButton.addActionListener(e -> togglePlay(timer, startButton));
        nextButton.addActionListener(e -> nextFrame());
        clearButton.addActionListener(e -> clear());

        JPanel panel = new JPanel();
        panel.add(nextButton);
        panel.add(clearButton);
        panel.add(startButton);

        Board board = new Board();
        board.addMouseListener(new MouseListener(this));

        frame.add(panel, BorderLayout.PAGE_START);
        frame.add(board, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void nextFrame() {
        game.nextFrame();

        frame.repaint();
    }

    private void clear() {
        game.clear();

        frame.repaint();
    }

    private void togglePlay(Timer timer, JButton button) {
        isRunning = !isRunning;

        if (isRunning) {
            button.setText("Stop");
            timer.start();
        } else {
            button.setText("Start");
            timer.stop();
        }
    }

    @SuppressWarnings("PMD")
    private class Board extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            Graphics2D g = (Graphics2D) graphics;

            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    boolean isAlive = game.isAlive(row, column);

                    drawCell(row, column, isAlive, g);
                }
            }
        }

        private void drawCell(int row, int column, boolean isAlive, Graphics2D g) {

            Point coordinates = cellToPixels(row, column);

            Shape shape = new Rectangle2D.Float(
                    coordinates.x, coordinates.y,
                    CELL_SIZE, CELL_SIZE);
            g.setStroke(new BasicStroke(1));

            g.setPaint(isAlive ? Color.black : Color.white);
            g.fill(shape);
            g.setPaint(Color.black);
            g.draw(shape);
        }

        private Point cellToPixels(int row, int column) {
            int offsetX = column * CELL_SIZE;
            int offsetY = row * CELL_SIZE;

            return new Point(MARGIN + offsetX, MARGIN + offsetY);
        }
    }

    private class MouseListener extends MouseAdapter {

        private final Gui gui;

        public MouseListener(Gui gui) {
            this.gui = gui;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getX() < MARGIN || e.getY() < MARGIN) {
                return;
            }

            int x = (e.getY() - MARGIN) / CELL_SIZE;
            int y = (e.getX() - MARGIN) / CELL_SIZE;

            if (x < gui.rows && y < gui.columns) {
                gui.game.toggle(x, y);

                frame.repaint();
            }
        }
    }
}