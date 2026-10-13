package edu.eci.dosw.oficioya.mapper;

import edu.eci.dosw.oficioya.entity.Usuario;
import edu.eci.dosw.oficioya.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { TrabajadorMapper.class, ContratanteMapper.class })
public interface UsuarioMapper {

    @Mapping(source = "fullName", target = "name")
    @Mapping(source = "trabajador", target = "work")
    @Mapping(source = "contratante", target = "contractor")
    UserModel toModel(Usuario entity);

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "work", target = "trabajador")
    @Mapping(source = "contractor", target = "contratante")
    Usuario toEntity(UserModel model);
}
