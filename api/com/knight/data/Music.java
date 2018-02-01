package com.knight.data;

/**
 *
 * @author artur
 */
public class Music 
{
    private String name, album, artist;
    
    /**
     * 
     */
    public Music() {}

    /**
     * 
     * @param name
     * @param album
     * @param artist 
     */
    public Music( String name, String album, String artist )
    {
        this.name = name;
        this.album = album;
        this.artist = artist;
    }
    
    /**
     * 
     * @return 
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * 
     * @param name 
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getAlbum() 
    {
        return album;
    }

    /**
     * 
     * @param album 
     */
    public void setAlbum(String album) 
    {
        this.album = album;
    }

    /**
     * 
     * @return 
     */
    public String getArtist() 
    {
        return artist;
    }
    
    /**
     * 
     * @param artist 
     */
    public void setArtist(String artist) 
    {
        this.artist = artist;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() 
    {
        return name + "\n" + album + "\n" + artist;
    }
}
