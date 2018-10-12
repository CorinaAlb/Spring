package com.javacodegeeks.ultimate.objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_PERSON")
@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private IdCard idCard;
    private List<Phone> phones;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToOne
    @JoinColumn(name = "ID_CARD_ID")
    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
