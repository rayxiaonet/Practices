package net.rayxiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rxiao on 7/6/16.
 */
public class TextJustification {
    public static void main(String[] args){
        String[] inputs = {"This", "is", "an", "example", "of", "text", "justification."};

        String[] justified = new TextJustification().justify(inputs,16);

        for (String s:justified) {
            System.out.println(s);
        }
    }

    public String[] justify(String[] inputs,int maxLength) {
        final String SPACER="                                           ";
        List<List<String>> ls = new ArrayList<List<String>>();
        int idx =0;
        List<String> lsCurrent = new ArrayList<String>();
        while (idx<inputs.length) {
            if (len(lsCurrent)+ inputs[idx].length()+1 <maxLength) {
                //can add more characters
                lsCurrent.add(inputs[idx++]);
            }else{
                //last line is done, move to next line
                ls.add(lsCurrent);
                lsCurrent = new ArrayList<String>();
            }
        }
        if (lsCurrent.size()>0) {
            ls.add(lsCurrent);
        }

        String[] xx =ls.stream().map((List<String> s)->{
            int totalSpaces = maxLength - len(s);
            int spacePerWord = s.size()>2?totalSpaces/(s.size()-1):totalSpaces;
            int remainder = s.size()>2?totalSpaces %(s.size()-1):0;
            return s.stream().reduce("",(a,b)->a + SPACER.substring(0,spacePerWord) + b);
        }).toArray(String[]::new);
        return xx;
    }

    private int len(List<String> list){
        return list.stream().map(s->s.length()).reduce(0,(a,b)->a+b);
    }
}
