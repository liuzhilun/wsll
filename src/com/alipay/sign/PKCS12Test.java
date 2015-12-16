package com.alipay.sign;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import javax.security.auth.x500.X500Principal;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * 生成私钥
 * @author Administrator
 *
 */
public class PKCS12Test {

	static {
		// 系统添加BC加密算法 以后系统中调用的算法都是BC的算法
		Security.addProvider(new BouncyCastleProvider());
	}

	public static void main(String args[]) throws NoSuchAlgorithmException,
            InvalidKeyException, SecurityException, SignatureException,
            KeyStoreException, CertificateException, IOException {
		String certPath = "c:/hansy.pfx";
		// 创建KeyStore
		 KeyStore store = KeyStore.getInstance("PKCS12");
		 store.load(null, null);

		/* RSA算法产生公钥和私钥 */
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(CAConfig.KEY_ALGORITHM);
		kpg.initialize(2048);
		KeyPair keyPair = kpg.generateKeyPair();
		// 组装证书
		String issuer = "C=CN,ST=BJ,L=BJ,O=SICCA,OU=SC,CN=SICCA";
		String subject = issuer;

		X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

		certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
		certGen.setIssuerDN(new X500Principal(issuer));
		certGen.setNotBefore(new Date(System.currentTimeMillis() - 50000));
		certGen.setNotAfter(new Date(System.currentTimeMillis() + 50000));
		certGen.setSubjectDN(new X500Principal(subject));
		certGen.setPublicKey(keyPair.getPublic());
		certGen.setSignatureAlgorithm(CAConfig.CA_SHA);

		X509Certificate cert = certGen.generateX509Certificate(keyPair.getPrivate());
		System.out.println(cert.toString());
		//私钥密码
		store.setKeyEntry("hansy", keyPair.getPrivate(),"123456".toCharArray(), new Certificate[] { cert });
		FileOutputStream fout =new FileOutputStream(certPath);
		store.store(fout, "123456".toCharArray());		
		fout.close();  
	}

}
