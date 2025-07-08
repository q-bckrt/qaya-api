package qbckrt.qayaapi.mapper;

import org.springframework.stereotype.Component;
import qbckrt.qayaapi.dto.UserInputDTO;
import qbckrt.qayaapi.dto.UserOutputDTO;
import qbckrt.qayaapi.entity.Currency;
import qbckrt.qayaapi.entity.User;
import qbckrt.qayaapi.repository.CurrencyRepository;

import java.time.ZoneId;
import java.util.Locale;

@Component
public class UserMapper {

    // FIELDS
    private final CurrencyRepository currencyRepository;

    // CONSTRUCTOR
    public UserMapper(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    // METHODS
    public User toEntity (UserInputDTO userInputDTO) {
        Locale userLocale = userInputDTO.getLocale() != null
                ? Locale.forLanguageTag(userInputDTO.getLocale())
                : Locale.ENGLISH;
        ZoneId userTimeZone = userInputDTO.getTimezone() != null
                ? ZoneId.of(userInputDTO.getTimezone())
                : ZoneId.systemDefault();

        Currency currency = currencyRepository.findById(userInputDTO.getCurrency())
                .orElseThrow(); // ???

        return new User(
                userInputDTO.getDisplayName(),
                userInputDTO.getEmail(),
                userLocale,
                userTimeZone,
                userInputDTO.getCountryCode(),
                currency,
                userInputDTO.getProfilePictureUrl(),
                false
        );
    }

    public UserOutputDTO toDTO(User user) {
        return new UserOutputDTO(
                user.getId().toString(),
                user.getDisplayName(),
                user.getEmail(),
                user.getLocale().toLanguageTag(),
                user.getTimeZone().getId(),
                user.getCountryCode(),
                user.getCurrency().getCode(),
                user.getProfilePictureUrl(),
                user.getCreatedAt().toString()
        );
    }

}
