package solutions;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-snake-game/
 *
 * Design a Snake game that is played on a device with screen size =
 * width x height. Play the game online if you are not familiar with
 * the game.
 * The snake is initially positioned at the top left corner (0,0) with
 * length = 1 unit.
 * You are given a list of food's positions in row-column order. When
 * a snake eats the food, its length and the game's score both increase
 * by 1.
 * Each food appears one by one on the screen. For example, the second
 * food will not appear until the first food was eaten by the snake.
 * When a food does appear on the screen, it is guaranteed that it will
 * not appear on a block occupied by the snake.
 *
 * Example:
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 *
 * Snake snake = new Snake(width, height, food);
 *
 * Initially the snake appears at position (0,0) and the food at (1,2).
 *
 * |S| | |
 * | | |F|
 *
 * snake.move("R"); -> Returns 0
 *
 * | |S| |
 * | | |F|
 *
 * snake.move("D"); -> Returns 0
 *
 * | | | |
 * | |S|F|
 *
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right
 *                     after that, the second food appears at (0,1) )
 *
 * | |F| |
 * | |S|S|
 *
 * snake.move("U"); -> Returns 1
 *
 * | |F|S|
 * | | |S|
 *
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 *
 * | |S|S|
 * | | |S|
 *
 * snake.move("U"); -> Returns -1 (Game over because snake collides with
 *                     border)
 */
public class DesignSnakeGame_353 {

    public class SnakeGame {
        private int width, height, p;
        private LinkedList<Integer> snake;
        private int[][] food;

        /** Initialize your data structure here.
            @param width - screen width
            @param height - screen height 
            @param food - A list of food positions
            E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int w, int h, int[][] f) {
            width = w; height = h;
            snake = new LinkedList<>();
            snake.add(0);
            food = f; p = 0;
        }
        
        /** Moves the snake.
            @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
            @return The game's score after the move. Return -1 if game over. 
            Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int head = snake.peek();
            int tail = snake.removeLast();
            int r = head / width, c = head % width;
            switch (direction) {
                case "U": --r; break;
                case "D": ++r; break;
                case "L": --c; break;
                case "R": ++c; break;
            }
            if (r < 0 || r >= height || c < 0 || c >= width || snake.contains(r * width + c)) return -1;
            snake.addFirst(r * width + c);
            if (p < food.length && food[p][0] == r && food[p][1] == c) {
                snake.add(tail);
                ++p;
            }
            return snake.size() - 1;
        }
    }

    /**
     * Your SnakeGame object will be instantiated and called as such:
     * SnakeGame obj = new SnakeGame(width, height, food);
     * int param_1 = obj.move(direction);
     */
}
