/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_test_SystemJNI */

#ifndef _Included_com_test_SystemJNI
#define _Included_com_test_SystemJNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_test_SystemJNI
 * Method:    shtermOpen
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_com_test_SystemJNI_shtermOpen
  (JNIEnv *, jobject);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermLedPanelWrite
 * Signature: (IJ)I
 */
JNIEXPORT jint JNICALL Java_com_test_SystemJNI_shtermLedPanelWrite
  (JNIEnv *, jobject, jint, jlong);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermLedPanelRead
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_test_SystemJNI_shtermLedPanelRead
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermTemperatureRead
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_test_SystemJNI_shtermTemperatureRead
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermIrigbRead
 * Signature: (J)[I
 */
JNIEXPORT jintArray JNICALL Java_com_test_SystemJNI_shtermIrigbRead
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermIrigbWrite
 * Signature: (IJ)I
 */
JNIEXPORT jint JNICALL Java_com_test_SystemJNI_shtermIrigbWrite
  (JNIEnv *, jobject, jint, jlong);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermPowerStatRead
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_test_SystemJNI_shtermPowerStatRead
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_test_SystemJNI
 * Method:    shtermEventRead
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_test_SystemJNI_shtermEventRead
  (JNIEnv *, jobject, jlong, jstring);

#ifdef __cplusplus
}
#endif
#endif
