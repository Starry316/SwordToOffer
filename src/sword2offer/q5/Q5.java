package sword2offer.q5;

/**
 * @Author starry
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：先遍历获取修改后总长度，然后从后向前复制，遇到空格则替换为%20
 * 亮点：使用后面多出来的位置作为临时存储
 */
public class Q5 {

    public static String replaceSpace(StringBuffer str) {
        int count = 0;
        int size = str.length();
        for (int i = 0; i < size; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int endPointer = str.length()-1;
        for (int i = size-1; i >= 0; i--) {
            if (str.charAt(i) == ' '){
                str.setCharAt(endPointer--,'0');
                str.setCharAt(endPointer--,'2');
                str.setCharAt(endPointer--,'%');
            }
            else str.setCharAt(endPointer--,str.charAt(i));
        }
        return str.toString();
    }

    public static void main(String []args){
        System.out.println(replaceSpace(new StringBuffer("1212 1212 1212 12")));
    }

}
