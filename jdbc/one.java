import java.sql.*;

public class one{
    public static void main(String args[]) throws Exception{
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/Emp";
        String name="root";
        String password="pranav1910";

        Class.forName(driver);
        Connection con=DriverManager.getConnection(url, name, password);
        System.out.println("connection done");

        Statement st= con.createStatement();

        String query="Select * from Empolyee";

        ResultSet rs=st.executeQuery(query);

        while(rs.next()){
            System.out.println(rs.getInt(1)+rs.getString(2));
        }
        rs.close();
        con.close();

    }
}