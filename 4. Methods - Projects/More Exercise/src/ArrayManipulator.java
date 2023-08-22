import java.util.Arrays;
import java.util.Scanner;
public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputAsStr = input.split(" ");
            String command = inputAsStr[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(inputAsStr[1]);
                    if (index > numbers.length) {
                        System.out.println("Invalid index");
                    } else {
                        exchangeIndexesOfArray(index, numbers);
                    }
                    break;
                case "max":
                    if (inputAsStr[1].equals("odd")) {
                        getMaxOddIndex(numbers);
                    } else if (inputAsStr[1].equals("even")) {
                        getMaxEvenIndex(numbers);
                    }
                    break;
                case "min":
                    if (inputAsStr[1].equals("odd")) {
                        getMinOddIndex(numbers);
                    } else if (inputAsStr[1].equals("even")) {
                        getMinEvenIndex(numbers);
                    }
                    break;
                case "first":
                    int countOfFirst = Integer.parseInt(inputAsStr[1]);
                    if (inputAsStr[2].equals("odd")) {
                        getFirstOddNelements(countOfFirst, numbers);
                    } else if (inputAsStr[2].equals("even")) {
                        getFirstEvenNelements(countOfFirst, numbers);
                    }
                    break;
                case "last":
                    int countOfLast = Integer.parseInt(inputAsStr[1]);
                    if (inputAsStr[2].equals("odd")) {
                        getLastOddNelements(countOfLast, numbers);
                    } else if (inputAsStr[2].equals("even")) {
                        getLastEvenNelements(countOfLast, numbers);
                    }
                    break;
            }

            input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println(Arrays.toString(numbers));
            }
        }

    }

    public static void exchangeIndexesOfArray(int index, int[] array) {
        int[] temp = new int[index + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= array.length - temp.length) {
                array[i] = temp[j];
                j++;
                if (j == index + 1) {
                    break;
                }
            } else {
                array[i] = array[i + temp.length]; }
        }

    }

    public static void getMaxOddIndex(int[] array) {
        int maxOdd = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number % 2 != 0) {
                if (number >= maxOdd) {
                    maxOdd = number;
                    index = i;
                }
            }
        }

        if (maxOdd == Integer.MIN_VALUE) {
            System.out.println("No matches");
            return;
        }

        System.out.println(index);
    }

    public static void getMinOddIndex(int[] array) {
        int minOdd = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number % 2 != 0) {
                if (number <= minOdd) {
                    minOdd = number;
                    index = i;
                }
            }
        }

        if (minOdd == Integer.MAX_VALUE) {
            System.out.println("No matches");
            return;
        }

        System.out.println(index);
    }

    public static void getMaxEvenIndex(int[] array) {
        int maxEven = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number % 2 == 0) {
                if (number >= maxEven) {
                    maxEven = number;
                    index = i;
                }
            }
        }

        if (maxEven == Integer.MIN_VALUE) {
            System.out.println("No matches");
            return;
        }

        System.out.println(index);
    }

    public static void getMinEvenIndex(int[] array) {
        int minEven = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            if (number % 2 == 0) {
                if (number <= minEven) {
                    minEven = number;
                    index = i;
                }
            }
        }

        if (minEven == Integer.MAX_VALUE) {
            System.out.println("No matches");
            return;
        }

        System.out.println(index);
    }

    public static void getFirstOddNelements (int count, int[] array) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] newArray = new int[count];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1 && count > j) {
                    int[] newestArray = new int[j];
                    for (int k = 0; k < newestArray.length; k++) {
                        newestArray[k] = newArray[k];
                    }
                    newArray = newestArray;
                    break;
                }
            int number = array[i];
            if (number % 2 != 0) {
                newArray[j] = number;
                j++;
                if (j == newArray.length) {
                    break;
                }

            }
        }

        if (j == 0) {
            System.out.print("[]\n");
            return;
        }

        System.out.println(Arrays.toString(newArray));
    }

    public static void getLastOddNelements(int count, int[] array) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] newArray = new int[count];
        int j = 0;
        for (int i = array.length; i >= 0; i--) {
            if (i == 0) {
                break;
            }
            if (i == 0 && count > j) {
                    int[] newestArray = new int[j];
                    for (int k = 0; k < newestArray.length; k++) {
                        newestArray[k] = newArray[k];
                    }
                    newArray = newestArray;
                    break;
            }
            int number = array[i - 1];
            if (number % 2 != 0) {
                newArray[j] = number;
                j++;
                if (j == newArray.length) {
                    break;
                }

            }
        }

        if (j == 0) {
            System.out.print("[]\n");
            return;
        } else if (j == 1) {
            System.out.println("[" + newArray[0] + "]");
            return;
        }

        int[] reversed = new int[newArray.length];
        int l = newArray.length - 1;
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = newArray[l];
            l--;
            if (l < 0) {
                break;
            }
        }

        System.out.println(Arrays.toString(reversed));
    }

    public static void getFirstEvenNelements (int count, int[] array) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] newArray = new int[count];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1 && count > j) {
                int[] newestArray = new int[j];
                for (int k = 0; k < newestArray.length; k++) {
                    newestArray[k] = newArray[k];
                }
                newArray = newestArray;
                break;
            }
            int number = array[i];
            if (number % 2 == 0) {
                newArray[j] = number;
                j++;
                if (j == newArray.length) {
                    break;
                }

            }
        }

        if (j == 0) {
            System.out.print("[]\n");
            return;
        }

        System.out.println(Arrays.toString(newArray));
    }

    public static void getLastEvenNelements(int count, int[] array) {
        if (count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] newArray = new int[count];
        int j = 0;
        for (int i = array.length; i >= 0; i--) {
            if (i == 0) {
                break;
            }
            if (i == 1 && count > j) {
                int[] newestArray = new int[j];
                for (int k = 0; k < newestArray.length; k++) {
                    newestArray[k] = newArray[k];
                }
                newArray = newestArray;
                break;
            }
            int number = array[i - 1];
            if (number % 2 == 0) {
                newArray[j] = number;
                j++;
                if (j == newArray.length) {
                    break;
                }

            }
        }

        if (j == 0) {
            System.out.print("[]\n");
            return;
        } else if (j == 1) {
            System.out.print("[" + newArray[0] + "]");
            return;
        }

        int[] reversed = new int[newArray.length];
        int l = newArray.length - 1;
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = newArray[l];
            l--;
            if (l < 0) {
                break;
            }
        }

        System.out.println(Arrays.toString(reversed));
    }
}