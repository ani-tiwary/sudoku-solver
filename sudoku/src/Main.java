public class Main {
    public static void main(String[] args) {
        //String input = "ll4l5llll9ll7346llll3l21l49l35l9l48ll9lllll3ll76l1l92l31l97l2llll9182ll3llll6l1ll"; /*easy*/
        //String input = "34ll6l2l92l849lll6llllllllll2l31llllll4lll1llllll25l4llllllllll9lll514l34l3l7ll68"; /*medium*/
        String input = "ll278lll3lllll98l14llll3l7l9l5ll8lllllll7lllllll5ll4l8l6l4llll73l98lllll8lll316ll"; /*hard*/
        SudokuSolver solver = new SudokuSolver();
        String solution = solver.solve(input);
        System.out.println(solution);
    }
}