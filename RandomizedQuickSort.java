/* Example of a Las Vegas Algorithm
* Always gives correct solution, 
* but running time is dependent on the random variable.
*/

import java.util.Random;

public class RandomizedQuickSort {

  public static void main(String[] args) {

    int[] array = {24,2,45,20,56,75,2,56,99,53,12};
    quickSort(array, 0, array.length-1);
    printArray(array);

  }

  public static void printArray(int[] arr) {
    for (int digit : arr) {
      System.out.print(digit + " ");
    }
    System.out.println();
  }

  public static int pickPivot(int low, int high) {
    Random rand = new Random();
    return low + rand.nextInt(high-low+1);
  }

  public static void quickSort(int[] arr, int low, int high) {

    printArray(arr);
    // int pivot = low + (high - low) / 2;
    int pivot = pickPivot(low, high);
    int i = low;
    int j = high;

    System.out.println("pivot: " + arr[pivot]);

    while (i <= j) {
      while (arr[i] < arr[pivot]) {
        i++;
      }

      while (arr[j] > arr[pivot]) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (low < j) {
      quickSort(arr, low, j);
    }
    if (i < high) {
      quickSort(arr, i, high);
    }

  }

}
