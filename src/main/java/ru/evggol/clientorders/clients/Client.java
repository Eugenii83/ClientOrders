package ru.evggol.clientorders.clients;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.evggol.clientorders.coupons.Coupon;
import ru.evggol.clientorders.orders.Order;
import ru.evggol.clientorders.profiles.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @OneToOne(mappedBy = "client", cascade = CascadeType.REMOVE)
    private Profile profile;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_coupons",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name = "coupon_id", referencedColumnName = "id")
    )
    private List<Coupon> coupons = new ArrayList<>();


}
