package edu.eci.dosw.oficioya.mapper;

import edu.eci.dosw.oficioya.entity.Contratante;
import edu.eci.dosw.oficioya.model.ContractorModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContratanteMapper {

    @Mapping(source = "promedioReputacion", target = "averageRating")
    ContractorModel toModel(Contratante entity);

    @Mapping(source = "averageRating", target = "promedioReputacion", defaultValue = "0.0")
    @Mapping(target = "usuario", ignore = true)
    Contratante toEntity(ContractorModel model);
}
