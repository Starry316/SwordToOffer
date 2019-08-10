package leetcode;

import java.util.Hashtable;

/**
 * @Author starry
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 思路
 * 使用双hash表，分别记录pattern中的字符对应的单词，以及单词对应的pattern是否重复
 *
 */
public class Q290 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0)return true;
        String words[] = str.split(" ");
        if (words.length != pattern.length())return false;
        Hashtable<Character,String> table = new Hashtable<>();
        Hashtable<String,Character> table2 = new Hashtable<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (table.containsKey(c)){
                if (!table.get(c).equals(words[i]))return false;
            }
            else {
                table.put(c,words[i]);
            }
            if (table2.containsKey(words[i])){
                if (!(table2.get(words[i]) == c))return false;
            }
            else table2.put(words[i],c);
        }

        return true;
    }
}
