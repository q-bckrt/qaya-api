package qbckrt.qayaapi.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import qbckrt.qayaapi.enums.TransactionType;

@Converter
public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {

    @Override
    public String convertToDatabaseColumn(TransactionType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.name();
    }

    @Override
    public TransactionType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return TransactionType.valueOf(dbData);
    }
}
