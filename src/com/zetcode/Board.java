package com.zetcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;
    private int score;
    private static int highScore;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    private boolean paused = false;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    private JButton pauseButton;

    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
        addPauseButton();
    }

    private void loadImages() {
        ball = new ImageIcon(getClass().getResource("/resources/dot.png")).getImage();
        apple = new ImageIcon(getClass().getResource("/resources/apple.png")).getImage();
        head = new ImageIcon(getClass().getResource("/resources/head.png")).getImage();
    }

    private void initGame() {
        dots = 3;
        score = 0;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void addPauseButton() {
        pauseButton = new JButton("Pause");
        pauseButton.setBounds(B_WIDTH - 80, B_HEIGHT - 40, 70, 30);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paused = !paused;
                pauseButton.setText(paused ? "Resume" : "Pause");
            }
        });
        setLayout(null);
        add(pauseButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", Font.BOLD, 14));
            g.drawString("Score: " + score, 10, 20);
            g.drawString("High Score: " + highScore, 10, 40);

            if (paused) {
                String pauseMsg = "Game Paused";
                Font small = new Font("Helvetica", Font.BOLD, 14);
                FontMetrics metr = getFontMetrics(small);

                g.setColor(Color.white);
                g.setFont(small);
                g.drawString(pauseMsg, (B_WIDTH - metr.stringWidth(pauseMsg)) / 2, B_HEIGHT / 2);
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over";
        String restartMsg = "Press 'R' to Restart";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(restartMsg, (B_WIDTH - metr.stringWidth(restartMsg)) / 2, (B_HEIGHT / 2) + 20);
    }

    private void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            score += 10;
            if (score > highScore) {
                highScore = score;
            }
            locateApple();
        }
    }

    private void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {
        int r;
        int newAppleX;
        int newAppleY;
        boolean inRestrictedArea;

        do {
            r = (int) (Math.random() * RAND_POS);
            newAppleX = ((r * DOT_SIZE));

            r = (int) (Math.random() * RAND_POS);
            newAppleY = ((r * DOT_SIZE));

            inRestrictedArea = (newAppleX < 80 && newAppleY < 50) || 
                               (newAppleX >= B_WIDTH - 80 && newAppleY >= B_HEIGHT - 40);

        } while (inRestrictedArea);

        apple_x = newAppleX;
        apple_y = newAppleY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame && !paused) {
            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if (key == KeyEvent.VK_P) {
                paused = !paused;
                pauseButton.setText(paused ? "Resume" : "Pause");
            }

            if (key == KeyEvent.VK_R && !inGame) {
                inGame = true;
                initGame();
            }
        }
    }
}
