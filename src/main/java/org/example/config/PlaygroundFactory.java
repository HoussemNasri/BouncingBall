package org.example.config;

public class PlaygroundFactory {
    private static PlaygroundConfig defaultInstance = null;

    public static PlaygroundConfig instance(PConfiguration configuration) {
        if (configuration == PConfiguration.DEFAUlT) {
            if (defaultInstance == null)
                defaultInstance = new DefaultPlaygroundConfig();
            return defaultInstance;
        }
        return null;
    }


}
