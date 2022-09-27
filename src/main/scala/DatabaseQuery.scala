package jdbc

import java.sql.DriverManager
import java.sql.Connection

object DatabaseQuery{

  def main(args: Array[String]): Unit = {
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/test"
    val username = "root"
    val password = "root"

    //val connection:Connection = null

    try {
      Class.forName(driver)
      val connection:Connection = DriverManager.getConnection(url, username, password)

      val statement = connection.createStatement()
      statement.executeUpdate("DROP TABLE emp")

      statement.executeUpdate("CREATE TABLE emp(EmpID int, EmpName varchar(255))")
      statement.executeUpdate("INSERT INTO emp VALUES('123', 'ABC')")
      statement.executeUpdate("INSERT INTO emp VALUES('456', 'DEF')")
      val resultSet = statement.executeQuery("SELECT * FROM emp")
      while ( resultSet.next() ) {
        val id = resultSet.getString("EmpID")
        val name = resultSet.getString("EmpName")
        println("EmpID, EmpName = " + id + ", " + name)
      }
    } catch {
      case e => e.printStackTrace
    }
    //connection.close()
  }

}