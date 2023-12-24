package jdbcexaples;

import java.sql.*;
import java.util.Scanner;

public class JdbcEx2 {


        public static void main(String[] args) {
             Connection conn=null;
            try{

                conn=DriverManager.getConnection("jdbc:oracle:thin:@//Mishal:1521/xe","system", "asdfg");
                System.out.println("Connected Successfully to the DB");
                PreparedStatement ps;


                Scanner kb=new Scanner(System.in);
                System.out.println("enter the id=");
                int id=kb.nextInt();

                System.out.println("Enter the name=");
                kb.nextLine();   //clearing the buffer
                String name=kb.nextLine();

                ps=conn.prepareStatement("insert into Family values(?,?)");
                ps.setInt(1,id);
                ps.setString(2,name);
                int how=ps.executeUpdate();
                System.out.println(how+" Record inserted");
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
