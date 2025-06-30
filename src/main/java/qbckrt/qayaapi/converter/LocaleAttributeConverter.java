package qbckrt.qayaapi.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Locale;

@Converter(autoApply = true)
public class LocaleAttributeConverter implements AttributeConverter<Locale, String> {

    @Override
    public String convertToDatabaseColumn(Locale locale) {
        return (locale == null) ? null : locale.toLanguageTag();
    }

    @Override
    public Locale convertToEntityAttribute(String dbData) {
        return (dbData == null || dbData.isEmpty()) ? null : Locale.forLanguageTag(dbData);
    }
}