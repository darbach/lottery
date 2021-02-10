package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;

public class Shuffler {

  private final int[] data;
  private final Random rng;

  public Shuffler(int[] data) {
    this(data, new Random()); //chain constructors
  }

  public Shuffler(int[] data, Random rng) { //overloaded, different parameters
    this.data = Arrays.copyOf(data, data.length);
    this.rng = rng;
  }

  public int[] shuffle() {
    return draw(data.length);
  }

  public int[] draw(int size) throws IllegalArgumentException {

    if (size > data.length) {
      throw new IllegalArgumentException();
    }

    for (int i = data.length - 1; i >= data.length - size; i--) {
      int swapTarget = rng.nextInt(i + 1);
      if (swapTarget != i) {
        int temp = data[i];
        data[i] = data[swapTarget];
        data[swapTarget] = temp;
      }
    }

    return Arrays.copyOfRange(data, data.length - size, data.length);
  }
}
