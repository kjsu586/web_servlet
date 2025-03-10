package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//문자를 암호화 변경을 하는 Model
public class encry_model {
	public String dataencod(String word) {	//base64 암호화
		Encoder ec = Base64.getEncoder();
		String security = ec.encodeToString(word.getBytes());
		return security;
	}
	public String datadecode(String word) {
		Decoder dc = Base64.getDecoder();
		/*
		byte dec[] = dc.decode(word);
		String security = new String(dec);
		*/
		String security = new String(dc.decode(word));
		return security;
	}
	
	//MD5 : %02x가 기본, 01,02,x 같음 / %03x ~ 부터는 자리수가 달라짐 (x : 소문자, X : 대문자)
	//sha-1 : 16진수 40자로 생성되는 암호화 기술 (%01x, %02x가 다름)
	//sha-2 : sha-224, sha-256, sha-384, sha-512
	//sha-3 : sha3-224, sha3-256, sha3-384, sha3-512
	
	//금융권 : 복합 암호화 기술 -> base64 -> md5 
	//금융권 : 복합 암호화 기술 -> md5 + sha-2
	public String md5_encode(String word) {
		String security = "";
		try {
			//MessageDigest : 암호화 클래스 구성 형태를 가지고 있는 라이브러리
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(word.getBytes());	//해당 암호화 기준으로 byte로 문자를 변환
			byte md5byte[] = md.digest();	//원시배열에 해당 암호화된 byte를 저장
			
			StringBuffer sb = new StringBuffer();	//문자열 클래스로 연속화
			for(byte s : md5byte) {	
				sb.append(String.format("%01x", s));
				//%02x -> 2자리 문자 -> 1234 -> 01,02,03,04
				//%01x -> 1자리 문자 -> 1234 -> 1,2,3,4
				//%05x -> 5자리 문자 -> 1234 -> 00001,00002
			}
			security = String.valueOf(sb);
		} catch (Exception e) {
			security = "MD5 Error";
		}
		return security;
	}
}
