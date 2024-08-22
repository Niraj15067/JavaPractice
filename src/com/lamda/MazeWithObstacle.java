package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacle {

	public static void main(String[] args) {
		
		List<String> ans= findPath(1,1,"",3,3,2,2);
		System.out.println(ans);

	}

	private static List<String> findPath(int r, int c, String path, int destR, int destC,int bombR, int bombC) {
		
		List<String> ans = new ArrayList<>();
		
		if(r==bombR && c==bombC) {
			return new ArrayList<>();
		}
		
		if(r == destR && c == destC) {
			ans.add(path);
			return ans;
		}
		
		if(r<destR) {
			ans.addAll(findPath(r+1, c, path+"D", destR, destC,bombR,bombC));
		}
		
		if(c<destC) {
			ans.addAll(findPath(r, c+1, path+"R", destR, destC,bombR,bombC));
		}
		
		return ans;
	}

}
