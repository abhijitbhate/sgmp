package com.ab.config;

import java.util.List;

public abstract class AbstractConfig {
    public abstract int getInt(String property);
    public abstract long getLong(String property);
    public abstract String getString(String property);
    public abstract List<String> getStringArray(String property);
}
