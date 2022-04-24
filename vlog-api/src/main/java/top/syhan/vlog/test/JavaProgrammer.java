package top.syhan.vlog.test;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:18
 **/
public class JavaProgrammer implements Programmer {
    private final String name;

    public JavaProgrammer(String name) {
        this.name = name;
    }

    @Override
    public void coding(BaseComputer computer) {
        System.out.println("Java程序员" + this.name + "在用" + computer.getBrand() + "敲代码,电脑尺寸为：" + computer.getSize());
    }
}
