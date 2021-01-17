package blog;

import java.sql.*;
import java.util.Scanner;

public class UserLoginAction implements Action {
    @Override
    public void run() {
        User user = new User();

        //1.提示用户输入需要的信息，并且使用JDBC执行SQL
        System.out.println("用户登录");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名称>");
        String username = scanner.nextLine();
        System.out.print("请输入密码>");
        String password = scanner.nextLine();
        //根据username,password判断用户是否登录成功
        try(Connection connection = DBUtil.getConnection()){
            String sql = "select id,nickname from users where username =? and password = ?";
            try (PreparedStatement s = connection.prepareStatement(sql)) {
                s.setString(1,username);
                s.setString(2,password);

                try(ResultSet resultSet = s.executeQuery()){
                    if(resultSet.next()){
                      int id = resultSet.getInt(1);
                      String nickname = resultSet.getString(2);
                      user.id = id;
                      user.username = username;
                      user.nickname = nickname;

                      User.login(user);
                    }else {
                        System.out.print("用户名或者密码错误，请重新输入");
                    }
                }
            }

        }catch (SQLException e){

            System.out.println("错误：" + e.getMessage());
        }

        User.login(user);

    }
}
