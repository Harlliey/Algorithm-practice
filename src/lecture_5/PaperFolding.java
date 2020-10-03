package lecture_5;

public class PaperFolding {
    
    public static void paperFolding(int n, int N, boolean concave) {
        if (n > N) return;
        paperFolding(n + 1, N, true);
        System.out.println(concave ? "凹" : "凸");
        paperFolding(n + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        paperFolding(1, N, true);
    }
}