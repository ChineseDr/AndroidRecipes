package com.ray.aidlbase;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;

/**
 * Created by ray on 2017/12/28.
 */

public class BookManagerImpl extends Binder implements IBookManger {
    @Override
    public List<Book> getBookList() throws RemoteException {
        return null;
    }

    @Override
    public void addBook() throws RemoteException {

    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
