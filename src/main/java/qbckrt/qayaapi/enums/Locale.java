package qbckrt.qayaapi.enums;

public enum Locale {
    EN_US("en-US"),
    FR_FR("fr-FR"),
    DE_DE("de-DE"),
    ES_ES("es-ES"),
    IT_IT("it-IT"),
    JA_JP("ja-JP"),
    KO_KR("ko-KR"),
    ID_ID("id-ID"),
    NL_NL("nl-NL");

    private final String code;

    Locale(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
