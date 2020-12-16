package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Offer;

@NoArgsConstructor
@AllArgsConstructor
public class OfferRepository {
    private Offer[] offers = new Offer[0];

    public void save(Offer offer) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        tmp[tmp.length - 1] = offer;
        offers = tmp;
    }

    public Offer[] getAll() {
        return offers;
    }
}
