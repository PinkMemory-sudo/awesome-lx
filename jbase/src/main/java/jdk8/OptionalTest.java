package jdk8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("").orElse("1"));
        System.out.println(Optional.ofNullable(null).orElse("1"));
    }
}
