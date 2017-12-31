package it.imperato.test.security.components.impl;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlEntityEncoder {

    public static String htmlEncode(String text){

        return StringEscapeUtils.escapeHtml4(text);
    }

}
