package com.example.gesticket.service;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.repository.BasedeConnaissanceRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasedeConnaissanceServiceImplement implements BasedeConnaissanceService {
    private BasedeConnaissanceRepository basedeConnaissanceRepository;

    @Override
    public BasedeConnaissances create(BasedeConnaissances basedeConnaissances) {
        return basedeConnaissanceRepository.save(basedeConnaissances);
    }

    @Override
    public BasedeConnaissances update(BasedeConnaissances basedeConnaissances, Long id) {
        Optional<BasedeConnaissances> Bd = basedeConnaissanceRepository.findById(id);
        if (Bd.isPresent()) {
            BasedeConnaissances Bd2 = Bd.get();
            Bd2.setId(basedeConnaissances.getId());
            Bd2.setContenu(basedeConnaissances.getContenu());
            return basedeConnaissanceRepository.save(Bd2);

        }else {
            return null;
        }
    }

    @Override
    public List<BasedeConnaissances> getAllBasedeConnaissances() {
        return basedeConnaissanceRepository.findAll();
    }

    @Override
    public String deleteBasedeConnaissances(Long id) {
        if (basedeConnaissanceRepository.existsById(id)) {
            basedeConnaissanceRepository.deleteById(id);
            return "Supprimé avec succès";
        } else {
            return "Non trouvé";
        }
    }
}
