package ar.com.ada.maven.root.utils;

import java.util.Scanner;

public class ScannerSingletone {
    private static Scanner scanner;

    private ScannerSingletone() { }

    public static Scanner getInstance() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
