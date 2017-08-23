package oldteb.leetcode2017.amazonOA;

import java.util.List;
import java.util.ArrayList;

public class BaseballScoring {
	
	public int getScore(String records){
		if(records == null || records.length() == 0)  return 0;
		
		int total = 0;
		int start = 0;
		List<Integer> buf = new ArrayList<Integer>();
		while(start < records.length()){
			char nextChar = records.charAt(start);
			int num = 0;
			switch(nextChar){
				case 'X':
					num = buf.size() == 0 ? 0 : buf.get(buf.size()-1)*2;
					start++;
					break;
				case '+':
					num = buf.size() == 0 ? 0 : buf.get(buf.size()-1);
					num += buf.size() < 2 ? 0 : buf.get(buf.size()-2);
					start++;
					break;
				case 'Z':
					num = buf.size() == 0 ? 0 : buf.get(buf.size()-1);
					if(buf.size() != 0)  buf.remove(buf.size()-1);
					total -= num;
					start++;
					continue;
				default:
					int end = getNumber(records,start);
					num = Integer.parseInt(records.substring(start, end));
					start = end;
			}
			buf.add(num);
			total += num;
		}
		
		return total;
	}
	
	public int getNumber(String records, int start){
		int cur = start+1;
		while(cur < records.length()){
			char next = records.charAt(cur);
			if(next < '0' || next > '9')  break;
			cur++;
		}
		return cur;
	}
	
}
