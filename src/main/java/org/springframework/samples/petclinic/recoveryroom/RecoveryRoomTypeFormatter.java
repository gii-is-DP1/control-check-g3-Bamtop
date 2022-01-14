package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{
	
	private final RecoveryRoomService recoveryRoom;

    @Autowired
    public RecoveryRoomTypeFormatter(RecoveryRoomService rr) {
        this.recoveryRoom = rr;
    }

    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType rr = recoveryRoom.getRecoveryRoomType(text);
        if(rr!=null) {
            return rr;
        }
        throw new ParseException("type not found: " + text, 0);
    }
    
    }
    

