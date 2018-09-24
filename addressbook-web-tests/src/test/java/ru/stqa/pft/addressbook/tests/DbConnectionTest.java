package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by 1 on 24.09.2018.
 */
public class DbConnectionTest {

  @Test

  public void testDbConnection() {
    Connection conn = null;

    try {
      conn =
              DriverManager.getConnection("jdbc:mysql://localhost/addressbook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" +
                      "&user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
      Groups groups = new Groups();

      while (rs.next()) {
        groups.add(new GroupData().withId(rs.getInt("group_id"))
                .withName(rs.getString("group_name")).withHeader(rs.getString("group_header")).withFooter(rs.getNString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(groups);

    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
