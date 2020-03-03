package org.jasig.cas.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


/**
 * 一般加密解密工具<br>
 * DESede/DES/BlowFish<br>
 * DES的密钥(key)长度是为8个字节,加密解密的速度是最快的<br>
 * DESede的密钥(key)长度是24个字节<br>
 * BlowFish的密钥(key)是可变的 加密最快，强度最高,密钥长度范围(1<=key<=16)<br>
 */
public class EncryptUtil {

	/**
	 * UTF-8
	 */
    private static final String CHARSET = "UTF-8";

    public  static final String DEFAULT_KEY="ANE_LB_KAPTCHA";
    
    public  static final String DEFAULT_TGT_KEY="ANE_LB_TGT";
    
    public  static final String LB_KEY="ANE_LB";
  

	/**
	* @MethodName: getCipher 
	* @description : getCipher
	* @param isEncrypt
	* @param key
	* @return cipher
	* @throws InvalidKeyException
	* @throws NoSuchAlgorithmException
	* @throws InvalidKeySpecException
	* @throws NoSuchPaddingException Cipher
	*/
	private static Cipher getCipher(boolean isEncrypt, byte[] key)
			throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException {
		
		/**
		 * 实例化SecretKeySpec
		 * 实例化SecureRandom
		 * 实例化Cipher
		 * 初始化cipher.init
		 * 将Cipher值返回
		 */
		SecretKeySpec keySpec = new SecretKeySpec(key, "Blowfish");
		SecureRandom sr = new SecureRandom();
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		cipher.init(isEncrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE,
				keySpec, sr);
		return cipher;
	}

	/**
	* @MethodName: encrypt 
	* @description : encrypt
	* @param data
	* @param key
	* @return String
	*/
	public static String encrypt(String data, String key) {
		if(data==null){
			return null;
		}
		Cipher cipher;
		try {
			cipher = getCipher(true, getBytes(key));
			return byte2hex(cipher.doFinal(data.getBytes(CHARSET)));
		} catch (Exception e) {
			return null;
		} 
	}

	/**
	* @MethodName: decrypt 
	* @description : decrypt
	* @param data
	* @param key
	* @return String
	*/
	public static String decrypt(String data, String key){
		if(data==null){
			return null;
		}
		Cipher cipher;
		try {
			
			cipher = getCipher(false, getBytes(key));
			byte[] b=hex2byte(data.getBytes(CHARSET));
			if(b==null){
				return null;
			}
            return new String(cipher.doFinal(b),CHARSET);
		} catch (Exception e) {
			return null;
		} 
		
	}

	/**
	* @MethodName: byte2hex 
	* @description : byte2hex
	* @param b
	* @return String
	*/
	private static String byte2hex(byte[] b) {
//		String hs = "";
		StringBuffer hs = new StringBuffer();
		String stmp ;
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0" + stmp);
//				hs = hs + "0" + stmp;
			else
				hs.append(stmp);
//				hs = hs + stmp;
		}
//		return hs.toUpperCase();
		return hs.toString().toUpperCase();

	}

	/**
	* @MethodName: hex2byte 
	* @description : hex2byte
	* @param b
	* @return
	* @throws Exception byte[]
	*/
	private static byte[] hex2byte(byte[] b) throws  Exception{
		if ((b.length % 2) != 0)
			return null;
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2,CHARSET);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
	
	/**
	* @MethodName: getBytes 
	* @description : getBytes
	* @param str
	* @return
	* @throws UnsupportedEncodingException byte[]
	*/
	private static byte[] getBytes(String str) throws UnsupportedEncodingException {
		return str.getBytes(CHARSET);
	}


}
