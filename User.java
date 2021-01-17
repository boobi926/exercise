package blog;

public class User {
    int id;
    String username;
    String nickname;
    //保存当前用户的登录信息
    //没有登录user==null
    //否则，指向具体的用户对象
    private static User currentUser = null;

    public static void login(User user){
        currentUser = user;
        System.out.print("当前登录的用户信息是："+currentUser);
    }

    //判断用户是否登录
    public static boolean isLogin(){
        return currentUser != null;
    }
    public static User getCurrentUser(){
        return currentUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
