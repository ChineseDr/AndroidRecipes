package com.ray.aidlbase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ray on 2017/12/27.
 */

public class Book implements Parcelable {
    private int bookID;
    private String bookName;

    public Book(int bookID, String bookName) {
        this.bookID = bookID;
        this.bookName = bookName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookID);
        dest.writeString(bookName);
    }

    public static final Creator<Book> CREATOR=new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    private Book(Parcel source){
        this.bookID=source.readInt();
        this.bookName=source.readString();
    }

}
