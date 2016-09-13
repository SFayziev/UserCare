package com.sh.utils;

/**
 * Created by shuhrat on 04.07.2015.
 */
public enum ImageType {
    // ONE_MEGABYTE = 1048576
    /**
     * The media type is unknown.
     */
    UNKNOWN("UNKNOWN", ".unknown", "unknown", 0, 0),

    /**
     * The media type is image png.
     */
    LOGO("image/jpeg", ".jpg", "JPEG", 0, 320),


    /**
     * The media type is image bmp.
     */
    BGIMAGE("image/png", ".png", "png", 0, 0),

    /**
     * The media type is image jpeg.
     */
    ICO("image/png", ".png", "png", 128, 128),

    /**
     * The media type is image jpeg.
     */
    AVATAR("image/jpeg", ".jpg", "JPEG", 128, 128),


    /**
     * The media type is link image.
     */
    LINKIMG("image/jpeg", ".jpg", "JPEG", 32, 32);


    /**
     * MIME-Type to use for the media type.
     */
    private final String theMimeType;

    /**
     * Standard file extension for the media type.
     */
    private final String theFileExtension;

    /**
     * What FFmpeg tools report as the format name.
     */
    private final String theFormatName;

    private final int theWidthSize;


    private final int theHeightSize;

    private ImageType( final String aMimeType, final String aFileExtension, final String aFormatName, final int aHeightSize , final int aWidthSize )
    {
        theFileExtension = aFileExtension;
        theMimeType = aMimeType;
        theFormatName = aFormatName;
        theHeightSize = aHeightSize;
        theWidthSize =aWidthSize;
    }

    public String getTheMimeType() {
        return theMimeType;
    }

    public String getTheFileExtension() {
        return theFileExtension;
    }

    public String getTheFormatName() {
        return theFormatName;
    }

    public int getTheWidthSize() {
        return theWidthSize;
    }

    public int getTheHeightSize() {
        return theHeightSize;
    }
}
