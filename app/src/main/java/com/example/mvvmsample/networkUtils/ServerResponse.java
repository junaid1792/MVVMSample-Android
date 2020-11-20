package com.example.mvvmsample.networkUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ServerResponse<T> {
    private boolean status;
    private String message;
    private T data;
    @NonNull public final StatusType statusType;


    private ServerResponse(@NonNull StatusType statusType, @Nullable T data,
                           @Nullable String message) {
        this.statusType = statusType;
        this.data = data;
        this.message = message;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return message;
    }

    public void setStatusMessage(String statusMessage) {
        this.message = statusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T>ServerResponse<T> success(@NonNull T data, String msg) {
        return new ServerResponse<>(StatusType.SUCCESS, data, msg);
    }

    public static <T>ServerResponse<T> error(String msg, @Nullable T data) {
        return new ServerResponse<>(StatusType.ERROR, data, msg);
    }

    public static <T>ServerResponse<T> loading(@Nullable T data) {
        return new ServerResponse<>(StatusType.LOADING, data, null);
    }

    public enum StatusType { SUCCESS, ERROR, LOADING }
}
