package com.hzy.java8.optional;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Optional;

/**
 * optional  常用方法
 */
public class Demo {

    /**
     * 创建一个 optional 实例， of 方法要求必须传入一个 非空值，如果为 null 则空指针异常
     */
    @Test
    public void test01() {
        Optional<User> optionalUser = Optional.of(new User());
        User user = optionalUser.get();
        System.out.println(user);
    }

    /**
     * 创建一个 空的 optional 实例， empty 方法没有参数      get 时会抛出 NoSuchElementException  异常
     */
    @Test
    public void test02() {
        Optional<User> optionalUser = Optional.empty();
        User user = optionalUser.get();
        System.out.println(user);
    }

    /**
     * ofNullable 方法允许传入 空值
     * get 时会抛出 NoSuchElementException  异常
     */
    @Test
    public void test03() {
        Optional<User> optionalUser = Optional.ofNullable(new User());
        User user = optionalUser.get();
        System.out.println(user);

        Optional<User> optionalUser1 = Optional.ofNullable(null);
        User user1 = optionalUser1.get();
        System.out.println(user1);
    }

    /**
     * optional 对象的 isPresent 方法，可以判断 是否含有值
     */
    @Test
    public void test04() {
        Optional<User> optionalUser = Optional.ofNullable(new User());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user);
        }

        Optional<User> optionalUser1 = Optional.ofNullable(null);
        if (optionalUser1.isPresent()) {
            User user1 = optionalUser1.get();
            System.out.println(user1);
        }
    }

    /**
     *  orElse(T t)  方法取值时，如果包含值，则返回该值，如果没有，则返回预先设定的 T t 值
     */
    @Test
    public void test05() {
        Optional<User> optionalUser = Optional.ofNullable(null);
        User user = optionalUser.orElse(new User("hzy", 1233, 1234.2));
        System.out.println(user);

        Optional<User> optionalUser1 = Optional.ofNullable(new User("king", 34564, 567456.3));
        User user1 = optionalUser1.orElse(new User("hzy", 1233, 1234.2));
        System.out.println(user1);
    }

    /**
     * 功能上与 orElse  方法相同， 参数内可以通过  供给型接口  lambda 表达式获取值
     */
    @Test
    public void test06(){
        Optional<User> optionalUser = Optional.ofNullable(null);
        User user = optionalUser.orElseGet(() -> new User());
        System.out.println(user);
    }

    /**
     *  类似于 stream  中的  map 处理
     */
    @Test
    public void test07(){
        Optional<User> optionalUser1 = Optional.ofNullable(new User("king", 34564, 567456.3));
        Optional<String> nameOptional = optionalUser1.map((e) -> e.getName());
        System.out.println(nameOptional.get());
    }

    /**
     *  flatMap  方法要求返回获取的 仍然是一个 optional 类型的值
     */
    @Test
    public void test08(){
        Optional<User> optionalUser = Optional.ofNullable(new User("king", 34564, 567456.3));
        Optional<Integer> integer = optionalUser.flatMap((e) -> Optional.of(e.getAge()));
        System.out.println(integer.get());
    }

}
