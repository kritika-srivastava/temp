package com.stackroute.collections;
import java.util.*;
public class PlayerNameComparator implements Comparator<Object>{
	public int compare(Object ob1,Object ob2) {
		Player s1=(Player) ob1;
		Player s2=(Player) ob2;
		
		if(s1.getPlayerName().compareTo(s2.getPlayerName())==0) {
			return 0;
		}
		else if(s1.getPlayerName().compareTo(s2.getPlayerName())>0) {
			return 1;
		}
		
		return -1;
	}
}
