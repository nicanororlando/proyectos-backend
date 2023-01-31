package com.java.practice.ejercices;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
public class Recursive_Can_Win {

  static class VirtualPlayer {

    private int pos = 0;
    private int leap;
    private int[] game;
    public boolean winnable = false;

    public VirtualPlayer(int leap, int[] game) {
      this.leap = leap;
      this.game = game;
    }

    private void moveUp() {
      if (game[pos + 1] == 0) {
        pos++;
        tick();
      }
    }

    private void jump() {
      if (leap > 0 && game[pos + leap] == 0) {
        int oldPos = pos;
        pos = pos + leap;
        tick();

        /* Si luego de hacer todos los recorridos posibles con el salto que se hizo, y no se pudo ganar, entonces 
        vuelvo a la posicion anterior para seguir probando. */
        pos = oldPos;
      }
    }

    private void moveDown() {
      if ((pos - 1) >= 0 && game[pos - 1] == 0) {
        game[pos] = 1; // Para que luego no deje avanzar.
        pos--;
        tick();
      }
    }

    public void tick() {
      if (pos == (game.length - 1) || (pos + leap) >= game.length) winnable =
        true; else {
        this.moveUp();
        this.jump();
        this.moveDown();
      }
    }
  }

  // Faster and less code, but slower.
  public static boolean canWin1(int leap, int[] game) {
    int i = 0;

    do {
      if (
        (i + leap) >= game.length || i == (game.length) - 1
      ) return true; else if (game[i + 1] != 0 && game[i + leap] != 0) {
        if (i > 0 && game[i - 1] == 0) i--; else return false;
      } else if (game[i + 1] == 0 && game[i + leap] != 0) i++; else if (
        game[i + leap] == 0
      ) i = i + leap; else continue;
    } while (i > 0);

    return false;
  }

  public static boolean canWin2(int leap, int[] game) {
    return true;
  }

  // Recursive form (More faster, but more complex and long code)
  public static boolean canWin3(
    int length,
    int leap,
    int[] game,
    boolean[] visited,
    int curr
  ) {
    if ((curr + leap) >= length || curr == length - 1) return true;

    boolean s = false;

    // 1. Try to go forward, one position.
    // 2. If we can't go forward, try to leap.
    // 3. If neather works, go back.

    // If I visit [curr + 1], then in the next call function I won't be able to visit [curr - 1]
    if (!visited[curr + 1] && game[curr + 1] == 0) {
      visited[curr + 1] = true;
      s = canWin3(length, leap, game, visited, curr + 1);

      if (s) return true;
    }

    if (leap > 1 && !visited[curr + leap] && game[curr + leap] == 0) {
      visited[curr + leap] = true;
      s = canWin3(length, leap, game, visited, curr + leap);

      if (s) return true;
    }

    // If I visit [curr - 1] in the next call function I won't be able to visit [curr + 1]
    if (curr > 0 && !visited[curr - 1] && game[curr - 1] == 0) {
      visited[curr - 1] = true;
      s = canWin3(length, leap, game, visited, curr - 1);
    }

    return s;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      // System.out.println( (canWin1(leap, game) ? "YES" : "NO" );
      // System.out.println( (canWin2(leap, game) ? "YES" : "NO" );
      System.out.println(
        (canWin3(game.length, leap, game, new boolean[game.length], 0))
          ? "YES"
          : "NO"
      );
    }
    scan.close();
  }
}
