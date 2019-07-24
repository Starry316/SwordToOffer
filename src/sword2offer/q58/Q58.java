package sword2offer.q58;

/**
 * @Author starry
 * 1. 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 2. 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class Q58 {
    public String ReverseSentence(String str) {
        String [] sentences = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = sentences.length-1; i >=0 ; i--) {
            sb.append(sentences[i]);
            if (i!=0)
                sb.append(" ");
        }
        while (sb.length()<str.length())sb.append(" ");
        return sb.toString();
    }

    public String LeftRotateString(String str,int n) {
        if (str == null) return null;
        int len = str.length();
        if(len == 0)return "";

        n = n % len;
        StringBuffer sb = new StringBuffer();
        sb.append(str.substring(n,len));
        sb.append(str.substring(0,n));

        return sb.toString();
    }

    public static void main(String[] args) {
        new Q58().LeftRotateString("abcd",3);
    }
}
