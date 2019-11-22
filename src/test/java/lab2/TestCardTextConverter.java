package lab2;

import lab2.exception.ConvertException;
import lab2.model.Card;
import lab2.converter.CardTextConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestCardTextConverter {

    private CardTextConverter CardTextConverter;
    private Card card;

    {
        CardTextConverter = new CardTextConverter();
    }

    @BeforeMethod
    public void beforeMethod() {
        card = new Card.Builder()
                .cardNumber(235235)
                .pin(2432)
                .type("Debit")
                .currency("USD")
                .balance(2454)
                .build();
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "235235-2432-Debit-USD-2454.0";
        String actual = CardTextConverter.serializeToString(card);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String serialized = "235235-2432-Debit-USD-2454.0";
        Card actual = CardTextConverter.deserializeString(serialized);
        Assert.assertEquals(actual, card);
    }


    @DataProvider
    public Object[][] negativeDeserializeStringDataProvider() {
        return new Object[][]{
                {"235235.0-2432-Debit-USD-2454.0"},
                {"235235-2432.0-Debit-USD-2454.0"},
                {"235235-2432-Debit-2454.0"}
        };
    }

    @Test(expectedExceptions = ConvertException.class, dataProvider = "negativeDeserializeStringDataProvider")
    public void negativeDeserializeStringTest(String serializedString) throws ConvertException {
        CardTextConverter.deserializeString(serializedString);
    }
}