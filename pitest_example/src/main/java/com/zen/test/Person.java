package com.zen.test;

import com.zen.test.human.Human;
import com.zen.test.human.Sex;

/**
 * @author zen
 * @since 20161214.
 */
public class Person implements Human {

    private int age;
    private Sex sex;

    public Person(int age, Sex sex) {
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Sex getSex() {
        return sex;
    }
}
