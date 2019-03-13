package cn.zlx.ssm;

public class Test {
    public static void main(String[] args) {
        String a="123456.abc";
        String b=a.substring(a.lastIndexOf("."));
        System.out.println(b);
    }
}
