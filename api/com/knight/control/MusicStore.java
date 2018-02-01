package com.knight.control;

import com.knight.data.Music;
import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author artur
 */
@WebService
public class MusicStore 
{
    private List<Music> musics = Arrays.asList
    ( 
        new Music( "Invisible", "One More Light", "Linkin Park" ),
        new Music( "Lake on Fire", "Unknow", "Nirvana" )
    );
    
    public List<Music> getMusics()
    {
        return musics;
    }
    
    public static void main(String[] args) 
    {
        Endpoint.publish( "http://localhost:8080/musics", new MusicStore() );
        
        System.out.println( "Serviço Iniciado");
    }
}
