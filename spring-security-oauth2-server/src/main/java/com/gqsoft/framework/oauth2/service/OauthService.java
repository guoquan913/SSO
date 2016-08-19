package com.gqsoft.framework.oauth2.service;

import java.util.List;

import com.gqsoft.framework.oauth2.domain.OauthClientDetails;
import com.gqsoft.framework.oauth2.domain.dto.OauthClientDetailsDto;


/**
 * @author Shengzhao Li
 */

public interface OauthService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}