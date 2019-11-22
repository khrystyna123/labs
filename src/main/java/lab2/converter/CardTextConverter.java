package lab2.converter;

import lab2.exception.ConvertException;
import lab2.model.Card;
import lab2.converter.Converter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CardTextConverter implements Converter<Card> {

    private final String FIELDS_SEPARATOR = "-";
    private final Integer FIELDS_COUNT = 5;

    private Object[] getCardFields(Card card) {
        return new Object[]{
                card.getCardNumber(), card.getPin(), card.getType(), card.getCurrency(), card.getBalance()
        };
    }

    @Override
    public String serializeToString(Card card) throws ConvertException {
        try {
            Object[] cardFields = getCardFields(card);

            List<String> stringFields = Arrays.stream(cardFields)
                    .map(Object::toString)
                    .map(o -> o.replace(FIELDS_SEPARATOR, "\\" + FIELDS_SEPARATOR))
                    .collect(Collectors.toList());

            return String.join(FIELDS_SEPARATOR, stringFields);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    @Override
    public Card deserializeString(String serializedString) throws ConvertException {
        try {
            String[] stringFields = serializedString.split("(?<!\\\\)" + FIELDS_SEPARATOR);

            if (stringFields.length != FIELDS_COUNT) {
                throw new Exception("Invalid format of string!");
            }

            Iterator<String> fieldsIterator = Arrays.stream(stringFields).map(s -> s.replace("\\" + FIELDS_SEPARATOR, FIELDS_SEPARATOR)).iterator();

            return new Card.Builder()
                    .cardNumber(Long.parseLong(fieldsIterator.next()))
                    .pin(Integer.parseInt(fieldsIterator.next()))
                    .type(fieldsIterator.next())
                    .currency(fieldsIterator.next())
                    .balance(Double.parseDouble(fieldsIterator.next()))
                    .build();
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

}