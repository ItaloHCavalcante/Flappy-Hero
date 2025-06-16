package view;

import model.GameState;
import model.Pipe;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class GamePanel extends JPanel {
    GameState gameState;
    Image backgroundImg;
    Font pressStartFont;

    public GamePanel(GameState gameState, Image backgroundImg) {
        this.gameState = gameState;
        this.backgroundImg = backgroundImg;
        setPreferredSize(new Dimension(gameState.boardWidth, gameState.boardHeight));
        setFocusable(true); // permite foco para eventos de teclado

        // Carrega a fonte Press Start 2P
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf");
            if (is != null) {
                pressStartFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(32f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(pressStartFont);
            } else {
                System.err.println("Fonte não encontrada no caminho especificado.");
                pressStartFont = new Font("Monospaced", Font.PLAIN, 18); // fallback
            }
        } catch (Exception e) {
            e.printStackTrace();
            pressStartFont = new Font("Monospaced", Font.PLAIN, 18); // fallback
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, gameState.boardWidth, gameState.boardHeight, null);
        g.drawImage(gameState.hero.img, gameState.hero.x, gameState.hero.y, gameState.hero.width, gameState.hero.height, null);

        for (Pipe pipe : gameState.pipes) {
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        g.setColor(Color.white);
        g.setFont(pressStartFont);

        if (gameState.gameOver) {
            g.drawString("Game Over: " + (int) gameState.score, 100, 147);
        } else {
            g.drawString(String.valueOf((int) gameState.score), 10, 35);
        }
    }
}
