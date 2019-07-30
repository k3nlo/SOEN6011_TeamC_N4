import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class CalculatorTest extends TestCase {

  /* requirement F4.v1 function selection */
  @Test
  public void testFunctionSelection() {
    Calculator tester = new Calculator();
    int number = 1;
    String input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("select function input = " + input);
    int result = tester.getChoice();
    assertEquals(result, number);
  }

  /* requirement F4.1v1 logarithm base initialization */
  @Test
  public void setBaseValue() {
    Calculator tester = new Calculator();
    double number = 2;
    String input = "2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("base input = " + input);
    double result = tester.getBase();
    assertEquals(result, number);
  }

  /* requirement F4.2v1 logarithm base validation */
  @Test
  public void baseNotNegative() {
    Calculator tester = new Calculator();
    double number = -2;
    String input = "-2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("base input = " + input);
    double result = tester.getBase();
    assertNotEquals(result, number);
  }

  /* requirement F4.2v1 logarithm base validation */
  @Test
  public void baseNotZero() {
    Calculator tester = new Calculator();
    double number = 0;
    String input = "0";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("base input = " + input);
    double result = tester.getBase();
    assertNotEquals(result, number);
  }

  /* requirement F4.2v1 logarithm base validation */
  @Test
  public void baseNotOne() {
    Calculator tester = new Calculator();
    double number = 1;
    String input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("base input = " + input);
    double result = tester.getBase();
    assertNotEquals(result, number);
  }

  /* requirement F4.2v1 logarithm base validation */
  @Test
  public void baseMustBeNumber() {
    Calculator tester = new Calculator();
    String input = "abc";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("base input = " + input);
    double result = tester.getBase();
    assertNotEquals(result, input);
  }

  /* requirement F4.3v1 logarithm variable initialization */
  @Test
  public void setVariableValue() {
    Calculator tester = new Calculator();
    double number = 4;
    String input = "4";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("variable input = " + input);
    double result = tester.getVariable();
    assertEquals(result, number);
  }

  /* requirement F4.4v1 logarithm variable validation */
  @Test
  public void variableNotNegative() {
    Calculator tester = new Calculator();
    double number = -2;
    String input = "-2";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("variable input = " + input);
    double result = tester.getVariable();
    assertNotEquals(result, number);
  }

  /* requirement F4.4v1 logarithm variable validation */
  @Test
  public void variableNotZero() {
    Calculator tester = new Calculator();
    double number = 0;
    String input = "0";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    System.out.println("variable input = " + input);
    double result = tester.getVariable();
    assertNotEquals(result, number);
  }

  /* requirement F4.5v1 logarithm calculation */
  @Test
  public void calculateLogarithm() {
    Calculator tester = new Calculator();
    double base = 10;
    double variable = 25;
    final double DELTA = 1e-7;
    System.out.println("log_"+base+"("+variable+"): ");
    double result = tester.log(base, variable);
    System.out.println("result = "+result);
    double java_result = Math.log10(variable);
    System.out.println("java_result = "+java_result);
    System.out.println("precision = "+DELTA);
   assertEquals(java_result, result, DELTA);
  }


}

