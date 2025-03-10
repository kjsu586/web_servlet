package re_exam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class exam8 extends ex8_box {
@Override
public void even() {
	ArrayList<Integer> number = new ArrayList<Integer>(Arrays.asList(this.data));
	int w = 0;
	while(w < number.size()) {
		if(number.get(w) % 2 != 0) {	//홀수면 배열에서 삭제
			number.remove(w);	//remove시 배열의 index node 번호가 변경됨
			w = 0;	//0사용은 배열에 값이 삭제 되면 노드변화로 처음부터 다시 검토 하도록 함
		}
		else {			
			w++;	//홀수가 아니면 +1 증가시켜서 배열 검토
		}
	}
	System.out.println(number);
	
}
@Override
	public void odd() {
		
}

	public static void main(String[] args) {
		new exam8().even();
		new exam8().odd();
		
	}

}
//추상 클래스
abstract class ex8_box{
	Integer data[] = {3,5,2,1,6,7,8,9,10,4};
	abstract public void even();
	abstract public void odd();
	
}