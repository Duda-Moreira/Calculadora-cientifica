package calculadora_api.service;

import calculadora_api.model.Calculation;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    private final List<Calculation> history = new ArrayList<>();

    public void add(Calculation calculation) {
        history.add(calculation);
    }

    public List<Calculation> getHistory() {
        return history;
    }
}
