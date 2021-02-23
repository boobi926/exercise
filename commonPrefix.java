
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"

//定义一个字符串con，并初始化为第一个字符串的值，然后进行两两比较。
public class commonPrefix {
    public static String longestCommonPrefix(String[] strs) {
     //字符串组为空时返回""。
        if(strs.length==0){
            return "";
        }
        String con = strs[0];  //始化为第一个字符串的值
        //让con和其余的字符串进行比较
        for(int i = 1; i<strs.length; i++){
            int j = 0;
            for(;j<con.length() && j<strs[i].length(); j++){
                if(con.charAt(j)!= strs[i].charAt(j)){
                    break;
                }
                con = con.substring(0,j);
                if(con.equals("")){
                    return "";
                }
            }
        }
       return con;
    }
    public static void main(String[] args){

     String[] strs ={"flower","flow","flight"};
        String ret = longestCommonPrefix(strs);

            System.out.println(ret);
      
    }
}
