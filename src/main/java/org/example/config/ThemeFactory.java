package org.example.config;

public class ThemeFactory {
    private static Theme defaultInstance = null;

    public static Theme instance(PConfiguration configuration) {
        if (configuration == PConfiguration.DEFAUlT) {
            if (defaultInstance == null)
                defaultInstance = new DefaultTheme();
            return defaultInstance;
        }
        return null;
    }


}
