package lab2;

import lab2.exception.ConvertException;
import lab2.model.Card;
import lab2.converter.XmlConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestXmlConverter {

    private XmlConverter<Card> cardXmlConverter;
    private Card card;

    @BeforeTest
    public void beforeTest() {
        cardXmlConverter = new XmlConverter<>(Card.class);
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
        String expected = "<Card><cardNumber>235235</cardNumber><pin>2432</pin><type>Debit</type><currency>USD</currency><balance>2454.0</balance></Card>";
        String actual = cardXmlConverter.serializeToString(card);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String xmlString = "<Card><cardNumber>235235</cardNumber><pin>2432</pin><type>Debit</type><currency>USD</currency><balance>2454.0</balance></Card>";
        Card actual = cardXmlConverter.deserializeString(xmlString);
        Assert.assertEquals(actual, card);
    }

    @Test(expectedExceptions = ConvertException.class)
    public void negativeDeserializeStringTest() throws ConvertException {
        String xmlString = "<Card><cardNumber>235235.0</cardNumber><balance>2454.0</balance><currency>USD</currency></Card>";
        cardXmlConverter.deserializeString(xmlString);
    }

}