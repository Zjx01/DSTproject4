//package cn.edu.zju.web.controller;
//
//public class TicketDemo implements Runnable {
//    private int tickets = 100;
//
//    public void run() {
//        synchronized (this){
//        while (true) {
//
//            if (tickets > 0) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                }
//                System.out.println(Thread.currentThread().getName() + "....sale:...." + tickets--);
//            }
//        }}
//    }
//
//    public static void main(String[] args) {
//        TicketDemo ticketDemo = new TicketDemo();
//        Thread t1 = new Thread(ticketDemo);
//        Thread t2 = new Thread(ticketDemo);
//        Thread t3 = new Thread(ticketDemo);
//        Thread t4 = new Thread(ticketDemo);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//    }
//}

//多线程冲突不能使用static