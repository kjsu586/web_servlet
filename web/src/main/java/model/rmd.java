package model;
//Model

import java.util.ArrayList;
import java.util.Random;

public class rmd {
	ArrayList<String> num = null;
	int ea = 0;
	public rmd(int n) {
		this.ea = n;	//자리수 세팅// 자동등록방지 4자리 또는 게시판 보안코드 6자리 등등..
		this.num = new ArrayList<String>();
	}
	public ArrayList<String> make_num(){	//난수를 생성하는 메소드
		Random rd = new Random();
		int w = 1;
		while(w <= this.ea) {
			this.num.add(String.valueOf(rd.nextInt(10)));	//0~9
			w++;
		}
		return num;
	}
	
}
