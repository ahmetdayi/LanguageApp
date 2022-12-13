package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.Level;
import org.springframework.stereotype.Component;

@Component
public class LevelConverter {
    //string alcak level döncek 4 tane if olcak
    public Level convert(String level){
        if (level.equalsIgnoreCase("A1")){
            return Level.A1;
        }
        if (level.equalsIgnoreCase("A2")){
            return Level.A2;
        }
        if (level.equalsIgnoreCase("B1")){
            return Level.B1;
        }
        if (level.equalsIgnoreCase("B2")){
            return Level.B2;
        }else {
            return null;
        }
    }


}
