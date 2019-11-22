package lab2;

import lab2.model.Card;
import lab2.converter.JsonConverter;
import lab2.exception.ConvertException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestJsonConverter {
    private JsonConverter<Card> cardJsonConverter;
    private Card card;

    @BeforeTest
    public void BeforeTest() {
        cardJsonConverter = new JsonConverter<Card>(Card.class);
    }

    @BeforeMethod
    public void BeforeMethod() {
        card = new Card.Builder()
                .cardNumber(235235)
                .pin(2432)
                .type("Debit")
                .currency("USD")
                .balance(2454)
                .build();
    }

    @Test
    public void serializeToString() throws ConvertException {
        String jsonString = "{\"cardNumber\":235235,\"pin\":2432,\"type\":\"Debit\",\"currency\":\"USD\",\"balance\":2454.0}";
        String jsonExpected = cardJsonConverter.serializeToString(card);
        Assert.assertEquals(jsonString, jsonExpected);
    }

    @Test
    public void deserializeString() throws ConvertException {
        String jsonString = "{\"cardNumber\":235235,\"pin\":2432,\"type\":\"Debit\",\"currency\":\"USD\",\"balance\":2454.0}";
        Card cardExpected = cardJsonConverter.deserializeString(jsonString);
        Assert.assertEquals(card, cardExpected);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeString() throws ConvertException {
        String jsonString = "{\"cardNumber\":\"235235.0\",\"pin\":\"2432\",\"currency\":USD,\"balance\":\"2454\"}";
        cardJsonConverter.deserializeString(jsonString);
    }
}