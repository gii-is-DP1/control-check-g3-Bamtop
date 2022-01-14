package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {

	private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    private static final String WELCOME_VIEW = "welcome";
	
	
	 private final RecoveryRoomService rr;

	    public RecoveryRoomController(RecoveryRoomService rr) {
	        this.rr = rr;
	    }
	    
	    @ModelAttribute("recoveryRoomTypes")
	    public List<RecoveryRoomType> populateRoomTypes() {
	        return this.rr.getAllRecoveryRoomTypes();
	    }
	    
	    @GetMapping(value = "/recoveryroom/create")
	    public String initCreationForm(ModelMap model) {
	        RecoveryRoom recoveryRoom = new RecoveryRoom();
	        model.put("recoveryRoom", recoveryRoom);
	        return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	    }

	    @PostMapping(value = "/recoveryroom/create")
	    public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            model.put("recoveryRoom", recoveryRoom);
	            return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	        }
	        else {
	            this.rr.save(recoveryRoom);

	            return WELCOME_VIEW;
	        }
	    }
	    
}
