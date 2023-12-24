package jdbcexaples;

import java.sql.*;
import java.util.Scanner;

public class JdbcEx1 {


        public static void main(String[] args) {
             Connection conn=null;
            try{

                conn=DriverManager.getConnection("jdbc:oracle:thin:@//Mishal:1521/xe","system", "asdfg");
                System.out.println("Connected Successfully to the DB");
                 Statement st=conn.createStatement();


                Scanner kb=new Scanner(System.in);
                System.out.println("enter the id=");
                int id=kb.nextInt();

                System.out.println("Enter the name=");
                kb.nextLine();   //clearing the buffer
                String name=kb.nextLine();

                int ans=st.executeUpdate("INSERT INTO Family values("+id+",'"+name+"'"+")");
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
