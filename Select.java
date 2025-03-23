package Playing.Background;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

    @Test
    public void SelectAll(){
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= utils.JDBCUtils.getConnection();
            String sql = "Select * from students ;";

            preparedStatement=connection.prepareStatement(sql);

            resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                int stu_id = resultSet.getInt(1);
                String stu_name=resultSet.getString(2);
                String tel=resultSet.getString(3);
                String address =resultSet.getString(4);
                String gender=resultSet.getString(5);

                System.out.println(stu_id+"\t"+ stu_name +"\t"+tel+"\t"+address+"\t"+gender+"\t");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
