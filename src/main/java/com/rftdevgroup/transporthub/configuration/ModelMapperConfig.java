package com.rftdevgroup.transporthub.configuration;

import com.rftdevgroup.transporthub.data.dto.user.UserRegisterDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration class for providing a configured {@link ModelMapper} bean.
 */
@Configuration
public class ModelMapperConfig {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        setTypeMapForUserRegisterDTO(modelMapper);
        return modelMapper;
    }

    private void setTypeMapForUserRegisterDTO(ModelMapper mapper) {
        TypeMap<UserRegisterDTO, User> typeMap = mapper.createTypeMap(UserRegisterDTO.class, User.class);
        typeMap.addMappings(mapping -> mapping.using(bcryptConverter()).map(UserRegisterDTO::getPassword, User::setPassword));
    }

    private Converter<String, String> bcryptConverter() {
        return mappingContext -> encoder.encode(mappingContext.getSource());
    }
}
