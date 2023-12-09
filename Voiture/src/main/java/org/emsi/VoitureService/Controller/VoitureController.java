package org.emsi.VoitureService.Controller;

import org.emsi.VoitureService.Model.Voiture;
import org.emsi.VoitureService.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository ;
    @GetMapping("/voitures")
    public List chercherVoitures(){
        return voitureRepository.findAll();
    }
    @GetMapping("/voitures/{id}")
    public Voiture chercherUnVoiture (@PathVariable Long id) throws Exception {

        return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistnt"));
    }



    @GetMapping("/voitures/client/{id}")
    public List<Voiture> chercherlesVoitureduClient (@PathVariable Long id){
        List<Voiture> voitures = new ArrayList<Voiture>();
        for(Voiture v: voitureRepository.findAll() )
        {
            if(v.getClient().getId()==id)
            {
                voitures.add(v);
            }
        }
        return  voitures;

    }


}
