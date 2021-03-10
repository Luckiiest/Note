package bookstroe;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        BookStore bookStore = new BookStore();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入图书金额");
        float price = input.nextFloat();
        System.out.println("请出示您的身份");
        int identity = input.nextInt();
        bookStore.buyBook(price,identity);
    }
}
