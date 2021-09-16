//
// Created by 杜若尘 on 2021/3/27.
//
#include "com_duruochen_practice_JniTest.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_com_duruochen_practice_JniTest_get
  (JNIEnv *env, jobject thiz) {
  printf("invoke get in c++\n");
  return env->NewStringUTF("hello from jni!");
  }


JNIEXPORT void JNICALL Java_com_duruochen_practice_JniTest_set
  (JNIEnv *env, jobject thiz, jstring string) {
   printf("invoke set in c++\n");
   char* str = (char*)env->GetStringUTFChars(string,NULL);
   printf("%s\n",str);
   env->ReleaseStringUTFChars(string, str);
  }