// IRemoteService.aidl
package com.ray.aidlserver;

// Declare any non-default types here with import statements

interface IRemoteService {

     /**
      * 获取当前服务所在进程
      */
      int getPID();

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
