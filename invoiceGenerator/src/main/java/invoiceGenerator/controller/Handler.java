package invoiceGenerator.controller;

import invoiceGenerator.util.HibernateUtil;
import invoiceGenerator.util.InvoiceGeneratorException;
import org.hibernate.Session;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import org.hibernate.CacheMode;

/**
 * @author tnebes
 * 4 March 2021
 */
public abstract class Handler<E> {

    protected E entity;
    protected Session session;
    protected Validator validator;

    protected abstract List<E> getData() throws InvoiceGeneratorException;
    protected abstract void createValidation() throws InvoiceGeneratorException;
    protected abstract void updateValidation() throws InvoiceGeneratorException;
    protected abstract void deleteValidation() throws InvoiceGeneratorException;

    public Handler() {
        this.session = HibernateUtil.getSessionFactory().openSession(); // should not use getCurrentSession()...
        this.session.setCacheMode(CacheMode.IGNORE);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }

    public Handler(E entity) {
        this();
        this.entity = entity;
    }

    public E create() throws InvoiceGeneratorException {
        validate();
        createValidation();
        save();
        return this.entity;
    }

    public E update() throws InvoiceGeneratorException {
        validate();
        updateValidation();
        session.beginTransaction();
        // nothing other than merge works
        session.merge(entity);
        session.getTransaction().commit();
        return this.entity;
    }

    private void save() {
        session.beginTransaction();
        session.save(this.entity);
        session.getTransaction().commit();
    }

    
    private void validate() throws InvoiceGeneratorException {
        Set<ConstraintViolation<E>> constraintViolations = validator.validate(this.entity);
        if(constraintViolations.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<E> violation : constraintViolations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new InvoiceGeneratorException(sb.toString());
        }
    }

    public boolean delete() throws InvoiceGeneratorException {
        deleteValidation();
        session.beginTransaction();
        session.delete(this.entity);
        session.getTransaction().commit();
        return true;
    }

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }
}
