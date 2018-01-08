package pl.dominisz;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
public class Sumator implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        //Da się bez pętli :-)
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println("suma " + sum);
    }

}
