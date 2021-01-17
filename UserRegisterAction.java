package blog;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.Scanner;

//用户注册功能
public class UserRegisterAction implements Action {
    @Override
    public void run() {

        //1.提示用户输入需要的信息，并且使用JDBC执行SQL
        System.out.println("用户开始注册");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名称>");
        String username = scanner.nextLine();
        System.out.print("请输入用户昵称>");
        String nickname = scanner.nextLine();
        System.out.print("请输入密码>");
        String password = scanner.nextLine();

        try(Connection connection = DBUtil.getConnection()){
            String sql = "insert into users (username,nickname,password) values (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1,username);
                statement.setString(2,nickname);
                statement.setString(3,password);

                statement.executeUpdate();

                int id;
                try(ResultSet r = statement.getGeneratedKeys()){
                    r.next();
                    id = r.getInt(1);
                }

                System.out.println("注册成功，欢迎您的加入，" + nickname);

                //注册成功后，让用户登录
                User user = new User();
                user.id = id;
                user.username = username;
                user.nickname = nickname;
                User.login(user);
            }

        }catch (SQLException e){

            System.out.println("错误：" + e.getMessage());
        }
    }

}
