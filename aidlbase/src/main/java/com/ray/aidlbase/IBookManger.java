package com.ray.aidlbase;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import java.util.List;

/**
 * Created by ray on 2017/12/28.
 */

public interface IBookManger extends IInterface {
    static final String DESCRIPTOR="com.ray.aidlbase.IBookManager";
    static final int TRANSACT_getBookList= IBinder.FIRST_CALL_TRANSACTION+0;
    static final int TRANSACT_addBook= IBinder.FIRST_CALL_TRANSACTION+1;
    public List<Book> getBookList() throws RemoteException;
    public void addBook() throws RemoteException;
}
