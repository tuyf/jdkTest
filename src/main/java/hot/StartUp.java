package hot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 与 jvm 书籍上 重写的类加载器 进行对比
 */
public class StartUp {

    public static void main(String[] args) throws ClassNotFoundException {

        int i = 0 ;

        while(true){
            MyClassLoader mcl = new MyClassLoader() ;
            MyClassLoader2 mc2 = new MyClassLoader2() ;
            System.out.println(mcl.getParent());
            Class<?> personClass =  mcl.findClass("hot.Person");
            Class<?> personClass2 =  mc2.findClass("hot.Person");

            try {
//                Object person =  personClass.newInstance() ;
                Object person =  personClass2.newInstance() ;
                Method sayHelloMethod = personClass.getMethod("sayHello") ;
                sayHelloMethod.invoke(person) ;
                System.out.println(++i);
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
