package jdbcexaples;

import javax.management.relation.RelationSupport;
import java.sql.*;
import java.util.Scanner;

public class JdbcEx3 {


        public static void main(String[] args) {
             Connection conn=null;
            try{

                conn=DriverManager.getConnection("jdbc:oracle:thin:@//Mishal:1521/xe","system", "asdfg");
                System.out.println("Connected Successfully to the DB");
                PreparedStatement ps;


                Scanner kb=new Scanner(System.in);
                System.out.println("Log in");
                System.out.println("enter the id=");
                int id=kb.nextInt();

                System.out.println("Enter the name=");
                kb.nextLine();   //clearing the buffer
                String name=kb.nextLine();

                ps=conn.prepareStatement("select * from Family where id=? and name=?");
                ps.setInt(1,id);
                ps.setString(2,name);
                ResultSet rs=ps.executeQuery();
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
