package calc;

import java.math.BigDecimal;

public class TestBigDecimal {

//    @Test
    public void test(){

//        Long ll = 1.1;
//        System.out.println(ll);
        double a=0.1;
        double b=0.2;
        System.out.println(a+b);

        BigDecimal a1=new BigDecimal("3.111");

        BigDecimal b1=new BigDecimal("0.2");

        System.out.println(a1.add(b1));
        BigDecimal c1=new BigDecimal("0.23574");
        a1=a1.add(c1);
        a1=a1.setScale(1,BigDecimal.ROUND_DOWN);
        System.out.println(a1);
    }

    public static void main(String[] args) {
//        BigDecimal bb = new BigDecimal(null,22l,2,0);
        TestBigDecimal testBigDecimal = new TestBigDecimal();
        testBigDecimal.test();
//        BigDecimal b1 = new BigDecimal("12.1234");
//        BigDecimal b2 = b1.setScale(2,RoundingMode.DOWN);
//
//
//        System.out.println("b1:" + b1);
//        System.out.println("b2:" + b2);

//        long sum = 34674;
//        long xs = 11100;
//        long ys = 23574;
//        long re1 = sum ^ xs;
//        System.out.println("re1:" + re1);
//
//        long re2 = sum ^ ys;
//        System.out.println("re2:" + re2);
//
//        long re3 = re1 & re2;
//        System.out.println("re3:" + re3);


//        long sum = 3;
//
//        long xs = 1;
//
//        long ys = 2;
//
//        long re1 = sum ^ xs;
//        System.out.println("re1:" + re1);
//
//        long re2 = sum ^ ys;
//        System.out.println("re2:" + re2);
//
//        long re3 = re1 & re2;
//        System.out.println("re3:" + re3);

    }
}
