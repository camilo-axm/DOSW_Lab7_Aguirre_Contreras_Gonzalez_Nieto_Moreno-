package edu.eci.dosw.oficioya.mapper;

import edu.eci.dosw.oficioya.entity.Trabajador;
import edu.eci.dosw.oficioya.entity.Trabajador_tiene_job;
import edu.eci.dosw.oficioya.model.TradeModel;
import edu.eci.dosw.oficioya.model.WorkModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TrabajadorMapper {

    @Autowired
    protected TradeMapper tradeMapper;

    @Mapping(source = "priceRate", target = "approxRate")
    @Mapping(source = "statusAvailable", target = "availableNow")
    @Mapping(source = "totalTrabajos", target = "completeJobs")
    @Mapping(source = "promedioReputacion", target = "averageRating")
    @Mapping(target = "mainTrade", ignore = true)
    @Mapping(target = "secondaryTrades", ignore = true)
    @Mapping(target = "zones", ignore = true)
    @Mapping(target = "availabilitySlots", ignore = true)
    @Mapping(target = "photos", ignore = true)
    public abstract WorkModel toModel(Trabajador entity);

    @Mapping(source = "approxRate", target = "priceRate")
    @Mapping(source = "availableNow", target = "statusAvailable", defaultValue = "false")
    @Mapping(source = "completeJobs", target = "totalTrabajos")
    @Mapping(source = "averageRating", target = "promedioReputacion", defaultValue = "0.0")
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "jobs", ignore = true)
    public abstract Trabajador toEntity(WorkModel model);

    @AfterMapping
    protected void fillTrades(Trabajador entity, @MappingTarget WorkModel model) {
        List<TradeModel> secondary = new ArrayList<>();
        if (entity.getJobs() != null) {
            for (Trabajador_tiene_job tj : entity.getJobs()) {
                TradeModel trade = tradeMapper.toModel(tj.getJob());
                if (Boolean.TRUE.equals(tj.getEsPrincipal())) {
                    model.setMainTrade(trade);
                } else {
                    secondary.add(trade);
                }
            }
        }
        model.setSecondaryTrades(secondary);
    }

    @AfterMapping
    protected void fillJobs(WorkModel model, @MappingTarget Trabajador entity) {
        if (model.getMainTrade() != null) {
            entity.agregarJob(tradeMapper.toEntity(model.getMainTrade()), true);
        }
        if (model.getSecondaryTrades() != null) {
            for (TradeModel trade : model.getSecondaryTrades()) {
                entity.agregarJob(tradeMapper.toEntity(trade), false);
            }
        }
    }
}
