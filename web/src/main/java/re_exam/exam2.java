package re_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class exam2 {
	
	
	public static void main(String[] args) {
		ex2_box eb = new ex2_box();
		eb.aaa();

	}

}

class ex2_box{
	ArrayList<Integer> user = null;
	ArrayList<Integer> pc =null;
	Scanner sc = null;
	public ex2_box() {
		this.sc = new Scanner(System.in);
		this.user = new ArrayList<Integer>();
		this.pc = new ArrayList<Integer>();
	}
	public Integer pc_return() {
		Integer npc = (int)Math.ceil(Math.random()*46);
		if(this.pc.contains(npc) == true) {
			this.pc.add(npc);
		}
		return npc;
	}
	
	public void aaa() {
		try {
			while(true) {
				if(this.user.size() == 6) {
					break;
				}
				if(this.pc.size() < 6) {
					Integer npc = (int)Math.ceil(Math.random()*46);
					if(this.pc.contains(npc) == false) {
						this.pc.add(npc);
					}else {	//중복 됐을 경우 외부 return 메소드로 재핸들링 
						Integer result = this.pc_return();
						this.pc.add(result);
					}
				}	
				System.out.println("숫자를 입력하세요 (1~46) : ");
				Integer no = this.sc.nextInt();
				if(no > 0 && no <= 46) {
					//같은 숫자 확인
					if(this.user.contains(no) == false) {
						this.user.add(no);
					}
				}else {
					System.out.println("숫자는 1~46까지만 입력 가능합니다.");
				}
			}
			System.out.println(this.user);
			System.out.println(this.pc);
		} catch (Exception e) {
			System.out.println("숫자만 입력해야 합니다");
			new ex2_box().aaa();
		}finally {
			sc.close();			
		}
		
	}
}