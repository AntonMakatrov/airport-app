package org.example.airportapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.airportapp.core.dto.FlightFilter;
import org.example.airportapp.core.dto.Pageable;
import org.example.airportapp.dao.api.IFlightDao;
import org.example.airportapp.dao.entity.FlightEntity;

import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {
    private final EntityManagerFactory emf;

    public FlightDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<FlightEntity> getAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FlightEntity> query = cb.createQuery(FlightEntity.class);
        Root<FlightEntity> root = query.from(FlightEntity.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<FlightEntity> getPage(Pageable pageable) {
        return getPage(null, pageable);
    }

    @Override
    public List<FlightEntity> getPage(FlightFilter filter, Pageable pageable) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FlightEntity> query = cb.createQuery(FlightEntity.class);
        Root<FlightEntity> root = query.from(FlightEntity.class);

        if (filter != null) {
            Predicate predicate = createPredicate(filter, cb, root);
            query.where(predicate);
        }

        query.select(root);

        TypedQuery<FlightEntity> typedQuery = em.createQuery(query);

        if (pageable != null) {
            typedQuery.setFirstResult((pageable.getPage() - 1) * pageable.getSize());
            typedQuery.setMaxResults(pageable.getSize());
        }

        return typedQuery.getResultList();
    }

    public int count(){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<FlightEntity> root = query.from(FlightEntity.class);
        query.select(cb.count(root));
        return Math.toIntExact(em.createQuery(query).getSingleResult());
    }

    private Predicate createPredicate(FlightFilter filter, CriteriaBuilder cb, Root<FlightEntity> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter != null) {
            if (filter.getArrivalAirport() != null) {
                predicates.add(cb.equal(root.get("arrivalAirport"), filter.getArrivalAirport()));
            }
            if (filter.getDepartureAirport() != null) {
                predicates.add(cb.equal(root.get("departureAirport"), filter.getDepartureAirport()));
            }
            if (filter.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), filter.getStatus()));
            }
            if (filter.getScheduledDeparture() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("scheduledDeparture"), filter.getScheduledDeparture()));
                predicates.add(cb.lessThan(root.get("scheduledDeparture"), filter.getScheduledDeparture().plusDays(1)));
            }
            if (filter.getScheduledArrival() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("scheduledArrival"), filter.getScheduledArrival()));
                predicates.add(cb.lessThan(root.get("scheduledArrival"), filter.getScheduledArrival().plusDays(1)));
            }
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
