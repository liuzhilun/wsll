package com.alipay.sign;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
/**
 * 生成公钥
 * @author Administrator
 *
 */
public class GenerateCa {
    private static String certPath = "c:/hansyDES.cer";
    public static void main(String[] args) {
        BaseCert baseCert = new BaseCert();
        X509Certificate cert = baseCert.generateCert("SHA1withRSA");
        System.out.println(cert.toString());

        // 导出为 cer 证书
        try {
            FileOutputStream fos = new FileOutputStream(certPath);
            fos.write(cert.getEncoded());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}