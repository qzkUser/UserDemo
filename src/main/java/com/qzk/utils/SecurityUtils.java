package com.qzk.utils;


public class SecurityUtils {/*
	
	@SneakyThrows
	public static void main(String[] args) {
		String m = SecurityUtils.encrypt("123");
		System.out.println(m);
		System.out.println(decrypt(m));
	}
	
	*//**
	 * 解密
	 * @param cipherText 密文
	 * @return 返回解密后的字符串
	 * @throws Exception 
	 *//*
	public static String decrypt(String cipherText) throws Exception{
		 // 从文件中得到私钥
    	FileInputStream inPrivate = new FileInputStream(
    			SecurityUtils.class.getClassLoader().getResource("").getPath() + "/pkcs8_private_key.pem");
        PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decodeFromString(cipherText), privateKey);
        String decryptStr = new String(decryptByte,"utf-8");
		return decryptStr;
	}
	*//**
	 * 加密
	 * @param plainTest 明文
	 * @return	返回加密后的密文
	 * @throws Exception 
	 *//*
	public static String encrypt(String plainTest) throws Exception{
		FileInputStream inPublic = new FileInputStream(
    			SecurityUtils.class.getClassLoader().getResource("").getPath() + "/rsa_public_key.pem");
        PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);
        // 加密
        byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), publicKey);
        String afterencrypt = Base64Utils.encodeToString(encryptByte);
        return afterencrypt;
	}
*/}
