package com.hyp.likou;

public class Regex_10 {
    public boolean isMatch(String s, String p) {
        char[] reg = p.toCharArray();
        char[] target = s.toCharArray();
        for(int i = 0,j = 0; j<target.length;){
            if(reg[i]=='.' || reg[i] == target[j]){
                i++;
                j++;
            }else{
                j++;
            }

            if(reg[i]=='.'){
                
            }
        }
        return false;
    }
}
