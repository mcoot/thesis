package scheduler;
public class WeekDay
{
  private final int value;
  public WeekDay (int val)
  {
    if (val < 0 || val > 4)
    {
      this.value = -1;
    }
    else
    {
      this.value = val;
    }
  }
  public WeekDay (java.lang.String val)
  {
    this.value = valueOf(val);
  }
  public static int valueOf(java.lang.String val)
  {
    java.lang.String uVal = val.toUpperCase();
    if (uVal.equals("MONDAY"))
    {
      return 0;
    }
    else
    if (uVal.equals("TUESDAY"))
    {
      return 1;
    }
    else
    if (uVal.equals("WEDNESDAY"))
    {
      return 2;
    }
    else
    if (uVal.equals("THURSDAY"))
    {
      return 3;
    }
    else
    if (uVal.equals("FRIDAY"))
    {
      return 4;
    }
    else
    {
      return -1;
    }
  }
  public boolean isValidDay()
  {
    return (value >= 0 && value <= 4);
  }
  public boolean equals(java.lang.Object o)
  {
    try
    {
      return value == ((scheduler.WeekDay) o).value;
    }
    catch (java.lang.ClassCastException ex)
    {
      return false;
    }
  }
  public int hashCode()
  {
    return value * 11;
  }
  public java.lang.String toString()
  {
    if (this.value == 0)
    {
      return "MONDAY";
    }
    else
    if (this.value == 1)
    {
      return "TUESDAY";
    }
    else
    if (this.value == 2)
    {
      return "WEDNESDAY";
    }
    else
    if (this.value == 3)
    {
      return "THURSDAY";
    }
    else
    if (this.value == 4)
    {
      return "FRIDAY";
    }
    else
    {
      return "Invalid";
    }
  }
}