package mgg.code.repository;

import jakarta.persistence.TypedQuery;
import mgg.code.HibernateController;
import mgg.code.model.Partido;


import java.util.List;


public class PartidoRepository implements CrudRepository<Partido, String> {
    private HibernateController hc = HibernateController.getInstance();

    public List<Partido> findAll() {
        hc.open();
        TypedQuery<Partido> query = hc.getManager().createNamedQuery("Partido.findAll", Partido.class);
        List<Partido> partidos = query.getResultList();
        hc.close();
        return partidos;
    }

    public Partido getById(String id) {
        hc.open();
        Partido partido = hc.getManager().find(Partido.class, id);
        hc.close();
        return partido;
    }

    public Partido save(Partido partido) {
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().persist(partido);
        hc.getTransaction().commit();
        hc.close();
        return partido;
    }

    public Partido update(Partido partido) {
        hc.open();
        hc.getTransaction().begin();
        hc.getManager().merge(partido);
        hc.getTransaction().commit();
        hc.close();
        return partido;
    }

    public Partido delete(String id) {
        hc.open();
        hc.getTransaction().begin();
        Partido partido = hc.getManager().find(Partido.class, id);
        hc.getManager().remove(partido);
        hc.getTransaction().commit();
        hc.close();
        return partido;
    }

}