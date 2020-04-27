public class Computer extends Player {

    public Computer(String token) {

        super("Bit Bucket", token);
    }

    //************ ALGORITHM #4 ***************
    // very basic random move algorithm for now
    // how should the computer decide how to move?
    public int determineMove() {

        int col = (int )(Math.random() * 8);

        return col;

    }

}
