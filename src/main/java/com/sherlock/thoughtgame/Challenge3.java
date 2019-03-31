package com.sherlock.thoughtgame;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Challenge3 implements ChallengeI{

    @Override
    public HashMap<String, Integer> solve(List<Input> inputList) {

        System.out.println("Input:"+inputList);
        inputList=inputList.stream().filter(i->
                ((i.getEndDate()==null ||
                        LocalDate.now().compareTo(i.getEndDate())<=0 )&&
                                LocalDate.now().compareTo(i.getStartDate())>=0))
                .collect(Collectors.toList());

        HashMap<String,Integer> output= new HashMap<>();

        System.out.println("Avtive List:"+inputList);
        inputList.forEach( i ->{
            if(output.containsKey(i.getCategory()))
            {
                Integer count = output.get(i.getCategory());
                count++;
                output.put(i.getCategory(),count);
            }
            else
                output.put(i.getCategory(),1);
        });
        System.out.println("Output:" +output);
        return output;
    }
}
