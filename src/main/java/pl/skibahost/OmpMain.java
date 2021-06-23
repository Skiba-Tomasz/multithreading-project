package pl.skibahost;

public class OmpMain {

    public static void main(String[] args){

        // omp parallel for
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }

        System.out.println("last line");
    }
}
