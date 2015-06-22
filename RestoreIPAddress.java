import java.util.ArrayList;
import java.util.List;


public class RestoreIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddress test = new RestoreIPAddress();
		System.out.println(test.restoreIpAddresses("010010"));
	}
	
	List<String> result;
	
	public List<String> restoreIpAddresses(String s){
		result = new ArrayList<String>();
		if(s.length() > 12) return result;
		List<String> list = new ArrayList<String>();
		restoreIpAddresses(s, list);
		return result;
	}
	
	
	public void restoreIpAddresses(String s, List<String> list){
		//return directly for wrong cases
		if(s.length() > (4 - list.size()) * 3) return;
		
		if(list.size() == 4 && s.length() == 0){
			//put list to result;
			result.add(list.get(0) + '.' + list.get(1) + '.' + list.get(2) + '.' + list.get(3));
			return;
		}
		
		
		//handle cases that start with 0
		if(s.length() > 0 && s.charAt(0) == '0'){
			list.add(s.substring(0, 1));
			restoreIpAddresses(s.substring(1), list);
			list.remove(list.size() - 1);			
		}else{
			for(int i = 0; i < Math.min(3, s.length()); i++){
				if(Integer.parseInt(s.substring(0, i + 1)) <= 255){
					list.add(s.substring(0, i + 1));
					restoreIpAddresses(s.substring(i + 1), list);
					list.remove(list.size() - 1);
				}
			}
		}
		
	}
		
	

}
