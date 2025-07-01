package qbckrt.qayaapi.mapper;

import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.UserInputDTO;
import qbckrt.qayaapi.entity.Currency;
import qbckrt.qayaapi.entity.User;

import java.time.ZoneId;
import java.util.Locale;

@Component
public class UserMapper {

    public User toEntity (UserInputDTO userInputDTO) {
        Locale userLocale = userInputDTO.getLocale() != null
                ? Locale.forLanguageTag(userInputDTO.getLocale())
                : Locale.ENGLISH;
        ZoneId userTimeZone = userInputDTO.getTimezone() != null
                ? ZoneId.of(userInputDTO.getTimezone())
                : ZoneId.systemDefault();

        Currency currency = new Currency();

        User user = new User(
                userInputDTO.getDisplayName(),
                userInputDTO.getEmail(),
                userLocale,
                userTimeZone,
                userInputDTO.getCountryCode(),
                currency,
                userInputDTO.getProfilePictureUrl(),
                false
        );

        return user;
    }
}
