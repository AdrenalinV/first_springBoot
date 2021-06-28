package ru.geekbrains.first_springBoot.exception;

public class NotProductByID extends RuntimeException{
    public NotProductByID(long id) {
        super("Not product id: " + id);
    }
}
