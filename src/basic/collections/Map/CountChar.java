package basic.collections.Map;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xjlin on 2018/9/10.
 */
public class CountChar{
    public static void main(String[] args){
        String string = "asdfasdfasdfasdfasdfasdgfasidjfalksjdfoiuwejkgjasd";

        System.out.println(CountChar.countResult(string));
    }

    static String countResult(String string) {
        Map<Character, Integer> charsMap = new TreeMap<>();

        char[] chars = string.toCharArray();
        for(char c: chars) {
            if(charsMap.get(c) != null) {
                int value = charsMap.get(c);
                charsMap.put(c, ++value);
            }else {
                charsMap.put(c,1);
            }
        }

        StringBuilder result = new StringBuilder();

        for(Character character: charsMap.keySet()) {
            result.append(character).append('[').append(charsMap.get(character)).append(']');
        }

        return result.toString();
    }
}
