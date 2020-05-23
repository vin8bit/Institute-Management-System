import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Data
{
  String user = "system";
  String pass = "system";
  PreparedStatement stm;
  PreparedStatement preparedStmt;
  
  public Data()
  {
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection localConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", this.user, this.pass);
      String str1 = "CREATE TABLE  LOGIN9 (USER_ID VARCHAR2(100), USER_PASSWORD VARCHAR2(100))";
      this.preparedStmt = localConnection.prepareStatement(str1);
      this.preparedStmt.execute();
      this.stm = localConnection.prepareStatement("insert into login9 values(?,?)");
      this.stm.setString(1, "avsk");
      this.stm.setString(2, "456");
      this.stm.executeUpdate();
      String str2 = "CREATE TABLE  VSTUDENT (ID1 VARCHAR2(150), FNAME VARCHAR2(150), LNAME VARCHAR2(150), FTHNAME VARCHAR2(150), ADD1 VARCHAR2(150), GENDER1 VARCHAR2(150), BIRHT1 VARCHAR2(150), JOIN1 VARCHAR2(150), COURSE1 VARCHAR2(150), PHONE1 VARCHAR2(150), EMAIL1 VARCHAR2(150), CASTE1 VARCHAR2(150), RELIGION1 VARCHAR2(150), NAITIONALITY1 VARCHAR2(150), IDMARK1 VARCHAR2(150), PASS1 VARCHAR2(150))";
      this.preparedStmt = localConnection.prepareStatement(str2);
      this.preparedStmt.execute();
      String str3 = "CREATE TABLE  VSTAFF (ID1 VARCHAR2(150), FNAME VARCHAR2(150), LNAME VARCHAR2(150), FTHNAME VARCHAR2(150), ADD1 VARCHAR2(150), GENDER1 VARCHAR2(150), BIRHT1 VARCHAR2(150), JOIN1 VARCHAR2(150), QUALIFICATION VARCHAR2(150), PHONE1 VARCHAR2(150), EMAIL1 VARCHAR2(150), CASTE1 VARCHAR2(150), RELIGION1 VARCHAR2(150), NAITIONALITY1 VARCHAR2(150), IDMARK1 VARCHAR2(150), PASS1 VARCHAR2(150), DESIGNATION VARCHAR2(150))";
      this.preparedStmt = localConnection.prepareStatement(str3);
      this.preparedStmt.execute();
      String str4 = "CREATE TABLE  VSALARY (ID1 VARCHAR2(150), FNAME1 VARCHAR2(150), LNAME1 VARCHAR2(150), DATE1 VARCHAR2(150), AMOUNT VARCHAR2(150))";
      this.preparedStmt = localConnection.prepareStatement(str4);
      this.preparedStmt.execute();
      
      String str5 = "CREATE TABLE  SACCOUNT (ID1 VARCHAR2(150), FNAME1 VARCHAR2(150), LNAME1 VARCHAR2(150), COURSE1 VARCHAR2(150), PAY1 VARCHAR2(150), MODEPAY1 VARCHAR2(150), AMOUNT VARCHAR2(150))";
      this.preparedStmt = localConnection.prepareStatement(str5);
      this.preparedStmt.execute();
      
      String str6 = "CREATE TABLE  VCOURSE (ID1 VARCHAR2(150), CCODE1 VARCHAR2(150), CNAME VARCHAR2(150), CFEE VARCHAR2(150),CDURATION VARCHAR2(150))";
      this.preparedStmt = localConnection.prepareStatement(str6);
      this.preparedStmt.execute();
      System.out.println("Create Table Success");
    }
    catch (Exception localException)
    {
      System.out.println(localException);
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    new Data();
  }
}
