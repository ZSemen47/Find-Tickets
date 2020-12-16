package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferManagerTest {
    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);

    Offer northwind = new Offer(1, 1000, "DME", "KZN", 95);
    Offer pobeda = new Offer(2, 1000, "DME", "KZN", 95);
    Offer s7 = new Offer(3, 1000, "CDZ", "KZN", 155);
    Offer s8 = new Offer(4, 1000, "CDZ", "SPB", 160);

    @BeforeEach
    void setUp() {
        manager.add(northwind);
        manager.add(pobeda);
        manager.add(s7);
        manager.add(s8);
    }

    @Test
    public void shouldFindCorrect() {
        Offer[] expected = new Offer[]{northwind, pobeda};
        Offer[] actual = manager.findAll("DME", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFind() {
        Offer[] expected = new Offer[]{};
        Offer[] actual = manager.findAll("NYC", "STA");
        assertArrayEquals(expected, actual);
    }
}