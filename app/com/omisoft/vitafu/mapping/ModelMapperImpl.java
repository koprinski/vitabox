package com.omisoft.vitafu.mapping;

import com.omisoft.vitafu.constants.MimeTypes;
import com.omisoft.vitafu.dto.MovieDTO;
import com.omisoft.vitafu.dto.MoviePlayerDTO;
import com.omisoft.vitafu.entity.Movie;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Default mapper implementation
 * Created by dido on 11/13/14.
 */
public class ModelMapperImpl implements ModelMapper {

    /**
     * Maps Movie to MoviePlayerDTO
     *
     * @param movie
     * @return
     */
    @Override
    public MoviePlayerDTO mapMovieToPlayerDTO(Movie movie, String captionLang, String subsLang) {
        MoviePlayerDTO dto = new MoviePlayerDTO();
        dto.setMovieId(movie.getId().toString());
        dto.setPoster(movie.getPoster());
        if (MimeTypes.MP4.getType().equals(movie.getMimeType())) {
            dto.setMp4Url(movie.getLocalURL());
        } else if (MimeTypes.OGGVIDEO.getType().equals(movie.getMimeType())) {
            dto.setOggUrl(movie.getLocalURL());
        } else { // Asume webm
            dto.setWebmUrl(movie.getLocalURL());
        }
//        if (!StringUtils.isEmpty(subsLang)) {
//            dto.setSubsLang(subsLang);
//            dto.setSubsUrl(movie.getSubtitles().get(subsLang).getSubtitleUrl());
//        }
//        if (!StringUtils.isEmpty(captionLang)) {
//            dto.setSubsLang(captionLang);
//            dto.setSubsUrl(movie.getCaptions().get(captionLang).getCaptionUrl());
//        }


        return dto;
    }


    /**
     * Maps Movie to MovieDTO
     * @param movieList
     * @return
     */
    @Override
    public List<MovieDTO> mapMovieDTO(List<Movie> movieList) {
        List<MovieDTO> dtoList = new ArrayList<>();

        for (Movie movie : movieList) {
            MovieDTO dto = new MovieDTO();
            if(movie.getPoster() != null) {
                dto.setTitle(movie.getTitle());
                dto.setMovieId(movie.getId().toString());
                dto.setVotes(movie.getVotes());
                dto.setSynopsis(movie.getSynopsis());
                dto.setPoster(movie.getPoster());
                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    /**
     * Maps Movie to MovieDTO
     * @param movie
     * @return
     */
    @Override
    public MovieDTO mapMovieById(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setMovieId(movie.getId().toString());
        dto.setPoster(movie.getPoster());
        dto.setSynopsis(movie.getSynopsis());
        dto.setTitle(movie.getTitle());
        dto.setVotes(movie.getVotes());
        dto.setViewCount(movie.getViewCount());
        dto.setDate(movie.getRelDate());
        dto.setViewCount(movie.getViewCount());
        dto.setTrailerURL(movie.getTrailerURL());

        return dto;
    }
}
