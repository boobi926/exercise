import java.util.*;


public class spaceReplace {

    public String replaceSpace (String s) {
        // write code here
        StringBuffer sb = new StringBuffer();
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(ch[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}