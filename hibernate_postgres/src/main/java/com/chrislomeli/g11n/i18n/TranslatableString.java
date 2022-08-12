package com.chrislomeli.g11n.i18n;

import lombok.Data;

/*** HACK HACk HACK **/
@Data
public class TranslatableString {

    private String string;

    public TranslatableString(String error_string_create_conflict_under_team, String s, String s1, Object[] toArray) {
        string = s;
    }

    public String getPrimaryValue() {
        return string;
    }
}
