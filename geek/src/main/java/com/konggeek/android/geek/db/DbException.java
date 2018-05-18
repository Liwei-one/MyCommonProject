package com.konggeek.android.geek.db;

import com.konggeek.android.geek.GeekException;

public class DbException extends GeekException {
    private static final long serialVersionUID = 1L;

    public DbException() {
    }


    public DbException(String msg) {
        super(msg);
    }

    public DbException(Throwable ex) {
        super(ex);
    }

    public DbException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
