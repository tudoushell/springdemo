import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author: elliot
 * @Date: 2020/11/8
 */
public class Test {

  @org.junit.Test
  public void test() {
    SpelExpressionParser spl = new SpelExpressionParser();
    Expression expression = spl.parseExpression("1+1");
    System.out.println(expression.getValue());
  }
}
