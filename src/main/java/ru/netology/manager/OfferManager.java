package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfferManager {
    private OfferRepository repository;

    public void add(Offer offer) {
        repository.save(offer);
    }

    public Offer[] findAll(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            int length = result.length;
            Offer[] tmp = new Offer[length + 1];
            if (offer.getFromAirport().equals(from) && offer.getToAirport().equals(to)) {
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
