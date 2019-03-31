package com.sherlock.thoughtgame;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class Challenge4 implements ChallengeI{

    @Override
    public HashMap<String, Integer> solve(List<Input> inputList) {
        System.out.println("Input:"+inputList);
        Integer totalValue=inputList.stream().filter(i->
                ((i.getEndDate()==null ||
                        LocalDate.now().compareTo(i.getEndDate())<=0 )&&
                        LocalDate.now().compareTo(i.getStartDate())>=0)).mapToInt(Input::getPrice).sum();

        HashMap<String,Integer> output= new HashMap<String,Integer>() {{
            put("totalValue", totalValue);
        }};
        System.out.println("Output:" +output);
        return output;

    }
}
