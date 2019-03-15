package hot.des;

import java.io.*;

public class MyClassLoader extends ClassLoader {

// 目标字节码路径

private String byteCode_Path;

// 密钥

private byte[] key;

public MyClassLoader(String byteCode_Path, byte[] key) {

        this.byteCode_Path = byteCode_Path;

        this.key = key;

        }

protected Class findClass(String name) throws ClassNotFoundException {

    BufferedInputStream bis = null;

        byte bys[] = null;

        try {

        bis = new BufferedInputStream(new FileInputStream(byteCode_Path + name + ".class"));

        bys = new byte[bis.available()];

        bis.read(bys);

        } catch (Exception e1) {

        e1.printStackTrace();

        } finally {

        try {

        bis.close();

        } catch (IOException e) {

        e.printStackTrace();

        }

        }

        bys=Use3DES.decrypt(key, bys);

// defineClass方法可以将byte数组转化为一个类的Class对象实例

        return this.defineClass(bys, 0, bys.length);

        }

    public static void main(String[] args) throws Exception {

// 对原来的字节码进行加密处理

        BufferedInputStream bis = null;

        BufferedOutputStream bos = null;

        byte[] bys = null;

        byte[] key=null;

        try {

//        bis = new BufferedInputStream(new FileInputStream("D:/People.class"));
            bis = new BufferedInputStream(new FileInputStream("E:/App.class"));


        bys = new byte[bis.available()];

// 把原字节码文件读到bys字节数组

        bis.read(bys);

//设置24位密钥数组

        key = "01234567899876543210abcd".getBytes();

// 将字节码加密后写到"D:/encrypt"目录下

//        bos = new BufferedOutputStream(new FileOutputStream("D:/encrypt/People.class"));
            bos = new BufferedOutputStream(new FileOutputStream("E:/encrypt/App.class"));

        bos.write(Use3DES.encrypt(key, bys));

        } catch (Exception e) {

        e.printStackTrace();

        } finally {

        bis.close();

        bos.close();

        }

//如何用自定义的加载器加载加密后的字节码文件(目标字节码)

        MyClassLoader mcl = new MyClassLoader("D:/encrypt",key);

        System.out.println("加载目标类的类加载器:" + mcl.getClass().getName());

        System.out.println("自定义类加载器的父类加载器:" + mcl.getParent().getClass().getName());

        mcl.findClass("");//即可获得解密数据
        }

        }