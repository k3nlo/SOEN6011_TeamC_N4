import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    // initialization
    int choice = -1;
    while (choice != 0) {
      choice = getChoice();

      if (choice == 1) {

        double variable = Double.NaN;
        double base = Double.NaN;

        do {
          base = getBase();

        } while (Double.isNaN(base));

        do {
          variable = getVariable();

        } while (Double.isNaN(variable));

        System.out.println("base = " + base + "; x = " + variable);
        double result = log(base, variable);
        System.out.println("log_" + base + "(" + variable + ") = " + result + "\n");
      }

      if (choice != 0 && choice != 1) {
        System.out.println("Chosen function is not available. Please try again.\n");
      }

      if (choice == 0) {
        System.out.println("Goodbye!");
      }
    }
  }

  /** @return valid choice */
  public static int getChoice() {
    int input = -1;
    System.out.println("Available Functions:");
    System.out.println("0: exit");
    System.out.println("1: log_b(x)");

    System.out.println("Enter the index of the function you would like to use:");
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextInt()) {
      input = scanner.nextInt();
    }
    return input;
  }

  public static double getBase() {
    double input = Double.NaN;
    try {
      System.out.println("Input a logarithm base:");
      Scanner scanner = new Scanner(System.in);
      if (scanner.hasNextDouble()) {
        input = scanner.nextDouble();

        if (input < 0) {
          input = Double.NaN;
          throw new IllegalArgumentException(
              "The base of a logarithm must " + "be positive. Please try again.");
        }

        if (input == 0 || input == 1) {
          input = Double.NaN;
          throw new IllegalArgumentException(
              "The base of a logarithm must not be equal to 0 or 1." + " Please try again.");
        }
      } else {
        input = Double.NaN;
        throw new IllegalArgumentException(
            "The base of a logarithm must be a real number. Please try again.");
      }

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return input;
  }

  public static double getVariable() {
    double input = Double.NaN;
    try {

      System.out.println("Input the variable x value:");
      Scanner scanner = new Scanner(System.in);
      if (scanner.hasNextDouble()) {
        input = scanner.nextDouble();

        if (input < 0 || input == 0) {
          input = Double.NaN;
          throw new IllegalArgumentException(
              "The logarithm function is only defined for x within ]0;+\u221e]. Please try again.");
        }

      } else {
        input = Double.NaN;
        throw new IllegalArgumentException(
            "The variable for a logarithm must be a real number. Please try again.");
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    return input;
  }

  public static double log(double base, double x) {
    double result = 0;
    result = ln(x) / ln(base);
    return result;
  }

  public static double ln(double x) {
    double result = 0;
    double n = 100000000.0; // for increased precision
    double exponent = 1 / n;
    result = n * (power(x, exponent) - 1);
    //    result = power(x, y);
    return result;
  }

  // reference for square and power functions:
  // https://stackoverflow.com/questions/3518973/doubleing-point-exponentiation-without-power-function
  static double square(double x) {
    return x * x;
  }
  // meaning of 'precision': the returned answer should be base^x, where
  //                         x is in [power-precision/2,power+precision/2]
  static double power(double base, double power, double precision) {
    if (power < 0) return 1 / power(base, -power, precision);
    if (power >= 10) return square(power(base, power / 2, precision / 2));
    if (power >= 1) return base * power(base, power - 1, precision);
    if (precision >= 1) return sqrt(base);
    return sqrt(power(base, power * 2, precision * 2));
  }

  static double power(double base, double power) {
    return power(base, power, .0000000000000001);
  }
  // reference for square root function:
  // https://rekinyz.wordpress.com/2015/01/20/implement-simple-sqrt-with-java/
  static double sqrt(double x) {
    if (x == 0) return 0;
    double last = 0.0;
    double res = 1.0;
    while (res != last) {
      last = res;
      res = (res + x / res) / 2;
    }
    return res;
  }
}
