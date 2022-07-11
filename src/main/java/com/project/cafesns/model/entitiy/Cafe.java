package com.project.cafesns.model.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.cafesns.model.dto.cafe.ModifyCafeRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cafename;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String addressdetail;

    @Column(nullable = false)
    private String zonenum;

    @Column
    private String intro;

    @Column
    private String notice;

    @Column
    private Boolean delivery;

    @Column
    private String opentime;

    @Column
    private String closetime;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "ownerid")
    @JsonBackReference(value = "user-cafe-FK")
    private User user;

    @OneToMany(mappedBy = "cafe")
    @JsonManagedReference(value = "menu-cafe-FK")
    List<Menu> menuList;

    @OneToMany(mappedBy = "cafe")
    @JsonManagedReference(value = "cafe-post-FK")
    List<Post> postList;

    @Builder
    public Cafe(ModifyCafeRequestDto modifyCafeRequestDto) {
        this.address = modifyCafeRequestDto.getAddress();
        this.addressdetail = modifyCafeRequestDto.getAddressdetail();
        this.zonenum = modifyCafeRequestDto.getZonenum();
        this.intro = modifyCafeRequestDto.getIntro();
        this.notice = modifyCafeRequestDto.getNotice();
        this.opentime = modifyCafeRequestDto.getOpentime();
        this.closetime = modifyCafeRequestDto.getClosetime();
        this.latitude = modifyCafeRequestDto.getLatitude();
        this.longitude = modifyCafeRequestDto.getLongitude();
    }
}
