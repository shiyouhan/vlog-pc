package top.syhan.vlog.test;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:27
 **/
public class TestProgrammer {
    public static void main(String[] args) {
        BaseComputer completer = new MacBook("MacBook Pro", 13);
        Programmer programmer = new JavaProgrammer("小王");
        programmer.coding(completer);
    }
}
