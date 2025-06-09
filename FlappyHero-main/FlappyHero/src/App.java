import controller.GameController;
import model.GameState;
import model.Hero;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Hero"); //Janela Principal

        // Carregar imagens
        Image backgroundImg = new ImageIcon(App.class.getResource("/JogoBG.png")).getImage();
        Image heroImg = new ImageIcon(App.class.getResource("/BonecoJogo.png")).getImage();
        Image topPipeImg = new ImageIcon(App.class.getResource("/toppipe.png")).getImage();
        Image bottomPipeImg = new ImageIcon(App.class.getResource("/bottompipe.png")).getImage();

        GameState state = new GameState();
        Hero hero = new Hero(state.boardWidth / 8, state.boardHeight / 3, 58, 40, heroImg);
        state.hero = hero;

        // Inicializa a variável do painel
        GamePanel panel = new GamePanel(state, backgroundImg);
        new GameController(state, panel, topPipeImg, bottomPipeImg);

        frame.add(panel); // Ativa o Painel
        frame.pack(); // Ajusta o tamanho da tela com o conteudo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha se apertar no X
        frame.setLocationRelativeTo(null); // Centraliza a Janela
        frame.setResizable(false); // Impede de redimencionar a tela
        frame.setVisible(true); // Torna a janela visível
    }
}
