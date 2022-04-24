package top.syhan.vlog.common;

/**
 * @program: vlog-api
 * @description: 性别枚举
 * @author: SYH
 * @create: 2022-04-23 16:22
 **/
public enum Gender {

    /**
     * 枚举
     */
    secret(0, "保密"),
    male(1, "男"),
    female(2, "女");

    public final Integer type;
    public final String value;

    Gender(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
