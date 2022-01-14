package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository recoveryRoom;
    
	
	public List<RecoveryRoom> getAll(){
        return recoveryRoom.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoom.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return recoveryRoom.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return null;       
    }
    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository recoveryRoom) {
        super();
        this.recoveryRoom = recoveryRoom;
    }
    
}
