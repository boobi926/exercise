//删除第一个字符串中第二个字符串的字符。

import java.util.ArrayList;
import java.util.List;

public class removeRepeat {
    public static List<Character> func(String str1,String str2){
        List<Character> list = new ArrayList<>();
        for(int i = 0;i<str1.length(); i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                list.add(ch);
            }
        }
        return list;
    }
    public static  void main(String[] args){
        String str1 = "hello jiajia";
        String  str2 = "llo";
        List<Character> ret = func(str1,str2);
        for (char ch:ret
             ) {
            System.out.println(ret);
        }
        System.out.println();
    }

}
