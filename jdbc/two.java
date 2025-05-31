import java.sql.*;
import java.util.*;

public class two {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Emp"; 
        String name = "root";
        String password = "pranav1910";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, name, password);
        System.out.println("Connection done");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll No and Student Name:");
        int rollno = sc.nextInt();
        String stdname = sc.next();
        sc.close();

        String query1 = "insert into student values(?, ?)";
        PreparedStatement ps1 = con.prepareStatement(query1);
        ps1.setInt(1, rollno);
        ps1.setString(2, stdname);
        int i1 = ps1.executeUpdate();
        System.out.println("Rows inserted: " + i1);

        String query2 = "select * from student";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query2);

        System.out.println("Roll No\tStudent Name");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
        }

        rs.close();
        st.close();
        ps1.close();
        con.close();
    }
}
    