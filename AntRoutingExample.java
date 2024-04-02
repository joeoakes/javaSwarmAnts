import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Ant {
    private int x;
    private int y;
    private int[][] grid;

    public Ant(int x, int y, int[][] grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public void move() {
        List<int[]> neighbors = getNeighbors(x, y, grid.length, grid[0].length);
        int[] nextPosition = pickNextPosition(neighbors);
        this.x = nextPosition[0];
        this.y = nextPosition[1];
    }

    private List<int[]> getNeighbors(int x, int y, int maxX, int maxY) {
        List<int[]> neighbors = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = x + dx;
                int newY = y + dy;
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !(dx == 0 && dy == 0)) {
                    neighbors.add(new int[]{newX, newY});
                }
            }
        }
        return neighbors;
    }

    private int[] pickNextPosition(List<int[]> neighbors) {
        Random rand = new Random();
        int index = rand.nextInt(neighbors.size());
        return neighbors.get(index);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class AntRoutingExample {
    public static void main(String[] args) {
        int[][] grid = new int[10][10]; // Example grid size
        // Set obstacle at (3,3)
        grid[3][3] = 1;

        Ant ant = new Ant(0, 0, grid);
        int steps = 20; // Number of steps the ant will take
        for (int i = 0; i < steps; i++) {
            ant.move();
            System.out.println("Ant moved to: (" + ant.getX() + ", " + ant.getY() + ")");
        }
    }
}
