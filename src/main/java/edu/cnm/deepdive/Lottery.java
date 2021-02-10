package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Lottery {

  public static void main(String[] args) {
    //size of data, number of draws, number of times
    int poolSize = Integer.parseInt(args[0]);
    int drawSize = Integer.parseInt(args[1]);
    int drawCount = Integer.parseInt(args[2]);

    int[] pool = Lottery.getPool(poolSize);      //create our pool of numbers
    Random rng = new SecureRandom();             //high quality pseudo-rng
    Shuffler shuffler = new Shuffler(pool, rng); //the engine that will run our lottery

    //TODO repeat count times:
    //  Get & print draw number of items from shuffler
    for (int i = 0; i < drawCount; i++) {
      int[] draw = shuffler.draw(drawSize);
      Arrays.sort(draw);
      System.out.println(Arrays.toString(draw));
    }
  }

  private static int[] getPool(int size) {
    int[] pool = new int[size];
    for (int i = 0; i < pool.length - 1; i++) {
      pool[i] = i + 1;
    }
    return pool;
  }
}
