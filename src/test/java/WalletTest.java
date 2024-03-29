import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Wallet;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet("John Doe");
    }

    @Test
    void testAddMoney() {
        wallet.addMoney(10000);
        Assertions.assertEquals(1, wallet.getMoneys().get(10000));a
    }

    @Test
    void testAddCoin() {
        wallet.addCoin(500);
        Assertions.assertEquals(1, wallet.getCoins().get(500));
    }

    @Test
    void testAddCard() {
        wallet.addCard("Credit Card");
        Assertions.assertTrue(wallet.getCards().contains("Credit Card"));
    }

    @Test
    void testTakeCard() {
        wallet.addCard("Credit Card");
        wallet.takeCard("Credit Card");
        Assertions.assertFalse(wallet.getCards().contains("Credit Card"));
    }

    @Test
    void testTakeCoins() {
        wallet.addCoin(500);
        wallet.takeCoins(500);
        Assertions.assertEquals(0, wallet.getCoins().get(500));
    }

    @Test
    void testTakeMoneys() {
        wallet.addMoney(10000);
        wallet.takeMoneys(10000);
        Assertions.assertEquals(0, wallet.getMoneys().get(10000));
    }

    @Test
    void testCalculateCoins() {
        wallet.addCoin(500);
        wallet.addCoin(500);
        Assertions.assertEquals(1000, wallet.calculateCoins());
    }

    @Test
    void testCalculateMoneys() {
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        Assertions.assertEquals(15000, wallet.calculateMoneys());
    }

    @Test
    void testGetMoneyAvailable() {
        wallet.addMoney(10000);
        wallet.addCoin(500);
        Assertions.assertEquals(10500, wallet.getMoneyAvailable());
    }
}