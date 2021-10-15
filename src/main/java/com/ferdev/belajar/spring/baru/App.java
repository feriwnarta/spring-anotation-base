package com.ferdev.belajar.spring.baru;

import com.ferdev.belajar.spring.baru.repository.AccountRepository;
import com.ferdev.belajar.spring.baru.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class App {

    public static void main( String[] args ) {
        // objek ini digunakan untuk melakukan annotation base
        // dengan menggunakan annotationConfigApplication
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // mencari lokasi, tempat beradanya anotattion service, repository, autowired dll
        context.scan("com.ferdev.belajar.spring.baru");
        // perlu direfresh
        context.refresh();
        // jika menggunakan cara ini, kita tidak memperlukan application context xml

        AccountService service = context.getBean("accountService", AccountService.class);
        AccountRepository repository = context.getBean("accountRepository", AccountRepository.class);

        // sebelum transfer
        System.out.println("sebelum transfer");
        System.out.println("nama  : " + service.getById(1l).getNama());
        System.out.println("Saldo : " + service.getById(1l).getBalance());

        System.out.println("nama  : " + service.getById(2l).getNama());
        System.out.println("saldo : " + service.getById(2l).getBalance());

        // sesudah transfer
        service.transfer(1l, 2l, new BigDecimal(45000));
        System.out.println("\nsesudah transfer");
        System.out.println("nama  : " + service.getById(1l).getNama());
        System.out.println("Saldo : " + service.getById(1l).getBalance());

        System.out.println("nama  : " + service.getById(2l).getNama());
        System.out.println("saldo : " + service.getById(2l).getBalance());



    }
}
