package com.alipay.sign;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import com.ecloud.common.DateUtils;
import com.ecloud.common.UUIDUtils;

import javax.security.auth.x500.X500Principal;

import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.UUID;
/**
 * 生成公钥
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class BaseCert {
	/**
	 * BouncyCastleProvider
	 */
	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	/**
	 * 
	 */
	protected static KeyPairGenerator kpg = null;

	/**
 * 
 */
	public BaseCert() {
		try {
            // 采用 RSA 非对称算法加密
			kpg = KeyPairGenerator.getInstance(CAConfig.KEY_ALGORITHM);
            // 初始化为 1023 位
			kpg.initialize(1024);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 生成 X509 证书
	 * @param user
	 * @return
	 */
	public X509Certificate generateCert(String user) {
		X509Certificate cert = null;
		try {
			KeyPair keyPair = this.kpg.generateKeyPair();
            // 公钥
			PublicKey pubKey = keyPair.getPublic();
			// 私钥
			PrivateKey priKey = keyPair.getPrivate();
			X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
            // 设置序列号
			certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
            // 设置颁发者
			certGen.setIssuerDN(new X500Principal(CAConfig.CA_ROOT_ISSUER));
            // 设置有效期
			certGen.setNotBefore(new Date());
			certGen.setNotAfter(DateUtils.getNextYear());
            // 设置使用者
			certGen.setSubjectDN(new X500Principal(CAConfig.CA_DEFAULT_SUBJECT + user));
			// 公钥
			certGen.setPublicKey(pubKey);
            // 签名算法
			certGen.setSignatureAlgorithm(CAConfig.CA_SHA);
			cert = certGen.generateX509Certificate(priKey, "BC");
		} catch (Exception e) {
			System.out.println(e.getClass() + e.getMessage());
		}
		return cert;
	}
}