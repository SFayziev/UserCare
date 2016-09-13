package com.sh.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Media types understood by the system.
 */
public enum MediaType
{
    // ONE_MEGABYTE = 1048576
    /**
     * The media type is unknown.
     */
    UNKNOWN( "UNKNOWN", ".unknown", "unknown", 0 ),

    /**
     * The media type is audio ogg.
     */
    OGG( "audio/ogg", ".ogg", "ogg", 1048576 * 2 ),

    /**
     * The media type is audio mp3.
     */
    MP3( "audio/mp3", ".mp3", "mp3", 1048576 * 2 ),

    /**
     * The media type is audio wav.
     */
    WAV( "audio/wav", ".wav", "wav", 1048576 * 11 ),

    /**
     * The media type is audio acc.
     */
    AAC( "audio/aac", ".aac", "aac", 1048576 ),

    /**
     * The media type is audio wma.
     */
    WMA( "audio/x-ms-wma", ".wma", "asf", 1048576 ),

    /**
     * The media type is image png.
     */
    PNG( "image/png", ".png", "png", 1048576 ),

    /**
     * The media type is image bmp.
     */
    BMP( "image/image/bmp", ".bmp", "bmp", 1048576 ),

    /**
     * The media type is image jpeg.
     */
    JPG( "image/jpeg", ".jpg", "JPEG", 1048576 ),

    /**
     * The media type is b4u.
     */
    B4U( "application-x/b4u", ".b4u", "unknown", 1048576 );

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

    /**
     * How large, in bytes, that a media file can be before it is allowed into the system.
     */
    private final int theMaximumFileSize;

    /**
     * Manages the mapping of format names to media types.
     */
    private static final Map<String,MediaType> formatToType = new HashMap<String, MediaType>( 12 );
    static
    {

        formatToType.put( OGG.getFormatName(), OGG );
        formatToType.put( "vorbis", OGG );
        formatToType.put( AAC.getFormatName(), AAC );
        formatToType.put( MP3.getFormatName(), MP3 );
        formatToType.put( WAV.getFormatName(), WAV );
        formatToType.put( WMA.getFormatName(), WMA );
        formatToType.put( "wmav2", WMA );
        formatToType.put( PNG.getFormatName(), PNG );
        formatToType.put( BMP.getFormatName(), BMP );
        formatToType.put( JPG.getFormatName(), JPG );
        formatToType.put( B4U.getFormatName(), B4U );
        formatToType.put( UNKNOWN.getFormatName(), UNKNOWN );
    }

    /**
     * Manages the mapping of mime-types to media types.
     */
    private static final Map<String,MediaType> mimeToType = new HashMap<String, MediaType>( 10 );
    static
    {
        mimeToType.put( OGG.getMimeType(), OGG );
        mimeToType.put( AAC.getMimeType(), AAC );
        mimeToType.put( MP3.getMimeType(), MP3 );
        mimeToType.put( WAV.getMimeType(), WAV );
        mimeToType.put( WMA.getMimeType(), WMA );
        mimeToType.put( PNG.getMimeType(), PNG );
        mimeToType.put( BMP.getMimeType(), BMP );
        mimeToType.put( JPG.getMimeType(), JPG );
        mimeToType.put( B4U.getMimeType(), B4U );
        mimeToType.put( UNKNOWN.getMimeType(), UNKNOWN );
    }

    /**
     * Manages the mapping of file extensions to media types.
     */
    private static final Map<String,MediaType> extensionToType = new HashMap<String, MediaType>( 10 );
    static
    {
        extensionToType.put( OGG.getFileExtension(), OGG );
        extensionToType.put( AAC.getFileExtension(), AAC );
        extensionToType.put( MP3.getFileExtension(), MP3 );
        extensionToType.put( WAV.getFileExtension(), WAV );
        extensionToType.put( WMA.getFileExtension(), WMA );
        extensionToType.put( PNG.getFileExtension(), PNG );
        extensionToType.put( BMP.getFileExtension(), BMP );
        extensionToType.put( JPG.getFileExtension(), JPG );
        extensionToType.put( B4U.getFileExtension(), B4U );
        extensionToType.put( UNKNOWN.getFileExtension(), UNKNOWN );
    }

    private MediaType( final String aMimeType, final String aFileExtension, final String aFormatName, final int aMaximumFileSize )
    {
        theFileExtension = aFileExtension;
        theMimeType = aMimeType;
        theFormatName = aFormatName;
        theMaximumFileSize = aMaximumFileSize;
    }

    public String getMimeType()
    {
        return theMimeType;
    }

    public String getFileExtension()
    {
        return theFileExtension;
    }

    public String getFormatName()
    {
        return theFormatName;
    }

    public int getMaximumFileSize()
    {
        return theMaximumFileSize;
    }

    public static MediaType fromFormatName( final String formatName )
    {
        final MediaType type;
        if ( formatToType.containsKey( formatName ) )
        {
            type = formatToType.get( formatName );
        }
        else if ( formatName.startsWith( "pcm_" ) )
        {
            type = WAV;
        }
        else
        {
            type = UNKNOWN;
        }
        return type;
    }

    public static MediaType fromMimeType( final String mimeType )
    {
        final MediaType type;
        if ( mimeToType.containsKey( mimeType ) )
        {
            type = mimeToType.get( mimeType );
        }
        else
        {
            type = UNKNOWN;
        }
        return type;
    }

    public static MediaType fromFileExtension( final String extension )
    {
        final MediaType type;
        if ( extensionToType.containsKey( extension ) )
        {
            type = extensionToType.get( extension );
        }
        else
        {
            type = UNKNOWN;
        }
        return type;
    }
}
