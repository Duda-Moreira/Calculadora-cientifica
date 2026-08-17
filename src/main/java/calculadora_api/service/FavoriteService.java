package calculadora_api.service;

import calculadora_api.model.FavoriteCalculation;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {
   private final List<FavoriteCalculation> favorites = new ArrayList<>();

   public void add(
    FavoriteCalculation favorite
   ) {
        favorites.add(favorite);
   }

   public List<FavoriteCalculation> getFavorites() {
    return favorites;
   }
}
