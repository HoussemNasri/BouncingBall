package org.example.config;

public abstract class Themed {
    protected Theme theme;

    public Themed(Theme theme) {
        this.theme = theme;
    }

    public Themed() {
        this(ThemeFactory.instance(PConfiguration.DEFAUlT));
    }

}
