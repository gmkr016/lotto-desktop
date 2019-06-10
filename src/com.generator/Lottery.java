package generator;

import java.util.Random;

public class Lottery {


    static int[] gen;
    static int[] newgen;
    static Random random;
    public static void main(String args[]) {
        generateFinalSequence();
    }

    private static int[] generate() {
        gen = new int[6];
        random = new Random();
        int rand_num;
        for (int i = 0; i < 6; i++) {
            rand_num = random.nextInt(46)+1;
            gen[i] = rand_num;
        }
        return gen;

    }

    private static int[] changeIfRepeated(int array[])
    {
        for(int x = 0; x < array.length; x++) {
            for(int y=x+1; y<array.length; y++) {
                if(array[x] == array[y]) {
                    array[x] = random.nextInt(46)+1;
                }
            }
        }
        return array;
    }

    public static int[] generateFinalSequence(){
        newgen = changeIfRepeated(generate());
        return newgen;
    }
}
