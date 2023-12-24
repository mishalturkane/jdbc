package jdbcexaples;
import java.sql.*;
public class JdbcEx {


        public static void main(String[] args) {
             Connection conn=null;
            try{

                conn=DriverManager.getConnection("jdbc:oracle:thin:@//Mishal:1521/xe","system", "asdfg");
                System.out.println("Connected Successfully to the DB");
                Statement st= conn.createStatement();
                int rs = st.executeUpdate("INSERT INTO Family values(108,'pta nhi')");
                System.out.println("Data inserted");

            }catch(SQLException ex){
                System.out.println("DB error:"+ex.getMessage());
            }finally {
               try{
                   if(conn!=null) {
                         conn.close();
                         System.out.println("Disconnected with the DB");
               }
               }catch(SQLException ex){
                    System.out.println("Error in DB closing connection");
                }

            }
        }


}
