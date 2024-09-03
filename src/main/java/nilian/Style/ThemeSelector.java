package nilian.Style;

public class ThemeSelector
{
    public String blackColor;
    public String whiteColor;

    public ThemeSelector(String themeString)
    {
        ThemeName themeName = ThemeName.valueOf(themeString);
        if(themeName == ThemeName.CLASSIC_GREEN_AND_WHITE)
        {
            whiteColor = "#FFFFFF";
            blackColor = "#769656";
        }
        else if(themeName == ThemeName.BROWN_AND_CREAM)
        {
            whiteColor = "#EEEED2";
            blackColor = "#8B4513";
        }
        else if(themeName == ThemeName.DARK_WOOD)
        {
            whiteColor = "#EEEED2";
            blackColor = "#654321";
        }
        else if(themeName == ThemeName.ICY_SEA)
        {
            whiteColor = "#DDEEFF";
            blackColor = "#77AADD";
        }
        else if(themeName == ThemeName.MARBLE)
        {
            whiteColor = "#FFFFFF";
            blackColor = "#B0C4DE";
        }
        else if(themeName == ThemeName.GLASS)
        {
            whiteColor = "#FFFFFF";
            blackColor = "#A9A9A9";
        }
        else if(themeName == ThemeName.BLUE_AND_GRAY)
        {
            whiteColor = "#E8E8E8";
            blackColor = "#708090";
        }
    }
}
