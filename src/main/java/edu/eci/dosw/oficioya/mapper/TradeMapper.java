package edu.eci.dosw.oficioya.mapper;

import edu.eci.dosw.oficioya.entity.Job;
import edu.eci.dosw.oficioya.model.TradeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TradeMapper {

    @Mapping(source = "nombre", target = "name")
    TradeModel toModel(Job entity);

    @Mapping(source = "name", target = "nombre")
    @Mapping(target = "activo", ignore = true)
    Job toEntity(TradeModel model);
}
