import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Junit test for nextDate class.
 *
 * @author Restart
 */
@RunWith(Parameterized.class)
public class NextDateTest {
  public String expected;
  public String line;
  NextDate nextDate =  new NextDate();

  /**
   * constructor.
   *
   * @param expected expected
   * @param line data string
   */
  public NextDateTest(String expected,String line) {
    this.expected = expected;
    this.line = line;
  }

  /**
   * data set.
   *
   * @return data set
   */
  @Parameterized.Parameters
  public static Collection<String[]> date() {
    return Arrays.asList(new String[][]{
            {"日期输入错误","2066年13月32日"},
            {"日期输入错误","2000年2月30日"},
            {"2001年3月1日","2001年2月28日"},
            {"2004年2月2日","2004年2月1"},
            {"1999年2月28日","1999年2月27日"},
            {"2000年11月14日","2000年11月13日"},
            {"2002年1月1日","2001年12月31日"},
            {"2001年10月1日","2001年9月30日"}
    });
  }

  /**
   * Test.
   *
   */
  @Test
  public void nextDate() {
    assertEquals(expected,nextDate.nextDate(line));
  }
}
