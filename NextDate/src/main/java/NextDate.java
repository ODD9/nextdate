/**
 * Given a date, the class used to find the next day.
 *
 * @author Restart
 * @version jdk 1.8.0
 *
 */
public class NextDate {
  private int[] days = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};

  /**
   * Process the string and output the nextDate.
   *
   * @param line date string
   * @return Date input incorrectly or output nextDate
   */
  String nextDate(String line) {
    //处理字符串
    line = line.replace('年',',');
    line = line.replace('月',',');
    line = line.replace('日',',');
    String[] str = line.split(",");
    int year = Integer.parseInt(str[0]);
    int month = Integer.parseInt(str[1]);
    int day = Integer.parseInt(str[2]);
    // 判断输入的年份是平年还是闰年
    if (!isLeapYear(year)) {
      days[1] = 28;
    }
    if (isError(year,month,day,days)) {
      return "日期输入错误";
    }
    return date(year,month,day,days);
  }

  /**
   * Judge if the date is incorrect.
   *
   * @param day day
   * @param days days array
   * @param month month
   * @param year year
   * @return checkInput
   */
  private boolean isError(int year, int month, int day,int[] days) {
    boolean checkInput;
    checkInput = year < 1964 || year > 2050 || month < 1 || month > 12 || day < 1
            || day > days[month - 1];
    return checkInput;
  }

  /**
   * Judge if the year of date is leapYear.
   *
   * @param year year
   * @return bool
   */
  private boolean isLeapYear(int year) {
    boolean bool;
    bool = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    return bool;
  }

  /**
   * Output next date.
   *
   * @param year  year
   * @param month month
   * @param day day
   * @param a array
   * @return nextDate
   */
  private String date(int year, int month, int day, int[] a) {
    if (day == a[month - 1]) {
      if (month == 12) {
        return (year + 1) + "年1月1日";
      } else {
        month += 1;
        day = 1;
      }
    } else {
      day += 1;
    }
    return year + "年" + month + "月" + day + "日";
  }
}
