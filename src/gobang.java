import java.util.Random;
import java.util.Scanner;

public class gobang {
    public String[] chessBoard = new String[225];

    public gobang() {
        for (int i = 0; i < 225; i++) {
            chessBoard[i] = "+";
        }
        while (true) {
            System.out.println("输入你要下的位置:");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > 15 || y > 15) {
                System.out.println("出界");
                continue;
            }
            if (!this.playMove(x, y)) {
                System.out.println("此处已有棋子");
                continue;
            }
            this.displayChessBoard();
            if (this.whoWin(x, y)) {
                System.out.println("你赢了");
                System.exit(0);
            }
            this.computeMove();
            //System.out.println(x+""+y);
        }
    }

    public boolean whoWin(int x, int y) {
        int wx = 1;
        for (int i = 1; i <= 5; i++) {
            if (x - i <= 0) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1 - i) + y - 1])) {
                wx += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (x + i > 15) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1 + i) + y - 1])) {
                wx += 1;
            } else {
                break;
            }
        }
        if (wx >= 5) {
            return true;
        }
        int wy = 1;
        for (int i = 1; i <= 5; i++) {
            if (y - i <= 0) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1) + y - 1 - i])) {
                wy += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (y + i > 15) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1) + y - 1 + i])) {
                wy += 1;
            } else {
                break;
            }
        }

        if (wy >= 5) {
            return true;
        }
        int wz = 1;
        for (int i = 1; i <= 5; i++) {
            if (x - i <= 0 || y - i <= 0) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1 - i) + y - 1 - i])) {
                wz += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (x + i > 15 || y + i > 15) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1 + i) + y - 1 + i])) {
                wz += 1;
            } else {
                break;
            }
        }
        if (wz >= 5) {
            return true;
        }


        int wyou = 1;
        for (int i = 1; i <= 5; i++) {
            if (x - i <= 0 || y + i > 15) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1 - i) + y - 1 + i])) {
                wyou += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (x + i > 15 || y - i <= 0) {
                break;
            }
            if (chessBoard[15 * (x - 1) + y - 1].equals(chessBoard[15 * (x - 1 + i) + y - 1 - i])) {
                wyou += 1;
            } else {
                break;
            }
        }
        return wyou >= 5;
    }

    public boolean playMove(int x, int y) {
        if (chessBoard[15 * (x - 1) + y - 1].equals("+")) {
            chessBoard[15 * (x - 1) + y - 1] = "●";
            return true;
        } else {
            return false;
        }
    }

    public void computeMove() {
        while (true) {
            Random random = new Random();
            int x = random.nextInt(15)+1;
            int y = random.nextInt(15)+1;
            //System.out.println(x+""+y);
            if (chessBoard[15 * (x - 1) + y - 1].equals("+")) {
                System.out.println("电脑下" + x + "  " + y);
                chessBoard[15 * (x - 1) + y - 1] = "○";
                this.displayChessBoard();
                if (this.whoWin(x, y)) {
                    System.out.println("电脑赢了");
                    System.exit(0);
                }
                break;
            }
        }
    }

    public void displayChessBoard() {
        for (int i = 1; i <= 225; i++) {
            System.out.print(chessBoard[i - 1] + "  ");
            if (i % 15 == 0) {
                System.out.println();
            }
        }
    }


}
