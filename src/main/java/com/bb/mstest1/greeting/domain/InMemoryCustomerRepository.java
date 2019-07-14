package com.bb.mstest1.greeting.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * in memory repository.
 * TODO:
 * <ul>
 *      <li>current implementation is not thread safe</li>
 * </ul>
 */
@Repository
public class InMemoryCustomerRepository implements CrudRepository<Customer, Integer> {

    private List<Customer> customers = new ArrayList<>();
    private AtomicInteger nextId = new AtomicInteger(0);


    public InMemoryCustomerRepository() {
        save(new Customer("Mr", "John Doe"));
        save(new Customer("Ms", "Jane Doe"));
        save(new Customer("Miss", "Janie Doe"));
    }

    @Override
    public long count() {
        return customers.size();
    }

    @Override
    public boolean existsById(Integer id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    public Customer save(Customer s) {
        Customer customerWithId = new Customer(nextId.getAndIncrement(), s.getTitle(), s.getName());
        customers.add(customerWithId);
        return customerWithId;
    }

    @Override
    public Iterable<Customer> findAll() {
        return Collections.unmodifiableList(customers);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customers.stream().filter(c-> ObjectUtils.nullSafeEquals(c.getId(), id)).findAny();
    }

    @Override
    public void deleteById(Integer id) {
        customers.removeIf(c -> ObjectUtils.nullSafeEquals(c.getId(), id));
    }

    @Override
    public void delete(Customer customer) {
        customers.removeIf(c->ObjectUtils.nullSafeEquals(c.getId(), customer.getId()));
    }

    @Override
    public void deleteAll() {
        customers.clear();
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }
}
