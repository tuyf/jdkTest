package cipher.rsa;//package cipher.rsa;
//
//import javax.crypto.Cipher;
//import java.security.*;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
//public class RsaTest {
//
//    //公钥string 转publicKey对象
//    public static PublicKey getPublicKey(String key) throws Exception {
//        byte[] keyBytes;
//        keyBytes = (new sun.misc.BASE64Decoder()).decodeBuffer(key);
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(keySpec);
//        return publicKey;
//    }
//
//    public static PrivateKey getPrivateKey(String key) throws Exception{
//        byte[] keyBytes;
//        keyBytes = (new sun.misc.BASE64Decoder()).decodeBuffer(key);
//        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//        return privateKey;
//    }
//
//    //加密
//    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        return cipher.doFinal(content);
//    }
//
//    /**
//     * byte[] b1 byte[] b2 byte[] b1 String
//     * String data----getBytes(默认编码)-----公钥加密(ISO字符集，使用其他字符集数据丢失)-----
//     * ----私钥解密----------new String(默认编码)----String data
//     *
//     *
//     * @param args
//     * @throws Exception
//     */
//    public static void main(String[] args) throws Exception {
//        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider());
//        generator.initialize(2048, new SecureRandom());
//        KeyPair keyPair = generator.generateKeyPair();
//        PublicKey publicKey = keyPair.getPublic();
//        String pubKey = new String(Base64.encodeBase64(publicKey.getEncoded()));
//        System.out.println("公钥:"+pubKey);
//        PrivateKey privateKey = keyPair.getPrivate();
//        String priKey = new String(Base64.encodeBase64(privateKey.getEncoded()));
//        System.out.println("私钥:"+priKey);
////公钥加密 此时的getBytes() 的编码 为默认 应该和最后的 new String() 的编码一样
//        byte[] encryptedBytes = encrypt(data.getBytes(), publicKey);
////将密文字节数组转String时 不使用ISO编码 可能导致数据丢失 解密失败
//
////如果下面两句 没有指明编码，或者使用其他编码，会导致数据的错误，导致字节数组b1长度超出限制， 报出异常javax.crypto.IllegalBlockSizeException，具体原因可能是因为在公钥加密时使用的字符集问题。
//        String s1 = new String(encryptedBytes,"ISO8859-1");
//        byte[] b1 = s1.getBytes("ISO8859-1");
////解密
//        byte[] decryptedByte = decrypt(b1, privateKey);
//        System.out.println("解密后:"+new String(decryptedByte));
//
//    }
//
//    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);
//        return cipher.doFinal(content);
//
//    }
//}
