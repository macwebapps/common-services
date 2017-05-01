package com.macwebapps.authentication.common;

/**
 * Created by froilan.macugay@pictureworks.com.au on 27/4/17.
 */
public interface TokenExtractor {
    public String extract(String payload);
}
