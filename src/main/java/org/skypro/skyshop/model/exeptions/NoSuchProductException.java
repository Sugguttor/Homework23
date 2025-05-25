package org.skypro.skyshop.model.exeptions;

    public class NoSuchProductException extends RuntimeException{
        public NoSuchProductException(String text) {
            super(text);
        }
    }

