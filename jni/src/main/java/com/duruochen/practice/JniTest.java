package com.duruochen.practice;

/**
 * Created by duruochen on 2021/3/27.
 */
public class JniTest {

    static {
        System.loadLibrary("jni-test");
    }

    public static void main(String[] args) {
        JniTest jniTest = new JniTest();
        System.out.println(jniTest.get());
        jniTest.set("hello world!java");
    }

    public native String get();

    public native void set(String str);
}
